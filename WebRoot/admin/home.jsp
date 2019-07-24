<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
<frameset rows="15%,*">
  <frame src="${pageContext.request.contextPath}/admin/top.jsp" name="top">
  <frameset cols="15%,*">
		<frame src="${pageContext.request.contextPath}/admin/left.jsp" name="left" >
		<frame src="${pageContext.request.contextPath}/admin/right.jsp" name="right">
  </frameset>
</frameset>
</html>
