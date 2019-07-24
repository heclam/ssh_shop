package com.luo.shop.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import com.luo.shop.category.vo.Category;
import com.luo.shop.product.vo.Product;
/*
 * 二级分类的实体类
 */
public class CategorySecond {
	private Integer csid;
	private String csname;
	private Category category;
	private Set<Product> products = new HashSet<Product>();
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
