package com.luo.shop.util;

import java.util.UUID;
/*
 * ���ɼ�����
 */
public class CreateUuid {
	public static String getUuid(){
		//���UUID.randomUUID()������һ���ַ������ַ������������-��,�����滻��
		return UUID.randomUUID().toString().replace("-","");
	}
}
