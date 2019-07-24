package com.luo.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.adminuser.service.AdminUserService;
import com.luo.shop.adminuser.vo.AdminUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	//模型驱动对象
	private AdminUser adminUser = new AdminUser();
	//注入AdminUserService
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
	 * 后台管理用户登录
	 */
	public String login(){
		//参数传入模型驱动的对象
		AdminUser existsAdminUser =  adminUserService.login(adminUser);
		if(existsAdminUser == null){
			//登录失败
			this.addActionError("您输入的用户名或密码错误");
			return "loginFail";
		}else{
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("existsAdminUser", existsAdminUser);
			return "loginSuccess";
		}
	}
	
	/**
	 * 后台管理员退出
	 */
	public String quit(){
		//将session销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
