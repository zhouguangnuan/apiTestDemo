package jdk.annotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>名称：Annotation1.java</p>
 * <p>描述：注解类，用于标识作用</p>
 * 
 * @author 周光暖
 * @date 2014-4-24 下午10:13:40
 * @version 1.0.0
 */
//@Retention(RetentionPolicy.SOURCE)// 保留时间：源文件
//@Retention(RetentionPolicy.CLASS)// 保留时间：class文件
@Retention(RetentionPolicy.RUNTIME)// 保留时间：运行状态

//@Target(ElementType.METHOD)// 定义注解的使用位置(如 方法上、成员变量上、参数前...)
public @interface Annotation1
{
	// 注解的属性
	String color();// 类似抽象方法
	// 比较特殊：使用注解是，当只有value属性 可以  @Annotation1(value="值") -->　@Annotation1(＂值＂)
	String value();
	String heigth() default "1米";// 设置初始值，使用时可以不赋值
}
