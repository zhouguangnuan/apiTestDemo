package jdk.file;

import java.io.File;

/**
 * �鿴Ŀ¼�������������
 * @author Administrator
 *
 */
public class File5 {
	public static void main(String[] args){
		File project = new File("a");
		if(project.exists()){
			if(project.isDirectory()){
				/**
				 * ��File����������һ��Ŀ¼�����Բ鿴��������
				 * File[] listFiles()
				 * ����ǰFile�������һ��Ŀ¼��listFiles()�����᷵��һ�����飬������ÿһ��Ԫ����һ��File����
				 * ����ǰĿ¼�µ�һ������(�ļ���Ŀ¼)
				 * ����ĳ��Ⱥ͵�ǰĿ¼�µ���������һ��
				 */
				File[] subs = project.listFiles();
				for(File file : subs){
					System.out.println(
						(file.isFile()? "�ļ���" : "Ŀ¼��") + file.getName()
					);
//					file.delete();
				}
			}
		}
	}
	
	public void deleteFile(File dir){
		
	}
}
