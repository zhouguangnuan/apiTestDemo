/*
 * @(#)ConstructorUtils_Test.java 2015-1-28 下午8:56:54
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.beanutils;

import org.junit.Test;

import bean.SampleBean;

/**
 * <p>File：ConstructorUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午8:56:54</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class ConstructorUtils_Test
{
	@Test
	public void testInvokeConstructor() throws Exception
	{
		SampleBean sampleBean = (SampleBean) ConstructorUtils.invokeConstructor(SampleBean.class, new Object[]{"singno", 11});
		System.out.println(sampleBean.getName());// singo
		System.out.println(sampleBean.getAge());// 11
	}
}
