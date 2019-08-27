<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login画面</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="main">
		<div class="title">
			<h2>ログイン画面</h2>
		</div>

		<s:if test="userIdErrorMessageList!=null && userIdErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="userIdErrorMessageList"><s:property/><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="passwordErrorMessageList!=null && passwordErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="passwordErrorMessageList"><s:property/><br></s:iterator>
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
		<s:form action="LoginAction">
			<table>
				<tr>
					<td><label>ログインID</label></td>
					<td><input type="text" name="userId" value=""></td>
				</tr>
				<tr>
					<td><label>パスワード</label></td>
					<td><input type="text" name="password" value=""></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="ログイン"/></td>
				</tr>

			</table>

		</s:form>
			<s:form action="CreateUserAction">
				<s:submit value="新規ユーザー登録"/>
			</s:form>

	</div>

</body>
</html>