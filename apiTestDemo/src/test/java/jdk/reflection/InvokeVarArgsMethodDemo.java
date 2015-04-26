package jdk.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

import javax.lang.model.type.TypeVariable;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

class OOXX{
	@SuppressWarnings(value = { "111" })
	@TestedOn(ints = { 0 })
	public static void main(@TestedOn(ints = { 0 }) String[] args) {
		System.out.println(Arrays.toString(args));
	}
	public static void show1(String ... args){
		System.out.println(Arrays.toString(args));
	}
	public static void show2(int[] args){
		System.out.println(Arrays.toString(args));
	}
	public static void show3(String arg){
		System.out.println(arg);
	}
}

/**
 * <p>名称：InvokeVarArgsMethodDemo.java</p>
 * <p>描述：使用反射调用方法</p>
 * 	     推荐使用 invoke(方法底层对象， new Object[]{ 方法底层需要的实际参数  });
 *
 * @author 周光暖
 * @date 2014-4-10 下午11:50:10
 * @version 1.0.0
 */
public class InvokeVarArgsMethodDemo {

	@Test
	public void test1() throws Exception {
		Class clazz = OOXX.class;
		Method method = clazz.getMethod("show1", String[].class);
//		method.invoke(null, "show1", "show2");//false
//		method.invoke(null, new String[]{"show1", "show2"});
		/**
		 * 由于 invoke() 方法的个别参数会被自动解包
		 * 避免出错，建议使用通用方法，即用 new Object[]{...里面写对应的参数... } 把参数包起来
		 * 
		 */
		method.invoke(null, new Object[]{new String[]{"show1","show2"}});//true
		System.out.println(Arrays.toString(method.getParameterTypes()));
		System.out.println("------------------------");
		
		method = clazz.getMethod("show2", int[].class);
		method.invoke(null, new Object[]{new int[]{1,2,3}});//true
		System.out.println(Arrays.toString(method.getParameterTypes()));
		System.out.println("------------------------");
		
		method = clazz.getMethod("show3", String.class);
		method.invoke(null, new Object[]{"show3"});//true
		System.out.println(Arrays.toString(method.getParameterTypes()));
		System.out.println("------------------------");
		
		method = clazz.getMethod("main", String[].class);
		method.invoke(null, new Object[]{new String[]{"show1", "show4", "show3"}});//true
		// method.getParameterTypes()	获得方法参数的类型数组
		System.out.println(Arrays.toString(method.getParameterTypes()));
		// method.getReturnType()	获得方法的返回类型
		System.out.println(method.getReturnType().equals(void.class));
	}
	
	@Test
	public void bridge () throws Exception {
		
		Class clazz = OOXX.class;
		
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();// 方法名
			Class[] parameterTypes = method.getParameterTypes();// 参数类型数组
			Class returnType = method.getReturnType();// 返回值类型
			
			Annotation[] annotations = method.getAnnotations();// 方法上的注解
			Annotation[][] annotations2 = method.getParameterAnnotations();// 方法参数前的的注解
			Class declaringClass = method.getDeclaringClass();// 声明方法的类
			System.out.println("-----------");
		}
	}
	
}
