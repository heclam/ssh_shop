package com.luo.shop.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 邮件发送工具类
 * @author hy
 *
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to :收件人
	 * @param code :激活码
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.获得一个Session对象
		 * 2.创建一个代表邮箱对象的Message
		 * 3.发送邮件Transport
		 */
		Properties props = new Properties();
		props.setProperty("mail.host","localhost");
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com","111");
			}
		});
		//2.创建邮件对象
		Message message = new MimeMessage(session);
		//设置发送人
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			message.addRecipient(RecipientType.TO,new InternetAddress(to));
			//抄送  密送BCC
			//设置标题
			message.setSubject("来自购物天堂落落商城官方激活邮件");
			//设置正文
			message.setContent("<h1>购物天堂落落商城官方激活邮件！请点击连接完成激活操作</h1><h3><a href='http://192.168.17.1:8080/ssh_shopping/user_active.action?code="+code+"'>http://192.168.17.1:8080/ssh_shopping/user_active.action?code="+code+"</a></h3>","text/html;charset=UTF-8");
			//3.发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//测试：(测试是否成功)
//	public static void main(String[] args) {
//		sendMail("aaa@shop.com","1111111111111");
//	}
}
