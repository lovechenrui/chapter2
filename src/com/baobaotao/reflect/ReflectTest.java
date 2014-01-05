package com.baobaotao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Car car = initByDefaultConst();
			car.introduce();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Car initByDefaultConst() throws Throwable{
		//ͨ����װ������ȡcar����
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.reflect.Car");
		Car car = (Car)clazz.newInstance();
		car.setBrand("12344");
		car.setColor("red");
		car.setMaxSpeed("200");
//		//��ȡ���Ĭ�Ϲ��������󣬲�ͨ����ʵ����car
//		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
//		Car car = (Car)cons.newInstance();
//		
//		//ͨ�����䷽����������ֵ 
//		Method setBrand = clazz.getMethod("setBrand", String.class);
//		setBrand.invoke(car,"����CA72");
//		Method setColor = clazz.getMethod("setColor",String.class);
//		setColor.invoke(car,"��ɫ");
//		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", String.class);
//		setMaxSpeed.invoke(car,"200");
		return car;
	}
}
