/*
 * @(#)JSON_Test.java 2015-1-29 上午9:26:12
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alibaba.fastjson;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.alibaba.fastjson.serializer.SerializerFeature;

import bean.BeanFactory;
import bean.SampleBean;
import bean.SampleBean2;

/**
 * <p>File：JSON_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-29 上午9:26:12</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class JSON_Test
{
	/**
	 * Object --> json字符串
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testToJSONString() throws Exception
	{
		SampleBean object = BeanFactory.getSampleBean();
		// 禁用循环引用检测
		String jsonStr = JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(jsonStr);
	}
	
	/**
	 * json字符串 --> Object
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testParseObject() throws Exception
	{
		String jsonStr = "{'age':31,'array':['array1','array2','array3'],'beans':[{'infos':['infos1','infos2','infos3'],'nestedProperty':'nestedProperty'},{'infos':['infos1','infos2','infos3'],'nestedProperty':'nestedProperty'},{'infos':['infos1','infos2','infos3'],'nestedProperty':'nestedProperty'}],'date':1422509937727,'list':['list1','list2','list3'],'map':{'map1':'val1','map2':'val2','map3':'val3'},'name':'rensanning'}";
		SampleBean sampleBean = JSON.parseObject(jsonStr, SampleBean.class);
		System.out.println(sampleBean);
	}
	
	@Test
	public void testparseObjectByFile() throws Exception
	{
		File file = FileUtils.getFile("E:\\GitHome\\git\\aipTestDemo\\src\\test\\java\\org\\dom4j\\test.json");
		byte[] input = FileUtils.readFileToByteArray(file);
		SampleBean sampleBean = JSON.parseObject(input, SampleBean.class);
		System.out.println(sampleBean);
	}
	
	@Test
        public void testToJSONString2() throws Exception
        {
                SampleBean2 object = BeanFactory.getSampleBean2();
                // 禁用循环引用检测
                String jsonStr = JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
                System.out.println(jsonStr);
        }
}
