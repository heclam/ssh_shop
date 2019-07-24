package com.luo.shop.index.action;

import java.util.List;

import com.luo.shop.category.service.CategoryService;
import com.luo.shop.category.vo.Category;
import com.luo.shop.product.service.ProductService;
import com.luo.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//注入ProductService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public String execute() throws Exception {
		 List<Category> clist = categoryService.findAll();
		 ActionContext.getContext().getSession().put("clist",clist);
		 //查找热门的商品
		 List<Product> hlist = productService.find_ishostProduct();
		 ActionContext.getContext().getValueStack().set("hlist",hlist);
		 //查找最新商品
		 List<Product> nlist = productService.findNew();
		 ActionContext.getContext().getValueStack().set("nlist",nlist);
		return "index";
	}
	//去首页
	public String head(){
		return "head";
	}
}
