/*
 * @(#)MemcachedClientTest.java 2015-2-6 下午4:18:47
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.googlecode.xmemcached;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.CASOperation;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 名称：XMemcachedTest.java<br>
 * 描述：<br>
 * <pre></pre>
 * @author 周光暖
 * @date 2015-2-9 下午10:51:49
 * @version 1.0.0
 */
public class XMemcachedTest
{
	/**
	 * Logger for this class
	 */
	// private static final Logger logger =
	// Logger.getLogger(XMemcachedTest.class);

	private static MemcachedClient memcachedClient;
	private String key;
	int exp;
	
	@Before
	public void initMemcachedClient() throws Exception
	{
		XMemcachedClientBuilder XMemcachedClientBuilder = new XMemcachedClientBuilder("localhost:11211");
		memcachedClient = XMemcachedClientBuilder.build();
		key = "testkey";
		exp = 0;
		memcachedClient.set(key, exp, this.getKeySet());
	}
	
	@Test
	public void testGet() throws Exception
	{
		Set<String> keySet = memcachedClient.get(key);
		System.out.println(ArrayUtils.toString(keySet));
	}

	/**
	 * 描述：添加缓存（key-vlue）<br>
	 * <pre>key不存在时，才成功</pre>
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception
	{
//		memcachedClient.delete(key);
		
		Set<String> keySet = this.getKeySet();
		boolean flog = memcachedClient.add(key, exp, keySet);
		System.out.println(flog);
	}
	
	/**
	 * 描述：替换缓存key对应的keyue<br>
	 * <pre>key存在时，才成功</pre>
	 * @throws Exception
	 */
	@Test
	public void testReplace() throws Exception
	{
//		memcachedClient.delete(key);
		
		Set<String> keySet = this.getKeySet();
		boolean flog = memcachedClient.replace(key, exp, keySet);
		System.out.println(flog);
	}
	
	/**
	 * 描述：设置缓存key对应的keyue<br>
	 * <pre>不管key是否存在，都可以重新构建缓存（key-vlue）</pre>
	 * @throws Exception
	 */
	@Test
	public void testSet() throws Exception
	{
		// [key3, key1, key2]
		Set<String> keySet1 = memcachedClient.get(key);
		Set<String> keySet2 = memcachedClient.get(key);
		keySet1.add("key4");// 
		keySet2.clear();
		
		// 替换缓存（顺序1）
		if (!memcachedClient.set(key, 0, keySet2)){
			System.err.println("keySet2 set error");
		}
		
		// 替换缓存（顺序2）：根顺序1替换，观察结合缓存的值
		if (!memcachedClient.set(key, exp, keySet1)){
			System.err.println("keySet1 set error");
		}
		
		this.testGet();
		// [key3, key4, key1, key2]
		// []
		// 并发操作，可能会丢失 key4 值
	}

	
	
