<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>


<header>
	<div class="header">
		<div class="left">
			<a href="<s:url action='HomeAction'/>">TweetApp</a>
		</div>
		<div class="right">
		<ul>
		    <li><s:form action= "TextListAction">
				<s:submit class="btn" value="TextList"/>
			</s:form></li>
			<s:if test="#session.loginFlag == null">
				<li><s:form action="GoLoginAction">
						<s:submit class="btn" value="Login"/>
				</s:form></li>
			</s:if>
			<s:else>
				<li><s:form action ="LogoutAction">
					<s:submit class="btn" value="Logout"/>
				</s:form></li>
				<li><s:form action ="TextAction">
					<s:submit class="btn" value="Post"/>
				</s:form></li>
			</s:else>
		</ul>
		</div>
	</div>
		
</header>

