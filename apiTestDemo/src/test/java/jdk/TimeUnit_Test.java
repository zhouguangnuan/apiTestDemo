/*
 * @(#)TimeUnit.java 2015-1-27 上午9:49:00
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdk;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * <p>File：TimeUnit.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-27 上午9:49:00</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class TimeUnit_Test
{
	/**
	 * 天 --> 小时
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testDAYS() throws Exception
	{
		System.out.println(TimeUnit.DAYS.toHours(1));// 24
	}
	
	/**
	 * 小时 --> 秒
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testHOURS() throws Exception
	{
		System.out.println(TimeUnit.HOURS.toSeconds(24));// 86400
		System.out.println(60*60*24);// 86400
	}
}
