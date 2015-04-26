package jdk.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO������
 * @author Administrator
 *
 */
public class IOUtils {
	/**
	 * ʹ��fis&fosʵ�ֵ��ļ�����
	 * @param src
	 * @param desc
	 */
	public static void copy(File src,File desc) throws IOException{
		/**
		 * ���б�Ҫ����֤����
		 */
		if(src == null){
			throw new RuntimeException("ԭ�ļ�����Ϊ��");
		}
		if(!src.exists()){
			throw new RuntimeException("ԭ�ļ�������!");
		}
		if(desc == null){
			throw new RuntimeException("Ŀ�����Ϊ��");
		}
		/**
		 * �����ļ���Ҫǿ�Ʋ���IOException
		 * ����ֱ���׳���������
		 */
		if(!desc.exists()){
			desc.createNewFile();
		}
		/**
		 * Ϊ�˱�֤��дЧ�ʣ����ǲ�Ҫһ���ֽ�һ���ֽڶ�д
		 * �������Ǵ���һ���ֽ����飬������д�ֽ�
		 */
		byte[] buf = new byte[1024*10];
		int len = -1;//��¼ÿ����ʵ��ȡ���ֽ���
		/**
		 * ����ԭ�ļ���Ŀ���ļ����� FIS �� FOS
		 */
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(desc);
		while((len=fis.read(buf))>0){
			//��ʵ�ʶ�ȡ������д��Ŀ���ļ�
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}
	
	/**
	 * ʹ�û����������ļ� BIS&BOS
	 * @param src
	 * @param desc
	 */
	public static void copy2(File src,File desc) throws IOException{
		/**
		 * src��java����������Ӳ�����ļ��Ķ���
		 */
		if(src!=null){//�����ļ��Ķ��󲻴��ڣ�Ϊ��
			/**
			 * IllegalArgumentException��RuntimeException����
			 * ������Ч�Ĳ������쳣
			 */
			throw new IllegalArgumentException("Դ�ļ�����Ϊ�գ�");
		}
		/**
		 * src.exists���ж� src����������Ӳ���е��ļ��Ƿ����
		 */
		if(!src.exists()){//���������ļ�������
			throw new IllegalArgumentException("Դ�ļ������ڣ�");
		}
		if(desc == null){
			throw new IllegalArgumentException("Ŀ���ļ�����Ϊ�գ�");
		}
		if(!desc.exists()){
			desc.createNewFile();
		}
		/**
		 * ʹ�û����ֽ�������������������ļ�
		 */
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try{
			/**
			 * �������ڶ�д�ļ���fis �� fos
			 */
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(desc);
			
//			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int b = -1;
			while((b=fis.read()) != -1){
				bos.write(b);
			}
			
		}finally{
			/**
			 * Ӧ�����ر����Ĳ�������finally��
			 * ��������ȷ�������رգ����ͷ���Դ
			 */
			if(bis != null){
				/**
				 * java jdk�е����ǿ����Զ�˳��رյ�
				 * �߼����ڹر�ǰ���Ƚ��䴦������ص���Źص�
				 * ��������ֻ��Ҫ�ر������ĸ߼����Ϳ�����
				 */
				bis.close();
			}
			if(bos != null){
				bos.flush();//������������ȫ��д��(��д���п��ܶ�ʧ����)
				bos.close();
			}
		}
	}
}




















