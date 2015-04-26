/*
 * @(#)CryptTest.java 2015-2-10 上午9:16:52
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.digest;

import org.junit.Test;

/**
 * <p>File：CryptTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午9:16:52</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class CryptTest
{
	@Test
	public void testname() throws Exception
	{
		String str = "你好";
	    System.out.println(Crypt.crypt(str));
	}
	
	@Test
	public void test2() throws Exception
	{
		String key = "key";
		String salt = "sdf";
		String str = Crypt.crypt(key, salt);
		System.out.println(str);// sdkEQZLnf/n7A
	}
}
