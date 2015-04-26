/*
 * @(#)SampleBean.java 2015-1-28 下午8:12:50
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package bean;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>File：SampleBean.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午8:12:50</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class SampleBean 
{
	private String				name;
	private Integer				age;
	private String[]			array;
	private List<String>		list;
	private Map<String, String>	map;
	private NestedBean			nestedBean;
	private List<NestedBean> 	beans;
	private Date				date;
	private URL					url;

	public SampleBean()
	{
		super();
	}
	
	public SampleBean(String name, Integer age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String[] getArray()
	{
		return array;
	}

	public void setArray(String[] array)
	{
		this.array = array;
	}

	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}

	public Map<String, String> getMap()
	{
		return map;
	}

	public void setMap(Map<String, String> map)
	{
		this.map = map;
	}

	public NestedBean getNestedBean()
	{
		return nestedBean;
	}

	public void setNestedBean(NestedBean nestedBean)
	{
		this.nestedBean = nestedBean;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public URL getUrl()
	{
		return url;
	}

	public void setUrl(URL url)
	{
		this.url = url;
	}

	public List<NestedBean> getBeans()
	{
		return beans;
	}

	public void setBeans(List<NestedBean> beans)
	{
		this.beans = beans;
	}
}
