package org.hibernate.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public abstract class BaseRole  extends BaseEntity
{
	@Column(name = "roleName", nullable = false, length = 50)
	private String roleName;

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
}
