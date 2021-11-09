package facebook.yoga;

public enum YGUnit //Type originates from: YGEnums.h
{
	YGUnitUndefined,
	YGUnitPoint,
	YGUnitPercent,
	YGUnitAuto;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGUnit forValue(int value)
	{
		return values()[value];
	}
}