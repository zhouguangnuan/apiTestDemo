package jdk.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���Ի����������ݶ�д
 * DataInputStream
 * DataOutputStream
 * @author Administrator
 *
 */
public class TestDataIOStream {
	public static void main(String[] args) throws IOException {
		File file = new File("data.dat");
		writeInt(file, 123456789);
		int num = readInt(file);
		System.out.println(num);
	}
	
	/**
	 * ���ļ���д��һ��intֵ
	 * @param file
	 * @param num
	 */
	public static void writeInt(File file,int num) throws IOException{
		//java.io.DataOutputStream
		DataOutputStream dos = null;
		try{
			FileOutputStream fos = new FileOutputStream(file);
			/**
			 * �Ƚ��ļ��ֽ������ת��Ϊһ�������ֽ������
			 * �����Ϳ�������д�������дЧ��
			 * �ٽ������ֽ������ת��ΪDataOutputStream
			 * �������ǾͿ����Ի�������λ��λд����
			 * �����ȷ���������д�������������д��Ч��
			 * ����Ǹ߼������Ӻ��Ч����
			 */
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			dos.writeInt(num);//дһ��intֵ ����4���ֽ�
		}finally{
			if(dos != null){
				dos.close();
			}
		}
	}
	
	/**
	 * �Ӹ����ļ��ж�ȡһ��intֵ
	 * @param file
	 * @param num
	 */
	public static int readInt(File file) throws IOException{
		/**
		 * 1�������ļ�������
		 * 2������DataInputStream�����ļ�������
		 * 3��ʹ��DIS��readInt()������ȡһ��intֵ������
		 * 4���ر���
		 */
		DataInputStream dis = null;
		int num;
		try{
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			num = dis.readInt();
			return num;
		}finally{
			if(dis != null){
				dis.close();
			}
		}
	}
}














