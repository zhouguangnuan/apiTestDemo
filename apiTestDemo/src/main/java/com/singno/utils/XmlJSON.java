/**
 * <p>项目名：</p>
 * <p>包名：com.singno.utils</p>
 * <p>文件名：XmlJSON.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-13-上午10:24:59</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package com.singno.utils;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * <p>
 * 名称：XmlJSON.java
 * </p>
 * <p>
 * 描述：
 * </p>
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author 周光暖
 * @date 2015-5-13 上午10:24:59
 * @version 1.0.0
 */
public class XmlJSON
{
	public static String xml2JSON(String xml)
	{
		return new XMLSerializer().read(xml).toString();
	}

	public static String json2XML(String json)
	{
		JSONObject jobj = JSONObject.fromObject(json);
		String xml = new XMLSerializer().write(jobj);
		return xml;
	}
}
