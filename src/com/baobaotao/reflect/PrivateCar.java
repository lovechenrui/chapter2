package com.baobaotao.reflect;

public class PrivateCar {
	//private 成员变量，使用传统的类实例只能在本类中访问
	private String color;
	//protected 方法，使用传统的类实例调用方法，只能在子类或者本包中访问
	protected void driver(){
		System.out.println("driver privateCar the color is "+color);
	};
	
}
