/*
 * @(#)CharSetUtils_Test.java 2015-1-26 下午3:06:13
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;

/**
 * <p>File：CharSetUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-26 下午3:06:13</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class CharSetUtils_Test
{
	/**
	 * char set
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testCharSet() throws Exception
	{
		// CharSet charSet = CharSet.getInstance("aeiou");
		// String demoStr = "The quick brown fox jumps over the lazy dog.";
		CharSet charSet = CharSet.getInstance("中国人", "日本人");
		String demoStr = "中国人日死日本人2";
		int count = 0;
		for (int i = 0, len = demoStr.length(); i < len; i++)
		{
			if (charSet.contains(demoStr.charAt(i)))
			{
				count++;
			}
		}
		// System.out.println("count: " + count);// count: 11
		System.out.println("count: " + count);// count: 7
	}
	
	/**
	 * CharSetUtils 操作字符串中的字符（统计，删除，保留，合并）
	 * 
	 * @author 周光暖
	 */
	@Test
	public void testCharSetUtils()
	{
		System.out.println("计算字符串中包含某字符数.");
		System.out.println(CharSetUtils.count("中国人日死日本人", "日本人"));// 5

		System.out.println("删除字符串中某字符.");
		System.out.println(CharSetUtils.delete("中国人日死日本人", "日本人"));// 中国死

		System.out.println("保留字符串中某字符.");
		System.out.println(CharSetUtils.keep("中国人日死日本人", "日本人"));// 人日日本人

		System.out.println("合并重复的字符.");
		System.out.println(CharSetUtils.squeeze("中国人日日日死日日日本人", "日"));// 中国人日死日本人
	}
}
