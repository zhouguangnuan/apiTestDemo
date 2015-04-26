/*
 * @(#)PathUtil.java 2015-1-28 下午3:58:46
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.singno.utils;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>File：PathUtil.java</p>
 * <p>Title: 获得路径的工具类</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午3:58:46</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class PathUtils
{
	/**
	 * 获得指定类.java文件的绝对路径，简限test使用
	 * @param clazz
	 * @return
	 * @author 周光暖
	 */
	public static String getJavaFileAbsolutePath(Class<?> clazz, String fileSeparator)
	{
		String path = clazz.getResource(fileSeparator).getPath();
		path = StringUtils.replaceOnce(path, "target"+fileSeparator+"classes", "src"+fileSeparator+"main"+fileSeparator+"java");
		path = StringUtils.replaceOnce(path, "target"+fileSeparator+"test-classes", "src"+fileSeparator+"test"+fileSeparator+"java");
		path = StringUtils.removeStart(path, fileSeparator);
		path += StringUtils.replace(ClassUtils.getPackageName(clazz), ".", fileSeparator);
		return path;
	}
}
