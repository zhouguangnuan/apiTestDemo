package jdk.Enum;

import org.junit.Test;



public class EnumTest
{
	@Test
	public void test1( ) throws Exception
	{
		System.out.println(WeekDay.SUN.compareTo(WeekDay.MON));
		System.out.println(WeekDay.SUN.name);
		System.out.println(WeekDay.SUN.nextDay().name);
		
		
		WeekDay.SUN.getClass();
//		
//		List<Class<?>> clazzs = ClassUtils.getAllSuperclasses(WeekDay.class);
		
//		Enum<WeekDay> ss = WeekDay.class.isSynthetic()
				
		
//		System.out.println(WeekDay.SUN.getClass().getSuperclass().getSuperclass());
				
//		Enum.
		
		System.out.println(WeekDay.SUN.getClass());
	}
	
	@Test
	public void test2() throws Exception
	{
		WeekDay[] weekDays = WeekDay.values();
		System.out.println(weekDays[0]);
	}
}
