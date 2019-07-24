package com.luo.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.user.dao.UserDao;
import com.luo.shop.user.vo.User;
import com.luo.shop.util.CreateUuid;
import com.luo.shop.util.MailUitls;
//����ע��
@Transactional
public class UserService {
	//ע��UserDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//���û�����ѯ�û��ķ���
	public User findByUserName(String username){
		return userDao.findByUsername(username);
	}

	public void save(User user) {
		user.setState(0); //0����δ���1�����Ѽ���
		//һ�±�ʾע����
		String code = CreateUuid.getUuid()+CreateUuid.getUuid();
		user.setCode(code);
		//��������
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
