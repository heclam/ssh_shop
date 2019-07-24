package com.luo.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.order.dao.OrderDao;
import com.luo.shop.order.vo.Order;
import com.luo.shop.order.vo.OrderItem;
import com.luo.shop.util.PageBean;
@Transactional
public class OrderService {
	//注入orderDao
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	//service层保存订单
	public void save(Order order) {
		orderDao.save(order);
	}
	//我的订单的业务层代码
	public PageBean<Order> findPageByUid(Integer uid, int currentPage) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示的记录数
		Integer limit = 5;
		pageBean.setLimit(limit);
		//设置总记录数
		Integer totalCount = null;
		totalCount = orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		Integer totalPage = null;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的集合
		Integer begin = (currentPage -1)* limit;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//service层更具订单id查询订单
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}
	
	//service完成订单的修改
	public void update(Order currOrder) {
		orderDao.update(currOrder);
	}
	
	//service层,后台分页查询订单
	public PageBean<Order> findByPage(Integer currentPage) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		int limit = 5;
		//设置每页显示的记录数
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount=orderDao.getCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置当前页数的订单集合
		int begin = (currentPage-1)*limit;
		List<Order> list = orderDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service层，后台异步处理根据oid查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}
}
