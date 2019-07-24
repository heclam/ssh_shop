<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>后台添加商品</title>
    
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
    		<h3>添加商品</h3>
    		<form action="${pageContext.request.contextPath }/adminProduct_add.action" method="post" enctype="multipart/form-data" >
    			<table>
    				<tr>
    					<td>商品名称：<input type="text" name="pname"  /></td>
    					<td>所属的二级分类:
    						<select name="categorySecond.csid">
    							<s:iterator var="c" value="cList">
    								<option value="<s:property value="#c.csid" />"><s:property value="#c.csname" /></option>
    							</s:iterator>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td>商品市场价格：<input type="text" name="market_price"  /></td>
    					<td>商品商城价格：<input type="text" name="shop_price"  /></td>
    				</tr>
    				<tr>
    					<td colspan="2">是否热门：
    						<select name="is_host">
	    						<option value="1">是</option>
	    						<option value="0">否</option>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td colspan="2">商品图片：<input type="file" name="upload" />
    					</td>
    				</tr>
    				<tr>
    					<td colspan="2">商品描述：
    						<textarea rows="30" cols="60" name="pdesc"></textarea>
    					</td>
    				</tr>
    				<tr>
    					<td colspan="2">
    						<input type="submit" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
    						<input type="reset" value="重置" />
    					</td>
    				</tr>
    			</table>
    				
    		</form>
    	</center>
  </body>
</html>