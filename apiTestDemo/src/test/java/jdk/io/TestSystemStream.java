package jdk.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestSystemStream {
	public static void main(String[] args) throws IOException {
//		System.out.println("helloworld");
		/**
		 * ���������������д���ı��ļ�
		 */
		/**
		 * ��ȡ���Լ��̵��ֽ�������
		 * ����һ���ͼ���������ȷ��Դ
		 */
		/**
		 * java���ؽӿڣ�ͨ���������java���Ե���c&c++�⺯��
		 */
		//InputStream (�ӿ�)
		InputStream input = System.in;
		//�����̵�������ת��Ϊ�ַ���
		InputStreamReader isr = new InputStreamReader(input);
		//���ַ���תΪ�����ַ�������
		BufferedReader reader = new BufferedReader(isr);
		String line = null;
		while((line=reader.readLine()) != null){
			/**
			 * ������exit��������
			 */
			if("exit".equals(line.trim())){
				break;
			}
			System.out.println("������ǣ�" + line);
		}
	}
}