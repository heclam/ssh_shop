package com.luo.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.user.dao.UserDao;
import com.luo.shop.user.vo.User;
import com.luo.shop.util.CreateUuid;
import com.luo.shop.util.MailUitls;
//事务注解
@Transactional
public class UserService {
	//注入UserDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//按用户名查询用户的方法
	public User findByUserName(String username){
		return userDao.findByUsername(username);
	}

	public void save(User user) {
		user.setState(0); //0代表未激活，1代表已激活
		//一下表示注册码
		String code = CreateUuid.getUuid()+CreateUuid.getUuid();
		user.setCode(code);
		//发送邮箱
		MailUitls.sendMail(user.getEmail(), code);
		userDao.save(user);
	}

	public User findUserBYCode(String code) {
		return userDao.findUserByCode(code);
	}

	public void updateUser(User user) {
		 userDao.updateUser(user);
		
	}

	public User login(User user) {
		return userDao.login(user);
	}
}
