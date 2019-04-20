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

            let load = " <button id=\"submitLot\" class=\"btn btn-primary\" type=\"button\" disabled>\n" +
                "                                                Processing\n" +
                "                                            </button>\n" +
                "                                            <div class=\"loader\" id=\"loader-6\">\n" +
                "                                                <span></span>\n" +
                "                                                <span></span>\n" +
                "                                                <span></span>\n" +
                "                                                <span></span>\n" +
                "                                            </div>";

            $('#processBar').html(load);
            $.ajax({
                url: this.requestURL,
                data: data,
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    alert("Process Successful");
                    let load = "   <button id=\"submitLot\" class=\"btn btn-primary\" type=\"button\">\n" +
                        "                                                Process\n" +
                        "                                            </button>";
                    $('#processBar').html(load);
                },
                error: function (err) {
                    alert("Process fail");
                    let load = "   <button id=\"submitLot\" class=\"btn btn-primary\" type=\"button\">\n" +
                        "                                                Process\n" +
                        "                                            </button>";
                    $('#processBar').html(load);
                }
            });
        });
    }
};