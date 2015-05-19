/**
 * <p>项目名：Mzyy</p>
 * <p>包名：com.rzhy.utils</p>
 * <p>文件名：.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-12-上午9:06:52</p>
 * Copyright (c) 2015aux公司-版权所有
 */
package com.rzhy.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.rzhy.model.IntegrationPf.IPFRequest;
import com.rzhy.model.IntegrationPf.IPFRequestBody;
import com.rzhy.model.IntegrationPf.IPFResponseBody;
import com.rzhy.model.IntegrationPf.request.GET_DOC_HOS_PATIENT;
import com.rzhy.model.IntegrationPf.response.PatientInfoModel;

/**
 * <p>名称：.java</p>
 * <p>描述：集成平台接口调用工具类</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-12 上午9:06:52
 * @version 1.0.0
 */
@SuppressWarnings("all")
public class IntegrationPfUtils
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(IntegrationPfUtils.class);
	
	// 缓存加载器加载的calss对象
	private static final Map<String, Class<?>> boyClassMap = new ConcurrentHashMap<String, Class<?>>();
	
	private static final String uri = "http://10.8.200.159:801/Services.asmx/Submit";
	
	@Test
	public void testname222222() throws Exception
	{
		String fileName = "C:\\Users\\Administrator\\Desktop\\22.xml";
		SAXReader saxReader = new SAXReader();
	           Document document = saxReader.read(fileName);
	           List list = document.selectNodes("//RESPONSE/BODY");
	           Iterator iter = list.iterator();
	           while (iter.hasNext()) {
	              Object ob = iter.next();
	              System.out.println(JSON.toJSONString(ob));
	           }
	}
	
	@Test
	public void testname22() throws Exception
	{
		GET_DOC_HOS_PATIENT form = new GET_DOC_HOS_PATIENT();
		form.setChxjb(1);
		form.setMyid("070807005");
		form.setPageSize(10);
		form.setStartIndex(1);
		
		String resultBody = IntegrationPfUtils.getResult(form);
//		resultBody = XmlUtils.formatXml(resultBody, "UTF-8", true);
		System.out.println(resultBody);
		
		SAXReader saxReader = new SAXReader();
		StringReader sr = new StringReader(resultBody);
		 Document doc = saxReader.read(sr);
	           
	           List list = doc.selectNodes("//RESPONSE/BODY");
	           Iterator iter = list.iterator();
	           while (iter.hasNext()) {
	              Object ob = iter.next();
	              System.out.println(JSON.toJSONString(ob));
	           }
		
		list = doc.selectNodes("//RESPONSE/BODY");
//	           Iterator iter = list.iterator();
	           while (iter.hasNext()) {
	              Attribute attribute = (Attribute) iter.next();
	              if (attribute.getValue().equals("01"))
	                  attribute.setValue("001");
	           }
	 
	           list = doc.selectNodes("//students/student");
	           iter = list.iterator();
	           while (iter.hasNext()) {
	              Element element = (Element) iter.next();
	              Iterator iterator = element.elementIterator("name");
	              while (iterator.hasNext()) {
	                  Element nameElement = (Element) iterator.next();
	                  if (nameElement.getText().equals("sam"))
	                     nameElement.setText("jeff");
	              }
	           }
	}
	
	@Test
	public void testname2222() throws Exception
	{
//		String resultBody = "<?xml version='1.0' encoding='utf-8'?><RESPONSE>  <HEADER>    <RET_CODE>0</RET_CODE>    <RET_INFO>成功</RET_INFO>  </HEADER>  <BODY>    <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>12</RN>        <NAME>李洁(B)</NAME>        <ID>00067583</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0842B</BEDNUMBER>        <ENTERTIME>2012-10-19 00:28</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67994</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-19 00:28</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>13</RN>        <NAME>李世超(B)</NAME>        <ID>00067600</ID>        <SEX>2</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0851B</BEDNUMBER>        <ENTERTIME>2012-10-19 08:47</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68011</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-19 08:47</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>14</RN>        <NAME>李英(B)</NAME>        <ID>00067592</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>08A04B</BEDNUMBER>        <ENTERTIME>2012-10-19 05:42</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68003</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-19 05:42</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>15</RN>        <NAME>李永曼(B)</NAME>        <ID>00067799</ID>        <SEX>2</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0624B</BEDNUMBER>        <ENTERTIME>2012-10-21 16:49</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>932</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68212</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-21 16:49</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>16</RN>        <NAME>李月(B)</NAME>        <ID>00067662</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0817B</BEDNUMBER>        <ENTERTIME>2012-10-19 19:18</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>934</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68073</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-19 19:18</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>17</RN>        <NAME>刘加利(B)</NAME>        <ID>00067877</ID>        <SEX>2</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0838B</BEDNUMBER>        <ENTERTIME>2012-10-22 12:42</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>931</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68290</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-22 12:42</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>18</RN>        <NAME>刘雪梅(B)</NAME>        <ID>00067677</ID>        <SEX>2</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0525B</BEDNUMBER>        <ENTERTIME>2012-10-20 01:15</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>934</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68088</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-20 01:15</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>19</RN>        <NAME>卢叶婷(B)</NAME>        <ID>00067890</ID>        <SEX>2</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0512</BEDNUMBER>        <ENTERTIME>2012-10-22 14:42</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>931</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68303</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-22 14:42</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>20</RN>        <NAME>吕艳丽(B)</NAME>        <ID>00067654</ID>        <SEX>2</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0839B</BEDNUMBER>        <ENTERTIME>2012-10-19 17:49</ENTERTIME>        <NURSINGLEVELS/>        <HOSPITALDAY>934</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>新生儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>68065</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-19 17:49</DIAGNOSETIME>        <DIAGNOSERESULT/>     </PERSON_INFOR>      <PCOUNT>6</PCOUNT>    <PRCOUNT>53</PRCOUNT>  </BODY></RESPONSE>";
//		String resultBody = "<?xml version='1.0' encoding='utf-8'?><BODY>   <PERSON_INFOR>     <RN>11</RN>      <NAME>黄松</NAME>      <ID>00067551</ID>      <SEX>1</SEX>      <URLPHOTO/>      <AGE>2岁6月</AGE>      <BEDNUMBER>0713</BEDNUMBER>      <ENTERTIME>2012-10-18 11:53</ENTERTIME>      <NURSINGLEVELS>1</NURSINGLEVELS>      <HOSPITALDAY>935</HOSPITALDAY>      <BEDDOCTOR/>      <MAINDOCTOR>宁武云</MAINDOCTOR>      <DEPARTMENTS>儿科</DEPARTMENTS>      <OPERATION/>      <HOSPITALNUMBER>67962</HOSPITALNUMBER>      <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>      <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>   </PERSON_INFOR>    <PCOUNT>6</PCOUNT>    <PRCOUNT>53</PRCOUNT> </BODY>";
//		String resultBody = "<?xml version='1.0' encoding='utf-8'?><BODY>  <AGE>2岁6月</AGE>  <BEDNUMBER>0713</BEDNUMBER>  <ENTERTIME>2012-10-18 11:53</ENTERTIME>  <HOSPITALDAY>925</HOSPITALDAY>  <ID>00067551</ID>  <NAME>黄松</NAME>  <NURSINGLEVELS>1</NURSINGLEVELS>  <SEX>1</SEX></BODY>";
//		String resultBody = " <BODY>      <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>   </BODY>";
//		String resultBody = "<BODY>    <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>     <PCOUNT>6</PCOUNT>    <PRCOUNT>53</PRCOUNT>  </BODY>";
//		String resultBody = "<BODY>    <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PCOUNT>6</PCOUNT>    <PRCOUNT>53</PRCOUNT>  </BODY>";
		String resultBody = "<RESPONSE>  <HEADER>    <RET_CODE>0</RET_CODE>    <RET_INFO>成功</RET_INFO>  </HEADER>  <BODY>    <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>      <PERSON_INFOR>       <RN>11</RN>        <NAME>黄松</NAME>        <ID>00067551</ID>        <SEX>1</SEX>        <URLPHOTO/>        <AGE>2岁6月</AGE>        <BEDNUMBER>0713</BEDNUMBER>        <ENTERTIME>2012-10-18 11:53</ENTERTIME>        <NURSINGLEVELS>1</NURSINGLEVELS>        <HOSPITALDAY>935</HOSPITALDAY>        <BEDDOCTOR/>        <MAINDOCTOR>宁武云</MAINDOCTOR>        <DEPARTMENTS>儿科</DEPARTMENTS>        <OPERATION/>        <HOSPITALNUMBER>67962</HOSPITALNUMBER>        <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>        <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT>     </PERSON_INFOR>     <PCOUNT>6</PCOUNT>    <PRCOUNT>53</PRCOUNT>  </BODY></RESPONSE>";
		
//		PatientInfoModel patientInfoModel = new PatientInfoModel();
//		patientInfoModel.setId("00067551");
//		patientInfoModel.setBedNumber("0713");
//		patientInfoModel.setEnterTime("2012-10-18 11:53");
//		patientInfoModel.setHospitalDay(925);
//		patientInfoModel.setName("黄松");
//		patientInfoModel.setNursingLevels(1);
//		patientInfoModel.setSex(1);
//		patientInfoModel.setAge("2岁6月");
//		
//		JAXBContext context = JAXBContext.newInstance(PatientInfoModel.class);  
//	            Marshaller marshaller = context.createMarshaller();  
//	            marshaller.marshal(patientInfoModel, System.out);  
		
//		<BODY> 
//		  <PERSON_INFOR> 
//		    <RN>11</RN>  
//		    <NAME>黄松</NAME>  
//		    <SEX>1</SEX>  
//		    <URLPHOTO/>  
//		    <ENTERTIME>2012-10-18 11:53</ENTERTIME>  
//		    <NURSINGLEVELS>1</NURSINGLEVELS>  
//		    <HOSPITALDAY>935</HOSPITALDAY>  
//		    <BEDDOCTOR/>  
//		    <MAINDOCTOR>宁武云</MAINDOCTOR>  
//		    <DEPARTMENTS>儿科</DEPARTMENTS>  
//		    <OPERATION/>  
//		    <HOSPITALNUMBER>67962</HOSPITALNUMBER>  
//		    <DIAGNOSETIME>2012-10-18 11:53</DIAGNOSETIME>  
//		    <DIAGNOSERESULT>新生儿黄疸 NOS,黄疸 NOS</DIAGNOSERESULT> 
//		  </PERSON_INFOR>  
//		  <PCOUNT>6</PCOUNT>  
//		  <PRCOUNT>53</PRCOUNT> 
//		</BODY>

		Class<?> clazz = getIPFResponseBodyClazz(PatientInfoModel.class);

		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		IPFResponseBody body = (IPFResponseBody) unmarshaller.unmarshal(new StringReader(resultBody));
		System.out.println(JSON.toJSONString(body));
	}
	
