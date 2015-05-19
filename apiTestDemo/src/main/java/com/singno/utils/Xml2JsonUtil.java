/**
 * <p>项目名：</p>
 * <p>包名：com.singno.utils</p>
 * <p>文件名：Xml2JsonUtil.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-13-上午9:35:17</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.singno.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>名称：Xml2JsonUtil.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-13 上午9:35:17
 * @version 1.0.0
 */
public class Xml2JsonUtil
{
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(Xml2JsonUtil.class);
	
	/**
	 * 转换一个xml格式的字符串到json格式
	 * 
	 * @param xml
	 *                xml格式的字符串
	 * @return 成功返回json 格式的字符串;失败反回null
	 */
	@SuppressWarnings("unchecked")
	public static String xml2JSON(String xml)
	{
		JSONObject obj = new JSONObject();
		try
		{
			InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(is);
			Element root = doc.getRootElement();
			obj.put(root.getName(), iterateElement(root));
			return obj.toString();
		} catch (Exception e)
		{
			log.error("传入XML后转换JSON出现错误===== Xml2JsonUtil-->xml2JSON============>>",
					e);
			return null;
		}
	}

	/**
	 * 转换一个xml格式的字符串到json格式
	 * 
	 * @param file
	 *                java.io.File实例是一个有效的xml文件
	 * @return 成功反回json 格式的字符串;失败反回null
	 */
	@SuppressWarnings("unchecked")
	public static String xml2JSON(File file)
	{
		JSONObject obj = new JSONObject();
		try
		{
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(file);
			Element root = doc.getRootElement();
			obj.put(root.getName(), iterateElement(root));
			return obj.toString();
		} catch (Exception e)
		{
			log.error("传入文件后转换JSON出现错误====Xml2JsonUtil-->xml2JSON=============>>",
					e);
			return null;
		}
	}

	/**
	 * 一个迭代方法
	 * 
	 * @param element
	 *                : org.jdom.Element
	 * @return java.util.Map 实例
	 */
	@SuppressWarnings("unchecked")
	private static Map iterateElement(Element element)
	{
		List jiedian = element.getChildren();
		Element et = null;
		Map obj = new HashMap();
		List list = null;
		for (int i = 0; i < jiedian.size(); i++)
		{
			list = new LinkedList();
			et = (Element) jiedian.get(i);
			if (et.getTextTrim().equals(""))
			{
				if (et.getChildren().size() == 0)
					continue;
				if (obj.containsKey(et.getName()))
				{
					list = (List) obj.get(et.getName());
				}
				list.add(iterateElement(et));
				obj.put(et.getName(), list);
			} else
			{
				if (obj.containsKey(et.getName()))
				{
					list = (List) obj.get(et.getName());
				}
				list.add(et.getTextTrim());
				obj.put(et.getName(), list);
			}
		}
		return obj;
	}
}
