<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/impl_rotator.js"></script>
<style>	
	table{
		border:1px solid black;
	}
	table td{
			border:1px solid black;
	}
</style>
</head>

<body>
	<div id="firstdiv">
		<center>
			<p align="left">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="${pageContext.request.contextPath}/images/title.jpg" alt="标题" width="200px" height="50px" />
			</p>
		<%@ include file="head.jsp" %>
			
			 <div >
				<p align="center">订单</p>
			</div>
			
            <div id="showOrder"  >
				<table border="1" style="width:80%;">
					<tr>
						<td colspan="5">订单编号:<s:property value="model.oid"/></td>
					</tr>
					<tr>
						<td>图片</td>
						<td>商品</td>
						<td>价格</td>
						<td>数量</td>
						<td>小计</td>
					</tr>
					<!-- 循环遍历订单 -->
					<s:iterator var="orderitem" value="model.orderItems">
						<tr id="del">
							<td width="200px" align="center"><img src="${pageContext.request.contextPath}/<s:property value="#orderitem.product.image"/>" width="150px" height="90px" /></td>
							<td><s:property value="#orderitem.product.pname"/></td>
							<td><s:property value="#orderitem.product.shop_price"/></td>
							<td><s:property value="#orderitem.count"/></td>
							<td>￥<s:property value="#orderitem.subtotal"/></td>
						</tr>
					</s:iterator>	
				</table>
				<div align="right" style="margin-right:200px;">商品金额:<span id="allpirce">￥<s:property value="model.total"/></span>&nbsp;</div>
			</div>
		<form id="orderForm" action="${pageContext.request.contextPath }/order_payOrder.action" method="post">
			<input type="hidden" name="oid" value="<s:property value="model.oid"/>"  />
			收货地址：<input type="text" name="addr" value="<s:property value="model.user.addr"/>" /><br/>
			收货人:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" value="<s:property value="model.user.username"/>" /><br/>
			联系电话：<input type="text" name="phone" value="<s:property value="model.user.phone"/>" />
			<hr />
			<h3>选择银行：</h3>
			<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行&nbsp;
			<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行&nbsp;
			<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行&nbsp;
			<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行&nbsp;
			<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行&nbsp;
			<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行&nbsp;
			<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行&nbsp;
			<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行&nbsp;
			<hr/>			
				<input type="submit" value="确认订单" />
		</form>		
		</center>
		<br/><br/><br/><br/>
		<!--底部-->
		<%@ include file="bottom.jsp" %>
	</div>

</body>
</html>
