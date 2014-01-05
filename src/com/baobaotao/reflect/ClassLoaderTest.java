package com.baobaotao.reflect;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader clazz = Thread.currentThread().getContextClassLoader();
		System.out.println("current classLoad: "+clazz);
		System.out.println("parent classLoad: "+clazz.getParent());
		System.out.println("grandparent classLoad: "+clazz.getParent().getParent());
	}

}
