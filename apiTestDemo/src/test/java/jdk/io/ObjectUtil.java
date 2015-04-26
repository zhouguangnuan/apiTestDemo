package jdk.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 深度复制对象
 * @author Administrator
 *
 */
public class ObjectUtil {
	public static Object deepClone(Object obj){
		try{
			/**
			 * 1 创建用于将字节写入字节数组的字节输出流
			 * 	ByteArrrayOutputStream
			 * 
			 * 2 创建用于序列化对象的ObjectOutputStream并处理
			 *  ByteArrayOutputStream。
			 *  
			 * 3 当对象被 oos 写出后，实际上就是通过ByteArrayOutputStream
			 * 写到其内部维护的字节数组上了，我们获取该数组。
			 *  
			 * 4 创建一个用于从数组中读取数据的输入流
			 * ByteArrayInputStream，并将之前保存着对象序列化后的字节
			 * 的数组传递给这个流。
			 * 
			 * 5 创建用于反序列化对象的出入流ObjectInputStream并处理
			 * ByteArrayInputStream
			 * 
			 * 6 使用IOS读取并反序列化对象达到深度复制的目的
			 */
			//1
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//2
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			//3
			oos.writeObject(obj);
			//获取该流中护卫的字节数组
			//创建一个新分配的 byte 数组。
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

















