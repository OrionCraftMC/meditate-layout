package facebook.yoga;

public enum YGPrintOptions //Type originates from: YGEnums.h
{
	YGPrintOptionsLayout(1),
	YGPrintOptionsStyle(2),
	YGPrintOptionsChildren(4);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, YGPrintOptions> mappings;
	private static java.util.HashMap<Integer, YGPrintOptions> getMappings()
	{
		if (mappings == null)
		{
			synchronized (YGPrintOptions.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, YGPrintOptions>();
				}
			}
		}
		return mappings;
	}

	private YGPrintOptions(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static YGPrintOptions forValue(int value)
	{
		return getMappings().get(value);
	}
}