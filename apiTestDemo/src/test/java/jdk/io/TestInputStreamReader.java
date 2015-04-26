package jdk.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader
 * @author Administrator
 *
 */
public class TestInputStreamReader {
	public static void main(String[] args) throws IOException{
		InputStreamReader reader = null;
		try{
			FileInputStream fis = new FileInputStream("char.txt");
			//���ַ���ʽ��ȡ����
//			reader = new InputStreamReader(fis);
			/**
			 * ���ݸ������ַ�����ȡ�ַ�
			 */
			reader = new InputStreamReader(fis,"UTF-8");
			
			int data = -1;
			while((data = reader.read()) != -1){
				/**
				 * һ�ζ�ȡһ��char
				 */
				System.out.print((char)data);
			}
			
		}finally{
			if(reader != null){
				reader.close();
			}
		}
	}
}
