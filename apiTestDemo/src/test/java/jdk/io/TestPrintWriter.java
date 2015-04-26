package jdk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
	public static void main(String[] args) throws IOException{
		/**
		 * 创建向文件pw.txt写数据的字符输出流
		 */
//		PrintWriter pw = new PrintWriter("pw.txt");
		PrintWriter pw = 
			new PrintWriter(
				new FileOutputStream("pw.txt"));
		
		/**
		 * 在某些情况下，我们需要在每次输出后都清空缓冲区
		 * 而这时我们都需要调用flush()方法。这样比较麻烦
		 * 这个时候我们可以调用PrintWriter的重载构造器方法
		 * 建立一个带有自动刷新的输出流
		 * PrintWriter(OutputStream out,boolean autoFlush)
		 * PrintWriter(Writer writer,boolean autoFlush)
		 * 这样当我们调用println()方法后，会自动flush()
		 */
		
		pw.println("helloworld!");
		
		pw.close();
	}
}
