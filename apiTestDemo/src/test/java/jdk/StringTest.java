package jdk;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;

import com.google.common.collect.Maps;


public class StringTest
{
	@Test
	public void testname() throws Exception
	{
		throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", "1111"));  
	}
	
	@Test
	public void testname2() throws Exception
	{
		String str = String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s],[%s]", "1", "2");
		System.out.println(str);
	}
}
