package org.hibernate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.entity.base.BaseUser;

@Entity
@Table(name = "User")
public class User extends BaseUser
{
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="departmentId")// 设置外键列名
	private Department department;
	
//	private Set<Role> roles;
	
	@Column(name = "age", length = 3)
	private Integer age;// 年龄
	
	@Column(name="gender", length=1)
	private String gender; // 性别
	
	@Column(name="phoneNumber", length=13)
	private String phoneNumber;// 手机号码
	
	@Column(name="email", length=50)
	private String email;// 邮箱
	
	@Column(name="description", length=50)
	private String description;// 描述
	
	@Column(name="createTime")
	private Date createTime;

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
}
