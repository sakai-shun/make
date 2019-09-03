<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/style.css">
<title>新規登録</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="main">
		<div class="title">
			<h2>CreateUser</h2>
		</div>
		<s:if test="loginIdErrorMessageList!=null && userIdErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="loginIdErrorMessageList"><s:property/><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="userNameErrorMessageList!=null && userNameErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="userNameErrorMessageList"><s:property/><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="loginPassErrorMessageList!=null && loginPassErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="loginPassErrorMessageList"><s:property/><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test = "errorMessage!=null">
			<div class="error">
				<div class="error-message">
					<s:property value="errorMessage"/>
				</div>
			</div>
		</s:if>
		<div class="user_form">
		<s:form action="CreateUserConfirmAction">
			<table class="user_table">
				<tr>
					<th>ログインID</th>
					<td><s:textfield name="loginId" value="%{#session.loginId}" placeholder="LoginId" class="text"/></td>
				</tr>
				<tr>
					<th>ユーザー名</th>
					<td><s:textfield name="userName" value="%{#session.userName}" placeholder="UserName" class="text"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:password name="loginPass" value="" placeholder="Password" class="text"/></td>
				</tr>
			</table>
			<div class="submit_btn">
				<s:submit value="Confirm" class="confirm_btn"/>
			</div>

		</s:form>
		</div>
	</div>
</body>
</html>