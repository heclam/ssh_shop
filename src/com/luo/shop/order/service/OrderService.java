package com.luo.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.order.dao.OrderDao;
import com.luo.shop.order.vo.Order;
import com.luo.shop.order.vo.OrderItem;
import com.luo.shop.util.PageBean;
@Transactional
public class OrderService {
	//ע��orderDao
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	//service�㱣�涩��
	public void save(Order order) {
		orderDao.save(order);
	}
	//�ҵĶ�����ҵ������
	public PageBean<Order> findPageByUid(Integer uid, int currentPage) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//���õ�ǰ��
		pageBean.setCurrentPage(currentPage);
		//����ÿҳ��ʾ�ļ�¼��
		Integer limit = 5;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		Integer totalCount = null;
		totalCount = orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		Integer totalPage = null;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�ļ���
		Integer begin = (currentPage -1)* limit;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//service����߶���id��ѯ����
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}
	
	//service��ɶ������޸�
	public void update(Order currOrder) {
		orderDao.update(currOrder);
	}
	
	//service��,��̨��ҳ��ѯ����
	public PageBean<Order> findByPage(Integer currentPage) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		int limit = 5;
		//����ÿҳ��ʾ�ļ�¼��
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount=orderDao.getCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//���õ�ǰҳ���Ķ�������
		int begin = (currentPage-1)*limit;
		List<Order> list = orderDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service�㣬��̨�첽�������oid��ѯ������
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}
}
