<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/style.css">
<title>Login画面</title>
</head>
<body>
	<script src="./js/login.js"></script>
	<jsp:include page="header.jsp"/>
	<div class="main">
		<div class="title">
			<h2>Login</h2>
		</div>

		<s:if test="loginIdErrorMessageList!=null && loginIdErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="loginIdErrorMessageList"><s:property/><br></s:iterator>
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
		<s:if test="isNotUserInfoMessage!=null && !isNotUserInfoMessage.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:property value="isNotUserInfoMessage"/>
				</div>
			</div>
		</s:if>
		<div class="login_table">
			<form id="form">

				<div><input type="text" name="loginId" placeholder="ID"></div>
				<div><input type="text" name="loginPass" placeholder="PASS"></div>
				<div>
					<button class="create_btn" onclick="goCreateUserAction()">CreateUser</button>
					<button class="login_btn" onclick="goLoginAction()">Login</button>
				</div>

			</form>
		</div>
	</div>

</body>
</html>