<%--
  Created by IntelliJ IDEA.
  User: DungPC
  Date: 10/30/2022
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse slimscrollsidebar">
        <ul class="nav" id="side-menu">
            <li style="padding: 10px 0 0;">
                <a href="<c:url value="/admin-home"/>" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                            aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
            </li>
            <li>
                <a href="<c:url value="/admin-member"/>" class="waves-effect"><i class="fa fa-user fa-fw"
                                                                 aria-hidden="true"></i><span class="hide-menu">Thành viên</span></a>
            </li>
            <li>
                <a href="<c:url value="/admin-role"/>" class="waves-effect"><i class="fa fa-modx fa-fw"
                                                                aria-hidden="true"></i><span class="hide-menu">Quyền</span></a>
            </li>
            <li>
                <a href="<c:url value="/admin-work"/>" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                aria-hidden="true"></i><span class="hide-menu">Dự án</span></a>
            </li>
            <li>
                <a href="<c:url value="/admin-task"/>" class="waves-effect"><i class="fa fa-table fa-fw"
                                                           aria-hidden="true"></i><span class="hide-menu">Công việc</span></a>
            </li>
        </ul>
    </div>
</div>
