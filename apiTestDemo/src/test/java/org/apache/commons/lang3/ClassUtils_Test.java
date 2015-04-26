/*
 * @(#)ClassUtils_Test.java 2015-1-28 下午1:17:30
 * Copyright 2015 周光暖, Inc. All rights reserved. 8637.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.apache.commons.lang3;

import java.util.Date;

import org.junit.Test;

/**
 * <p>File：ClassUtils_Test.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-1-28 下午1:17:30</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class ClassUtils_Test
{
	/**
	 * 获取简单类名
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetShortClassName() throws Exception
	{
        System.out.println(ClassUtils.getShortClassName(new Date(), "valueIfNull"));// Date 
        // 第一个参数为空时，返回第二个参数
        System.out.println(ClassUtils.getShortClassName(null, "valueIfNull"));// valueIfNull  
        
        System.out.println(ClassUtils.getShortClassName(Date.class));// Date   
        
        System.out.println(ClassUtils.getShortClassName("Date"));// Date   
        System.out.println(ClassUtils.getShortClassName("java.util.Date"));// Date   
        
        System.out.println(ClassUtils.getSimpleName(Date.class));// Date  
		System.out.println(ClassUtils.getSimpleName(new Date(), "valueIfNull"));// Date  
		System.out.println(ClassUtils.getSimpleName(null, "valueIfNull"));// valueIfNull  
		
        System.out.println(Date.class.getName());// java.util.Date  
	}
	
	/**
	 * 获得包名
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetPackageName() throws Exception
	{
		System.out.println(ClassUtils.getPackageName(new Date(), "valueIfNull"));// java.util   
		System.out.println(ClassUtils.getPackageName(Date.class));// java.util
		System.out.println(ClassUtils.getPackageName("Date"));// ""  
		System.out.println(ClassUtils.getPackageName(""));// "" 
		System.out.println(ClassUtils.getPackageName("java.util.Date"));// java.util  
	}
	
	/**
	 * 获取类所有父类
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testGetAllSuperclasses() throws Exception
	{
        System.out.println(ClassUtils.getAllSuperclasses(Date.class));  
        // [class java.lang.Object]
	}
	
	/**
	 * 获取类实现的所有接口
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void tesGetAllSuperclasses() throws Exception
	{
        System.out.println(ClassUtils.getAllInterfaces(Date.class));  
        // [interface java.io.Serializable, interface java.lang.Cloneable, interface java.lang.Comparable]
	}
	
	/**
	 * 判断是否可以转型
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIsAssignable() throws Exception
	{
		// 判断第一个参数能否转为第二个参数的类型
        System.out.println(ClassUtils.isAssignable(Date.class, Object.class));// true  
        System.out.println(ClassUtils.isAssignable(Object.class, Date.class));// false  
        
        System.out.println(ClassUtils.isAssignable(new Class[]{Integer.class, String.class}, new Class[]{Object.class, Object.class}));// true 
        System.out.println(ClassUtils.isAssignable(new Class[]{Integer.class, String.class}, new Class[]{Object.class, Object.class}, false));// true 
        System.out.println(ClassUtils.isAssignable(new Class[]{int.class, String.class}, new Class[]{Object.class, Object.class}, false));// false 
        System.out.println(ClassUtils.isAssignable(new Class[]{Integer.class, String.class}, new Class[]{Object.class, Object.class}, true));// true 
        System.out.println(ClassUtils.isAssignable(new Class[]{int.class, String.class}, new Class[]{Object.class, Object.class}, true));// true 
	}
	
	/**
	 * 判断是否（基本类型或包装类型/包装类型）
	 * @throws Exception
	 * @author 周光暖
	 */
	@Test
	public void testIsPrimitive() throws Exception
	{
		Class clazz = null;
		System.out.println(ClassUtils.isPrimitiveOrWrapper(clazz));// false
		
		clazz = int.class;
		System.out.println(ClassUtils.isPrimitiveOrWrapper(clazz));// true
		// 判断是否是包装类型
		System.out.println(ClassUtils.isPrimitiveWrapper(clazz));// false
		
		clazz = Integer.class;
		System.out.println(ClassUtils.isPrimitiveOrWrapper(clazz));// true
		System.out.println(ClassUtils.isPrimitiveWrapper(clazz));// true
		
		clazz = char.class;
		clazz = Character.class;
		System.out.println(ClassUtils.isPrimitiveOrWrapper(clazz));// true
		System.out.println(ClassUtils.isPrimitiveWrapper(clazz));// true
	}
	
//	    public static Method getPublicMethod(Class<?> cls, String methodName, Class<?>... parameterTypes)
//	    public static Class<?>[] toClass(Object... array) {
	
	
//	    public static boolean isInnerClass(Class<?> cls) {
//	    public static List<Class<?>> convertClassNamesToClasses(List<String> classNames) {
//	    public static List<String> convertClassesToClassNames(List<Class<?>> classes) {
//	    public static Class<?> getClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
//	    public static Class<?> getClass(String className) throws ClassNotFoundException {
//	    public static Class<?> getClass(String className, boolean initialize) throws ClassNotFoundException {
//	    public static String getShortCanonicalName(Object object, String valueIfNull) {
//	    public static String getShortCanonicalName(Class<?> cls) {
//	    public static String getShortCanonicalName(String canonicalName) {
//	    public static String getPackageCanonicalName(Object object, String valueIfNull) {
//	    public static String getPackageCanonicalName(Class<?> cls) {
//	    public static String getPackageCanonicalName(String canonicalName) {
}
