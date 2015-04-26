package jdk.file;

import java.io.File;

/**
 * 測試 刪除文件或目录
 * @author Administrator
 *
 */
public class TestDeleteFile {

	public static void main(String[] args) {
		File file = new File("a");
		deleteFile(file);
	}
	
	public static void deleteFile(File file){
		if(file==null){
			throw new RuntimeException("文件为空！");
		}
		if(!file.exists()){
			throw new RuntimeException("文件或目录不存在！");
		}
		//若是文件直接删除
		if(file.isFile()){
			if(!file.delete()){
				throw new RuntimeException(file.getName() + "文件删除失败！");
			}
		//若是目录
		}else{
			File[] subs = file.listFiles();
			for(File sub : subs){
				//递归调用当前方法删除
				deleteFile(sub);
			}
			//当这个目录下的所有子项都被删除后，删除该目录
			if(!file.delete()){
				throw new RuntimeException(file.getName() + "目录删除失败");
			}
		}
	}
	
//	public static void deleteFile(File dir){
//		while(dir.exists()){
//			dir.delete();
//			if(!dir.exists()){
//				return;
//			}else{
//				File[] files = dir.listFiles();
//				for(File file : files){
//					deleteFile(file);
//				}
//			}
//		}
//	}
	
//	/**
//	 * 要求：传入的File是一个目录，要做到成功将该目录删除，前提是该目录内部有多级目录和文件	
//	 * 思路:
//	 * 	1先删内层文件或文件夹(没有子文件的目录)
//	 * 	2循环1步骤，直到当前文件夹没有子文件，可以删除
//	 */
//	
//	/**
//	 * 循环调用deleteFileNexine()方法，直到当前文件被删除
//	 */
//	public static void deleteFile(File dir){
//		while(dir.exists()){
//			deleteFileNexine(dir);
//		}
//	}
//	/**
//	 * 递归迭代删除当前文件的内层文件或文件夹(没有子文件的目录)
//	 * @param dir
//	 */
//	private static void deleteFileNexine(File dir){
//		dir.delete();
//		if(!dir.exists()){
//			return;
//		}else{
//			File[] files = dir.listFiles();
//			for(File file : files){
//				deleteFile(file);
//			}
//		}
//	}
}













