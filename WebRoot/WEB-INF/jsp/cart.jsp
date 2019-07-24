<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscookies/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/impl_rotator.js"></script>

<script type="text/javascript">
/* 现在不实现修改购物车
//更改购买数量
	function changeQuantity(num){
		//获取数量
		var qt = document.getElementById("quantity");
		//单价为
		var sprice = document.getElementById("sprice").innerHTML;
		//获取总价格
		var allprice = document.getElementById("allpirce");
		//现在的数量为
		var getnum = qt.value;
		//判断
		if(num=="minus"){
			if(getnum <=1){	
			}else{
				getnum = parseInt(getnum)-1;
				qt.value = getnum;
			}
			
		}
		if(num=="add"){
			if(getnum>0){
				getnum = parseInt(getnum)+1;
				qt.value = getnum;
			}
		}
		//小计
		document.getElementById("subtotal").innerHTML=getnum*sprice;
		//总价格
		var totalprice = parseFloat(getnum)*parseFloat(sprice);
		
		allpirce.innerHTML=totalprice;
	} */
//删除
function deleteip(){

	$("#del").remove();
	var allprice = document.getElementById("allpirce").innerHTML=0;
}
function showMessage(){
alert("此功能还未实现哦");
}

</script>

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
				<p align="center">购物车</p>
			</div>
			<!-- 做一个判断：购物车是否有购物项 -->
			<s:if test="#session.cart.cartItems.size() != 0" >
            <div id="showcar"  >
				<table>
					<tr>
						<td>商品照片</td>
						<td>商品名称</td>
						<td>商品属性</td>
						<td>商品价格/元</td>
						<td>商品数量</td>
						<td>小计</td>
						<td>商品操作</td>
					</tr>
					<!--cartItems  -->
					<s:iterator var="cartItem" value="#session.cart.cartItems">
						<tr id="del">
							<td><img src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.image" />" width="150px" height="90" /></td>
							<td><s:property value="#cartItem.product.pname" /></td>
							<td><s:property value="#cartItem.product.pdesc" /></td>
							<td><span id="sprice"><s:property value="#cartItem.product.shop_price"/></span></td>
							<td>
								<!-- <button id="minus" onclick="changeQuantity('minus')" style="width: 30px;height: 20px;border-radius: 5px;">-</button>
								<input type="text" value="<s:property value="#cartItem.count" />" id="quantity" style="width: 50px;height: 20px;border: 1px solid #3FAF83;border-radius: 5px;"/>
								  <button id="add" onclick="changeQuantity('add')" style="width: 30px;height: 20px;border-radius: 5px;">+</button>
								-->
								<s:property value="#cartItem.count" />
							</td>
							<td><span id="subtotal"><s:property value="#cartItem.subtotal" /></span></td>
							<td><a href="${pageContext.request.contextPath }/cart_removeCart.action?pid=<s:property value="#cartItem.product.pid" />"><button onclick="deleteip()" style="width: 50px;height: 30px;border: 1px solid black;background: red;border-radius: 10px;">删除</button></a></td>
						</tr>
					</s:iterator>
				</table>
				<button style="width: 100px;height: 30px;border: 1px solid #3FAF83;background: grey;border-radius: 12px;float: left;margin-left: 200px;" >总价:<span id="allpirce"><s:property value="#session.cart.total" /></span></button>&nbsp;
				<span><a href="${pageContext.request.contextPath }/cart_clearCart.action"><font color="red">清空购物车</font></a></span>
				<a href="${pageContext.request.contextPath }/order_save.action"><button style="width: 80px;height: 30px;border: 1px solid black;background: red;border-radius: 12px;float: right;margin-right: 200px;">提交订单</button></a>
			</div>
			</s:if>
			<s:else>
				<div id="showcar">
					<h3>亲，您还没购物呢，请先去选购吧</h3>
				</div>
			</s:else>
		</center>
			<!--底部-->
		<%@ include file="bottom.jsp" %>
	</div>

</body>
</html>

