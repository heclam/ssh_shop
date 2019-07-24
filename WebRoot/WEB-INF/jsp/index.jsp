<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/impl_rotator.js"></script>
<script type="text/javascript">
	//登录的页面验证
	function checkLogin(){
		var username = document.getElementById("username").value;
		if(username == null || username == ''){
				document.getElementById("ck_username").innerHTML="<font color='red'>请输入账号！</font>";
				return false;
		}
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
				document.getElementById("ck_password").innerHTML="<font color='red'>请输入密码！</font>";
				return false;
		}
	}
	//进行注册验证
	function checkForm(){
		
		/* var username = document.getElementById("username").value;
		alert(username+"---");
		if(username == null || username == ''){
				alert("用户名不能为空！"+username);
				return false;
		}
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
				alert("密码不能为空！");
				return false;
		}
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
				alert("两次密码不一致！");
				return false;
		} */
	}
	//使用ajax异步交互方式查询注册用户名是否存在
	
	function checkUsername(){
	//获取文本款username的值
	var username = document.getElementById("username").value;
	//1.创建异步交互对象
		var xhr = createXmlHttp();
	//2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
	//3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
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
	function chang(){
		document.getElementById("chg").src="${pageContext.request.contextPath }/checkImg.action?"+new Date().getTime();
	}
</script>

</head>

<body>
	<!--弹出了的表单开始-->
	<div id="mask" onclick="hidenMask()"></div>
	<div id="login_register" >
			<table>
				<tr>
					<td width="200px"><button id="b1" style="background: none;width: 195px;height: 50px;border-right: solid 1px #000;"><b>登录</b></button>
						<button id="b2" onclick="change('top1')" style="display: none;background: none;width: 195px;height: 50px;border-right: solid 1px #000;" >登录</button>
					</td>
					<td><button id="b3" onclick="change('top2')"  style="background: none;width: 200px;height: 50px;"  >注册</button>
						<button id="b4"  style="display: none;background: none;width: 200px;height: 50px;"><b>注册</b></button>
					</td>
				</tr>
				<tr>
					<td colspan="2" >
						<div id="end1" align="center" >
<!--登录页面 -->					<s:actionerror />
								<form action="${pageContext.request.contextPath}/user_login.action" onsubmit="return checkLogin()" method="post" name="myform">
						
									<img src="${pageContext.request.contextPath}/images/test1.gif" />:&nbsp;&nbsp;
									<input type="text" name="username" id="username" placeholder="请输入账号"  /><span id="ck_username"></span>
										<br/>
									<img src="${pageContext.request.contextPath}/images/lock.jpg" width="30px" height="30px" />:&nbsp;&nbsp;
									<input type="text" name="password" id="password" placeholder="请输入密码" /><span id="ck_password"></span>
									<br/><br/>
									<input type="checkbox"/>记住密码&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">忘记密码？</a>
									<br/>
									<br/>
									<br/>
									<br/>
										<input type="submit" value="登录" style="width: 60%;height: 40px;background:#3FAF83; " /> &nbsp;&nbsp;&nbsp;&nbsp;
								</form>
							</div>
<!--注册页面 -->
						<div id="end2" style="display: none;" align="center">
								<s:actionerror />
								<form action="${pageContext.request.contextPath }/user_regist.action" method="post" onsubmit="return checkForm()" >
									<table>
										<tr>
											<td>用户名:</td>
											<td><input type="text" name="username" id="username" onblur="checkUsername()"  />
												<span id="span1"></span>
												<!-- 错误数据的回显 -->
												<s:fielderror></s:fielderror>
												
											</td>
										</tr>
										<tr>
											<td>密 &nbsp; 码:</td>
											<td><input type="password" name="password" id="password" /></td>
										</tr>
										<tr>
											<td>确认密码:</td>
											<td><input type="password" name="repassword" id="repassword" style="width: 200px;height: 30px;border:1px solid #3FAF83;" /></td>
										</tr>
										<tr>
											<td>E-mail:</td>
											<td><input type="text" name="email" id="email" style="width: 200px;height: 30px;border:1px solid #3FAF83;" /></td>
										</tr>
										<tr>
											<td>姓名:</td>
											<td><input type="text" name="name" id="name" style="width: 200px;height: 30px;border:1px solid #3FAF83;" /></td>
										</tr>
										<tr>
											<td>电 &nbsp;&nbsp; 话:</td>
											<td><input type="text" name="phone" id="phone" style="width: 200px;height: 30px;border:1px solid #3FAF83;" /></td>
										</tr>
										<tr>
											<td>收货地址:</td>
											<td><input type="text" name="addr" id="addr" style="width: 200px;height: 30px;border:1px solid #3FAF83;" /></td>
										</tr>
										<tr>
											<td>验证码：</td>
											<td><input type="text" name="checkcode" style="width: 200px;height: 30px;border:1px solid #3FAF83;" />
												&nbsp;<img src="${pageContext.request.contextPath }/checkImg.action" onclick="chang()" id="chg" />
											</td>
										</tr>
										<tr>
											<td colspan="2"> 
												<input type="submit" value="提交" style="width:40%;height: 40px;background:#3FAF83; " />
								           		 <input type="reset" value="重置" style="width: 40%;height: 40px;background:#3FAF83; "  />
								      		</td>
										</tr>
									</table>
	    					    </form>
						</div>
					</td>
				</tr>
			</table>

	</div>
	<!--弹出了的表单结束-->

	<div id="firstdiv">
		<center>
        	<p align="left">
                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             	<img src="${pageContext.request.contextPath}/images/title.jpg" alt="标题" width="200px" height="50px" />
                <span>
                	<s:if test="#session.existsUser == null">
                 	<button type="button" id="login" onclick="showlogin()" >登录</button>&nbsp;&nbsp;
					<button type="button" id="register" onclick="showregister()">注册</button>
					</s:if>	
					<s:else>
						<s:property value="#session.existsUser.name" />&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/order_findByUid.action?currentPage=1" ><font color="red">我的订单</font></a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/user_quit.action">退出</a>
					
					</s:else>
				</span>
             </p>
		
            <div id="head">
				<ul class="first">
					<li>全部类别
						<ul class="one">
							<li>劳力士
									<div> <button style="width: 100px;">劳力士男表</button><br/>
											<ul>
												<li>腕表</li>
												<li>腕带</li>
												<li>表壳</li>
												<li>条纹</li>
											</ul>
											<br/><br/>
											<button style="width: 100px;">劳力士女表</button><br/>
											<ul>
												<li>品牌logo</li>
												<li>最受欢迎的款式</li>
												<li>潮流款</li>
												<li>青春款</li>
											</ul>
									</div>
							</li>
							<li>百达翡丽</li>
							<li>伯爵</li>
							<li>爱彼</li>
							<li>宝凯</li>
							<li>阿玛尼</li>
							<li>宝珀</li>
							<li>ck</li>
							<li>更多</li>
							<li><button type="button" >经营地区</button>&nbsp;&nbsp;
								<button type="button" >专卖店</button></li>
						</ul>
					</li>
					<li>首页</li>
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
					<a href="${pageContext.request.contextPath }/cart_myCart.action" ><font color="red">购物车</font></a>
				</p> 
			</div>

			<!--轮播图片-->
			<div>
				<img src="${pageContext.request.contextPath}/images/roll_1.jpg" width="100%" height="400px" alt="广告图片" id="rotator" />
			</div>

			<div id="middle">
				<p align="left"><font size="+1" color="ff0033">热门产品</font></p>
				<ul>
					<s:iterator var="h" value="hlist">
						<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#h.pid" />">
								<img src="${pageContext.request.contextPath}/<s:property value="#h.image" />" width="290px" height="200px"   />
	                        </a>
							<p><s:property value="#h.pdesc" /></p>
							<span>￥<s:property value="#h.shop_price" /></span>
							
						</li>
					</s:iterator>

				</ul>
			</div>

		</center>
	</div>
	<center>
		<div id="middle2">
			<p align="left"><font size="+1" color="ff0033">最新产品</font></p><p align="right"><font color="blue">更多>></font></p>
			<div id="left">
				<img src="${pageContext.request.contextPath}/images/img7.jpg" width="270px" height="540px" />
			</div>
				
			<div id="right">
				<ul>
					<s:iterator var="n" value="nlist">
						<li><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#n.pid" />">
							<img src="${pageContext.request.contextPath}/<s:property value="#n.image" />" width="290px" height="200px"  />
	                        </a>
							<p><s:property value="#n.pdesc" /></p>
							<span>￥<s:property value="#n.shop_price" /></span>
							
						</li>
					</s:iterator>
		
				</ul>
			</div>
		</div>
	</center>

	<!--底部-->
	<%@ include file="bottom.jsp" %>
</body>
</html>

