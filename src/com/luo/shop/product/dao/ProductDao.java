package com.luo.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.luo.shop.product.vo.Product;
import com.luo.shop.util.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport {
	//��ҳ��ҳ����Ʒ�Ĳ�ѯ
	public List<Product> find_ishostProduct() {
		//ʹ������������ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//��ѯ���ŵ���Ʒ����������is_host=1
		criteria.add(Restrictions.eq("is_host",1));
		//�����������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ��
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,8);
		return list;
	}
	//�������µ���Ʒ
	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0,6);
		return list;
	}
	//����pid������Ʒ
	public Product findByPid(Integer pid) {
		Product product = this.getHibernateTemplate().get(Product.class, pid);
		return product;
	}
	//����һ������cid��ѯ��Ʒ�ĸ���
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid=?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//����һ������cid��ѯ��Ʒ�ļ���
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?0";
		//��ҳ�ķ�����һ����������д��
		//��ҳ����һ��д��
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{cid},begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	//���ݶ�������csid��ѯ��Ʒ�ĸ���
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid=?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,csid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//���ݶ�������csid��ѯ��Ʒ�ļ���
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?0";
		//��ҳ�ķ�����һ����������д��
		//��ҳ����һ��д��
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{csid},begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao�㣬��ȡ��Ʒ����Ҳ��
	public int findCount() {
		String hql ="select count(*) from Product";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//dao�㣬��ȡ��ҳ����Ʒ����
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,null,begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao����Ʒ���
	public void add(Product product) {
		this.getHibernateTemplate().save(product);
	}
	
	//doa�㣬��Ʒɾ��
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	
	//dao�㣬������Ʒ
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
