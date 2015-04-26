package jdk.file;

import java.io.File;
import java.io.IOException;

/**
 * File操作文件或目录
 * @author Administrator
 *
 */
public class TestFile2 {
	public static void main(String[] args) throws IOException {
		/**
		 * 创建一个File实例，代表当前目录下的一个demo目录
		 */
		File dir = new File("demo");
		/**
		 * 判断该目录是否在硬盘中存在
		 */
		if(!dir.exists()){
			//创建该目录
			dir.mkdir();
		}
		System.out.println(dir.getCanonicalPath());
		/**
		 * 创建一个file用于描述dir目录下的一个文件或目录 
		 */
		File file = new File(dir,"test.txt");
		if(!file.exists()){
			//创建文件
			file.createNewFile();
		}
		
//		File dir2 = new File("JavaSE核心I");
//		System.out.println(dir2.exists());
//		System.out.println(dir2.canWrite());
		
		
	}
}













