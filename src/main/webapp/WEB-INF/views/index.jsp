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

    <title>Home Page</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href='<spring:url value="/statics/assets/images/favicon.ico"/>'>

    <!-- Bootstrap CSS -->
    <link href='<spring:url value="/statics/assets/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css"/>

    <!-- Font Awesome CSS -->
    <link href='<spring:url value="/statics/assets/font-awesome/css/font-awesome.min.css"/>' rel="stylesheet"
          type="text/css"/>

    <!-- Custom CSS -->
    <link href='<spring:url value="/statics/assets/css/style.css"/>' rel="stylesheet" type="text/css"/>

    <!-- BEGIN CSS for this page -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
    <!-- END CSS for this page -->

</head>

<body class="adminbody">

<div id="main">

    <!-- top bar navigation -->
    <div class="headerbar">
        <!-- LOGO -->
        <div class="headerbar-left">
            <a href="index.html" class="logo"><img alt="Logo"
                                                   src='<spring:url value="/statics/assets/images/logo.png"/>'/> <span>Hex</span></a>
        </div>
        <jsp:include page="/WEB-INF/views/partial/navBar.jsp" flush="true"/>
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
                            <h1 class="main-title float-left">Dashboard</h1>
                            <ol class="breadcrumb float-right">
                                <li class="breadcrumb-item">Home</li>
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ol>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <!-- end row -->


            </div>
            <!-- end row -->


            <!-- end row -->


        </div>
        <!-- END container-fluid -->

    </div>
    <!-- END content -->

</div>
<!-- END content-page -->

<jsp:include page="/WEB-INF/views/partial/footer.jsp" flush="true"/>

</div>
<!-- END main -->

<script>
</script>
<!-- END Java Script for this page -->

</body>
</html>
