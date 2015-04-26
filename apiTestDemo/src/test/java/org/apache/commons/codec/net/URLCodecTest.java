/*
 * @(#)URLCodecTest.java 2015-2-9 下午5:50:59
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.net;

import org.apache.commons.codec.CharEncoding;
import org.junit.Test;

/**
 * <p>File：URLCodecTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-9 下午5:50:59</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class URLCodecTest
{
	private static final String str = "你好";
	
	@Test
	public void testEncode() throws Exception
	{
		URLCodec urlCodec = new URLCodec(CharEncoding.UTF_8);
		String encodeStr = urlCodec.encode(str);
		System.out.println(encodeStr);// %E4%BD%A0%E5%A5%BD
		
		String decodeStr = urlCodec.decode(encodeStr);
		System.out.println(decodeStr);// 你好
	}
}
