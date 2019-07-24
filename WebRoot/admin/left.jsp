<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="StyleSheet" href="_dtree/dtree.css" type="text/css" />
	<script type="text/javascript" src="_dtree/dtree.js"></script>
  </head>
  
  <body>
   
<div class="dtree">
		<p><a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a></p>
	<script type="text/javascript">
		<!--

		d = new dTree('d');

		d.add(0,-1,'系统菜单树');
		d.add(1,0,'用户管理');
		d.add(2,1,'用户管理','','','right');
		d.add(3,0,'一级分类管理');
		d.add(4,3,'一级分类管理','${pageContext.request.contextPath}/adminCategory_findAll.action','','right');
		d.add(5,0,'二级分类管理');
		d.add(6,5,'二级分类管理','${pageContext.request.contextPath}/adminCategorySecond_findAll.action?currentPage=1','','right');
		d.add(7,0,'商品管理');
		d.add(8,7,'商品管理','${pageContext.request.contextPath}/adminProduct_findAll.action?currentPage=1','','right');
		d.add(9,0,'订单管理');
		d.add(10,9,'订单管理','${pageContext.request.contextPath}/adminOrder_findAll.action?currentPage=1','','right');
		document.write(d);

		//-->
	</script>

</div>
  </body>
</html>
