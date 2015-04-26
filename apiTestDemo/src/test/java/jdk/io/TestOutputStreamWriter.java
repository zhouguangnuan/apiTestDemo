package jdk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符输出流
 * 以字符为单位写数据的流
 * @author Administrator
 *
 */
public class TestOutputStreamWriter {
	public static void main(String[] args) throws IOException{
		//字符输出流
		OutputStreamWriter writer = null;
		try{
			FileOutputStream fos = new FileOutputStream("char.txt");
			/**
			 * 以字符为单位向文件里写数据
			 */
//			writer = new OutputStreamWriter(fos);
			/**
			 * 使用字符流重载构造方法
			 * 以指定的字符集写字符
			 */
			writer = new OutputStreamWriter(fos,"UTF-8");	
			
			/**
			 * write()方法有几个重载的方法
			 * write(char[] data):将char数组中的所有字符一次性写出
			 * write(int data):将 int 描述的 char 值写出(写int的低16位)
			 * write(String data):将字符串一次性写出
			 */
			writer.write("你好字符输出流！！");
		}finally{
			if(writer != null){
				writer.close();
			}
		}
	}
}
