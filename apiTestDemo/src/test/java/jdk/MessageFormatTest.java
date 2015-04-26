package jdk;
import static org.junit.Assert.*;

import java.text.MessageFormat;
import java.util.Date;

import org.junit.Test;


/**<p>项目名：</p>
 * <p>包名：	</p>
 * <p>文件名：MessageFormatDemo.java</p>
 * <p>版本信息：</p>
 * <p>日期：2014年9月12日-下午2:11:06</p>
 * Copyright (c) 2014singno公司-版权所有
 */

/**<p>名称：MessageFormatDemo.java</p>
 * <p>描述：</p>
 * <pre>
 *     	MessageFormat模式（主要部分）： 
		FormatElement:
		         { ArgumentIndex }
		         { ArgumentIndex , FormatType }
		         { ArgumentIndex , FormatType , FormatStyle }
		 
		 FormatType: 
		         number
		         date
		         time
		         choice（需要使用ChoiceFormat）
		 
		 FormatStyle:
		         short
		         medium
		         long
		         full
		         integer
		         currency
		         percent
		         SubformatPattern（子模式）    
 * </pre>
 * @author 周光暖
 * @date 2014年9月12日 下午2:11:06
 * @version 1.0.0
 */
public class MessageFormatTest
{
	@Test
	public void test1() throws Exception
	{
		String pig = "{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";  
		Object[] array = new Object[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};  
		String value = MessageFormat.format(pig, array);  
		System.out.println(value);  
		//ABCDEFGHIJKLMNOPQ
	}
	
	@Test
	public void test2() throws Exception
	{
//		String message = "oh, {0} is 'a' pig";  //oh, ZhangSan is a pig
		String message = "oh, {0} is ''a'' pig"; //oh, ZhangSan is 'a' pig
//		String message = "oh, '{0}' is a pig";  //oh, {0} is a pig
		Object[] array = new Object[]{"ZhangSan"};  
//		String value = MessageFormat.format(message, array);  
		String value = MessageFormat.format(message, "ZhangSan");  
		System.out.println(value);
	}
	
	@Test
	public void test3() throws Exception
	{
//		String message = "oh, {0,number,#.#} is a pig"; //oh, 3.1 is a pig
		String message = "oh, {0,number,#.##} is a pig"; //oh, 3.1 is a pig
		Object[] array = new Object[]{new Double(3.1415)};  
		String value = MessageFormat.format(message, array);  
		System.out.println(value);  
	}
	
	@Test
	public void test4() throws Exception
	{
		String message = "oh, {0,date,yyyy MM dd hh:mm:ss} is a pig"; 
//		Object[] array = new Object[]{new Date()};  //oh, 2014 is a pig
		Object[] array = new Object[]{new Date().getTime()};  //oh, 2014 is a pig
		String value = MessageFormat.format(message, array);  
		System.out.println(value);  
	}
	
	@Test
	public void test5() throws Exception
	{
		String message = "oh, {0,time,yyyy} is a pig"; 
//		Object[] array = new Object[]{new Date()};  //oh, 2014 is a pig
		Object[] array = new Object[]{new Date().getTime()};  //oh, 2014 is a pig
		String value = MessageFormat.format(message, array);  
		System.out.println(value);  
	}
}









































