package jdk.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File��
 * ���������ļ�ϵͳ�е�һ���ļ���Ŀ¼
 * @author Administrator
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		//java.io.File
		/**
		 * "."����ǰĿ¼�������һ�����·��
		 * 	     ���������Ե���Ŀ�ĸ�Ŀ¼
		 * 
		 * File.separator��һ������������������ͬ�ļ�ϵͳ��Ŀ¼�㼶�ķָ���
		 */
		//
		File file = new File("." + File.separator + "file.txt");
		/**
		 * boolean exists()
		 * �жϵ�ǰ�ļ���Ŀ¼�Ƿ����
		 */
		System.out.println("�ļ��Ƿ����" + file.exists());
		/**
		 * ��ȡ�ļ���
		 */
		System.out.println("�ļ�����" + file.getName());
		/**
		 * �ļ���С
		 * long length() ���ظ��ļ����ֽ���
		 */
		System.out.println("�ļ���С��" + file.length());
		/**
		 * ��ȡ�ļ�·��
		 * String getPath() ���ظ��ļ�·��
		 */
		System.out.println("�ļ�·����" + file.getPath());
		/**
		 * ��ȡ�ļ�����·��
		 * String getAbsolutePath() ���ظ��ļ�·��
		 */
		System.out.println("�ļ�·����" + file.getAbsolutePath());
		/**
		 * ���ϵ�ǰϵͳ�淶�ľ���·��
		 * ��Ҫ�����쳣
		 */
		System.out.println("�ļ�ϵͳ��������·��" + file.getCanonicalPath());
		/**
		 * �鿴��ǰfile�������Ƿ�Ϊһ���ļ�
		 * boolean isFile()
		 */
		System.out.println("���ļ���" + file.isFile());
		/**
		 * �鿴��ǰfile�������Ƿ�Ϊһ��Ŀ¼
		 * boolean isDirectory()
		 */
		System.out.println("��Ŀ¼��" + file.isDirectory());
		/**
		 * �鿴��ǰ�ļ�����޸�����
		 * long lastModified()
		 */
		long time = file.lastModified();
		Date date = new Date(time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastModified = format.format(time);
		System.out.println("����޸�ʱ�䣺" + lastModified);
		
		/**
		 * �鿴�ļ��Ƿ�ɶ�
		 * boolean canRead()
		 */
		System.out.println("�ļ��Ƿ�ɶ���" + file.canRead());
		/**
		 * �鿴�ļ��Ƿ��д
		 * boolean canWrite()
		 */
		System.out.println("�ļ��Ƿ��д��" + file.canWrite());
		
	}
}

































