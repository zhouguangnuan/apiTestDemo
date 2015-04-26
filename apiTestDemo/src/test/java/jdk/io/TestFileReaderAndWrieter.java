package jdk.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符输入流与文件字符输出流
 * @author Administrator
 *
 */
public class TestFileReaderAndWrieter {
	public static void main(String[] args) throws IOException{
		/**
		 * 创建读取文本文件的字符输入流
		 * 
		 * 这两个类只是能以快捷的方式读写文本文件
		 * 构造方法假定字符编码集都正确
		 */
		FileReader reader = new FileReader("char.txt");
		
		FileWriter writer = new FileWriter("char_copy.txt");
		
		int data = -1;
		
		while((data = reader.read()) != -1){
			writer.write(data);
		}
		//应该放在finally中
		reader.close();
		writer.flush();
		writer.close();
	}
}
