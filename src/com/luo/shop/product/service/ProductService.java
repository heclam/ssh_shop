package com.luo.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.product.dao.ProductDao;
import com.luo.shop.product.vo.Product;
import com.luo.shop.util.PageBean;
@Transactional
public class ProductService {
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	//����������Ʒ
	public List find_ishostProduct() {
		
		return productDao.find_ishostProduct();
	}
	//����������Ʒ
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}
	//����һ�������cid����ҳ�Ĳ�ѯ��Ʒ
	public PageBean<Product> findByPageCid(Integer cid, int currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setCurrentPage(currentPage);
		//����ÿҳ��ʾ��¼��
		int limit = 6;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		System.out.println(totalCount+"-------------");
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount/limit)
		if(totalCount % limit == 0){
			totalPage = totalCount /limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
			//���Ŀ�ʼ
			int begin = (currentPage-1)*limit;
			
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//���߶����������csid����ҳ�Ĳ�ѯ��Ʒ
	public PageBean<Product> findByPageCsid(Integer csid, int currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setCurrentPage(currentPage);
		//����ÿҳ��ʾ��¼��
		int limit = 6;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
	//	System.out.println(totalCount+"-------------");
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount/limit)
		if(totalCount % limit == 0){
			totalPage = totalCount /limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
			//���Ŀ�ʼ
			int begin = (currentPage-1)*limit;
			
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service�㣬��ҳ��ѯ��Ʒ
	public PageBean<Product> findByPage(Integer currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//ÿҳ��ʾ�ļ�¼��
		int limit = 5;
		pageBean.setLimit(limit);
		//��ȡ�ܼ�¼��
		int totalCount = 0 ;
		totalCount = productDao.findCount();
		//�����ܼ�¼��
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount/limit)
		if(totalCount % limit == 0){
			totalPage = totalCount /limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʼ���±�ֵ
		int begin = (currentPage-1)*limit;
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service�㣬��̨��Ʒ���
	public void add(Product product) {
		productDao.add(product);
	}
	
	//service�㣬��̨����pidɾ����Ʒ
	public void delete(Product product) {
		productDao.delete(product);
	}
	
	//service�㣬������Ʒ
	public void update(Product product) {
		productDao.update(product);
	}


}
