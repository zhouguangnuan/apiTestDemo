/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：Book.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午7:32:41</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * <p>名称：Book.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午7:32:41
 * @version 1.0.0
 */
public class Book
{

	private String id;
	private String name;
	private float price;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Book [id=" + id + ",name=" + name + ",price=" + price
				+ "]";
	}
}