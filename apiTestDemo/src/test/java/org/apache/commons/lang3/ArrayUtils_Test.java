/*
 * @(#)ArrayUtils_Test.java 2015-1-28 上午11:00:56
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import java.util.Map;

import org.junit.Test;

/**
 * <p>File：ArrayUtils_Test.java</p>
 * <p>Title: 操作数组</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 上午11:00:56</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class ArrayUtils_Test
{	
	/**
	 * 操作数组的元素
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testEdit() throws Exception
	{
		// 追加元素到数组尾部
		int[] array1 = {1, 2};
		array1 = ArrayUtils.add(array1, 3); // => [1, 2, 3]
		 
		System.out.println(array1.length);//3
		System.out.println(array1[2]);//3
		 
		// 删除指定位置的元素
		int[] array2 = {1, 2, 3};
		array2 = ArrayUtils.remove(array2, 2); // => [1, 2]
		System.out.println(array2.length);//2
		 
		// 截取部分元素
		int[] array3 = {1, 2, 3, 4};
		array3 = ArrayUtils.subarray(array3, 1, 3); // => [2, 3]
		System.out.println(array3.length);//2
	}
	
	/**
	 * 数组拷贝
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testClone() throws Exception
	{
		String[] array4 = {"aaa", "bbb", "ccc"};
		String[] copied = (String[]) ArrayUtils.clone(array4); // => {"aaa", "bbb", "ccc"}
		         
		String[] copied2 =  ObjectUtils.clone(array4);
		
		System.out.println(copied.length);//3   
		System.out.println(copied2.length);//3   
	}
	
	/**
	 * 判断是否包含某元素
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testContains() throws Exception
	{
		String[] array5 = {"aaa", "bbb", "ccc", "bbb"};
		boolean result1 = ArrayUtils.contains(array5, "bbb"); // => true    
		System.out.println(result1);//true
	}
	
	/**
	 * 判断某元素在数组中出现的位置
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIndexOf() throws Exception
	{
		String[] array5 = {"aaa", "bbb", "ccc", "bbb"};
		
		// （从前往后，没有返回-1）
		int result2 = ArrayUtils.indexOf(array5, "bbb"); // => 1    
		System.out.println(result2);//1
		 
		// （从后往前，没有返回-1）
		int result3 = ArrayUtils.lastIndexOf(array5, "bbb"); // => 3
		System.out.println(result3);//3
	}
	
	/**
	 * 数组转Map
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testToMap() throws Exception
	{
		// 数组转Map
		Map<Object, Object> map = ArrayUtils.toMap(new String[][]{
		    {"key1", "value1"},
		    {"key2", "value2"}
		});
		System.out.println(map.get("key1"));//"value1"
		System.out.println(map.get("key2"));//"value2"
	}
	
	/**
	 * 判断数组是否为空
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIsEmpty() throws Exception
	{
		Object[] array61 = new Object[0];
		Object[] array62 = null;
		Object[] array63 = new Object[]{"aaa"};
		 
		System.out.println(ArrayUtils.isEmpty(array61));//true
		System.out.println(ArrayUtils.isEmpty(array62));//true
		System.out.println(ArrayUtils.isNotEmpty(array63));//true
	}
	
	/**
	 * 判断数组长度是否相等
	 * @throws Exception
	 * @author 周光暖
	 */
	public void testIsSameLength() throws Exception
	{
		Object[] array71 = new Object[]{"aa", "bb", "cc"};
		Object[] array72 = new Object[]{"dd", "ee", "ff"};
		 
		System.out.println(ArrayUtils.isSameLength(array71, array72));//true
	}
	
	/**
	 * 判断数组元素内容是否相等（位置一对一比较）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIsEquals() throws Exception
	{
		Object[] array81 = new Object[]{"bb", "aa", "cc"};
		Object[] array82 = new Object[]{"aa", "bb", "cc"};
		System.out.println(ArrayUtils.isEquals(array81, array82));// false
		
		array81 = new Object[]{"aa", "bb", "cc"};
		array82 = new Object[]{"aa", "bb", "cc"};
		System.out.println(ArrayUtils.isEquals(array81, array82));// true
	}
	
	/**
	 * 将包装类型数组转为基本数据类型数组
	 * @throws Exception
	 * @author 周光暖
	 */
	public void testToPrimitive() throws Exception
	{
		// Integer[] 转化为 int[]
		Integer[] array9 = new Integer[]{1, 2};
		int[] result = ArrayUtils.toPrimitive(array9);
		 
		System.out.println(result.length);//2
		System.out.println(result[0]);//1
	}
	
	/**
	 * 将基本类型数组转为包装类型数组
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testToObject() throws Exception
	{
		// int[] 转化为 Integer[]
		int[] array10 = new int[]{1, 2};
		Integer[] result10 = ArrayUtils.toObject(array10);
		System.out.println(result10[0].intValue());//1
	}
	
	@Test
	public void testAdd() throws Exception
	{
		int[] ints = new int[] { 1, 2, 3 };
		ints = ArrayUtils.add(ints, 5);
		System.out.println(ArrayUtils.toString(ints));
	}

	@Test
	public void testAddAll() throws Exception
	{
		int[] target = new int[] { 1, 2, 3 };
		int[] given = new int[] { 4, 5, 6 };
		target = ArrayUtils.addAll(target, given);
		System.out.println(ArrayUtils.toString(target));
	}

	@Test
	public void testConstains() throws Exception
	{
		int[] ints = new int[] { 1, 2, 3 };
		System.out.println("是否包含：" + ArrayUtils.contains(ints, 2));
	}

	@Test
	public void testRemove() throws Exception
	{
		int[] ints1 = new int[] { 1, 2, 3 };
		int[] ints2 = ints1;
		int[] ints3 = ArrayUtils.remove(ints1, 2);// 返回一个新的数组
		System.out.println(ints1.equals(ints2));
		System.out.println(ArrayUtils.toString(ints1));
		System.out.println(ArrayUtils.toString(ints2));
		System.out.println(ArrayUtils.toString(ints3));
	}

	@Test
	public void testRemoveElement() throws Exception
	{
		int[] ints = ArrayUtils.removeElement(new int[] { 1, 2, 3 }, 1);
		System.err.println(ArrayUtils.toString(ints));
	}
}
