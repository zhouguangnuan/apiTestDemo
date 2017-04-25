package test.java.util.Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class CollectionTest {
	
	/**
	 * 简便写法
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		Set<String> sets = new HashSet<String>(){{add("String1");add("String2");add("String3");}};
		System.out.println(JSON.toJSONString(sets));
	}
	
	@Test
	public void testName2() throws Exception {
		HashMap<String, String> sets = new HashMap<String, String>(){{
			put("key1", "value");
		}};
	}
}
