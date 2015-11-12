/**
 * <p>项目名：</p>
 * <p>包名：org.apache.cxf.service</p>
 * <p>文件名：HelloServiceImpl.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-12-下午5:23:24</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.apache.cxf.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.bean.User;


/**
 * <p>名称：HelloServiceImpl.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-12 下午5:23:24
 * @version 1.0.0
 */
@WebService(endpointInterface = "org.apache.cxf.service.HelloService", serviceName = "HelloService", portName = "HelloServicePort")
public class HelloServiceImpl implements HelloService
{

	public String sayHi(String text)
	{
		System.out.println("sayHi called...");
		return "Hi :" + text;
	}

	public String getUser(User user)
	{
		System.out.println("sayUser called...");
		return "User:[id=" + user.getId() + "][name=" + user.getName()
				+ "]";
	}

	public List<User> getListUser()
	{
		System.out.println("getListUser called...");
		List<User> lst = new ArrayList<User>();
		lst.add(new User(2, "u2222222"));
		lst.add(new User(3, "u3"));
		lst.add(new User(4, "u4"));
		lst.add(new User(5, "u5"));
		lst.add(new User(6, "u6"));
		return lst;
	}

}