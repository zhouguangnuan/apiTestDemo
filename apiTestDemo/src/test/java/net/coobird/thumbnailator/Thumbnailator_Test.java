/*
 * @(#)Thumbnailator_Test.java 2015-1-28 下午2:34:22
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package net.coobird.thumbnailator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.geometry.Positions;

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
public class Thumbnailator_Test
{
	/**
	 * 按照指定尺寸进行缩放
	 * 若图片横比200小，高比100小，图片按比例拉伸，横为200或高为100
	 * 若图片横比200小，高比100大，高缩小到100，图片比例不变
	 * 若图片横比200大，高比100小，横缩小到200，图片比例不变
	 * 若图片横比200大，高比100大，图片按比例缩小，横为200或高为100
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test1() throws Exception
	{
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(200, 100)// 指定尺寸
		.outputFormat("jpg")// 输出格式（默认：JPEG）（该处如果设值，文件名不用加后缀）
//		.outputQuality(0.75f)// 输出质量（0.0f~1.0f）：默认 0.7f
		.toFile(getAbsolutePath("test1_1"));// 输出的文件
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(900, 200)// 指定尺寸
		.outputFormat("jpg")
		.toFile(getAbsolutePath("test1_2"));

		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(2560, 2048)
		.outputFormat("jpg")
		.toFile(getAbsolutePath("test1_3"));
		
		Thumbnails.of(getAbsolutePath("test1_1.jpg"))
		.size(400, 200)// 指定尺寸
		.outputFormat("jpg")
		.toFile(getAbsolutePath("test1_4"));
	}
	
	/**
	 * 按照指定比例进行缩放
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test2() throws Exception
	{
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.scale(0.25f)// 比例
		.outputFormat("jpg")// 输出格式（该处如果设值，文件名不用加后缀）
		.toFile(getAbsolutePath("test2_1"));

		Thumbnails.of(getAbsolutePath("old.jpg"))
		.scale(1.10f)
		.outputFormat("jpg")
		.toFile(getAbsolutePath("test2_2"));
	}
	
	/**
	 * 不按照比例，指定大小进行缩放
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test3() throws Exception
	{
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(200, 900)
		.outputFormat("jpg")
		.keepAspectRatio(false)// 默认是按照比例缩放的
		.toFile(getAbsolutePath("test3"));
	}
	
	/**
	 * 旋转
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test4() throws Exception
	{
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		.rotate(90)// (角度),正数：顺时针 负数：逆时针
		.toFile(getAbsolutePath("test4_1"));

		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		.rotate(-90)
		.toFile(getAbsolutePath("test4_2")); 
	}
	
	/**
	 * 水印
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test5() throws Exception
	{
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.TOP_LEFT,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				1.0f)// 透明度
				.toFile(getAbsolutePath("test5_1"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.TOP_CENTER,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.9f)// 透明度
				.toFile(getAbsolutePath("test5_2"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.TOP_RIGHT,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.8f)// 透明度
				.toFile(getAbsolutePath("test5_3"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
			Positions.CENTER_LEFT,// 位置
			ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
			0.7f)// 透明度
		.toFile(getAbsolutePath("test5_4"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.CENTER,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.6f)// 透明度
				.toFile(getAbsolutePath("test5_5"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.CENTER_RIGHT,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.5f)// 透明度
				.toFile(getAbsolutePath("test5_6"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.BOTTOM_LEFT,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.4f)// 透明度
				.toFile(getAbsolutePath("test5_7"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.BOTTOM_CENTER,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.3f)// 透明度
				.toFile(getAbsolutePath("test5_8"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.outputFormat("jpg")
		// 水印设置
		.watermark(
				Positions.BOTTOM_RIGHT,// 位置
				ImageIO.read(new File(getAbsolutePath("watermark.jpg"))),// 水印图
				0.2f)// 透明度
				.toFile(getAbsolutePath("test5_9"));
	}
	
	/**
	 * 裁剪
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test6() throws Exception
	{
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.sourceRegion(
			Positions.CENTER,// 原图位置：中心 
			400,// width
			400)// height
		.size(200, 200)
		.keepAspectRatio(false)
		.toFile(getAbsolutePath("test6_1.jpg"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.sourceRegion(
			Positions.BOTTOM_RIGHT,// 原图位置：中心 
			400,// width
			400)// height
			.size(200, 200)
		.keepAspectRatio(false)
		.toFile(getAbsolutePath("test6_2.jpg"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.sourceRegion(
			0,// x 坐标
			0,// y 坐标
			400,// width
			300)// height
		.size(200, 200)
		.keepAspectRatio(false)
		.toFile(getAbsolutePath("test6_3.jpg"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.sourceRegion(
			0,// x 坐标
			0,// y 坐标
			200,// width
			500)// height
		.size(200, 200)
		.keepAspectRatio(false)
		.toFile(getAbsolutePath("test6_4.jpg"));
		
		// 按比例
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.sourceRegion(
			0,// x 坐标
			0,// y 坐标
			400,// width
			300)// height
		.size(200, 200)
		.toFile(getAbsolutePath("test6_5.jpg"));
		
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.sourceRegion(
			0,// x 坐标
			0,// y 坐标
			200,// width
			500)// height
		.size(200, 200)
		.toFile(getAbsolutePath("test6_6.jpg"));
	}
	
	/**
	 * 输出到OutputStream
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test7() throws Exception
	{
		OutputStream os = new FileOutputStream(getAbsolutePath("test7.jpg"));
		Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.toOutputStream(os);// 输入到流
	}
	
	/**
	 * 输出到BufferedImage
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void test8() throws Exception
	{
		BufferedImage thumbnail = 
			Thumbnails.of(getAbsolutePath("old.jpg"))
		.size(1280, 1024)
		.asBufferedImage();
		
		ImageIO.write(thumbnail, "jpg", new File(getAbsolutePath("test8.jpg"))); 
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
