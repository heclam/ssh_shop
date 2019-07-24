package com.luo.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.user.service.UserService;
import com.luo.shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动
	private User user = new User();
	//注入UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//接受输入的验证码
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
	 * AJAX进行异步校验用户名的执行方法
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		User existUser = userService.findByUserName(user.getUsername());
		//获得response对象，页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码
		response.setContentType("text/html;charset=UTF-8");
		if(existUser != null){
			//查询到用户：用户名已存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		}else{
			response.getWriter().println("<font color='red'>用户名可以使用</font>");
		}
		return NONE;
	}
	/*
	 * 用户注册
	 */
	public String regist(){
		/*
		 * 这里进行验证的判断
		 */
		String crcode = (String) ServletActionContext.getRequest().getSession().getAttribute("checkImgCode");
		
		if(!crcode.equalsIgnoreCase(checkcode)){
			this.addActionError("验证码错误！");
			return "falirRegist";
		}
		userService.save(user);
		this.addActionMessage("注册成功，请去邮箱激活！");
		return "msg";
		
	}
	/*
	 * 用户激活
	 * 根据传回来的激活码code是否与生成的一样如相同则修改status为1 code为空
	 * 若不一样则返回错误信息
	 * 
	 */
	public String active(){
		User existUser = userService.findUserBYCode(user.getCode());
		if(existUser == null){
			this.addActionMessage("用户激活失败，激活码错误！");
		}else{
			existUser.setState(1);
			existUser.setCode(null);
			userService.updateUser(existUser);
			this.addActionMessage("用户激活成功，请去登录！");
			return "msg";
		}
		return NONE;
	}
	
	/*
	 * 用户登录
	 */
	public String login(){
		User existsUser = userService.login(user);
		if(existsUser == null){
			//登录失败；并无此用户
			this.addActionError("用户名错误或密码错误或用户未激活");
			return LOGIN;
		}else{
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("existsUser", existsUser);
			return "loginSuccess";
		}
		
	}
	
	/*
	 * 用户退出
	 */
	public String quit(){
		//将session销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
