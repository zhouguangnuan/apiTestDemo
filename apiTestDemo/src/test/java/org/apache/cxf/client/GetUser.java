package org.apache.cxf.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.cxf.bean.User;

/**
 * <p>
 * Java class for getUser complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.cxf.apache.org/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUser", propOrder =
{ "arg0" })
public class GetUser
{

	protected User arg0;

	/**
	 * Gets the value of the arg0 property.
	 * 
	 * @return possible object is {@link User }
	 * 
	 */
	public User getArg0()
	{
		return arg0;
	}

	/**
	 * Sets the value of the arg0 property.
	 * 
	 * @param value
	 *                allowed object is {@link User }
	 * 
	 */
	public void setArg0(User value)
	{
		this.arg0 = value;
	}

}
