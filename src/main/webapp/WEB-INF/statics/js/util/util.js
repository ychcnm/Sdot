let util = {
    getContextPath: function () {//获取网站根目录

        let localObj = window.location;

        let contextPath = localObj.pathname.split("/")[1];

        let basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

        return basePath;
    },
};