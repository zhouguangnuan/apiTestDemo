package org.hibernate.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_user", catalog = "test_hibernate")
public class VUser implements java.io.Serializable
{

	// Fields

	private String refrenceId;
	private String userName;
	private Integer age;

	// Constructors

	/** default constructor */
	public VUser()
	{
	}

	/** minimal constructor */
	public VUser(String refrenceId, String userName)
	{
		this.refrenceId = refrenceId;
		this.userName = userName;
	}

	/** full constructor */
	public VUser(String refrenceId, String userName, Integer age)
	{
		this.refrenceId = refrenceId;
		this.userName = userName;
		this.age = age;
	}

	// Property accessors
	@Id
	@Column(name = "refrenceId", nullable = false, length = 32)
	public String getRefrenceId()
	{
		return this.refrenceId;
	}

	public void setRefrenceId(String refrenceId)
	{
		this.refrenceId = refrenceId;
	}

	@Column(name = "userName", nullable = false, length = 50)
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name = "age")
	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

}