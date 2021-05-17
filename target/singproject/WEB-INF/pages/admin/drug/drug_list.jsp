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
        h2 {
            font-size: 30px;
            text-align: center;
            color: #0C0C0C;
            padding-bottom: 45px;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/WEB-INF/pages/plugins/top.jsp"/>
    <jsp:include page="/WEB-INF/pages/plugins/left.jsp"/>
    <div class="layui-body">
        <div style="padding: 15px;">
            <h2>药品信息列表</h2>
            <div class="demoTable">
                查询药品名称：
                <div class="layui-inline">
                    <input type="text" class="layui-input" name="title" id="demoReload">
                </div>
                <button class="layui-btn" data-type="reload">检索</button>
            </div>
            <table class="layui-table" id="stockTable" lay-filter="listSplit"></table>
        </div>
    </div>
    <script type="text/html" id="status">
        {{#   if(d.status == 0){     }}
        <button class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">上架</button>
        {{#    } else {         }}
        <button class="layui-btn layui-btn-xs layui-btn-danger">下架</button>
        {{# }}}
    </script>
    <script type="text/html" id="barOption">
        {{#   if(d.status == 0){     }}
        <button class="layui-btn layui-btn-xs layui-btn-success" lay-event="add">出库录入</button>
        <button class="layui-btn layui-btn-xs layui-btn-success" lay-event="list">出库列表</button>
        {{#    }       }}
    </script>
    <script src="<%=basePath%>js/drug_list.js"></script>
    <div class="layui-footer">

    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>