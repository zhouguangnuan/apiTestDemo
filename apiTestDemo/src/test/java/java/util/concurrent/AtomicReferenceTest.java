package java.util.concurrent;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;

import com.google.common.collect.Maps;

public class AtomicReferenceTest {
	
	private volatile Integer s = 1;
	
	@Test
	public void testName() throws Exception {
		HashMap<String, String> map = Maps.newHashMap();
		AtomicReference<HashMap<String, String>> amap = new AtomicReference<HashMap<String, String>>(map);

		// amap.compareAndSet(expect, update)
	}
}
