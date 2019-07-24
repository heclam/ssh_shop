<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改二级分类</title>
    
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
    		<h3>修改二级分类</h3>
    		<form action="${pageContext.request.contextPath }/adminCategorySecond_update.action" method="post" >
    						<input type="hidden" name="csid" value="<s:property value="model.csid" />" />
    			二级级分类的名称：<input type="text" name="csname" value="<s:property value="model.csname" />"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			所属的一级分类：
    						<select name="category.cid"  >
    							<s:iterator var="c" value="cList">
    								<s:if test="model.category.cid==#c.cid">
    								<option  value="<s:property value="#c.cid" />" selected ><s:property value="#c.cname" /></option>
    								</s:if>
    								<s:else>
    								<option  value="<s:property value="#c.cid" />" ><s:property value="#c.cname" /></option>
    								</s:else>
    							</s:iterator>
    						</select>
    			
    			
    				
    			<br/><br/>
    			<input type="submit" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="reset" value="重置" />
    			
    		</form>
    	</center>
  </body>
</html>
