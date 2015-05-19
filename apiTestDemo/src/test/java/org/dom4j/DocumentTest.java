/**<p>项目名：</p>
 * <p>包名：org.dom4j</p>
 * <p>文件名：DocumentTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-4-24-下午1:07:22</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package org.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import bean.GET_DOC_HOS_PATIENT;

import com.alibaba.fastjson.JSON;
import com.singno.utils.IGPFUtils;

/**<p>名称：DocumentTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-4-24 下午1:07:22
 * @version 1.0.0
 */
public class DocumentTest
{
	static String fileStr = "C:\\Users\\Administrator\\Desktop\\test.xml";
	
	
	/** 创建XML文档 */
	@Test
	public void testCreateDocument() throws Exception
	{
		Document document = DocumentHelper.createDocument();
	       // ProcessingInstruction
	       Map<String, String> inMap = new HashMap<String, String>();
	       inMap.put("type", "text/xsl");
	       inMap.put("href", "students.xsl");
	       document.addProcessingInstruction("xml-stylesheet", inMap);
	       // root element
	       Element studentsElement = document.addElement("students");
	       // 注释
	       studentsElement.addComment("An Student Catalog");
	       // son element
	       Element stuElement = studentsElement.addElement("student");
	       stuElement.addAttribute("sn", "01");
	       Element nameElement = stuElement.addElement("name");
	       nameElement.setText("sam");
	       Element ageElement = stuElement.addElement("age");
	       ageElement.setText("18");
	       // son element
	       Element anotherStuElement = studentsElement.addElement("student");
	       anotherStuElement.addAttribute("sn", "02");
	       Element anotherNameElement = anotherStuElement.addElement("name");
	       anotherNameElement.setText("lin");
	       Element anotherAgeElement = anotherStuElement.addElement("age");
	       anotherAgeElement.setText("20");
		
	       System.out.println(document.asXML());
	       
//	       this.saveDocument(document, new File(fileStr));
	}
	
	@Test
	public void testLoadDocumentByFile() throws Exception
	{
		SAXReader reader = new SAXReader(); 
		InputStream in = FileUtils.openInputStream(new File(fileStr));
		Document dom = reader.read(in);
		System.out.println(JSON.toJSONString(dom));
	}
	
	@Test
	public void testParseText() throws Exception
	{
		String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			              "<?xml-stylesheet type=\"text/xsl\" href=\"students.xsl\"?>" +
			              "<students><!--An Student Catalog-->   <student sn=\"01\">" +
			              "<name>sam</name><age>18</age></student><student sn=\"02\">" +
			              "<name>lin</name><age>20</age></student></students>";
	       Document document = null;
	       try {
	           document = DocumentHelper.parseText(text);
	       } catch (DocumentException e) {
	           e.printStackTrace();
	       }
	}
	
	/** 修改XML文档 */
	@Test
	public void testUpdateDocument() throws Exception
	{
		SAXReader saxReader = new SAXReader();
	           Document document = saxReader.read(fileStr);
	           List list = document.selectNodes("//students/student/@sn");
	           Iterator iter = list.iterator();
	           while (iter.hasNext()) {
	              Attribute attribute = (Attribute) iter.next();
	              if (attribute.getValue().equals("01"))
	                  attribute.setValue("001");
	           }
	 
	           list = document.selectNodes("//students/student");
	           iter = list.iterator();
	           while (iter.hasNext()) {
	              Element element = (Element) iter.next();
	              Iterator iterator = element.elementIterator("name");
	              while (iterator.hasNext()) {
	                  Element nameElement = (Element) iterator.next();
	                  if (nameElement.getText().equals("sam"))
	                     nameElement.setText("jeff");
	              }
	           }
	 
	           XMLWriter output = new XMLWriter(new FileWriter(new File("students-modified.xml")));
	           output.write(document);
	           output.close();
	           this.saveDocument(document, new File("C:\\Users\\Administrator\\Desktop\\students-modified.xml"));
	}
	
	/** 保存XML文档 */
	public void  saveDocument(Document document, File outputXml) throws Exception
	{
		// 美化格式
	       OutputFormat format = OutputFormat.createPrettyPrint();
	       // 缩减格式
               // OutputFormat format = OutputFormat.createCompactFormat();
	       // 指定XML编码
               // format.setEncoding("GBK");
	       XMLWriter output = new XMLWriter(new FileWriter(outputXml), format);
	       output.write(document);
	       output.close();
	}
	
	/** 遍历XML文档 */
	@Test
	public void testIterator() throws Exception
	{
		SAXReader reader = new SAXReader(); 
		InputStream in = FileUtils.openInputStream(new File(fileStr));
		Document dom = reader.read(in);
		Element root = dom.getRootElement();
	       // 枚举根节点下所有子节点
	       for (Iterator ie = root.elementIterator(); ie.hasNext();) {
	           System.out.println("======");
	           Element element = (Element) ie.next();
	           System.out.println(element.getName());
	 
	           // 枚举属性
	           for (Iterator ia = element.attributeIterator(); ia.hasNext();) {
	              Attribute attribute = (Attribute) ia.next();
	              System.out.println(attribute.getName() + ":"
	                     + attribute.getData());
	           }
	           // 枚举当前节点下所有子节点
	           for (Iterator ieson = element.elementIterator(); ieson.hasNext();) {
	              Element elementSon = (Element) ieson.next();
	              System.out.println(elementSon.getName() + ":"
	                     + elementSon.getText());
	           }
	       }
	}
	
