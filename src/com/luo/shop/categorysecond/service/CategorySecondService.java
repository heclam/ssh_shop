package com.luo.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.categorysecond.dao.CategorySecondDao;
import com.luo.shop.categorysecond.vo.CategorySecond;
import com.luo.shop.util.PageBean;
@Transactional
public class CategorySecondService {
	//注入CategorySecondDao
	private CategorySecondDao categorySecondDao;
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	//后台管理二级分类的service带分页
	public PageBean<CategorySecond> findByCurrentPage(Integer currentPage) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//设置当前显示的第几页
		pageBean.setCurrentPage(currentPage);
		//设置每页显示的条数
		int limit = 10;
		pageBean.setLimit(limit);
		//设置总的记录数
		Integer totalCount = 0;
		totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		Integer totalPage = 0;
		if(totalCount%limit == 0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的集合
		int begin = (currentPage-1)*limit;
		List<CategorySecond> list = categorySecondDao.findByCurrentPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service层：保存二级分类
	public void save(CategorySecond categorySecond) {
			categorySecondDao.save(categorySecond);
	}

	//service层，根据csid查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
	
	//service层，二级分类
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	//service层：修改二级分类
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
	
	//service层，查询所有的二级分类
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
}
