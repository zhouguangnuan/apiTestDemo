package org.hibernate.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * YjkJyjgxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "YJK_jyjgxx", schema = "dbo", catalog = "digitlab")
public class YjkJyjgxx implements java.io.Serializable
{

	// Fields

	private String ybbh;
	private String jyxm;
	private String jyjg;
	private String xmdw;
	private String ckfw;
	private String jgts;
	private String jgts1;
	private String zhmc;
	private Integer xmsh;
	private Integer jgbs;

	// Constructors

	/** default constructor */
	public YjkJyjgxx()
	{
	}

	/** minimal constructor */
	public YjkJyjgxx(String ybbh, String jyjg, Integer jgbs)
	{
		this.ybbh = ybbh;
		this.jyjg = jyjg;
		this.jgbs = jgbs;
	}

	/** full constructor */
	public YjkJyjgxx(String ybbh, String jyxm, String jyjg, String xmdw,
			String ckfw, String jgts, String jgts1, String zhmc,
			Integer xmsh, Integer jgbs)
	{
		this.ybbh = ybbh;
		this.jyxm = jyxm;
		this.jyjg = jyjg;
		this.xmdw = xmdw;
		this.ckfw = ckfw;
		this.jgts = jgts;
		this.jgts1 = jgts1;
		this.zhmc = zhmc;
		this.xmsh = xmsh;
		this.jgbs = jgbs;
	}

	// Property accessors
	@Id
	@Column(name = "ybbh", length = 103)
	public String getYbbh()
	{
		return this.ybbh;
	}

	public void setYbbh(String ybbh)
	{
		this.ybbh = ybbh;
	}

	@Column(name = "jyxm", length = 80)
	public String getJyxm()
	{
		return this.jyxm;
	}

	public void setJyxm(String jyxm)
	{
		this.jyxm = jyxm;
	}

	@Column(name = "jyjg", nullable = false, length = 150)
	public String getJyjg()
	{
		return this.jyjg;
	}

	public void setJyjg(String jyjg)
	{
		this.jyjg = jyjg;
	}

	@Column(name = "xmdw", length = 10)
	public String getXmdw()
	{
		return this.xmdw;
	}

	public void setXmdw(String xmdw)
	{
		this.xmdw = xmdw;
	}

	@Column(name = "ckfw", length = 180)
	public String getCkfw()
	{
		return this.ckfw;
	}

	public void setCkfw(String ckfw)
	{
		this.ckfw = ckfw;
	}

	@Column(name = "jgts", length = 10)
	public String getJgts()
	{
		return this.jgts;
	}

	public void setJgts(String jgts)
	{
		this.jgts = jgts;
	}

	@Column(name = "jgts1", length = 4)
	public String getJgts1()
	{
		return this.jgts1;
	}

	public void setJgts1(String jgts1)
	{
		this.jgts1 = jgts1;
	}

	@Column(name = "zhmc", length = 80)
	public String getZhmc()
	{
		return this.zhmc;
	}

	public void setZhmc(String zhmc)
	{
		this.zhmc = zhmc;
	}

	@Column(name = "xmsh")
	public Integer getXmsh()
	{
		return this.xmsh;
	}

	public void setXmsh(Integer xmsh)
	{
		this.xmsh = xmsh;
	}

	@Column(name = "jgbs", nullable = false)
	public Integer getJgbs()
	{
		return this.jgbs;
	}

	public void setJgbs(Integer jgbs)
	{
		this.jgbs = jgbs;
	}

}