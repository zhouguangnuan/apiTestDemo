package jdk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 测试对象序列化类
 * @author Administrator
 *
 */
public class TestObjectOutputStream {
	public static void main(String[] args) throws IOException{
		/**
		 * 创建一个Person的实例
		 */
		Person person = new Person();
		person.setAge(12);
		person.setName("boss");
		person.setPassword("123456");
		person.setSex(1);
		
		/**
		 * 将兑现保存到文件中
		 * 1：创建用于写文件的字节输出流FileOutputStream
		 * 2:创建用于序列化对象的ObjectOutputStream并让其
		 * 处理FileOutputStream，这样就可以将对象序列化
		 * 成字节后写到文件里了。
		 * 3：使用ObjectOutputStream将对象写出。
		 */
		ObjectOutputStream oos = null;
		try{
			/**
			 * 将序列化后的对象存入person.obj文件中
			 * 后缀名随意
			 */
			FileOutputStream fos = new FileOutputStream("person.obj");
			/**
			 * 将对象序列化后写入文件中
			 */
			oos = new ObjectOutputStream(fos);
			/**
			 * 这里ObjectOutputStream帮我们做了两件事
			 * 1：将对象person转化为字节形似
			 * 2：将这些字节写出
			 * 
			 * 注意，写出的只是有属性值，但实际上写出的字节总量比所有属性值的总字节量要大。
			 * 因为还需要记录那些值是哪个属性的这类描述信息。我们不需要关心写出后的字节代表
			 * 什么。总之比所有的属性加载一起占用的字节量大。
			 */
			oos.writeObject(person);
			
		}finally{
			if(oos != null){
				oos.flush();
				oos.close();
			}
		}
	}
	
	static class Person
	{
		private int age;
		private String name;
		private String password;
		private int sex;
		
		public Person()
		{
			super();
		}
		
		public int getAge()
		{
			return age;
		}
		public void setAge(int age)
		{
			this.age = age;
		}
		public String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public String getPassword()
		{
			return password;
		}
		public void setPassword(String password)
		{
			this.password = password;
		}
		public int getSex()
		{
			return sex;
		}
		public void setSex(int sex)
		{
			this.sex = sex;
		}
	}
}















