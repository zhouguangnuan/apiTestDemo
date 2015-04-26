package org.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.entity.base.BaseEntity;

@Entity
@Table(name="Student")
public class Student extends BaseEntity
{
	private String name;
	
	@ManyToMany(mappedBy="students")
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Teacher> getTeachers()
	{
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers)
	{
		this.teachers = teachers;
	}
}
