package jdk.reflection;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class LoadresouceDemo
{
	@Test
	public void test1() throws Exception
	{
		Properties p = new Properties();
		
		// 默认从当前类所在的classPath目录下查找
		// InputStream in = LoadresouceDemo.class.getResourceAsStream("test.propertes");
		// 默认在classPath根目录下查找
		InputStream in = LoadresouceDemo.class.getClassLoader().getResourceAsStream("test.propertes");
		
		p.load(in);
		String jsonStr = p.toString();
		System.out.println(jsonStr);

	
	}
	
	@Test
	public void test2() throws Exception
	{
		String s1 = new String("你好");
		String s2 = new String("你好");
		System.out.println(s1==s2);
		
		s1 = "你好";
		s2 = "你好";
		System.out.println(s1==s2);
	}
}
