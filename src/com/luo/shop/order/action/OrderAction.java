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
//����ģ������
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	//ʹ��ģ������
	private Order order = new Order();
	//ע��OrderService
	private OrderService orderService;
	//����currentPage�������
	private Integer currentPage;
	//����֧��ͨ������
	private String pd_FrpId;
	//���ܸ���ɹ������Ӧ���ݣ�
	private String r6_Order;//������
	private String r3_Amt; //������
	
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
	
	//���涩��
	public String save(){ //������Ҫ����������������ʹ����������
		//1.�������ݵ����ݿ�
		//�������ݵĲ�ȫ
		order.setOrdertime(new Date());
		order.setState(1); //1:δ���� ��2:�Ѹ������û�з��� ��3���Ѿ����������ǻ�û��ȷ���ջ� ��4���������
		//�ܼƵ������ǹ��ﳵ�е���Ϣ
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			this.addActionError("�ף�����û�й�����ȹ���");
			return "msg";
		}
		//�����ܽ��
		order.setTotal(cart.getTotal());
		//���ö����еĶ����
		for(CartItem cartItem : cart.getCartItems()){
			//�½�������
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		//���ö��������û�
			//Ҳ��ͨ��sessionȥ��ȡ�ѵ�¼���û�
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existsUser");
		if(user == null){
			this.addActionError("�ף�����û�е�¼������ȥ��¼��");
			return "login";
		}
		order.setUser(user);
		orderService.save(order);
		//����������ʹ��ֵջ�ķ�ʽ��������Ϊorder����Ҫ�����Ķ�������ʹ��model
		
		//�����궩������չ��ﳵ
		cart.clearCart();
		return "saveSuccess";
	}
	
	//�ҵĶ����Ĳ�ѯ
	public String findByUid(){
		//�����û���id��ѯ
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existsUser");
		//����service��
		PageBean<Order> pageBean = orderService.findPageByUid(user.getUid(),currentPage);
		//����ֵջ���Ա����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidSuccess";
		
	}
	
	//���ݶ���id��ѯ����
	public String findByOid(){
		//oid�ѱ�ģ����������
		order = orderService.findByOid(order.getOid());
		return "findByOidSuccess";
	}
	
	//Ϊ��������
	public String payOrder() throws IOException{
		//�޸Ķ���
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());
		orderService.update(currOrder);
		//���֧��
			//����һЩ�������
		String p0_Cmd = "Buy"; //ҵ������
		String p1_MerId = "10001126856"; //�̻����
		String p2_Order = order.getOid().toString(); //�������
		String p3_Amt = "0.01"; //������
		String p4_Cur = "CNY" ; //���ױ���
		String p5_Pid = ""; //��Ʒ����
		String p6_Pcat = ""; //��Ʒ����
		String p7_Pdesc = ""; //��Ʒ����
		String p8_Url = "http://localhost:8080/ssh_shopping/order_callBack.action"; //֧���ɹ�����ת��ҳ��·��
		String p9_SAF = ""; //�ͻ���ַ
		String pa_MP = ""; //��չ��Ϣ
		String pd_FrpId = this.pd_FrpId; //֧��ͨ������
		String pr_NeedResponse = "1" ;//Ӧ�����
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur,
				p5_Pid,p6_Pcat, p7_Pdesc, p8_Url, p9_SAF,
				pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		// ���ױ���������:
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
			//�ض�����ױ�
				ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
		
	}
	
	//����ɹ����ת��
	public String callBack(){
		//�޸Ķ���״̬���޸Ķ���״̬Ϊ�Ѿ�����
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		currOrder.setState(2);
		orderService.update(currOrder);
		//��ҳ����ʾ����ɹ���Ϣ
		this.addActionMessage("��������ɹ���������ţ�"+r6_Order+" ����Ľ�"+r3_Amt);
		return "msg";
	}
	
	//�޸Ķ���״̬
	public String updateState(){
		order = orderService.findByOid(order.getOid());
		order.setState(4);
		orderService.update(order);
		return "updateStateSuccess";
	}
}
