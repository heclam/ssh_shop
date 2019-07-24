<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  </head>
  
  <body>
	<h1>表白吧后台管理系统</h1>
	
	<p align="right" style="margin-right:150px;">
		<s:if test="#session.existsAdminUser != null">
			<a href="${pageContext.request.contextPath }/adminUser_quit.action" target="_parent">
			<font color="red">退出</font></a>
		</s:if>&nbsp;&nbsp;&nbsp;&nbsp;
		管理员:<s:property value="#session.existsAdminUser.username" />
	</p>
  </body>
</html>
