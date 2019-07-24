<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>后台订单管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function showDetail(oid){
			var btn = document.getElementById("btn"+oid);
			var div = document.getElementById("div"+oid);
			//这里发送异步请求显示商品详情
			//1.创建异步对象
			var xhr = createXmlHttp();
			//2.设置监听
			if(btn.value=="订单详情"){
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4){
						if(xhr.status == 200){
						div.innerHTML= xhr.responseText;
						}
					}
				}
				btn.value="关闭";
			}else{
				btn.value="订单详情";
				div.innerHTML="";
			}
			
			//3.打开连接
				xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItem.action?time="+new Date().getTime()+"&oid="+oid,true);
			//4.发送
				xhr.send(null);
			}
		
		
		function createXmlHttp(){
		var xmlHttp;
		try{//Firefox,opera 8.0+,Safari
			xmlHttp = new XMLHttpRequest();
		}catch(e){
			try{ //Internet Explorer
				xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
			}catch(e){
				try{
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){}
			}
		}
		return xmlHttp;
	}
	</script>
  </head>
  
  <body>
    <center>
    	<h3>订单列表</h3>
    	
    	<table border="1" width="80%" >
    		<tr>
    			<td>序号</td>
    			<td>订单编号</td>
    			<td>订单金额</td>
    			<td>收货人</td>
    			<td>订单状态</td>
    			<td>订单详情</td>
    		</tr>
    	<s:iterator var="o" value="pageBean.list" status="status">
    		<tr>
    			<!-- 这个序号通过status.count来完成 -->
    			<td align="center"><s:property value="#status.count" /></td>
    			<td><s:property value="#o.oid" /></td>
    			<td><s:property value="#o.total" /></td>
    			<td><s:property value="#o.name" /></td>
    			<td>
    				<!-- 1:未付款 ，2:已付款，但是没有发货 ，3：已经发货，但是还没有确认收货 ，4：交易完成 -->
    				<s:if test="#o.state==1">
    					未付款
    				</s:if>
    				<s:if test="#o.state==2">
    					<a href="${pageContext.request.contextPath }/adminOrder_updateState.action?oid=<s:property value="#o.oid" />">
    						<font color="blue">未发货</font></a>
    				</s:if>
    				<s:if test="#o.state==3">
    					<font color="red">未签收</font>
    				</s:if>
    				<s:if test="#o.state==4">
    					完成交易
    				</s:if>
    			</td>
    			<td align="center" >
    				<input id="btn<s:property value="#o.oid" />" type="button" value="订单详情" onclick="showDetail(<s:property value="#o.oid" />)" />
    				<div id="div<s:property value="#o.oid" />"></div>
    			</td>
    		</tr>
    	</s:iterator>
    	</table>
    			<div>
    				<span>第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页</span>
					<s:if test="pageBean.currentPage !=1">
						<a href="${pageContext.request.contextPath }/adminOrder_findAll.action?currentPage=1"><input type="button" value="首页" /></a>
						<a href="${pageContext.request.contextPath }/adminOrder_findAll.action?currentPage=<s:property value="pageBean.currentPage-1" />"><input type="button" value="上一页" /></a>
					</s:if>
					<s:if test="pageBean.currentPage != pageBean.totalPage">
						<a href="${pageContext.request.contextPath }/adminOrder_findAll.action?currentPage=<s:property value="pageBean.currentPage+1" />"><input type="button" value="下一页" /></a>
						<a href="${pageContext.request.contextPath }/adminOrder_findAll.action?currentPage=<s:property value="pageBean.totalPage" />"><input type="button" value="尾页" /></a>
					</s:if>
				</div>
    </center>
  </body>
</html>
