package jdk.reflection;

import org.junit.Test;

/**
 * <p>名称：InstanceClassDemo.java</p>
 * <p>描述：利用Class实例化对象</p>
 *
 * @author 周光暖
 * @date 2014-4-10 下午11:47:02
 * @version 1.0.0
 */
public class InstanceClassDemo {
	
	/**
	 * 描述：静态方式
	 * 特点:
     * 	1.类的加载跟创建同步进行，不可分离。
     *	2.需要知道类名，通过类名去声明变量，和完成new的动作
     *	3.new的动作实现了类的加载和创建
	 */
	@Test
	public void test1() throws Exception
	{
		String str = new String();
		System.out.println(str.getClass().getSimpleName());
	}
	
	/**
	 * 描述：动态方式
	 * 特点:
     * 	1.类的加载跟创建步骤分离了
     * 	2.可以通过传参的方式，加载指定绝对路径名的类，便返回该类
     *	3.需要实例化该类时，可以随时调用该类的newInstance()方法创建
	 */
	@Test
	public void test2() throws Exception
	{
		String className = "java.lang.String";
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		
		System.out.println(obj.getClass().getSimpleName());
	}
	
	/**
	 * 描述：获得类的字节码
	 *
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception
	{
		// Class的实际对象，代表内存里的一份字节码
		Class clz = String.class;// 方式一
		clz = new String().getClass();// 方式二
		clz = Class.forName("java.lang.String");// 方式三
	}
}
