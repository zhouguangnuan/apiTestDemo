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
}
