package org.apache.commons.configuration;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.springframework.util.NumberUtils;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("all")
public class PropertiesConfigurationTest
{
	/**
	 * 描述：读取数据<br>
	 * <pre></pre>
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception
	{
		//注意路径默认指向的是classpath的根目录  
		Configuration config = new PropertiesConfiguration("test.properties");  
//		Configuration config = new PropertiesConfiguration();
		
		String ip=config.getString("ip");  
		int port=config.getInt("port");  
		String title=config.getString("application.title");  
		//再举个Configuration的比较实用的方法吧,在读取配置文件的时候有可能这个键值对应的值为空，那么在下面这个方法中  
		//你就可以为它设置默认值。比如下面这个例子就会在test.properties这个文件中找id的值，如果找不到就会给id设置值为123  
		//这样就保证了java的包装类不会返回空值。虽然功能很简单，但是很方便很实用。  
		Integer id=config.getInteger("id", new Integer(123));  
		//如果在properties 文件中有如下属性keys=cn,com,org,uk,edu,jp,hk  
		//可以实用下面的方式读取：  
		String[] keys1=config.getStringArray("keys1");  
		List keys2=config.getList("keys1");  
	}
	
	/**
	 * 描述：设置默认配置<br>
	 * <pre>分隔符...</pre>
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception
	{
		// 设置默认分隔符【默认是 ","】
		AbstractConfiguration.setDefaultListDelimiter('/');  
		Configuration config = new PropertiesConfiguration("test.properties");  
		String[] keys1_array = config.getStringArray("keys1");  
		List key1_list = config.getList("keys1");  
		
		String[] keys2_array = config.getStringArray("keys2");  
                List key2_list = config.getList("keys2");  
                
		System.out.println("keys1_array：" + JSON.toJSONString(keys1_array));
		System.out.println("key1_list：" + JSON.toJSONString(key1_list));
		System.out.println("keys2_array：" + JSON.toJSONString(keys2_array));
		System.out.println("key2_list：" + JSON.toJSONString(key2_list));
	}
	
	@Test
	public void testname() throws Exception
	{
//		Configuration config = new PropertiesConfiguration("test.properties");  
//		String s = config.getString("test.aa"); 
		
		
		Properties prop=new Properties();         
		prop.load(new InputStreamReader(PropertiesConfigurationTest.class.getClassLoader().getResourceAsStream("test.properties"), "UTF-8"));  
		
		System.out.println(prop.get("test.aa"));
	}
	
	/**
	 * 描述：设置配置文件值<br>
	 * <pre></pre>
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception
	{
		PropertiesConfiguration config = new PropertiesConfiguration("test.properties");    
		config.setProperty("id2222", "sss22333");  
		config.save();  
	}
}
