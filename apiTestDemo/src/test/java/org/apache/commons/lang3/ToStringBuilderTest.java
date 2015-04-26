/**<p>项目名：</p>
 * <p>包名：	cn.singno.modle.commonsLang</p>
 * <p>文件名：ToStringBuilderTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2014年7月18日-下午11:35:32</p>
 * Copyright (c) 2014singno公司-版权所有
 */
package org.apache.commons.lang3;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;

/**<p>名称：ToStringBuilderTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2014年7月18日 下午11:35:32
 * @version 1.0.0
 */
public class ToStringBuilderTest
{

	@Test
	public void testToString() throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "周光暖");
		map.put("age", 26);
//		String str = new ToStringBuilder(new Object(), ToStringStyle.MULTI_LINE_STYLE).toString();
		String str = ToStringBuilder.reflectionToString(map, ToStringStyle.MULTI_LINE_STYLE, true);
		System.out.println(str);
	}
}
