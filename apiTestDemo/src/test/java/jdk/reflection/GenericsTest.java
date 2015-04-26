package jdk.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


class a<String,Object,T>{
	
}

/** 测试用的Bean */
class Bean<List, T, S>{
	private Map<Map<String, Integer>, Object> map = new HashMap();
	
	public <T>T get(T o){
		return o;
	}
	
	public Map<Object, T> get2(Map<Object, T> m){
		return m;
	}
}



/**
 *  概念：
 *  	泛型 ：泛指的类型，也是类型 ，当对其具体指明类型时(即赋值)，便可使用 
 *  		如：声明一个对象变量、实例化一个对象、通过声明的对象变量调用对象的方法
 *  
 *  	Class：属于类
 * 
 *  声明的语法：<T> T 泛型变量
 *  赋值的语法：<String> 传入具体类型
 *  
 *  泛型参数的声明：
 * 	1.在类上声明
 * 		Class className<T> {}，表示 声明一个名为 className且带有T泛型(类型)参数的类
 * 		可以直接声明
 * 		类上声明了的泛型参数变量，在类里可以直接使用
 * 		在使用带泛型参数的类时，需要为参数赋值
 * 		如  Class xxxClass extends ClassName<T> .... 时，需要
 * 			 Class xxxClass extends ClassName<Object> ... 为参数赋值 Object，或者
 * 			 Class xxxClass<T> extends ClassName<T> ... 在构建类时传递一个泛型参数
 * 
 * 	2.在方法上声明	
 * 		public <T> T getBean(Class<T> t){return t.newInstance();}
 * 		如果该方法所在类上没有声明过此泛型参数变量，需要在方法参数里传入该变量，对其进行赋值，否则编译错误
 */		

/**
 * <p>名称：GenericsTest.java</p>
 * <p>描述：测试泛型的相关应用</p>
 *
 * @author 周光暖
 * @date 2014-4-16 下午09:08:05
 * @version 1.0.0
 */
public class GenericsTest 
{
	/** 描述：获得泛型参数 */
	@Test
	public void test1() throws Exception
	{
		Class clz = Bean.class;
		// 获得类的泛型参数
		TypeVariable[] ts1 = clz.getTypeParameters();
		System.out.println(Arrays.toString(ts1));// [List, T, S]
		
		// 获得属性的泛型参数
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields)
		{
			Class c = field.getType();// 参数类型
			Type c2 = field.getGenericType();// 带泛型参数的参数类型
			System.out.println("c：" + c);
			System.out.println("c2：" + c2);
			ParameterizedType pT = (ParameterizedType)c2;// 将带泛型参数的类强转成 参数化类型
			Type[] tps = pT.getActualTypeArguments();
			System.out.println("tps：" + Arrays.toString(tps));
			
			/**
			 * 返回 Type 对象，表示此类型是其成员之一的类型。例如，如果此类型为 O<T>.I<S>，则返回 O<T> 的表示形式。 
			 * 如果此类型为顶层类型，则返回 null。 
			 */
			Type tp = pT.getOwnerType();// null
			System.out.println(tp);
			tp = pT.getRawType();// interface java.util.Map 声明此类型的类或接口
			System.out.println(tp);
			
			pT = (ParameterizedType) tps[0];
			System.out.println(pT);
			tp = pT.getOwnerType();
			System.out.println(tp);
		}
		
		// 获得方法的泛型参数
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods)
		{
			System.out.println("method：" + method.getName());
			Class[] clzs = method.getParameterTypes();// 获得方法参数
			for (Class c : clzs)
			{
				System.out.println("c：" + c);
			}
			
			TypeVariable<Method>[] tVs = method.getTypeParameters();
			for (TypeVariable<Method> tV : tVs)
			{
				System.out.println("tV：" + tV);
			}
		}
	}
}



















