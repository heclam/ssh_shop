<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table border="0" width="100%" >
	<s:iterator var="oi" value="list">
		<tr>
			<td><img width="60" height="40" src="${pageContext.request.contextPath }/<s:property value="#oi.product.image" />" /></td>
			<td>购买数量:<s:property value="#oi.count" /></td>
			<td>小计：<s:property value="#oi.subtotal" />￥</td>
		</tr>
	</s:iterator>
	
</table>