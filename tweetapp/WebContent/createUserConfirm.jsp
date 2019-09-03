<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/style.css">
<title>新規登録確認</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="main">
		<div class="title">
			<h1>CreateUserConfirm</h1>
		</div>
		<div class="confirm_form">
			<table class="user_table">
				<tr>
					<td><label>ログインID:</label></td>
					<td><s:property value="#session.loginId"/></td>
				</tr>
				<tr>
					<td><label>パスワード:</label></td>
					<td><s:property value="#session.loginPass"/></td>
				</tr>
				<tr>
					<td><label>ユーザー名:</label></td>
					<td><s:property value="#session.userName"/></td>
				</tr>
			</table>
			<s:form action="CreateUserCompleteAction">
				<s:submit value="Create" class="create_btn"/>
			</s:form>
			<s:form action="CreateUserAction">
				<s:submit value="Back" class="back_btn"/>
				<s:hidden name="backFlag" value="1"/>
			</s:form>
		</div>
	</div>
</body>
</html>