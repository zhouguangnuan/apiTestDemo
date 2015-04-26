/*
 * @(#)BCodecTest.java 2015-2-10 上午8:39:39
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.net;

import org.apache.commons.codec.CharEncoding;
import org.junit.Test;

/**
 * <p>File：BCodecTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午8:39:39</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class BCodecTest
{
	@Test
	public void testname() throws Exception
	{
		 String str = "你好"; 
		 BCodec bcodec = new BCodec();  
		 String code = bcodec.encode(str, CharEncoding.UTF_8);  
		 System.out.println(code);// =?UTF-8?B?5L2g5aW9?=  
		 String data = bcodec.decode(code);
		 System.out.println(data);// 你好  
	}
}
