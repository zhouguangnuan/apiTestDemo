package jdk.annotation.test;

import jdk.annotation.annotation.Annotation1;
import jdk.annotation.usedAnnotation.Bean1;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo1
{
	@Test
	public void test1() throws Exception
	{
		Class clazz = Bean1.class;
		boolean beAnnotation = clazz.isAnnotationPresent(Annotation1.class);
		if (beAnnotation)
		{
			Annotation1 annotation = (Annotation1) clazz.getAnnotation(Annotation1.class);
			System.out.println("annotation£º" + annotation);
			System.out.println(annotation.color());
		}
	}
}
