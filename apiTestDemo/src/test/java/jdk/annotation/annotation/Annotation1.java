package jdk.annotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>���ƣ�Annotation1.java</p>
 * <p>������ע���࣬���ڱ�ʶ����</p>
 * 
 * @author �ܹ�ů
 * @date 2014-4-24 ����10:13:40
 * @version 1.0.0
 */
//@Retention(RetentionPolicy.SOURCE)// ����ʱ�䣺Դ�ļ�
//@Retention(RetentionPolicy.CLASS)// ����ʱ�䣺class�ļ�
@Retention(RetentionPolicy.RUNTIME)// ����ʱ�䣺����״̬

//@Target(ElementType.METHOD)// ����ע���ʹ��λ��(�� �����ϡ���Ա�����ϡ�����ǰ...)
public @interface Annotation1
{
	// ע�������
	String color();// ���Ƴ��󷽷�
	// �Ƚ����⣺ʹ��ע���ǣ���ֻ��value���� ����  @Annotation1(value="ֵ") -->��@Annotation1(��ֵ��)
	String value();
	String heigth() default "1��";// ���ó�ʼֵ��ʹ��ʱ���Բ���ֵ
}
