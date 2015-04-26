package org.hibernate.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public abstract class BaseUser  extends BaseEntity
{
	@Column(name = "userName", nullable = false, length = 50)
	private String userName;// 用户名

	@Column(name = "password", nullable = false, length = 32)
	private String password;// 用户密码
	
	@Column(name = "salt", nullable = false, length = 50)
	private String salt;// 密码盐值

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}
}
