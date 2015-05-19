/**
 * <p>项目名：</p>
 * <p>包名：javax.xml.bind</p>
 * <p>文件名：JAXBExceptionTest.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午2:51:51</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package javax.xml.bind;

import java.io.File;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.junit.Test;

import bean.Book;
import bean.Classroom;
import bean.Customer;
import bean.DataFile;
import bean.GET_DOC_HOS_PATIENT;
import bean.IpfBody;
import bean.IpfRequest;
import bean.Student;
import bean.XmlTestBean;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * <p>名称：JAXBExceptionTest.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午2:51:51
 * @version 1.0.0
 */
public class JAXBExceptionTest
{
	@Test
	public void testXml2Java() throws Exception
	{
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>22</age><classroom><grade>4</grade><id>1</id><name>软件工程</name></classroom><id>101</id><name>张三</name></student>";  
	        try {  
	            JAXBContext context = JAXBContext.newInstance(Student.class);  
	            Unmarshaller unmarshaller = context.createUnmarshaller();  
	            Student student = (Student)unmarshaller.unmarshal(new StringReader(xmlStr));  
	            System.out.println(student.getAge());  
	            System.out.println(student.getClassroom().getName());  
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	@Test
	public void testJava2Xml() throws Exception
	{
		Classroom classroom1 = new Classroom(1, "软件工程1", 4);  
		Classroom classroom2 = new Classroom(1, "软件工程2", 4);  
		List<Classroom> classrooms = Lists.newArrayList();
		classrooms.add(classroom1);
		classrooms.add(classroom2);
	        Student student = new Student(101, "张三", 22, classroom1);  
	        student.setClassrooms(classrooms);
	        
	        Map<String, Object> map = Maps.newHashMap();
	        map.put("GET_DOC_HOS_PATIENT", classroom1);
	        student.setMap(map);
	        
	        try {  
	            JAXBContext context = JAXBContext.newInstance(Student.class);  
	            Marshaller marshaller = context.createMarshaller();  
	            marshaller.marshal(student, System.out);  
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	@Test
	public void testname999() throws Exception
	{
		try
		{
			Class<?> clazz = ClassUtils.updateAnnotationForClass("bean.DataFile", "javax.xml.bind.annotation.XmlRootElement", "name", "AUTO_IDS");
			
			DataFile dataFile = (DataFile) clazz.newInstance();
			Book book = new Book();
			book.setId("NO11");
			book.setName("123");
			book.setPrice(1);
			dataFile.setBook(book);
			
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(dataFile, System.out);
			 
//			JAXBContext context = JAXBContext.newInstance(DataFile.class);
//			Marshaller marshaller = context.createMarshaller();
//			marshaller.marshal(dataFile, System.out);
		} catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testname10() throws Exception
	{
		Class<?> clazz = ClassUtils.updateAnnotationForClass(
				"bean.DataFile",
				"javax.xml.bind.annotation.XmlRootElement",
				"name", "AUTO_IDS");
		System.out.println("修改后的@XmlRootElement: " + clazz.getAnnotation(XmlRootElement.class).name());
	}
	
//	@Test
//	public void testJava22Xml() throws Exception
//	{
//		GET_DOC_HOS_PATIENT GET_DOC_HOS_PATIENT = new GET_DOC_HOS_PATIENT();
//		GET_DOC_HOS_PATIENT.setMyid("070807005");
//		GET_DOC_HOS_PATIENT.setChxjb(1);
//		GET_DOC_HOS_PATIENT.setPageSize(10);
//		GET_DOC_HOS_PATIENT.setStartIndex(0);
//		IpfBody<GET_DOC_HOS_PATIENT> body = new IpfBody<GET_DOC_HOS_PATIENT>(GET_DOC_HOS_PATIENT);
//		System.out.println(getAnnotation(body));
//		
//		updateAnnotation(body);
//		
//		System.out.println(getAnnotation(body));
//		
//		IpfRequest ipfRequest = new IpfRequest("GET_DOC_HOS_PATIENT", body);
//		
//		System.out.println(getAnnotation(ipfRequest.getBody()));
//		
//		try {  
//	            JAXBContext context = JAXBContext.newInstance(IpfRequest.class);  
//	            Marshaller marshaller = context.createMarshaller();  
//	            marshaller.marshal(ipfRequest, System.out);  
//	        } catch (JAXBException e) {  
//	            e.printStackTrace();  
//	        }  
//	}
	
	@Test
	public void testXml22Java222() throws Exception
	{
		String xmlStr = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><BODY><GET_DOC_HOS_PATIENT xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:type='getDOCHOSPATIENT'><SELECT_TYPE>1</SELECT_TYPE><EMP_CODE>0708070051</EMP_CODE><PAGE_SIZE>10</PAGE_SIZE><PAGE_INDEX>0</PAGE_INDEX></GET_DOC_HOS_PATIENT></BODY>";
		Class<?> IpfBodyClazz = updateAnnotationForClass(GET_DOC_HOS_PATIENT.class);
		try
		{
			JAXBContext context = JAXBContext.newInstance(IpfBodyClazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			IpfBody body = (IpfBody)unmarshaller.unmarshal(new StringReader(xmlStr));
			System.out.println(JSON.toJSONString(body));
		} catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testJava22Xml() throws Exception
	{
		Class<?> IpfBodyClazz = updateAnnotationForClass(GET_DOC_HOS_PATIENT.class);
//		Class<?> IpfBodyClazz = IpfBody.class;
		
//		System.out.println(IpfBodyClazz.getAnnotation(XmlRootElement.class).name());
//		System.out.println(IpfBodyClazz.getAnnotation(XmlSeeAlso.class).value());
//		System.out.println(IpfBodyClazz.getAnnotation(XmlElement.class).name());
//		java.lang.annotation.Annotation[] annotations = IpfBodyClazz.getAnnotations();
		
//		Class<?> IpfBodyClazz = ClassUtils.updateAnnotationForClass("bean.IpfBody", "javax.xml.bind.annotation.XmlRootElement", "name", "BODY");
		
		GET_DOC_HOS_PATIENT ipfMethod = new GET_DOC_HOS_PATIENT();
		ipfMethod.setMyid("0708070051");
		ipfMethod.setChxjb(1);
		ipfMethod.setPageSize(10);
		ipfMethod.setStartIndex(0);
		IpfBody<GET_DOC_HOS_PATIENT> body = (IpfBody<GET_DOC_HOS_PATIENT>) IpfBodyClazz.newInstance();
//		IpfBody<GET_DOC_HOS_PATIENT> body = new IpfBody<GET_DOC_HOS_PATIENT>();
		body.setIpfMethod(ipfMethod);
		
//		IpfRequest ipfRequest = new IpfRequest("GET_DOC_HOS_PATIENT", body);
		
		try {  
	            JAXBContext context = JAXBContext.newInstance(IpfBodyClazz);  
	            Marshaller marshaller = context.createMarshaller();  
	            marshaller.marshal(body, System.out);  
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	public static Class<?> updateAnnotationForClass(Class methodClass) throws Exception
	{
		Class<?> c = null;
		if (null==methodClass)
		{
			return c;
		}
		try
		{
			ClassPool classPool = ClassPool.getDefault();
			classPool.appendClassPath(new ClassClassPath(ClassUtils.class));
			CtClass clazz = classPool.get("bean.IpfBody");
			clazz.defrost();// //对已经冻结的class解冻之后还可以继续编辑修改  
			
			ClassFile classFile = clazz.getClassFile();
			ConstPool classFileCP = classFile.getConstPool();
			
			Annotation xmlSeeAlso = new Annotation("javax.xml.bind.annotation.XmlSeeAlso", classFileCP);
			ArrayMemberValue arrayMemberValue = new ArrayMemberValue(new ClassMemberValue(methodClass.getName(), classFileCP), classFileCP);
			MemberValue[] memberValue = new MemberValue[]{new ClassMemberValue(methodClass.getName(), classFileCP)};
			arrayMemberValue.setValue(memberValue);
			xmlSeeAlso.addMemberValue("value", arrayMemberValue);
			Annotation xmlRootElement = new Annotation("javax.xml.bind.annotation.XmlRootElement", classFileCP);
			xmlRootElement.addMemberValue("name", new StringMemberValue("BODY", classFileCP));
			AnnotationsAttribute tableAttribute = new AnnotationsAttribute(classFileCP, AnnotationsAttribute.visibleTag);
			tableAttribute.addAnnotation(xmlSeeAlso);
			tableAttribute.addAnnotation(xmlRootElement);
			classFile.addAttribute(tableAttribute);
			classFile.setVersionToJava5();
			
			MethodInfo methodInfo = null;
			CtMethod[] ctMethods = clazz.getMethods();
			for (CtMethod ctMethod : ctMethods)
			{
				if ("getIpfMethod".equals(ctMethod.getName()))
				{
					methodInfo = ctMethod.getMethodInfo();
					break;
				}
			}
			if (null != methodInfo)
			{
				ConstPool methodCP = methodInfo.getConstPool();
				Annotation xmlElement = new Annotation("javax.xml.bind.annotation.XmlElement", methodCP);  
				xmlElement.addMemberValue("name", new StringMemberValue("GET_DOC_HOS_PATIENT", methodCP));
				AnnotationsAttribute methodAttribute = new AnnotationsAttribute(methodCP, AnnotationsAttribute.visibleTag);
				methodAttribute.setAnnotation(xmlElement);
				methodInfo.addAttribute(methodAttribute);
			}
			
//			 clazz.writeFile();

//			AnnotationClassLoader loader = new AnnotationClassLoader(ClassUtils.class.getClassLoader());
			// 加载器加载class文件，一个加载器只会加载一次路径名称相同的calss
			// 这里因为只改了注解，类路径是没有改变的。
			
			c = clazz.toClass(ClassUtils.class.getClassLoader(), null);
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
	
	public static Class<?> updateAnnotationForClass2(Class methodClass) throws Exception
	{
		Class<?> c = null;
		if (null==methodClass)
		{
			return c;
		}
		try
		{
			ClassPool classPool = ClassPool.getDefault();
			classPool.appendClassPath(new ClassClassPath(ClassUtils.class));
			CtClass clazz = classPool.get("bean.IpfBody");
			clazz.defrost();// //对已经冻结的class解冻之后还可以继续编辑修改  
			
			ClassFile classFile = clazz.getClassFile();
			ConstPool classFileCP = classFile.getConstPool();
			
			Annotation xmlSeeAlso = new Annotation("javax.xml.bind.annotation.XmlSeeAlso", classFileCP);
			ArrayMemberValue arrayMemberValue = new ArrayMemberValue(new ClassMemberValue(methodClass.getName(), classFileCP), classFileCP);
			MemberValue[] memberValue = new MemberValue[]{new ClassMemberValue(methodClass.getName(), classFileCP)};
			arrayMemberValue.setValue(memberValue);
			xmlSeeAlso.addMemberValue("value", arrayMemberValue);
			Annotation xmlRootElement = new Annotation("javax.xml.bind.annotation.XmlRootElement", classFileCP);
			xmlRootElement.addMemberValue("name", new StringMemberValue("BODY", classFileCP));
			AnnotationsAttribute tableAttribute = new AnnotationsAttribute(classFileCP, AnnotationsAttribute.visibleTag);
			tableAttribute.addAnnotation(xmlSeeAlso);
			tableAttribute.addAnnotation(xmlRootElement);
			classFile.addAttribute(tableAttribute);
			classFile.setVersionToJava5();
			
			MethodInfo methodInfo = null;
			CtMethod[] ctMethods = clazz.getMethods();
			for (CtMethod ctMethod : ctMethods)
			{
				if ("getIpfMethod".equals(ctMethod.getName()))
				{
					methodInfo = ctMethod.getMethodInfo();
					break;
				}
			}
			if (null != methodInfo)
			{
				ConstPool methodCP = methodInfo.getConstPool();
				Annotation xmlElement = new Annotation("javax.xml.bind.annotation.XmlElement", methodCP);  
				xmlElement.addMemberValue("name", new StringMemberValue("GET_DOC_HOS_PATIENT", methodCP));
				AnnotationsAttribute methodAttribute = new AnnotationsAttribute(methodCP, AnnotationsAttribute.visibleTag);
				methodAttribute.setAnnotation(xmlElement);
				methodInfo.addAttribute(methodAttribute);
			}
			
//			 clazz.writeFile();

//			AnnotationClassLoader loader = new AnnotationClassLoader(ClassUtils.class.getClassLoader());
			// 加载器加载class文件，一个加载器只会加载一次路径名称相同的calss
			// 这里因为只改了注解，类路径是没有改变的。
			
			c = clazz.toClass(ClassUtils.class.getClassLoader(), null);
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
	
	@Test
	public void testJava22Xml333() throws Exception
	{
		Class<?> IpfBodyClazz = updateAnnotationForClass2(GET_DOC_HOS_PATIENT.class);
//		Class<?> IpfBodyClazz = IpfBody.class;
		
//		System.out.println(IpfBodyClazz.getAnnotation(XmlRootElement.class).name());
//		System.out.println(IpfBodyClazz.getAnnotation(XmlSeeAlso.class).value());
//		System.out.println(IpfBodyClazz.getAnnotation(XmlElement.class).name());
//		java.lang.annotation.Annotation[] annotations = IpfBodyClazz.getAnnotations();
		
//		Class<?> IpfBodyClazz = ClassUtils.updateAnnotationForClass("bean.IpfBody", "javax.xml.bind.annotation.XmlRootElement", "name", "BODY");
		
		GET_DOC_HOS_PATIENT ipfMethod = new GET_DOC_HOS_PATIENT();
		ipfMethod.setMyid("0708070051");
		ipfMethod.setChxjb(1);
		ipfMethod.setPageSize(10);
		ipfMethod.setStartIndex(0);
		IpfBody<GET_DOC_HOS_PATIENT> body = (IpfBody<GET_DOC_HOS_PATIENT>) IpfBodyClazz.newInstance();
		body.setIpfMethod(ipfMethod);
		
		IpfRequest ipfRequest = new IpfRequest("GET_DOC_HOS_PATIENT", body);
		
		try {  
	            JAXBContext context = JAXBContext.newInstance(IpfRequest.class);  
	            Marshaller marshaller = context.createMarshaller();  
	            marshaller.marshal(ipfRequest, System.out);  
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	public AnnotationsAttribute getAnnotation(Object body) throws NotFoundException
	{
		String clazzName = body.getClass().getName();
		ClassPool pool = ClassPool.getDefault();
		// 获取要修改的类的所有信息
		CtClass ct = pool.get(clazzName);
		// 获取类中的方法
		CtMethod[] cms = ct.getDeclaredMethods();
		CtMethod cm = cms[0];
		// 获取方法信息
		MethodInfo methodInfo = cm.getMethodInfo();
		// 获取方法上的注解属性
		AnnotationsAttribute attribute = (AnnotationsAttribute)methodInfo.getAttribute(AnnotationsAttribute.visibleTag);
		return attribute;
	}
	
	public void updateAnnotation(Object body) throws NotFoundException
	{
		String clazzName = body.getClass().getName();
		ClassPool pool = ClassPool.getDefault();
		// 获取要修改的类的所有信息
		CtClass ct = pool.get(clazzName);
		// 获取类中的方法
		CtMethod[] cms = ct.getDeclaredMethods();
		CtMethod cm = cms[0];
		// 获取方法信息
		MethodInfo methodInfo = cm.getMethodInfo();
		ConstPool constPool = methodInfo.getConstPool();
		// 获取方法上的注解属性
		AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
		Annotation annotation = new Annotation("javax.xml.bind.annotation.XmlElement", constPool);  
		annotation.addMemberValue("name", new StringMemberValue("!!!!GET_DOC_HOS_PATIENT", constPool));
		attribute.setAnnotation(annotation);
		methodInfo.addAttribute(attribute);
	}
	
	@Test
	public void testJava22Xml2() throws Exception
	{
		XmlTestBean<Classroom> xmlTestBean = new XmlTestBean<Classroom>();
		xmlTestBean.setStr("ssss");
		Classroom classroom1 = new Classroom(1, "软件工程1", 4);  
		xmlTestBean.setObj(classroom1);
		try {  
	            JAXBContext context = JAXBContext.newInstance(XmlTestBean.class);  
	            Marshaller marshaller = context.createMarshaller();  
	            marshaller.marshal(xmlTestBean, System.out);  
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	@Test
	public void testXml22Java() throws Exception
	{
		String xmlStr = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><REQUEST><BODY><GET_DOC_HOS_PATIENT xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:type='getDOCHOSPATIENT'><SELECT_TYPE>1</SELECT_TYPE><EMP_CODE>070807005</EMP_CODE><PAGE_SIZE>10</PAGE_SIZE><PAGE_INDEX>0</PAGE_INDEX></GET_DOC_HOS_PATIENT></BODY><HEADER><PASSWORD>123</PASSWORD><TRANSNO>GET_DOC_HOS_PATIENT</TRANSNO><USERID>DOC_APP</USERID></HEADER></REQUEST>";
		try {  
	            JAXBContext context = JAXBContext.newInstance(IpfRequest.class);  
	            Unmarshaller unmarshaller = context.createUnmarshaller();  
	            IpfRequest IpfRequest = (IpfRequest)unmarshaller.unmarshal(new StringReader(xmlStr));  
	            System.out.println(JSON.toJSONString(IpfRequest));
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	@Test
	public void testname333() throws Exception
	{
		Customer<HashSet<Book>> customer = new Customer<HashSet<Book>>();
		customer.setId(100);
		customer.setName("suo");
		customer.setAge(29);

		Book book = new Book();
		book.setId("1");
		book.setName("哈里波特");
		book.setPrice(100);

		Book book2 = new Book();
		book2.setId("2");
		book2.setName("苹果");
		book2.setPrice(50);

		HashSet<Book> bookSet = new HashSet<Book>();
		bookSet.add(book);
		bookSet.add(book2);

		customer.setT(bookSet);

		try
		{
			File file = new File("C:\\file1.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(
					Customer.class, HashSet.class);
			Marshaller jaxbMarshaller = jaxbContext
					.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(
					Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
		} catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>描述：动态修改注解</p>
	 * <pre>
	 *    
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testname() throws Exception
	{
		ClassPool pool = ClassPool.getDefault();
		// 获取要修改的类的所有信息
		CtClass ct = pool.get("bean.CollectionBase");
		// 获取类中的方法
		CtMethod[] cms = ct.getDeclaredMethods();
		// 获取第一个方法（因为只有一个方法）
		CtMethod cm = cms[0];
		System.out.println("方法名称====" + cm.getName());
		// 获取方法信息
		MethodInfo methodInfo = cm.getMethodInfo();
		// 获取类里的em属性
		CtField cf = ct.getField("em");
		// 获取属性信息
		FieldInfo fieldInfo = cf.getFieldInfo();
		System.out.println("属性名称===" + cf.getName());

		// 获取注解属性
		AnnotationsAttribute attribute = (AnnotationsAttribute) fieldInfo.getAttribute(AnnotationsAttribute.visibleTag);
		System.out.println(attribute);
		// 获取注解
		Annotation annotation = attribute.getAnnotation("javax.persistence.PersistenceContext");
		System.out.println(annotation);
		// 获取注解的值
		String text = ((StringMemberValue) annotation.getMemberValue("unitName")).getValue();
		System.out.println("注解名称===" + text);
	}
	
	@Test
	public void testname55555() throws Exception
	{
		ClassPool pool = ClassPool.getDefault();      
	           //获取需要修改的类  
	           CtClass ct = pool.get("bean.CollectionBase");   
	             
	           //获取类里的所有方法  
	           CtMethod[] cms = ct.getDeclaredMethods();  
	           CtMethod cm = cms[0];      
	           System.out.println("方法名称====" + cm.getName());  
	             
	           MethodInfo minInfo = cm.getMethodInfo();  
	           //获取类里的em属性  
	           CtField cf = ct.getField("em");  
	           FieldInfo fieldInfo = cf.getFieldInfo();    
	             
	           System.out.println("属性名称===" + cf.getName());  
	             
	           ConstPool cp = fieldInfo.getConstPool();  
	           //获取注解信息  
	           AnnotationsAttribute attribute2 = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);  
	           Annotation annotation = new Annotation("javax.persistence.PersistenceContext", cp);  
	           //修改名称为unitName的注解  
	           annotation.addMemberValue("unitName", new StringMemberValue("basic-entity", cp));  
	           attribute2.setAnnotation(annotation);  
	           minInfo.addAttribute(attribute2);  
	             
	           //打印修改后方法  
	           Annotation annotation2 = attribute2.getAnnotation("javax.persistence.PersistenceContext");  
	           String text = ((StringMemberValue)annotation2.getMemberValue("unitName")).getValue();  
	             
	           System.out.println("修改后的注解名称===" + text);  
	}
	
	@Test
	public void testname4444() throws Exception
	{
		ClassPool pool = ClassPool.getDefault();
		// 获取要修改的类的所有信息
		CtClass ct = pool.get("bean.IpfBody");
//		Object[] objs = ct.getAnnotations();
//		AnnotationImpl annotationImpl = (AnnotationImpl) objs[0];
//		AnnotationsAttribute xmlSeeAlsoAnnotation = (AnnotationsAttribute)ct.getAnnotation(javax.xml.bind.annotation.XmlSeeAlso.class);
//		System.out.println(xmlSeeAlsoAnnotation.getName());
		
		
		// 获取类中的方法
		CtMethod[] cms = ct.getDeclaredMethods();
		// 获取第一个方法（因为只有一个方法）
		CtMethod cm = cms[0];
		// 获取方法信息
		MethodInfo methodInfo = cm.getMethodInfo();
		// 获取方法上的注解属性
		AnnotationsAttribute attribute = (AnnotationsAttribute)methodInfo.getAttribute(AnnotationsAttribute.visibleTag);
		Annotation annotation = attribute.getAnnotation("javax.xml.bind.annotation.XmlElement");
		annotation.addMemberValue("name", new StringMemberValue("!!!!GET_DOC_HOS_PATIENT", methodInfo.getConstPool()));
		attribute.setAnnotation(annotation);
		
		attribute = (AnnotationsAttribute)methodInfo.getAttribute(AnnotationsAttribute.visibleTag);
		System.out.println();
		// 获取注解属性
//		AnnotationsAttribute attribute = (AnnotationsAttribute) fieldInfo.getAttribute(AnnotationsAttribute.visibleTag);
//		System.out.println(attribute);
//		// 获取注解
//		Annotation annotation = attribute.getAnnotation("javax.persistence.PersistenceContext");
//		System.out.println(annotation);
//		// 获取注解的值
//		String text = ((StringMemberValue) annotation.getMemberValue("unitName")).getValue();
//		System.out.println("注解名称===" + text);
	}
}
