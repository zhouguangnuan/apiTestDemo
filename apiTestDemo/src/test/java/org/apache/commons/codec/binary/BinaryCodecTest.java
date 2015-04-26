/*
 * @(#)BinaryCodecTest.java 2015-2-11 下午1:49:33
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.binary;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.CharEncoding;
import org.junit.Test;

/**
 * <p>File：BinaryCodecTest.java</p>
 * <p>Title: 二进制编码</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-11 下午1:49:33</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class BinaryCodecTest
{	
	@Test
	public void test1() throws Exception
	{
		String str = "你好";
		String asciiStr = BinaryCodec.toAsciiString(str.getBytes());
		System.out.println(asciiStr);
		// 101111011010010111100101101000001011110111100100

		System.out.println(new String(BinaryCodec.fromAscii(asciiStr.getBytes())));// 你好
		
		System.out.println(BinaryCodec.toAsciiString("A".getBytes(CharEncoding.UTF_8)));// 01000001
	}

	@Test
	public void test2() throws Exception
	{
		String str = "你好";
		byte[] asciiByte = BinaryCodec.toAsciiBytes(str.getBytes());
		char[] asciiChar = BinaryCodec.toAsciiChars(str.getBytes());
		System.out.println(asciiByte);
		System.out.println(ArrayUtils.toString(asciiByte));

		// 101111011010010111100101101000001011110111100100
		// {1,0,1,1,1,1,0,1,1,0,1,0,0,1,0,1,1,1,1,0,0,1,0,1,1,0,1,0,0,0,0,0,1,0,1,1,1,1,0,1,1,1,1,0,0,1,0,0}
		System.out.println(asciiChar);
		System.out.println(ArrayUtils.toString(asciiChar));
	}
	
}
