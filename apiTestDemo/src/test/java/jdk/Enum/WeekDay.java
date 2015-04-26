package jdk.Enum;

public enum WeekDay
{
	SUN(0, "星期天")// 相当于 public static WeekDay SUN = new WeedDay(0, "星期天");
	{
		public WeekDay nextDay()
		{
			return MON;
		}
	}, 
	MON(1, "星期一")
	{
		public WeekDay nextDay()
		{
			return TUE;
		}
	}, 
	TUE(2, "星期二")
	{
		public WeekDay nextDay()
		{
			return WED;
		}
	}, 
	WED(3, "星期三")
	{
		public WeekDay nextDay()
		{
			return THI;
		}
	}, 
	THI(4, "星期四")
	{
		public WeekDay nextDay()
		{
			return FRI;
		}
	}, 
	FRI(5, "星期五")
	{
		public WeekDay nextDay()
		{
			return SAT;
		}
	}, 
	SAT(6, "星期六")
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
