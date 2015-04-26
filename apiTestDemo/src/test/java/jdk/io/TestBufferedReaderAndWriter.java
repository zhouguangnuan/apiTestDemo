package jdk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**3
 * 缓冲字符输入输出流
 * 以行为单位读写字符串
 * @author Administrator
 *
 */
public class TestBufferedReaderAndWriter {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try{
			/**
			 * BuffererReader要处理一个字符流。
			 * 而我们读取文件时创建的是一个字节输入流
			 * 所以我们要先将字节输入流转为字符输入流
			 * 再将字符输入流转换为缓冲字符输入流
			 */
			/**
			 * 1:创建用于读取文件的字节输入流
			 */
			FileInputStream fis = new FileInputStream("day02.txt");
			/**
			 * 2:将字节流转换为字符流
			 */
			InputStreamReader isr = new InputStreamReader(fis);
			/**
			 * 3:将字符输入流转换为按行读取的缓冲字符输入流
			 */
			reader = new BufferedReader(isr);
			
//			reader = 
//				new BufferedReader(
//					new InputStreamReader(
//						new FileInputStream("")));
			/**
			 * 创建缓冲字符输出流
			 */
			FileOutputStream fos = new FileOutputStream("day02_copy.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			writer = new BufferedWriter(osw);
			
//			writer = new BufferedWriter(
//				new OutputStreamWriter(
//					new FileOutputStream("")));
			
			/**
			 * 每次读取一行数据，保存在一个字符串中
			 * readLine()方法，一次读取一行字符串
			 * 一行指的是一直读取字符直到看到"\n"为止
			 * 若readLine方法返回null说明EOF
			 */
			String lineData = null;
			//一次读取一行字符串
			while((lineData = reader.readLine()) != null ){
				writer.write(lineData);
				/**
				 * 读取的时候以行为单位读取，但是返回的字符串并没有包含换行符
				 * 所以我们在写的时候，将字符串写出后，要加上一个换行符。
				 * 这里我们可以调用BufferedWriter的newLine()方法加入换行
				 */
				writer.newLine();
			}
			
			
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			if(writer != null){
				try{
					/**
					 * 关闭流前，看看该流有没有flush方法
					 * 有就执行下，没坏处
					 */
					writer.flush();
					writer.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
