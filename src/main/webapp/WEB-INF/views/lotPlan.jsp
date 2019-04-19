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

    <!-- Switchery css -->
    <link href='<spring:url value="/statics/assets/plugins/switchery/switchery.min.css"/>' rel="stylesheet"/>

    <!-- Font Awesome CSS -->
    <link href='<spring:url value="/statics/assets/font-awesome/css/font-awesome.min.css"/>' rel="stylesheet"
          type="text/css"/>

    <!-- Custom CSS -->
    <link href='<spring:url value="/statics/assets/css/style.css"/>' rel="stylesheet" type="text/css"/>

    <!-- BEGIN CSS for this page -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
    <link href='<spring:url value="/statics/assets/plugins/datetimepicker/css/daterangepicker.css"/>' rel="stylesheet">
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
                            <h1 class="main-title float-left">Create Lot</h1>
                            <ol class="breadcrumb float-right">
                                <li class="breadcrumb-item">Lot</li>
                                <li class="breadcrumb-item active">Create Lot</li>
                            </ol>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <!-- end row -->


            </div>
            <!-- end row -->
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="card mb-3">
                    <div class="card-header">
                        <span class="pull-right"><button class="btn btn-primary btn-sm" data-target="#addLotModal"
                                                         id="addLot"
                                                         data-toggle="modal"><i class="fa fa-user-plus"
                                                                                aria-hidden="true"></i> Add Lot</button></span>
                        <h3><i class="fa fa-file-text-o"></i> Create Lot</h3>
                    </div>
                    <div class="card-body">
                        <div class="dataTables_scroll">
                            <div class="dataTables_scrollBody"
                                 style="position: relative; overflow: auto; height: 350px; width: 100%;">
                                <table id="lotTable"
                                       class="table table-bordered table-hover display dataTable no-footer" role="grid"
                                       aria-describedby="lotTable" style="width: 100%;">
                                    <thead>
                                    <tr>
                                        <th>Lot No.</th>
                                        <th>Production Series</th>
                                        <th>Production Type</th>
                                        <th>Production Quantity</th>
                                        <th width="120">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody id="lotTableBody">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="form-group m-b-0">
                            <!-- Modal -->
                            <div class="modal fade custom-modal" id="addLotModal" tabindex="-1" role="dialog"
                                 aria-labelledby="addLotModal" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel2">Add the Lot</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="card-body">
                                                <form>
                                                    <div class="form-group">
                                                        <label for="LotNumber">Lot Number</label>
                                                        <input type="text" class="form-control" id="LotNumber"
                                                               aria-describedby="LotNumberHelp"
                                                               readonly>
                                                        <small id="LotNumberHelp" class="form-text text-muted">Lot
                                                            Number was Generated Randomly by System
                                                        </small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="prdSeries">Product Series</label>
                                                        <select id="prdSeries" class="form-control is-valid"
                                                                aria-describedby="prdSeriesHelp" required>
                                                            <option selected="selected" value="0">Choose Production
                                                                Series
                                                            </option>
                                                        </select>
                                                        <small id="prdSeriesHelp" class="form-text text-muted">Please
                                                            Select the Product Series Number
                                                        </small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="prdType">Product Type</label>
                                                        <select id="prdType" class="form-control is-valid"
                                                                aria-describedby="prdTypeHelp" required>
                                                            <option selected="selected" value="0">Choose Production
                                                                Type
                                                            </option>
                                                        </select>
                                                        <small id="prdTypeHelp" class="form-text text-muted">Please
                                                            Select the Product Type
                                                        </small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="prdQty">Product Quantity</label>
                                                        <input type="number" class="form-control  is-valid" id="prdQty"
                                                               aria-describedby="prdQtyHelp" placeholder="Enter number"
                                                               required="required" min="0">
                                                        <small id="prdQtyHelp" class="form-text text-muted">Please Input
                                                            the Product Quantity
                                                        </small>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <button id="saveBtn" type="submit" class="btn btn-primary"
                                                    data-dismiss="modal">Save changes
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card-->
                    <div class="card-body">
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                <input id="scheduleTime" type='text' class="form-control" name="daterange"
                                       value=""/>
                            </div>
                            <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                <a id="submitLot" role="button" class="btn btn-primary" href="#">Submit</a>
                                <a id="clearLot" role="button" class="btn btn-secondary" href="#">Clear</a>
                            </div>
                        </div>
                    </div>
                    <!-- end row -->
                </div>
                <!-- END container-fluid -->
            </div>
            <!-- END content -->
        </div>
        <!-- END content-page -->
        <jsp:include page="/WEB-INF/views/partial/footer.jsp" flush="true"/>


        <!-- Page JS-->
        <script src='<spring:url value="/statics/js/page/lotPlan.js"/>'></script>
        <!-- BEGIN Java Script for this page -->
        <script src='<spring:url value="/statics/assets/plugins/datetimepicker/js/moment.min.js"/>'></script>
        <script src='<spring:url value="/statics/assets/plugins/datetimepicker/js/daterangepicker.js"/>'></script>
        <!-- END Java Script for this page -->
        <script>
            lotPlanPage.init();
        </script>
        <!-- END Java Script for this page -->

</body>
</html>
