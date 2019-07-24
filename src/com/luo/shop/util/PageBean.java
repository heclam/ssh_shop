package com.luo.shop.util;

import java.util.List;
/**
 * 分页类的封装
 * @author hy
 *分页需要知道的是： 当前页，总记录数，每页的记录数
 */
public class PageBean<T> {
	private int currentPage; //当前页
	private int totalCount; //总记录数
	private int totalPage; //总页数
	private int limit; //每页显示的记录数
	private List<T> list;  //每页显示数据的集合
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
