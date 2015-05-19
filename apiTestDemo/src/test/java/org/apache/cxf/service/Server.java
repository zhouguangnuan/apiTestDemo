/**
 * <p>项目名：</p>
 * <p>包名：org.apache.cxf.service</p>
 * <p>文件名：Server.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-12-下午5:24:04</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.apache.cxf.service;

import javax.xml.ws.Endpoint;

/**
 * <p>名称：Server.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-12 下午5:24:04
 * @version 1.0.0
 */
public class Server {  
	      
	    protected Server() throws Exception {  
	        // START SNIPPET: publish  
	        System.out.println("Starting Server");  
	        HelloServiceImpl implementor = new HelloServiceImpl();  
	        String address = "http://localhost:8111/helloWorld";  
	        Endpoint.publish(address, implementor);  
	        // END SNIPPET: publish
	        
//	        http://localhost:8111/helloWorld?wsdl
	    }  
	      
	    public static void main(String[] args) throws Exception {  
	        new Server();  
	        System.out.println("Server ready...");  
	  
	        Thread.sleep(5 * 60 * 1000 * 10);  
	        System.out.println("Server exiting");  
	        System.exit(0);  
	    }  
	}  
