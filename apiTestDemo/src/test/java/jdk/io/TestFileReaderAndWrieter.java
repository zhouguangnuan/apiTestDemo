package jdk.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ļ��ַ����������ļ��ַ������
 * @author Administrator
 *
 */
public class TestFileReaderAndWrieter {
	public static void main(String[] args) throws IOException{
		/**
		 * ������ȡ�ı��ļ����ַ�������
		 * 
		 * ��������ֻ�����Կ�ݵķ�ʽ��д�ı��ļ�
		 * ���췽���ٶ��ַ����뼯����ȷ
		 */
		FileReader reader = new FileReader("char.txt");
		
		FileWriter writer = new FileWriter("char_copy.txt");
		
		int data = -1;
		
		while((data = reader.read()) != -1){
			writer.write(data);
		}
		//Ӧ�÷���finally��
		reader.close();
		writer.flush();
		writer.close();
	}
}
