package com.luo.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.luo.shop.product.vo.Product;
import com.luo.shop.util.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport {
	//首页上页面商品的查询
	public List<Product> find_ishostProduct() {
		//使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//查询热门的商品，条件就是is_host=1
		criteria.add(Restrictions.eq("is_host",1));
		//倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询：
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,8);
		return list;
	}
	//查找最新的商品
	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0,6);
		return list;
	}
	//根据pid查找商品
	public Product findByPid(Integer pid) {
		Product product = this.getHibernateTemplate().get(Product.class, pid);
		return product;
	}
	//根据一级分类cid查询商品的个数
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid=?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//根据一级分类cid查询商品的集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?0";
		//分页的方法：一种是离线型写法
		//分页的另一种写法
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{cid},begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	//根据二级分类csid查询商品的个数
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid=?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,csid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//根据二级分类csid查询商品的集合
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?0";
		//分页的方法：一种是离线型写法
		//分页的另一种写法
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{csid},begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao层，获取商品的中也属
	public int findCount() {
		String hql ="select count(*) from Product";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//dao层，获取分页的商品集合
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,null,begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao层商品添加
	public void add(Product product) {
		this.getHibernateTemplate().save(product);
	}
	
	//doa层，商品删除
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	
	//dao层，更新商品
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
