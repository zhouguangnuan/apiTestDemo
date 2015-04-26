/*
 * @(#)HelloWorldServerHandler.java 2015-1-30 下午4:30:22
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.mina.demo1;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * <p>File：HelloWorldServerHandler.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-30 下午4:30:22</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class HelloWorldServerHandler extends IoHandlerAdapter  
{  
    /** 
     * Trap exceptions. 
     */  
    @Override  
    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception  
    {  
        cause.printStackTrace();  
    }  
  
    /**
     * 收到消息时执行 
     */
    @Override  
    public void messageReceived( IoSession session, Object message ) throws Exception  
    {  
		String str = message.toString();

		if (str.trim().equalsIgnoreCase("quit"))
		{
			// "Quit" ? let's get out ...
			session.close(true);
			return;
		}

		System.out.println("Received message:" + str);

		// Send the "Hello, I am Server!" back to the client
		String helloWorld = "Hello, I am Server!";
		session.write(helloWorld);
		System.out.println("Message written...");
    }  
  
    /**
     * 闲置时执行 
     */
    @Override  
    public void sessionIdle(IoSession session, IdleStatus status ) throws Exception  
    {  
        System.out.println( "IDLE " + session.getIdleCount( status ));  
    }  
}
