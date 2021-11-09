package facebook.yoga.detail;

/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */



//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGNode;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGConfig;



public class Log //Type originates from: log.h
{
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static void log(YGNode* node, YGLogLevel level, Object* context, char* format, ...) noexcept
  public static void log(YGNode node, YGLogLevel level, Object context, tangible.RefObject<String> format, Object... LegacyParamArray) //Method definition originates from: log.cpp
  {
//   va_list args;
   int ParamCount = -1;
//   va_start(args, format);
   GlobalMembers.vlog(node == null ? null : node.getConfig(), node, new YGLogLevel(level), context, format, new va_list(args));
//   va_end(args);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static void log(YGConfig* config, YGLogLevel level, Object* context, char* format, ...) noexcept
  public static void log(YGConfig config, YGLogLevel level, Object context, tangible.RefObject<String> format, Object... LegacyParamArray) //Method definition originates from: log.cpp
  {
//	va_list args;
	int ParamCount = -1;
//	va_start(args, format);
	GlobalMembers.vlog(config, null, new YGLogLevel(level), context, format, new va_list(args));
//	va_end(args);
  }
}