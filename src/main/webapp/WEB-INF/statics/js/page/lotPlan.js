/*Dependency:
 *          util.js
 *          request.js
 * */
let lotPlanPage = {
    requestURL: '',
    baseUrl: util.getContextPath(),
    JsonData: '',
    productInfo: '',
    init: function () {
        this.requestURL = util.getContextPath() + "/lot/getProduct.do";
        request.myAjax(this.requestURL, this.JsonData, this.getProductSuccess,
            this.getProductFail);
        this.bindEvent();
    },
    bindEvent: function () {
        $('#prdSeries').on('change', function () {
            let series = $('#prdSeries').val();
            lotPlanPage.getProductType(series);
        });
        $('#addLot').on('click', function () {
            $('#LotNumber').val(guid());
        });
        $('#saveBtn').on('click', function () {

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