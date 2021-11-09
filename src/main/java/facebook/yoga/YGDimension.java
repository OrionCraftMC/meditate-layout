package facebook.yoga;

public enum YGDimension //Type originates from: YGEnums.h
{
	YGDimensionWidth,
	YGDimensionHeight;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGDimension forValue(int value)
	{
		return values()[value];
	}
}