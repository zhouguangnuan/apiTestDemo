//package org.hibernate.entity;
//
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import org.hibernate.entity.base.BaseRole;
//
//@Entity
//@Table(name = "Role")
//public class Role extends BaseRole
//{
//	private Set<User> users;// 所属用户
//	
//	private Set<Privilege> privileges;// 权限组
//	
//	@Column(name="description", length=50)
//	private String description;// 描述
//
//	public Set<User> getUsers()
//	{
//		return users;
//	}
//
//	public void setUsers(Set<User> users)
//	{
//		this.users = users;
//	}
//
//	public Set<Privilege> getPrivileges()
//	{
//		return privileges;
//	}
//
//	public void setPrivileges(Set<Privilege> privileges)
//	{
//		this.privileges = privileges;
//	}
//
//	public String getDescription()
//	{
//		return description;
//	}
//
//	public void setDescription(String description)
//	{
//		this.description = description;
//	}
//}
