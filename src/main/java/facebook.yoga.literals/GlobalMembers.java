package facebook.yoga.literals;

public class GlobalMembers
{
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	YGValue operator"" _pt(double value)
	{
	  return YGValue((float)value, YGUnitPoint);
	}
	//C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
	//ORIGINAL LINE: inline YGValue operator"" _pt(unsigned long long value)
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	YGValue operator"" _pt(long value)
	{
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return operator"" _pt(static_cast<double>(value));
	  return new YGValue(literals.GlobalMembers.operator"" _pt((long)(double)value));
	}

//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	YGValue operator"" _percent(double value)
	{
	  return YGValue((float)value, YGUnitPercent);
	}
	//C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
	//ORIGINAL LINE: inline YGValue operator"" _percent(unsigned long long value)
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	YGValue operator"" _percent(long value)
	{
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return operator"" _percent(static_cast<double>(value));
	  return new YGValue(literals.GlobalMembers.operator"" _percent((long)(double)value));
	}
}