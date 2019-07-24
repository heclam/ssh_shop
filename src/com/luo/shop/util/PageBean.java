package com.luo.shop.util;

import java.util.List;
/**
 * ��ҳ��ķ�װ
 * @author hy
 *��ҳ��Ҫ֪�����ǣ� ��ǰҳ���ܼ�¼����ÿҳ�ļ�¼��
 */
public class PageBean<T> {
	private int currentPage; //��ǰҳ
	private int totalCount; //�ܼ�¼��
	private int totalPage; //��ҳ��
	private int limit; //ÿҳ��ʾ�ļ�¼��
	private List<T> list;  //ÿҳ��ʾ���ݵļ���
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
