<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>成功页面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/mainDiv.css" media="all"/>
</head>
<body>
<div class="">
    <div class="topDiv">
        <hr>${sessionScope.loginUser.name}，您好！<hr>
    </div>
    <div class="middleDiv">
        上传成功文件列表：
        <c:forEach items="${requestScope.fileNameList}" var="fileName" varStatus="var">
            ${var.count}--${fileName}<br/>
        </c:forEach>
        恭喜你！上传成功<br>
        <a href="<%=path%>/user/returnMain">点击</a>返回上一页
    </div>
</div>
</body>
</html>
