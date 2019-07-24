<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单页面</title>
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
				<p align="center">我的订单</p>
			</div>
			
            <div id="showOrder"  >
            <!-- 做一个判断是否有订单 -->
            <s:if test="pageBean.list.size() !=0 ">
				<table border="1" style="width:80%;">
					<s:iterator var="order" value="pageBean.list">
						<tr>
							<td colspan="5">订单编号:<s:property value="#order.oid"/>&nbsp;&nbsp;&nbsp;&nbsp;
								订单状态：
								<s:if test="#order.state == 1">
									<a href="${pageContext.request.contextPath }/order_findByOid.action?oid=<s:property value="#order.oid"/>"><font color="red">未付款</font></a>
								</s:if>
								<s:if test="#order.state == 2">
									已付款
								</s:if>
								<s:if test="#order.state == 3">
									<a href="${pageContext.request.contextPath }/order_updateState.action?oid=<s:property value="#order.oid"/>"><font color="red">确认收货</font></a>
								</s:if>
								<s:if test="#order.state == 4">
									交易成功
								</s:if>
							</td>
						</tr>
						<tr>
							<td>图片</td>
							<td>商品</td>
							<td>价格</td>
							<td>数量</td>
							<td>小计</td>
						</tr>
						<!-- 循环遍历订单 -->
						 <s:iterator var="orderitem" value="#order.orderItems">
							<tr id="del">
								<td width="200px" align="center"><img src="${pageContext.request.contextPath}/<s:property value="#orderitem.product.image"/>" width="150px" height="90px" /></td>
								<td><s:property value="#orderitem.product.pname"/></td>
								<td><s:property value="#orderitem.product.shop_price"/></td>
								<td><s:property value="#orderitem.count"/></td>
								<td>￥<s:property value="#orderitem.subtotal"/></td>
							</tr>
						</s:iterator> 
				</s:iterator>
				<tr>
							<td colspan="5">
								<div style="clear:both;float: right;margin-right:400px">
									<span>第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页</span>
										<s:if test="pageBean.currentPage !=1">
											<a href="${pageContext.request.contextPath }/order_findByUid.action?currentPage=1"><input type="button" value="首页" /></a>
											<a href="${pageContext.request.contextPath }/order_findByUid.action?currentPage=<s:property value="pageBean.currentPage-1" />"><input type="button" value="上一页" /></a>
										</s:if>
										<s:if test="pageBean.currentPage != pageBean.totalPage">
											<a href="${pageContext.request.contextPath }/order_findByUid.action?currentPage=<s:property value="pageBean.currentPage+1" />"><input type="button" value="下一页" /></a>
											<a href="${pageContext.request.contextPath }/order_findByUid.action?currentPage=<s:property value="pageBean.totalPage" />"><input type="button" value="尾页" /></a>
										</s:if>
								</div>
							</td>
						</tr>	
				</table>	
			</s:if>	
			<s:else>
				亲，你还没有订单赶快去购物吧！
			</s:else>
		</div>
		</center>
		<br/><br/><br/><br/>
		<!--底部-->
		<%@ include file="bottom.jsp" %>
	</div>

</body>
</html>
