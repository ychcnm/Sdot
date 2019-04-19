<%--
  Created by IntelliJ IDEA.
  User: changhe.a.ye
  Date: 4/3/2019
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Pike Admin - Free Bootstrap 4 Admin Template</title>
    <meta name="description" content="Free Bootstrap 4 Admin Theme | Pike Admin">
    <meta name="author" content="Pike Web Development - https://www.pikephp.com">

    <!-- Favicon -->
    <link rel="shortcut icon" href='<spring:url value="/statics/assets/images/favicon.ico"/>'>

    <!-- Switchery css -->
    <link href='<spring:url value="/statics/assets/plugins/switchery/switchery.min.css"/>'>

    <!-- Bootstrap CSS -->
    <link href='<spring:url value="/statics/assets/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css"/>

    <!-- Font Awesome CSS -->
    <link href='<spring:url value="/statics/assets/font-awesome/css/font-awesome.min.css"/>' rel="stylesheet"
          type="text/css"/>

    <!-- Custom CSS -->
    <link href='<spring:url value="/statics/assets/css/style.css"/>' rel="stylesheet" type="text/css"/>

    <!-- Modernizr -->
    <script src='<spring:url value="/statics/assets/js/modernizr.min.js"/>'></script>

    <!-- jQuery -->
    <script src='<spring:url value="/statics/assets/js/jquery.min.js"/>'></script>

    <!-- Moment -->
    <script src='<spring:url value="/statics/assets/js/moment.min.js"/>'></script>

    <!-- BEGIN CSS for this page -->
    <link href='<spring:url value="/statics/assets/plugins/jquery.filer/css/jquery.filer.css"/>' rel="stylesheet"/>
    <link href='<spring:url value="/statics/assets/plugins/jquery.filer/css/themes/jquery.filer-dragdropbox-theme.css"/>'
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
    <link href='<spring:url value="/statics/assets/plugins/datetimepicker/css/daterangepicker.css"/>' rel="stylesheet">
    rel="stylesheet"/>
    <!-- END CSS for this page -->

</head>

<body class="adminbody">

<div id="main">

    <!-- top bar navigation -->
    <div class="headerbar">
        <div class="headerbar">
            <!-- LOGO -->
            <div class="headerbar-left">
                <a href="index.html" class="logo"><img alt="Logo"
                                                       src='<spring:url value="/statics/assets/images/logo.png"/>'/>
                    <span>Hex</span></a>
            </div>
            <jsp:include page="/WEB-INF/views/partial/navBar.jsp" flush="true"/>
        </div>
    </div>
    <!-- End Navigation -->


    <!-- Left Sidebar -->
    <jsp:include page="/WEB-INF/views/partial/leftMenu.jsp" flush="true"/>
    <!-- End Sidebar -->


    <div class="content-page">

        <!-- Start content -->
        <div class="content">

            <div class="container-fluid">


                <div class="row">
                    <div class="col-xl-12">
                        <div class="breadcrumb-holder">
                            <h1 class="main-title float-left">Upload Lot File</h1>
                            <ol class="breadcrumb float-right">
                                <li class="breadcrumb-item">Lot</li>
                                <li class="breadcrumb-item active">Upload Lot File</li>
                            </ol>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <!-- end row -->


                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="card mb-3">
                            <div class="card-header">
                                <h3><i class="fa fa-file"></i>Upload Lot For Planner</h3>
                                Files upload with drag & drop
                            </div>

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                        <input type="file" name="files[]" id="uploadLot" multiple="multiple">
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                        <input id="scheduleTime" type='text' class="form-control" name="daterange"
                                               value=""/>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                        <a id="submitLot" role="button" class="btn btn-primary" href="#">Process</a>
                                    </div>
                                </div>
                            </div>
                        </div><!-- end card-->
                    </div>
                </div>


            </div>
            <!-- END container-fluid -->

        </div>
        <!-- END content -->

    </div>
    <!-- END content-page -->

    <jsp:include page="/WEB-INF/views/partial/footer.jsp" flush="true"/>

</div>
<!-- END main -->


<script src='<spring:url value="/statics/assets/js/jquery.scrollTo.min.js"/>'></script>
<script src='<spring:url value="/statics/assets/plugins/switchery/switchery.min.js"/>'></script>
<script src='<spring:url value="/statics/assets/plugins/datetimepicker/js/moment.min.js"/>'></script>
<script src='<spring:url value="/statics/assets/plugins/datetimepicker/js/daterangepicker.js"/>'></script>
<!-- Page JS-->
<script src='<spring:url value="/statics/js/page/uploadLot.js"/>'></script>

