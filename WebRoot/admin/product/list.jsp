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
		function addProduct(){
			window.location.href="${pageContext.request.contextPath}/adminProduct_addPage.action";
		}
	</script> 
  </head>
  
  <body>
    <center>
    	<h3>商品列表</h3>
    	<p align="center" style="margin-left:200px;">
    		<input type="button" value="添加" onclick="addProduct()"/>
    	</p>
    	<table border="1" width="80%" >
    		<tr>
    			<td>序号</td>
    			<td>商品图片</td>
    			<td>商品名称</td>
    			<td>商品价格</td>
    			<td>是否热门</td>
    			<td>编辑</td>
    			<td>删除</td>
    		</tr>
    	<s:iterator var="p" value="pageBean.list" status="status">
    		<tr>
    			<!-- 这个序号通过status.count来完成 -->
    			<td align="center"><s:property value="#status.count" /></td>
    			<td><img alt="商品图片" width="50" height="40" src="${pageContext.request.contextPath }/<s:property value="#p.image" />" /></td>
    			<td><s:property value="#p.pname" /></td>
    			<td><s:property value="#p.market_price" /></td>
    			<td>
    				<s:if test="#p.is_host==1">
    					是
    				</s:if>
    				<s:else>
    					否
    				</s:else>
    			</td>
    			<td align="center" >
    				<a href="${pageContext.request.contextPath }/adminProduct_edit.action?pid=<s:property value="#p.pid" />">
    					<img alt="编辑" src="${pageContext.request.contextPath }/images/edit.jpg" width="25px" height="25px" />
    				</a>
    			</td>
    			<td align="center" >
    				<a href="${pageContext.request.contextPath }/adminProduct_delete.action?pid=<s:property value="#p.pid" />">
						<img alt="删除" src="${pageContext.request.contextPath }/images/delete.jpg" width="25px" height="25px" />
					</a>
				</td>
    		</tr>
    	</s:iterator>
    	</table>
    			<div>
    				<span>第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页</span>
					<s:if test="pageBean.currentPage !=1">
						<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?currentPage=1"><input type="button" value="首页" /></a>
						<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?currentPage=<s:property value="pageBean.currentPage-1" />"><input type="button" value="上一页" /></a>
					</s:if>
					<s:if test="pageBean.currentPage != pageBean.totalPage">
						<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?currentPage=<s:property value="pageBean.currentPage+1" />"><input type="button" value="下一页" /></a>
						<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?currentPage=<s:property value="pageBean.totalPage" />"><input type="button" value="尾页" /></a>
					</s:if>
				</div>
    </center>
  </body>
</html>
