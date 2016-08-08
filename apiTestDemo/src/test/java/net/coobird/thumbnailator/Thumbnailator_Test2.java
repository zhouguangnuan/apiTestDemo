/*
 * @(#)Thumbnailator_Test.java 2015-1-28 下午2:34:22
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package net.coobird.thumbnailator;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.singno.utils.PathUtils;

/**
 * <p>File：Thumbnailator_Test.java</p>
 * <p>Title: 图片开源工具</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午2:34:22</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class Thumbnailator_Test2
{
	/**
	 * 水印
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test5() throws Exception
	{
		Thumbnails.of(getAbsolutePath("huangliqin.png"))
		.size(180, 180)
		.outputFormat("png")
		// 水印设置
		.watermark(
				Positions.BOTTOM_CENTER,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.png"))),// 水印图
				1f)// 透明度
				.toFile(getAbsolutePath("huangliqin_new"));
	}
	
	@Test
	public void testName() throws Exception {
		String imaUrl = "http://localhost:8880/static/img/81.png";
		String imaName = StringUtils.substring(imaUrl, imaUrl.lastIndexOf("/")+1);
		String imaSuffix = StringUtils.substring(imaName, imaName.lastIndexOf(".")+1);
		System.out.println(imaName); 
		System.out.println(imaSuffix); 
	}
	
	// ========================================================================
	/**
	 * 获得文件的绝对路径
	 * @param fileName
	 * @return
	 * @throws Exception
	 * @author 周光暖
	 */
	private String getAbsolutePath(String fileName) throws Exception
	{
		return PathUtils.getJavaFileAbsolutePath(this.getClass(), "/") + "/" + fileName;
	}
}
