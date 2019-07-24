<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'productList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/impl_rotator.js"></script>
	<style>	
.diplaydiv{
	float: left;
    padding-left:100px;
}	
	</style>
  </head>
  
  <body>
  	<center>
	   	<%@ include file="head.jsp" %>
	</center>	
	   		<div class="diplaydiv" style="none;width:10%;" >
				<dl>
			   		<s:iterator var="c" value="#session.clist">
				   		<dt><a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid" />&currentPage=1"><s:property value="#c.cname"/></a>
				   			<!-- 查询二级菜单会存在延迟必须在set中设置lazy=false -->
				   			<s:iterator var="cs" value="#c.categorySeconds">
				   					<dd>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&currentPage=1"><s:property value="#cs.csname"/></a></dd>
				   						
				   			</s:iterator>
				   		</dt>
			   		</s:iterator>
		   		</dl>
			</div>
			<div class="diplaydiv" style="width: 70%;" id="middle">
	
					<ul>
						<s:iterator var="p" value="pageBean.list">
							<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid" />">
									<img src="${pageContext.request.contextPath}/<s:property value="#p.image" />" width="290px" height="200px"   />
		                        </a>
								<p><s:property value="#p.pdesc" /></p><br/>
								<span>￥<s:property value="#p.shop_price" /></span>
								
							</li>
						</s:iterator>
	
					</ul>
			</div>
			<div style="clear:both;float: right;margin-right:400px">
				<span>第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页</span>
				<!-- 这里面的cid从值栈里面获取 -->
				<!-- 这里判断是一级分类的分页还是二级分类的分页 -->
				<s:if test="cid != null"><!-- 一级 分类的分页-->
					<s:if test="pageBean.currentPage !=1">
						<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&currentPage=1"><input type="button" value="首页" /></a>
						<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&currentPage=<s:property value="pageBean.currentPage-1" />"><input type="button" value="上一页" /></a>
					</s:if>
					<s:if test="pageBean.currentPage != pageBean.totalPage">
						<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&currentPage=<s:property value="pageBean.currentPage+1" />"><input type="button" value="下一页" /></a>
						<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&currentPage=<s:property value="pageBean.totalPage" />"><input type="button" value="尾页" /></a>
					</s:if>
				</s:if>
				<s:if test="csid != null"><!-- 二级分类的分页-->
					<s:if test="pageBean.currentPage !=1">
						<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&currentPage=1"><input type="button" value="首页" /></a>
						<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&currentPage=<s:property value="pageBean.currentPage-1" />"><input type="button" value="上一页" /></a>
					</s:if>
					<s:if test="pageBean.currentPage != pageBean.totalPage">
						<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&currentPage=<s:property value="pageBean.currentPage+1" />"><input type="button" value="下一页" /></a>
						<a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&currentPage=<s:property value="pageBean.totalPage" />"><input type="button" value="尾页" /></a>
					</s:if>
				</s:if>
			</div>
		
  </body>
</html>
