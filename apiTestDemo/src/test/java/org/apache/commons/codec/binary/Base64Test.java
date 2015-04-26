/*
 * @(#)Base64Test.java 2015-2-10 上午9:12:03
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.binary;

import org.junit.Test;

/**
 * <p>File：Base64Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午9:12:03</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class Base64Test
{
	@Test
	public void testname() throws Exception
	{
		String str = "你好";
		String code = Base64.encodeBase64String(str.getBytes());
		System.out.println(code);// 5L2g5aW9
		System.out.println(Base64.isBase64(code));// true
		System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(code)));// 你好
	}
	
	@Test
	public void testname2() throws Exception
	{
		String code = "111";
		System.out.println(Base64.isBase64(code));// true
		System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(code)));// 你好
	}
}
