package facebook.yoga;

public enum YGEdge //Type originates from: YGEnums.h
{
	YGEdgeLeft,
	YGEdgeTop,
	YGEdgeRight,
	YGEdgeBottom,
	YGEdgeStart,
	YGEdgeEnd,
	YGEdgeHorizontal,
	YGEdgeVertical,
	YGEdgeAll;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGEdge forValue(int value)
	{
		return values()[value];
	}
}