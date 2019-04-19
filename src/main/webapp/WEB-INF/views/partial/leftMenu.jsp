<%--
  Created by IntelliJ IDEA.
  User: Mitch
  Date: 4/10/2019
  Time: 1:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<div class="left main-sidebar">

    <div class="sidebar-inner leftscroll">

        <div id="sidebar-menu">

            <ul>

                <li class="submenu">
                    <a class="active" href="${pageContext.request.contextPath}/home/index"><i
                            class="fa fa-fw fa-bars"></i><span> Dashboard </span>
                    </a>
                </li>

                <li class="submenu">
                    <a href="${pageContext.request.contextPath}/lot/choosePlan"><i
                            class="fa fa-clock-o bigfonts"></i><span> Lot Planner </span>
                    </a>
                </li>
            </ul>

            <div class="clearfix"></div>

        </div>

        <div class="clearfix"></div>

    </div>

</div>