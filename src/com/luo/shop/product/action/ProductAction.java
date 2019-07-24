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
//实现一个模型驱动
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
	 * 注入CategoryServic为了查询一级菜单
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
	 * 根据pid查找商品
	 */
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	/*
	 * 根据cid分页查询商品
	 */
	public String findByCid(){
		//用下面这个也是可以的，不过前面已经查过一级分类菜单了并已经存在session里面了，可以直接从session里面获取
		//List<Category> cList = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid,currentPage);//根据一级分类的id查询商品，带分页的查询
		//将PageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findByCid";
	}
	/*
	 * 根据csid分页查询商品
	 */
	public String findByCsid(){
		PageBean<Product> pageBean = productService.findByPageCsid(csid,currentPage);
		//将PageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findByCsid";
	}
}
