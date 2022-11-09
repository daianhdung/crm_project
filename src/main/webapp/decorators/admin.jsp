<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/template/plugins/images/favicon.png"/>">
    <title><dec:title default="Admin"/> </title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/template/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<c:url value="/template/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"/>" rel="stylesheet">
    <link href="<c:url value="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>" rel="stylesheet">
    <!-- toast CSS -->
    <link href="<c:url value="/template/plugins/bower_components/toast-master/css/jquery.toast.css"/>" rel="stylesheet">
    <!-- morris CSS -->
    <link href="<c:url value="/template/plugins/bower_components/morrisjs/morris.css"/>" rel="stylesheet">
    <!-- animation CSS -->
    <link href="<c:url value="/template/css/animate.css"/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value="/template/css/style.css"/>" rel="stylesheet">
    <!-- color CSS -->
    <link href="<c:url value="/template/css/colors/blue-dark.css"/>" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/template/css/custom.css"/>">
</head>

<body>

<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<%--    header--%>
<%@include file="/common/admin/header.jsp" %>
<%--header--%>

<div id="wrapper">
    <!-- Left navbar-header -->
    <%@ include file="/common/admin/menu.jsp" %>
    <!-- Left navbar-header end -->

    <dec:body/>
</div>


<%--    footer--%>
<%@include file="/common/admin/footer.jsp"%>
<%--    footer--%>


<script src="<c:url value="/template/plugins/bower_components/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/template/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<!-- Menu Plugin JavaScript -->
<script src="<c:url value="/template/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"/>"></script>
<!--slimscroll JavaScript -->
<script src="<c:url value="/template/js/jquery.slimscroll.js"/>"></script>

<!--Wave Effects -->
<script src="<c:url value="/template/js/waves.js"/>"></script>
<script src="<c:url value="/template/js/jquery.dataTables.js"/>"></script>
<!--Counter js -->
<script src="<c:url value="/template/plugins/bower_components/waypoints/lib/jquery.waypoints.js"/>"></script>
<script src="<c:url value="/template/plugins/bower_components/counterup/jquery.counterup.min.js"/>"></script>
<!--Morris JavaScript -->
<script src="<c:url value="/template/plugins/bower_components/raphael/raphael-min.js"/>"></script>
<script src="<c:url value="/template/plugins/bower_components/morrisjs/morris.js"/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<c:url value="/template/js/custom.min.js"/>"></script>
<script src="<c:url value="/template/js/dashboard1.js"/>"></script>
<script src="<c:url value="/template/plugins/bower_components/toast-master/js/jquery.toast.js"/>"></script>
<script src="<c:url value="/template/js/role.js"/>"></script>
<script src="<c:url value="/template/js/member.js"/>"></script>
<script src="<c:url value="/template/js/job.js"/>"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>

</body>

</html>
