<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
     <div id="head">
				<ul class="first">
					<li><a href="${pageContext.request.contextPath }/index_head.action">首页</a></li>
					<s:iterator value="#session.clist" var="c">
						<li><a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&currentPage=1"><s:property value="#c.cname"/></a></li>
					</s:iterator>
					<li>关于我们▼
						<ul class="two">
							<li>企业文化</li>
							<li>合作伙伴</li>
							<li>其他</li>
						</ul>
					</li>
				</ul> 
				
				 <p><input type="text" size="15" style="width: 200px;height: 25px;border:solid 1px #000;border-radius: 5px;box-shadow: 0 0 " placeholder="搜索：劳力士/柏尼时/拉尔森" />
				                <input type="button" style="width: 30px;height: 25px;background:none" value="go" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<s:if test="#session.existsUser != null">
						<a href="${pageContext.request.contextPath }/order_findByUid.action?currentPage=1" ><font color="red">我的订单</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</s:if>
					<a href="${pageContext.request.contextPath }/cart_myCart.action" ><font color="red">购物车</font></a>
				</p> 
	</div>
