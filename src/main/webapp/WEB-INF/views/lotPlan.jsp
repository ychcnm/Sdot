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

        <nav class="navbar-custom">

            <ul class="list-inline float-right mb-0">

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-fw fa-question-circle"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5>
                                <small>Help and Support</small>
                            </h5>
                        </div>

                        <!-- item-->
                        <a target="_blank" href="https://www.pikeadmin.com" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Do you want custom development to integrate this theme?</b>
                                <span>Contact Us</span>
                            </p>
                        </a>

                        <!-- item-->
                        <a target="_blank" href="https://www.pikeadmin.com/pike-admin-pro"
                           class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Do you want PHP version of the theme that save dozens of hours of work?</b>
                                <span>Try Pike Admin PRO</span>
                            </p>
                        </a>

                        <!-- All-->
                        <a title="Clcik to visit Pike Admin Website" target="_blank" href="https://www.pikeadmin.com"
                           class="dropdown-item notify-item notify-all">
                            <i class="fa fa-link"></i> Visit Pike Admin Website
                        </a>

                    </div>
                </li>

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-fw fa-envelope-o"></i><span class="notif-bullet"></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5>
                                <small><span class="label label-danger pull-xs-right">12</span>Contact Messages</small>
                            </h5>
                        </div>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Jokn Doe</b>
                                <span>New message received</span>
                                <small class="text-muted">2 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Michael Jackson</b>
                                <span>New message received</span>
                                <small class="text-muted">15 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <p class="notify-details ml-0">
                                <b>Foxy Johnes</b>
                                <span>New message received</span>
                                <small class="text-muted">Yesterday, 13:30</small>
                            </p>
                        </a>

                        <!-- All-->
                        <a href="#" class="dropdown-item notify-item notify-all">
                            View All
                        </a>

                    </div>
                </li>

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        <i class="fa fa-fw fa-bell-o"></i><span class="notif-bullet"></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-lg">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5>
                                <small><span class="label label-danger pull-xs-right">5</span>Allerts</small>
                            </h5>
                        </div>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <div class="notify-icon bg-faded">
                                <img src='<spring:url value="/statics/assets/images/avatars/avatar2.png"/>' alt="img"
                                     class="rounded-circle img-fluid">
                            </div>
                            <p class="notify-details">
                                <b>John Doe</b>
                                <span>User registration</span>
                                <small class="text-muted">3 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <div class="notify-icon bg-faded">
                                <img src='<spring:url value="/statics/assets/images/avatars/avatar3.png"/>' alt="img"
                                     class="rounded-circle img-fluid">
                            </div>
                            <p class="notify-details">
                                <b>Michael Cox</b>
                                <span>Task 2 completed</span>
                                <small class="text-muted">12 minutes ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <div class="notify-icon bg-faded">
                                <img src='<spring:url value="/statics/assets/images/avatars/avatar4.png"/>' alt="img"
                                     class="rounded-circle img-fluid">
                            </div>
                            <p class="notify-details">
                                <b>Michelle Dolores</b>
                                <span>New job completed</span>
                                <small class="text-muted">35 minutes ago</small>
                            </p>
                        </a>

                        <!-- All-->
                        <a href="#" class="dropdown-item notify-item notify-all">
                            View All Allerts
                        </a>

                    </div>
                </li>

                <li class="list-inline-item dropdown notif">
                    <a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        <img src='<spring:url value="/statics/assets/images/avatars/admin.png"/>' alt="Profile image"
                             class="avatar-rounded">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5 class="text-overflow">
                                <small>Hello, admin</small>
                            </h5>
                        </div>

                        <!-- item-->
                        <a href="pro-profile.html" class="dropdown-item notify-item">
                            <i class="fa fa-user"></i> <span>Profile</span>
                        </a>

                        <!-- item-->
                        <a href="#" class="dropdown-item notify-item">
                            <i class="fa fa-power-off"></i> <span>Logout</span>
                        </a>

                        <!-- item-->
                        <a target="_blank" href="https://www.pikeadmin.com" class="dropdown-item notify-item">
                            <i class="fa fa-external-link"></i> <span>Pike Admin</span>
                        </a>
                    </div>
                </li>

            </ul>

            <ul class="list-inline menu-left mb-0">
                <li class="float-left">
                    <button class="button-menu-mobile open-left">
                        <i class="fa fa-fw fa-bars"></i>
                    </button>
                </li>
            </ul>

        </nav>

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
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="card mb-3">
                    <div class="card-header">
                        <h3><i class="fa fa-file-text-o"></i> Create Lot</h3>
                    </div>

                    <div class="card-body">

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Lot No.</th>
                                <th>Production Series</th>
                                <th>Production Type</th>
                                <th>Production Quantity</th>
                                <th width="120">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">Lot 1</th>
                                <td>
                                    <select id="prdSeries" class="form-control">
                                        <option selected="">Choose Production Series</option>
                                    </select>
                                </td>
                                <td>
                                    <select id="prdType" class="form-control">
                                        <option selected="">Choose Production Type</option>
                                    </select>
                                </td>
                                <td>
                                    <input type="number" class="form-control" id="exampleInputNumber1"
                                           aria-describedby="numberlHelp" placeholder="Enter number" required="">
                                </td>
                                <td>
                                    <a href="javascript:deleteRecord_13('13');" class="btn btn-danger btn-sm"
                                       data-placement="top" data-toggle="tooltip" data-title="Delete"><i
                                            class="fa fa-trash-o" aria-hidden="true"></i></a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="form-group m-b-0">
                            <a role="button" href="#custom-modal" class="btn btn-success" data-target="#customModal"
                               data-toggle="modal"><i class="fa fa-plus bigfonts"></i></a>
                            <small class="form-text text-muted">Add Lot</small>

                            <!-- Modal -->
                            <div class="modal fade custom-modal" id="customModal" tabindex="-1" role="dialog"
                                 aria-labelledby="customModal" aria-hidden="true">
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
                                                               aria-describedby="LotNumberHelp" placeholder="NSHSSN231"
                                                               readonly>
                                                        <small id="LotNumberHelp" class="form-text text-muted">Lot
                                                            Number was generated randomly by system
                                                        </small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Your lucky number
                                                            (required)</label>
                                                        <input type="number" class="form-control"
                                                               id="exampleInputNumber1" aria-describedby="numberlHelp"
                                                               placeholder="Enter number" required="">
                                                        <small id="numberlHelp" class="form-text text-muted">We'll never
                                                            share your email with anyone else.
                                                        </small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Password (required)</label>
                                                        <input type="password" class="form-control"
                                                               id="exampleInputPassword1" placeholder="Password"
                                                               required="">
                                                    </div>
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="checkbox" class="form-check-input">
                                                            Check me out
                                                        </label>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                </form>

                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <div id="reportrange" class="form-control"
                                 style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 100%">
                                <i class="fa fa-calendar"></i>&nbsp;
                                <span>April 1, 2019 - April 30, 2019</span> <b class="caret"></b>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <button class="btn btn-primary" type="submit">
                                Submit
                            </button>
                            <button type="reset" class="btn btn-secondary m-l-5">
                                Cancel
                            </button>
                        </div>
                    </div>
                </div><!-- end card-->
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/esm/popper.js"></script>
<!-- END Java Script for this page -->
<script>
    lotPlanPage.init()
</script>
<!-- END Java Script for this page -->

</body>
</html>