<!-- BEGIN Java Script for this page -->
<script src='<spring:url value="/statics/assets/plugins/jquery.filer/js/jquery.filer.min.js"/>'></script>
<script>
    uploadLotPage.init();
    $("#uploadLot").filer({
        limit: null,
        maxSize: null,
        extensions: null,
        changeInput: '<div class="jFiler-input-dragDrop"><div class="jFiler-input-inner"><div class="jFiler-input-icon"><i class="icon-jfi-cloud-up-o"></i></div><div class="jFiler-input-text"><h3>Drag & Drop files here</h3> <span style="display:inline-block; margin: 15px 0">or</span></div><a class="jFiler-input-choose-btn btn btn-custom">Browse Files</a></div></div>',
        showThumbs: true,
        theme: "dragdropbox",
        templates: {
            box: '<ul class="jFiler-items-list jFiler-items-grid"></ul>',
            item: '<li class="jFiler-item">\
                        <div class="jFiler-item-container">\
                            <div class="jFiler-item-inner">\
                                <div class="jFiler-item-thumb">\
                                    <div class="jFiler-item-status"></div>\
                                    <div class="jFiler-item-info">\
                                        <span class="jFiler-item-title"><b title="{{fi-name}}">{{fi-name | limitTo: 25}}</b></span>\
                                        <span class="jFiler-item-others">{{fi-size2}}</span>\
                                    </div>\
                                    {{fi-image}}\
                                </div>\
                                <div class="jFiler-item-assets jFiler-row">\
                                    <ul class="list-inline pull-left">\
                                        <li>{{fi-progressBar}}</li>\
                                    </ul>\
                                    <ul class="list-inline pull-right">\
                                        <li><a class="icon-jfi-trash jFiler-item-trash-action"></a></li>\
                                    </ul>\
                                </div>\
                            </div>\
                        </div>\
                    </li>',
            itemAppend: '<li class="jFiler-item">\
                            <div class="jFiler-item-container">\
                                <div class="jFiler-item-inner">\
                                    <div class="jFiler-item-thumb">\
                                        <div class="jFiler-item-status"></div>\
                                        <div class="jFiler-item-info">\
                                            <span class="jFiler-item-title"><b title="{{fi-name}}">{{fi-name | limitTo: 25}}</b></span>\
                                            <span class="jFiler-item-others">{{fi-size2}}</span>\
                                        </div>\
                                        {{fi-image}}\
                                    </div>\
                                    <div class="jFiler-item-assets jFiler-row">\
                                        <ul class="list-inline pull-left">\
                                            <li><span class="jFiler-item-others">{{fi-icon}}</span></li>\
                                        </ul>\
                                        <ul class="list-inline pull-right">\
                                            <li><a class="icon-jfi-trash jFiler-item-trash-action"></a></li>\
                                        </ul>\
                                    </div>\
                                </div>\
                            </div>\
                        </li>',
            progressBar: '<div class="bar"></div>',
            itemAppendToEnd: false,
            removeConfirmation: true,
            _selectors: {
                list: '.jFiler-items-list',
                item: '.jFiler-item',
                progressBar: '.bar',
                remove: '.jFiler-item-trash-action'
            }
        },
        dragDrop: {
            dragEnter: null,
            dragLeave: null,
            drop: null,
        },
        uploadFile: {
            url: util.getContextPath() + "/lot/upload",
            data: null,
            type: 'POST',
            enctype: 'multipart/form-data',
            beforeSend: function () {
            },
            success: function (data, el) {
                var parent = el.find(".jFiler-jProgressBar").parent();
                el.find(".jFiler-jProgressBar").fadeOut("slow", function () {
                    $("<div class=\"jFiler-item-others text-success\"><i class=\"fa fa-plus\"></i> Success</div>").hide().appendTo(parent).fadeIn("slow");
                });
            },
            error: function (el) {
                var parent = el.find(".jFiler-jProgressBar").parent();
                el.find(".jFiler-jProgressBar").fadeOut("slow", function () {
                    $("<div class=\"jFiler-item-others text-error\"><i class=\"fa fa-minus\"></i> Error</div>").hide().appendTo(parent).fadeIn("slow");
                });
            },
            statusCode: null,
            onProgress: null,
            onComplete: null
        },
        files: '',
        addMore: false,
        clipBoardPaste: true,
        excludeName: null,
        beforeRender: null,
        afterRender: null,
        beforeShow: null,
        beforeSelect: null,
        onSelect: null,
        afterShow: null,
        onRemove: function (itemEl, file, id, listEl, boxEl, newInputEl, inputEl) {
            var file = file.name;
            $.post(util.getContextPath() + "/lot/delete", {file: file});
        },
        onEmpty: null,
        options: null,
        captions: {
            button: "Choose Files",
            feedback: "Choose files To Upload",
            feedback2: "files were chosen",
            drop: "Drop file here to Upload",
            removeConfirmation: "Are you sure you want to remove this file?",
            errors: {
                filesLimit: "Only {{fi-limit}} files are allowed to be uploaded.",
                filesType: "Only Images are allowed to be uploaded.",
                filesSize: "{{fi-name}} is too large! Please upload file up to {{fi-maxSize}} MB.",
                filesSizeAll: "Files you've choosed are too large! Please upload files up to {{fi-maxSize}} MB."
            }
        }
    });
</script>
<!-- END Java Script for this page -->

</body>
</html>