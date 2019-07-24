package com.luo.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.adminuser.vo.AdminUser;

public class AdminUserDao extends HibernateDaoSupport {
	
	//dao�㣺��̨�����û���¼
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ?0 and password = ?1";
		List<AdminUser> list = (List<AdminUser>) this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}
