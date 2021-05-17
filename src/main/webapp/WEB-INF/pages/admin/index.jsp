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
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/WEB-INF/pages/plugins/top.jsp"/>
    <jsp:include page="/WEB-INF/pages/plugins/left.jsp"/>
    <div class="layui-body">
        <div style="padding: 15px;">
            <div class="layui-col-md4">&nbsp;</div>
            <div class="layui-col-md4">
                <div class="layui-carousel" id="test1">
                    <div carousel-item>
                        <div><img src="<%=basePath%>img/1.jpg" alt=""></div>
                        <div><img src="<%=basePath%>img/2.jpg" alt=""></div>
                        <div><img src="<%=basePath%>img/3.jpg" alt=""></div>
                    </div>
                </div>
                <br><br><br>
                <h2>当前登录用户：<shiro:principal/></h2>
            </div>
            <div class="layui-col-md4">&nbsp;</div>
        </div>
    </div>

    <div class="layui-footer">

    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use(['element','carousel'], function(){
        var element = layui.element;
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
</script>
</body>
</html>