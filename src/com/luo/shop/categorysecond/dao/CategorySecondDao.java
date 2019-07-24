package com.luo.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.categorysecond.vo.CategorySecond;
import com.luo.shop.util.PageHibernateCallback;

public class CategorySecondDao extends HibernateDaoSupport {

	//��ȡ����������ܼ�¼��
	public Integer findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	//��ȡ��ǰҳ��ʾ�ļ���
	public  List<CategorySecond> findByCurrentPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql,
				null,begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao�㣺�����������
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}
	
	//dao�㣬����csid��ѯ����������
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}
	
	//dao�㣬ɾ����������
	public void delete(CategorySecond categorySecond) {
			this.getHibernateTemplate().delete(categorySecond);
	}
	
	//dao�㣬�޸Ķ������� 
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}
	
	//dao�㣬��ѯ���еĶ�������
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

}
