package com.baobaotao.reflect;

public class PrivateCar {
	//private ��Ա������ʹ�ô�ͳ����ʵ��ֻ���ڱ����з���
	private String color;
	//protected ������ʹ�ô�ͳ����ʵ�����÷�����ֻ����������߱����з���
	protected void driver(){
		System.out.println("driver privateCar the color is "+color);
	};
	
}
