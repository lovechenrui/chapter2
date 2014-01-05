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
		//通过类装载器获取car对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.reflect.Car");
		Car car = (Car)clazz.newInstance();
		car.setBrand("12344");
		car.setColor("red");
		car.setMaxSpeed("200");
//		//获取类的默认构造器对象，并通过她实例化car
//		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
//		Car car = (Car)cons.newInstance();
//		
//		//通过反射方法设置属性值 
//		Method setBrand = clazz.getMethod("setBrand", String.class);
//		setBrand.invoke(car,"红旗CA72");
//		Method setColor = clazz.getMethod("setColor",String.class);
//		setColor.invoke(car,"红色");
//		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", String.class);
//		setMaxSpeed.invoke(car,"200");
		return car;
	}
}
