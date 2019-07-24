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
 * 后台管理二级分类的action
 * @author hy
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	//模型驱动的对象
	private CategorySecond categorySecond = new CategorySecond();
	//注入CategorySecondService
	private CategorySecondService categorySecondService;
	//接受currentPage
	private Integer currentPage;
	//注入CategoryService
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
	
	//查询二级分类：带分页
	public String findAll(){
		PageBean<CategorySecond> pageBean = categorySecondService.findByCurrentPage(currentPage);
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findAll";
		
	}
	
	//添加二级分类1.首先进行页面显示一级分类
	public String add(){
		//查询一级分类
		List<Category> cList = categoryService.findAll(); 
		//存入值栈中便于在页面显示
		ActionContext.getContext().getValueStack().set("cList", cList);
		//进行页面跳转
		return "addSuccess";
	}
	//2.保存提交的二级分类数据
	public String save(){
		//System.out.println("csname:"+categorySecond.getCsname()+",csid:"+categorySecond.getCsid()+",cid="+categorySecond.getCategory().getCid());
		categorySecondService.save(categorySecond);
		return "saveSuccess";
		
	}
	
	//二级分类的删除
	public String delete(){
		//先查询出要删除的对象
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//删除二级分类
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//根据csid编辑二级分类
	public String edit(){
		//根据csid查询出二级分类
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//查询出所有的一级分类
		List<Category> clist = categoryService.findAll();
		//将一级分类存入值栈中
		ActionContext.getContext().getValueStack().set("cList",clist);
		return "editSuccess";
	}
	
	//修改二级分类
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
