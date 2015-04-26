/*
 * @(#)Sha2CryptTest.java 2015-2-10 上午8:48:51
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.codec.digest;

import org.junit.Test;

/**
 * <p>File：Sha2CryptTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午8:48:51</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class Sha2CryptTest
{
	@Test
	public void testname() throws Exception
	{
		String str = "你好";
		// $6$F5DmajUw$IL9Gi1ClDSWpUx7k4xwMVlVbha9XVo.rMbwRpDr5KLu.bChO9x9C.dncX2spLo03OPrq4Mh.EXaaBrSOlhjBB0
		System.out.println(Sha2Crypt.sha512Crypt(str.getBytes()));
		// $6$sYxZRSVg$/rHTL6DIDtbnaBCTqGJ/bfAfnNpXuxMZxksI.YQ.UYJ99UgjeueMHzZwb9vG894xzNcGVTwZV/0k5wJMrCd1D1
		System.out.println(Sha2Crypt.sha512Crypt(str.getBytes()));
	}
}
