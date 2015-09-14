/**<p>项目名：</p>
 * <p>包名：org.hibernate</p>
 * <p>文件名：BasicTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-4-9-下午1:52:25</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.hibernate.test;


import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.entity.User;
import org.hibernate.entity2.VUser;
import org.hibernate.test.base.BaseTest;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**<p>名称：BasicApiTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-4-9 下午1:52:25
 * @version 1.0.0
 */
public class BasicApiTest extends BaseTest
{
	@Test
	public void testSave() throws Exception
	{
		session.beginTransaction();
		User user = new User();
		user.setUserName("singno");
		user.setPassword("123123");
		user.setSalt("sdfsadgdfgdfgfdg");
		user.setAge(11);
		user.setCreateTime(new Date());
		session.save(user);
		
//		Husband husband = new Husband();
//		husband.setHusbandName("husband");
//		Wife wife = new Wife();
//		wife.setName("wife");
//		husband.setWife(wife);
//		session.save(husband);
		
//		Department d1 = new Department();
//		d1.setDepartmentName("test1");
//		Department d2 = new Department();
//		d2.setDepartmentName("test2");
//		d2.setParent(d1);
//		session.save(d2);
		
		
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testUpate() throws Exception
	{
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("singno");
		user.setPassword("222222");
		user.setSalt("sdfsadgdfgdfgfdg");
		user.setAge(11);
		session.update(user);
		
		session.getTransaction().commit();
		// org.hibernate.TransientObjectException: The given object has a null identifier: org.hibernate.entity.User
	}
	
	@Test
	public void testSaveOrUpdate() throws Exception
	{
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("singno");
		user.setPassword("222222");
		user.setSalt("sdfsadgdfgdfgfdg");
		user.setAge(11);
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
		// org.hibernate.TransientObjectException: The given object has a null identifier: org.hibernate.entity.User
	}
	
	@Test
	public void testLoad() throws Exception
	{
		session.beginTransaction();
		
		User user = (User) session.load(User.class, "8a878b4d4c9d37ff014c9d3800ad0000");
		// 未发送sql
		System.out.println(JSON.toJSONString(user));// 这里发送sql
		
//		user.setAge(203);
		session.save(user);
//		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testGet() throws Exception
	{
		session.beginTransaction();
		
//		User user = (User) session.get(User.class, "8a878b4d4c9d37ff014c9d3800ad0000");// 这里发送sql
//		System.out.println(JSON.toJSONString(user));
		
//		Husband husband = (Husband) session.get(Husband.class, "8a8299204ca2033a014ca2033fa20000");// 这里发送sql
//		System.out.println(JSON.toJSONString(husband));
		
//		Wife wife = (Wife) session.get(Wife.class, "8a8299204ca20c2f014ca20c31dc0001");// 这里发送sql
//		System.out.println(JSON.toJSONString(wife));
		
//		Department department = (Department) session.get(Department.class, "8a82991c4ca25561014ca25563310000");// 这里发送sql
//		System.out.println(JSON.toJSONString(department));
		
		VUser v_User = (VUser) session.get(VUser.class, "8a8299264cbb9525014cbb952c0b0000");// 这里发送sql
		System.out.println(JSON.toJSONString(v_User));
		v_User.setAge(40);
		session.update(v_User);
		
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testSQL() throws Exception
	{
		session.beginTransaction();
		
		String queryString = "select wife.* from Wife wife left join Husband husband on wife.refrenceId=husband.wifeId where wife.refrenceId=?";
		Query query = session.createSQLQuery(queryString);
		query.setParameter(0, "8a8299204ca23472014ca23475630001");
		List list = query.list();
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testContains() throws Exception
	{
		session.beginTransaction();
		
		User user = (User) session.get(User.class, "8a878b4d4c9d37ff014c9d3800ad0000");// 这里发送sql
		User user2 = (User) BeanUtils.cloneBean(user);
		user2.setRefrenceId("11");
		boolean  contains = session.contains(user2);
		System.out.println(contains);
		
		session.getTransaction().commit();
	}
	
	
}
