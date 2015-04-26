package jdk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
	public static void main(String[] args) throws IOException{
		/**
		 * �������ļ�pw.txtд���ݵ��ַ������
		 */
//		PrintWriter pw = new PrintWriter("pw.txt");
		PrintWriter pw = 
			new PrintWriter(
				new FileOutputStream("pw.txt"));
		
		/**
		 * ��ĳЩ����£�������Ҫ��ÿ���������ջ�����
		 * ����ʱ���Ƕ���Ҫ����flush()�����������Ƚ��鷳
		 * ���ʱ�����ǿ��Ե���PrintWriter�����ع���������
		 * ����һ�������Զ�ˢ�µ������
		 * PrintWriter(OutputStream out,boolean autoFlush)
		 * PrintWriter(Writer writer,boolean autoFlush)
		 * ���������ǵ���println()�����󣬻��Զ�flush()
		 */
		
		pw.println("helloworld!");
		
		pw.close();
	}
}
