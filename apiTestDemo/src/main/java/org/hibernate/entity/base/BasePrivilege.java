package org.hibernate.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public abstract class BasePrivilege  extends BaseEntity
{
	@Column(name = "privilegeName", nullable = false, length = 50)
	private String privilegeName;// 权限名称

	public String getPrivilegeName()
	{
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName)
	{
		this.privilegeName = privilegeName;
	}
}
