package com.luo.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	//���ﳵ����
	//key����Ʒ��id��value�ǹ�����
		//ʹ��Mapֻ��Ϊ��ɾ���򵥣�ͨ��keyɾ��������
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer, CartItem>();
	//Ϊ�˱���CartItem�����ṩһ�·���
	//��һ������ΪcartItmes
	public Collection<CartItem> getCartItems(){
		//Map.values���԰�map�е�valueת����һ�����еļ���
		return map.values();
	}
	//�����ܼ�
	private double total;
	public double getTotal() {
		return total;
	}
	//���ﳵ�ķ���
	//1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem){
		//�жϹ��ﳵ���Ƿ��Ѿ����ڹ�����
		/*
		 * �������
		 * 		*��������
		 * 		*�ܼ� = �ܼ�+������С��
		 * ���������
		 * 		*��map����ӹ�����
		 * 		*�ܼ�= �ܼ�+������С��
		 */
		//��ȡ��Ʒid
		Integer pid = cartItem.getProduct().getPid();
		//�жϹ��ﳵ���Ƿ���ڸ���Ʒ
			//ͨ��map�е�pid���ж�
		if(map.containsKey(pid)){
			//����
			CartItem _cartItem = map.get(pid); //���ﳵ��ԭ���Ĺ�����
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			//������
			map.put(pid,cartItem);
		}
		//�����ܼƵ�ֵ
		total +=cartItem.getSubtotal(); 
		
	}
	//2.�ӹ��ﳵ�Ƴ�������
	public void removeCart(Integer pid){
		//���������Ƴ����ﳵ
		CartItem cartItem = map.remove(pid);
		//�ܼ�=�ܼ�-�Ƴ��Ĺ�����С��
		total -= cartItem.getSubtotal();
	}
	//3.��չ��ﳵ
	public void clearCart(){
		//�����й��������
		map.clear();
		//���ܼ�����Ϊ0��
		total = 0;
	}
	
}
