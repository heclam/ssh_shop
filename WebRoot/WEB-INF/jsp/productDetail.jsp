<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/impl_rotator.js"></script>
	<script type="text/javascript">
		function addCart(){
			document.getElementById("formdetail").submit();
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
<!-- 
			<div>

				<input type="text" name="sreach" size="15"
					style="width: 600px;height: 20px;border-radius: 10px;border:solid 1px red;"
					placeholder="搜索其他商品" /> <input type="button"
					style="width: 80px;height: 20px;border-radius: 5px;border:solid 1px #3FAF83;background: #F00"
					value="搜索" />
			</div> -->
		<%@ include file="head.jsp" %>
			<div id="detailmd">
				商品详情
				<div class="showDetail">
					<img src="${pageContext.request.contextPath}/<s:property value="model.image" />" width="450" height="200px"
						id="changbigtu" /><br /> <br /> <br />

					<p>
						<img src="${pageContext.request.contextPath}/images/img1.jpg" width="50px" height="50px"
							onmouseover="changeTu('${pageContext.request.contextPath}/images/img1.jpg')"
							onmouseout="changeTu('${pageContext.request.contextPath}/images/roll_3.jpg')" />&nbsp; <img
							src="${pageContext.request.contextPath}/images/img2.jpg" width="50px" height="50px"
							onmouseover="changeTu('${pageContext.request.contextPath}/images/img2.jpg')"
							onmouseout="changeTu('${pageContext.request.contextPath}/images/roll_3.jpg')" />&nbsp; <img
								src="${pageContext.request.contextPath}/images/img3.jpg" width="50px" height="50px"
								onmouseover="changeTu('${pageContext.request.contextPath}/images/img3.jpg')"
								onmouseout="changeTu('${pageContext.request.contextPath}/images/roll_3.jpg')" />&nbsp; <img
									src="${pageContext.request.contextPath}/images/img4.jpg" width="50px" height="50px"
									onmouseover="changeTu('${pageContext.request.contextPath}/images/img4.jpg')"
									onmouseout="changeTu('${pageContext.request.contextPath}/images/roll_3.jpg')" />
					</p>
				</div>
				
				<div class="showMessage">
					<form id="formdetail" action="${pageContext.request.contextPath }/cart_addCart.action" method="post"> 
						<!-- 传一个商品id过去 -->
						<input type="hidden" name="pid" value="<s:property value="model.pid" />" />  
						<p>商品名称：<s:property value="model.pname" /></p>
						<br />
						<P>
							描述：<s:property value="model.pdesc" />
						</P>
						<p>
							<font color="red">价格:￥<s:property value="model.shop_price" />/只</font>
						</p>
	
						<span>数量<input type="text" name="count" value="1"
							maxlength="4"
							style="width: 50px;height: 20px;border-radius: 5px;border: solid 2px #3FAF83;"
							title="请输入购买量" />件</span> <br /> <br />
						<P>
							<Button type="button" onclick="addCart()"
								style="height:30px;width:80px;display:inline-block;background:#F00;">加入购物车</Button>
						</P>
						<span class="btn">配送范围：送货范围仅限汕头、云浮、汕尾、揭阳、中山、珠海、东莞、梅州、茂名、清远、广州、湛江、惠州、深圳、佛山、阳江、河源、肇庆、韶关、江门、潮州地区</span>
					 </form>
				</div>

			</div>
		</center>
		<!--底部-->
		<%@ include file="bottom.jsp" %>
	</div>

</body>
</html>
