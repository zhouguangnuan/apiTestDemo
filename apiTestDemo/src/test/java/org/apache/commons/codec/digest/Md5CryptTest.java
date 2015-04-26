/*
 * @(#)Md5CryptTest.java 2015-2-10 上午8:50:47
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.digest;

import java.security.MessageDigest;

import org.junit.Test;

/**
 * <p>File：Md5CryptTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午8:50:47</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class Md5CryptTest
{
	@Test
	public void test1() throws Exception
	{
		String str = "你好";
		
		System.out.println(Md5Crypt.md5Crypt(str.getBytes())); // $1$GjVDNAx6$/4aGitpd6mNLzxjPbb2Ez.
	    System.out.println(Md5Crypt.apr1Crypt(str));// $apr1$XafTkAqG$mIJ.RWYfAdLQPYJb1saTD.
	}
	
	@Test
	public void test2() throws Exception
	{
		byte[] keyBytes = "keyBytes".getBytes();
		String salt = "123213";
		String prefix = "prefix";
		String result = Md5Crypt.md5Crypt(keyBytes, null, null);
		System.out.println(result);// prefixNc9545aP$Ipc64pwa64gdn8ZXC1uGH0
	}
	
	@Test
	public void test3() throws Exception
	{
		byte[] keyBytes = "keyBytes".getBytes();
		String salt = "123213";
		String result = Md5Crypt.md5Crypt(keyBytes, null);
		System.out.println(result);// $1$01xaYV1y$DjnPKureB7gzokstEPBKE.
								   // $1$Jx841Ezf$bHCJHFhqH/CgUG1uN1uyU.
	}
}
