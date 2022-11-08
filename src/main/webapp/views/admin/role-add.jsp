<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <h4 class="page-title">Thêm mới quyền</h4>
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
                                    <label class="col-md-12">Tên quyền</label>
                                    <div class="col-md-12">
                                        <input name="name" type="text" placeholder="Tên quyền"
                                            class="form-control form-control-line" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-md-12">Mô tả</label>
                                    <div class="col-md-12">
                                        <input name="description" type="text" placeholder="Mô tả" class="form-control form-control-line" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <h5 class="text-danger">${mes}</h5>
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Add Role</button>
                                        <a href="<c:url value="/admin-role"/>" class="btn btn-primary">Quay lại</a>
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
    <!-- /#wrapper -->
    <!-- jQuery -->
</body>

</html>