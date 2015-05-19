/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：Customer.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午7:32:17</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>名称：Customer.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午7:32:17
 * @version 1.0.0
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.PROPERTY)
public class Customer<T>
{
	String name;
	int age;
	int id;
	T t;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + id + ",name=" + name + ",age=" + age
				+ ",t=" + t + "]";
	}

	public T getT()
	{
		return t;
	}

	public void setT(T t)
	{
		this.t = t;
	}
}