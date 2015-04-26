package org.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.entity.base.BaseEntity;

@Entity
public class Husband extends BaseEntity
{
	private String husbandName;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="wifeId")
	private Wife wife;

	public String getHusbandName()
	{
		return husbandName;
	}

	public void setHusbandName(String husbandName)
	{
		this.husbandName = husbandName;
	}

	public Wife getWife()
	{
		return wife;
	}

	public void setWife(Wife wife)
	{
		this.wife = wife;
	}
}
