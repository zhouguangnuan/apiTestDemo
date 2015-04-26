/*
 * @(#)DateUtils.java 2015-1-28 上午11:36:48
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

/**
 * <p>File：DateUtils.java</p>
 * <p>Title: 操作日期</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 上午11:36:48</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class DateUtils_Test
{
	/**
	 * 日期字符串 --> Date
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testParseDate() throws Exception
	{
		Date date = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});
		System.out.println(DateFormatUtils.format(date, "yyyy/MM/dd HH:mm:ss"));// 2010/01/01 11:22:33
		
		date = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});
		System.out.println(DateFormatUtils.format(date, "yyyy/MM/dd HH:mm:ss"));// 2010/01/01 11:22:33
		
		date = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss", "HH:mm:ss"});
		System.out.println(DateFormatUtils.format(date, "yyyy/MM/dd HH:mm:ss"));// 2010/01/01 11:22:33
		
		// 返回第二个参数里第一个匹配解析的结果
		date = DateUtils.parseDate("2010/01/01", new String[]{"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd"});
		System.out.println(DateFormatUtils.format(date, "yyyy/MM/dd HH:mm:ss"));// 2010/01/01 00:00:00
	} 
	
	/**
	 * 增加/减少（年、月、日、小时、分、秒、毫秒）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testAdd() throws Exception
	{
		Date date = DateUtils.parseDate("2010/01/11", "yyyy/MM/dd");
		
		// 1天后
		Date tenDaysAfter = DateUtils.addDays(date, 1); // => 2010/01/12 00:00:00
		System.out.println(DateFormatUtils.format(tenDaysAfter, "yyyy/MM/dd HH:mm:ss"));
		
		// 1天前
		Date tenDaysBefore = DateUtils.addDays(date, -1); // => 2010/01/10 00:00:00
		System.out.println(DateFormatUtils.format(tenDaysBefore, "yyyy/MM/dd HH:mm:ss"));
		 
		// 前一个月
		Date prevMonth = DateUtils.addMonths(date, -1); // => 2009/12/11 00:00:00
		System.out.println(DateFormatUtils.format(prevMonth, "yyyy/MM/dd HH:mm:ss"));
	}
	
	/**
	 * 是否同一天
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIsSameDay() throws Exception
	{
		// 判断是否是同一天
		Date date1 = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});
		Date date2 = DateUtils.parseDate("2010/01/01 22:33:44", new String[]{"yyyy/MM/dd HH:mm:ss"});
		
		System.out.println(DateUtils.isSameDay(date1, date2));// true
		// 日期比较不能用equals
		System.out.println(date1.equals(date2));// false
	}
}
