package com.luo.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.luo.shop.order.vo.Order;
import com.luo.shop.order.vo.OrderItem;
import com.luo.shop.util.PageHibernateCallback;

import net.bytebuddy.asm.Advice.This;

public class OrderDao extends HibernateDaoSupport {
	//dao�㱣�涩��
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}
	//Dao����ҵĶ����ĸ���ͳ��
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
	//dao����߶���id��ѯ����
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}
	
	//dao����ɶ������޸�
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}
	
	//ddao�㣬��̨��ȡ�����ܼ�¼��
	public int getCount() {
		String hql = "select count(*) from Order";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//dao�㣬��̨��ȡ��ǰҳ�Ķ�������
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,null,begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//dao�㣬��̨�첽�������oid��ѯ������
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql ="from OrderItem oi where oi.order.oid=?0";
		List<OrderItem> list = (List<OrderItem>) this.getHibernateTemplate().find(hql, oid);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	
	
	

}
