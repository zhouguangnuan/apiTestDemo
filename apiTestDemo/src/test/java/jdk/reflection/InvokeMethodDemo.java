package jdk.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

/**
 * <p>名称：Person.java</p>
 * <p>描述：测试实例</p>
 *
 * @author 周光暖
 * @date 2014-4-10 下午11:51:09
 * @version 1.0.0
 */
class Person {
	public void sayHello(){
		System.out.println("----hello----");
	}
	
	private String sayHello2(String name, Integer time){
		return name + " " + time + "点好！";
	}
}

/**
 * <p>名称：InvokeMethodDemo.java</p>
 * <p>描述：使用反射调用方法</p>
 *
 * @author 周光暖
 * @date 2014-4-10 下午11:51:01
 * @version 1.0.0
 */
public class InvokeMethodDemo {
	
	/**
	 * 1. 得到方法所在类的字节码;	Class对象
	 * 2. 获得sayHello方法;	Method对象
	 * 3. 执行Method所表示的方法(sayHello);
	 */
	private Class<Person> clazz = Person.class;
	private Method method;
	
	@Test
	public void test1() throws Exception{
		/**
		 * 获得公共成员方法
		 * Method method = clazz.getMethod(String name, Class<?>... parameterTypes);
		 * name:	方法名
		 * parameterTypes：	方法调用所需参数的类型
		 */
		method = clazz.getMethod("sayHello");
		/**
		 * method.invoke(Object obj, Object... args);
		 * obj:		方法所属对象
		 * args:	方法调用所需参数
		 */
		method.invoke(clazz.newInstance(), null);
	}
	
	@Test
	public void test2() throws Exception {
		// 获得声明的所有方法
		method = clazz.getDeclaredMethod("sayHello2", String.class, Integer.class);
		//System.out.println(Arrays.toString(method.getDeclaredAnnotations()));
		method.setAccessible(true);
		Object obj = method.invoke(clazz.newInstance(), "singno", 8);
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args)
	{
		for (String arg : args)
		{
			System.out.println("main:" + arg);
		}
	}
	
	/**
	 * 描述：利用反射执行指定类的main方法
	 *
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception
	{
		Class clazz = InvokeMethodDemo.class;
		Method methodMain = clazz.getDeclaredMethod("main", String[].class);
		methodMain.invoke(null, new Object[]{new String[]{"1", "2", "3"}});
	}
	
	/**
	 * 描述：利用反射操作数组
	 *
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception
	{
		printObject(new String[]{"1", "2", "3"});
		printObject("!!!!!");
	}
	
	public void printObject(Object obj){
		Class clazz = obj.getClass();
		if (clazz.isArray())
		{
			for (int i = 0; i < Array.getLength(obj); i++)
			{
				//Array.set(obj, i, i+"!");
				System.out.println(Array.get(obj, i).toString());
			}
		} else {
			System.out.println(obj.toString());
		}
	}
}
