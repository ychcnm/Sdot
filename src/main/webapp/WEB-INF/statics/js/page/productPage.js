/*Dependency:
 *          util.js
 *          request.js
 * */
var productPage = {
    requestURL: '',
    baseUrl: util.getContextPath(),
    JsonData: '',
    init: function () {
        this.requestURL = this.baseUrl + "/products/getProductList.do";
        this.bindEvent();
        request.myAjax(this.requestURL, this.JsonData, this.getProductSuccess,
            this.getProductFail);
    },
    bindEvent: function () {
        $('.product-list').on('click', 'span', function () {
            let id = $(this).attr('id');
            productPage.getProductDetail(id);
        });
        $('#confirmButton').on('click', function () {
            $('#productModal').modal('toggle');
            $('.modal-body').children().eq(1).remove();
        });
        $('.close').on('click', function () {
            $('.modal-body').children().eq(1).remove();
        });
    },
    getProductDetail: function (id) {
        this.requestURL = this.baseUrl + "/products/getProductDetail.do";
        this.JsonData = {
            'id': id
        };
        request.myAjax(this.requestURL, JSON.stringify(this.JsonData),
            this.getProductDetailSuccess, this.getProductDetailFail);
    },
    getProductSuccess: function (data) {
        let template = $('#handlebars-products').html();
        let templateScript = Handlebars.compile(template);
        let html = templateScript({
            'product': data
        });
        $('.product-list').append(html);
    },
    getProductFail: function () {
        console.log("Fail");
    },
    getProductDetailSuccess: function (data) {
        console.log("Success");
        let template = $('#handlebars-productsDetail').html();
        let templateScript = Handlebars.compile(template);
        let html = templateScript(data);
        $('.modal-body').empty();
        $('.modal-body').append(html);
        $('#productModal').modal('show');
    },
    getProductDetailFail: function () {
        console.log("Fail");
    }
};