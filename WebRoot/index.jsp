<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 访问首页直接重定向到index.action
	由于struts默认只拦截请求(request)所以要到web.xml文件修改
	<filter-mapping> 
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
		<dispatcher>REQUEST</dispatcher>
		<dispatcher>FORWARD</dispatcher>
	</filter-mapping>
	使其可以拦截forward
-->
<jsp:forward page="index.action"></jsp:forward>
