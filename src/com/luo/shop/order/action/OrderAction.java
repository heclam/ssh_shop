package com.luo.shop.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.cart.vo.Cart;
import com.luo.shop.cart.vo.CartItem;
import com.luo.shop.order.service.OrderService;
import com.luo.shop.order.vo.Order;
import com.luo.shop.order.vo.OrderItem;
import com.luo.shop.user.vo.User;
import com.luo.shop.util.PageBean;
import com.luo.shop.util.PaymentUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//采用模型驱动
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	//使用模型驱动
	private Order order = new Order();
	//注入OrderService
	private OrderService orderService;
	//接收currentPage这个参数
	private Integer currentPage;
	//接收支付通道编码
	private String pd_FrpId;
	//接受付款成功后的响应数据：
	private String r6_Order;//订单号
	private String r3_Amt; //付款金额
	
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	//保存订单
	public String save(){ //这里需要保存两个对象所以使用联级操作
		//1.保存数据到数据库
		//订单数据的补全
		order.setOrdertime(new Date());
		order.setState(1); //1:未付款 ，2:已付款，但是没有发货 ，3：已经发货，但是还没有确认收货 ，4：交易完成
		//总计的数据是购物车中的信息
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			this.addActionError("亲！您还没有购物！请先购物");
			return "msg";
		}
		//设置总金额
		order.setTotal(cart.getTotal());
		//设置订单中的订单项：
		for(CartItem cartItem : cart.getCartItems()){
			//新建订单项
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		//设置订单所属用户
			//也是通过session去获取已登录的用户
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existsUser");
		if(user == null){
			this.addActionError("亲！您还没有登录！请先去登录！");
			return "login";
		}
		order.setUser(user);
		orderService.save(order);
		//遍历订单，使用值栈的方式遍历，因为order就是要遍历的对象所以使用model
		
		//保存完订单后清空购物车
		cart.clearCart();
		return "saveSuccess";
	}
	
	//我的订单的查询
	public String findByUid(){
		//根据用户的id查询
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existsUser");
		//调用service层
		PageBean<Order> pageBean = orderService.findPageByUid(user.getUid(),currentPage);
		//放入值栈中以便访问
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidSuccess";
		
	}
	
	//根据订单id查询订单
	public String findByOid(){
		//oid已被模型驱动接受
		order = orderService.findByOid(order.getOid());
		return "findByOidSuccess";
	}
	
	//为订单付款
	public String payOrder() throws IOException{
		//修改订单
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());
		orderService.update(currOrder);
		//完成支付
			//设置一些请求参数
		String p0_Cmd = "Buy"; //业务类型
		String p1_MerId = "10001126856"; //商户编号
		String p2_Order = order.getOid().toString(); //订单编号
		String p3_Amt = "0.01"; //付款金额
		String p4_Cur = "CNY" ; //交易币种
		String p5_Pid = ""; //商品名称
		String p6_Pcat = ""; //商品种类
		String p7_Pdesc = ""; //商品描述
		String p8_Url = "http://localhost:8080/ssh_shopping/order_callBack.action"; //支付成功后跳转的页面路径
		String p9_SAF = ""; //送货地址
		String pa_MP = ""; //扩展信息
		String pd_FrpId = this.pd_FrpId; //支付通道编码
		String pr_NeedResponse = "1" ;//应答机制
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur,
				p5_Pid,p6_Pcat, p7_Pdesc, p8_Url, p9_SAF,
				pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		// 向易宝发送请求:
				StringBuffer sb = new StringBuffer(
						"https://www.yeepay.com/app-merchant-proxy/node?");
				sb.append("p0_Cmd=").append(p0_Cmd).append("&");
				sb.append("p1_MerId=").append(p1_MerId).append("&");
				sb.append("p2_Order=").append(p2_Order).append("&");
				sb.append("p3_Amt=").append(p3_Amt).append("&");
				sb.append("p4_Cur=").append(p4_Cur).append("&");
				sb.append("p5_Pid=").append(p5_Pid).append("&");
				sb.append("p6_Pcat=").append(p6_Pcat).append("&");
				sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				sb.append("p8_Url=").append(p8_Url).append("&");
				sb.append("p9_SAF=").append(p9_SAF).append("&");
				sb.append("pa_MP=").append(pa_MP).append("&");
				sb.append("pd_FrpId=").append(pd_FrpId).append("&");
				sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				sb.append("hmac=").append(hmac);
			//重定向的易宝
				ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
		
	}
	
	//付款成功后的转向
	public String callBack(){
		//修改订单状态：修改订单状态为已经付款
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		currOrder.setState(2);
		orderService.update(currOrder);
		//在页面显示付款成功信息
		this.addActionMessage("订单付款成功：订单编号："+r6_Order+" 付款的金额："+r3_Amt);
		return "msg";
	}
	
	//修改订单状态
	public String updateState(){
		order = orderService.findByOid(order.getOid());
		order.setState(4);
		orderService.update(order);
		return "updateStateSuccess";
	}
}
