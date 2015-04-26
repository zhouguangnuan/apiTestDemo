package jdk.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader
 * @author Administrator
 *
 */
public class TestInputStreamReader {
	public static void main(String[] args) throws IOException{
		InputStreamReader reader = null;
		try{
			FileInputStream fis = new FileInputStream("char.txt");
			//以字符形式读取数据
//			reader = new InputStreamReader(fis);
			/**
			 * 根据给定的字符集读取字符
			 */
			reader = new InputStreamReader(fis,"UTF-8");
			
			int data = -1;
			while((data = reader.read()) != -1){
				/**
				 * 一次读取一个char
				 */
				System.out.print((char)data);
			}
			
		}finally{
			if(reader != null){
				reader.close();
			}
		}
	}
}
