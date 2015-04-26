/*
 * @(#)NumberUtils_Test.java 2015-1-26 下午2:10:45
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * <p>File：NumberUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-26 下午2:10:45</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class NumberUtils_Test
{
	@Test
	public void testToInt() throws Exception
	{
		System.out.println(NumberUtils.toInt("8", 0));// 8
		System.out.println(NumberUtils.toInt("sdf", 0));// 0
		System.out.println(NumberUtils.toInt(null, 0));// 0
	}
	
	/**
	 * 从数组中选出最大/最小值
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testMax_Min() throws Exception
	{
		System.out.println(NumberUtils.max(new int[] { 1, 2, 3, 4 }));
		System.out.println(NumberUtils.max(new int[] { 1, 55, 3, 4 }));
		System.out.println(NumberUtils.max(new int[] { 1, 0, 3, 4 }));
		
		System.out.println(NumberUtils.min(new int[] { 1, 2, 3, 4 }));
		System.out.println(NumberUtils.min(new int[] { 1, 55, 3, 4 }));
		System.out.println(NumberUtils.min(new int[] { 1, 0, 3, 4 }));
	}
	
	/**
	 * 判断字符串是否是有效数字
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIsDigits() throws Exception
	{
		System.out.println("判断字符串是否全是整数.");
		System.out.println(NumberUtils.isDigits("123"));
	}
	
	/**
	 * 判断字符串是否是有效数字
	 * @throws Exception
	 * @author 周光暖
	 */
	public void testIsNumber() throws Exception
	{
		System.out.println(NumberUtils.isNumber("0123.1"));
	}
}
