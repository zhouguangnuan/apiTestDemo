/**
 * <p>项目名：</p>
 * <p>包名：org.apache.commons.validator</p>
 * <p>文件名：GenericValidatorTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-8-下午11:38:33</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.apache.commons.validator;

import org.junit.Test;

/**
 * <p>名称：GenericValidatorTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-8 下午11:38:33
 * @version 1.0.0
 */
public class GenericValidatorTest
{
	@Test
	public void test() throws Exception
	{
		String value= "";
		System.out.println(GenericValidator.isBlankOrNull(value));
		System.out.println(GenericValidator.isEmail(value));
		System.out.println(GenericValidator.isBlankOrNull(value));
		System.out.println(GenericValidator.isBlankOrNull(value));
	}
}
