<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
</head>

<body>

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse"
                    data-target=".navbar-collapse">
                    <i class="fa fa-bars"></i>
                </a>
                <div class="top-left-part">
                    <a class="logo" href="views/admin/index.jsp">
                        <b>
                            <img src="plugins/images/pixeladmin-logo.png" alt="home" />
                        </b>
                        <span class="hidden-xs">
                            <img src="plugins/images/pixeladmin-text.png" alt="home" />
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
                                <img src="plugins/images/users/varun.jpg" alt="user-img" width="36"
                                    class="img-circle" />
                                <b class="hidden-xs">Cybersoft</b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="profile.jsp">Thông tin cá nhân</a></li>
                                <li><a href="#">Thống kê công việc</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Đăng xuất</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href="views/admin/index.jsp" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                                                aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                    </li>
                    <li>
                        <a href="user-table.jsp" class="waves-effect"><i class="fa fa-user fa-fw"
                                                                         aria-hidden="true"></i><span class="hide-menu">Thành viên</span></a>
                    </li>
                    <li>
                        <a href="role-table.jsp" class="waves-effect"><i class="fa fa-modx fa-fw"
                                                                         aria-hidden="true"></i><span class="hide-menu">Quyền</span></a>
                    </li>
                    <li>
                        <a href="groupwork.jsp" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                        aria-hidden="true"></i><span class="hide-menu">Công việc</span></a>
                    </li>
                    <li>
                        <a href="task.jsp" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                   aria-hidden="true"></i><span class="hide-menu">Công việc</span></a>
                    </li>
                    <li>
                        <a href="views/blank.jsp" class="waves-effect"><i class="fa fa-columns fa-fw"
                                                                          aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                    </li>
                    <li>
                        <a href="views/404.jsp" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                                                        aria-hidden="true"></i><span class="hide-menu">Error 404</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Thêm mới công việc</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material">
                                <div class="form-group">
                                    <label class="col-md-12">Tên dự án</label>
                                    <div class="col-md-12">
                                        <input type="text" readonly value="Dự án CRM" class="form-control form-control-line">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Tên công việc</label>
                                    <div class="col-md-12">
                                        <input type="text" readonly value="Thiết kế database" class="form-control form-control-line">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu</label>
                                    <div class="col-md-12">
                                        <input type="text" readonly value="05-07/2020" class="form-control form-control-line"> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc</label>
                                    <div class="col-md-12">
                                        <input type="text" readonly value="17-07/2020" class="form-control form-control-line"> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Trạng thái</label>
                                    <div class="col-md-12">
                                        <select class="form-control form-control-line">
                                            <option>Chưa thực hiện</option>
                                            <option selected>Đang thực hiện</option>
                                            <option>Đã hoàn thành</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Lưu lại</button>
                                        <a href="profile.jsp" class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>

</body>

</html>