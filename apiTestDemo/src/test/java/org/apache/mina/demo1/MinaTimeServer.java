/*
 * @(#)MinaTimeServer.java 2015-1-30 下午4:29:53
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.mina.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * <p>File：MinaTimeServer.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-30 下午4:29:53</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class MinaTimeServer
{
	private static final int PORT = 8888;  
	  
    public static void main(String[] args) throws IOException {  
    	// IoAcceptor 相当于网络应用程序中的服务器端
        IoAcceptor acceptor = new NioSocketAcceptor();  
          
        // Add two filters : a logger and a codec  
        acceptor.getFilterChain().addLast( "logger", new LoggingFilter() );  
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ))));  
     
        // Attach the business logic to the server  
        acceptor.setHandler( new HelloWorldServerHandler() );  
  
        // Configurate the buffer size and the iddle time  
        acceptor.getSessionConfig().setReadBufferSize( 2048 );  
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );  
          
        // And bind !  
        acceptor.bind( new InetSocketAddress(PORT) );  
    }  
}
