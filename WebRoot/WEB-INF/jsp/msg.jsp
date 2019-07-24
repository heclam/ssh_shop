<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'msg.jsp' starting page</title>
    
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
  		<table width="850px" border="0" >
  			<tr>
  				<td>
  					<s:actionmessage/>
  					<s:actionerror />
  					<br/>
  					<br/>
  					<a href="${pageContext.request.contextPath}/index.action">首页</a>
  					<a href="${pageContext.request.contextPath}/index.action">注册</a>
  					<a href="${pageContext.request.contextPath}/index.action">登录</a>
  				</td>
  				
  			</tr>
  		</table>
  </body>
</html>
