/*
 * @(#)ConvertUtils_Test.java 2015-1-28 下午6:47:05
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.beanutils;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

/**
 * <p>File：ConvertUtils_Test.java</p>
 * <p>Title: 在字符串和指定类型的实例之间进行转换</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午6:47:05</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class ConvertUtils_Test
{
	Object obj;
	String str;
	
	/**
	 * Object --> String
	 * 将任何类型对象转为字符串（可以注册转换器，控制输出格式）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConvert1() throws Exception
	{
		Object obj;
		String str;
		
		// 将任何类型对象转为字符串
		obj = "456.2";
		str = ConvertUtils.convert(obj);  
		System.out.println(str);// 456.2
		
		obj = 456.2;
		str = ConvertUtils.convert(obj);  
		System.out.println(str);// 456.2
		
		obj = new Date();
		str = ConvertUtils.convert(obj);  
		System.out.println(str);// Wed Jan 28 18:55:36 CST 2015
        
		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");// 设置模式
		ConvertUtils.register(converter, String.class);// 注册转换器，第二个参数：转换后的类型
        str = ConvertUtils.convert(obj);  
        System.out.println(str);// 2015/01/28 19:12:17
	}
	
	/**
	 * String --> Object
	 * 将字符串转换为指定类型的对象（默认可以使用基本类型，特殊类型需要注册转换器）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConvert2() throws Exception
	{
		str = "123";
        obj = ConvertUtils.convert(str, Integer.class);  
        Integer i= (Integer)obj;  
        System.out.println(i);// 123
        
        str = "true";
        obj = ConvertUtils.convert(str, Boolean.class);  
        Boolean b= (Boolean)obj;  
        System.out.println(b);// true
        
//        str = "2015/09/11 09:12:00";
//        obj = ConvertUtils.convert(str, Date.class);  
//        System.out.println(obj);// error
        
        DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");// 设置模式
		ConvertUtils.register(converter, Date.class);// 注册转换器，第二个参数：转换后的类型
        str = "2015/09/11 09:12:00";
        obj = ConvertUtils.convert(str, Date.class);  
        System.out.println(obj);// Fri Sep 11 09:12:00 CST 2015
	}
	
	/**
	 * String[] --> Object[]
	 * 将字符串数组转换为指定类型的对象数组
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConvert3() throws Exception
	{
		// 第二个参数指定数组对象class
        String[] strs  = new String[]{"11", "22", "33"};
        Integer[] array = (Integer[]) ConvertUtils.convert(strs, Integer[].class);
        System.out.println(Arrays.toString(array));// [11, 22, 33]
        
        strs  = new String[]{"11", "bb", "33"};
        array = (Integer[]) ConvertUtils.convert(strs, Integer[].class);
        System.out.println(Arrays.toString(array));// [11, 0, 33]
        
        DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");// 设置模式
		ConvertUtils.register(converter, Date.class);// 注册转换器，第二个参数：转换后的类型
        strs  = new String[]{"2015/09/11 09:12:00", "2015/09/12 09:12:00", "2015/09/13 09:12:00"};
        Date[] dates = (Date[]) ConvertUtils.convert(strs, Date[].class);  
        System.out.println(Arrays.toString(dates));
        // [Fri Sep 11 09:12:00 CST 2015, Sat Sep 12 09:12:00 CST 2015, Sun Sep 13 09:12:00 CST 2015]
	}
	
	/**
	 * Object --> Object
	 * 将对象转换为指定类型的对象
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConvert4() throws Exception
	{
		obj  = new String[]{"11", "22", "33"};
		Integer[] is = (Integer[]) ConvertUtils.convert(obj, Integer[].class);
		System.out.println(Arrays.toString(is));// [11, 22, 33] 
		
		obj  = new String[]{"11", "22", "33"};
		obj = (Integer) ConvertUtils.convert(obj, Integer.class);
		System.out.println(obj);// 11
		
		obj  = new String[]{"aa", "22", "33"};
		obj = (Integer) ConvertUtils.convert(obj, Integer.class);
		System.out.println(obj);// 0
		
		obj  = "11";
		obj = (Integer) ConvertUtils.convert(obj, Integer.class);
		System.out.println(obj);// 11
		
		obj  = "aa";
		obj = (Integer) ConvertUtils.convert(obj, Integer.class);
		System.out.println(obj);// 0
	}
	
	/**
	 * 注册转换器
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testRegister() throws Exception
	{
        DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");
		ConvertUtils.register(converter, Date.class);
        str = "2015/09/11 09:12:00";
        obj = ConvertUtils.convert(str, Date.class);  
        System.out.println(obj);// Fri Sep 11 09:12:00 CST 2015
	}
}
