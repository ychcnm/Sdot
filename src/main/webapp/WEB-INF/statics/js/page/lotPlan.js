/*Dependency:
 *          util.js
 *          request.js
 * */
let lotPlanPage;
lotPlanPage = {
    requestURL: '',
    baseUrl: util.getContextPath(),
    JsonData: '',
    productInfo: '',
    init: function () {
        this.requestURL = util.getContextPath() + "/lot/getProduct.do";
        request.myAjax(this.requestURL, this.JsonData, this.getProductSuccess,
            this.getProductFail);
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

            let time = $('input[name="daterange"]').val();
            let lots = [];
            $('#lotTable  > tbody > tr').each(function () {
                let lotId = $(this).find('th').text();
                let type = $(this).find('td').eq(1).text();
                let size = $(this).find('td').eq(2).text();
                let lot = {
                    "lotId": lotId,
                    "productType": type,
                    "lotSize": size
                };
                lots.push(lot);
            });
            this.JsonData = {
                "lotList": lots,
                "timeRange": time
            };
            this.requestURL = util.getContextPath() + "/lot/lotSubmit.do";
            request.myAjax(this.requestURL, JSON.stringify(this.JsonData), lotPlanPage.lotSubmitSuccess,
                lotPlanPage.lotSubmitFail);
        });
        $('#clearLot').on('click', function () {
            $('#lotTableBody').html('');
        });
        $('input[name="daterange"]').on('apply.daterangepicker', function (ev, picker) {
            $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
        });
        $('input[name="daterange"]').on('cancel.daterangepicker', function (ev, picker) {
            $(this).val('');
        });
        $('input[name="daterange"]').daterangepicker({
            autoUpdateInput: false,
            locale: {
                cancelLabel: 'Clear'
            }
        });
        $('#prdSeries').on('change', function () {
            let series = $('#prdSeries').val();
            lotPlanPage.getProductType(series);
        });
        $('#addLot').on('click', function () {
            $('#LotNumber').val(guid());
        });
        $('#saveBtn').on('click', function () {
            let lotNumber = $('#LotNumber').val();
            let productSeries = $('#prdSeries').val();
            $('#prdSeries').val('');
            $('#prdSeries').trigger("change");
            let productType = $('#prdType').val();
            $('#prdType').val('');
            let prodQty = $('#prdQty').val();
            $('#prdQty').val('');
            let row = "<tr><th scope='row'>" + lotNumber + "</th><td>" + productSeries + "</td><td>" + productType + "</td><td>" + prodQty + "</td>";
            row += "<td><a class=\"btn btn-danger btn-sm\" href=\"javascript:deleteRecord_13('13');\" data-toggle=\"tooltip\" data-title=\"Delete\" data-placement=\"top\" type=\"delBtn\"><i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i></a></td></tr>";
            $('#lotTable > tbody:last-child').append(row);
        });
        $('#lotTable').on('click', 'a[type="delBtn"]', function (e) {
            $(this).closest('tr').remove()
        });
    },
    getProductSuccess: function (data) {
        this.productInfo = data;
        let selector = $('#prdSeries');
        for (let k in data) {
            let o = new Option("Series " + k, k);
            selector.append(o);
        }
    },
    getProductFail: function () {
        console.log("Fail");
    },
    getProductType: function (series) {
        this.JsonData = {
            'series': series,
        };
        this.requestURL = util.getContextPath() + "/lot/getProductType.do";
        request.myAjax(this.requestURL, JSON.stringify(this.JsonData), this.getProductTypeSuccess,
            this.getProductTypeFail);
    },
    getProductTypeSuccess: function (data) {
        let selector = $('#prdType');
        selector.empty().append('<option selected="">Choose Production Type</option>');
        for (let k in data) {
            let o = new Option(data[k], data[k]);
            selector.append(o);
        }
    },
    getProductTypeFail: function () {
        console.log("fail");
    },
    lotSubmitSuccess: function (data) {
        lotPlanPage.displayResult(data);
    },
    lotSubmitFail: function (data) {
        alert("fail");
    },
    dateFromDay: function (year, day) {
        let date = new Date(year, 0); // initialize a date in `year-01-01`
        return new Date(date.getTime() + 60 * 60 * 24 * 1000 * day);
    },
    dateFormat: function (date) {
        let d = new Date(date);
        let date_format_str = d.getFullYear().toString() + "-" + ((d.getMonth() + 1).toString().length == 2 ? (d.getMonth() + 1).toString() : "0" + (d.getMonth() + 1).toString()) + "-" + (d.getDate().toString().length == 2 ? d.getDate().toString() : "0" + d.getDate().toString()) + " " + (d.getHours().toString().length == 2 ? d.getHours().toString() : "0" + d.getHours().toString()) + ":" + ((parseInt(d.getMinutes() / 5) * 5).toString().length == 2 ? (parseInt(d.getMinutes() / 5) * 5).toString() : "0" + (parseInt(d.getMinutes() / 5) * 5).toString());
        return date_format_str;
    },
    displayResult: function (data) {

        let body = "<div id=\"chartdiv\"></div>";
        $('#uploadBody').html(body);
        // Themes begin

        let HardScore = data['HardScore'];
        let SoftScore = data['SoftScore'];

        let head = " <h3><i class=\"fa fa-history\"></i>Result</h3>" + "HardScore: " + HardScore + " / " + "SoftScore: " + SoftScore;

        $('#createLotHead').html(head);


        am4core.useTheme(am4themes_animated);
        // Themes end

        var chart = am4core.create("chartdiv", am4charts.XYChart);
        chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

        chart.paddingRight = 30;
        chart.dateFormatter.inputDateFormat = "yyyy-MM-dd HH:mm";

        var colorSet = new am4core.ColorSet();
        colorSet.saturation = 0.4;

        let dataObject = data['resultData'];

        let chartData = [];
        let lots = [];

        let p = 0;
        let index = 0;
        for (let o in dataObject) {
            for (let j = 0; j < dataObject[o].length; j++) {
                let task = 'lotPackage' + dataObject[o][j]['id'];
                let oven = o;
                let requireTime = dataObject[o][j]['lotPackage']['requireTime'];
                let year = dataObject[o][j]['startingTimeGrain']['date']['year'];
                let dayOfYear = dataObject[o][j]['startingTimeGrain']['day']['dayOfYear'];
                let start = lotPlanPage.dateFromDay(year, dayOfYear);
                let end = new Date(new Date(start).getTime() + 60 * 60 * requireTime * 1000);
                start = lotPlanPage.dateFormat(start);
                end = lotPlanPage.dateFormat(end);
                let jObject = {
                    "category": "Oven " + oven,
                    "start": start,
                    "end": end,
                    "color": colorSet.getIndex(index).brighten(0.4 + j * 0.4),
                    "task": task
                };

                let lotlist = dataObject[o][j]['lotPackage']['lotList'];
                for (let k in lotlist) {
                    let lot = {
                        'lotPackage': task,
                        'Oven': oven,
                        'lotId': lotlist[k]['id'],
                        'type': lotlist[k]['productType'],
                        'size': lotlist[k]['lotSize'],
                        "start": start,
                        "end": end
                    };
                    lots.push(lot);
                }
                chartData.push(jObject);
            }
            index = index + 1;
        }

        chart.data = chartData;

        let startArray = data['StartDate'];
        startArray = lotPlanPage.dateFormat(startArray);
        let endArray = data['EndDate'];
        endArray = lotPlanPage.dateFormat(endArray);
        chart.dateFormatter.dateFormat = "yyyy-MM-dd HH:mm";
        chart.dateFormatter.inputDateFormat = "yyyy-MM-dd HH:mm";

        var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "category";
        categoryAxis.renderer.grid.template.location = 0;
        categoryAxis.renderer.inversed = true;

        var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
        dateAxis.renderer.minGridDistance = 70;
        dateAxis.baseInterval = {count: 2, timeUnit: "hour"};
        // dateAxis.min = new Date(startArray).getTime();
        //  dateAxis.max = new Date(endArray).getTime();
        //  dateAxis.strictMinMax = true;
        dateAxis.renderer.tooltipLocation = 0;

        var series1 = chart.series.push(new am4charts.ColumnSeries());
        series1.columns.template.width = am4core.percent(80);
        series1.columns.template.tooltipText = "{task}: [bold]{openDateX}[/] - [bold]{dateX}[/]";

        series1.dataFields.openDateX = "start";
        series1.dataFields.dateX = "end";
        series1.dataFields.categoryY = "category";
        series1.columns.template.propertyFields.fill = "color"; // get color from data
        series1.columns.template.propertyFields.stroke = "color";
        series1.columns.template.strokeOpacity = 0;

        chart.scrollbarX = new am4core.Scrollbar();

        let infoTable = "<div class=\"row\"><div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12\">\n" +
            "    <div class=\"card mb-3\">\n" +
            "                    <div class=\"card-header\">\n" +
            "                        <h3><i class=\"fa fa-file-text-o\"></i>Lot Information</h3>\n" +
            "                    </div>\n" +
            "                    <div class=\"card-body\">\n" +
            "                        <div class=\"dataTables_scroll\">\n" +
            "                            <div class=\"dataTables_scrollBody\" style=\"position: relative; overflow: auto; height: 350px; width: 100%;\">\n" +
            "                                <table id=\"lotTable\" class=\"table table-bordered table-hover display dataTable no-footer\" role=\"grid\" aria-describedby=\"lotTable\" style=\"width: 100%;\">\n" +
            "                                    <thead>\n" +
            "                                    <tr>\n" +
            "                                        <th>Lot Package</th>\n" +
            "                                        <th>Lot Number</th>\n" +
            "                                        <th>Product Type</th>\n" +
            "                                        <th>Assign Oven</th>\n" +
            "                                        <th>Lot Size</th>\n" +
            "                                        <th>Schedule Time</th>\n" +
            "                                    </tr>\n" +
            "                                    </thead>\n" +
            "                                    <tbody id=\"lotInfoTableBody\">\n" +
            "                                    </tbody>\n" +
            "                                </table>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    <!-- end card-->\n" +
            "                    <!-- end row -->\n" +
            "                </div>\n" +
            "                <!-- END container-fluid -->\n" +
            "            </div></div>";
        $('#lotrow').append(infoTable);

        let lotInfoBody = "";
        for (let l in lots) {
            let str = "<tr>" + "<td>" + lots[l]['lotPackage'] + "</td>" + "<td>" + "Lot" + lots[l]['lotId'] + "</td>" + "<td>" + lots[l]['type'] + "</td>" + "<td>" + lots[l]['Oven'] + "</td>" + "<td>" + lots[l]['size'] + "</td>" + "<td>" + lots[l]['start'] + " - " + lots[l]['end'] + "</td></tr>";
            lotInfoBody += str;
        }
        $('#lotInfoTableBody').html(lotInfoBody);
        $('#down').html('');
    }
};

function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }

    return s4() + s4() + '-' + s4();
}