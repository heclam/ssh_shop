package com.luo.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.order.vo.Order;
import com.luo.shop.order.vo.OrderItem;
import com.luo.shop.util.PageHibernateCallback;

import net.bytebuddy.asm.Advice.This;

public class OrderDao extends HibernateDaoSupport {
	//dao层保存订单
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}
	//Dao层的我的订单的个数统计
	public Integer findByCountUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.id = ?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		String hql = "from Order o where o.user.uid=?0 order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,
				new Object[]{uid},begin,limit));
		return list;
	}
	//dao层更具订单id查询订单
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}
	
	//dao层完成订单的修改
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}
	
	//ddao层，后台获取订单总记录数
	public int getCount() {
		String hql = "select count(*) from Order";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//dao层，后台获取当前页的订单集合
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,null,begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao层，后台异步处理根据oid查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql ="from OrderItem oi where oi.order.oid=?0";
		List<OrderItem> list = (List<OrderItem>) this.getHibernateTemplate().find(hql, oid);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	
	

}
