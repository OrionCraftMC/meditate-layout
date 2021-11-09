package facebook.yoga;

public enum YGPositionType //Type originates from: YGEnums.h
{
	YGPositionTypeStatic,
	YGPositionTypeRelative,
	YGPositionTypeAbsolute;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGPositionType forValue(int value)
	{
		return values()[value];
	}
}