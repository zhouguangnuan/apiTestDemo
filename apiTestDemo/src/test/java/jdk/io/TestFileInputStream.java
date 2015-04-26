package jdk.io;

import java.io.FileInputStream;

/**
 * ���ļ���ȡ�ֽڵĳ�����
 * FileInputStream
 * @author Administrator
 *
 */
public class TestFileInputStream {
	public static void main(String[] args) throws Exception{
		
		FileInputStream fis = new FileInputStream("out.dat");
		
		//��ȡ������
		int num = 0;
		 
		//��ȡ��һ���ֽ�
		int data = fis.read();
		/**
		 * 			    01111111 11111111 11111111 11111111
		 * num          01111111 11111111 00000000 00000000
		 * data<<16     00000000 00000000 00000000 11111111
		 */
		num = num | (data<<24);
		data = fis.read();
		num = num | (data<<16);
		data = fis.read();
		num = num | (data<<8);
		data = fis.read();
		num = num | (data<<0);
		System.out.println(num);
		
		/**
		 * 
		 */
		
		
		
		
		fis.close();
	}
}
