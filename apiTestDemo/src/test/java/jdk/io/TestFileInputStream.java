package jdk.io;

import java.io.FileInputStream;

/**
 * 从文件读取字节的出入流
 * FileInputStream
 * @author Administrator
 *
 */
public class TestFileInputStream {
	public static void main(String[] args) throws Exception{
		
		FileInputStream fis = new FileInputStream("out.dat");
		
		//读取的整数
		int num = 0;
		 
		//读取第一个字节
		int data = fis.read();
		/**
		 * 			    01111111 11111111 11111111 11111111
		 * num          01111111 11111111 00000000 00000000
		 * data<<16     00000000 00000000 00000000 11111111
		 */
		num = num | (data<<24);
		data = fis.read();
		num = num | (data<<16);
		data = fis.read();
		num = num | (data<<8);
		data = fis.read();
		num = num | (data<<0);
		System.out.println(num);
		
		/**
		 * 
		 */
		
		
		
		
		fis.close();
	}
}
