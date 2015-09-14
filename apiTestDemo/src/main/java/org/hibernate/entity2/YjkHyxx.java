package org.hibernate.entity2;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * YjkHyxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "YjkHyxx")
public class YjkHyxx implements java.io.Serializable
{

	// Fields

	private Long hyid;
	private Long pbid;
	private Short jzxh;
	private String jzsj;
	private Boolean yypb;
	private Long yyxh;
	private Long ghxh;
	private Long appid;
	private Date sdsj;

	// Constructors

	/** default constructor */
	public YjkHyxx()
	{
	}

	/** minimal constructor */
	public YjkHyxx(Long hyid, Long pbid)
	{
		this.hyid = hyid;
		this.pbid = pbid;
	}

	/** full constructor */
	public YjkHyxx(Long hyid, Long pbid, Short jzxh, String jzsj,
			Boolean yypb, Long yyxh, Long ghxh, Long appid,
			Date sdsj)
	{
		this.hyid = hyid;
		this.pbid = pbid;
		this.jzxh = jzxh;
		this.jzsj = jzsj;
		this.yypb = yypb;
		this.yyxh = yyxh;
		this.ghxh = ghxh;
		this.appid = appid;
		this.sdsj = sdsj;
	}

	// Property accessors
	@Id
	@Column(name = "HYID", nullable = false, precision = 18, scale = 0)
	public Long getHyid()
	{
		return this.hyid;
	}

	public void setHyid(Long hyid)
	{
		this.hyid = hyid;
	}

	@Column(name = "PBID", nullable = false, precision = 18, scale = 0)
	public Long getPbid()
	{
		return this.pbid;
	}

	public void setPbid(Long pbid)
	{
		this.pbid = pbid;
	}

	@Column(name = "JZXH", precision = 4, scale = 0)
	public Short getJzxh()
	{
		return this.jzxh;
	}

	public void setJzxh(Short jzxh)
	{
		this.jzxh = jzxh;
	}

	@Column(name = "JZSJ", length = 40)
	public String getJzsj()
	{
		return this.jzsj;
	}

	public void setJzsj(String jzsj)
	{
		this.jzsj = jzsj;
	}

	@Column(name = "YYPB", precision = 1, scale = 0)
	public Boolean getYypb()
	{
		return this.yypb;
	}

	public void setYypb(Boolean yypb)
	{
		this.yypb = yypb;
	}

	@Column(name = "YYXH", precision = 18, scale = 0)
	public Long getYyxh()
	{
		return this.yyxh;
	}

	public void setYyxh(Long yyxh)
	{
		this.yyxh = yyxh;
	}

	@Column(name = "GHXH", precision = 18, scale = 0)
	public Long getGhxh()
	{
		return this.ghxh;
	}

	public void setGhxh(Long ghxh)
	{
		this.ghxh = ghxh;
	}

	@Column(name = "APPID", precision = 18, scale = 0)
	public Long getAppid()
	{
		return this.appid;
	}

	public void setAppid(Long appid)
	{
		this.appid = appid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SDSJ", length = 7)
	public Date getSdsj()
	{
		return this.sdsj;
	}

	public void setSdsj(Date sdsj)
	{
		this.sdsj = sdsj;
	}

}