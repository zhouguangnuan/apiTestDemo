package jdk.file;

import java.io.File;

/**
 * 查看目录下面的所有子项
 * @author Administrator
 *
 */
public class File5 {
	public static void main(String[] args){
		File project = new File("a");
		if(project.exists()){
			if(project.isDirectory()){
				/**
				 * 当File对象代表的是一个目录，可以查看所有子项
				 * File[] listFiles()
				 * 若当前File代表的是一个目录，listFiles()方法会返回一个数组，数组中每一个元素是一个File对象
				 * 代表当前目录下的一个子项(文件或目录)
				 * 数组的长度和当前目录下的子项数量一致
				 */
				File[] subs = project.listFiles();
				for(File file : subs){
					System.out.println(
						(file.isFile()? "文件：" : "目录：") + file.getName()
					);
//					file.delete();
				}
			}
		}
	}
	
	public void deleteFile(File dir){
		
	}
}
