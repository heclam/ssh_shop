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
	//ע��ProductService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public String execute() throws Exception {
		 List<Category> clist = categoryService.findAll();
		 ActionContext.getContext().getSession().put("clist",clist);
		 //�������ŵ���Ʒ
		 List<Product> hlist = productService.find_ishostProduct();
		 ActionContext.getContext().getValueStack().set("hlist",hlist);
		 //����������Ʒ
		 List<Product> nlist = productService.findNew();
		 ActionContext.getContext().getValueStack().set("nlist",nlist);
		return "index";
	}
	//ȥ��ҳ
	public String head(){
		return "head";
	}
}
