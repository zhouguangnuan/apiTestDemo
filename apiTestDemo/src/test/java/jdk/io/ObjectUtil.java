package jdk.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ��ȸ��ƶ���
 * @author Administrator
 *
 */
public class ObjectUtil {
	public static Object deepClone(Object obj){
		try{
			/**
			 * 1 �������ڽ��ֽ�д���ֽ�������ֽ������
			 * 	ByteArrrayOutputStream
			 * 
			 * 2 �����������л������ObjectOutputStream������
			 *  ByteArrayOutputStream��
			 *  
			 * 3 ������ oos д����ʵ���Ͼ���ͨ��ByteArrayOutputStream
			 * д�����ڲ�ά�����ֽ��������ˣ����ǻ�ȡ�����顣
			 *  
			 * 4 ����һ�����ڴ������ж�ȡ���ݵ�������
			 * ByteArrayInputStream������֮ǰ�����Ŷ������л�����ֽ�
			 * �����鴫�ݸ��������
			 * 
			 * 5 �������ڷ����л�����ĳ�����ObjectInputStream������
			 * ByteArrayInputStream
			 * 
			 * 6 ʹ��IOS��ȡ�������л�����ﵽ��ȸ��Ƶ�Ŀ��
			 */
			//1
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//2
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			//3
			oos.writeObject(obj);
			//��ȡ�����л������ֽ�����
			//����һ���·���� byte ���顣
			byte[] data = baos.toByteArray();
			
			//4
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			//5
			ObjectInputStream ois = new ObjectInputStream(bais);
			//6
			Object copy = ois.readObject();
			
			oos.close();
			ois.close();
			
			return copy;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

















