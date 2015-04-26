/*
 * @(#)HexTest.java 2015-2-10 上午8:58:50
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.binary;

import org.apache.commons.codec.Charsets;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * <p>File：HexTest.java</p>
 * <p>Title: 十六进制编码</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午8:58:50</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class HexTest
{
	@Test
	public void testname() throws Exception
	{
		String str = "你好";
	    char[] chs = Hex.encodeHex(str.getBytes());  
	    System.out.println(chs);// e4bda0e5a5bd  
	    System.out.println(StringUtils.newStringUtf8(Hex.decodeHex(chs)));// 你好  
	    
	    Hex hex = new Hex(Charsets.UTF_8);
	    Object hexStr = hex.encode(str);
	    System.out.println(JSON.toJSONString(hexStr));// "e4bda0e5a5bd"
	    System.out.println(JSON.toJSONString(hex.decode("e4bda0e5a5bd")));// "5L2g5aW9"
	    
	}
}
