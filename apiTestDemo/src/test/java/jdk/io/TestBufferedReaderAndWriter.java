package jdk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**3
 * �����ַ����������
 * ����Ϊ��λ��д�ַ���
 * @author Administrator
 *
 */
public class TestBufferedReaderAndWriter {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try{
			/**
			 * BuffererReaderҪ����һ���ַ�����
			 * �����Ƕ�ȡ�ļ�ʱ��������һ���ֽ�������
			 * ��������Ҫ�Ƚ��ֽ�������תΪ�ַ�������
			 * �ٽ��ַ�������ת��Ϊ�����ַ�������
			 */
			/**
			 * 1:�������ڶ�ȡ�ļ����ֽ�������
			 */
			FileInputStream fis = new FileInputStream("day02.txt");
			/**
			 * 2:���ֽ���ת��Ϊ�ַ���
			 */
			InputStreamReader isr = new InputStreamReader(fis);
			/**
			 * 3:���ַ�������ת��Ϊ���ж�ȡ�Ļ����ַ�������
			 */
			reader = new BufferedReader(isr);
			
//			reader = 
//				new BufferedReader(
//					new InputStreamReader(
//						new FileInputStream("")));
			/**
			 * ���������ַ������
			 */
			FileOutputStream fos = new FileOutputStream("day02_copy.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			writer = new BufferedWriter(osw);
			
//			writer = new BufferedWriter(
//				new OutputStreamWriter(
//					new FileOutputStream("")));
			
			/**
			 * ÿ�ζ�ȡһ�����ݣ�������һ���ַ�����
			 * readLine()������һ�ζ�ȡһ���ַ���
			 * һ��ָ����һֱ��ȡ�ַ�ֱ������"\n"Ϊֹ
			 * ��readLine��������null˵��EOF
			 */
			String lineData = null;
			//һ�ζ�ȡһ���ַ���
			while((lineData = reader.readLine()) != null ){
				writer.write(lineData);
				/**
				 * ��ȡ��ʱ������Ϊ��λ��ȡ�����Ƿ��ص��ַ�����û�а������з�
				 * ����������д��ʱ�򣬽��ַ���д����Ҫ����һ�����з���
				 * �������ǿ��Ե���BufferedWriter��newLine()�������뻻��
				 */
				writer.newLine();
			}
			
			
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			if(writer != null){
				try{
					/**
					 * �ر���ǰ������������û��flush����
					 * �о�ִ���£�û����
					 */
					writer.flush();
					writer.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
