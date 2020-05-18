<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>欢迎使用</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/mainDiv.css" media="all"/>
</head>
<body>
<div class="">
	<div class="topDiv">
		<hr>${sessionScope.loginUser.name}，您好！欢迎使用图书管理系统<hr>
	</div>
	<div class="middleDiv">
		<form name="uploadForm" method="POST" action="<%=path%>/upload/fileUpload" enctype="multipart/form-data">
			<table>
				<tr>
					<td colspan="3">Please select a file to upload :</td>
				</tr>
				<tr>
					<td colspan="3"><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="上传文件" /></td>
				</tr>
				<tr>
					<td colspan="3">修改密码:</td>
				</tr>
				<tr>
					<td><label>
						登录名:
						<input type="text" name="loginName" placeholder="用户名或电话"/>
					</label></td>
					<td><label>
						原密码:
						<input type="password" name="oldPwd" placeholder=""/>
					</label></td>
					<td><label>
						新密码:
						<input type="password" name="newPwd" placeholder=" "/>
					</label></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" formaction="<%=path%>/user/changePwd" value="修改密码"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" formaction="<%=path%>/user/logOut" value="退出登录"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>
