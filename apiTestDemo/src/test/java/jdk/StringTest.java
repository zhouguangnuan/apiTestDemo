package jdk;

import org.junit.Test;

public class StringTest
{
	@Test
	public void testname() throws Exception
	{
		throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", "1111"));  
	}
}
