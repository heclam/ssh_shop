<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function addCategory(){
			window.location.href="${pageContext.request.contextPath}/admin/category/add.jsp";
		}
	</script>
  </head>
  
  <body>
    <center>
    	<h3>一级分类列表</h3>
    	<p align="center" style="margin-left:200px;">
    		<input type="button" value="添加" onclick="addCategory()"/>
    	</p>
    	<table border="1" width="80%" >
    		<tr>
    			<td>序号</td>
    			<td>一级分类名称</td>
    			<td>编辑</td>
    			<td>删除</td>
    		</tr>
    	<s:iterator var="c" value="clist" status="status">
    		<tr>
    			<!-- 这个序号通过status.count来完成 -->
    			<td align="center"><s:property value="#status.count" /></td>
    			<td><s:property value="#c.cname" /></td>
    			<td align="center" >
    				<a href="${pageContext.request.contextPath }/adminCategory_edit.action?cid=<s:property value="#c.cid" />">
    					<img alt="编辑" src="${pageContext.request.contextPath }/images/edit.jpg" width="25px" height="25px" />
    				</a>
    			</td>
    			<td align="center" >
    				<a href="${pageContext.request.contextPath }/adminCategory_delete.action?cid=<s:property value="#c.cid" />">
						<img alt="删除" src="${pageContext.request.contextPath }/images/delete.jpg" width="25px" height="25px" />
					</a>
				</td>
    		</tr>
    	</s:iterator>
    	</table>
    </center>
  </body>
</html>
