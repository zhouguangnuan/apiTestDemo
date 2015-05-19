/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：XmlTestBean.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午6:45:44</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * <p>名称：XmlTestBean.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午6:45:44
 * @version 1.0.0
 */
@XmlRootElement(name="XML_TEST_BEAN")
@XmlSeeAlso(Classroom.class)
public class XmlTestBean<T>
{
	private String str;
	
	private T obj;

	@XmlElement(name="STR")
	public String getStr()
	{
		return str;
	}

	public void setStr(String str)
	{
		this.str = str;
	}

	public T getObj()
	{
		return obj;
	}

	public void setObj(T obj)
	{
		this.obj = obj;
	}
}
