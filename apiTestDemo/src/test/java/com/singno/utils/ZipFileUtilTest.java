package com.singno.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.CharEncoding;
import org.junit.Test;

import com.google.common.base.Charsets;

/**
 * 测试ZipFileUtil的压缩和解压缩方法
 * 
 * @author Luxh
 */
public class ZipFileUtilTest
{
	@Test
	public void testCompressFiles2Zip()
	{
		// 存放待压缩文件的目录
		File srcFile = new File("C:\\Users\\Administrator\\Desktop\\11.txt");
		// 压缩后的zip文件路径
		String zipFilePath = "C:\\Users\\Administrator\\Desktop\\22.zip";
		if (srcFile.exists())
		{
			File[] files = srcFile.listFiles();
			ZipFileUtil.compressFiles2Zip(files, zipFilePath);
		}
	}

	@Test
	public void testDecompressZip()
	{
		// 压缩包所在路径
		String zipFilePath = "d:/test2/test.zip";
		// 解压后的文件存放目录
		String saveFileDir = "d:/test2/";
		// 调用解压方法
		ZipFileUtil.decompressZip(zipFilePath, saveFileDir);
	}

	@Test
	public void testname() throws Exception
	{
		File file = new File("C:\\Users\\Administrator\\Desktop\\11.zip");
		if (file.exists())
		{
			InputStream is = null;
			ZipArchiveInputStream zais = null;
			ByteArrayOutputStream os = null;
			try
			{
				is = new FileInputStream(file);
				zais = new ZipArchiveInputStream(is);
				os = new ByteArrayOutputStream();
				
				while (null != zais.getNextEntry())
				{
				        int b;
				        while ((b =  zais.read()) != -1)
                                        {
	                                        os.write(b);
                                        }
				}
				
				System.out.println(new String(os.toByteArray(), "GBK"));
			} catch (Exception e)
			{
				e.printStackTrace();
			} 
			finally
			{
				if (is != null) is.close();
				if (zais != null) zais.close();
				if (os != null) os.close();
			}
		}
	}
}