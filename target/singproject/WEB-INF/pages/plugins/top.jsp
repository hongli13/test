<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<div class="layui-header">
    <div class="layui-logo">基于SSM药房管理系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                <shiro:principal/>
            </a>
            <dl class="layui-nav-child">
                <dd><a href="<%=basePath%>adminUpdateByPasswordUrl.html">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="<%=basePath%>AdminAction/logout.html">退出</a></li>
    </ul>
</div>
