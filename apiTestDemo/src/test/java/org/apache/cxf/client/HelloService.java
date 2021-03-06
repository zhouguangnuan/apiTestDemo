package org.apache.cxf.client;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.bean.User;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://service.cxf.apache.org/")
public interface HelloService
{

	/**
	 * 
	 * @param arg0
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "sayHi", targetNamespace = "http://service.cxf.apache.org/", className = "org.apache.cxf.client.SayHi")
	@ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://service.cxf.apache.org/", className = "org.apache.cxf.client.SayHiResponse")
	public String sayHi(
			@WebParam(name = "arg0", targetNamespace = "") String arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getUser", targetNamespace = "http://service.cxf.apache.org/", className = "org.apache.cxf.client.GetUser")
	@ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://service.cxf.apache.org/", className = "org.apache.cxf.client.GetUserResponse")
	public String getUser(
			@WebParam(name = "arg0", targetNamespace = "") User arg0);

	/**
	 * 
	 * @return returns java.util.List<org.apache.cxf.client.User>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getListUser", targetNamespace = "http://service.cxf.apache.org/", className = "org.apache.cxf.client.GetListUser")
	@ResponseWrapper(localName = "getListUserResponse", targetNamespace = "http://service.cxf.apache.org/", className = "org.apache.cxf.client.GetListUserResponse")
	public List<User> getListUser();

}
