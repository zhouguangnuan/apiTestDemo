package org.apache.cxf.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.apache.cxf.bean.User;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the org.apache.cxf.client package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory
{

	private final static QName _GetListUser_QNAME = new QName(
			"http://service.cxf.apache.org/", "getListUser");
	private final static QName _SayHi_QNAME = new QName(
			"http://service.cxf.apache.org/", "sayHi");
	private final static QName _GetUserResponse_QNAME = new QName(
			"http://service.cxf.apache.org/", "getUserResponse");
	private final static QName _GetUser_QNAME = new QName(
			"http://service.cxf.apache.org/", "getUser");
	private final static QName _GetListUserResponse_QNAME = new QName(
			"http://service.cxf.apache.org/", "getListUserResponse");
	private final static QName _SayHiResponse_QNAME = new QName(
			"http://service.cxf.apache.org/", "sayHiResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances
	 * of schema derived classes for package: org.apache.cxf.client
	 * 
	 */
	public ObjectFactory()
	{
	}

	/**
	 * Create an instance of {@link SayHiResponse }
	 * 
	 */
	public SayHiResponse createSayHiResponse()
	{
		return new SayHiResponse();
	}

	/**
	 * Create an instance of {@link GetListUserResponse }
	 * 
	 */
	public GetListUserResponse createGetListUserResponse()
	{
		return new GetListUserResponse();
	}

	/**
	 * Create an instance of {@link GetUser }
	 * 
	 */
	public GetUser createGetUser()
	{
		return new GetUser();
	}

	/**
	 * Create an instance of {@link GetListUser }
	 * 
	 */
	public GetListUser createGetListUser()
	{
		return new GetListUser();
	}

	/**
	 * Create an instance of {@link GetUserResponse }
	 * 
	 */
	public GetUserResponse createGetUserResponse()
	{
		return new GetUserResponse();
	}

	/**
	 * Create an instance of {@link User }
	 * 
	 */
	public User createUser()
	{
		return new User();
	}

	/**
	 * Create an instance of {@link SayHi }
	 * 
	 */
	public SayHi createSayHi()
	{
		return new SayHi();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetListUser }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://service.cxf.apache.org/", name = "getListUser")
	public JAXBElement<GetListUser> createGetListUser(GetListUser value)
	{
		return new JAXBElement<GetListUser>(_GetListUser_QNAME,
				GetListUser.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://service.cxf.apache.org/", name = "sayHi")
	public JAXBElement<SayHi> createSayHi(SayHi value)
	{
		return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetUserResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://service.cxf.apache.org/", name = "getUserResponse")
	public JAXBElement<GetUserResponse> createGetUserResponse(
			GetUserResponse value)
	{
		return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME,
				GetUserResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://service.cxf.apache.org/", name = "getUser")
	public JAXBElement<GetUser> createGetUser(GetUser value)
	{
		return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetListUserResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://service.cxf.apache.org/", name = "getListUserResponse")
	public JAXBElement<GetListUserResponse> createGetListUserResponse(
			GetListUserResponse value)
	{
		return new JAXBElement<GetListUserResponse>(
				_GetListUserResponse_QNAME,
				GetListUserResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SayHiResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://service.cxf.apache.org/", name = "sayHiResponse")
	public JAXBElement<SayHiResponse> createSayHiResponse(
			SayHiResponse value)
	{
		return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME,
				SayHiResponse.class, null, value);
	}

}
