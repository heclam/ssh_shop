<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>后台管理系统页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		body{
			color:white;
			background:#339999;
		}
		table{
			margin-top:100px;
		}
	</style>
  </head>
  
  <body>
  		
  		<center>
  			<!-- 显示错误信息:当登录失败时传回 -->
 			<s:actionerror/>
 			
	    	<form action="${pageContext.request.contextPath }/adminUser_login.action" target="_parent"  method="post" >
	    		<table>
	    			<tr>
	    				<td>管理员姓名：</td>
	    				<td><input type="text" name="username" /></td>
	    			</tr>
	    			<tr>
	    				<td>管理员密码：</td>
	    				<td><input type="password" name="password" /></td>
	    			</tr>
	    			<tr align="center">
						<td colspan="2"><input type="submit" value="进入管理系统" /></td>    			
	    			</tr>
	    		</table>
	    	</form>
    	</center>
  </body>
</html>
