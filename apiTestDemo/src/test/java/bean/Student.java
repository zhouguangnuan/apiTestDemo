/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：Student.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午2:50:02</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>名称：Student.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午2:50:02
 * @version 1.0.0
 */
@XmlRootElement  
public class Student
{
	private int id;
	private String name;
	private int age;
	private Classroom classroom;
	private List<Classroom> classrooms;
	
	Map<String, Object> map;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Classroom getClassroom()
	{
		return classroom;
	}

	public void setClassroom(Classroom classroom)
	{
		this.classroom = classroom;
	}

	public Student(int id, String name, int age, Classroom classroom)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.classroom = classroom;
	}

	public List<Classroom> getClassrooms()
	{
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms)
	{
		this.classrooms = classrooms;
	}

	public Map<String, Object> getMap()
	{
		return map;
	}

	public void setMap(Map<String, Object> map)
	{
		this.map = map;
	}

	// 无参够着函数一定需要，否则JXBContext无法正常解析。
	public Student()
	{
		super();
	}
}
