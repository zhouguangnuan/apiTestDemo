/**
 * <p>项目名：</p>
 * <p>包名：javax.xml.bind</p>
 * <p>文件名：ClassUtils.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午11:28:39</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package javax.xml.bind;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import bean.Student;

/**
 * <p>
 * 名称：ClassUtils.java
 * </p>
 * <p>
 * 描述：
 * </p>
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author 周光暖
 * @date 2015-5-11 下午11:28:39
 * @version 1.0.0
 */
public class ClassUtils
{

	// 缓存加载器加载的calss对象
	private static final Map<String, Class<?>> classPoolMap = new ConcurrentHashMap<String, Class<?>>();

	/**
	 * 运行时动态修改注解值
	 * 
	 * @param Class
	 * 
	 * @param entityClassName
	 *                待映射的实体全限定类名
	 * @param annotation
	 *                需要修改的注解全限定类名
	 * @param annotationAttrName
	 *                注解属性名称
	 * @param annotationVal
	 *                注解属性值
	 * 
	 * @return 映射后的类对象
	 */
	public static Class<?> updateAnnotationForClass(String entityClassName, String annotationClassName, String annotationAttrName, String annotationVal) throws Exception
	{
		Class<?> c = null;
		if (StringUtils.isBlank(entityClassName)
				|| StringUtils.isBlank(annotationClassName)
				|| StringUtils.isBlank(annotationAttrName)
				|| StringUtils.isBlank(annotationVal))
		{
			return c;
		}
		c = classPoolMap.get(annotationVal);
		if (null != c)
		{
			return c;
		}
		try
		{
			ClassPool classPool = ClassPool.getDefault();
			classPool.appendClassPath(new ClassClassPath(ClassUtils.class));
			// classPool.importPackage("javax.persistence");
			CtClass clazz = classPool.get(entityClassName);
			clazz.defrost();
			ClassFile classFile = clazz.getClassFile();
			ConstPool constPool = classFile.getConstPool();
			
			Annotation tableAnnotation = new Annotation(annotationClassName, constPool);
			tableAnnotation.addMemberValue(annotationAttrName, new StringMemberValue(annotationVal, constPool));
			// 获取运行时注解属性
//			AnnotationsAttribute attribute = (AnnotationsAttribute) classFile.getAttribute(AnnotationsAttribute.visibleTag);
			AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
			attribute.addAnnotation(tableAnnotation);
			classFile.addAttribute(attribute);
			classFile.setVersionToJava5();
			// clazz.writeFile();

//			AnnotationClassLoader loader = new AnnotationClassLoader(ClassUtils.class.getClassLoader());
			// 加载器加载class文件，一个加载器只会加载一次路径名称相同的calss
			// 这里因为只改了注解，类路径是没有改变的。
			
			c = clazz.toClass(ClassUtils.class.getClassLoader(), null);
			if (null != c)
			{
				classPoolMap.put(annotationVal, c);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	public static Class<?> updateAnnotationForClass(Object obj, String annotationClassName, String annotationAttrName, String annotationVal) throws Exception
	{
		Class<?> c = null;
		if (null == obj || StringUtils.isBlank(annotationClassName) || StringUtils.isBlank(annotationAttrName) || StringUtils.isBlank(annotationVal))
		{
			return c;
		}
		String entityClassName = obj.getClass().getName();
		
		c = classPoolMap.get(annotationVal);
		if (null != c)
		{
			return c;
		}
		try
		{
			ClassPool classPool = ClassPool.getDefault();
			classPool.appendClassPath(new ClassClassPath(ClassUtils.class));
			// classPool.importPackage("javax.persistence");
			CtClass clazz = classPool.get(entityClassName);
			clazz.defrost();
			ClassFile classFile = clazz.getClassFile();
			ConstPool constPool = classFile.getConstPool();
			
			Annotation tableAnnotation = new Annotation(annotationClassName, constPool);
			tableAnnotation.addMemberValue(annotationAttrName, new StringMemberValue(annotationVal, constPool));
			// 获取运行时注解属性
//			AnnotationsAttribute attribute = (AnnotationsAttribute) classFile.getAttribute(AnnotationsAttribute.visibleTag);
			AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
			attribute.addAnnotation(tableAnnotation);
			classFile.addAttribute(attribute);
			classFile.setVersionToJava5();
			// clazz.writeFile();

//			AnnotationClassLoader loader = new AnnotationClassLoader(ClassUtils.class.getClassLoader());
			// 加载器加载class文件，一个加载器只会加载一次路径名称相同的calss
			// 这里因为只改了注解，类路径是没有改变的。
			
			c = clazz.toClass(ClassUtils.class.getClassLoader(), null);
			if (null != c)
			{
				classPoolMap.put(annotationVal, c);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	public static Object unmarshalClaim(Class<?> c, String xmlString) throws Exception 
	{
		JAXBContext jaxbContext;
		// 获取动态class对象
		Class<?> calss = ClassUtils.updateAnnotationForClass(
				"bean.DataFile",
				"javax.xml.bind.annotation.XmlRootElement",
				"name", "AUTO_IDS");
		if (null != calss)
		{
			c = calss;
		}
		xmlString = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><DataFile><Book><id>NO11</id><name>123</name><price>1.0</price></Book></DataFile>";

		StreamSource streamSource = new StreamSource(new StringReader(xmlString));

		// 加载映射bean类
		jaxbContext = JAXBContext.newInstance(c);
		// 创建解析
		Unmarshaller um = jaxbContext.createUnmarshaller();
		return um.unmarshal(new StringReader(xmlString));
	}

	@Test
	public void testname22() throws Exception
	{
		Class<?> clazz3 = ClassUtils.updateAnnotationForClass(
				"bean.DataFile",
				"javax.xml.bind.annotation.XmlRootElement",
				"name", "AUTO_IDS");
		System.out.println("修改后的@XmlRootElement: " + clazz3.getAnnotation(XmlRootElement.class).name());
	}
	
	@Test
	public void testname() throws Exception
	{
		Class<?> c = ClassUtils.updateAnnotationForClass(
				"bean.DataFile",
				"javax.xml.bind.annotation.XmlRootElement",
				"name", "DataFile");
		Object obj = ClassUtils.unmarshalClaim(c, "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><DataFile><Book><id>NO11</id><name>123</name><price>1.0</price></Book></DataFile>");
		System.out.println(JSON.toJSONString(obj));
	}
}