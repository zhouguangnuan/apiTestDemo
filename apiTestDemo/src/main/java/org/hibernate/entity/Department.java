package org.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.entity.base.BaseDepartment;

@Entity
@Table(name = "Department")
public class Department extends BaseDepartment
{
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="parentId")
	private Department parent;// 父级部门
	
	@OneToMany(mappedBy="parent")
	private Set<Department> children;// 子部门
	
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private Set<User> users;// 拥有用户
	
	@Column(name="description", length=50)
	private String description;// 描述

	public Set<User> getUsers()
	{
		return users;
	}

	public void setUsers(Set<User> users)
	{
		this.users = users;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Department getParent()
	{
		return parent;
	}

	public void setParent(Department parent)
	{
		this.parent = parent;
	}

	public Set<Department> getChildren()
	{
		return children;
	}

	public void setChildren(Set<Department> children)
	{
		this.children = children;
	}
}
