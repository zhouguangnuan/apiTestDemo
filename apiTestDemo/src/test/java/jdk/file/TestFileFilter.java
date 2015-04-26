package jdk.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件过滤器
 * 用来过滤并获取当前目录下的指定子项
 * @author Administrator
 *
 */
public class TestFileFilter {
	public static void main(String[] args) {
//		FileFilter filter = new FileFilter(){
//			public boolean accept(File pathname) {
//				System.out.println("正在过滤的子项：" + pathname.getName());
//				boolean isFile = pathname.isFile();
//				return isFile;
//			}
//		};
		/**
		 * listFiles(FileFilter filter)
		 * 该方法要求我们传入一个FileFilter(接口)的子类实例，然后将该目录下的所有子项顺序通过调用
		 * FileFilter的accept方法传入，保留accept()方法返回值为true的子项，最终构成一个File数组返回。
		 * 
		 * 这种通过调用某个方法并传入一个实例，在该方法中又调用我们传入的实例的某个方法的模式称为[回调模式]
		 * swing中使用的监听器也是典型的回调模式。
		 */
		File projectDir = new File(".");
//		File[] subs = projectDir.listFiles(filter);
		
		File[] subs = projectDir.listFiles(new FileFilter(){
			public boolean accept(File pathname) {
				return pathname.isFile();
			}
		});
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
