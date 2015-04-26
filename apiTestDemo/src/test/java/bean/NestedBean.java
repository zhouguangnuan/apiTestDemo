/*
 * @(#)NestedBean.java 2015-1-28 下午8:14:10
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package bean;

import java.util.List;

/**
 * <p>File：NestedBean.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午8:14:10</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class NestedBean
{
	private String nestedProperty; 

	private List<String> infos;
	
	public String getNestedProperty()
	{
		return this.nestedProperty;
	}

	public void setNestedProperty(String nestedProperty)
	{
		this.nestedProperty = nestedProperty;
	}

	public List<String> getInfos()
	{
		return infos;
	}

	public void setInfos(List<String> infos)
	{
		this.infos = infos;
	}
}
