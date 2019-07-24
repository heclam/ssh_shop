package com.luo.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.categorysecond.vo.CategorySecond;
import com.luo.shop.util.PageHibernateCallback;

public class CategorySecondDao extends HibernateDaoSupport {

	//获取二级分类的总记录数
	public Integer findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	//获取当前页显示的集合
	public  List<CategorySecond> findByCurrentPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql,
				null,begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao层：保存二级分类
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}
	
	//dao层，根据csid查询出二级分类
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}
	
	//dao层，删除二级分类
	public void delete(CategorySecond categorySecond) {
			this.getHibernateTemplate().delete(categorySecond);
	}
	
	//dao层，修改二级分类 
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}
	
	//dao层，查询所有的二级分类
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

}
