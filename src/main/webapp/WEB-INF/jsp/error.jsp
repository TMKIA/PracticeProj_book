<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>出错</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/mainDiv.css" media="all"/>
</head>
<body>
<div class="">
    <div class="topDiv">
        <hr>
        ${sessionScope.loginUser.name}，您好！
        <hr>
    </div>
    <div class="middleDiv">
        登录失败！单击<a href="<%=path%>/user/logOut">这里</a>返回
    </div>
</div>
</body>
</html>
