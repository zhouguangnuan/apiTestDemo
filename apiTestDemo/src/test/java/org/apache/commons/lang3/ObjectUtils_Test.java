/*
 * @(#)ObjectUtils_Test.java 2015-1-26 下午3:33:04
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * <p>File：ObjectUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-26 下午3:33:04</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class ObjectUtils_Test
{
	/**
	 * Object为null时，默认打印某字符
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testDefaultIfNull() throws Exception
	{
		Object obj = null;
		System.out.println(ObjectUtils.defaultIfNull(obj, "空"));
	}
	
	/**
	 * 比较变量引用是否相等
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testEquals() throws Exception
	{
		Object a = new Object();
		Object b = a;
		Object c = new Object();
		Object d = null;
		
		System.out.println(ObjectUtils.equals(a, b));// true
		System.out.println(ObjectUtils.equals(a, c));// false
		System.out.println(ObjectUtils.equals(null, null));// true
		System.out.println(null==null);// true
		// System.out.println(d.equals(null));// error
		
		System.out.println(ObjectUtils.notEqual(a, b));// false
		System.out.println(ObjectUtils.notEqual(a, c));// true
		System.out.println(ObjectUtils.notEqual(null, null));// false
	}
	
	/**
	 * 返回第一个非空对象
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testFirstNonNull() throws Exception
	{
		List<String> list = Arrays.asList("1", "2", "3");
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = null;
		
		System.out.println(ObjectUtils.firstNonNull(list));// [1, 2, 3]
		System.out.println(ObjectUtils.firstNonNull(list.toArray()));// 1
		System.out.println(ObjectUtils.firstNonNull(list2));// []
		System.out.println(ObjectUtils.firstNonNull(list3));// null
		
		System.out.println(ObjectUtils.firstNonNull(null, null));// null
		System.out.println(ObjectUtils.firstNonNull(null, ""));// ""
		System.out.println(ObjectUtils.firstNonNull(null, null, ""));// ""
		System.out.println(ObjectUtils.firstNonNull(null, "zz"));// zz
		System.out.println(ObjectUtils.firstNonNull("abc", "", 123));// abc
		System.out.println(ObjectUtils.firstNonNull(null, "xyz", 123));// xyz
		System.out.println(ObjectUtils.firstNonNull(Boolean.TRUE, 123));// true
	}
	
	/**
	 * 用父类Object的toString()方法返回对象信息
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIdentityToString() throws Exception
	{
		Date date = new Date();
		System.out.println(date);// Mon Jan 26 17:05:06 CST 2015
		System.out.println(new Object());// java.lang.Object@6937f9
		System.out.println(ObjectUtils.identityToString(date));// java.util.Date@626fd2
		System.out.println(date);// Mon Jan 26 17:05:06 CST 2015
		
		StringBuffer sb = new StringBuffer("日期:");
		ObjectUtils.identityToString(sb, date);
		System.out.println(sb);// 日期:java.util.Date@a30fd
	}

	/**
	 * 返回对象信息，null->""
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testToString() throws Exception
	{
		Date date = new Date();
		System.out.println(ObjectUtils.toString(date));// Mon Jan 26 17:00:34 CST 2015
		System.out.println(ObjectUtils.toString(null));
		System.out.println(ObjectUtils.toString(null, "空"));// "空"
		Object obj2 = null;
		System.out.println(obj2);// null
		System.out.println(date);// Mon Jan 26 17:00:34 CST 2015
		
		List<String> list = Arrays.asList("1", "2", "3");
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = null;
		System.out.println(ObjectUtils.toString(list));// [1, 2, 3]
		System.out.println(ObjectUtils.toString(list2));// []
		System.out.println(ObjectUtils.toString(list3));// ""
		System.out.println(list3);// null
	}
	
	/**
	 * 返回Integer数组中，最大/最小的值
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testMin_Max() throws Exception
	{
		System.out.println(ObjectUtils.min(new Integer[] { 1, 2, 3, 4 }));// 1
		System.out.println(ObjectUtils.max(new Integer[] { 1, 2, 3, 4 }));// 4
	}
	
	/**
	 * 比较两个对象，左边大的返回1，小则返回-1
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testCompare() throws Exception
	{
		System.out.println(ObjectUtils.compare(1, 2));// -1
		System.out.println(ObjectUtils.compare(2, 1));// 1
		System.out.println(ObjectUtils.compare(2, null));// 1
		System.out.println(ObjectUtils.compare(2, null, true));// -1
	}
	
	/**
	 * 返回可以比较的对象的数组中，排序居中的对象
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testMedian() throws Exception
	{
		System.out.println(ObjectUtils.median(new Integer[] { 1, 2, 3, 4, 5 }));// 3
		System.out.println(ObjectUtils.median(new Integer[] { 2, 4, 5, 3, 1 }));// 3
		System.out.println(ObjectUtils.median(new Integer[] { 2, 4, 5, 3, 3, 3 }));// 3
		
		System.out.println(ObjectUtils.median(new String[] { "a","b","c","d","e" }));// c
		System.out.println(ObjectUtils.median(new String[] { "a","b","1","d","e" }));// c
		
		// 自定义比较规则
		System.out.println(ObjectUtils.median(new Comparator<String>(){
			public int compare(String o1, String o2)
			{
				return 0;
			}
			
		}, new String[] { "a","b","1","d","e" }));// c
	}
	
	/**
	 * 返回数组中数量最多的对象
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testMode() throws Exception
	{
		System.out.println(ObjectUtils.mode(new Integer[] { 1, 2, 3, 4, 5, 5 }));// 5
		System.out.println(ObjectUtils.mode(new Integer[] { 1, 2, 3, 4, 5 }));// null
		
		System.out.println(ObjectUtils.mode(new Object[] { "1","2","3","3" }));// 3
	}
	
	/**
	 * 克隆对象（目标对象不可克隆返回null）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testClone() throws Exception
	{
		String[] strs = new String[]{"1", "2", "3"};
		
		Object objC = ObjectUtils.clone(strs);
		System.out.println(JSON.toJSONString(strs));// ["1","2","3"]
		System.out.println(JSON.toJSONString(objC));// ["1","2","3"]
		
		objC = ObjectUtils.clone(Arrays.asList(strs));
		System.out.println(JSON.toJSONString(objC));// null
	}
	
	/**
	 * 克隆对象（目标对象不可克隆返回目标对象）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testCloneIfPossible() throws Exception
	{
		String[] strs = new String[]{"1", "2", "3"};
		
		Object objC = ObjectUtils.cloneIfPossible(strs);
		System.out.println(JSON.toJSONString(strs));// ["1","2","3"]
		System.out.println(JSON.toJSONString(objC));// ["1","2","3"]
		
		objC = ObjectUtils.cloneIfPossible(Arrays.asList(strs));
		System.out.println(JSON.toJSONString(objC));// ["1","2","3"]
	}
	
	
}
