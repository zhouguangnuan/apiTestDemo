package jdk.io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 文件输出流
 * 用于向文件中写入数据的流
 * @author Administrator
 *
 */
public class TestFileOutputStream {
	public static void main(String[] args) throws Exception {
		/**
		 * write(int b)
		 * write(byte[] buff)
		 * write(byte[] buff, int off, int len)
		 */
//		File file = new File("out.dat");
		/**
		 * 创建文件输出流
		 * 构造方法
		 * FileOutputStream(File file)
		 * FileOutputStream(String file)
		 * 创建向指定文件中写数据的文件输出流
		 */
		FileOutputStream fos = new FileOutputStream("out.dat",true);
		
		/**
		 * 若想打开文件后继续在文件末尾追加内容，而不是重写文件，我么可以使用个参数构造方法
		 * 以上两个构造方法都有一个重载的构造方法
		 * 第二个参数为boolean值，当为true是则是追加内容
		 * 
		 * FileOutputStream(File file,boolean append)
		 * FileOutputStream(String file,boolean append)
		 */
		
		
		/**
		 * 基本数据类型序列化加持久化
		 */
		
		int a = 1233456789;
		fos.write(a >>> 24);
		fos.write(a >>> 16);
		fos.write(a >>> 8);
		fos.write(a);
		
		
		fos.close();
	}
}




















