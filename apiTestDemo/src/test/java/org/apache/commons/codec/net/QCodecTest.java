/*
 * @(#)QCodecTest.java 2015-2-10 上午8:37:18
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.net;

import org.apache.commons.codec.CharEncoding;
import org.junit.Test;

/**
 * <p>File：QCodecTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午8:37:18</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class QCodecTest
{
	@Test
	public void testEncode() throws Exception
	{
		String str = "你好"; 
		QCodec qcodec = new QCodec();
		String code = qcodec.encode(str, CharEncoding.UTF_8);
		System.out.println(code);// =?UTF-8?Q?=E4=BD=A0=E5=A5=BD?=
		String data = qcodec.decode(code);
		System.out.println(data);// 你好
	}
}
