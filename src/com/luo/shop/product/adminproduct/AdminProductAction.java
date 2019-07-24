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
 * ��̨��Ʒ����
 * @author hy
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	//ģ������
	private Product product = new Product();
	//ע��productService
	private ProductService productService;
	//����currentPage
	private Integer currentPage;
	//ע��categorySecondService
	private CategorySecondService categorySecondService;
	
	//�ļ��ϴ�
	private File upload;//�ϴ����ļ�
	private String uploadFileName;//�ļ��ϴ�������
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
	
	//��̨��ѯ������Ʒ
	public String findAll(){
		PageBean<Product> pageBean = productService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��ת����Ʒ���ҳ��
	public String addPage(){
		//1.��ȡ���еĶ�������
		List<CategorySecond> list = categorySecondService.findAll();
			//����ѯ���Ķ����������ֵջ��
		ActionContext.getContext().getValueStack().set("cList",list);
		//2.��ת�����ҳ��
		return "addPageSuccess";
	}
	
	//��̨��Ʒ���
	public String add() throws IOException{
	//	System.out.println("���������id:"+product.getCategorySecond().getCsid());
		//����ʱ��
		product.setPdate(new Date());
		if(upload != null){
			//��ȡҪ��ŵ��ļ��ĵ�ַ
			String repath = ServletActionContext.getServletContext().getRealPath("/images");
			//����һ���ļ�
			File diskFile = new File(repath+"//"+uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			product.setImage("images/"+uploadFileName);
		}
		productService.add(product);
		return "addSuccess";
	}
	
	//��̨����pidɾ����Ʒ
	public String delete(){
		//����pid��ѯ��Ʒ
		product = productService.findByPid(product.getPid());
		//ɾ����Ƭ
		String img = product.getImage();
		if(img != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+img);
			File file = new File(realPath);
			file.delete();
		}
		//ɾ����Ʒ
		productService.delete(product);
		//ҳ����ת
		return "deleteSuccess";
	}
	
	//����pid��ѯ��Ʒ������ת���޸�ҳ��
	public String edit(){
		//����id��ѯ����Ʒ
		product = productService.findByPid(product.getPid());
		//��ѯ�����еĶ�������
		List<CategorySecond> list = categorySecondService.findAll();
		//����������ļ��ϴ���ֵջ��
		ActionContext.getContext().getValueStack().set("cList", list);
		//ҳ����ת����Ʒ�޸�ҳ��
		return "editSuccess";
	}
	
	//�޸���Ʒ
	public String update() throws IOException{
		//������������
		product.setPdate(new Date());
		if(upload != null){
			//��ʾҪ������Ƭ
			//1.��ɾ����ǰ�ϴ�����Ƭ
			String oldName = product.getImage();
			if(oldName != null){
				String oldPath = ServletActionContext.getServletContext().getRealPath("/"+oldName);
				File file = new File(oldPath);
				file.delete();
			}
			//2.�ϴ��µ���Ƭ
			String filePath = ServletActionContext.getServletContext().getRealPath("/images");
			File newimg = new File(filePath+"//"+uploadFileName);
			FileUtils.copyFile(upload, newimg);
			product.setImage("images/"+uploadFileName);
		}
		productService.update(product);
		return "updateSuccess";
	}
}
