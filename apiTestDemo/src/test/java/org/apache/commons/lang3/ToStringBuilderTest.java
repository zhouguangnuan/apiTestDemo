/**<p>��Ŀ����</p>
 * <p>������	cn.singno.modle.commonsLang</p>
 * <p>�ļ�����ToStringBuilderTest.java</p>
 * <p>�汾��Ϣ��</p>
 * <p>���ڣ�2014��7��18��-����11:35:32</p>
 * Copyright (c) 2014singno��˾-��Ȩ����
 */
package org.apache.commons.lang3;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;

/**<p>���ƣ�ToStringBuilderTest.java</p>
 * <p>������</p>
 * <pre>
 *    
 * </pre>
 * @author �ܹ�ů
 * @date 2014��7��18�� ����11:35:32
 * @version 1.0.0
 */
public class ToStringBuilderTest
{

	@Test
	public void testToString() throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "�ܹ�ů");
		map.put("age", 26);
//		String str = new ToStringBuilder(new Object(), ToStringStyle.MULTI_LINE_STYLE).toString();
		String str = ToStringBuilder.reflectionToString(map, ToStringStyle.MULTI_LINE_STYLE, true);
		System.out.println(str);
	}
}
