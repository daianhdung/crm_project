<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
</head>

<body>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <h4 class="page-title">Chi tiết thành viên</h4>
            </div>
        </div>
        <!-- /.row -->
        <!-- .row -->
        <div class="row">
            <div class="col-md-4 col-xs-12">
                <div class="white-box">
                    <div class="user-bg"> <img width="100%" alt="user" src="plugins/images/large/img1.jpg">
                        <div class="overlay-box">
                            <div class="user-content">
                                <a href="javascript:void(0)"><img src="plugins/images/users/genu.jpg"
                                                                  class="thumb-lg img-circle" alt="img"></a>
                                <h4 class="text-white">${isLogin.getFullname()}</h4>
                                <h5 class="text-white">${isLogin.getEmail()}</h5>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col-md-8 col-xs-12">
                <!-- BEGIN THỐNG KÊ -->
                <div class="row">
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-xs-12">
                                    <h3 class="counter text-right m-t-15 text-danger">20%</h3>
                                </div>
                                <div class="col-xs-12">
                                    <i data-icon="E" class="linea-icon linea-basic"></i>
                                    <h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar"
                                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 20%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-xs-12">
                                    <h3 class="counter text-right m-t-15 text-megna">50%</h3>
                                </div>
                                <div class="col-xs-12">
                                    <i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
                                    <h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-megna" role="progressbar"
                                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 50%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-xs-12">
                                    <h3 class="counter text-right m-t-15 text-primary">30%</h3>
                                </div>
                                <div class="col-xs-12">
                                    <i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
                                    <h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-primary" role="progressbar"
                                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 30%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- END THỐNG KÊ -->

            </div>
        </div><br />
        <!-- /.row -->
        <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
        <h4>DANH SÁCH CÔNG VIỆC</h4>
        <div class="row">
            <div class="col-md-4">
                <div class="white-box">
                    <h3 class="box-title">Chưa thực hiện</h3>
                    <div class="message-center">
                        <c:forEach items="${taskHavenDone}" var="task">
                            <a href="#">
                                <div class="mail-contnet">
                                    <h4>${task.getJobsModel().getName()}</h4>
                                    <h5>${task.getName()}</h5>
                                    <span class="mail-desc"></span>
                                    <span class="time">Bắt đầu: ${task.getStartDate()}</span>
                                    <span class="time">Kết thúc: ${task.getEndDate()}</span>
                                    </tr>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="white-box">
                    <h3 class="box-title">Đang thực hiện</h3>
                    <div class="message-center">
                        <c:forEach items="${taskDoing}" var="task">
                            <a href="#">
                                <div class="mail-contnet">
                                    <h4>${task.getJobsModel().getName()}</h4>
                                    <h5>${task.getName()}</h5>
                                    <span class="mail-desc"></span>
                                    <span class="time">Bắt đầu: ${task.getStartDate()}</span>
                                    <span class="time">Kết thúc: ${task.getEndDate()}</span>
                                    </tr>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="white-box">
                    <h3 class="box-title">Đã hoàn thành</h3>
                    <div class="message-center">
                        <c:forEach items="${taskComplete}" var="task">
                            <a href="#">
                                <div class="mail-contnet">
                                    <h4>${task.getJobsModel().getName()}</h4>
                                    <h5>${task.getName()}</h5>
                                    <span class="mail-desc"></span>
                                    <span class="time">Bắt đầu: ${task.getStartDate()}</span>
                                    <span class="time">Kết thúc: ${task.getEndDate()}</span>
                                    </tr>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- END DANH SÁCH CÔNG VIỆC -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
</body>

</html>