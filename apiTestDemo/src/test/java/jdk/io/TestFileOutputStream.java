package jdk.io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * �ļ������
 * �������ļ���д�����ݵ���
 * @author Administrator
 *
 */
public class TestFileOutputStream {
	public static void main(String[] args) throws Exception {
		/**
		 * write(int b)
		 * write(byte[] buff)
		 * write(byte[] buff, int off, int len)
		 */
//		File file = new File("out.dat");
		/**
		 * �����ļ������
		 * ���췽��
		 * FileOutputStream(File file)
		 * FileOutputStream(String file)
		 * ������ָ���ļ���д���ݵ��ļ������
		 */
		FileOutputStream fos = new FileOutputStream("out.dat",true);
		
		/**
		 * ������ļ���������ļ�ĩβ׷�����ݣ���������д�ļ�����ô����ʹ�ø��������췽��
		 * �����������췽������һ�����صĹ��췽��
		 * �ڶ�������Ϊbooleanֵ����Ϊtrue������׷������
		 * 
		 * FileOutputStream(File file,boolean append)
		 * FileOutputStream(String file,boolean append)
		 */
		
		
		/**
		 * ���������������л��ӳ־û�
		 */
		
		int a = 1233456789;
		fos.write(a >>> 24);
		fos.write(a >>> 16);
		fos.write(a >>> 8);
		fos.write(a);
		
		
		fos.close();
	}
}




















