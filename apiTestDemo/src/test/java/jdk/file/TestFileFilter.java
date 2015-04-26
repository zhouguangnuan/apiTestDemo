package jdk.file;

import java.io.File;
import java.io.FileFilter;

/**
 * �ļ�������
 * �������˲���ȡ��ǰĿ¼�µ�ָ������
 * @author Administrator
 *
 */
public class TestFileFilter {
	public static void main(String[] args) {
//		FileFilter filter = new FileFilter(){
//			public boolean accept(File pathname) {
//				System.out.println("���ڹ��˵����" + pathname.getName());
//				boolean isFile = pathname.isFile();
//				return isFile;
//			}
//		};
		/**
		 * listFiles(FileFilter filter)
		 * �÷���Ҫ�����Ǵ���һ��FileFilter(�ӿ�)������ʵ����Ȼ�󽫸�Ŀ¼�µ���������˳��ͨ������
		 * FileFilter��accept�������룬����accept()��������ֵΪtrue��������չ���һ��File���鷵�ء�
		 * 
		 * ����ͨ������ĳ������������һ��ʵ�����ڸ÷������ֵ������Ǵ����ʵ����ĳ��������ģʽ��Ϊ[�ص�ģʽ]
		 * swing��ʹ�õļ�����Ҳ�ǵ��͵Ļص�ģʽ��
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
	
	
	
	
	
	
	
	
	
	
	
	
