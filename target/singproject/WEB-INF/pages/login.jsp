<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css"/>
<%--    <script src="<%=basePath%>js/jquery.js"></script>--%>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="<%=basePath%>layui/layui.js"></script>
    <style>
        body{background-image: url("../../drug/img/4.jpg")}
        form{padding-top: 360px;}
        h2{font-size: 30px; text-align: center; color: #0C0C0C;padding-bottom: 45px;}
    </style>
</head>
<body>
<div class="layui-container">
    <div class="layui-col-md5">&nbsp;</div>
    <div class="layui-col-md5">
        <form class="layui-form">
            <h2 class="layui-col-md-offset2">管理员登录</h2>
            <div class="layui-form-item">
                <label class="layui-form-label">用户ID:</label>
                <div class="layui-input-block">
                    <input type="text" name="aid" required lay-verify="required" placeholder="请输入用户ID"
                           autocomplete="off" class="layui-input">
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
                    <input type="button" class="layui-btn layui-btn-sm layui-col-md-offset6" lay-filter="submitBtn" lay-submit value="登录">
                    <button type="reset" class="layui-btn layui-btn-sm layui-btn-danger">重置</button>
                </div>
            </div>
        </form>
    </div>
    <div class="layui-col-md2">&nbsp;</div>
    <script src="<%=basePath%>js/login.js"></script>
</div>
</body>
</html>
