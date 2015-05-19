/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：IpfRequest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午3:28:15</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>名称：IpfRequest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午3:28:15
 * @version 1.0.0
 */
@SuppressWarnings("all")
@XmlRootElement(name="REQUEST")
public class IpfRequest
{
	private ipfHearder hearder;
	
	private IpfBody body;

	public IpfRequest()
	{
		super();
	}
	
	public IpfRequest(String methodName, IpfBody body)
	{
		super();
		this.hearder = new ipfHearder();
		this.hearder.setUserId("DOC_APP");
		this.hearder.setPassword("123");
		this.hearder.setTransno(methodName);
		this.body = body;
	}

	@XmlElement(name="HEADER")
	public ipfHearder getHearder()
	{
		return hearder;
	}

	public void setHearder(ipfHearder hearder)
	{
		this.hearder = hearder;
	}

	@XmlElement(name="BODY")
	public IpfBody getBody()
	{
		return body;
	}

	public void setBody(IpfBody body)
	{
		this.body = body;
	}
}
