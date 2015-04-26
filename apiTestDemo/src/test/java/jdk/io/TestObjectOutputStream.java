package jdk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ���Զ������л���
 * @author Administrator
 *
 */
public class TestObjectOutputStream {
	public static void main(String[] args) throws IOException{
		/**
		 * ����һ��Person��ʵ��
		 */
		Person person = new Person();
		person.setAge(12);
		person.setName("boss");
		person.setPassword("123456");
		person.setSex(1);
		
		/**
		 * �����ֱ��浽�ļ���
		 * 1����������д�ļ����ֽ������FileOutputStream
		 * 2:�����������л������ObjectOutputStream������
		 * ����FileOutputStream�������Ϳ��Խ��������л�
		 * ���ֽں�д���ļ����ˡ�
		 * 3��ʹ��ObjectOutputStream������д����
		 */
		ObjectOutputStream oos = null;
		try{
			/**
			 * �����л���Ķ������person.obj�ļ���
			 * ��׺������
			 */
			FileOutputStream fos = new FileOutputStream("person.obj");
			/**
			 * ���������л���д���ļ���
			 */
			oos = new ObjectOutputStream(fos);
			/**
			 * ����ObjectOutputStream����������������
			 * 1��������personת��Ϊ�ֽ�����
			 * 2������Щ�ֽ�д��
			 * 
			 * ע�⣬д����ֻ��������ֵ����ʵ����д�����ֽ���������������ֵ�����ֽ���Ҫ��
			 * ��Ϊ����Ҫ��¼��Щֵ���ĸ����Ե�����������Ϣ�����ǲ���Ҫ����д������ֽڴ���
			 * ʲô����֮�����е����Լ���һ��ռ�õ��ֽ�����
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















