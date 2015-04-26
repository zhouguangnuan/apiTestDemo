package org.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.entity.base.BaseEntity;

@Entity
@Table(name="Teacher")
public class Teacher extends BaseEntity
{
	private String name;
	
	@ManyToMany
	@JoinTable(name="Teacher_Student",
		joinColumns={@JoinColumn(name="teacher_id")},
		inverseJoinColumns={@JoinColumn(name="student_id")}
	)
	private Set<Student> students = new HashSet<Student>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Student> getStudents()
	{
		return students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}
}
