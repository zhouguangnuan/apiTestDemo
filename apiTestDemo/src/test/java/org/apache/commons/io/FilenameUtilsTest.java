/*
 * @(#)FilenameUtilsTest.java 2015-2-10 上午11:05:15
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.io;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

/**
 * <p>File：FilenameUtilsTest.java</p>
 * <p>Title: 文件名工具类</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 上午11:05:15</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class FilenameUtilsTest
{
	
//	private static final String FILE_PATH = "D:/GitHome/git/apiDemo/apiTestDemo/src/test_/java/org/apache/commons/io/test_File.txt";
	
	private static final String filename = "testFile.txt";// 文件名
	private static final String fullFilename = "D:/org/apache/commons/io/testFile.txt";// 全路径名
	private static final String basePath = "D:/org/apache/commons/io";// 路径 
	private static final String parentPath = "D:/org/apache/";// 父级路径
	
	
	/**
	 * 获得完整路径
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getFullPath()
	{
		// D:/org/apache/commons/io/
		System.out.println("test_getFullPath：" + FilenameUtils.getFullPath(fullFilename));
	}
	
	/**
	 * 获得文件名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getName()
	{
		// testFile.txt
		System.out.println("getName：" + FilenameUtils.getName(fullFilename));
	}

	/**
	 * 获得基本文件名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getBaseName()
	{
		// testFile
		System.out.println("getBaseName：" + FilenameUtils.getBaseName("http://localhost:8880/static/img/activity1/577BC6AA80DC4F818EBEA539D30DB494.jpg"));
//		System.out.println("getBaseName：" + FilenameUtils.getBaseName(fullFilename));
	}

	/**
	 * 获得扩展名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getExtension()
	{
		// txt
		System.out.println("getExtension：" + FilenameUtils.getExtension(fullFilename));
	}
	
	/**
	 * 判断文件是否包含指定的后缀
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_isExtension()
	{
		Collection<String> extensions = Arrays.asList("png", "jpg");
		System.out.println("isExtension：" + FilenameUtils.isExtension(filename, extensions));
	}
	
	/**
	 * 比较两文件名是否相同（不区分分隔符）
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_equalsNormalized()
	{
		String windows_fileName = FilenameUtils.separatorsToWindows(fullFilename);
		String unix_fileName = FilenameUtils.separatorsToUnix(fullFilename);
		System.out.println("windows_fileName：" + windows_fileName);
		System.out.println("unix_fileName：" + unix_fileName);
		System.out.println("equalsNormalized：" + FilenameUtils.equalsNormalized(windows_fileName, windows_fileName));// true
		System.out.println("equalsNormalized：" + FilenameUtils.equalsNormalized(windows_fileName, unix_fileName));// true
	}
	
	/**
	 * 移除扩展名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_removeExtension()
	{
		// txt
		System.out.println("removeExtension：" + FilenameUtils.removeExtension(fullFilename));
	}
	
	/**
	 * 通配符匹配文件名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_wildcardMatch()
	{
//		String wildcardMatcher = "*.txt";// true
//		String wildcardMatcher = "D:*";// true
		String wildcardMatcher = "D:/org/*/testFile.txt";// true
		System.out.println("wildcardMatch：" + FilenameUtils.wildcardMatch(fullFilename, wildcardMatcher));
	}
	
	// ================================================================================================================
	
	/**
	 * 拼接路径和文件名，获得全路径名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_concat()
	{
		// D:\org\apache\commons\io\testFile.txt
		System.out.println("test_concat：" + FilenameUtils.concat(basePath, filename));
	}

	/**
	 * 判断父目录是否包含子目录
	 * @throws IOException
	 * @author 周光暖
	 */
	@Test
	public void test_directoryContains() throws IOException
	{
		System.out.println("test_directoryContains：" + FilenameUtils.directoryContains(parentPath, basePath));
	}

	/**
	 * 获得unix系统分隔符的文件名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_separatorsToUnix()
	{
		// D:/org/apache/commons/io/testFile.txt
		System.out.println("test_separatorsToUnix：" + FilenameUtils.separatorsToUnix(fullFilename));
	}

	/**
	 * 获得windows系统分隔符的文件名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_separatorsToWindows()
	{
		// D:\org\apache\commons\io\testFile.txt
		System.out.println("test_separatorsToWindows：" + FilenameUtils.separatorsToWindows(fullFilename));
	}

	/**
	 * 获得当前系统分隔符的文件名
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_separatorsToSystem()
	{
		// D:\org\apache\commons\io\testFile.txt
		System.out.println("test_separatorsToSystem：" + FilenameUtils.separatorsToSystem(fullFilename));
	}

	/**
	 * 获得文件后缀长度
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getPrefixLength()
	{
		System.out.println("test_getPrefixLength：" + FilenameUtils.getPrefixLength(fullFilename));// 3
	}

	/**
	 * 获得最后分隔符的下标
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_indexOfLastSeparator()
	{
		System.out.println("test_indexOfLastSeparator：" + FilenameUtils.indexOfLastSeparator(parentPath));// 13
	}

	/**
	 * 获得扩展名前.的下标
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_indexOfExtension()
	{
		System.out.println("test_indexOfExtension：" + FilenameUtils.indexOfExtension(filename));// 8
	}

	@Test
	public void test_getPrefix()
	{
		System.out.println("test_getPrefix：" + FilenameUtils.getPrefix(fullFilename));// D:/
	}

	/**
	 * 获得文件路径
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getPath()
	{
		// org/apache/commons/io/
		System.out.println("test_getPath：" + FilenameUtils.getPath(fullFilename));
	}

	/**
	 * 获得文件所在目录的路径
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_getPathNoEndSeparator()
	{
		// org/apache/commons/io
		System.out.println("test_getPathNoEndSeparator：" + FilenameUtils.getPathNoEndSeparator(fullFilename));
	}

	@Test
	public void test_getFullPathNoEndSeparator()
	{
		// D:/org/apache/commons/io
		System.out.println("getFullPathNoEndSeparator：" + FilenameUtils.getFullPathNoEndSeparator(fullFilename));
	}

	/**
	 * 比较两文件名是否相同（区分分隔符）
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_equalsOnSystem()
	{
		String windows_fileName = FilenameUtils.separatorsToWindows(fullFilename);
		String unix_fileName = FilenameUtils.separatorsToUnix(fullFilename);
		System.out.println("windows_fileName：" + windows_fileName);
		System.out.println("unix_fileName：" + unix_fileName);
		System.out.println("equalsOnSystem：" + FilenameUtils.equalsOnSystem(windows_fileName, windows_fileName));// true
		System.out.println("equalsOnSystem：" + FilenameUtils.equalsOnSystem(windows_fileName, unix_fileName));// false
	}

	@Test
	public void test_equalsNormalizedOnSystem()
	{
		String windows_fileName = FilenameUtils.separatorsToWindows(fullFilename);
		String unix_fileName = FilenameUtils.separatorsToUnix(fullFilename);
		System.out.println("windows_fileName：" + windows_fileName);
		System.out.println("unix_fileName：" + unix_fileName);
		System.out.println("equalsNormalizedOnSystem：" + FilenameUtils.equalsNormalizedOnSystem(windows_fileName, windows_fileName));// true
		System.out.println("equalsNormalizedOnSystem：" + FilenameUtils.equalsNormalizedOnSystem(windows_fileName, unix_fileName));// true
	}

	@Test
	public void test_equals()
	{
		String windows_fileName = FilenameUtils.separatorsToWindows(fullFilename);
		String unix_fileName = FilenameUtils.separatorsToUnix(fullFilename);
		System.out.println("windows_fileName：" + windows_fileName);
		System.out.println("unix_fileName：" + unix_fileName);
		System.out.println("equals：" + FilenameUtils.equals(windows_fileName, windows_fileName));// true
		System.out.println("equals：" + FilenameUtils.equals(windows_fileName, unix_fileName));// false
	}

	@Test
	public void test_wildcardMatchOnSystem()
	{
//		String wildcardMatcher = "*.txt";// true
//		String wildcardMatcher = "D:*";// true
		String wildcardMatcher = "D:/org/*/testFile.txt";// true
		System.out.println("wildcardMatchOnSystem：" + FilenameUtils.wildcardMatchOnSystem(fullFilename, wildcardMatcher));
	}
}
