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

	//dao层：后台添加一级分类
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}
	
	//dao层：后台根据cid查询一级分类
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//dao层：后台删除一级分类
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	//dao层：后台更新一级分类
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
