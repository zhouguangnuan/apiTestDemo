package org.apache.commons.lang.math;

import org.junit.Test;

public class RandomUtilsTest {
	
	@Test
	public void nextInt() throws Exception {
		for(int i=0; i<10000; i++){
			System.out.println(RandomUtils.nextInt(5));
		}
	}
}
