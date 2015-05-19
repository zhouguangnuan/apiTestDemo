/**
 * <p>项目名：</p>
 * <p>包名：org.apache.cxf.service</p>
 * <p>文件名：HelloService.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-12-下午5:21:43</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.apache.cxf.service;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.bean.User;


/**
 * <p>名称：HelloService.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-12 下午5:21:43
 * @version 1.0.0
 */
@WebService  
public interface HelloService
{
	public String sayHi(String text);

	public String getUser(User user);

	public List<User> getListUser();
}