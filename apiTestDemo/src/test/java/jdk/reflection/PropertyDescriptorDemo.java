package jdk.reflection;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;


/**
 * <p>名称：PropertyDescriptorDemo.java</p>
 * <p>描述：测试属性描述类的用法</p>
 *
 * @author 周光暖
 * @date 2014-4-22 下午09:31:15
 * @version 1.0.0
 */
public class PropertyDescriptorDemo
{
	@Test
	public void test1() throws Exception
	{
		Person2 person = new Person2(10, "周光暖");
		String propertyName = "age";
		/**
		 * 通过 
		 * String：属性名称
		 * Class<?>：属性所属类
		 * 获得 PropertyDescriptor 属性描述符 对象
		 */
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, person.getClass());
		Method methodGetAge = pd.getReadMethod();
		System.out.println(methodGetAge.invoke(person, null));
		Method methodSetAge = pd.getWriteMethod();
		methodSetAge.invoke(person, 12);
		System.out.println(methodGetAge.invoke(person, null));
	}
	
	@Test
	public void test2() throws Exception
	{
		Person2 person = new Person2(10, "周光暖");
		String propertyName = "age";
		BeanInfo beanInfo = Introspector.getBeanInfo(person.getClass()); 
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		Object retVal = null;
		for (PropertyDescriptor pd : pds)
		{
			if (pd.getDisplayName().equals(propertyName))
			{
				retVal = pd.getReadMethod().invoke(person);
				break;
			}
		}
		System.out.println(retVal);
	}
	
	/**
	 * 描述：对BeanUtils的基础应用
	 *
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception
	{
//		Person2 person = new Person2(10, "周光暖");
//		String propertyName = "age";
//
//		Object retVal = BeanUtils.getProperty(person, propertyName);
//		System.out.println(retVal);
//		
//		// 会自动类型转换
//		BeanUtils.setProperty(person, propertyName, "11");
//		retVal = BeanUtils.getProperty(person, propertyName);
//		System.out.println(retVal);
//		
//		// 不做类型转换
//		PropertyUtils.setProperty(person, "age", 12);
//		retVal = PropertyUtils.getProperty(person, "age");
//		System.out.println(retVal);
	}
}
