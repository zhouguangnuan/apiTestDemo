/*
 * @(#)Jsoup_Test.java 2015-1-29 下午1:53:04
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jsoup;

import java.io.File;
import java.net.URLEncoder;

import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.singno.utils.PathUtils;

/**
 * <p>File：Jsoup_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-29 下午1:53:04</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class Jsoup_Test
{
	/**
	 * 过滤html内容
	 * 利用基于 Whitelist 的清除器和 clean(String bodyHtml, Whitelist whitelist)方法来清除用户输入的恶意内容。
	 * 限制用户可以输入的标签范围（可以用以防止XSS攻击 ）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testClean() throws Exception
	{
		String html = "<li><a href='http://www.oschina.net/project/lang/194/csharp' javascript:window.history.back()>C# 开源软件</a></li>" +
					  "<script type='text/javascript' src='/js/utils.js?t=1377425784000'></script>";

		String html2 = "<!DOCTYPE html><html><script>alert('中国人');</script><body><a onclick='alert(11)'>点击我</a></body></html>";
		
		// 新增用户输入的html内容的范围
		// jsoup的whitelist清理器能够在服务器端对用户输入的HTML进行过滤，只输出一些安全的标签和属性。
		Whitelist user_content_filter = Whitelist.relaxed();
	        user_content_filter.addTags("embed", "object", "param", "span", "div");
	        user_content_filter.addAttributes(":all", "style", "class", "id",
	                "name");
	        user_content_filter.addAttributes("object", "width", "height",
	                "classid", "codebase");
	        user_content_filter.addAttributes("param", "name", "value");
	        user_content_filter.addAttributes("embed", "src", "quality", "width",
	                "height", "allowFullScreen", "allowScriptAccess", "flashvars",
	                "name", "type", "pluginspage");
	    
	    html = Jsoup.clean(html, user_content_filter);
//	    html = StringEscapeUtils.escapeHtml4(html);
	    
	    System.out.println(html);
	    // <li><a href="http://www.oschina.net/project/lang/194/csharp">C# 开源软件</a></li>
	    // <script type='text/javascript' src='/js/utils.js?t=1377425784000'></script> 不支持的标签直接被过滤
	    
	    html2 = Jsoup.clean(html2, user_content_filter);
	    System.out.println(html2);
	    // <a>点击我</a>
	}
	
	/**
	 * 解析一个html字符串
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testParse() throws Exception
	{
		String html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		System.out.println("html：");
		System.out.println(doc.html());
		System.out.println("head：");
		System.out.println(doc.head());
		System.out.println("title：");
		System.out.println(doc.title());
		System.out.println("body：");
		System.out.println(doc.body());
		System.out.println("text：");
		System.out.println(doc.text());
		System.out.println("tagName：");
		System.out.println(doc.tagName());

		// 没有关闭的标签，自动补全
		String html1 = "<p>Lorem <p>Ipsum parses to <p>Lorem</p> <p>Ipsum</p>";
		doc = Jsoup.parse(html1);
		System.out.println("html：");
		System.out.println(doc.html());
		
		String html2 = "<td>Table data</td>";
		doc = Jsoup.parse(html2);
		System.out.println("html：");
		System.out.println(doc.html());
	}
	
	/**
	 * 根据一个文件加载Document对象（IOException）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testParseByFile() throws Exception
	{
		File input = new File(getAbsolutePath("test.html"));
		Document doc = Jsoup.parse(input, "UTF-8");
		System.out.println("html：");
		System.out.println(doc.html());
	}
	
	/**
	 * 解析一个body片断
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testParseBodyFragment() throws Exception
	{
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		System.out.println(body);
//		<body>
//			<div>
//				<p>Lorem ipsum.</p>
//			</div>
//		</body>
	}
	
	/**
	 * 根据一个url加载Document对象（IOException）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testConnect() throws Exception
	{
//		Connection con= Jsoup.connect("http://jbk.39.net/bw/key=咳嗽_t2") 
//		.data("query", "Java")   // 请求参数
//		.userAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; BIDUBrowser 2.x)") // 设置 User-Agent 
//		.timeout(30000); // 设置连接超时时间
//		/*.ignoreHttpErrors(true)
//		.followRedirects(true)*/
//
//		Connection.Response resp = con.execute();
//		Document doc = null; 
//		if (resp.statusCode() == 200){ 
//			doc = con.get(); 
//		}
		
		Document doc = Jsoup.connect("http://example.com/").get();
		System.out.println("html：");
		System.out.println(doc.html());
	}
	
	/**
	 * 数据抽取
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testElement() throws Exception
	{
		File input = new File(getAbsolutePath("test.html"));
		Document doc = Jsoup.parse(input, "UTF-8");
		Element content = doc.getElementById("content");

		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
			System.out.println(link);
//			<a href="http://www.iana.org/domains/example">More information...</a>
			System.out.println(link.attr("href"));
//			http://www.iana.org/domains/example
			System.out.println(link.text());
//			More information...
		}
	}
	
	/**
	 * 查找元素
	 * getElementById(String id)
	 * getElementsByTag(String tag)
	 * getElementsByClass(String className)
	 * getElementsByAttribute(String key) (and related methods)
	 * Element siblings: siblingElements(), firstElementSibling(), lastElementSibling();nextElementSibling(), previousElementSibling()
	 * Graph: parent(), children(), child(int index)
	 * attr(String key)获取属性attr(String key, String value)设置属性
	 * attributes()获取所有属性
	 * id(), className() and classNames()
	 * text()获取文本内容text(String value) 设置文本内容
	 * html()获取元素内HTMLhtml(String value)设置元素内的HTML内容
	 * outerHtml()获取元素外HTML内容
	 * data()获取数据内容（例如：script和style标签)
	 * tag() and tagName()
	 * append(String html), prepend(String html)
	 * appendText(String text), prependText(String text)
	 * appendElement(String tagName), prependElement(String tagName)
	 * html(String value)
	 * 
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetElements() throws Exception
	{
		
	}
	
	/**
	 * 使用选择器语法来查找元素
	 * 
     * tagname: 通过标签查找元素，比如：a
     * ns|tag: 通过标签在命名空间查找元素，比如：可以用 fb|name 语法来查找 <fb:name> 元素
     * #id: 通过ID查找元素，比如：#logo
     * .class: 通过class名称查找元素，比如：.masthead
     * [attribute]: 利用属性查找元素，比如：[href]
     * [^attr]: 利用属性名前缀来查找元素，比如：可以用[^data-] 来查找带有HTML5 Dataset属性的元素
     * [attr=value]: 利用属性值来查找元素，比如：[width=500]
     * [attr^=value], [attr$=value], [attr*=value]: 利用匹配属性值开头、结尾或包含属性值来查找元素，比如：[href*=/path/]
     * [attr~=regex]: 利用属性值匹配正则表达式来查找元素，比如： img[src~=(?i)\.(png|jpe?g)]
     * *: 这个符号将匹配所有元素
     * el#id: 元素+ID，比如： div#logo
     * el.class: 元素+class，比如： div.masthead
     * el[attr]: 元素+class，比如： a[href]
     *     任意组合，比如：a[href].highlight
     * ancestor child: 查找某个元素下子元素，比如：可以用.body p 查找在"body"元素下的所有p元素
     * parent > child: 查找某个父元素下的直接子元素，比如：可以用div.content > p 查找 p 元素，也可以用body > * 查找body标签下所有直接子元素
     * siblingA + siblingB: 查找在A元素之前第一个同级元素B，比如：div.head + div
     * siblingA ~ siblingX: 查找A元素之前的同级X元素，比如：h1 ~ p
     * el, el, el:多个选择器组合，查找匹配任一选择器的唯一元素，例如：div.masthead, div.logo
     * :lt(n): 查找哪些元素的同级索引值（它的位置在DOM树中是相对于它的父节点）小于n，比如：td:lt(3) 表示小于三列的元素
     * :gt(n):查找哪些元素的同级索引值大于n，比如： div p:gt(2)表示哪些div中有包含2个以上的p元素
     * :eq(n): 查找哪些元素的同级索引值与n相等，比如：form input:eq(1)表示包含一个input标签的Form元素
     * :has(seletor): 查找匹配选择器包含元素的元素，比如：div:has(p)表示哪些div包含了p元素
     * :not(selector): 查找与选择器不匹配的元素，比如： div:not(.logo) 表示不包含 class="logo" 元素的所有 div 列表
     * :contains(text): 查找包含给定文本的元素，搜索不区分大不写，比如： p:contains(jsoup)
     * :containsOwn(text): 查找直接包含给定文本的元素
     * :matches(regex): 查找哪些元素的文本匹配指定的正则表达式，比如：div:matches((?i)login)
     * :matchesOwn(regex): 查找自身包含文本匹配指定正则表达式的元素
     * 注意：上述伪选择器索引是从0开始的，也就是说第一个元素索引值为0，第二个元素index为1等

	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testSelect() throws Exception
	{
		File input = new File(getAbsolutePath("test.html"));
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		Elements links = doc.select("a[href]"); //带有href属性的a元素
		Elements pngs = doc.select("img[src$=.png]");//扩展名为.png的图片
		Element masthead = doc.select("div.masthead").first();//class等于masthead的div标签
		Elements resultLinks = doc.select("h3.r > a"); //在h3元素之后的a元素
	}
	
	/**
	 * 从元素集合抽取属性、文本和html内容
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetData() throws Exception
	{
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		
		Element link = doc.select("a").first();//查找第一个a元素
		System.out.println(link);
		
		String text = doc.body().text(); // "An example link"//取得字符串中的文本
		String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址
		String linkText = link.text(); // "example""//取得链接地址中的文本
		String linkOuterH = link.outerHtml();// "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容
	}
	
	/**
	 * URL处理
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testURL() throws Exception
	{
//	    在你解析文档时确保有指定base URI，然后
//	    使用 abs: 属性前缀来取得包含base URI的绝对路径。代码如下： 
		
		String url = "http://www.open-open.com/";
//		url = URLEncoder.encode(url, CharEncoding.UTF_8);
		
		Connection con= Jsoup.connect(url) 
			.userAgent("Mozilla/5.0 (Windows NT 6.1; rv:33.0) Gecko/20100101 Firefox/33.0");// 设置 User-Agent 
				
		Document doc = con.get();
		System.out.println(doc.html());
		
		Element link = doc.select("a").first();
		String relHref = link.attr("href"); // == "/"
		String absHref = link.attr("abs:href"); // "http://www.open-open.com/"
		
		System.out.println(relHref);
		System.out.println(absHref);
	}
	
	/**
	 * 数据修改
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testname() throws Exception
	{
//		设置属性的值
//		Element.attr(String key, String value)
//		Elements.attr(String key, String value)
		
//		设置元素的html内容		
//	    Element.html(String html) 这个方法将先清除元素中的HTML内容，然后用传入的HTML代替。
//	    Element.prepend(String first) 和 Element.append(String last) 方法用于在分别在元素内部HTML的前面和后面添加HTML内容
//	    Element.wrap(String around) 对元素包裹一个外部HTML内容。

//		设置元素的文本内容
//	    Element.text(String text) 将清除一个元素中的内部HTML内容，然后提供的文本进行代替
//	    Element.prepend(String first) 和 Element.append(String last) 将分别在元素的内部html前后添加文本节点。

		
	}
	
	// ============================================================================================
	/**
	 * 获得文件的绝对路径
	 * @param fileName
	 * @return
	 * @throws Exception
	 * @author 周光暖
	 */
	private String getAbsolutePath(String fileName) throws Exception
	{
		return PathUtils.getJavaFileAbsolutePath(this.getClass(), "/") + "/" + fileName;
	}
}
