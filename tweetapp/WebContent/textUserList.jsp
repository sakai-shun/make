<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/style.css">
<title>テキストユーザーリスト</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="main">
		<div class="title">
			<h1>TextUserList</h1>
		</div>
		<s:if test="textInfoList != null && textInfoList.size()>0">
		<table>
			<s:iterator value="textInfoList">
				<tr>
					<td><s:property value="userName"/></td>
					<td>
						<s:property value="content"/>
						<a href="<s:url action ='TextAction'><s:param name="id" value="%{id}"/><s:param name="editFlag" value="1"/></s:url>">Edit</a>
						<a href="<s:url action ='DeleteTextAction'><s:param name="id" value="%{id}"/></s:url>">Delete</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		</s:if>
		<s:else>
		<div class="info">
			<p>つぶやきはありません。</p>
		</div>
		</s:else>

	</div>
</body>
</html>