/*
 * @(#)BeanUtils_Test.java 2015-1-28 下午5:37:04
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.beanutils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

import bean.NestedBean;
import bean.SampleBean;

/**
 * <p>File：BeanUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午5:37:04</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
@SuppressWarnings("all")
public class BeanUtils_Test
{
	/**
	 * 获取Bean的普通字段值
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetProperty() throws Exception
	{
		SampleBean bean1 = new SampleBean();
		bean1.setName("rensanning");
		bean1.setAge(31);
		 
		String name = BeanUtils.getProperty(bean1, "name");
		String age  = BeanUtils.getProperty(bean1, "age");
		 
		System.out.println(name);// rensanning
		System.out.println(age);// 31
	}
	
	/**
	 * 获取Bean的数组集合字段值
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetArrayProperty() throws Exception
	{
		SampleBean bean6 = new SampleBean();
		bean6.setArray(new String[]{"a", "b", "c"});
		List<String> list0 = new ArrayList<String>();
		list0.add("d");
		list0.add("e");
		list0.add("f");
		bean6.setList(list0);
		 
		String[] array = BeanUtils.getArrayProperty(bean6, "array");
		 
		System.out.println(array.length);//3
		System.out.println(array[0]);//"a"
		System.out.println(array[1]);//"b"
		System.out.println(array[2]);//"c"
		 
		String[] list = BeanUtils.getArrayProperty(bean6, "list");
		System.out.println(list.length);//3
		System.out.println(list[0]);//"d"
		System.out.println(list[1]);//"e"
		System.out.println(list[2]);//"f"
		 
		System.out.println(BeanUtils.getProperty(bean6, "array[1]"));//"b"
		System.out.println(BeanUtils.getIndexedProperty(bean6, "array", 2));//"c"
	}
	
	/**
	 * 获取Bean的Map字段值
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetMappedProperty() throws Exception
	{
		SampleBean bean7 = new SampleBean();
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		bean7.setMap(map);
		 
		String value1 = BeanUtils.getMappedProperty(bean7, "map", "key1");
		System.out.println(value1);//"value1"
		 
		String value2 = BeanUtils.getMappedProperty(bean7, "map", "key2");
		System.out.println(value2);//"value2"
		 
		System.out.println(BeanUtils.getProperty(bean7, "map.key1"));//"value1"
		System.out.println(BeanUtils.getProperty(bean7, "map.key2"));//"value2"
	}
	
	/**
	 * 获取Bean的嵌套字段值 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetNestedProperty() throws Exception
	{
		SampleBean bean = new SampleBean();
		NestedBean nestedBean = new NestedBean();
		nestedBean.setNestedProperty("xxx");
		bean.setNestedBean(nestedBean);
		 
		String value = BeanUtils.getNestedProperty(bean, "nestedBean.nestedProperty");
		System.out.println(value);//"xxx"
		 
		System.out.println(BeanUtils.getProperty(bean, "nestedBean.nestedProperty"));//"xxx"
	}
	
	/**
	 * 设置字段值 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testSetProperty() throws Exception
	{
		SampleBean bean2 = new SampleBean();
		BeanUtils.setProperty(bean2, "name", "rensanning");
		BeanUtils.setProperty(bean2, "age", 31);
		 
		System.out.println(bean2.getName());
		System.out.println(bean2.getAge());
	}
	
	/**
	 * 克隆beam 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testCloneBean() throws Exception
	{
		SampleBean bean3 = new SampleBean();
		bean3.setName("rensanning");
//		bean3.setAge(31);
//		bean3.setDate(new Date());
//		bean3.setUrl(new URL("http://www.google.com/"));
		
		Map<String, String>	map = new HashMap<String, String>();
		map.put("name", "singo");
		map.put("age", "11");
		bean3.setMap(map);
		 
		SampleBean clone = (SampleBean) BeanUtils.cloneBean(bean3);
//		SampleBean clone2 = ObjectUtils.clone(bean3);// error
		
		System.out.println(clone.getName());
		System.out.println(clone.getAge());
	}
	
	/**
	 * 属性拷贝
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testCopyProperties() throws Exception
	{
		SampleBean orig = new SampleBean();
		orig.setName("rensanning");
		orig.setAge(31);
		
		// 下面两个属性必须赋值？
		orig.setDate(new Date());
		orig.setUrl(new URL("http://www.google.com/"));
		
		SampleBean dest = new SampleBean();
		BeanUtils.copyProperties(dest, orig);// 第一个参数：被赋值的对象，第二个参数：被拷贝属性的对象	
		
		System.out.println(orig.getName());
		System.out.println(orig.getAge());
		
		SampleBean bean = new SampleBean();
		BeanUtils.copyProperty(bean, "name", "singno");
		System.out.println(bean.getName());
	}
	
	/**
	 * 描述对象（Object --> Map）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testDescribe() throws Exception
	{
		SampleBean bean4 = new SampleBean();
		bean4.setName("rensanning");
		bean4.setAge(31);
		 
		Map<String, String> map4 = BeanUtils.describe(bean4);
		 
		System.out.println(map4.get("name"));
		System.out.println(map4.get("age"));
	}
	
	/**
	 * 赋值（Map --> Object）
	 * 注意：
	 * 	map5.put("age", ""); --> age：0
	 *  // map5.put("age", ""); --> age：null
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testPopulate() throws Exception
	{
		SampleBean bean5 = new SampleBean();
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("name", "rensanning");
		map5.put("age", "");
		BeanUtils.populate(bean5, map5);
		 
		System.out.println(bean5.getName());
		System.out.println(bean5.getAge());// 0
		
		SampleBean bean6 = new SampleBean();
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("name", "rensanning");
//		map5.put("age", null);
		BeanUtils.populate(bean6, map6);
		 
		System.out.println(bean6.getName());
		System.out.println(bean6.getAge());// null
	}
	
	/**
	 * URL字段的特殊处理 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testSetURL() throws Exception
	{
		SampleBean bean8 = new SampleBean();
		 
		BeanUtils.setProperty(bean8, "url", "http://www.google.com/");
		 
		URL url = bean8.getUrl();
		System.out.println(url.getProtocol());//"http"
		System.out.println(url.getHost());//"www.google.com"
		System.out.println(url.getPath());//"/"
	}
	
	/**
	 * 日期的转化 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConverter() throws Exception
	{
		SampleBean bean9 = new SampleBean();
		 
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");
		 
		ConvertUtils.register(converter, Date.class);
		ConvertUtils.register(converter, String.class);
		 
		BeanUtils.setProperty(bean9, "date", "2010/12/19 23:40:00");
		 
		String value9 = BeanUtils.getProperty(bean9, "date");
		System.out.println(value9);// 2010/12/19 23:40:00
	}
	
	/**
	 * 配合转换器的使用
	 * ConvertUtils作用：在字符串和指定类型的实例之间进行转换
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConvertUtils() throws Exception
	{
		SampleBean bean9 = new SampleBean();
		BeanUtils.setProperty(bean9, "date", new Date());
		 
		String value9 = BeanUtils.getProperty(bean9, "date");
		System.out.println(value9);// Wed Jan 28 18:29:04 CST 2015
		
		// ====================================================
		// 注册日期转换器
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");
		ConvertUtils.register(converter, String.class);
		
		value9 = BeanUtils.getProperty(bean9, "date");
		System.out.println(value9);// 2015/01/28 18:29:47
	}
}
