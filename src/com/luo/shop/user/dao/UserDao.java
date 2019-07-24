package com.luo.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.user.vo.User;

import net.bytebuddy.asm.Advice.This;
//需要注入一个sessionFactory
public class UserDao extends HibernateDaoSupport {
	//按照名称查询是否有该用户
	public User findByUsername(String username){
		List<User> list =(List<User>) this.getHibernateTemplate().find("from User where username=?0",username);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	public User findUserByCode(String code) {
		String hql = "from User where code=?0";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql,code);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	/*
	 * 根据传进来的用户查询是否有该用户
	 */
	public User login(User user) {
		String hql = "from User where username=?0 and password=?1 and state=?2";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
