/*
 * @(#)PropertyUtils_Test.java 2015-1-28 下午8:07:43
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import bean.SampleBean;

/**
 * <p>File：PropertyUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午8:07:43</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class PropertyUtils_Test
{
	/**
	 * 获得对象指定属性的值
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetProperty() throws Exception
	{
		SampleBean bean = new SampleBean();
		bean.setName("singno");
		
		Map<String, String>	map = new HashMap<String, String>();
		map.put("name", "singo");
		map.put("age", "11");
		bean.setMap(map);
		
		System.out.println(PropertyUtils.getProperty(bean, "name"));
		System.out.println(PropertyUtils.getSimpleProperty(bean, "map"));// {age=11, name=singo}
//		System.out.println(PropertyUtils.getSimpleProperty(bean, "map.name"));// error
		System.out.println(PropertyUtils.getProperty(bean, "map.name"));// singo
	}
}
