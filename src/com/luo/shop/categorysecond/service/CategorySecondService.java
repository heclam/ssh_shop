package com.luo.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luo.shop.categorysecond.dao.CategorySecondDao;
import com.luo.shop.categorysecond.vo.CategorySecond;
import com.luo.shop.util.PageBean;
@Transactional
public class CategorySecondService {
	//ע��CategorySecondDao
	private CategorySecondDao categorySecondDao;
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	//��̨������������service����ҳ
	public PageBean<CategorySecond> findByCurrentPage(Integer currentPage) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//���õ�ǰ��ʾ�ĵڼ�ҳ
		pageBean.setCurrentPage(currentPage);
		//����ÿҳ��ʾ������
		int limit = 10;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		Integer totalCount = 0;
		totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		Integer totalPage = 0;
		if(totalCount%limit == 0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�ļ���
		int begin = (currentPage-1)*limit;
		List<CategorySecond> list = categorySecondDao.findByCurrentPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//service�㣺�����������
	public void save(CategorySecond categorySecond) {
			categorySecondDao.save(categorySecond);
	}

	//service�㣬����csid��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
	
	//service�㣬��������
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	//service�㣺�޸Ķ�������
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
	
	//service�㣬��ѯ���еĶ�������
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
}