	// Visitor是自动遍历所有子节点的
	@Test
	public void testVisitor() throws Exception
	{
		SAXReader reader = new SAXReader(); 
		InputStream in = FileUtils.openInputStream(new File(fileStr));
		Document dom = reader.read(in);
		dom.accept(new MyVisitor());
	}
	
	/**
	 * 定义自己的访问者类
	 */
	private static class MyVisitor extends VisitorSupport
	{
		/**
		 * 对于属性节点，打印属性的名字和值
		 */
		public void visit(Attribute node)
		{
			System.out.println("attribute : " + node.getName() + " = " + node.getValue());
		}

		/**
		 * 对于处理指令节点，打印处理指令目标和数据
		 */
		public void visit(ProcessingInstruction node)
		{
			System.out.println("PI : " + node.getTarget() + " " + node.getText());
		}

		/**
		 * 对于元素节点，判断是否只包含文本内容，如是，则打印标记的名字和 元素的内容。如果不是，则只打印标记的名字
		 */
		public void visit(Element node)
		{
			if (node.isTextOnly())
				System.out.println("element : " + node.getName() + " = " + node.getText());
			else
				System.out.println("--------" + node.getName() + "--------");
		}
	}
	
	/** ElementHandler */
	@Test
	public void testElementHandler() throws Exception
	{
		SAXReader saxReader = new SAXReader();
		File file = new File(fileStr);
		// 添加一个ElementHandler实例。
		saxReader.addHandler("/students/student", new StudentHandler());
		saxReader.read(file);
	}
	
	/**
	 * 定义StudentHandler处理器类，对<student>元素进行处理。
	 */
	public static class StudentHandler implements ElementHandler
	{
		@Override
		public void onStart(ElementPath elementPath)
		{
			Element elt  = elementPath.getCurrent();
			System.out.println("Found student: " + elt.attributeValue("sn"));
			// 添加对子元素<name>的处理器。
			elementPath.addHandler("name", new NameHandler());
		}

		@Override
		public void onEnd(ElementPath elementPath)
		{
			// 移除对子元素<name>的处理器。
			elementPath.removeHandler("name");
		}
	}
	
	/**
	 * 定义NameHandler处理器类，对<student>的<name>子元素进行处理。
	 */
	private static class NameHandler implements ElementHandler
	{
		@Override
		public void onStart(ElementPath elementPath)
		{
			System.out.println("path : " + elementPath.getPath());
		}

		@Override
		public void onEnd(ElementPath elementPath)
		{
			Element elt = elementPath.getCurrent();
			// 输出<name>元素的名字和它的文本内容。
			System.out.println(elt.getName() + " : " + elt.getText());
		}
	}
	
	@Test
	public void testname() throws Exception
	{
		Document document = DocumentHelper.createDocument();
		
	       // ProcessingInstruction
//	       Map<String, String> inMap = new HashMap<String, String>();
//	       inMap.put("type", "text/xsl");
//	       inMap.put("href", "students.xsl");
//	       document.addProcessingInstruction("xml-stylesheet", inMap);
	       // root element
		
//		<REQUEST>
//		  <HEADER>
//		    <USERID>DOC_APP</USERID>
//		    <PASSWORD>123</PASSWORD>
//		    <TRANSNO>GET_DOC_HOS_SEARCH</TRANSNO>
//		  </HEADER>
//		  <BODY>
//		    <GET_DOC_HOS_SEARCH>
//		      <EMP_CODE>070807005</EMP_CODE>
//		      <PATIENT_KEY>肖纳</PATIENT_KEY>
//		      <SELECT_TYPE>1</SELECT_TYPE>
//		      <PAGE_SIZE>10</PAGE_SIZE>
//		      <PAGE_INDEX>0</PAGE_INDEX>
//		    </GET_DOC_HOS_SEARCH>
//		  </BODY>
//		</REQUEST>

		// REQUEST
	       Element REQUEST = document.addElement("REQUEST");
	       // HEADER
	       Element HEADER = REQUEST.addElement("HEADER");
	       Element nameElement = HEADER.addElement("USERID");
	       nameElement.setText("DOC_APP");
	       Element PASSWORD = HEADER.addElement("PASSWORD");
	       PASSWORD.setText("123");
	       Element TRANSNO = HEADER.addElement("TRANSNO");
	       TRANSNO.setText("GET_DOC_HOS_SEARCH");// 
	       
	       // BODY
	       Element BODY = REQUEST.addElement("BODY");
	       
	       Element requestForm = BODY.addElement("GET_DOC_HOS_SEARCH");// 
	       requestForm.addElement("EMP_CODE").setText("070807005");
	       requestForm.addElement("PATIENT_KEY").setText("肖纳");
	       requestForm.addElement("SELECT_TYPE").setText("1");
	       requestForm.addElement("PAGE_SIZE").setText("10");
	       requestForm.addElement("PAGE_INDEX").setText("0");
		
	       System.out.println(document.asXML());
	}
	
	@Test
	public void testname77() throws Exception
	{
		Object requstFormBean = new GET_DOC_HOS_PATIENT();
		String requestXml = IGPFUtils.buildRequestXml(requstFormBean);
		System.out.println(requestXml);
	}
}
