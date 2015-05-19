/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：IpfMethod.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午3:30:40</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;



/**
 * <p>名称：IpfMethod.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午3:30:40
 * @version 1.0.0
 */
@XmlSeeAlso(value=GET_DOC_HOS_PATIENT.class)
@XmlRootElement
public class IpfBody<T>
{
	private T ipfMethod;

	public IpfBody()
	{
		super();
	}

	public IpfBody(T ipfMethod)
	{
		super();
		this.ipfMethod = ipfMethod;
	}

	@XmlElement(name="DEFAULT")
	public T getIpfMethod()
	{
		return ipfMethod;
	}

	public void setIpfMethod(T ipfMethod)
	{
		this.ipfMethod = ipfMethod;
	}
}
