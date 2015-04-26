/*
 * @(#)MethodUtils_Test.java 2015-1-28 下午9:00:57
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.beanutils;

import org.junit.Test;

import bean.SampleBean;

/**
 * <p>File：MethodUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午9:00:57</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class MethodUtils_Test
{
	@Test
	public void testInvokeMethod() throws Exception
	{
		SampleBean sampleBean = new SampleBean("singno", 11);
		Object name = MethodUtils.invokeMethod(sampleBean, "getName", null);
		System.out.println(name);// singno
		
		name = MethodUtils.invokeMethod(sampleBean, "setName", "singno22");
		System.out.println(name);// null
		System.out.println(sampleBean.getName());// singno22
	}
}
