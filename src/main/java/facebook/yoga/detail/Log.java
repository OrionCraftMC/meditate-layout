package facebook.yoga.detail;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGNode;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGConfig;



public class Log //Type originates from: log.h
{
  public static void log(YGNode node, YGLogLevel level, Object context, String format, Object... LegacyParamArray) //Method definition originates from: log.cpp
  {
//	va_list args;
	int ParamCount = -1;
//	va_start(args, format);
	GlobalMembers.vlog(node == null ? null : node.getConfig(), node, level, context, format, new va_list(args));
//	va_end(args);
  }

  public static void log(YGConfig config, YGLogLevel level, Object context, String format, Object... LegacyParamArray) //Method definition originates from: log.cpp
  {
//	va_list args;
	int ParamCount = -1;
//	va_start(args, format);
	GlobalMembers.vlog(config, null, level, context, format, new va_list(args));
//	va_end(args);
  }
}