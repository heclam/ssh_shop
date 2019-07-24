package com.luo.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.adminuser.service.AdminUserService;
import com.luo.shop.adminuser.vo.AdminUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	//ģ����������
	private AdminUser adminUser = new AdminUser();
	//ע��AdminUserService
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	@Override
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}
	
	/**
	 * ��̨�����û���¼
	 */
	public String login(){
		//��������ģ�������Ķ���
		AdminUser existsAdminUser =  adminUserService.login(adminUser);
		if(existsAdminUser == null){
			//��¼ʧ��
			this.addActionError("��������û������������");
			return "loginFail";
		}else{
			//��¼�ɹ�
			ServletActionContext.getRequest().getSession().setAttribute("existsAdminUser", existsAdminUser);
			return "loginSuccess";
		}
	}
	
	/**
	 * ��̨����Ա�˳�
	 */
	public String quit(){
		//��session����
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
