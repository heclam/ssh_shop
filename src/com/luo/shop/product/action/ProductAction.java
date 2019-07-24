package com.luo.shop.product.action;

import java.util.List;

import com.luo.shop.category.service.CategoryService;
import com.luo.shop.category.vo.Category;
import com.luo.shop.product.service.ProductService;
import com.luo.shop.product.vo.Product;
import com.luo.shop.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//ʵ��һ��ģ������
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCid() {
		return cid;
	}
	private Integer csid;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	private int currentPage;
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/*
	 * ע��CategoryServicΪ�˲�ѯһ���˵�
	 */
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	/*
	 * ����pid������Ʒ
	 */
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	/*
	 * ����cid��ҳ��ѯ��Ʒ
	 */
	public String findByCid(){
		//���������Ҳ�ǿ��Եģ�����ǰ���Ѿ����һ������˵��˲��Ѿ�����session�����ˣ�����ֱ�Ӵ�session�����ȡ
		//List<Category> cList = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid,currentPage);//����һ�������id��ѯ��Ʒ������ҳ�Ĳ�ѯ
		//��PageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findByCid";
	}
	/*
	 * ����csid��ҳ��ѯ��Ʒ
	 */
	public String findByCsid(){
		PageBean<Product> pageBean = productService.findByPageCsid(csid,currentPage);
		//��PageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findByCsid";
	}
}
