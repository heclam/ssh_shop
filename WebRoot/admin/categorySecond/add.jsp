<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加二级分类</title>
    
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
    		<h3>添加二级分类</h3>
    		<form action="${pageContext.request.contextPath }/adminCategorySecond_save.action" method="post" >
    			二级分类的名称：<input type="text" name="csname"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			所属的一级分类：
    						<select name="category.cid">
    							<s:iterator var="c" value="cList">
    								<option value="<s:property value="#c.cid" />">
										<s:property value="#c.cname" />
    								</option>
    							</s:iterator>
    						</select>
    			
    			
    				
    			<br/><br/>
    			<input type="submit" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="reset" value="重置" />
    			
    		</form>
    	</center>
  </body>
</html>
