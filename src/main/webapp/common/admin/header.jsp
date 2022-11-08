<%--
  Created by IntelliJ IDEA.
  User: DungPC
  Date: 10/30/2022
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<nav class="navbar navbar-default navbar-static-top m-b-0">
    <div class="navbar-header">
        <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
            <i class="fa fa-bars"></i>
        </a>
        <div class="top-left-part">
            <a class="logo" href="<c:url value="/admin-home"/>">
                <b>
                    <img src="<c:url value="/template/plugins/images/pixeladmin-logo.png"/>" alt="home" />
                </b>
                <span class="hidden-xs">
                                <img src="<c:url value="/template/plugins/images/pixeladmin-text.png"/>" alt="home" />
                            </span>
            </a>
        </div>
        <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
            <li>
                <form role="search" class="app-search hidden-xs">
                    <input type="text" placeholder="Search..." class="form-control">
                    <a href="">
                        <i class="fa fa-search"></i>
                    </a>
                </form>
            </li>
        </ul>
        <ul class="nav navbar-top-links navbar-right pull-right">
            <li>
                <div class="dropdown">
                    <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#">
                        <img src="<c:url value="/template/plugins/images/users/varun.jpg"/>" alt="user-img" width="36" class="img-circle" />
                        <b class="hidden-xs">ADMIN ${isLogin.getFullname()}</b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/admin-profile"/>">Thông tin cá nhân</a></li>
                        <li><a href="#">Thống kê công việc</a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/logout"/>">Đăng xuất</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <!-- /.navbar-header -->
    <!-- /.navbar-top-links -->
    <!-- /.navbar-static-side -->
</nav>