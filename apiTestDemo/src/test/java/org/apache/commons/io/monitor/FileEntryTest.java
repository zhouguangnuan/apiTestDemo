/*
 * @(#)FileEntryTest.java 2015-2-10 下午5:52:09
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.io.monitor;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * <p>File：FileEntryTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 下午5:52:09</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class FileEntryTest
{
	private File file1 = FileUtils.getFile("C:/Users/txsb/Desktop/Message.java");
	private File file2 = FileUtils.getFile("C:/Users/txsb/Desktop/22/新建文件夹/123/dfsdf/log4j2.properties");
	
	@Test
	public void testname() throws Exception
	{
		System.out.println(file2.getName());
		FileEntry fileEntry = new FileEntry(file2);
		
		System.out.println("isExists：" + fileEntry.isExists());
		System.out.println("getLevel：" + fileEntry.getLevel());
	}
}
