package facebook.yoga;

public enum YGJustify //Type originates from: YGEnums.h
{
	YGJustifyFlexStart,
	YGJustifyCenter,
	YGJustifyFlexEnd,
	YGJustifySpaceBetween,
	YGJustifySpaceAround,
	YGJustifySpaceEvenly;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGJustify forValue(int value)
	{
		return values()[value];
	}
}