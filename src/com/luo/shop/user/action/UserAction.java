package com.luo.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.user.service.UserService;
import com.luo.shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ģ������
	private User user = new User();
	//ע��UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//�����������֤��
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	/**
	 * AJAX�����첽У���û�����ִ�з���
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		User existUser = userService.findByUserName(user.getUsername());
		//���response����ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		//���ñ���
		response.setContentType("text/html;charset=UTF-8");
		if(existUser != null){
			//��ѯ���û����û����Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		}else{
			response.getWriter().println("<font color='red'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	/*
	 * �û�ע��
	 */
	public String regist(){
		/*
		 * ���������֤���ж�
		 */
		String crcode = (String) ServletActionContext.getRequest().getSession().getAttribute("checkImgCode");
		
		if(!crcode.equalsIgnoreCase(checkcode)){
			this.addActionError("��֤�����");
			return "falirRegist";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�����ȥ���伤�");
		return "msg";
		
	}
	/*
	 * �û�����
	 * ���ݴ������ļ�����code�Ƿ������ɵ�һ������ͬ���޸�statusΪ1 codeΪ��
	 * ����һ���򷵻ش�����Ϣ
	 * 
	 */
	public String active(){
		User existUser = userService.findUserBYCode(user.getCode());
		if(existUser == null){
			this.addActionMessage("�û�����ʧ�ܣ����������");
		}else{
			existUser.setState(1);
			existUser.setCode(null);
			userService.updateUser(existUser);
			this.addActionMessage("�û�����ɹ�����ȥ��¼��");
			return "msg";
		}
		return NONE;
	}
	
	/*
	 * �û���¼
	 */
	public String login(){
		User existsUser = userService.login(user);
		if(existsUser == null){
			//��¼ʧ�ܣ����޴��û�
			this.addActionError("�û�����������������û�δ����");
			return LOGIN;
		}else{
			//��¼�ɹ�
			ServletActionContext.getRequest().getSession().setAttribute("existsUser", existsUser);
			return "loginSuccess";
		}
		
	}
	
	/*
	 * �û��˳�
	 */
	public String quit(){
		//��session����
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
