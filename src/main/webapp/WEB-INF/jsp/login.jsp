<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>图书管理系统</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/mainDiv.css" media="all"/>
</head>
<body>
<div class="loginDiv">
	<form action="<%=path%>/user/loginCheck" method="post">
		<table>
			<caption>用户登录</caption>
			<tr>
				<td><label>
					登录名
					<input type="text" name="loginName"/>
				</label></td>
			</tr>
			<tr>
				<td><label>
					密&nbsp;&nbsp;码
					<input type="password" name="passWord">
				</label></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交"/>
					<input type="reset" value="重置">
				</td>
			</tr>
			${sessionScope.loginUser}
		</table>
	</form>
</div>
</body>
</html>
