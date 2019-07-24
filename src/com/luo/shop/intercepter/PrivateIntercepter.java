package com.luo.shop.intercepter;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.adminuser.vo.AdminUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 后台访问权限的拦截器
 * 	作用：没有登录的用户是不可以访问的
 * @author hy
 *
 */
public class PrivateIntercepter extends MethodFilterInterceptor  {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		AdminUser existsAdminUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existsAdminUser");
		if(existsAdminUser !=null){
			//后台管理员已登录
				//方法放行
			return invocation.invoke();
		}else{
			//后台管理员还未登录
				//设置提示信息
			//获取正在执行的哪个action
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			//每次清空ActionErrors里面的内容
			actionSupport.clearActionErrors();
			actionSupport.addActionError("亲！您还没有登录，请先去登录！");
			return "loginFail";
		}
	
	}

	
}
