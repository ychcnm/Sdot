/**
 * ajax接口模板
 *
 * @returns
 */
let request = {
    myAjax: function (url, data, success, error) {
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: success,
            error: error,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
        });
    },

};