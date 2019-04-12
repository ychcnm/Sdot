/*Dependency:
 *          util.js
 *          request.js
 * */
var lotPlanPage = {
    requestURL: '',
    baseUrl: util.getContextPath(),
    JsonData: '',
    productInfo: '',
    init: function () {
        this.requestURL = this.baseUrl + "/lot/getProduct.do";
        this.bindEvent();
        request.myAjax(this.requestURL, this.JsonData, this.getProductSuccess,
            this.getProductFail);
    },
    bindEvent: function () {

    },
    getProductSuccess: function (data) {
        this.productInfo = data;
        let option = $('#prdSeries');
        for (var k in data) {
            var o = new Option("Series " + k, k);
            option.append(o)
        }
    },
    getProductFail: function () {
        console.log("Fail");
    },
};