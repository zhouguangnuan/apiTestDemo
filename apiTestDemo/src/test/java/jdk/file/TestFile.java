package jdk.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类
 * 用于描述文件系统中的一个文件或目录
 * @author Administrator
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		//java.io.File
		/**
		 * "."代表当前目录。这个是一个相对路径
		 * 	     代表类属性的项目的根目录
		 * 
		 * File.separator是一个常量，用于描述不同文件系统中目录层级的分隔符
		 */
		//
		File file = new File("." + File.separator + "file.txt");
		/**
		 * boolean exists()
		 * 判断当前文件或目录是否存在
		 */
		System.out.println("文件是否存在" + file.exists());
		/**
		 * 获取文件名
		 */
		System.out.println("文件名：" + file.getName());
		/**
		 * 文件大小
		 * long length() 返回该文件的字节数
		 */
		System.out.println("文件大小：" + file.length());
		/**
		 * 获取文件路径
		 * String getPath() 返回该文件路径
		 */
		System.out.println("文件路径：" + file.getPath());
		/**
		 * 获取文件绝对路径
		 * String getAbsolutePath() 返回该文件路径
		 */
		System.out.println("文件路径：" + file.getAbsolutePath());
		/**
		 * 符合当前系统规范的绝对路径
		 * 需要捕获异常
		 */
		System.out.println("文件系统中描述的路径" + file.getCanonicalPath());
		/**
		 * 查看当前file描述的是否为一个文件
		 * boolean isFile()
		 */
		System.out.println("是文件吗？" + file.isFile());
		/**
		 * 查看当前file描述的是否为一个目录
		 * boolean isDirectory()
		 */
		System.out.println("是目录吗？" + file.isDirectory());
		/**
		 * 查看当前文件最后修改日期
		 * long lastModified()
		 */
		long time = file.lastModified();
		Date date = new Date(time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastModified = format.format(time);
		System.out.println("最后修改时间：" + lastModified);
		
		/**
		 * 查看文件是否可读
		 * boolean canRead()
		 */
		System.out.println("文件是否可读：" + file.canRead());
		/**
		 * 查看文件是否可写
		 * boolean canWrite()
		 */
		System.out.println("文件是否可写：" + file.canWrite());
		
	}
}

































