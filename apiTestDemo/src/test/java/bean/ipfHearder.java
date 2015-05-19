/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：ipfHearder.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午3:29:33</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>名称：ipfHearder.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午3:29:33
 * @version 1.0.0
 */
public class ipfHearder
{
	private String userId;// 接口授权账号Id
	private String password;// 接口授权账号密码
	private String transno;// 接口方法名
	
	public ipfHearder()
	{
		super();
	}

	public ipfHearder(String userId, String password, String transno)
	{
		super();
		this.userId = userId;
		this.password = password;
		this.transno = transno;
	}

	@XmlElement(name="USERID")
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	@XmlElement(name="PASSWORD")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@XmlElement(name="TRANSNO")
	public String getTransno()
	{
		return transno;
	}

	public void setTransno(String transno)
	{
		this.transno = transno;
	}
}
