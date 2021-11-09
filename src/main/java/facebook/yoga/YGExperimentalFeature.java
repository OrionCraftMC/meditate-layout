package facebook.yoga;

public enum YGExperimentalFeature //Type originates from: YGEnums.h
{
	YGExperimentalFeatureWebFlexBasis;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static YGExperimentalFeature forValue(int value)
	{
		return values()[value];
	}
}