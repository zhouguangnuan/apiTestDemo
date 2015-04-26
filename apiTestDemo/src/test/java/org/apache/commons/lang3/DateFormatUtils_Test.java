/*
 * @(#)DateFormatUtils_Test.java 2015-1-28 下午12:56:54
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
 * <p>File：DateFormatUtils_Test.java</p>
 * <p>Title: 格式日期为指定格式的字符串</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午12:56:54</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class DateFormatUtils_Test
{
	/**
	 * 格式日期为指定格式的字符串
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testFormat() throws Exception
	{
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));  
  
        StopWatch sw = new StopWatch();  
        sw.start();  
  
        for (Iterator iterator = DateUtils.iterator(new Date(), DateUtils.RANGE_WEEK_CENTER); iterator.hasNext();)  
        {  
            Calendar cal = (Calendar) iterator.next();  
            System.out.println(DateFormatUtils.format(cal.getTime(), "yy-MM-dd HH:mm"));  
        }  

        sw.stop();  
        System.out.println("秒表计时（毫秒）:" + sw.getTime());  
	}
}
