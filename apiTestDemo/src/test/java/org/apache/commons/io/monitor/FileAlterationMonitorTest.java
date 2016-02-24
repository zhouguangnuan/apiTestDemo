/*
 * @(#)FileAlterationObserverTest.java 2015-2-10 下午1:40:09
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.io.monitor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Test;

/**
 * <p>
 * File：FileAlterationObserverTest.java
 * </p>
 * <p>
 * Title: 文件修改监视器类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015 2015-2-10 下午1:40:09
 * </p>
 * <p>
 * Company: 8637.com
 * </p>
 * 
 * @author 周光暖
 * @version 1.0
 */
public class FileAlterationMonitorTest
{
	private static final String parentDir = "C:/Users/txsb/Desktop";

	@Test
	public void testname() throws Exception
	{
		// 初始化观察者，确定观察的目录
		FileAlterationObserver observer = new FileAlterationObserver(parentDir);
		// 添加监听器
		observer.addListener(new FileAlterationListenerAdaptor()
		{

			@Override
			public void onFileCreate(File file)
			{
				System.out.println("File created: " + file.getName());
			}

			@Override
			public void onFileDelete(File file)
			{
				System.out.println("File deleted: " + file.getName());
			}

			@Override
			public void onDirectoryCreate(File dir)
			{
				System.out.println("Directory created: " + dir.getName());
			}

			@Override
			public void onDirectoryDelete(File dir)
			{
				System.out.println("Directory deleted: " + dir.getName());
			}
			
			@Override
			public void onFileChange(File dir)
			{
				System.out.println("onFileChange: " + dir.getName());
			}
		});

		// 创建监视器
		FileAlterationMonitor monitor = new FileAlterationMonitor(500, observer);
		try
		{
			monitor.start();

			Thread.sleep(1000000);// 这期间在桌面新增/删除（文件/文件夹），观察结果

			monitor.stop();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testname2() throws Exception
        {
		PropertiesConfiguration config = new PropertiesConfiguration(parentDir + "/test.properties");
//		config.setFile(new File(parentDir + "/test.properties"));
		config.setProperty("id2222", "sss223332111111");  
		config.save(); 
        }
}
