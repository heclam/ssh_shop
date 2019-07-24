package com.luo.shop.category.adminaction;

import java.util.List;
import com.luo.shop.category.service.CategoryService;
import com.luo.shop.category.vo.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台管理一级分类的action
 * @author hy
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	//模型驱动的对象
	private Category category = new Category();
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	//注入CategoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//查询所有的一级分类
	public String findAll(){
		List<Category> clist = categoryService.findAll();
		//存入值栈中
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "findAll";
	}
	//添加一级分类
	public String save(){
		//保存添加的一级分类
		categoryService.save(category);
		//返回信息
		return "saveSuccess";
	}
	
	//删除一级分类
	public String delete(){
		//更具cid查询一级分类
		category = categoryService.findByCid(category.getCid());
		//删除查询到的一级分类
		categoryService.delete(category);
		//页面跳转
		return "deleteSuccess";
	}
	
	//修改一级分类，1.先查询
	public String edit(){
		//根据cid获取到一个Category对象
		category = categoryService.findByCid(category.getCid());
		//返回修改页面
		return "editSuccess";
	}
	//2.更新一级分类
	public String update(){
		categoryService.update(category);
		//页面跳转
		return "updateSuccess";
	}
}
