package org.hibernate.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public abstract class BaseDepartment  extends BaseEntity
{
	@Column(name = "departmentName", nullable = false, length = 50)
	private String departmentName;// 部门名称

	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
}
