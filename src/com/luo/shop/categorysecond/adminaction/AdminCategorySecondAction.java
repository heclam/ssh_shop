package com.luo.shop.categorysecond.adminaction;

import java.util.List;

import com.luo.shop.category.service.CategoryService;
import com.luo.shop.category.vo.Category;
import com.luo.shop.categorysecond.service.CategorySecondService;
import com.luo.shop.categorysecond.vo.CategorySecond;
import com.luo.shop.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨������������action
 * @author hy
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	//ģ�������Ķ���
	private CategorySecond categorySecond = new CategorySecond();
	//ע��CategorySecondService
	private CategorySecondService categorySecondService;
	//����currentPage
	private Integer currentPage;
	//ע��CategoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	//��ѯ�������ࣺ����ҳ
	public String findAll(){
		PageBean<CategorySecond> pageBean = categorySecondService.findByCurrentPage(currentPage);
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findAll";
		
	}
	
	//��Ӷ�������1.���Ƚ���ҳ����ʾһ������
	public String add(){
		//��ѯһ������
		List<Category> cList = categoryService.findAll(); 
		//����ֵջ�б�����ҳ����ʾ
		ActionContext.getContext().getValueStack().set("cList", cList);
		//����ҳ����ת
		return "addSuccess";
	}
	//2.�����ύ�Ķ�����������
	public String save(){
		//System.out.println("csname:"+categorySecond.getCsname()+",csid:"+categorySecond.getCsid()+",cid="+categorySecond.getCategory().getCid());
		categorySecondService.save(categorySecond);
		return "saveSuccess";
		
	}
	
	//���������ɾ��
	public String delete(){
		//�Ȳ�ѯ��Ҫɾ���Ķ���
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//ɾ����������
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//����csid�༭��������
	public String edit(){
		//����csid��ѯ����������
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//��ѯ�����е�һ������
		List<Category> clist = categoryService.findAll();
		//��һ���������ֵջ��
		ActionContext.getContext().getValueStack().set("cList",clist);
		return "editSuccess";
	}
	
	//�޸Ķ�������
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
