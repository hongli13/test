<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item"><a href="">首页</a></li>
            <shiro:hasRole name="admin">
                <li class="layui-nav-item">
                    <a href="javascript:;">管理员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>adminAddUrl.html">增加管理员</a></dd>
                        <dd><a href="<%=basePath%>adminListUrl.html">管理员列表</a></dd>
                    </dl>
                </li>
            </shiro:hasRole>
            <shiro:hasRole name="xmkeshe">
                <li class="layui-nav-item">
                    <a href="javascript:;">类别管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>itemAddUrl.html">增加类别</a></dd>
                        <dd><a href="<%=basePath%>itemListUrl.html">类别列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">药品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>drugAddUrl.html">增加药品</a></dd>
                        <dd><a href="<%=basePath%>drugListUrl.html">药品列表</a></dd>
                    </dl>
                </li>
            </shiro:hasRole>
            <li class="layui-nav-item"><a href="<%=basePath%>adminUpdateByPasswordUrl.html">安全设置</a></li>
        </ul>
    </div>
</div>