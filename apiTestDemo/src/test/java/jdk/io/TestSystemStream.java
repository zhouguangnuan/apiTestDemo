package jdk.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestSystemStream {
	public static void main(String[] args) throws IOException {
//		System.out.println("helloworld");
		/**
		 * 将键盘输入的内容写入文本文件
		 */
		/**
		 * 获取来自键盘的字节输入流
		 * 这是一个低级流，有明确来源
		 */
		/**
		 * java本地接口，通过这个技术java可以调用c&c++库函数
		 */
		//InputStream (接口)
		InputStream input = System.in;
		//将键盘的输入流转换为字符流
		InputStreamReader isr = new InputStreamReader(input);
		//将字符流转为缓冲字符输入流
		BufferedReader reader = new BufferedReader(isr);
		String line = null;
		while((line=reader.readLine()) != null){
			/**
			 * 当见到exit结束程序
			 */
			if("exit".equals(line.trim())){
				break;
			}
			System.out.println("输入的是：" + line);
		}
	}
}