package jdk.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import bean.Between;

/**
 * <p>名称：User.java</p>
 * <p>描述：测试实体</p>
 *
 * @author 周光暖
 * @date 2014-4-10 下午11:47:37
 * @version 1.0.0
 */
class User {
	@Between
	public String name;
	private Integer age;
	private Double weight;
	private Float height;
	boolean isBoy;
}

/**
 * <p>名称：FieldsDemo.java</p>
 * <p>描述：利用反射，操作字段</p>
 *
 * @author 周光暖
 * @date 2014-4-10 下午11:47:25
 * @version 1.0.0
 */
public class FieldsDemo {
	
	@Test
	public void test1() throws Exception {
		Class clazz = User.class;
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) { 
			String fieldName = field.getName(); //　获得成员变量名
			boolean isAccessible = field.isAccessible(); // 是否可访问
			String toGenericString = field.toGenericString(); // private int test.User.age
			Class fieldType = field.getType(); // 获得成员变量的类型
			Type genericType = field.getGenericType(); // 获得成员变量的类型(带泛型参数,如果有泛型修饰)
			Annotation[] annotation = field.getAnnotations();
			
			System.out.println("fieldName：" + fieldName);
			System.out.println("isAccessible：" + isAccessible);
			System.out.println("toGenericString：" + toGenericString);
			System.out.println("fieldType：" + fieldType);
			System.out.println("genericType：" + genericType);
			System.out.println("annotation：" + Arrays.toString(annotation));
			System.out.println("==================================================");
		}
	}
	
	@Test
	public void test2() throws Exception
	{
		Class clazz = Constant.class;
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) { 
			String fieldName = field.getName(); //　获得成员变量名
			Class fieldType = field.getType(); // 获得成员变量的类型
//			Object value = field.get(fieldName);
			Object value = field.get(fieldName);
			
			
			System.out.println("fieldName：" + fieldName);
			System.out.println("fieldType：" + fieldType);
			System.out.println(fieldName + "：" + value);
			
//			System.out.println("isEnumConstant()：" + field.isEnumConstant());
//			System.out.println("isAccessible()：" + field.isAccessible());
//			System.out.println("isSynthetic()：" + field.isSynthetic());
		}
	}
	
	@Test
	public void testSetParamet() throws Exception {
		Map<String, String> paramet = new HashMap<String, String>();
		paramet.put("name", "singno");
		paramet.put("age", "25");
		paramet.put("weight", "126.5");
		paramet.put("isBoy", "true");
		paramet.put("height", "175.0m");
		
		Set<String> except = new HashSet<String>();
		except.add("weight");
		
		try {
			Object obj = setParamet(User.class, paramet, except);
		} catch (Exception e) {
			System.out.println("--------- 参数类型错误 -----------");
		}
	}
	
	/**
	 * 描述：根据指定参数，获得实体对象
	 *
	 * @param clazz 需要设置属性的类的类型
	 * @param paramet Map<String, String>集合  key：属性名，value：属性值(字符串形式)
	 * @param except 不需要设置属性的 属性名的Set<String>集合
	 * @return Object
	 * @throws Exception 
	 */
	public Object setParamet(Class clazz, Map<String, String> paramet, Set<String> except) throws Exception{
			Object obj = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				if (except.contains(fieldName)) {
					continue;
				}
				if (!paramet.containsKey(fieldName)) {
					continue;
				}
				Class fieldType = field.getType();
				if (String.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, paramet.get(fieldName));
				}
				else if (Byte.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Byte.parseByte(paramet.get(fieldName)));
				}
				else if (Short.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Short.parseShort(paramet.get(fieldName)));
				}
				else if (Long.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Long.parseLong(paramet.get(fieldName)));
				}
				else if (Float.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Float.parseFloat(paramet.get(fieldName)));
				}
				else if (Double.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Double.parseDouble(paramet.get(fieldName)));
				}
				else if (Integer.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Integer.parseInt(paramet.get(fieldName)));
				}
				else if (Boolean.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, Boolean.parseBoolean(paramet.get(fieldName)));
				}
				else if (String.class.equals(fieldType)) 
				{
					field.setAccessible(true);
					field.set(obj, paramet.get(fieldName));
				}
			}
		return obj;
	}
}
