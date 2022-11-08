<%@ page contentType="text/html; charset=UTF-8" %>
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
                <h4 class="page-title">Danh sách thành viên</h4>
            </div>
            <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                <a href="<c:url value="/manager-addmem?action=addmem"/>" class="btn btn-sm btn-success">Thêm mới</a>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /row -->
        <div class="row">
            <div class="col-sm-12">
                <div class="white-box">
                    <div class="table-responsive">
                        <table class="table" id="example">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Full Name</th>
                                <th>Username</th>
                                <th>Role</th>
                                <th>#</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${members}" var="mem">
                                <tr>
                                    <td>${mem.getId()}</td>
                                    <td>${mem.getFullname()}</td>
                                    <td>${mem.getEmail()}</td>
                                    <td>${mem.getRole().getName()}</td>
                                    <td>
                                        <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                                        <a href="<c:url value="/member-detail?action=detail&id=${mem.getId()}"/>" class="btn btn-sm btn-info">Xem</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
<!-- /#wrapper -->
<!-- jQuery -->

</body>

</html>