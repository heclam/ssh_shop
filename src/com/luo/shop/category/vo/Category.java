package com.luo.shop.category.vo;

import java.util.HashSet;
import java.util.Set;

import com.luo.shop.categorysecond.vo.CategorySecond;

/*
 * 一级菜单的实体类
 */
public class Category {
	private Integer cid;
	private String cname;
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
	
}
