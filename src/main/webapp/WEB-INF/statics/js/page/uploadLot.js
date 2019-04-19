/*Dependency:
 *          util.js
 *          request.js
 * */
var uploadLotPage = {
    requestURL: this.baseUrl + "/lot/upload",
    baseUrl: util.getContextPath(),
    JsonData: '',
    init: function () {
        this.requestURL = "";
        this.bindEvent();
        this.timeInit();
    },
    timeInit: function () {
        var today = new Date();
        var date = today.getDate() + '/' + (today.getMonth() + 1) + '/' + today.getFullYear();
        $('input[name="daterange"]').daterangepicker({
            minDate: today
        })
    },
    bindEvent: function () {
        $('#submitLot').on('click', function () {
            let data = new FormData();
            let timeRange = $('input[name="daterange"]').val();
            data.append("timeRange", timeRange);
            jQuery.each(jQuery('#uploadLot')[0].files, function (i, file) {
                data.append('file- ' + i, file);
            });
            this.requestURL = util.getContextPath() + "/lot/uploadSubmit";
            $.ajax({
                url: this.requestURL,
                data: data,
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    alert(data);
                },
                error: function (err) {
                    alert(err);
                }
            });
        });
    }
};