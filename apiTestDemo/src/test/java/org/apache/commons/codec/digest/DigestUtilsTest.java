/*
 * @(#)DigestUtilsTest.java 2015-2-9 下午5:30:28
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.digest;

import java.io.FileInputStream;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.net.QCodec;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

/**
 * <p>File：DigestUtilsTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-9 下午5:30:28</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class DigestUtilsTest
{
	@Test
	public void test1() throws Exception
	{
		String str = "你好";  
        System.out.println(DigestUtils.md5Hex(str));// 7eca689f0d3389d9dea66ae112e5cfd7  
        System.out.println(DigestUtils.md2Hex(str));// ca895cbe8af1e58a93dfc1b2ad7fb9d0  
        System.out.println(DigestUtils.sha1Hex(str));// 440ee0853ad1e99f962b63e459ef992d7c211722   
        System.out.println(DigestUtils.sha256Hex(str));// 670d9743542cae3ea7ebe36af56bd53648b0a1126162e78d81a32934a711302e  
        // 05f076c7d180e91d80a56d70b226fca01e2353554c315ac1e8caaaeca2ce0dc0d9d84e206a2bf1143a0ae1b9be9bcfa8  
        System.out.println(DigestUtils.sha384Hex(str));
        // 5232181bc0d9888f5c9746e410b4740eb461706ba5dacfbc93587cecfc8d068bac7737e92870d6745b11a25e9cd78b55f4ffc706f73cfcae5345f1b53fb8f6b5
		System.out.println(DigestUtils.sha512Hex(str));
		System.out.println(DigestUtils.shaHex(str));// 440ee0853ad1e99f962b63e459ef992d7c211722

		//		7eca689f0d3389d9dea66ae112e5cfd7
		System.out.println(DigestUtils.md5Hex(new FileInputStream("C:/Users/txsb/Desktop/Message.java")));
		//		440ee0853ad1e99f962b63e459ef992d7c211722
		System.out.println(DigestUtils.sha1Hex(new FileInputStream("C:/Users/txsb/Desktop/Message.java")));
	}
	
	@Test
	public void test2() throws Exception
	{
		String str = "你好";  
        System.out.println(DigestUtils.md5Hex(str));
        // 7eca689f0d3389d9dea66ae112e5cfd7 
	}
	
	@Test
	public void testname() throws Exception
	{
//		String encryptedStr = CryptoUtils.HASHencrypt("123", CryptoUtils.ALGORITHM.HASH.MD2);// ef1fedf5d32ead6b7aaf687de4ed1b71
		String str = "123";  
		 System.out.println(DigestUtils.md2Hex(str));// ef1fedf5d32ead6b7aaf687de4ed1b71
	}
}
