package com.luo.shop.util;

import java.util.UUID;
/*
 * 生成激活码
 */
public class CreateUuid {
	public static String getUuid(){
		//这个UUID.randomUUID()会生成一个字符串，字符串里面包含‘-’,所以替换掉
		return UUID.randomUUID().toString().replace("-","");
	}
}
