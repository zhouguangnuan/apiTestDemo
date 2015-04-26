package jdk.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

class Box{
	public String name;
	public Map<String, Object> map = new HashMap();
}
/**
 * <p>名称：GenericFieldsDemo.java</p>
 * <p>描述：利用反射，操作泛型修饰的字段</p>
 *
 * @author 周光暖
 * @date 2014-4-16 下午09:05:44
 * @version 1.0.0
 */
public class GenericFieldsDemo
{
	@Test
	public void test1() throws Exception
	{
		Class clz = Box.class;
		Field field = clz.getField("name");
		Class type = field.getType();
		System.out.println(type);// class java.lang.String
		System.out.println("-----------------------------------------------");
		type = clz.getField("map").getType();
		System.out.println(type);// interface java.util.Map
		System.out.println("-----------------------------------------------");
		Type type2 = clz.getField("map").getGenericType();
		System.out.println(type2);// java.util.Map<java.lang.String, java.lang.Object>
		
		// 获取 泛型参数
		ParameterizedType pType = (ParameterizedType) type2;
		Type[] types = pType.getActualTypeArguments();
		System.out.println(Arrays.toString(types));
		// [class java.lang.String, class java.lang.Object]
		
		
		Type t1 = pType.getOwnerType();
		System.out.println(t1);// null
		Type t2 = pType.getRawType();
		System.out.println(t2);// interface java.util.Map
		
	}
}
