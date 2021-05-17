<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>基于SSM药房管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="<%=basePath%>layui/layui.js"></script>
    <script src="<%=basePath%>js/admin_updateByPass.js" type="text/javascript"></script>
    <style>
        h2{font-size: 30px; text-align: center; color: #0C0C0C;padding-bottom: 45px;}
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/WEB-INF/pages/plugins/top.jsp"/>
    <jsp:include page="/WEB-INF/pages/plugins/left.jsp"/>
    <div class="layui-body">
        <div style="padding: 15px;">
            <div class="layui-container">
                <form class="layui-form">
                    <h2 class="layui-col-md-offset2">修改用户密码</h2>
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名称:</label>
                        <div class="layui-input-block">
                            <input type="text" name="aid" required lay-verify="required" placeholder="请输入用户昵称"
                                   autocomplete="off" value="<shiro:principal/>" class="layui-input" readonly>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">登录密码:</label>
                        <div class="layui-input-block">
                            <input type="password" name="password" required lay-verify="required" placeholder="请输入登录密码"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <input type="button" class="layui-btn layui-btn-sm layui-col-md-offset6" lay-filter="submitBtn" lay-submit value="修改">
                            <button type="reset" class="layui-btn layui-btn-sm layui-btn-danger">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="layui-footer">

    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use(['element','form'], function(){
        var element = layui.element,
        form = layui.form;

    });
</script>
</body>
</html>