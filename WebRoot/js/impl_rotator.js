window.onload  = function(){
var roll = document.getElementById("rotator");
var imgArr = ["images/roll_1.jpg","images/roll_2.jpg","images/roll_3.jpg","images/roll_4.jpg","images/roll_5.jpg"];
var index = 0;
 var timer = setInterval(function(){
	index++;
	if(index >= imgArr.length){
	index = 0;
	}
	roll.src = imgArr[index];
},2000);

//清除定时器
roll.onclick = function(){
	clearInterval(timer);
}
}


	//显示遮罩面和登录框
		   		function showlogin(){
						document.getElementById("mask").style.display="block";
						document.getElementById("login_register").style.display="block";

				}
				//显示注册
				function showregister(){
					showlogin();
					change("regest");
				}
				function hidenMask() {
						document.getElementById("mask").style.display="none";
						document.getElementById("login_register").style.display="none";
				}
 //登录
	function change(ss){
				if(ss == "top1"){
					document.getElementById("b1").style.display="block";
					document.getElementById("b2").style.display="none";
					document.getElementById("b3").style.display="block";
					document.getElementById("b4").style.display="none";
					document.getElementById("end1").style.display="block";
					document.getElementById("end2").style.display="none";
				}else{
					//ert("12123");
					document.getElementById("b1").style.display = "none";
					document.getElementById("b2").style.display = "block";
					document.getElementById("b3").style.display = "none";
					document.getElementById("b4").style.display = "block";	
					document.getElementById("end1").style.display = "none";
					document.getElementById("end2").style.display = "block";
				}
		}	

//订单详情里面图片的放大
		function changeTu(tusrc){
		document.getElementById("changbigtu").src=tusrc;
	}

//car.html里面的数量加减
//更改购买数量
	function changeQuantity(num){
		var qt = document.getElementById("quantity");
		var allprice = document.getElementById("allpirce");
		var getnum = qt.value;
		if(num=="minus"){
			if(getnum <=1){	
			}else{
				getnum = parseInt(getnum)-1;
			}
			qt.value = getnum;
		}
		if(num=="add"){
			if(getnum>0){
				getnum = parseInt(getnum)+1;
				qt.value = getnum;
			}
		}
		//总价格
		var totalprice = parseFloat(getnum)*1440.00;
		allpirce.innerHTML=totalprice;
	}
//删除
function deleteip(){

	$("#del").remove();
	var allprice = document.getElementById("allpirce").innerHTML=0;
}
function showMessage(){
alert("此功能还未实现哦");
}
