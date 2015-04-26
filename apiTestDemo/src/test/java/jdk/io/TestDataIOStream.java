package jdk.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试基本类型数据读写
 * DataInputStream
 * DataOutputStream
 * @author Administrator
 *
 */
public class TestDataIOStream {
	public static void main(String[] args) throws IOException {
		File file = new File("data.dat");
		writeInt(file, 123456789);
		int num = readInt(file);
		System.out.println(num);
	}
	
	/**
	 * 向文件中写入一个int值
	 * @param file
	 * @param num
	 */
	public static void writeInt(File file,int num) throws IOException{
		//java.io.DataOutputStream
		DataOutputStream dos = null;
		try{
			FileOutputStream fos = new FileOutputStream(file);
			/**
			 * 先将文件字节输出流转换为一个缓冲字节输出流
			 * 这样就可以批量写出，提高写效率
			 * 再将缓冲字节输出流转化为DataOutputStream
			 * 这样我们就可以以基本数据位单位写出。
			 * 这样既方便了我们写出数据又提高了写出效率
			 * 这就是高级流叠加后的效果。
			 */
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			dos.writeInt(num);//写一个int值 连续4个字节
		}finally{
			if(dos != null){
				dos.close();
			}
		}
	}
	
	/**
	 * 从给定文件中读取一个int值
	 * @param file
	 * @param num
	 */
	public static int readInt(File file) throws IOException{
		/**
		 * 1：创建文件输入流
		 * 2：创建DataInputStream处理文件输入流
		 * 3：使用DIS的readInt()方法读取一个int值并返回
		 * 4：关闭流
		 */
		DataInputStream dis = null;
		int num;
		try{
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			num = dis.readInt();
			return num;
		}finally{
			if(dis != null){
				dis.close();
			}
		}
	}
}














