package jdk.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO工具类
 * @author Administrator
 *
 */
public class IOUtils {
	/**
	 * 使用fis&fos实现的文件拷贝
	 * @param src
	 * @param desc
	 */
	public static void copy(File src,File desc) throws IOException{
		/**
		 * 进行必要的验证工作
		 */
		if(src == null){
			throw new RuntimeException("原文件对象为空");
		}
		if(!src.exists()){
			throw new RuntimeException("原文件不存在!");
		}
		if(desc == null){
			throw new RuntimeException("目标对象为空");
		}
		/**
		 * 创建文件需要强制捕获IOException
		 * 我们直接抛出给调用者
		 */
		if(!desc.exists()){
			desc.createNewFile();
		}
		/**
		 * 为了保证读写效率，我们不要一个字节一个字节读写
		 * 这里我们创建一个字节数组，批量读写字节
		 */
		byte[] buf = new byte[1024*10];
		int len = -1;//记录每次真实读取的字节数
		/**
		 * 根据原文件和目标文件创建 FIS 和 FOS
		 */
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(desc);
		while((len=fis.read(buf))>0){
			//将实际读取的数据写入目标文件
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}
	
	/**
	 * 使用缓冲流复制文件 BIS&BOS
	 * @param src
	 * @param desc
	 */
	public static void copy2(File src,File desc) throws IOException{
		/**
		 * src是java中用于描述硬盘中文件的对象
		 */
		if(src!=null){//描述文件的对象不存在，为空
			/**
			 * IllegalArgumentException是RuntimeException子类
			 * 描述无效的参数的异常
			 */
			throw new IllegalArgumentException("源文件对象为空！");
		}
		/**
		 * src.exists是判断 src所描述的在硬盘中的文件是否存在
		 */
		if(!src.exists()){//被描述的文件不存在
			throw new IllegalArgumentException("源文件不存在！");
		}
		if(desc == null){
			throw new IllegalArgumentException("目标文件对象为空！");
		}
		if(!desc.exists()){
			desc.createNewFile();
		}
		/**
		 * 使用缓冲字节输入流和输出流复制文件
		 */
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try{
			/**
			 * 创建用于读写文件的fis 和 fos
			 */
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(desc);
			
//			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int b = -1;
			while((b=fis.read()) != -1){
				bos.write(b);
			}
			
		}finally{
			/**
			 * 应当将关闭流的操作放入finally中
			 * 这样可以确保流被关闭，以释放资源
			 */
			if(bis != null){
				/**
				 * java jdk中的流是可以自动顺序关闭的
				 * 高级流在关闭前会先将其处理的流关掉后才关掉
				 * 所以我们只需要关闭最外层的高级流就可以了
				 */
				bis.close();
			}
			if(bos != null){
				bos.flush();//将缓冲区内容全部写出(不写，有可能丢失数据)
				bos.close();
			}
		}
	}
}




















