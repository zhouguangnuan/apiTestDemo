/**<p>项目名：</p>
 * <p>包名：org.hibernate</p>
 * <p>文件名：BasicTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-4-9-下午1:52:25</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.entity.Department;
import org.hibernate.entity.User;
import org.hibernate.test.base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.alibaba.fastjson.JSON;

/**<p>名称：CascadeiTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-4-9 下午1:52:25
 * @version 1.0.0
 */
public class CascadeiTest extends BaseTest
{
	@Test
	public void testSave1() throws Exception
	{
		session.beginTransaction();
		
		Department department = new Department();
		department.setDepartmentName("coding");
		department.setDescription("研发中心");
//		session.save(department);
		
		User user = new User();
		user.setUserName("singno");
		user.setPassword("123123");
		user.setSalt("sdfsadgdfgdfgfdg");
		user.setAge(11);
		user.setDepartment(department);
		session.save(user);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testSave2() throws Exception
	{
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("singno");
		user.setPassword("123123");
		user.setSalt("sdfsadgdfgdfgfdg");
		user.setAge(11);
		
		Department department = new Department();
		department.setDepartmentName("coding");
		department.setDescription("研发中心");
		Set<User> users = new HashSet<User>();
		users.add(user);
		department.setUsers(users);
		session.save(department);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testManyToOne() throws Exception
	{
		session.beginTransaction();
		
		User user = (User) session.get(User.class, "402881854c9ec024014c9ec026a20001");
//		System.out.println(JSON.toJSONString(user));
		
		Department department = user.getDepartment();
		System.out.println(JSON.toJSONString(department));
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testOneToMany() throws Exception
	{
		session.beginTransaction();
		
		Department department = (Department) session.get(Department.class, "8a8299204ca14be3014ca14be67f0001");
		System.out.println(JSON.toJSONString(department));
		
		Set<User> users = department.getUsers();
		System.out.println(JSON.toJSONString(users));
		
		session.getTransaction().commit();
	}
}
