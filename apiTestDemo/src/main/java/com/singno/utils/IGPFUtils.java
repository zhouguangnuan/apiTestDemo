/**
 * <p>项目名：</p>
 * <p>包名：com.singno.utils</p>
 * <p>文件名：IGPFUtils.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-13-下午12:33:14</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.singno.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import bean.GET_DOC_HOS_PATIENT;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

/**
 * <p>名称：IGPFUtils.java</p>
 * <p>描述：集成平台接口调用工具类</p>
 * <pre>
 *    IGPF即 integration platform缩写
 * </pre>
 * @author 周光暖
 * @date 2015-5-13 下午12:33:14
 * @version 1.0.0
 */
public class IGPFUtils
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(IGPFUtils.class);
	
	private static final String userId = "DOC_APP";
	private static final String password = "123";
	
	/**
	 * <p>描述：构建REQUEST字符串</p>
	 * <pre>
	 *    构建集成平台请求规范的xml格式字符串
	 * </pre>
	 * @param requstFormBean
	 * @return
	 */
	public static String buildRequestXml(Object requstFormBean)
	{
		// requstFormBean空代表没有请求，requstFormBean的属性值可以为空，代表方法请求参数为空
		// 所有 requstFormBean 直接按《查询接口规范-医护查询V1.2》的接口名称命名
		// 这里需要 requstFormBean 的类名作为调用方法的相关信息
		if (null == requstFormBean)
		{
			return null;
		}
		String methodName = requstFormBean.getClass().getSimpleName();
		Map params;
		try
		{
			params = BeanUtils.describe(requstFormBean);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
		{
			logger.error(e);
			params = Maps.newHashMap();
		}

		Document document = DocumentHelper.createDocument();

		// REQUEST
		Element REQUEST = document.addElement("REQUEST");
		// HEADER
		Element HEADER = REQUEST.addElement("HEADER");
		Element USERID = HEADER.addElement("USERID");
		USERID.setText(userId);
		Element PASSWORD = HEADER.addElement("PASSWORD");
		PASSWORD.setText(password);
		Element TRANSNO = HEADER.addElement("TRANSNO");
		TRANSNO.setText(methodName);//

		// BODY
		Element BODY = REQUEST.addElement("BODY");

		// params
		Element requestForm = BODY.addElement(methodName);
		
		
		params.remove("class");
		for (Object key : params.entrySet())
		{
			Object value = params.get(key);
			if (null != value)
			{
				requestForm.addElement(key.toString()).setText(value.toString());
			}
		}

		return document.asXML();
	}
	
	/**
	 * <p>描述：获得结果对象</p>
	 * <pre>
	 *    根据REQUEST作为参数，调用集成平台接口，返回结果
	 * </pre>
	 * @param REQUEST	集成平台请求规范的xml格式字符串
	 * @return
	 */
	public JSON getResultFromIGPF(String REQUEST)
	{
		
		String resultXmlStr = "";
		return new XMLSerializer().read(resultXmlStr);
	}
	
	@Test
	public void testname77() throws Exception
	{
		Object requstFormBean = new GET_DOC_HOS_PATIENT();
		String requestXml = IGPFUtils.buildRequestXml(requstFormBean);
		System.out.println(requestXml);
	}
}
