package jdk.file;

import java.io.File;
import java.io.IOException;

/**
 * File�����ļ���Ŀ¼
 * @author Administrator
 *
 */
public class TestFile2 {
	public static void main(String[] args) throws IOException {
		/**
		 * ����һ��Fileʵ��������ǰĿ¼�µ�һ��demoĿ¼
		 */
		File dir = new File("demo");
		/**
		 * �жϸ�Ŀ¼�Ƿ���Ӳ���д���
		 */
		if(!dir.exists()){
			//������Ŀ¼
			dir.mkdir();
		}
		System.out.println(dir.getCanonicalPath());
		/**
		 * ����һ��file��������dirĿ¼�µ�һ���ļ���Ŀ¼ 
		 */
		File file = new File(dir,"test.txt");
		if(!file.exists()){
			//�����ļ�
			file.createNewFile();
		}
		
//		File dir2 = new File("JavaSE����I");
//		System.out.println(dir2.exists());
//		System.out.println(dir2.canWrite());
		
		
	}
}













