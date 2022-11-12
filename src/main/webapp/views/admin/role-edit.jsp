<%@ page contentType="text/html; charset=UTF-8" language="java"%>
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
                <h4 class="page-title">Thêm mới công việc</h4>
            </div>
        </div>
        <!-- /.row -->
        <!-- .row -->
        <div class="row">
            <div class="col-md-2 col-12"></div>
            <div class="col-md-8 col-xs-12">
                <div class="white-box">
                    <form method="post" class="form-horizontal form-material">
                        <div class="form-group">
                            <label class="col-md-12">Full Name</label>
                            <div class="col-md-12">
                                <input type="text" readonly value="${userEdit.getFullname()}" class="form-control form-control-line">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-12">Email</label>
                            <div class="col-md-12">
                                <input type="text" readonly value="${userEdit.getEmail()}" class="form-control form-control-line">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-12">Trạng thái</label>
                            <div class="col-md-12">
                                <select name="txtRole" class="form-control form-control-line">
                                    <c:forEach items="${listRole}" var="role">
                                        <option value="${role.getId()}">${role.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <button type="submit" class="btn btn-success">Lưu lại</button>
                                <a href="<c:url value="/admin-member"/>" class="btn btn-primary">Quay lại</a>
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
<!-- /#page-wrapper -->
</body>

</html>