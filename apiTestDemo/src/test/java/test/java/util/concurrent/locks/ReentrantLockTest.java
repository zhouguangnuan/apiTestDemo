package test.java.util.concurrent.locks;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ReentrantLockTest {
	
	private static ConcurrentHashMap<String, ReentrantLock> lockMap = new ConcurrentHashMap<String, ReentrantLock>();
	
	public static void main(String[] args) {
		
		final Lock lock = new ReentrantLock();
		
		new Thread("Thread1"){  
            @Override  
            public void run() {  
        		lock.lock();					
        		try {
    				try {
    					Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    				System.out.println("11111111111");
        		}
        		finally {
        			lock.unlock();
        		}
            }
        }.start();
        
        new Thread("Thread2"){  
            @Override  
            public void run() {  
        		lock.lock();					
        		try {
        			System.out.println("22222222222");
        		}
        		finally {
        			lock.unlock();
        		}
            }  
        }.start();
	}
	
	private ReentrantLock getLock(String key) {
		ReentrantLock lock = lockMap.get(key);
		if (lock != null)
			return lock;
		
		lock = new ReentrantLock();
		ReentrantLock previousLock = lockMap.putIfAbsent(key, lock);
		return previousLock == null ? lock : previousLock;
	}
}
