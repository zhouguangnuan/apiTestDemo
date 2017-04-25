/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：User.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-12-下午3:46:58</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import java.io.Serializable;

/**
 * <p>名称：User.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-12 下午3:46:58
 * @version 1.0.0
 */
public class User implements Serializable
{
	private static final long serialVersionUID = 1001881900957402607L;

	private Integer id;
	private String name;
	
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

	public void setId(Integer id)
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

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