	/**
	 * 描述：CAS compare and set<br>
	 * <pre>
	 * 每次请求存储某个数据同时要附带一个cas值，memcached比对这个cas值与当前存储数据的cas值是否相等，
	 * 如果相等就让新的数据覆盖老的数据，如果不相等就认为更新失败。
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testCAS_Gets() throws Exception
	{
		// [key3, key1, key2]
		GetsResponse<Set<String>> result1 = memcachedClient.gets(key);// 获得（带CAS和Value）的值
		GetsResponse<Set<String>> result2 = memcachedClient.gets(key);
		Set<String> keySet1 = result1.getValue();
		Set<String> keySet2 = result2.getValue();
		final long cas1 = result1.getCas();
		final long cas2 = result2.getCas();
		keySet1.add("key4");// 
		keySet2.clear();
		
		
		// 替换缓存（顺序1）
		if (!memcachedClient.cas(key, 0, keySet2, cas2)){
			System.err.println("keySet2 cas error");
		}
		
		// 替换缓存（顺序2）：根顺序1替换，观察结合缓存的值
		if (!memcachedClient.cas(key, exp, keySet1, cas1)){
			System.err.println("keySet1 cas error");
		}
		
		this.testGet();
		// [key3, key4, key1, key2]
		// []
		// 并发操作，可能会丢失 key4 值，需要对替换失败的操作做处理
	}
	
	
	/**
	 * 描述：CAS compare and set<br>
	 * <pre>
	 * 方法提供与当前存储数据的cas值和value，根据自己业务需要制定更新策略（决定更新后缓存的值）。
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testCAS2() throws Exception
	{
		// [key3, key1, key2]
		GetsResponse<Set<String>> result1 = memcachedClient.gets(key);// 获得（带CAS和Value）的值
		GetsResponse<Set<String>> result2 = memcachedClient.gets(key);
		GetsResponse<Set<String>> result3 = memcachedClient.gets(key);
		Set<String> keySet1 = result1.getValue();
		Set<String> keySet2 = result2.getValue();
		Set<String> keySet3 = result3.getValue();
		final long cas1 = result1.getCas();
		final long cas2 = result2.getCas();
		final long cas3 = result3.getCas();
		keySet1.add("key4");// 
		keySet2.clear();
		keySet3.add("key5");// 
		
		// 替换缓存（顺序3）
		this.cas(key, exp, keySet3, cas3);
		
		// 替换缓存（顺序1）
		this.cas(key, exp, keySet2, cas2);
		
		// 替换缓存（顺序2）：根顺序1替换，观察结合缓存的值
		this.cas(key, exp, keySet1, cas1);
		
		
		
		this.testGet();
		// [key3, key4, key1, key2]
		// [key3, key5, key1, key2]
		// key4 或 key5 的丢失
	}
	
	@Test
	public void testCAS3() throws Exception
	{
		// [key3, key1, key2]
		GetsResponse<Set<String>> result1;
		Set<String> keySet1;
		
		// 替换缓存（顺序3）
		boolean again = true;
		int num = 1;
		while (again){
			result1 = memcachedClient.gets(key);
			keySet1 = result1.getValue();
			keySet1.add("key4");
			
			if (num == 1)// 第一次并发
			{
				GetsResponse<Set<String>> result2 = memcachedClient.gets(key);
				Set<String> keySet2 = result2.getValue();
				keySet2.clear();
				memcachedClient.cas(key, 0, keySet2, result2.getCas());
			}
			
			if (num == 2)// 第二次并发
			{
				GetsResponse<Set<String>> result3 = memcachedClient.gets(key);
				Set<String> keySet3 = result3.getValue();
				keySet3.add("key5");// 
				memcachedClient.cas(key, 0, keySet3, result3.getCas());
			}
			num++;
			
			again = !memcachedClient.cas(key, 0, keySet1, result1.getCas());
		}
		
		this.testGet();
		// [key4, key5]
		// 结果正确
	}

	private void cas(final String key, final int exp, final Set<String> keySet, final long cas) throws TimeoutException, InterruptedException, MemcachedException
	{
		memcachedClient.cas(key, exp, new CASOperation<Set<String>>(){

			// 设置允许你尝试去原子更新某个key存储的数据的次数
			@Override
			public int getMaxTries()
			{
				return 2;
//				return Integer.MAX_VALUE;
			}

			// 获得将被替换成的值
			@Override
			public Set<String> getNewValue(long currentCAS, Set<String> currentValue)
			{
				if (cas == currentCAS)// 表示数据没有被其它请求更新过，可以直接更新值
				{
					return keySet;
				}
				else
				{
					// 更新keySet记录多的值，避免key丢失
					return currentValue.size() > keySet.size() ? currentValue : keySet;
				}
			}
			
		});
	}
	
	private Set<String> getKeySet()
	{
		Set<String> keySet = new HashSet<String>();
		keySet.add("key1");
		keySet.add("key2");
		keySet.add("key3");
		return keySet;
	}
}
