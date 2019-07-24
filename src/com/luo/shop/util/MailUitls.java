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
 * �ʼ����͹�����
 * @author hy
 *
 */
public class MailUitls {
	/**
	 * �����ʼ��ķ���
	 * @param to :�ռ���
	 * @param code :������
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.���һ��Session����
		 * 2.����һ��������������Message
		 * 3.�����ʼ�Transport
		 */
		Properties props = new Properties();
		props.setProperty("mail.host","localhost");
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com","111");
			}
		});
		//2.�����ʼ�����
		Message message = new MimeMessage(session);
		//���÷�����
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			message.addRecipient(RecipientType.TO,new InternetAddress(to));
			//����  ����BCC
			//���ñ���
			message.setSubject("���Թ������������̳ǹٷ������ʼ�");
			//��������
			message.setContent("<h1>�������������̳ǹٷ������ʼ�������������ɼ������</h1><h3><a href='http://192.168.17.1:8080/ssh_shopping/user_active.action?code="+code+"'>http://192.168.17.1:8080/ssh_shopping/user_active.action?code="+code+"</a></h3>","text/html;charset=UTF-8");
			//3.�����ʼ�
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���ԣ�(�����Ƿ�ɹ�)
//	public static void main(String[] args) {
//		sendMail("aaa@shop.com","1111111111111");
//	}
}
