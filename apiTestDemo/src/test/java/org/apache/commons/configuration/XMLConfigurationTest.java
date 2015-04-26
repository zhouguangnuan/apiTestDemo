package org.apache.commons.configuration;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

@SuppressWarnings("all")
public class XMLConfigurationTest
{
	private XMLConfiguration config;
	
	/**
	 * 描述：读取基本数据<br>
	 * <pre></pre>
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception
	{
		/** 
		    *<colors> 
		  *  <background>#808080</background> 
		  *  <text>#000000</text> 
		  *  <header>#008000</header> 
		  *  <link normal="#000080" visited="#800080"/> 
		  *  <default>${colors.header}</default> 
		  *</colors> 
		    *这是从上面的xml中摘抄的一段，我们现在来解析它， 
		    *colors是根标签下的直接子标签，所以是顶级名字空间 
		    */  
		config = new XMLConfiguration("XMLtest.xml");
		String backColor = config.getString("colors.background");  
		String textColor = config.getString("colors.text");  
		//现在我们知道了如何读取标签下的数据，那么如何读标签中的属性呢？看下面  
		//<link normal="#000080" visited="#800080"/>  
		String linkNormal = config.getString("colors.link[@normal]");  
		//还支持引用呢！  
		//<default>${colors.header}</default>  
		String defColor = config.getString("colors.default");  
		//也支持其他类型，但是一定要确定类型正确，否则要报异常哦  
		//<rowsPerPage>15</rowsPerPage>  
		int rowsPerPage = config.getInt("rowsPerPage");  
		System.out.println();
	}
	
	/**
	 * 描述：读取list<br>
	 * <pre></pre>
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception
	{
		/**
		 * 但是我们如何读取List呢 看这里: <buttons> <name>OK,Cancel,Help</name>
		 * <name>Yes,No,Cancel</name> </buttons>
		 */
		// 这时我们可以用：
		config = new XMLConfiguration("XMLtest.xml");
		List<Object> buttons = config.getList("buttons.name");
		for (Object button : buttons)
		{
			System.out.println(button);
		}
		
		System.out.println(config.getBasePath());
		System.out.println(config.getRootElementName());
	}
	
	/**
	 * 描述：配置分隔符<br>
	 * <pre></pre>
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception
	{
		config = new XMLConfiguration();  
        config.setDelimiterParsingDisabled(true);  
        config.setFileName("XMLtest.xml");  
        config.load();  
        List<Object> buttons = config.getList("buttons.name");  
        for(Object button: buttons){  
            System.out.println(button);  
        }  
	}
	
	@Test
	public void test4() throws Exception
	{
		config = new XMLConfiguration();
        config.setDelimiterParsingDisabled(true);  
        config.setFileName("XMLtest2.xml");  
        config.load();  
        Object prop = config.getProperty("tables.table.name");  
        if(prop instanceof Collection)  
        {  
            System.out.println("Number of tables: " + ((Collection) prop).size());  
        }  
      //return users  
        System.out.println(config.getProperty("tables.table(0).name"));  
        //return system  
        System.out.println(config.getProperty("tables.table(0)[@tableType]"));  
        //return documents  
        System.out.println(config.getProperty("tables.table(1).name"));  
        //return null,因为只有两个table所以这个值为null  
        System.out.println(config.getProperty("tables.table(2).name"));  
        //return [docid, name, creationDate, authorID, version]  
        //如果所要找的节点不存在唯一值，则返回Collection类型  
        System.out.println(config.getProperty("tables.table(1).fields.field.name"));  
        //[long, long]  
        //与上面的相同，返回值不唯一  
        System.out.println(config.getProperty("tables.table.fields.field(0).type"));  
        //return creationDate  
        System.out.println(config.getProperty("tables.table(1).fields.field(2).name"));  
	}
}
