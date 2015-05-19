/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：Classroom.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午2:49:40</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * <p>名称：Classroom.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午2:49:41
 * @version 1.0.0
 */
public class Classroom
{
	private int id;  
	    private String name;  
	    private int grade;  
	  
	    public int getId() {  
	        return id;  
	    }  
	  
	    public void setId(int id) {  
	        this.id = id;  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public int getGrade() {  
	        return grade;  
	    }  
	  
	    public void setGrade(int grade) {  
	        this.grade = grade;  
	    }  
	  
	    public Classroom(int id, String name, int grade) {  
	        super();  
	        this.id = id;  
	        this.name = name;  
	        this.grade = grade;  
	    }  
	  
	    public Classroom() {  
	        super();  
	    }  
}
