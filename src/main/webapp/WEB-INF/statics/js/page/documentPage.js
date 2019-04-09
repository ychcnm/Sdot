/*Dependency:
 *          util.js
 *          request.js
 * */
var documentPage = {
    requestURL: '',
    baseUrl: util.getContextPath(),
    JsonData: '',
    init: function () {
        this.requestURL = this.baseUrl + "/documents/getDocumentList.do";
        this.bindEvent();
        request.myAjax(this.requestURL, this.JsonData, this.getDocumentSuccess,
            this.getDocumentFail);
    },
    bindEvent: function () {
        $('#document-table').on('click', 'i', function () {
            $('#passwordModal').modal('show');
            let path = $(this).attr('path');
            let type = $(this).attr('type');
            let docuentName = $(this).parent().siblings(":eq(1)").text();
            documentPage.JsonData = {
                "Name": docuentName,
                "path": path,
                "type": type
            };
            documentPage.downloadFile();
        });
    },
    getDocumentSuccess: function (data) {
        let template = $('#handlebars-documents').html();
        let templateScript = Handlebars.compile(template);
        let html = templateScript({
            'document': data
        });
        $('#document-table').append(html);
        console.log("Success");
    },
    getDocumentFail: function () {
        console.log("Fail");
    },
    downloadFile: function () {

        this.requestURL = this.baseUrl + "/documents/download.do";
        request.myAjax(this.requestURL, JSON.stringify(this.JsonData),
            this.downloadFileSuccess, this.downloadFileFile);

        console.log("Download");
    },
    downloadFileSuccess: function () {
        console.log("Download Success");
    },
    downloadFileFile: function () {
        console.log("Download Fail");
    },
};