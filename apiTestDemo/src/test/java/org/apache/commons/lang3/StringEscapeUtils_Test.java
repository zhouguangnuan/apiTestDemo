/*
 * @(#)StringEscapeUtils_Test.java 2015-1-28 上午10:28:01
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import org.junit.Test;

/**
 * <p>File：StringEscapeUtils_Test.java</p>
 * <p>Title: 转义字符串</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 上午10:28:01</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class StringEscapeUtils_Test
{
	/**
	 * 将字符串经过 html 转义得到适合在页面中显示的内容
	 * 
	 * 将转义后的内容复制进页面里预览将会以文本的方式输出，不会当成html代码执行（可以用以防止XSS攻击 ）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testEscapeHtml4() throws Exception
	{
		System.out.println("html:"
				+ StringEscapeUtils.escapeHtml4("/n\n"));
		// html:/n
		System.out.println("html:"
				+ StringEscapeUtils.escapeHtml4("<p>"));
		// html:&lt;p&gt;
		System.out.println("html:"
				+ StringEscapeUtils.unescapeHtml4("<p>"));
		// html:<p>
		System.out.println("html:"
				+ StringEscapeUtils
						.escapeHtml4("www.baidu.com?id=123&name=singno"));
		// html:www.baidu.com?id=123&amp;name=singno
		System.out.println("html:"
				+ StringEscapeUtils
						.escapeHtml4("<script type='text/javascript'/>"));
		// html:&lt;script type='text/javascript'/&gt;
		System.out.println("html:"
				+ StringEscapeUtils
						.unescapeHtml4("&lt;script type='text/javascript'/&gt;"));
		// html:<script type='text/javascript'/>

		// escapeHtml4 和 escapeHtml3 的区别
		System.out.println(StringEscapeUtils.escapeHtml3("<!DOCTYPE html><html><script>alert('中国人');</script><body><a onclick='alert(11)'>点击我</a></body></html>"));
		System.out.println(StringEscapeUtils.escapeHtml4("<!DOCTYPE html><html><script>alert('中国人');</script><body><a onclick='alert(11)'>点击我</a></body></html>"));
	}
	
	@Test
	public void testname() throws Exception
	{
		String input = "<script type='text/javascript'/>";
		System.out.println(StringEscapeUtils.escapeEcmaScript(input));// <script type=\'text\/javascript\'\/>
	}
	
	/**
	 * 字符串的Escape 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testname2() throws Exception
	{
		System.out.println(StringEscapeUtils.escapeCsv("测试测试哦"));
		// 测试测试哦
		
		System.out.println(StringEscapeUtils.escapeCsv("测试,测试哦"));
		// "测试,测试哦"
		
		System.out.println(StringEscapeUtils.escapeCsv("测试\n测试哦"));
		// "测试
		// 测试哦"
		 
		System.out.println(StringEscapeUtils.escapeHtml4("<p>测试测试哦</p>"));
		// &lt;p&gt;测试测试哦&lt;/p&gt;
		
		System.out.println(StringEscapeUtils.escapeJava("\"rensaninng\"，欢迎您！"));
		// \"rensaninng\"\uFF0C\u6B22\u8FCE\u60A8\uFF01
		 
		System.out.println(StringEscapeUtils.escapeEcmaScript("测试'测试哦"));
		// \u6D4B\u8BD5\'\u6D4B\u8BD5\u54E6
		
		System.out.println(StringEscapeUtils.escapeXml("<tt>\"bread\" & \"butter\"</tt>"));
		// &lt;tt&gt;&quot;bread&quot; &amp; &quot;butter&quot;&lt;/tt&gt;
		
		System.out.println(StringEscapeUtils.escapeHtml4("<tt>\"bread\" & \"butter\"</tt>"));
		// &lt;tt&gt;&quot;bread&quot; &amp; &quot;butter&quot;&lt;/tt&gt;
	}
	
	@Test
	public void testname3() throws Exception
	{
		System.out.println(StringEscapeUtils.unescapeHtml4("&lt;tt&gt;&quot;bread&quot; &amp; &quot;butter&quot;&lt;/tt&gt"));
		// <tt>"bread" & "butter"</tt&gt
	}
}
