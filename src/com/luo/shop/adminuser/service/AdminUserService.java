package com.luo.shop.adminuser.service;

import com.luo.shop.adminuser.dao.AdminUserDao;
import com.luo.shop.adminuser.vo.AdminUser;

public class AdminUserService {
	//注入AdminUserDao
	private AdminUserDao adminUserDao;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//业务成：后台管理用户登录
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
