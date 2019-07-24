package com.luo.shop.user.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//����ͼƬ��֤��
public class CheckImgCode extends ActionSupport{
	@Override
	public String execute() throws Exception {
		   //�������ʵ����֤�������
		          BufferedImage bi=new BufferedImage(68, 22,BufferedImage.TYPE_INT_RGB);//����ͼ�񻺳���
		           Graphics g=bi.getGraphics(); //ͨ������������һ������
		           Color c=new Color(200,150,255); //������ɫ
		          /*���ݱ�������һ�����ο�
		            */
		           g.setColor(c);//Ϊ��������������ɫ
		          g.fillRect(0, 0, 68,22); //fillRect:���ָ���ľ���
		          
		          char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();//ת��Ϊ�ַ��͵�����
		         Random r=new Random();
		          int len=ch.length;
		          int index; //index���ڴ���������
		          StringBuffer sb=new StringBuffer();
		         for(int i=0;i<4;i++)
		          {
		              index=r.nextInt(len);//�����������
		              g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));  //������ɫ
		              g.drawString(ch[index]+"",(i*15)+3, 18);//�������Լ����ֵ�λ��
		              sb.append(ch[index]);
		          }
		          ServletActionContext.getRequest().getSession().setAttribute("checkImgCode",sb.toString()); //�����ֱ�����session�У����ں�����ʹ��
		          ImageIO.write(bi, "JPG", ServletActionContext.getResponse().getOutputStream()); 
		return NONE;
	}
}
