package com.luo.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport {

	public List findAll() {
		String hql = "from Category";
		List<Category> clist = (List<Category>) this.getHibernateTemplate().find(hql);
		return clist;
	}

	//dao�㣺��̨���һ������
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}
	
	//dao�㣺��̨����cid��ѯһ������
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//dao�㣺��̨ɾ��һ������
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	//dao�㣺��̨����һ������
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
