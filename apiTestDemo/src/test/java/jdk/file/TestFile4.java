package jdk.file;

import java.io.File;

/**
 * ɾ���ļ���Ŀ¼
 * @author Administrator
 *
 */
public class TestFile4 {
	public static void main(String[] args) {
		/**
		 * �����ļ�
		 * ����Ҫɾ�����ļ���File����
		 * 
		 */
		File file = new File("demo");
//		if(file.exists()){
//			file.delete();
//			System.out.println("ɾ�����");
//		}
//		
		/**
		 * ɾ���ļ���Ŀ¼
		 * boolean delete()
		 * ���ļ���Ŀ¼��ɾ��ʱ����true
		 * 
		 * ��ɾ��һ��Ŀ¼��ʱ��Ҫȷ��Ŀ¼�ǿյĲ��ܳɹ�ɾ����Ŀ¼��
		 */
		if(file.delete()){
			System.out.println("ɾ�����");
		}
		
		
	}
}














