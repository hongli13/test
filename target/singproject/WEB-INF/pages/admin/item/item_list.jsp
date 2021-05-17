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
                <h2>分类列表</h2>
               <table class="layui-table"></table>
            </div>
        </div>
    </div>
    <script src="<%=basePath%>js/item_list.js"></script>
    <div class="layui-footer">

    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>