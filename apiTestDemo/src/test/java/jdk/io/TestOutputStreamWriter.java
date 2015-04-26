package jdk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * �ַ������
 * ���ַ�Ϊ��λд���ݵ���
 * @author Administrator
 *
 */
public class TestOutputStreamWriter {
	public static void main(String[] args) throws IOException{
		//�ַ������
		OutputStreamWriter writer = null;
		try{
			FileOutputStream fos = new FileOutputStream("char.txt");
			/**
			 * ���ַ�Ϊ��λ���ļ���д����
			 */
//			writer = new OutputStreamWriter(fos);
			/**
			 * ʹ���ַ������ع��췽��
			 * ��ָ�����ַ���д�ַ�
			 */
			writer = new OutputStreamWriter(fos,"UTF-8");	
			
			/**
			 * write()�����м������صķ���
			 * write(char[] data):��char�����е������ַ�һ����д��
			 * write(int data):�� int ������ char ֵд��(дint�ĵ�16λ)
			 * write(String data):���ַ���һ����д��
			 */
			writer.write("����ַ����������");
		}finally{
			if(writer != null){
				writer.close();
			}
		}
	}
}
