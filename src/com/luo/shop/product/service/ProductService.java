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
	//查找热门商品
	public List find_ishostProduct() {
		
		return productDao.find_ishostProduct();
	}
	//查找最新商品
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}
	//根具一级分类的cid带分页的查询商品
	public PageBean<Product> findByPageCid(Integer cid, int currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示记录数
		int limit = 6;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		System.out.println(totalCount+"-------------");
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		//Math.ceil(totalCount/limit)
		if(totalCount % limit == 0){
			totalPage = totalCount /limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
			//从哪开始
			int begin = (currentPage-1)*limit;
			
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//根具二级级分类的csid带分页的查询商品
	public PageBean<Product> findByPageCsid(Integer csid, int currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setCurrentPage(currentPage);
		//设置每页显示记录数
		int limit = 6;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
	//	System.out.println(totalCount+"-------------");
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		//Math.ceil(totalCount/limit)
		if(totalCount % limit == 0){
			totalPage = totalCount /limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
			//从哪开始
			int begin = (currentPage-1)*limit;
			
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service层，分页查询商品
	public PageBean<Product> findByPage(Integer currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		//每页显示的记录数
		int limit = 5;
		pageBean.setLimit(limit);
		//获取总记录数
		int totalCount = 0 ;
		totalCount = productDao.findCount();
		//设置总记录数
		pageBean.setTotalCount(totalCount);
		//计算总页数
		int totalPage = 0;
		//Math.ceil(totalCount/limit)
		if(totalCount % limit == 0){
			totalPage = totalCount /limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//计算每页开始的下标值
		int begin = (currentPage-1)*limit;
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service层，后台商品添加
	public void add(Product product) {
		productDao.add(product);
	}
	
	//service层，后台根据pid删除商品
	public void delete(Product product) {
		productDao.delete(product);
	}
	
	//service层，更新商品
	public void update(Product product) {
		productDao.update(product);
	}


}
