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
public class GET_DOC_HOS_PATIENT
{
	private String myid;
	private Integer chxjb;
	private Integer pageSize;
	private Integer startIndex;
	
	public GET_DOC_HOS_PATIENT()
	{
		super();
	}
	
	@XmlElement(name="EMP_CODE")
	public String getMyid()
	{
		return myid;
	}
	public void setMyid(String myid)
	{
		this.myid = myid;
	}
	@XmlElement(name="SELECT_TYPE")
	public Integer getChxjb()
	{
		return chxjb;
	}
	public void setChxjb(Integer chxjb)
	{
		this.chxjb = chxjb;
	}
	@XmlElement(name="PAGE_SIZE")
	public Integer getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}
	@XmlElement(name="PAGE_INDEX")
	public Integer getStartIndex()
	{
		return startIndex;
	}
	public void setStartIndex(Integer startIndex)
	{
		this.startIndex = startIndex;
	}
}
