var util = {
    getContextPath: function () {//获取网站根目录

        var localObj = window.location;

        var contextPath = localObj.pathname.split("/")[1];

        var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

        return basePath;
    },
};