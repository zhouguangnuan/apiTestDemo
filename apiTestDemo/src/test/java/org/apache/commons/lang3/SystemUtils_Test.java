/*
 * @(#)SystemUtils_Test.java 2015-1-28 上午9:28:25
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import org.junit.Test;

/**
 * <p>File：SystemUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 上午9:28:25</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class SystemUtils_Test
{
	@Test
	public void test() throws Exception
	{
        System.out.println("获得系统文件分隔符.");  
        System.out.println(SystemUtils.FILE_SEPARATOR);// \
  
        System.out.println("获得源文件编码.");  
        System.out.println(SystemUtils.FILE_ENCODING);// UTF-8
  
        System.out.println("获得ext目录.");  
        System.out.println(SystemUtils.JAVA_EXT_DIRS);
        // C:\Program Files\Java\jdk1.7.0_51\jre\lib\ext;C:\Windows\Sun\Java\lib\ext  
  
        System.out.println("获得java版本.");  
        System.out.println(SystemUtils.JAVA_VM_VERSION);// 24.51-b03  
  
        System.out.println("获得java厂商.");  
        System.out.println(SystemUtils.JAVA_VENDOR);// Oracle Corporation
	}
}
