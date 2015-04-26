package jdk.Enum;

public enum WeekDay
{
	SUN(0, "������")// �൱�� public static WeekDay SUN = new WeedDay(0, "������");
	{
		public WeekDay nextDay()
		{
			return MON;
		}
	}, 
	MON(1, "����һ")
	{
		public WeekDay nextDay()
		{
			return TUE;
		}
	}, 
	TUE(2, "���ڶ�")
	{
		public WeekDay nextDay()
		{
			return WED;
		}
	}, 
	WED(3, "������")
	{
		public WeekDay nextDay()
		{
			return THI;
		}
	}, 
	THI(4, "������")
	{
		public WeekDay nextDay()
		{
			return FRI;
		}
	}, 
	FRI(5, "������")
	{
		public WeekDay nextDay()
		{
			return SAT;
		}
	}, 
	SAT(6, "������")
	{
		public WeekDay nextDay()
		{
			return null;
		}
	};
	
	public String name;
	
	private WeekDay(int i, String name){
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public abstract WeekDay nextDay();
}
