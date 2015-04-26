package jdk.file;

import java.io.File;

/**
 * 删除文件或目录
 * @author Administrator
 *
 */
public class TestFile4 {
	public static void main(String[] args) {
		/**
		 * 描述文件
		 * 创建要删除的文件的File对象
		 * 
		 */
		File file = new File("demo");
//		if(file.exists()){
//			file.delete();
//			System.out.println("删除完毕");
//		}
//		
		/**
		 * 删除文件或目录
		 * boolean delete()
		 * 当文件或目录被删除时返回true
		 * 
		 * 当删除一个目录的时候，要确保目录是空的才能成功删除该目录。
		 */
		if(file.delete()){
			System.out.println("删除完毕");
		}
		
		
	}
}














