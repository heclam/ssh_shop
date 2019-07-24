<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加一级分类</title>
    
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
    	<center>
    		<h3>添加一级分类</h3>
    		<form action="${pageContext.request.contextPath }/adminCategory_save.action" method="post" >
    			一级分类的名称：<input type="text" name="cname"  /><br/><br/>
    			<input type="submit" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="reset" value="重置" />
    		</form>
    	</center>
  </body>
</html>
