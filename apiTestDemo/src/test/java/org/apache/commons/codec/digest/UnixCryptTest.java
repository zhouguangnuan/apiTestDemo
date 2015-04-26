/*
 * @(#)UnixCryptTest.java 2015-2-10 上午9:15:53
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.digest;

import org.junit.Test;

/**
 * <p>File：UnixCryptTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午9:15:53</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class UnixCryptTest
{
	@Test
	public void testname() throws Exception
	{
		String str = "你好";
	    System.out.println(UnixCrypt.crypt(str.getBytes()));
	}
}
