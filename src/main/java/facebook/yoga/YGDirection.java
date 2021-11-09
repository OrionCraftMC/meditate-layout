package facebook.yoga;

public enum YGDirection //Type originates from: YGEnums.h
{
	YGDirectionInherit,
	YGDirectionLTR,
	YGDirectionRTL;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGDirection forValue(int value)
	{
		return values()[value];
	}
}