//	public static IPFResponseBody getIPFResponseBody(String bodyXmlStr, Class<?> listBeanClass)
//	{
//		return null;
//	}
	
	public static String getResult(Object form) throws InstantiationException, IllegalAccessException
	{
		Class<?> iPFRequestBody = getIPFRequestBodyClazz(form);
 
		IPFRequestBody body = (IPFRequestBody) iPFRequestBody.newInstance();
		body.setFormOrResult(form);
		IPFRequest iPFRequest = new IPFRequest(body);
		
		ByteArrayOutputStream byteArrayOutputStream = null;
		String resultBody = null;
		try
		{
			JAXBContext context = JAXBContext.newInstance(IPFRequest.class);
			Marshaller marshaller = context.createMarshaller();
			
			byteArrayOutputStream = new ByteArrayOutputStream();
			marshaller.marshal(iPFRequest, byteArrayOutputStream);
			String XmlString = byteArrayOutputStream.toString();
			
			Map<String, String> params = ImmutableMap.of("XmlString", XmlString);
			resultBody = HttpUtils.post(uri, params);
			byteArrayOutputStream.close();
		} 
		catch (Exception e)
		{
			logger.error("集成平台接口调用失败", e);
		}
		return resultBody;
	}
	
	@Test
	public void testname() throws Exception
	{
		GET_DOC_HOS_PATIENT bean = new GET_DOC_HOS_PATIENT();
		bean.setChxjb(1);
		bean.setChxjb(1);
		Map<String, String> paramsMap = BeanUtils.describe(bean);
		System.out.println(JSON.toJSONString(paramsMap));
	}
	
	
	 
	
	private static Class<?> getIPFRequestBodyClazz(Object formOrResult)
	{
		Class<?> c = null;
		if (null==formOrResult) return c;
		try
		{
			String formOrResultClassName = formOrResult.getClass().getName();
			String formOrResultSimpleClassName = formOrResult.getClass().getSimpleName();
			String bodyClassName = "com.rzhy.common.IPFRequestBody";
			
			ClassPool classPool = ClassPool.getDefault();
			classPool.appendClassPath(new ClassClassPath(IntegrationPfUtils.class));
			CtClass clazz = classPool.get(bodyClassName);
			clazz.defrost(); //对已经冻结的class解冻之后还可以继续编辑修改  
			 
			ClassFile classFile = clazz.getClassFile();
			ConstPool classFileCP = classFile.getConstPool();
			
			Annotation xmlSeeAlso = new Annotation("javax.xml.bind.annotation.XmlSeeAlso", classFileCP);
			ArrayMemberValue arrayMemberValue = new ArrayMemberValue(new ClassMemberValue(formOrResultClassName, classFileCP), classFileCP);
			MemberValue[] memberValue = new MemberValue[]{new ClassMemberValue(formOrResultClassName, classFileCP)};
			arrayMemberValue.setValue(memberValue);
			xmlSeeAlso.addMemberValue("value", arrayMemberValue);
			Annotation xmlRootElement = new Annotation("javax.xml.bind.annotation.XmlRootElement", classFileCP);
			xmlRootElement.addMemberValue("name", new StringMemberValue("BODY", classFileCP));
			AnnotationsAttribute tableAttribute = new AnnotationsAttribute(classFileCP, AnnotationsAttribute.visibleTag);
			tableAttribute.addAnnotation(xmlSeeAlso);
			tableAttribute.addAnnotation(xmlRootElement);
			classFile.addAttribute(tableAttribute);
//			classFile.setVersionToJava5();
			
			MethodInfo methodInfo = null;
			CtMethod[] ctMethods = clazz.getMethods();
			for (CtMethod ctMethod : ctMethods)
			{
				if ("setFormOrResult".equals(ctMethod.getName()))
				{
					methodInfo = ctMethod.getMethodInfo();
					break;
				}
			}
			if (null != methodInfo)
			{
				ConstPool methodCP = methodInfo.getConstPool();
				Annotation xmlElement = new Annotation("javax.xml.bind.annotation.XmlElement", methodCP);  
				xmlElement.addMemberValue("name", new StringMemberValue(formOrResultSimpleClassName, methodCP));
				AnnotationsAttribute methodAttribute = new AnnotationsAttribute(methodCP, AnnotationsAttribute.visibleTag);
				methodAttribute.setAnnotation(xmlElement);
				methodInfo.addAttribute(methodAttribute);
			}
			
//			 clazz.writeFile();

//			AnnotationClassLoader loader = new AnnotationClassLoader(ClassUtils.class.getClassLoader());
			// 加载器加载class文件，一个加载器只会加载一次路径名称相同的calss
			// 这里因为只改了注解，类路径是没有改变的。
			
			c = clazz.toClass(IntegrationPfUtils.class.getClassLoader(), null);
//			if (null != c)
//			{
//				classPoolMap.put(annotationVal, c);
//			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	private static Class<?> getIPFResponseBodyClazz(Class<?> listBeanClass)
	{
		Class<?> c = null;
		if (null==listBeanClass) return c;
		try
		{
			String bodyClassName = "com.rzhy.common.IPFResponseBody";
			
			ClassPool classPool = ClassPool.getDefault();
			classPool.appendClassPath(new ClassClassPath(listBeanClass));
			
			CtClass listBeanClazz = classPool.get(listBeanClass.getName());
			ClassFile classFile = listBeanClazz.getClassFile();
			ConstPool classFileCP = classFile.getConstPool();
			
			AnnotationsAttribute attribute = (AnnotationsAttribute)classFile.getAttribute(AnnotationsAttribute.visibleTag);
			Annotation annotation = attribute.getAnnotation("javax.xml.bind.annotation.XmlRootElement");
			MemberValue memberValue = annotation.getMemberValue("name");
			String listName = StringUtils.remove(memberValue.toString(), "\"");
			
			
			CtClass clazz = classPool.get(bodyClassName);
			clazz.defrost(); //对已经冻结的class解冻之后还可以继续编辑修改  
			
			MethodInfo methodInfo = null;
			CtMethod[] ctMethods = clazz.getMethods();
			for (CtMethod ctMethod : ctMethods)
			{
				if ("getResult".equals(ctMethod.getName()))
				{
					methodInfo = ctMethod.getMethodInfo();
					break;
				}
			}
			if (null != methodInfo)
			{
				ConstPool methodCP = methodInfo.getConstPool();
				Annotation xmlElement = new Annotation("javax.xml.bind.annotation.XmlElement", methodCP);  
				xmlElement.addMemberValue("name", new StringMemberValue(listName, methodCP));
				xmlElement.addMemberValue("type", new ClassMemberValue(listBeanClass.getName(), methodCP));
				AnnotationsAttribute methodAttribute = new AnnotationsAttribute(methodCP, AnnotationsAttribute.visibleTag);
				methodAttribute.setAnnotation(xmlElement);
				methodInfo.addAttribute(methodAttribute);
			}
			
//			 clazz.writeFile();

//			AnnotationClassLoader loader = new AnnotationClassLoader(ClassUtils.class.getClassLoader());
			// 加载器加载class文件，一个加载器只会加载一次路径名称相同的calss
			// 这里因为只改了注解，类路径是没有改变的。
			
			c = clazz.toClass(listBeanClass.getClassLoader(), null);// TODO N 一个classloader里面怎么有两个重复的对象呢，除非是两个不同的classloader。。所以爆了个重复加载类的错误 
//			if (null != c)
//			{
//				classPoolMap.put(annotationVal, c);
//			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
}
