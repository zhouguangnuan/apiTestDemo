package org.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.entity.base.BaseEntity;

@Entity
@Table(name="Wife")
public class Wife extends BaseEntity
{
	private String name;
	
	@OneToOne(mappedBy="wife")
	private Husband husband;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Husband getHusband()
	{
		return husband;
	}

	public void setHusband(Husband husband)
	{
		this.husband = husband;
	}
}
