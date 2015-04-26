package jdk.file;

import java.io.File;
import java.io.IOException;

/**
 * 创建多级目录
 * @author Administrator
 *
 */
public class TestFile3 {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"a" + File.separator + 
				"b" + File.separator + 
				"c" + File.separator + 
				"d"
		);
		if(!file.exists()){
			/**
			 * 该方法也是用于创建目录
			 * 但是会帮我们创建所有不存在的父目录
			 */
			file.mkdirs();
		}
		
		File sub = new File(file,"test.txt");
		if(!sub.exists()){
			sub.createNewFile();
		}
		
		System.out.println("创建完毕！");
	}
}
