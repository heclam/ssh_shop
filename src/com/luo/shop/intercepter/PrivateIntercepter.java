package com.luo.shop.intercepter;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.adminuser.vo.AdminUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ��̨����Ȩ�޵�������
 * 	���ã�û�е�¼���û��ǲ����Է��ʵ�
 * @author hy
 *
 */
public class PrivateIntercepter extends MethodFilterInterceptor  {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		AdminUser existsAdminUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existsAdminUser");
		if(existsAdminUser !=null){
			//��̨����Ա�ѵ�¼
				//��������
			return invocation.invoke();
		}else{
			//��̨����Ա��δ��¼
				//������ʾ��Ϣ
			//��ȡ����ִ�е��ĸ�action
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			//ÿ�����ActionErrors���������
			actionSupport.clearActionErrors();
			actionSupport.addActionError("�ף�����û�е�¼������ȥ��¼��");
			return "loginFail";
		}
	
	}

	
}
