package com.luo.shop.adminuser.service;

import com.luo.shop.adminuser.dao.AdminUserDao;
import com.luo.shop.adminuser.vo.AdminUser;

public class AdminUserService {
	//ע��AdminUserDao
	private AdminUserDao adminUserDao;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//ҵ��ɣ���̨�����û���¼
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
