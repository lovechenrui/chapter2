package com.baobaotao.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
	public static void main(String[] args) throws Throwable {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.reflect.PrivateCar");
		PrivateCar privateCar = (PrivateCar)clazz.newInstance();
		
		Field colorFld = clazz.getDeclaredField("color");
		//ȡ��java���Է��ʼ�飬�Է���private����
		colorFld.setAccessible(true);
		colorFld.set(privateCar, "��ɫ");
		
		Method method = clazz.getDeclaredMethod("driver",(Class[])null);
		//ȡ��java���Է��ʼ�飬�Է���protected����
		method.setAccessible(false);
		method.invoke(privateCar, (Object[])null);
	}

}
