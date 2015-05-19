
package org.apache.cxf.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "id",
    "name"
})
public class User
{

	protected Integer id;
	protected String name;

	public User()
	{
		super();
	}

	public User(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer value)
	{
		this.id = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String value)
	{
		this.name = value;
	}

}
