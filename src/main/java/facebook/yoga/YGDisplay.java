package facebook.yoga;

public enum YGDisplay //Type originates from: YGEnums.h
{
	YGDisplayFlex,
	YGDisplayNone;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGDisplay forValue(int value)
	{
		return values()[value];
	}
}