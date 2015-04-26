//package org.hibernate.entity;
//
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import org.hibernate.entity.base.BasePrivilege;
//
//@Entity
//@Table(name = "Privilege")
//public class Privilege extends BasePrivilege
//{
//	private Privilege parent;// 父级权限
//	
//	private Set<Privilege> children;// 子权限
//	
//	private Set<Role> roles;// 所属角色
//	
//	@Column(name="permission", length=20)
//	private String permission;// 权限标示
//	
//	@Column(name="description", length=50)
//	private String description;// 描述
//}
