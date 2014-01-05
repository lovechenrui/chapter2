package com.baobaotao.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
	public static void main(String[] args) throws Throwable {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.reflect.PrivateCar");
		PrivateCar privateCar = (PrivateCar)clazz.newInstance();
		
		Field colorFld = clazz.getDeclaredField("color");
		//取消java语言访问检查，以访问private变量
		colorFld.setAccessible(true);
		colorFld.set(privateCar, "红色");
		
		Method method = clazz.getDeclaredMethod("driver",(Class[])null);
		//取消java语言访问检查，以访问protected方法
		method.setAccessible(false);
		method.invoke(privateCar, (Object[])null);
	}

}
