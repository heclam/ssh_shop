package com.luo.shop.category.adminaction;

import java.util.List;
import com.luo.shop.category.service.CategoryService;
import com.luo.shop.category.vo.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨����һ�������action
 * @author hy
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	//ģ�������Ķ���
	private Category category = new Category();
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	//ע��CategoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//��ѯ���е�һ������
	public String findAll(){
		List<Category> clist = categoryService.findAll();
		//����ֵջ��
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "findAll";
	}
	//���һ������
	public String save(){
		//������ӵ�һ������
		categoryService.save(category);
		//������Ϣ
		return "saveSuccess";
	}
	
	//ɾ��һ������
	public String delete(){
		//����cid��ѯһ������
		category = categoryService.findByCid(category.getCid());
		//ɾ����ѯ����һ������
		categoryService.delete(category);
		//ҳ����ת
		return "deleteSuccess";
	}
	
	//�޸�һ�����࣬1.�Ȳ�ѯ
	public String edit(){
		//����cid��ȡ��һ��Category����
		category = categoryService.findByCid(category.getCid());
		//�����޸�ҳ��
		return "editSuccess";
	}
	//2.����һ������
	public String update(){
		categoryService.update(category);
		//ҳ����ת
		return "updateSuccess";
	}
}
