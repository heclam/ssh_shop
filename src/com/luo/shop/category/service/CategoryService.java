package com.luo.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.category.dao.CategoryDao;
import com.luo.shop.category.vo.Category;
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	public List findAll() {
		return categoryDao.findAll();
	}
	//service�㣺��̨���һ������
	public void save(Category category) {
		categoryDao.save(category);
	}
	//service�㣺��̨����cid��ѯһ������
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}
	//service�㣺��̨ɾ��һ������
	public void delete(Category category) {
		categoryDao.delete(category);
	}
	
	//service�㣺��̨����һ������
	public void update(Category category) {
		categoryDao.update(category);
	}

}
