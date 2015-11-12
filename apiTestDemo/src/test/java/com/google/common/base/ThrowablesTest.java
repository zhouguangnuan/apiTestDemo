package com.google.common.base;


import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>文件名称: ThrowablesTest.java</p>
 * <p>文件描述: </p>
 * <p>版权所有: 本来生活版权所有(C)</p>
 * <p>公    司: 本来生活</p>
 * <p>内容摘要: // 简要描述本文件的内容，包括主要模块、函数及其功能的说明</p>
 * <p>其他说明: // 其它内容的说明</p>
 * <p>完成日期：2015-10-14-下午2:46:19</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：</p>
 * @version 1.0
 * @author  周光暖
 */
public class ThrowablesTest
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(ThrowablesTest.class);

	@Test
	public void testThrowables()
	{
		try
		{
			throw new Exception();
		}
		catch (Throwable t)
		{
			logger.error("fail to resolve json-tag with data:{},error:{}", 11, Throwables.getStackTraceAsString(t));
//			Throwables.propagate(t);
		}
	}

	@Test
	public void call() throws IOException
	{
		try
		{
			throw new IOException();
		}
		catch (Throwable t)
		{
			Throwables.propagateIfInstanceOf(t, IOException.class);
			throw Throwables.propagate(t);
		}
	}    
}
