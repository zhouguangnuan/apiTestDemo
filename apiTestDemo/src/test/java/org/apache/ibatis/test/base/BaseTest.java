/**<p>项目名：</p>
 * <p>包名：org.hibernate</p>
 * <p>文件名：BasicTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-4-9-下午1:52:25</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.apache.ibatis.test.base;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**<p>名称：BaseTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-4-9 下午1:52:25
 * @version 1.0.0
 */
public class BaseTest
{
	protected static SqlSession session;
	
	@Before
	public void beforeTest() throws Exception
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config-mybatis.xml");
		SqlSessionFactoryBean sessionFactory = (SqlSessionFactoryBean) ac.getBean(SqlSessionFactoryBean.class);
		session = sessionFactory.getObject().openSession();
	}
	
	@After
	public void endTest() throws Exception
	{
		session.close();
	}
}
