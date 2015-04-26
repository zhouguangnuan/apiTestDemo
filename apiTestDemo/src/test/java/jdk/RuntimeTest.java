/*
 * @(#)RuntimeTest.java 2015-2-9 下午2:27:54
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdk;

import org.junit.Test;

/**
 * <p>File：RuntimeTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-9 下午2:27:54</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class RuntimeTest
{
	/**
	 * 获得可用的处理器个数（n核处理器）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testAvailableProcessors() throws Exception
	{
		final int DEFAULT_CONN_THREADS = Runtime.getRuntime().availableProcessors();
		System.out.println(DEFAULT_CONN_THREADS);
	}
}
