/*
 * @(#)FileUtilsTest.java 2015-2-10 下午1:55:07
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.io;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.tools.ant.filters.StringInputStream;
import org.joda.time.DateTime;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

/**
 * <p>File：FileUtilsTest.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-10 下午1:55:07</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class FileUtilsTest
{
//	private static final String filename = "D:/GitHome/git/apiDemo/apiTestDemo/src/test/java/org/apache/commons/io/testFile.txt";
//	private static final String filename = "C:/Users/txsb/Desktop/新建文件夹/log4j.properties";
	private static final String filename1 = "C:/Users/txsb/Desktop/新建文件夹/log4j.properties";
	private static final String filename2 = "C:/Users/txsb/Desktop/新建文件夹/";
	private static final String filename3 = "C:/Users/txsb/Desktop/新建文件夹/123/dfsdf/log4j2.properties";
	private static final String filename4 = "C:/Users/txsb/Desktop/Message.java";
	private static final String filename5 = "C:/Users/txsb/Desktop/22";
	private static final String filename6 = "C:/Users/txsb/Desktop/22/test.txt";
	
	// 11
	
	private File directory = FileUtils.getFile(filename2);
	private IOFileFilter fileFilter = new IOFileFilter(){
		public boolean accept(File file)
		{
			System.out.println("fileFilter:" + file.getName());
			boolean flag = file.isFile();
			return flag;
		}

		public boolean accept(File dir, String name)
		{
			System.out.println("fileFilter:" + dir.getName());
			System.out.println("fileFilter:" + name);
			return false;
		}
		
	};
	
	private IOFileFilter dirFilter = new IOFileFilter(){
		public boolean accept(File file)
		{
			System.out.println("dirFilter:" + file.getName());
			boolean flag = file.isDirectory();
			return flag;
		}

		public boolean accept(File dir, String name)
		{
			System.out.println("dirFilter:" + dir.getName());
			System.out.println("dirFilter:" + name);
			return false;
		}
	};
	
	/**
	 * 初始化文件夹
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_getFile() throws Exception
	{
		File file = FileUtils.getFile(filename1);
		if (!file.exists())
		{
			String absolutePath = file.getAbsolutePath();
			String extension = FilenameUtils.getExtension(absolutePath);
			if (StringUtils.isBlank(extension))// 表示文件夹
			{
				file.mkdirs();
			}
			else
			{
				File ParentFile = file.getParentFile();
				ParentFile.mkdirs();// 
				file.createNewFile();// 指定目录存在，才能成功创建文件。否则抛 java.io.IOException: 系统找不到指定的路径。
			}
		}
		System.out.println(file.exists()); 
	}

	/**
	 * 获得临时文件夹
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_getTempDirectory()
	{
		File file = FileUtils.getTempDirectory();
		System.out.println("file AbsolutePath：" + file.getAbsolutePath());// C:/Users/txsb/AppData/Local/Temp
	}
	
	/**
	 * 获得临时文件夹路径
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_getTempDirectoryPath() throws Exception
	{
		System.out.println(FileUtils.getTempDirectoryPath());// C:/Users/txsb/AppData/Local/Temp/
	}

	@Test
	public void test_getUserDirectoryPath()
	{
		System.out.println(FileUtils.getUserDirectoryPath());// C:/Users/txsb
	}

	@Test
	public void test_getUserDirectory()
	{
		File file = FileUtils.getUserDirectory();
		System.out.println("file AbsolutePath：" + file.getAbsolutePath());// C:/Users/txsb
	}

	/**
	 * 获得文件输入流（不是文件会报错）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_openInputStream() throws Exception
	{
		File file = FileUtils.getFile(filename1);
		FileInputStream in = FileUtils.openInputStream(file);
		
		//将键盘的输入流转换为字符流
		InputStreamReader isr = new InputStreamReader(in);
		//将字符流转为缓冲字符输入流
		BufferedReader reader = new BufferedReader(isr);
		String line = null;
		while((line=reader.readLine()) != null){
			System.out.println("输入的是：" + line);
		}
	}

	/**
	 * 获得文件输出流（不是文件会报错）
	 * 路径目录不存在会创建
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_openOutputStream() throws Exception
	{
		File file = FileUtils.getFile(filename1);
		FileOutputStream output = FileUtils.openOutputStream(file);
		// java.io.FileNotFoundException: C:/Users/txsb/Desktop/新建文件夹/log4j.properties (系统找不到指定的路径。)
//		FileOutputStream output = new FileOutputStream(file);
//		output.write("abc".getBytes());
		IOUtils.closeQuietly(output);
	}

	/**
	 * 字节计数显示大小
	 * 
	 * @author 周光暖
	 */
	@Test
	public void test_byteCountToDisplaySize()
	{
		System.out.println(FileUtils.byteCountToDisplaySize(BigInteger.valueOf(100l)));// 100 bytes
	}

	/**
	 * 更新文件修改时间
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_touch() throws Exception
	{
		File file = FileUtils.getFile(filename1);
		FileUtils.touch(file);
	}

	/**
	 * 数组转换文件收集文件
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_convertFileCollectionToFileArray() throws Exception
	{
		Collection<File> list = FileUtils.listFiles(directory, fileFilter, dirFilter);
		File[] files = FileUtils.convertFileCollectionToFileArray(list);
		URL[] urls = FileUtils.toURLs(files);
		System.out.println(JSON.toJSONString(urls));
	}

	/**
	 * 列表指定路径下的所有文件（不包括文件夹）
	 * File 			directory		列表的目录路径
	 * IOFileFilter 	fileFilter		必填，过滤查询所需文件
	 * IOFileFilter 	dirFilter		选填，过滤所需查询的子目录（null时不查询子目录）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_listFiles() throws Exception
	{
		Collection<File> files = FileUtils.listFiles(directory, fileFilter, dirFilter);
		int i = 0;
		for(File file : files)
		{
			if (i==0) System.out.println();
			System.out.println("files[" + i + "]: " + file.getName());
			i++;
		}
	}

	/**
	 * 列表指定路径下的所有文件（包括文件夹）
	 * File 			directory		列表的目录路径
	 * IOFileFilter 	fileFilter		必填，过滤查询所需文件
	 * IOFileFilter 	dirFilter		选填，过滤所需查询的子目录（null时不查询子目录）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_listFilesAndDirs() throws Exception
	{
		Collection<File> files = FileUtils.listFilesAndDirs(directory, fileFilter, dirFilter);
		int i = 0;
		for(File file : files)
		{
			if (i==0) System.out.println();
			System.out.println("files[" + i + "]: " + file.getName());
			i++;
		}
	}

	@Test
	public void test_iterateFiles() throws Exception
	{
		Iterator<File> iterator = FileUtils.iterateFiles(directory, fileFilter, dirFilter);
		int i = 0;
		while (iterator.hasNext())
		{
			if (i==0) System.out.println();
			File file = iterator.next();
			System.out.println("files[" + i + "]: " + file.getName());
			i++;
		}
	}

	@Test
	public void test_iterateFilesAndDirs()
	{
		Iterator<File> iterator = FileUtils.iterateFilesAndDirs(directory, fileFilter, dirFilter);
		int i = 0;
		while (iterator.hasNext())
		{
			if (i==0) System.out.println();
			File file = iterator.next();
			System.out.println("files[" + i + "]: " + file.getName());
			i++;
		}
	}

	/**
	 * 判断是否为同一个文件（不能比较文件夹）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_contentEquals() throws Exception
	{
		File file1 = FileUtils.getFile(filename1);
		File file2 = FileUtils.getFile(filename3);
		System.out.println("contentEquals: " + FileUtils.contentEquals(file1, file2));
	}

	@Test
	public void test_contentEqualsIgnoreEOL() throws Exception
	{
		File file1 = FileUtils.getFile(filename1);
		File file2 = FileUtils.getFile(filename3);
		boolean flag = FileUtils.contentEqualsIgnoreEOL(file1, file2, CharEncoding.UTF_8);
		System.out.println("contentEquals: " + flag);
	}

	@Test
	public void test_toFile() throws Exception
	{
//		[
//		 file:/C:/Users/txsb/Desktop/新建文件夹/123/dfsdf/log4j2.properties, 
//		 file:/C:/Users/txsb/Desktop/新建文件夹/123/dfsdf/log4j2.properties.bak, 
//		 file:/C:/Users/txsb/Desktop/新建文件夹/log4j.properties, 
//		 file:/C:/Users/txsb/Desktop/新建文件夹/log4j.properties.bak
//		]
		URL url = new URL("file:/C:/Users/txsb/Desktop/新建文件夹/123/dfsdf/log4j2.properties");
		File file = FileUtils.toFile(url);
		System.out.println(file);
	}

	@Test
	public void test_toFiles()
	{
		URL[] urls = null;
		File[] files = FileUtils.toFiles(urls);
	}

	@Test
	public void test_toURLs() throws Exception
	{
		
	}

	/**
	 * 拷贝文件到指定目录
	 * File 	srcFile		被拷贝的文件		（非空，必须文件）
	 * File 	destDir		保存备份文件的目录	（非空，必须目录）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_copyFileToDirectory() throws Exception
	{
		File srcFile = FileUtils.getFile(filename3);
		File destDir = FileUtils.getFile(filename2);	
		FileUtils.copyFileToDirectory(srcFile, destDir);
	}

	/**
	 * 拷贝文件到指定文件
	 * File 	srcFile		被拷贝的文件		（非空，必须文件）
	 * File 	destDir		保存备份文件的目录	（非空，必须文件）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_copyFile() throws Exception
	{
		File srcFile = FileUtils.getFile(filename3);
		File destDir = FileUtils.getFile(filename4);	
		FileUtils.copyFile(srcFile, destDir);
	}

	/**
	 * 拷贝目录到指定目录
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_copyDirectoryToDirectory() throws Exception
	{
		File srcFile = FileUtils.getFile(directory);
		File destDir = FileUtils.getFile(filename2);	
		FileUtils.copyDirectoryToDirectory(srcFile, destDir);
	}

	@Test
	public void test_copyDirectory() throws Exception
	{
		File srcFile = FileUtils.getFile(directory);
		File destDir = FileUtils.getFile(filename5);	
		FileUtils.copyDirectory(srcFile, destDir);
	}

	/**
	 * 从输入流拷贝到指定文件
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_copyInputStreamToFile() throws Exception
	{
		FileInputStream source = FileUtils.openInputStream(FileUtils.getFile(filename1));
		File destination = FileUtils.getFile(filename6);
		FileUtils.copyInputStreamToFile(source, destination);
	}

	/**
	 * 删除目录
	 * @throws C:/Users/txsb/Desktop/新建文件夹/Message.txt is not a directory
	 * @author 周光暖
	 */
	@Test
	public void test_deleteDirectory() throws Exception
	{
		File file = FileUtils.getFile(filename1);
		FileUtils.deleteDirectory(file);
	}

	/**
	 * 平静的删除（不会抛出异常）
	 * 如果是文件夹时，删除文件夹包括其内的所有文件
	 * @author 周光暖
	 */
	@Test
	public void test_deleteQuietly()
	{
		File file = FileUtils.getFile(filename1);
		FileUtils.deleteQuietly(file);
	}

	/**
	 * 判断目录是否包含指定目录
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_directoryContains() throws Exception
	{
		File directory = FileUtils.getFile(filename2);
		File child = FileUtils.getFile(filename3);
		System.out.println(FileUtils.directoryContains(directory, child));
	}

	/**
	 * 清空指定目录
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_cleanDirectory() throws Exception
	{
		FileUtils.cleanDirectory(FileUtils.getFile(filename2));
	}

	/**
	 * 进程等待阻塞，直到指定路径的文件存在，才返回
	 * 用于确保指定路径的文件创建成功
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_waitFor() throws Exception
	{
		File file = FileUtils.getFile(filename1);
		int seconds = 60;
		System.out.println("waitFor[" + DateTime.now().toString("HH:mm:ss") + "]: " + FileUtils.waitFor(file, seconds));
	}

	/**
	 * 将文件内容转为String
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_readFileToString() throws Exception
	{
		System.out.println(FileUtils.readFileToString(FileUtils.getFile(filename6)));
//		System.out.println(FileUtils.readFileToString(FileUtils.getFile(filename6), Charsets.UTF_8));
//		System.out.println(FileUtils.readFileToString(FileUtils.getFile(filename6), CharEncoding.UTF_8));
	}

	/**
	 * 将文件转为流
	 * File directory 必须为文件（非目录）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_readFileToByteArray() throws Exception
	{
		File directory = FileUtils.getFile(filename1);
		byte[] byteArray = FileUtils.readFileToByteArray(directory);
		System.out.println(byteArray);
	}

	/**
	 * 逐行读取文件内容到List<String>
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_readLines() throws Exception
	{
//		File directory = FileUtils.getFile(filename1);
		File directory = FileUtils.getFile(filename1);
		List<String> strs = FileUtils.readLines(directory);
		System.out.println(JSON.toJSONString(strs));
	}

	@Test
	public void test_lineIterator() throws Exception
	{
	}

	/**
	 * 向文件写内容
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_writeStringToFile() throws Exception
	{
		String data = "中国";
		File directory = FileUtils.getFile("C:/Users/Administrator/Desktop/test.json");
		FileUtils.writeStringToFile(directory, data, CharEncoding.UTF_8);
	}

	/**
	 * 向文件写内容
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_write() throws Exception
	{
		String data = "\n 555555555555";
		File directory = FileUtils.getFile(filename1);
		FileUtils.write(directory, data, CharEncoding.UTF_8, true);
	}

	@Test
	public void test_writeByteArrayToFile() throws Exception
	{
	}

	@Test
	public void test_writeLines() throws Exception
	{
		Collection<String> lines = Arrays.asList("123", "456", "789");
		File directory = FileUtils.getFile(filename1);
		FileUtils.writeLines(directory, lines);
	}

	@Test
	public void test_forceDelete() throws Exception
	{
//		FileUtils.forceDelete(file);
	}

	@Test
	public void test_forceDeleteOnExit() throws Exception
	{
	}

	@Test
	public void test_forceMkdir() throws Exception
	{
	}

	@Test
	public void test_sizeOf() throws Exception
	{
	}

	@Test
	public void test_sizeOfAsBigInteger() throws Exception
	{
	}

	/**
	 * 指定目录文件的大小
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_sizeOfDirectory() throws Exception
	{
		System.out.println(FileUtils.sizeOfDirectory(directory));// 15 字节
	}

	@Test
	public void test_sizeOfDirectoryAsBigInteger() throws Exception
	{
	}

	/**
	 * 判断文件是否是新文件（跟其它文件比、...）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test_isFileNewer() throws Exception
	{
		System.out.println(FileUtils.isFileNewer(directory, FileUtils.getFile(filename6)));
	}

	@Test
	public void test_isFileOlder() throws Exception
	{
	}

	@Test
	public void test_checksumCRC32() throws Exception
	{
		System.out.println(FileUtils.checksumCRC32(FileUtils.getFile(filename6)));
	}

	@Test
	public void test_checksum() throws Exception
	{
	}

	@Test
	public void test_moveDirectory() throws Exception
	{
		FileUtils.getFile(filename6);
//		FileUtils.moveDirectory(srcDir, destDir);
	}

	@Test
	public void test_moveDirectoryToDirectory() throws Exception
	{
	}

	@Test
	public void test_moveFile() throws Exception
	{
	}

	@Test
	public void test_moveFileToDirectory() throws Exception
	{
	}

	@Test
	public void test_moveToDirectory() throws Exception
	{
	}

	@Test
	public void test_isSymlink() throws Exception
	{
		// ????
		File directory = FileUtils.getFile("sdfd");
		System.out.println(FileUtils.isSymlink(directory));
	}
	
	@Test
	public void test_download() throws Exception
	{
		URL url = new URL("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQFK8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL3kweXE0T3JscWY3UTltc3ZPMklvAAIEG9jUUgMECAcAAA%3d%3d");
		byte[] bytest =  IOUtils.toByteArray(url.openStream());
		new FileOutputStream("C:\\Users\\Administrator\\Desktop\\ss.jpg").write(bytest);
	}
}
