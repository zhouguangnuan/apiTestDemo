/*
 * @(#)DateTime_Time.java 2015-1-27 下午3:29:29
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.joda.time;

import java.util.Date;

import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

/**
 * <p>File：DateTime_Time.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-27 下午3:29:29</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class DateTime_Time
{
	/**
	 * 解析日期 --> DateTime
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testParse() throws Exception
	{
		System.out.println(DateTime.parse("2016-07-01 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate().getTime());
		// 1466438400000
		// 1466438400
		
		// 格式 默认是：yyyy-MM-dd
		DateTime dateTime = DateTime.parse("2015-01-27");
		System.out.println(dateTime.toDate().getTime());// 1422288000000
		System.out.println(dateTime.toString("yyyy-MM-dd"));// 2015-01-27
														 
		dateTime = DateTime.parse("2015-01-27 09:10:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateTime.toDate().getTime());// 1422321000000
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 09:10:00
		
		DateTime s = DateTime.parse("2016-05", DateTimeFormat.forPattern("yyyy-MM"));
		System.out.println(s.toString("yyyy-MM-dd"));
		
		DateTime DateTime = org.joda.time.DateTime.now();
	}
	
	@Test
	public void testName11() throws Exception {
//		System.out.println(DateTime.parse("2016-03-31", DateTimeFormat.forPattern("yyyy-MM-dd")).plusMonths(-1).toString("yyyy-MM-dd"));
//		System.out.println(DateTime.now().getDayOfWeek());
		
		
		
		
//		System.out.println(aa(DateTime.parse("2017-01-02", DateTimeFormat.forPattern("yyyy-MM-dd"))));
//		System.out.println(aa(DateTime.parse("2017-01-03", DateTimeFormat.forPattern("yyyy-MM-dd"))));
//		System.out.println(aa(DateTime.parse("2017-01-04", DateTimeFormat.forPattern("yyyy-MM-dd"))));
//		System.out.println(aa(DateTime.parse("2017-01-05", DateTimeFormat.forPattern("yyyy-MM-dd"))));
//		System.out.println(aa(DateTime.parse("2017-01-06", DateTimeFormat.forPattern("yyyy-MM-dd"))));
//		System.out.println(aa(DateTime.parse("2017-01-07", DateTimeFormat.forPattern("yyyy-MM-dd"))));
//		System.out.println(aa(DateTime.parse("2017-01-08", DateTimeFormat.forPattern("yyyy-MM-dd"))));
		
		System.out.println(DateTime.parse("2016-01-11", DateTimeFormat.forPattern("yyyy-MM-dd")).getWeekOfWeekyear());
	}
	
	public static Boolean aa(DateTime dateTime){
		
		
		
		
		return null;
	}
	
	@Test
	public void testName55() throws Exception {
		System.out.println(3%3);
	}
	
	
	
	/**
	 * 加减(年、月、星期、日、小时、分、秒)修改日期
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testPlus() throws Exception
	{
		DateTime dateTime = DateTime.parse("2015-01-27");
		System.out.println(dateTime.plusMinutes(-30).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-26 23:30:00
		System.out.println(dateTime.plusYears(1).toString("yyyy-MM-dd HH:mm:ss"));// 2016-01-27 00:00:00
		System.out.println(dateTime.plusMonths(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-02-27 00:00:00
		System.out.println(dateTime.plusWeeks(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-02-03 00:00:00
    	System.out.println(dateTime.plusDays(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-28 00:00:00
    	System.out.println(dateTime.plusHours(9).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 09:00:00
    	System.out.println(dateTime.plusMinutes(10).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 00:10:00
    	System.out.println(dateTime.plusSeconds(30).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 00:00:30
	}
	
	/**
	 * 修改 dateTime 日期
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testDayOfWeek() throws Exception
	{
		DateTime dateTime = DateTime.parse("2015-01-27 09:10:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		
		// 获得当天日期，开始时间的 dateTime 
		System.out.println(dateTime.withTimeAtStartOfDay().toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 00:00:00
		
		// 修改当前日期（年份）
		System.out.println(dateTime.withYear(2013).toString("yyyy-MM-dd HH:mm:ss"));// 2013-01-27 09:10:00
		// 修改当前日期（日期（年、月、日）
		System.out.println(dateTime.withDate(2015, 12, 30).toString("yyyy-MM-dd HH:mm:ss"));// 2015-12-30 09:10:00
		// 修改当前日期（时间）（小时、分、秒、毫秒）
		System.out.println(dateTime.withTime(9, 20, 30, 0).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 09:20:30

		
		// 修改当前日期（月份）为当前年中的第几月
		System.out.println(dateTime.withMonthOfYear(2).toString("yyyy-MM-dd HH:mm:ss"));// 2015-02-27 09:10:00
		// 修改当前日期（日）为当前年中的第几天
		System.out.println(dateTime.withDayOfYear(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-01 09:10:00
		// 修改当前日期（日）为当前月的第几天
		System.out.println(dateTime.withDayOfMonth(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-01 09:10:00
		// 修改当前日期（日）为当前星期的第几天
		System.out.println(dateTime.withDayOfWeek(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-26 09:10:00
		// 修改当前日期（时间小时）为当天的第几个小时
		System.out.println(dateTime.withHourOfDay(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 01:10:00
		// 修改当前日期（时间分钟）为当前小时的第几分钟
		System.out.println(dateTime.withMinuteOfHour(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 09:01:00
		// 修改当前日期（时间秒）为当前分钟的第几秒
		System.out.println(dateTime.withSecondOfMinute(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 09:10:01
		// 修改当前日期（时间毫秒）为当前秒的第几毫秒
		System.out.println(dateTime.withMillisOfSecond(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 09:10:00 0001
		// 修改当前日期（时间毫秒）为当天的第几毫秒
		System.out.println(dateTime.withMillisOfDay(1).toString("yyyy-MM-dd HH:mm:ss"));// 2015-01-27 00:00:00 0001
	}
	
	@Test
    public void testName() throws Exception
    {
		String dateStr = "2016-05";
		DateTime date = DateTime.parse(dateStr, DateTimeFormat.forPattern("yyyy-MM"));
		System.out.println(date.toString("yyyy-MM-dd HH:mm:ss"));
		date = date.plusMonths(1).plusSeconds(-1);
		System.out.println(date.toString("yyyy-MM-dd HH:mm:ss"));
		
//		2016-05-01 00:00:00
//		2016-05-31 23:59:59
    }
}
