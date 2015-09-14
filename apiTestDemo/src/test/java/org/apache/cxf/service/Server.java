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

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

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
	      
	protected Server() throws Exception
	{
		// 第一种发布方式：通过CXF提供的JaxWsServerFactoryBean来发布webservice
//		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
//		factory.setServiceClass(HelloServiceImpl.class);
//		factory.setAddress("http://localhost:8111/helloWorld");
//		org.apache.cxf.endpoint.Server server = factory.create();
//		server.start();

		// 第二种方式，通过JAX-WS提供的Endpoint来发布webservice
		// 首先创建webservice服务提供类的实例
		HelloServiceImpl implementor = new HelloServiceImpl();
		String address = "http://localhost:8111/helloWorld";
		Endpoint.publish(address, implementor);

		// http://localhost:8111/helloWorld?wsdl
	}

	public static void main(String[] args) throws Exception
	{
		new Server();
		System.out.println("Server ready...");

		Thread.sleep(5 * 60 * 1000 * 10);
		System.out.println("Server exiting");
		System.exit(0);
	}
}
