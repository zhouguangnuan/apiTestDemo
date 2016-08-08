/*
 * @(#)StringUtils_Test.java 2015-1-28 上午9:33:26
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <p>File：StringUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 上午9:33:26</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class StringUtils_Test
{
	/**
	 * 将字符串重复n次
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testRepeat() throws Exception
	{
		System.out.println(StringUtils.repeat("*", 50));
		// **************************************************
	}
	
	/**
	 * 将文字按某宽度居中
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testCenter() throws Exception
	{
		System.out.println(StringUtils.center("  StringUtilsDemo  ", 50, "^O^"));
		// ^O^^O^^O^^O^^O^  StringUtilsDemo  ^O^^O^^O^^O^^O^^
	}
	
	/**
	 * 将字符串数组用某字符串连接
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testJoin() throws Exception
	{
		String[] strs = new String[]{"11", "22", "33"}; 
		System.out.println(StringUtils.join("11", "22", "33"));// 112233
		System.out.println(StringUtils.join(strs));// 112233
		System.out.println(StringUtils.join(strs, "-"));// 11-22-33
		System.out.println(StringUtils.join(Arrays.asList(strs), "-"));// 11-22-33
	}
	
	/**
	 * 缩短到某长度,用...结尾
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testAbbreviate() throws Exception
	{
		String str = "中华人民共和国万岁!";
		System.out.println(StringUtils.abbreviate(str, 5));// 中华...
		System.out.println(StringUtils.abbreviate(str, 4));// 中...
//		System.out.println(StringUtils.abbreviate(str, 3));// 当maxWidth<4时	error
		
		// 从第15个开始，总宽度10个字符
		System.out.println(StringUtils.abbreviate("abcdefghigklmnopqrstuvwxyz", 15, 10));
		// ...pqrs...
		System.out.println(StringUtils.abbreviate("abcdefghigklmnopqrstuvwxyz", 4, 10));
		// abcdefg...
		System.out.println(StringUtils.abbreviate("abcdefghigklmnopqrstuvwxyz", 5, 10));
		// ...fghi...
	}
	
	@Test
	public void testAbbreviateMiddle() throws Exception
	{
		String str = "15669108193";
		System.out.println(StringUtils.abbreviateMiddle(str, "****", 10));// 156****193
	}
	
	/**
	 * 返回两字符串不同处索引号
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIndexOfDifference() throws Exception
	{
		System.out.println(StringUtils.indexOfDifference("aaabc", "aaabc"));// -1：表示亮字符串相同
		System.out.println(StringUtils.indexOfDifference("aaabc", "aaacc"));// 3 
	}
	
	/**
	 * 返回两字符串不同处开始至结束
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testDifference() throws Exception
	{
		// 返回第二个参数的截取字符串
		System.out.println(StringUtils.difference("aaa?cde", "aaaccde"));// ccde
		System.out.println(StringUtils.difference("aaa?cde", "aaabcde"));// bcde
  
	}
	
	/**
	 * 截去字符串为以指定字符串结尾的部分
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testChomp() throws Exception
	{
		System.out.println(StringUtils.chomp("ABCDEFGHIJK", "GH"));// ABCDEFGHIJK
		System.out.println(StringUtils.chomp("ABCDEFGHIJK", "JK"));// ABCDEFGHI
	}
	
	/**
	 * 检查一字符串是否为另一字符串的子集
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testContainsOnly() throws Exception
	{
		// 第一个参数是第二个参数的子集
		System.out.println(StringUtils.containsOnly("aad", "aadd"));// true  
		System.out.println(StringUtils.containsOnly("aadd", "aad"));// true  
		System.out.println(StringUtils.containsOnly("aadd", "aadc"));// true  
		System.out.println(StringUtils.containsOnly("aaddc", "aad"));// false
		
		System.out.println(StringUtils.containsNone("aad", "aadd"));// false  
		System.out.println(StringUtils.containsNone("aadd", "aad"));// false  
		System.out.println(StringUtils.containsNone("aadd", "aadc"));// false  
		System.out.println(StringUtils.containsNone("aaddc", "aad"));// false
	}
	
	/**
	 * 检查一字符串是否包含另一字符串
	 * @throws Exception
	 * @author 周光暖
	 */
	public void testContains() throws Exception
	{
		System.out.println(StringUtils.contains("aad", "aadd"));// false
		System.out.println(StringUtils.contains("aadd", "aad"));// true
	}
	
	/**
	 * 返回可以处理null的toString()
	 * @throws Exception
	 * @author 周光暖
	 */
	public void testDefaultString() throws Exception
	{
		 System.out.println(StringUtils.defaultString("aaaa"));// aaaa  
	     System.out.println(StringUtils.defaultString(null));// ""
	}
	
	/**
	 * 去除字符中的空格
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testDeleteWhitespace() throws Exception
	{
		String str = "    aa  bb  cc    ";
		System.out.println(StringUtils.deleteWhitespace(str));// aabbcc  
	}
	
	/**
	 * 只去除字符两边的空格
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testTrim() throws Exception
	{
		System.out.println("    aa  bb  cc    ".trim());// aa  bb  cc 
		System.out.println(StringUtils.trim(null)); // null
		System.out.println(StringUtils.trim("")); // ""
		System.out.println(StringUtils.trim("     ")); // ""
		System.out.println(StringUtils.trim("abc")); // "abc"
		System.out.println(StringUtils.trim("    abc")); // "abc"
		System.out.println(StringUtils.trim("    abc  ")); // "abc"
		System.out.println(StringUtils.trim("    ab c  ")); // "ab c"
	}
	
	/**
	 * 去除指定字符
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testStrip() throws Exception
	{
		System.out.println(StringUtils.strip(null)); // null
		System.out.println(StringUtils.strip("")); // ""
		System.out.println(StringUtils.strip("   ")); // ""
		System.out.println(StringUtils.strip("abc")); // "abc"
		System.out.println(StringUtils.strip("  abc")); // "abc"
		System.out.println(StringUtils.strip("abc  ")); // "abc"
		System.out.println(StringUtils.strip(" abc ")); // "abc"
		System.out.println(StringUtils.strip(" ab c ")); // "ab c"
		System.out.println(StringUtils.strip("  abcyx", "xyz")); // "  abc"
		System.out.println(StringUtils.stripStart("yxabcxyz  ", "xyz")); // "abcxyz  "
		System.out.println(StringUtils.stripEnd("  xyzabcyx", "xyz")); // "  xyzabc"	
		System.out.println(StringUtils.stripEnd("120.01", ".0")); // 12	
		System.out.println(StringUtils.stripEnd("120.01", ".0")); // 120.01
		
//		stripToNull
//		stripToEmpty
	}
	
	/**
	 * 字符串分割
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testSplit() throws Exception
	{
		//默认半角空格分割
		String str1 = "aaa bbb ccc";
		String[] dim1 = StringUtils.split(str1); // => ["aaa", "bbb", "ccc"]
		 
		System.out.println(dim1.length);//3
		System.out.println(dim1[0]);//"aaa"
		System.out.println(dim1[1]);//"bbb"
		System.out.println(dim1[2]);//"ccc"
		 
		//指定分隔符
		String str2 = "aaa,bbb,ccc";
		String[] dim2 = StringUtils.split(str2, ","); // => ["aaa", "bbb", "ccc"]
		 
		System.out.println(dim2.length);//3
		System.out.println(dim2[0]);//"aaa"
		System.out.println(dim2[1]);//"bbb"
		System.out.println(dim2[2]);//"ccc"
		 
		//去除空字符串
		String str3 = "aaa,,bbb";
		String[] dim3 = StringUtils.split(str3, ","); // => ["aaa", "bbb"]
		 
		System.out.println(dim3.length);//2
		System.out.println(dim3[0]);//"aaa"
		System.out.println(dim3[1]);//"bbb"
		 
		//包含空字符串
		String str4 = "aaa,,bbb";
		String[] dim4 = StringUtils.splitPreserveAllTokens(str4, ","); // => ["aaa", "", "bbb"]
		 
		System.out.println(dim4.length);//3
		System.out.println(dim4[0]);//"aaa"
		System.out.println(dim4[1]);//""
		System.out.println(dim4[2]);//"bbb"
		 
		//指定分割的最大次数（超过后不分割）
		String str5 = "aaa,bbb,ccc";
		String[] dim5 = StringUtils.split(str5, ",", 2); // => ["aaa", "bbb,ccc"]
		 
		System.out.println(dim5.length);//2
		System.out.println(dim5[0]);//"aaa"
		System.out.println(dim5[1]);//"bbb,ccc"
	}
	
	/**
	 * 随机数
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testRandom() throws Exception
	{
		// 10位英字
		System.out.println(RandomStringUtils.randomAlphabetic(10));// hysbMumelP
		 
		// 10位英数
		System.out.println(RandomStringUtils.randomAlphanumeric(10));// mHl5fTE1ja
		
		// 10位数字
		System.out.println(RandomStringUtils.randomNumeric(10));// 7788885751
		 
		// 10位ASCII码
		System.out.println(RandomStringUtils.randomAscii(10));// .eFHaP>Y#}
		 
		// 指定文字10位
		System.out.println(RandomStringUtils.random(10, "abcde"));// dbdececdca
	}
	
	/**
	 * 判断是否是某类字符
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testStringType() throws Exception
	{
		// 是否是字母
        System.out.println(StringUtils.isAlpha("ab"));// true  
        System.out.println(StringUtils.isAlpha("ab123"));// false  
        System.out.println(StringUtils.isAlpha("中国"));// false  
        
        System.out.println("============================================================");
        
        // 是否是字母和数字和汉字（符号：false）
        System.out.println(StringUtils.isAlphanumeric("123a"));// true 
        System.out.println(StringUtils.isAlphanumeric("中国"));// true 
        System.out.println(StringUtils.isAlphanumeric("--"));// false 
        System.out.println(StringUtils.isAlphanumeric("%*"));// false 
        
        System.out.println("============================================================");
        
        System.out.println(StringUtils.isNumeric("123"));// true   
        System.out.println(StringUtils.isNumeric("12b3"));// false   
	}
}
