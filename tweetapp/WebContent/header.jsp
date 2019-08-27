<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>


<header>
		<div class="right">
			<s:form action= "TextAction">
				<s:submit value="投稿一覧"/>
			</s:form>
		</div>
		<div class="left">
			<s:if test="#session.loginFlag == null">
				<s:form action="GoLoginAction">
					<s:submit value="ログイン"/>
				</s:form>
			</s:if>
			<s:else>
				<s:form action ="LogoutAction">
					<s:submit value="ログアウト"/>
				</s:form>
			</s:else>
		</div>

</header>

