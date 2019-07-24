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
	//service层：后台添加一级分类
	public void save(Category category) {
		categoryDao.save(category);
	}
	//service层：后台更具cid查询一级分类
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}
	//service层：后台删除一级分类
	public void delete(Category category) {
		categoryDao.delete(category);
	}
	
	//service层：后台更行一级分类
	public void update(Category category) {
		categoryDao.update(category);
	}

}
