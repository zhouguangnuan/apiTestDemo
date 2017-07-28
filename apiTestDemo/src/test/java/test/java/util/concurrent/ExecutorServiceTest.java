package test.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorServiceTest {
	public ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
	public ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
	public ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
//	public ExecutorService customerExecutorService = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
	public ExecutorService customerExecutorService = new ThreadPoolExecutor(0, 2, 60, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

	@Test
	public void testFixedExecutorService() {
		for (int i = 0; i < 1000; i ++) {
			fixedExecutorService.execute(new PringRunnable());
		}
		for (int i = 0; i < 1000; i ++) {
			fixedExecutorService.execute(new PringRunnable());
		}
//		for (int i = 0; i < 1000; i ++) {
//			fixedExecutorService.execute(new PringRunnable());
//		}
	}
	
	@Test
	public void testCachedExecutorService() throws Exception {
		for (int i = 0; i < 100; i ++) {
			cachedExecutorService.execute(new PringRunnable());
		}
	}
	
	@Test
	public void testSingleExecutorService() throws Exception {
		for (int i = 0; i < 100; i ++) {
			singleExecutorService.execute(new PringRunnable());
		}
	}
	
	@Test
	public void testCustomerExecutorService() {
		for (int i = 0; i < 10000; i ++) {
			customerExecutorService.execute(new PringRunnable());
		}
	}
	
	private class PringRunnable implements Runnable{
		public void run() {
			System.out.println(Thread.currentThread().getId());
		}
	}
}