package com.luo.shop.product.adminproduct;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.luo.shop.categorysecond.service.CategorySecondService;
import com.luo.shop.categorysecond.vo.CategorySecond;
import com.luo.shop.product.service.ProductService;
import com.luo.shop.product.vo.Product;
import com.luo.shop.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import antlr.Utils;
/**
 * 后台商品管理
 * @author hy
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	//模型驱动
	private Product product = new Product();
	//注入productService
	private ProductService productService;
	//接受currentPage
	private Integer currentPage;
	//注入categorySecondService
	private CategorySecondService categorySecondService;
	
	//文件上传
	private File upload;//上传的文件
	private String uploadFileName;//文件上传的名称
	private String uploadContextType;
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	//后台查询所有商品
	public String findAll(){
		PageBean<Product> pageBean = productService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//跳转到商品添加页面
	public String addPage(){
		//1.获取所有的二级分类
		List<CategorySecond> list = categorySecondService.findAll();
			//将查询到的二级分类存入值栈中
		ActionContext.getContext().getValueStack().set("cList",list);
		//2.跳转到添加页面
		return "addPageSuccess";
	}
	
	//后台商品添加
	public String add() throws IOException{
	//	System.out.println("二级分类的id:"+product.getCategorySecond().getCsid());
		//设置时间
		product.setPdate(new Date());
		if(upload != null){
			//获取要存放的文件的地址
			String repath = ServletActionContext.getServletContext().getRealPath("/images");
			//创建一个文件
			File diskFile = new File(repath+"//"+uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			product.setImage("images/"+uploadFileName);
		}
		productService.add(product);
		return "addSuccess";
	}
	
	//后台根据pid删除商品
	public String delete(){
		//根据pid查询商品
		product = productService.findByPid(product.getPid());
		//删除照片
		String img = product.getImage();
		if(img != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+img);
			File file = new File(realPath);
			file.delete();
		}
		//删除商品
		productService.delete(product);
		//页面跳转
		return "deleteSuccess";
	}
	
	//根据pid查询商品，并跳转到修改页面
	public String edit(){
		//根据id查询出商品
		product = productService.findByPid(product.getPid());
		//查询出所有的二级分类
		List<CategorySecond> list = categorySecondService.findAll();
		//将二级分类的集合存入值栈中
		ActionContext.getContext().getValueStack().set("cList", list);
		//页面跳转到商品修改页面
		return "editSuccess";
	}
	
	//修改商品
	public String update() throws IOException{
		//从新设置日期
		product.setPdate(new Date());
		if(upload != null){
			//表示要更改照片
			//1.先删除以前上传的照片
			String oldName = product.getImage();
			if(oldName != null){
				String oldPath = ServletActionContext.getServletContext().getRealPath("/"+oldName);
				File file = new File(oldPath);
				file.delete();
			}
			//2.上传新的照片
			String filePath = ServletActionContext.getServletContext().getRealPath("/images");
			File newimg = new File(filePath+"//"+uploadFileName);
			FileUtils.copyFile(upload, newimg);
			product.setImage("images/"+uploadFileName);
		}
		productService.update(product);
		return "updateSuccess";
	}
}
