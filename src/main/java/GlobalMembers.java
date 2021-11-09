import java.util.*;

public class GlobalMembers
{
	public static boolean YGValueEqual(YGValue a, YGValue b) //Method definition originates from: Utils.cpp
	{
	  if (a.unit != b.unit)
	  {
		return false;
	  }

	  if (a.unit == YGUnitUndefined || (yoga.GlobalMembers.isUndefined(a.value) && yoga.GlobalMembers.isUndefined(b.value)))
	  {
		return true;
	  }

	  return Math.abs(a.value - b.value) < 0.0001f;
	}

	public static boolean YGValueEqual(facebook.yoga.detail.CompactValue a, facebook.yoga.detail.CompactValue b)
	{
	  return YGValueEqual((YGValue) a, (YGValue) b);
	}

	// This custom float equality function returns true if either absolute
	// difference between two floats is less than 0.0001f or both are undefined.
	public static boolean YGFloatsEqual(float a, float b) //Method definition originates from: Utils.cpp
	{
	  if (!yoga.GlobalMembers.isUndefined(a) && !yoga.GlobalMembers.isUndefined(b))
	  {
		return Math.abs(a - b) < 0.0001f;
	  }
	  return yoga.GlobalMembers.isUndefined(a) && yoga.GlobalMembers.isUndefined(b);
	}

	public static boolean YGDoubleEqual(double a, double b) //Method definition originates from: Utils.cpp
	{
	  if (!yoga.GlobalMembers.isUndefined(a) && !yoga.GlobalMembers.isUndefined(b))
	  {
		return Math.abs(a - b) < 0.0001;
	  }
	  return yoga.GlobalMembers.isUndefined(a) && yoga.GlobalMembers.isUndefined(b);
	}

	public static float YGFloatMax(float a, float b) //Method definition originates from: Utils.cpp
	{
	  if (!yoga.GlobalMembers.isUndefined(a) && !yoga.GlobalMembers.isUndefined(b))
	  {
		return fmaxf(a, b);
	  }
	  return yoga.GlobalMembers.isUndefined(a) ? b : a;
	}

	public static YGFloatOptional YGFloatOptionalMax(YGFloatOptional op1, YGFloatOptional op2) //Method definition originates from: Utils.cpp
	{
	  if (op1 >= op2)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return op1;
		return new YGFloatOptional(op1);
	  }
	  if (op2 > op1)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return op2;
		return new YGFloatOptional(op2);
	  }
	  return op1.isUndefined() ? op2 : op1;
	}

	public static float YGFloatMin(float a, float b) //Method definition originates from: Utils.cpp
	{
	  if (!yoga.GlobalMembers.isUndefined(a) && !yoga.GlobalMembers.isUndefined(b))
	  {
		return fminf(a, b);
	  }

	  return yoga.GlobalMembers.isUndefined(a) ? b : a;
	}

	// This custom float comparison function compares the array of float with
	// YGFloatsEqual, as the default float comparison operator will not work(Look
	// at the comments of YGFloatsEqual function).
	//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
	//ORIGINAL LINE: template <std::size_t size>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename size> requires int<size>
	public static <size> boolean YGFloatArrayEqual(ArrayList<Float> val1, ArrayList<Float> val2)
	{
	  boolean areEqual = true;
	  for (int i = 0; i < size && areEqual; ++i)
	  {
		areEqual = YGFloatsEqual(val1.get(i), val2.get(i));
	  }
	  return areEqual;
	}

	// This function returns 0 if YGFloatIsUndefined(val) is true and val otherwise
	public static float YGFloatSanitize(float val) //Method definition originates from: Utils.cpp
	{
	  return yoga.GlobalMembers.isUndefined(val) ? 0F : val;
	}

	public static YGFlexDirection YGFlexDirectionCross(YGFlexDirection flexDirection, YGDirection direction) //Method definition originates from: Utils.cpp
	{
	  return YGFlexDirectionIsColumn(new YGFlexDirection(flexDirection)) ? YGResolveFlexDirection(YGFlexDirectionRow, new YGDirection(direction)) : YGFlexDirectionColumn;
	}

	public static boolean YGFlexDirectionIsRow(YGFlexDirection flexDirection)
	{
	  return flexDirection == YGFlexDirectionRow || flexDirection == YGFlexDirectionRowReverse;
	}

	public static YGFloatOptional YGResolveValue(YGValue value, float ownerSize)
	{
	  switch (value.unit)
	  {
		case YGUnitPoint:
		  return YGFloatOptional(value.value);
		case YGUnitPercent:
		  return YGFloatOptional(value.value * ownerSize * 0.01f);
		default:
		  return YGFloatOptional();
	  }
	}

	public static YGFloatOptional YGResolveValue(yoga.detail.CompactValue value, float ownerSize)
	{
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return YGResolveValue((YGValue) value, ownerSize);
	  return new YGFloatOptional(YGResolveValue((YGValue) value, ownerSize));
	}

	public static boolean YGFlexDirectionIsColumn(YGFlexDirection flexDirection)
	{
	  return flexDirection == YGFlexDirectionColumn || flexDirection == YGFlexDirectionColumnReverse;
	}

	public static YGFlexDirection YGResolveFlexDirection(YGFlexDirection flexDirection, YGDirection direction)
	{
	  if (direction == YGDirectionRTL)
	  {
		if (flexDirection == YGFlexDirectionRow)
		{
		  return YGFlexDirectionRowReverse;
		}
		else if (flexDirection == YGFlexDirectionRowReverse)
		{
		  return YGFlexDirectionRow;
		}
	  }

	  return new YGFlexDirection(flexDirection);
	}

	public static YGFloatOptional YGResolveValueMargin(yoga.detail.CompactValue value, float ownerSize)
	{
	  return value.isAuto() ? YGFloatOptional(0) : YGResolveValue(new yoga.detail.CompactValue(value), ownerSize);
	}

	public static void throwLogicalErrorWithMessage(tangible.RefObject<String> message) //Method definition originates from: Utils.cpp
	{
	  throw std::logic_error(message.argValue);
	}


//#endif

	//C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
	//ORIGINAL LINE: #define YG_ENUM_DECL(NAME, ...) typedef YG_ENUM_BEGIN(NAME){__VA_ARGS__} YG_ENUM_END(NAME); char* NAME##ToString(NAME);

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if __cplusplus
	//C++ TO JAVA CONVERTER TODO TASK: #define macros defined in multiple preprocessor conditionals can only be replaced within the scope of the preprocessor conditional:
	///#define YG_ENUM_SEQ_DECL(NAME, ...) YG_ENUM_DECL(NAME, __VA_ARGS__) namespace facebook { namespace yoga { namespace enums { template <> constexpr int count<NAME>() { return detail::n<__VA_ARGS__>(); } } } } YG_EXTERN_C_BEGIN
	//#else
	//C++ TO JAVA CONVERTER TODO TASK: #define macros defined in multiple preprocessor conditionals can only be replaced within the scope of the preprocessor conditional:
	///#define YG_ENUM_SEQ_DECL YG_ENUM_DECL
	//#endif

	public static YG_EXTERN_C_BEGIN public enum YGAlign UnnamedParameter
	{
		YGAlignAuto, YGAlignFlexStart, YGAlignCenter, YGAlignFlexEnd, YGAlignStretch, YGAlignBaseline, YGAlignSpaceBetween, YGAlignSpaceAround
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGAlignToString(YGAlign value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGAlignAuto:
		  return "auto";
		case YGAlignFlexStart:
		  return "flex-start";
		case YGAlignCenter:
		  return "center";
		case YGAlignFlexEnd:
		  return "flex-end";
		case YGAlignStretch:
		  return "stretch";
		case YGAlignBaseline:
		  return "baseline";
		case YGAlignSpaceBetween:
		  return "space-between";
		case YGAlignSpaceAround:
		  return "space-around";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGDimension
	{
		YGDimensionWidth, YGDimensionHeight
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGDimensionToString(YGDimension value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGDimensionWidth:
		  return "width";
		case YGDimensionHeight:
		  return "height";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGDirection
	{
		YGDirectionInherit, YGDirectionLTR, YGDirectionRTL
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGDirectionToString(YGDirection value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGDirectionInherit:
		  return "inherit";
		case YGDirectionLTR:
		  return "ltr";
		case YGDirectionRTL:
		  return "rtl";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGDisplay
	{
		YGDisplayFlex, YGDisplayNone
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGDisplayToString(YGDisplay value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGDisplayFlex:
		  return "flex";
		case YGDisplayNone:
		  return "none";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGEdge
	{
		YGEdgeLeft, YGEdgeTop, YGEdgeRight, YGEdgeBottom, YGEdgeStart, YGEdgeEnd, YGEdgeHorizontal, YGEdgeVertical, YGEdgeAll
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGEdgeToString(YGEdge value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGEdgeLeft:
		  return "left";
		case YGEdgeTop:
		  return "top";
		case YGEdgeRight:
		  return "right";
		case YGEdgeBottom:
		  return "bottom";
		case YGEdgeStart:
		  return "start";
		case YGEdgeEnd:
		  return "end";
		case YGEdgeHorizontal:
		  return "horizontal";
		case YGEdgeVertical:
		  return "vertical";
		case YGEdgeAll:
		  return "all";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGExperimentalFeature
	{
		YGExperimentalFeatureWebFlexBasis
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGExperimentalFeatureToString(YGExperimentalFeature value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGExperimentalFeatureWebFlexBasis:
		  return "web-flex-basis";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGFlexDirection
	{
		YGFlexDirectionColumn, YGFlexDirectionColumnReverse, YGFlexDirectionRow, YGFlexDirectionRowReverse
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGFlexDirectionToString(YGFlexDirection value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGFlexDirectionColumn:
		  return "column";
		case YGFlexDirectionColumnReverse:
		  return "column-reverse";
		case YGFlexDirectionRow:
		  return "row";
		case YGFlexDirectionRowReverse:
		  return "row-reverse";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGJustify
	{
		YGJustifyFlexStart, YGJustifyCenter, YGJustifyFlexEnd, YGJustifySpaceBetween, YGJustifySpaceAround, YGJustifySpaceEvenly
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGJustifyToString(YGJustify value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGJustifyFlexStart:
		  return "flex-start";
		case YGJustifyCenter:
		  return "center";
		case YGJustifyFlexEnd:
		  return "flex-end";
		case YGJustifySpaceBetween:
		  return "space-between";
		case YGJustifySpaceAround:
		  return "space-around";
		case YGJustifySpaceEvenly:
		  return "space-evenly";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGLogLevel
	{
		YGLogLevelError, YGLogLevelWarn, YGLogLevelInfo, YGLogLevelDebug, YGLogLevelVerbose, YGLogLevelFatal
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGLogLevelToString(YGLogLevel value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGLogLevelError:
		  return "error";
		case YGLogLevelWarn:
		  return "warn";
		case YGLogLevelInfo:
		  return "info";
		case YGLogLevelDebug:
		  return "debug";
		case YGLogLevelVerbose:
		  return "verbose";
		case YGLogLevelFatal:
		  return "fatal";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGMeasureMode
	{
		YGMeasureModeUndefined, YGMeasureModeExactly, YGMeasureModeAtMost
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGMeasureModeToString(YGMeasureMode value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGMeasureModeUndefined:
		  return "undefined";
		case YGMeasureModeExactly:
		  return "exactly";
		case YGMeasureModeAtMost:
		  return "at-most";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGNodeType
	{
		YGNodeTypeDefault, YGNodeTypeText
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGNodeTypeToString(YGNodeType value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGNodeTypeDefault:
		  return "default";
		case YGNodeTypeText:
		  return "text";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGOverflow
	{
		YGOverflowVisible, YGOverflowHidden, YGOverflowScroll
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGOverflowToString(YGOverflow value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGOverflowVisible:
		  return "visible";
		case YGOverflowHidden:
		  return "hidden";
		case YGOverflowScroll:
		  return "scroll";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGPositionType
	{
		YGPositionTypeStatic, YGPositionTypeRelative, YGPositionTypeAbsolute
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGPositionTypeToString(YGPositionType value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGPositionTypeStatic:
		  return "static";
		case YGPositionTypeRelative:
		  return "relative";
		case YGPositionTypeAbsolute:
		  return "absolute";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGPrintOptions
	{
		YGPrintOptionsLayout = 1, YGPrintOptionsStyle = 2, YGPrintOptionsChildren = 4
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGPrintOptionsToString(YGPrintOptions value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGPrintOptionsLayout:
		  return "layout";
		case YGPrintOptionsStyle:
		  return "style";
		case YGPrintOptionsChildren:
		  return "children";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGUnit
	{
		YGUnitUndefined, YGUnitPoint, YGUnitPercent, YGUnitAuto
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGUnitToString(YGUnit value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGUnitUndefined:
		  return "undefined";
		case YGUnitPoint:
		  return "point";
		case YGUnitPercent:
		  return "percent";
		case YGUnitAuto:
		  return "auto";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
	public enum YGWrap
	{
		YGWrapNoWrap, YGWrapWrap, YGWrapWrapReverse
	}
//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	
	public static String YGWrapToString(YGWrap value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGWrapNoWrap:
		  return "no-wrap";
		case YGWrapWrap:
		  return "wrap";
		case YGWrapWrapReverse:
		  return "wrap-reverse";
	  }
	  return "unknown";
	}



	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#undefine YG_ENUM_DECL
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#undefine YG_ENUM_SEQ_DECL

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


	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if __cplusplus


//C++ TO JAVA CONVERTER WARNING: The following constructor is declared outside of its associated class:
	public static YGNode() //Method definition originates from: YGNode.h
	{
		this.YGNode = YGConfigGetDefault();
	}

 // Yoga specific properties, not compatible with flexbox specification

	 private boolean equalsTo(YGStyle ConversionHelpers.getValueFromOperator(lhs), YGStyle ConversionHelpers.getValueFromOperator(rhs)) //Method definition originates from: YGStyle.cpp
	 {
	   boolean areNonFloatValuesEqual = ConversionHelpers.getValueFromOperator(lhs).direction() == ConversionHelpers.getValueFromOperator(rhs).direction() && ConversionHelpers.getValueFromOperator(lhs).flexDirection() == ConversionHelpers.getValueFromOperator(rhs).flexDirection() && ConversionHelpers.getValueFromOperator(lhs).justifyContent() == ConversionHelpers.getValueFromOperator(rhs).justifyContent() && ConversionHelpers.getValueFromOperator(lhs).alignContent() == ConversionHelpers.getValueFromOperator(rhs).alignContent() && ConversionHelpers.getValueFromOperator(lhs).alignItems() == ConversionHelpers.getValueFromOperator(rhs).alignItems() && ConversionHelpers.getValueFromOperator(lhs).alignSelf() == ConversionHelpers.getValueFromOperator(rhs).alignSelf() && ConversionHelpers.getValueFromOperator(lhs).positionType() == ConversionHelpers.getValueFromOperator(rhs).positionType() && ConversionHelpers.getValueFromOperator(lhs).flexWrap() == ConversionHelpers.getValueFromOperator(rhs).flexWrap() && ConversionHelpers.getValueFromOperator(lhs).overflow() == ConversionHelpers.getValueFromOperator(rhs).overflow() && ConversionHelpers.getValueFromOperator(lhs).display() == ConversionHelpers.getValueFromOperator(rhs).display() && YGValueEqual(ConversionHelpers.getValueFromOperator(lhs).flexBasis(), ConversionHelpers.getValueFromOperator(rhs).flexBasis()) && ConversionHelpers.getValueFromOperator(lhs).margin() == ConversionHelpers.getValueFromOperator(rhs).margin() && ConversionHelpers.getValueFromOperator(lhs).position() == ConversionHelpers.getValueFromOperator(rhs).position() && ConversionHelpers.getValueFromOperator(lhs).padding() == ConversionHelpers.getValueFromOperator(rhs).padding() && ConversionHelpers.getValueFromOperator(lhs).border() == ConversionHelpers.getValueFromOperator(rhs).border() && ConversionHelpers.getValueFromOperator(lhs).dimensions() == ConversionHelpers.getValueFromOperator(rhs).dimensions() && ConversionHelpers.getValueFromOperator(lhs).minDimensions() == ConversionHelpers.getValueFromOperator(rhs).minDimensions() && ConversionHelpers.getValueFromOperator(lhs).maxDimensions() == ConversionHelpers.getValueFromOperator(rhs).maxDimensions();

	   areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).flex().isUndefined() == ConversionHelpers.getValueFromOperator(rhs).flex().isUndefined();
	   if (areNonFloatValuesEqual && !ConversionHelpers.getValueFromOperator(lhs).flex().isUndefined() && !ConversionHelpers.getValueFromOperator(rhs).flex().isUndefined())
	   {
		 areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).flex() == ConversionHelpers.getValueFromOperator(rhs).flex();
	   }

	   areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).flexGrow().isUndefined() == ConversionHelpers.getValueFromOperator(rhs).flexGrow().isUndefined();
	   if (areNonFloatValuesEqual && !ConversionHelpers.getValueFromOperator(lhs).flexGrow().isUndefined())
	   {
		 areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).flexGrow() == ConversionHelpers.getValueFromOperator(rhs).flexGrow();
	   }

	   areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).flexShrink().isUndefined() == ConversionHelpers.getValueFromOperator(rhs).flexShrink().isUndefined();
	   if (areNonFloatValuesEqual && !ConversionHelpers.getValueFromOperator(rhs).flexShrink().isUndefined())
	   {
		 areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).flexShrink() == ConversionHelpers.getValueFromOperator(rhs).flexShrink();
	   }

	   if (!(ConversionHelpers.getValueFromOperator(lhs).aspectRatio().isUndefined() && ConversionHelpers.getValueFromOperator(rhs).aspectRatio().isUndefined()))
	   {
		 areNonFloatValuesEqual = areNonFloatValuesEqual && ConversionHelpers.getValueFromOperator(lhs).aspectRatio() == ConversionHelpers.getValueFromOperator(rhs).aspectRatio();
	   }

	   return areNonFloatValuesEqual;
	 }

	 private boolean notEqualsTo(YGStyle ConversionHelpers.getValueFromOperator(lhs), YGStyle ConversionHelpers.getValueFromOperator(rhs))
	 {
	  return !(ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs));
	 }

//#endif

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



	// Not defined in MSVC++
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if ! NAN
	public static int __nan = 0x7fc00000;

//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	// extern YGValue YGValueAuto;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	// extern YGValue YGValueUndefined;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	// extern YGValue YGValueZero;

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if __cplusplus

	private boolean equalsTo(YGValue ConversionHelpers.getValueFromOperator(lhs), YGValue ConversionHelpers.getValueFromOperator(rhs))
	{
	  if (ConversionHelpers.getValueFromOperator(lhs).unit != ConversionHelpers.getValueFromOperator(rhs).unit)
	  {
		return false;
	  }

	  switch (ConversionHelpers.getValueFromOperator(lhs).unit)
	  {
		case YGUnitUndefined:
		case YGUnitAuto:
		  return true;
		case YGUnitPoint:
		case YGUnitPercent:
		  return ConversionHelpers.getValueFromOperator(lhs).value == ConversionHelpers.getValueFromOperator(rhs).value;
	  }

	  return false;
	}

	private boolean notEqualsTo(YGValue ConversionHelpers.getValueFromOperator(lhs), YGValue ConversionHelpers.getValueFromOperator(rhs))
	{
	  return !(ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs));
	}

	private YGValue subtract(YGValue value)
	{
	  return new YGValue(-value.value, value.unit);
	}


	//#endif


	public static YGValue YGValueZero = new YGValue(0, YGUnitPoint);
	public static YGValue YGValueUndefined = new YGValue((*(float*) __nan), YGUnitUndefined);
	public static YGValue YGValueAuto = new YGValue((*(float*) __nan), YGUnitAuto);





	// YGNode
	 public static YGNode YGNodeNew() //Method definition originates from: Yoga.cpp
	 {
	  return YGNodeNewWithConfig(YGConfigGetDefault());
	 }

	 public static YGNode YGNodeNewWithConfig(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	 YGNode node = new YGNode((config));
	 YGAssertWithConfig(config, node != null, "Could not allocate memory for node");
	 Event.<Event.NodeAllocation>publish(node, {config});

	 return node;
	 }

	 public static YGNode YGNodeClone(YGNode oldNode) //Method definition originates from: Yoga.cpp
	 {
	  YGNode node = new YGNode(oldNode);
	  YGAssertWithConfig(oldNode.getConfig(), node != null, "Could not allocate memory for node");
	  Event.<Event.NodeAllocation>publish(node, {node.getConfig()});
	  node.setOwner(null);
	  return node;
	 }

	 public static void YGNodeFree(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  if (struct YGNode * owner = node.getOwner())
	  {
		owner.removeChild(node);
		node.setOwner(null);
	  }

	  int childCount = YGNodeGetChildCount(node);
	  for (int i = 0; i < childCount; i++)
	  {
		YGNode child = YGNodeGetChild(node, new int(i));
		child.setOwner(null);
	  }

	  node.clearChildren();
	  Event.<Event.NodeDeallocation>publish(node, {node.getConfig()});
	  if (node != null)
	  {
	  node.close();
	  }
	 }

	 public static void YGNodeFreeRecursiveWithCleanupFunc(YGNode root, YGNodeCleanupFunc cleanup) //Method definition originates from: Yoga.cpp
	 {
	  int skipped = 0;
	  while (YGNodeGetChildCount(root) > skipped)
	  {
		YGNode child = YGNodeGetChild(root, new int(skipped));
		if (child.getOwner() != root)
		{
		  // Don't free shared nodes that we don't own.
		  skipped += 1;
		}
		else
		{
		  YGNodeRemoveChild(root, child);
		  YGNodeFreeRecursive(child);
		}
	  }
	  if (cleanup != null)
	  {
		cleanup.invoke(root);
	  }
	  YGNodeFree(root);
	 }

	 public static void YGNodeFreeRecursive(YGNode root) //Method definition originates from: Yoga.cpp
	 {
	  return YGNodeFreeRecursiveWithCleanupFunc(root, null);
	 }

	 public static void YGNodeReset(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  node.reset();
	 }

	 public static void YGNodeInsertChild(YGNode owner, YGNode child, int index) //Method definition originates from: Yoga.cpp
	 {
	  YGAssertWithNode(owner, child.getOwner() == null, "Child already has a owner, it must be removed first.");

	  YGAssertWithNode(owner, !owner.hasMeasureFunc(), "Cannot add child: Nodes with measure functions cannot have children.");

	  owner.insertChild(child, new int(index));
	  child.setOwner(owner);
	  owner.markDirtyAndPropogate();
	 }

	 public static void YGNodeSwapChild(YGNode owner, YGNode child, int index) //Method definition originates from: Yoga.cpp
	 {
	  owner.replaceChild(child, new int(index));
	  child.setOwner(owner);
	 }

	 public static void YGNodeRemoveChild(YGNode owner, YGNode excludedChild) //Method definition originates from: Yoga.cpp
	 {
	  if (YGNodeGetChildCount(owner) == 0)
	  {
		// This is an empty set. Nothing to remove.
		return;
	  }

	  // Children may be shared between parents, which is indicated by not having an
	  // owner. We only want to reset the child completely if it is owned
	  // exclusively by one node.
	  var childOwner = excludedChild.getOwner();
	  if (owner.removeChild(excludedChild))
	  {
		if (owner == childOwner)
		{
		  excludedChild.setLayout(new YGLayout()); // layout is no longer valid
		  excludedChild.setOwner(null);
		}
		owner.markDirtyAndPropogate();
	  }
	 }

	 public static void YGNodeRemoveAllChildren(YGNode owner) //Method definition originates from: Yoga.cpp
	 {
	  int childCount = YGNodeGetChildCount(owner);
	  if (childCount == 0)
	  {
		// This is an empty set already. Nothing to do.
		return;
	  }
	  YGNode firstChild = YGNodeGetChild(owner, 0);
	  if (firstChild.getOwner() == owner)
	  {
		// If the first child has this node as its owner, we assume that this child
		// set is unique.
		for (int i = 0; i < childCount; i++)
		{
		  YGNode oldChild = YGNodeGetChild(owner, new int(i));
		  oldChild.setLayout((new YGNode()).getLayout()); // layout is no longer valid
		  oldChild.setOwner(null);
		}
		owner.clearChildren();
		owner.markDirtyAndPropogate();
		return;
	  }
	  // Otherwise, we are not the owner of the child set. We don't have to do
	  // anything to clear it.
	  owner.setChildren(YGVector());
	  owner.markDirtyAndPropogate();
	 }

	 public static YGNode YGNodeGetChild(YGNode node, int index) //Method definition originates from: Yoga.cpp
	 {
	  if (index < node.getChildren().size())
	  {
		return node.getChild(new int(index));
	  }
	  return null;
	 }

	 public static YGNode YGNodeGetOwner(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getOwner();
	 }

	 public static YGNode YGNodeGetParent(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getOwner();
	 }

	 public static int YGNodeGetChildCount(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return (int)(node.getChildren().size());
	 }

	 public static void YGNodeSetChildren(YGNode owner, YGNode[] c, int count) //Method definition originates from: Yoga.cpp
	 {
	  ArrayList<YGNode> children = new ArrayList<YGNode>(Arrays.asList(c, c + count));
	  YGNodeSetChildrenInternal(owner, children);
	 }

	 public static void YGNodeSetIsReferenceBaseline(YGNode node, boolean isReferenceBaseline) //Method definition originates from: Yoga.cpp
	 {
	  if (node.isReferenceBaseline() != isReferenceBaseline)
	  {
		node.setIsReferenceBaseline(isReferenceBaseline);
		node.markDirtyAndPropogate();
	  }
	 }

	 public static boolean YGNodeIsReferenceBaseline(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.isReferenceBaseline();
	 }

	 public static void YGNodeCalculateLayout(YGNode node, float ownerWidth, float ownerHeight, YGDirection ownerDirection) //Method definition originates from: Yoga.cpp
	 {
	  YGNodeCalculateLayoutWithContext(node, ownerWidth, ownerHeight, new YGDirection(ownerDirection), null);
	 }

	// Mark a node as dirty. Only valid for nodes with a custom measure function
	// set.
	//
	// Yoga knows when to mark all other nodes as dirty but because nodes with
	// measure functions depend on information not known to Yoga they must perform
	// this dirty marking manually.
	 public static void YGNodeMarkDirty(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  YGAssertWithNode(node, node.hasMeasureFunc(), "Only leaf nodes with custom measure functions" + "should manually mark themselves as dirty");

	  node.markDirtyAndPropogate();
	 }

	// Marks the current node and all its descendants as dirty.
	//
	// Intended to be used for Yoga benchmarks. Don't use in production, as calling
	// `YGCalculateLayout` will cause the recalculation of each and every node.
	 public static void YGNodeMarkDirtyAndPropogateToDescendants(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.markDirtyAndPropogateDownwards();
	 }

	 public static void YGNodePrint(YGNode node, YGPrintOptions options) //Method definition originates from: Yoga.cpp
	 {
	  YGNodePrintInternal(node, new YGPrintOptions(options));
	 }

	 public static boolean YGFloatIsUndefined(float value) //Method definition originates from: Yoga.cpp
	 {
	  return facebook.yoga.isUndefined(value);
	 }

	 public static boolean YGNodeCanUseCachedMeasurement(YGMeasureMode widthMode, float width, YGMeasureMode heightMode, float height, YGMeasureMode lastWidthMode, float lastWidth, YGMeasureMode lastHeightMode, float lastHeight, float lastComputedWidth, float lastComputedHeight, float marginRow, float marginColumn, YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	  if ((!YGFloatIsUndefined(lastComputedHeight) && lastComputedHeight < 0F) || (!YGFloatIsUndefined(lastComputedWidth) && lastComputedWidth < 0F))
	  {
		return false;
	  }
	  boolean useRoundedComparison = config != null && config.pointScaleFactor != 0F;
	  float effectiveWidth = useRoundedComparison ? YGRoundValueToPixelGrid(width, config.pointScaleFactor, false, false) : width;
	  float effectiveHeight = useRoundedComparison ? YGRoundValueToPixelGrid(height, config.pointScaleFactor, false, false) : height;
	  float effectiveLastWidth = useRoundedComparison ? YGRoundValueToPixelGrid(lastWidth, config.pointScaleFactor, false, false) : lastWidth;
	  float effectiveLastHeight = useRoundedComparison ? YGRoundValueToPixelGrid(lastHeight, config.pointScaleFactor, false, false) : lastHeight;

	  boolean hasSameWidthSpec = lastWidthMode == widthMode && YGFloatsEqual(effectiveLastWidth, effectiveWidth);
	  boolean hasSameHeightSpec = lastHeightMode == heightMode && YGFloatsEqual(effectiveLastHeight, effectiveHeight);

	  boolean widthIsCompatible = hasSameWidthSpec || YGMeasureModeSizeIsExactAndMatchesOldMeasuredSize(new YGMeasureMode(widthMode), width - marginRow, lastComputedWidth) || YGMeasureModeOldSizeIsUnspecifiedAndStillFits(new YGMeasureMode(widthMode), width - marginRow, new YGMeasureMode(lastWidthMode), lastComputedWidth) || YGMeasureModeNewMeasureSizeIsStricterAndStillValid(new YGMeasureMode(widthMode), width - marginRow, new YGMeasureMode(lastWidthMode), lastWidth, lastComputedWidth);

	  boolean heightIsCompatible = hasSameHeightSpec || YGMeasureModeSizeIsExactAndMatchesOldMeasuredSize(new YGMeasureMode(heightMode), height - marginColumn, lastComputedHeight) || YGMeasureModeOldSizeIsUnspecifiedAndStillFits(new YGMeasureMode(heightMode), height - marginColumn, new YGMeasureMode(lastHeightMode), lastComputedHeight) || YGMeasureModeNewMeasureSizeIsStricterAndStillValid(new YGMeasureMode(heightMode), height - marginColumn, new YGMeasureMode(lastHeightMode), lastHeight, lastComputedHeight);

	  return widthIsCompatible && heightIsCompatible;
	 }

	 public static void YGNodeCopyStyle(YGNode dstNode, YGNode srcNode) //Method definition originates from: Yoga.cpp
	 {
	  if (!(dstNode.getStyle() == srcNode.getStyle()))
	  {
		dstNode.setStyle(srcNode.getStyle());
		dstNode.markDirtyAndPropogate();
	  }
	 }

	 public static Object YGNodeGetContext(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getContext();
	 }

	 public static void YGNodeSetContext(YGNode node, Object context) //Method definition originates from: Yoga.cpp
	 {
	  return node.setContext(context);
	 }

	public static void YGConfigSetPrintTreeFlag(YGConfig config, boolean enabled) //Method definition originates from: Yoga.cpp
	{
	 config.printTree = enabled;
	}

	public static boolean YGNodeHasMeasureFunc(YGNode node) //Method definition originates from: Yoga.cpp
	{
	 return node.hasMeasureFunc();
	}

	 public static void YGNodeSetMeasureFunc(YGNode node, YGMeasureFunc measureFunc) //Method definition originates from: Yoga.cpp
	 {
	  node.setMeasureFunc(measureFunc);
	 }

	public static boolean YGNodeHasBaselineFunc(YGNode node) //Method definition originates from: Yoga.cpp
	{
	 return node.hasBaselineFunc();
	}

	public static void YGNodeSetBaselineFunc(YGNode node, YGBaselineFunc baselineFunc) //Method definition originates from: Yoga.cpp
	{
	 node.setBaselineFunc(baselineFunc);
	}

	public static YGDirtiedFunc YGNodeGetDirtiedFunc(YGNode node) //Method definition originates from: Yoga.cpp
	{
	 return node.getDirtied();
	}

	public static void YGNodeSetDirtiedFunc(YGNode node, YGDirtiedFunc dirtiedFunc) //Method definition originates from: Yoga.cpp
	{
	 node.setDirtiedFunc(dirtiedFunc);
	}

	public static void YGNodeSetPrintFunc(YGNode node, YGPrintFunc printFunc) //Method definition originates from: Yoga.cpp
	{
	 node.setPrintFunc(printFunc);
	}

	 public static boolean YGNodeGetHasNewLayout(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getHasNewLayout();
	 }

	 public static void YGNodeSetHasNewLayout(YGNode node, boolean hasNewLayout) //Method definition originates from: Yoga.cpp
	 {
	  node.setHasNewLayout(hasNewLayout);
	 }

	public static YGNodeType YGNodeGetNodeType(YGNode node) //Method definition originates from: Yoga.cpp
	{
	 return new YGNodeType(node.getNodeType());
	}

	public static void YGNodeSetNodeType(YGNode node, YGNodeType nodeType) //Method definition originates from: Yoga.cpp
	{
	 return node.setNodeType(nodeType);
	}

	 public static boolean YGNodeIsDirty(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.isDirty();
	 }

	public static boolean YGNodeLayoutGetDidUseLegacyFlag(YGNode node) //Method definition originates from: Yoga.cpp
	{
	 return node.didUseLegacyFlag();
	}

	 public static void YGNodeStyleSetDirection(YGNode node, YGDirection value) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).direction())>updateStyle(node, YGStyle.direction, value);
	 }

	 public static YGDirection YGNodeStyleGetDirection(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGDirection(node.getStyle().direction());
	 }

	 public static void YGNodeStyleSetFlexDirection(YGNode node, YGFlexDirection flexDirection) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).flexDirection())>updateStyle(node, YGStyle.flexDirection, flexDirection);
	 }

	 public static YGFlexDirection YGNodeStyleGetFlexDirection(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGFlexDirection(node.getStyle().flexDirection());
	 }

	 public static void YGNodeStyleSetJustifyContent(YGNode node, YGJustify justifyContent) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).justifyContent())>updateStyle(node, YGStyle.justifyContent, justifyContent);
	 }

	 public static YGJustify YGNodeStyleGetJustifyContent(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGJustify(node.getStyle().justifyContent());
	 }

	 public static void YGNodeStyleSetAlignContent(YGNode node, YGAlign alignContent) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).alignContent())>updateStyle(node, YGStyle.alignContent, alignContent);
	 }

	 public static YGAlign YGNodeStyleGetAlignContent(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGAlign(node.getStyle().alignContent());
	 }

	 public static void YGNodeStyleSetAlignItems(YGNode node, YGAlign alignItems) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).alignItems())>updateStyle(node, YGStyle.alignItems, alignItems);
	 }

	 public static YGAlign YGNodeStyleGetAlignItems(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGAlign(node.getStyle().alignItems());
	 }

	 public static void YGNodeStyleSetAlignSelf(YGNode node, YGAlign alignSelf) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).alignSelf())>updateStyle(node, YGStyle.alignSelf, alignSelf);
	 }

	 public static YGAlign YGNodeStyleGetAlignSelf(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGAlign(node.getStyle().alignSelf());
	 }

	 public static void YGNodeStyleSetPositionType(YGNode node, YGPositionType positionType) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).positionType())>updateStyle(node, YGStyle.positionType, positionType);
	 }

	 public static YGPositionType YGNodeStyleGetPositionType(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGPositionType(node.getStyle().positionType());
	 }

	 public static void YGNodeStyleSetFlexWrap(YGNode node, YGWrap flexWrap) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).flexWrap())>updateStyle(node, YGStyle.flexWrap, flexWrap);
	 }

	 public static YGWrap YGNodeStyleGetFlexWrap(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGWrap(node.getStyle().flexWrap());
	 }

	 public static void YGNodeStyleSetOverflow(YGNode node, YGOverflow overflow) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).overflow())>updateStyle(node, YGStyle.overflow, overflow);
	 }

	 public static YGOverflow YGNodeStyleGetOverflow(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGOverflow(node.getStyle().overflow());
	 }

	 public static void YGNodeStyleSetDisplay(YGNode node, YGDisplay display) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).display())>updateStyle(node, YGStyle.display, display);
	 }

	 public static YGDisplay YGNodeStyleGetDisplay(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return new YGDisplay(node.getStyle().display());
	 }

// TODO(T26792433): Change the API to accept YGFloatOptional.

	 public static void YGNodeStyleSetFlex(YGNode node, float flex) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).flex())>updateStyle(node, YGStyle.flex, new YGFloatOptional(flex));
	 }

// TODO(T26792433): Change the API to accept YGFloatOptional.

	 public static float YGNodeStyleGetFlex(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().flex().isUndefined() ? ((float) __nan) : node.getStyle().flex().unwrap();
	 }

// TODO(T26792433): Change the API to accept YGFloatOptional.

	 public static void YGNodeStyleSetFlexGrow(YGNode node, float flexGrow) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).flexGrow())>updateStyle(node, YGStyle.flexGrow, new YGFloatOptional(flexGrow));
	 }

	 public static float YGNodeStyleGetFlexGrow(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().flexGrow().isUndefined() ? kDefaultFlexGrow : node.getStyle().flexGrow().unwrap();
	 }

// TODO(T26792433): Change the API to accept YGFloatOptional.

	 public static void YGNodeStyleSetFlexShrink(YGNode node, float flexShrink) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).flexShrink())>updateStyle(node, YGStyle.flexShrink, new YGFloatOptional(flexShrink));
	 }

	 public static float YGNodeStyleGetFlexShrink(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().flexShrink().isUndefined() ? (node.getConfig().useWebDefaults ? kWebDefaultFlexShrink : kDefaultFlexShrink) : node.getStyle().flexShrink().unwrap();
	 }

	 public static void YGNodeStyleSetFlexBasis(YGNode node, float flexBasis) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(flexBasis);
	  GlobalMembers.<decltype((new YGStyle(())).flexBasis())>updateStyle(node, YGStyle.flexBasis, value);
	 }

	 public static void YGNodeStyleSetFlexBasisPercent(YGNode node, float flexBasisPercent) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(flexBasisPercent);
	  GlobalMembers.<decltype((new YGStyle(())).flexBasis())>updateStyle(node, YGStyle.flexBasis, value);
	 }

	 public static void YGNodeStyleSetFlexBasisAuto(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).flexBasis())>updateStyle(node, YGStyle.flexBasis, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetFlexBasis(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  YGValue flexBasis = node.getStyle().flexBasis();
	  if (flexBasis.unit == YGUnitUndefined || flexBasis.unit == YGUnitAuto)
	  {
		// TODO(T26792433): Get rid off the use of YGUndefined at client side
		flexBasis.value = ((float) __nan);
	  }
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexBasis;
	  return new YGValue(flexBasis);
	 }

	 public static void YGNodeStyleSetPosition(YGNode node, YGEdge edge, float points) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(points);
	  GlobalMembers.<decltype((new YGStyle(())).position())>updateIndexedStyleProp(node, YGStyle.position, edge, value);
	 }

	 public static void YGNodeStyleSetPositionPercent(YGNode node, YGEdge edge, float percent) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(percent);
	  GlobalMembers.<decltype((new YGStyle(())).position())>updateIndexedStyleProp(node, YGStyle.position, edge, value);
	 }

	 public static YGValue YGNodeStyleGetPosition(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().position().get(edge);
	 }

	 public static void YGNodeStyleSetMargin(YGNode node, YGEdge edge, float points) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(points);
	  GlobalMembers.<decltype((new YGStyle(())).margin())>updateIndexedStyleProp(node, YGStyle.margin, edge, value);
	 }

	 public static void YGNodeStyleSetMarginPercent(YGNode node, YGEdge edge, float percent) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(percent);
	  GlobalMembers.<decltype((new YGStyle(())).margin())>updateIndexedStyleProp(node, YGStyle.margin, edge, value);
	 }

	 public static void YGNodeStyleSetMarginAuto(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).margin())>updateIndexedStyleProp(node, YGStyle.margin, edge, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetMargin(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().margin().get(edge);
	 }

	 public static void YGNodeStyleSetPadding(YGNode node, YGEdge edge, float points) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(points);
	  GlobalMembers.<decltype((new YGStyle(())).padding())>updateIndexedStyleProp(node, YGStyle.padding, edge, value);
	 }

	 public static void YGNodeStyleSetPaddingPercent(YGNode node, YGEdge edge, float percent) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(percent);
	  GlobalMembers.<decltype((new YGStyle(())).padding())>updateIndexedStyleProp(node, YGStyle.padding, edge, value);
	 }

	 public static YGValue YGNodeStyleGetPadding(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().padding().get(edge);
	 }

// TODO(T26792433): Change the API to accept YGFloatOptional.

	 public static void YGNodeStyleSetBorder(YGNode node, YGEdge edge, float border) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(border);
	  GlobalMembers.<decltype((new YGStyle(())).border())>updateIndexedStyleProp(node, YGStyle.border, edge, value);
	 }

	 public static float YGNodeStyleGetBorder(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	  var border = node.getStyle().border().get(edge);
	  if (border.isUndefined() || border.isAuto())
	  {
		// TODO(T26792433): Rather than returning YGUndefined, change the api to
		// return YGFloatOptional.
		return ((float) __nan);
	  }

	  return ((YGValue)border).value;
	 }

	 public static void YGNodeStyleSetWidth(YGNode node, float points) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(points);
	  GlobalMembers.<decltype((new YGStyle(())).dimensions())>updateIndexedStyleProp(node, YGStyle.dimensions, YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetWidthPercent(YGNode node, float percent) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(percent);
	  GlobalMembers.<decltype((new YGStyle(())).dimensions())>updateIndexedStyleProp(node, YGStyle.dimensions, YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetWidthAuto(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).dimensions())>updateIndexedStyleProp(node, YGStyle.dimensions, YGDimensionWidth, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetWidth(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().dimensions().get(YGDimensionWidth);
	 }

	 public static void YGNodeStyleSetHeight(YGNode node, float points) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(points);
	  GlobalMembers.<decltype((new YGStyle(())).dimensions())>updateIndexedStyleProp(node, YGStyle.dimensions, YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetHeightPercent(YGNode node, float percent) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(percent);
	  GlobalMembers.<decltype((new YGStyle(())).dimensions())>updateIndexedStyleProp(node, YGStyle.dimensions, YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetHeightAuto(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).dimensions())>updateIndexedStyleProp(node, YGStyle.dimensions, YGDimensionHeight, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetHeight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().dimensions().get(YGDimensionHeight);
	 }

	 public static void YGNodeStyleSetMinWidth(YGNode node, float minWidth) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(minWidth);
	  GlobalMembers.<decltype((new YGStyle(())).minDimensions())>updateIndexedStyleProp(node, YGStyle.minDimensions, YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetMinWidthPercent(YGNode node, float minWidth) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(minWidth);
	  GlobalMembers.<decltype((new YGStyle(())).minDimensions())>updateIndexedStyleProp(node, YGStyle.minDimensions, YGDimensionWidth, value);
	 }

	 public static YGValue YGNodeStyleGetMinWidth(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().minDimensions().get(YGDimensionWidth);
	 }

	 public static void YGNodeStyleSetMinHeight(YGNode node, float minHeight) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(minHeight);
	  GlobalMembers.<decltype((new YGStyle(())).minDimensions())>updateIndexedStyleProp(node, YGStyle.minDimensions, YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetMinHeightPercent(YGNode node, float minHeight) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(minHeight);
	  GlobalMembers.<decltype((new YGStyle(())).minDimensions())>updateIndexedStyleProp(node, YGStyle.minDimensions, YGDimensionHeight, value);
	 }

	 public static YGValue YGNodeStyleGetMinHeight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().minDimensions().get(YGDimensionHeight);
	 }

	 public static void YGNodeStyleSetMaxWidth(YGNode node, float maxWidth) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(maxWidth);
	  GlobalMembers.<decltype((new YGStyle(())).maxDimensions())>updateIndexedStyleProp(node, YGStyle.maxDimensions, YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetMaxWidthPercent(YGNode node, float maxWidth) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(maxWidth);
	  GlobalMembers.<decltype((new YGStyle(())).maxDimensions())>updateIndexedStyleProp(node, YGStyle.maxDimensions, YGDimensionWidth, value);
	 }

	 public static YGValue YGNodeStyleGetMaxWidth(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().maxDimensions().get(YGDimensionWidth);
	 }

	 public static void YGNodeStyleSetMaxHeight(YGNode node, float maxHeight) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPoint>ofMaybe(maxHeight);
	  GlobalMembers.<decltype((new YGStyle(())).maxDimensions())>updateIndexedStyleProp(node, YGStyle.maxDimensions, YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetMaxHeightPercent(YGNode node, float maxHeight) //Method definition originates from: Yoga.cpp
	 {
	  var value = detail.CompactValue.<YGUnitPercent>ofMaybe(maxHeight);
	  GlobalMembers.<decltype((new YGStyle(())).maxDimensions())>updateIndexedStyleProp(node, YGStyle.maxDimensions, YGDimensionHeight, value);
	 }

	 public static YGValue YGNodeStyleGetMaxHeight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  return node.getStyle().maxDimensions().get(YGDimensionHeight);
	 }

// TODO(T26792433): Change the API to accept YGFloatOptional.

	// Yoga specific properties, not compatible with flexbox specification Aspect
	// ratio control the size of the undefined dimension of a node. Aspect ratio is
	// encoded as a floating point value width/height. e.g. A value of 2 leads to a
	// node with a width twice the size of its height while a value of 0.5 gives the
	// opposite effect.
	//
	// - On a node with a set width/height aspect ratio control the size of the
	//   unset dimension
	// - On a node with a set flex basis aspect ratio controls the size of the node
	//   in the cross axis if unset
	// - On a node with a measure function aspect ratio works as though the measure
	//   function measures the flex basis
	// - On a node with flex grow/shrink aspect ratio controls the size of the node
	//   in the cross axis if unset
	// - Aspect ratio takes min/max dimensions into account
	 public static void YGNodeStyleSetAspectRatio(YGNode node, float aspectRatio) //Method definition originates from: Yoga.cpp
	 {
	  GlobalMembers.<decltype((new YGStyle(())).aspectRatio())>updateStyle(node, YGStyle.aspectRatio, new YGFloatOptional(aspectRatio));
	 }

// Yoga specific properties, not compatible with flexbox specification

// TODO(T26792433): Change the API to accept YGFloatOptional.

	 public static float YGNodeStyleGetAspectRatio(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	  YGFloatOptional op = node.getStyle().aspectRatio();
	  return op.isUndefined() ? ((float) __nan) : op.unwrap();
	 }

	 public static float YGNodeLayoutGetLeft(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position.get(YGEdgeLeft);
	 }

	 public static float YGNodeLayoutGetTop(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position.get(YGEdgeTop);
	 }

	 public static float YGNodeLayoutGetRight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position.get(YGEdgeRight);
	 }

	 public static float YGNodeLayoutGetBottom(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position.get(YGEdgeBottom);
	 }

	 public static float YGNodeLayoutGetWidth(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().dimensions.get(YGDimensionWidth);
	 }

	 public static float YGNodeLayoutGetHeight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().dimensions.get(YGDimensionHeight);
	 }

	 public static YGDirection YGNodeLayoutGetDirection(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return new YGDirection(node.getLayout().direction());
	 }

	 public static boolean YGNodeLayoutGetHadOverflow(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().hadOverflow();
	 }

	public static boolean YGNodeLayoutGetDidLegacyStretchFlagAffectLayout(YGNode node) //Method definition originates from: Yoga.cpp
	{
	 return node.getLayout().doesLegacyStretchFlagAffectsLayout();
	}

	// Get the computed values for these nodes after performing layout. If they were
	// set using point values then the returned value will be the same as
	// YGNodeStyleGetXXX. However if they were set using a percentage value then the
	// returned value is the computed value used during layout.
	 public static float YGNodeLayoutGetMargin(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
		 YGAssertWithNode(node, edge <= YGEdgeEnd, "Cannot get layout properties of multi-edge shorthands");
		 if (edge == YGEdgeStart)
		 {
			 if (node.getLayout().direction() == YGDirectionRTL)
			 {
				 return node.getLayout().margin.get(YGEdgeRight);
			 }
			 else
			 {
				 return node.getLayout().margin.get(YGEdgeLeft);
			 }
		 }
		 if (edge == YGEdgeEnd)
		 {
			 if (node.getLayout().direction() == YGDirectionRTL)
			 {
				 return node.getLayout().margin.get(YGEdgeLeft);
			 }
			 else
			 {
				 return node.getLayout().margin.get(YGEdgeRight);
			 }
		 }
		 return node.getLayout().margin.get(edge);
	 }

	 public static float YGNodeLayoutGetBorder(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
		 YGAssertWithNode(node, edge <= YGEdgeEnd, "Cannot get layout properties of multi-edge shorthands");
		 if (edge == YGEdgeStart)
		 {
			 if (node.getLayout().direction() == YGDirectionRTL)
			 {
				 return node.getLayout().border.get(YGEdgeRight);
			 }
			 else
			 {
				 return node.getLayout().border.get(YGEdgeLeft);
			 }
		 }
		 if (edge == YGEdgeEnd)
		 {
			 if (node.getLayout().direction() == YGDirectionRTL)
			 {
				 return node.getLayout().border.get(YGEdgeLeft);
			 }
			 else
			 {
				 return node.getLayout().border.get(YGEdgeRight);
			 }
		 }
		 return node.getLayout().border.get(edge);
	 }

	 public static float YGNodeLayoutGetPadding(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
		 YGAssertWithNode(node, edge <= YGEdgeEnd, "Cannot get layout properties of multi-edge shorthands");
		 if (edge == YGEdgeStart)
		 {
			 if (node.getLayout().direction() == YGDirectionRTL)
			 {
				 return node.getLayout().padding.get(YGEdgeRight);
			 }
			 else
			 {
				 return node.getLayout().padding.get(YGEdgeLeft);
			 }
		 }
		 if (edge == YGEdgeEnd)
		 {
			 if (node.getLayout().direction() == YGDirectionRTL)
			 {
				 return node.getLayout().padding.get(YGEdgeLeft);
			 }
			 else
			 {
				 return node.getLayout().padding.get(YGEdgeRight);
			 }
		 }
		 return node.getLayout().padding.get(edge);
	 }

	 public static void YGConfigSetLogger(YGConfig config, YGLogger logger) //Method definition originates from: Yoga.cpp
	 {
	  if (logger != null)
	  {
		config.setLogger(logger);
	  }
	  else
	  {
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if ANDROID
		config.setLogger(YGAndroidLog);
	//#else
		config.setLogger(YGDefaultLog);
	//#endif
	  }
	 }

	 public static void YGAssert(boolean condition, tangible.RefObject<String> message) //Method definition originates from: Yoga.cpp
	 {
	   if (!condition)
	   {
		 Log.log(YGNodeRef((null)), YGLogLevelFatal, null, "%s\n", message.argValue);
		 throwLogicalErrorWithMessage(message);
	   }
	 }

	 public static void YGAssertWithNode(YGNode node, boolean condition, tangible.RefObject<String> message) //Method definition originates from: Yoga.cpp
	 {
	   if (!condition)
	   {
		 Log.log(node, YGLogLevelFatal, null, "%s\n", message.argValue);
		 throwLogicalErrorWithMessage(message);
	   }
	 }

	 public static void YGAssertWithConfig(YGConfig config, boolean condition, tangible.RefObject<String> message) //Method definition originates from: Yoga.cpp
	 {
	   if (!condition)
	   {
		 Log.log(config, YGLogLevelFatal, null, "%s\n", message.argValue);
		 throwLogicalErrorWithMessage(message);
	   }
	 }

	// Set this to number of pixels in 1 point to round calculation results If you
	// want to avoid rounding - set PointScaleFactor to 0
	 public static void YGConfigSetPointScaleFactor(YGConfig config, float pixelsInPoint) //Method definition originates from: Yoga.cpp
	 {
	  YGAssertWithConfig(config, pixelsInPoint >= 0.0f, "Scale factor should not be less than zero");

	  // We store points for Pixel as we will use it for rounding
	  if (pixelsInPoint == 0.0f)
	  {
		// Zero is used to skip rounding
		config.pointScaleFactor = 0.0f;
	  }
	  else
	  {
		config.pointScaleFactor = pixelsInPoint;
	  }
	 }

	public static void YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(YGConfig config, boolean shouldDiffLayout) //Method definition originates from: Yoga.cpp
	{
	 config.shouldDiffLayoutWithoutLegacyStretchBehaviour = shouldDiffLayout;
	}

	// Yoga previously had an error where containers would take the maximum space
	// possible instead of the minimum like they are supposed to. In practice this
	// resulted in implicit behaviour similar to align-self: stretch; Because this
	// was such a long-standing bug we must allow legacy users to switch back to
	// this behaviour.
	 public static void YGConfigSetUseLegacyStretchBehaviour(YGConfig config, boolean useLegacyStretchBehaviour) //Method definition originates from: Yoga.cpp
	 {
	  config.useLegacyStretchBehaviour = useLegacyStretchBehaviour;
	 }

	// YGConfig
	 public static YGConfig YGConfigNew() //Method definition originates from: Yoga.cpp
	 {
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if ANDROID
	  YGConfig config = new YGConfig(YGAndroidLog);
	//#else
	  YGConfig config = new YGConfig(YGDefaultLog);
	//#endif
	  gConfigInstanceCount++;
	  return config;
	 }

	 public static void YGConfigFree(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	  config = null;
	  gConfigInstanceCount--;
	 }

	 public static void YGConfigCopy(YGConfig dest, YGConfig src) //Method definition originates from: Yoga.cpp
	 {
//C++ TO JAVA CONVERTER TODO TASK: The memory management function 'memcpy' has no equivalent in Java:
//C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'sizeof':
	   memcpy(dest, src, sizeof(YGConfig));
	 }

	 public static int32_t YGConfigGetInstanceCount() //Method definition originates from: Yoga.cpp
	 {
	   return new int32_t(gConfigInstanceCount);
	 }

	 public static void YGConfigSetExperimentalFeatureEnabled(YGConfig config, YGExperimentalFeature feature, boolean enabled) //Method definition originates from: Yoga.cpp
	 {
	  config.experimentalFeatures.set(feature, enabled);
	 }

	 public static boolean YGConfigIsExperimentalFeatureEnabled(YGConfig config, YGExperimentalFeature feature) //Method definition originates from: Yoga.cpp
	 {
	   return config.experimentalFeatures.get(feature);
	 }

	// Using the web defaults is the preferred configuration for new projects. Usage
	// of non web defaults should be considered as legacy.
	 public static void YGConfigSetUseWebDefaults(YGConfig config, boolean enabled) //Method definition originates from: Yoga.cpp
	 {
	  config.useWebDefaults = enabled;
	 }

	 public static boolean YGConfigGetUseWebDefaults(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	   return config.useWebDefaults;
	 }

	 public static void YGConfigSetCloneNodeFunc(YGConfig config, YGCloneNodeFunc callback) //Method definition originates from: Yoga.cpp
	 {
	  config.setCloneNodeCallback(callback);
	 }

	// Export only for C#
	//C++ TO JAVA CONVERTER NOTE: This was formerly a static local variable declaration (not allowed in Java):
	 public static YGConfigGetDefault_YGConfig defaultConfig = YGConfigNew();

	 public static YGConfig YGConfigGetDefault() //Method definition originates from: Yoga.cpp
	 {
	//C++ TO JAVA CONVERTER NOTE: This static local variable declaration (not allowed in Java) has been moved just prior to the method:
	//  static struct YGConfig* defaultConfig = YGConfigNew();
	  return defaultConfig;
	 }

	 public static void YGConfigSetContext(YGConfig config, Object context) //Method definition originates from: Yoga.cpp
	 {
	  config.context = context;
	 }

	 public static Object YGConfigGetContext(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	  return config.context;
	 }

	 public static float YGRoundValueToPixelGrid(double value, double pointScaleFactor, boolean forceCeil, boolean forceFloor) //Method definition originates from: Yoga.cpp
	 {
	  double scaledValue = value * pointScaleFactor;
	  // We want to calculate `fractial` such that `floor(scaledValue) = scaledValue
	  // - fractial`.
	  double fractial = fmod(scaledValue, 1.0);
	  if (fractial < 0)
	  {
		// This branch is for handling negative numbers for `value`.
		//
		// Regarding `floor` and `ceil`. Note that for a number x, `floor(x) <= x <=
		// ceil(x)` even for negative numbers. Here are a couple of examples:
		//   - x =  2.2: floor( 2.2) =  2, ceil( 2.2) =  3
		//   - x = -2.2: floor(-2.2) = -3, ceil(-2.2) = -2
		//
		// Regarding `fmodf`. For fractional negative numbers, `fmodf` returns a
		// negative number. For example, `fmodf(-2.2) = -0.2`. However, we want
		// `fractial` to be the number such that subtracting it from `value` will
		// give us `floor(value)`. In the case of negative numbers, adding 1 to
		// `fmodf(value)` gives us this. Let's continue the example from above:
		//   - fractial = fmodf(-2.2) = -0.2
		//   - Add 1 to the fraction: fractial2 = fractial + 1 = -0.2 + 1 = 0.8
		//   - Finding the `floor`: -2.2 - fractial2 = -2.2 - 0.8 = -3
		++fractial;
	  }
	  if (YGDoubleEqual(fractial, 0))
	  {
		// First we check if the value is already rounded
		scaledValue = scaledValue - fractial;
	  }
	  else if (YGDoubleEqual(fractial, 1.0))
	  {
		scaledValue = scaledValue - fractial + 1.0;
	  }
	  else if (forceCeil)
	  {
		// Next we check if we need to use forced rounding
		scaledValue = scaledValue - fractial + 1.0;
	  }
	  else if (forceFloor)
	  {
		scaledValue = scaledValue - fractial;
	  }
	  else
	  {
		// Finally we just round the value
		scaledValue = scaledValue - fractial + (!YGDoubleIsUndefined(fractial) && (fractial > 0.5 || YGDoubleEqual(fractial, 0.5)) ? 1.0 : 0.0);
	  }
	  return (YGDoubleIsUndefined(scaledValue) || YGDoubleIsUndefined(pointScaleFactor)) ? ((float) __nan) : (float)(scaledValue / pointScaleFactor);
	 }
@FunctionalInterface
interface voidDelegate
{
	std::function <invoke(YGNode node)>&& f;
}


	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if __cplusplus


	// Calls f on each node in the tree including the given node argument.
	public static void YGTraversePreOrder(YGNode node, voidDelegate void) //Method definition originates from: Yoga.cpp
	{
	  if (node == null)
	  {
		return;
	  }
	  f(node);
	  YGTraverseChildrenPreOrder(node.getChildren(), f);
	}

	public static void YGNodeSetChildren(YGNode owner, ArrayList<YGNode> children) //Method definition originates from: Yoga.cpp
	{
	 YGNodeSetChildrenInternal(owner, children);
	}

	//#endif

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if _MSC_VER

	/* define fmaxf if < VC12 */
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if _MSC_VER < 1800
	public static float fmaxf(float a, float b)
	{
	  return (a > b) ? a : b;
	}

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if ANDROID
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if ANDROID
	public static int YGAndroidLog(YGConfig config, YGNode node, YGLogLevel level, tangible.RefObject<String> format, va_list args) //Method definition originates from: Yoga.cpp
	{
	  int androidLevel = YGLogLevelDebug;
	  switch (level)
	  {
		case YGLogLevelFatal:
		  androidLevel = ANDROID_LOG_FATAL;
		  break;
		case YGLogLevelError:
		  androidLevel = ANDROID_LOG_ERROR;
		  break;
		case YGLogLevelWarn:
		  androidLevel = ANDROID_LOG_WARN;
		  break;
		case YGLogLevelInfo:
		  androidLevel = ANDROID_LOG_INFO;
		  break;
		case YGLogLevelDebug:
		  androidLevel = ANDROID_LOG_DEBUG;
		  break;
		case YGLogLevelVerbose:
		  androidLevel = ANDROID_LOG_VERBOSE;
		  break;
	  }
	  int result = __android_log_vprint(androidLevel, "yoga", format.argValue, args);
	  return result;
	}
	//#endif

	//#else
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if ! ANDROID
	//C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
	//ORIGINAL LINE: #define YG_UNUSED(x) (void) (x);
	public static int YGDefaultLog(YGConfig config, YGNode node, YGLogLevel level, tangible.RefObject<String> format, va_list args) //Method definition originates from: Yoga.cpp
	{
	   (config);
	   (node);
	  switch (level)
	  {
		case YGLogLevelError:
		case YGLogLevelFatal:
		  return vfprintf(stderr, format.argValue, args);
		case YGLogLevelWarn:
		case YGLogLevelInfo:
		case YGLogLevelDebug:
		case YGLogLevelVerbose:
		default:
		  return vprintf(format.argValue, args);
	  }
	}

	//#endif


	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#undefine YG_UNUSED
	//#endif

	public static boolean YGDoubleIsUndefined(double value)
	{
	  return facebook.yoga.isUndefined(value);
	}

	public static int32_t gConfigInstanceCount = 0;

	public static YGConfig YGConfigClone(YGConfig oldConfig)
	{
	  YGConfig config = new YGConfig(oldConfig);
	  YGAssert(config != null, "Could not allocate memory for config");
	  gConfigInstanceCount++;
	  return config;
	}

	public static YGNode YGNodeDeepClone(YGNode oldNode)
	{
	  var config = YGConfigClone(oldNode.getConfig());
	  var node = new YGNode((oldNode, config));
	  node.setOwner(null);
	  Event.<Event.NodeAllocation>publish(node, {node.getConfig()});

	  ArrayList<YGNode> vec = YGVector();
	  vec.ensureCapacity(oldNode.getChildren().size());
	  YGNode childNode = null;
//C++ TO JAVA CONVERTER NOTE: 'auto' variable declarations are not supported in Java:
//ORIGINAL LINE: for (auto* item : oldNode->getChildren())
	  for (var item : oldNode.getChildren())
	  {
		childNode = YGNodeDeepClone(item);
		childNode.setOwner(new YGNode(node));
		vec.add(childNode);
	  }
	  node.setChildren(vec);

	  return new YGNode(node);
	}

	public static void YGConfigFreeRecursive(YGNode root)
	{
	  if (root.getConfig() != null)
	  {
		gConfigInstanceCount--;
		root.getConfig() = null;
	  }
	  // Delete configs recursively for childrens
//C++ TO JAVA CONVERTER NOTE: 'auto' variable declarations are not supported in Java:
//ORIGINAL LINE: for (auto* child : root->getChildren())
	  for (var child : root.getChildren())
	  {
		YGConfigFreeRecursive(child);
	  }
	}

	public static void YGNodeSetChildrenInternal(YGNode owner, ArrayList<YGNode> children)
	{
	  if (owner == null)
	  {
		return;
	  }
	  if (children.size() == 0)
	  {
		if (YGNodeGetChildCount(owner) > 0)
		{
		  for (YGNode child : owner.getChildren())
		  {
			child.setLayout(new YGLayout());
			child.setOwner(null);
		  }
		  owner.setChildren(YGVector());
		  owner.markDirtyAndPropogate();
		}
	  }
	  else
	  {
		if (YGNodeGetChildCount(owner) > 0)
		{
		  for (YGNode oldChild : owner.getChildren())
		  {
			// Our new children may have nodes in common with the old children. We
			// don't reset these common nodes.
			if (std::find(children.iterator(), children.end(), oldChild) == children.end())
			{
			  oldChild.setLayout(new YGLayout());
			  oldChild.setOwner(null);
			}
		  }
		}
		owner.setChildren(children);
		for (YGNode child : children)
		{
		  child.setOwner(owner);
		}
		owner.markDirtyAndPropogate();
	  }
	}
//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
	public static <T, NeedsUpdate, Update> void updateStyle(YGNode node, T value, NeedsUpdate && needsUpdate, Update && update)
	{
	  if (needsUpdate(node.getStyle(), value))
	  {
		update(node.getStyle(), value);
		node.markDirtyAndPropogate();
	  }
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Ref, typename T>
@FunctionalInterface
interface propDelegate
{
	Ref invoke();
}

	public static <Ref, T> void updateStyle(YGNode node, propDelegate prop, T value)
	{
//C++ TO JAVA CONVERTER TODO TASK: Only lambda expressions having all locals passed by reference can be converted to Java:
//ORIGINAL LINE: updateStyle(node, value, [prop](YGStyle& s, T x)
  updateStyle(node, value, (YGStyle s, T x) ->
  {
	  return prop.invoke() != x;
  }, (YGStyle s, T x) ->
  {
	  prop.invoke() = x;
  });
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Ref, typename Idx>
@FunctionalInterface
interface propDelegate
{
	Ref invoke();
}

	public static <Ref, Idx> void updateIndexedStyleProp(YGNode node, propDelegate prop, Idx idx, facebook.yoga.detail.CompactValue value)
	{
//C++ TO JAVA CONVERTER TODO TASK: Only lambda expressions having all locals passed by reference can be converted to Java:
//ORIGINAL LINE: updateStyle(node, value, [idx, prop](YGStyle& s, CompactValue x)
  updateStyle(node, value, (YGStyle s, CompactValue x) ->
  {
	  return prop.invoke()[idx] != x;
  }, (YGStyle s, CompactValue x) ->
  {
	  prop.invoke()[idx] = x;
  });
	}


	// MSVC has trouble inferring the return type of pointer to member functions
	// with const and non-const overloads, instead of preferring the non-const
	// overload like clang and GCC. For the purposes of updateStyle(), we can help
	// MSVC by specifying that return type explicitely. In combination with
	// decltype, MSVC will prefer the non-const version.
	//C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
	//ORIGINAL LINE: #define MSVC_HINT(PROP) decltype(YGStyle{}.PROP())

	//C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
	//ORIGINAL LINE: #define YG_NODE_LAYOUT_PROPERTY_IMPL(type, name, instanceName) type YGNodeLayoutGet##name(YGNodeRef node) { return node->getLayout().instanceName; }

	//C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
	//ORIGINAL LINE: #define YG_NODE_LAYOUT_RESOLVED_PROPERTY_IMPL(type, name, instanceName) type YGNodeLayoutGet##name( YGNodeRef node, YGEdge edge) { YGAssertWithNode( node, edge <= YGEdgeEnd, "Cannot get layout properties of multi-edge shorthands"); if (edge == YGEdgeStart) { if (node->getLayout().direction() == YGDirectionRTL) { return node->getLayout().instanceName[YGEdgeRight]; } else { return node->getLayout().instanceName[YGEdgeLeft]; } } if (edge == YGEdgeEnd) { if (node->getLayout().direction() == YGDirectionRTL) { return node->getLayout().instanceName[YGEdgeLeft]; } else { return node->getLayout().instanceName[YGEdgeRight]; } } return node->getLayout().instanceName[edge]; }

//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	std::atomic<int> gCurrentGenerationCount(0);

//
// This is a wrapper around the YGNodelayoutImpl function. It determines whether
// the layout request is redundant and can be skipped.
//
// Parameters:
//  Input parameters are the same as YGNodelayoutImpl (see above)
//  Return parameter is true if layout was performed, false if skipped
//

	public static boolean YGLayoutNodeInternal(YGNode node, float availableWidth, float availableHeight, YGDirection ownerDirection, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, float ownerWidth, float ownerHeight, boolean performLayout, LayoutPassReason reason, YGConfig config, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount) //Method definition originates from: Yoga.cpp
	{
	  YGLayout layout = node.getLayout();

	  depth++;

	  boolean needToVisitNode = (node.isDirty() && layout.generationCount != generationCount) || layout.lastOwnerDirection != ownerDirection;

	  if (needToVisitNode)
	  {
		// Invalidate the cached results.
		layout.nextCachedMeasurementsIndex = 0;
		layout.cachedLayout.availableWidth = -1F;
		layout.cachedLayout.availableHeight = -1F;
		layout.cachedLayout.widthMeasureMode = YGMeasureModeUndefined;
		layout.cachedLayout.heightMeasureMode = YGMeasureModeUndefined;
		layout.cachedLayout.computedWidth = -1F;
		layout.cachedLayout.computedHeight = -1F;
	  }

	  YGCachedMeasurement cachedResults = null;

	  // Determine whether the results are already cached. We maintain a separate
	  // cache for layouts and measurements. A layout operation modifies the
	  // positions and dimensions for nodes in the subtree. The algorithm assumes
	  // that each node gets layed out a maximum of one time per tree layout, but
	  // multiple measurements may be required to resolve all of the flex
	  // dimensions. We handle nodes with measure functions specially here because
	  // they are the most expensive to measure, so it's worth avoiding redundant
	  // measurements if at all possible.
	  if (node.hasMeasureFunc())
	  {
		float marginAxisRow = node.getMarginForAxis(YGFlexDirectionRow, ownerWidth).unwrap();
		float marginAxisColumn = node.getMarginForAxis(YGFlexDirectionColumn, ownerWidth).unwrap();

		// First, try to use the layout cache.
		if (YGNodeCanUseCachedMeasurement(new YGMeasureMode(widthMeasureMode), availableWidth, new YGMeasureMode(heightMeasureMode), availableHeight, new YGMeasureMode(layout.cachedLayout.widthMeasureMode), layout.cachedLayout.availableWidth, new YGMeasureMode(layout.cachedLayout.heightMeasureMode), layout.cachedLayout.availableHeight, layout.cachedLayout.computedWidth, layout.cachedLayout.computedHeight, marginAxisRow, marginAxisColumn, config))
		{
		  cachedResults = layout.cachedLayout;
		}
		else
		{
		  // Try to use the measurement cache.
		  for (int i = 0; i < layout.nextCachedMeasurementsIndex; i++)
		  {
			if (YGNodeCanUseCachedMeasurement(new YGMeasureMode(widthMeasureMode), availableWidth, new YGMeasureMode(heightMeasureMode), availableHeight, new YGMeasureMode(layout.cachedMeasurements.get(i).widthMeasureMode), layout.cachedMeasurements.get(i).availableWidth, new YGMeasureMode(layout.cachedMeasurements.get(i).heightMeasureMode), layout.cachedMeasurements.get(i).availableHeight, layout.cachedMeasurements.get(i).computedWidth, layout.cachedMeasurements.get(i).computedHeight, marginAxisRow, marginAxisColumn, config))
			{
			  cachedResults = layout.cachedMeasurements.get(i);
			  break;
			}
		  }
		}
	  }
	  else if (performLayout)
	  {
		if (YGFloatsEqual(layout.cachedLayout.availableWidth, availableWidth) && YGFloatsEqual(layout.cachedLayout.availableHeight, availableHeight) && layout.cachedLayout.widthMeasureMode == widthMeasureMode && layout.cachedLayout.heightMeasureMode == heightMeasureMode)
		{
		  cachedResults = layout.cachedLayout;
		}
	  }
	  else
	  {
		for (int i = 0; i < layout.nextCachedMeasurementsIndex; i++)
		{
		  if (YGFloatsEqual(layout.cachedMeasurements.get(i).availableWidth, availableWidth) && YGFloatsEqual(layout.cachedMeasurements.get(i).availableHeight, availableHeight) && layout.cachedMeasurements.get(i).widthMeasureMode == widthMeasureMode && layout.cachedMeasurements.get(i).heightMeasureMode == heightMeasureMode)
		  {
			cachedResults = layout.cachedMeasurements.get(i);
			break;
		  }
		}
	  }

	  if (!needToVisitNode && cachedResults != null)
	  {
		layout.measuredDimensions.set(YGDimensionWidth, cachedResults.computedWidth);
		layout.measuredDimensions.set(YGDimensionHeight, cachedResults.computedHeight);

		(performLayout ? layoutMarkerData.cachedLayouts : layoutMarkerData.cachedMeasures) += 1;

		if (gPrintChanges && gPrintSkips)
		{
		  Log.log(node, YGLogLevelVerbose, null, "%s%d.{[skipped] ", YGSpacer(new int(depth)), depth);
		  node.print(layoutContext);
		  Log.log(node, YGLogLevelVerbose, null, "wm: %s, hm: %s, aw: %f ah: %f => d: (%f, %f) %s\n", YGMeasureModeName(new YGMeasureMode(widthMeasureMode), performLayout), YGMeasureModeName(new YGMeasureMode(heightMeasureMode), performLayout), availableWidth, availableHeight, cachedResults.computedWidth, cachedResults.computedHeight, LayoutPassReasonToString(reason));
		}
	  }
	  else
	  {
		if (gPrintChanges)
		{
		  Log.log(node, YGLogLevelVerbose, null, "%s%d.{%s", YGSpacer(new int(depth)), depth, needToVisitNode ? "*" : "");
		  node.print(layoutContext);
		  Log.log(node, YGLogLevelVerbose, null, "wm: %s, hm: %s, aw: %f ah: %f %s\n", YGMeasureModeName(new YGMeasureMode(widthMeasureMode), performLayout), YGMeasureModeName(new YGMeasureMode(heightMeasureMode), performLayout), availableWidth, availableHeight, LayoutPassReasonToString(reason));
		}

		YGNodelayoutImpl(node, availableWidth, availableHeight, new YGDirection(ownerDirection), new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), ownerWidth, ownerHeight, performLayout, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount), reason);

		if (gPrintChanges)
		{
		  Log.log(node, YGLogLevelVerbose, null, "%s%d.}%s", YGSpacer(new int(depth)), depth, needToVisitNode ? "*" : "");
		  node.print(layoutContext);
		  Log.log(node, YGLogLevelVerbose, null, "wm: %s, hm: %s, d: (%f, %f) %s\n", YGMeasureModeName(new YGMeasureMode(widthMeasureMode), performLayout), YGMeasureModeName(new YGMeasureMode(heightMeasureMode), performLayout), layout.measuredDimensions.get(YGDimensionWidth), layout.measuredDimensions.get(YGDimensionHeight), LayoutPassReasonToString(reason));
		}

//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: layout->lastOwnerDirection = ownerDirection;
		layout.lastOwnerDirection.copyFrom(ownerDirection);

		if (cachedResults == null)
		{
		  if (layout.nextCachedMeasurementsIndex + 1 > (int) layoutMarkerData.maxMeasureCache != null)
		  {
			layoutMarkerData.maxMeasureCache = layout.nextCachedMeasurementsIndex + 1;
		  }
		  if (layout.nextCachedMeasurementsIndex == DefineConstants.YG_MAX_CACHED_RESULT_COUNT)
		  {
			if (gPrintChanges)
			{
			  Log.log(node, YGLogLevelVerbose, null, "Out of cache entries!\n");
			}
			layout.nextCachedMeasurementsIndex = 0;
		  }

		  YGCachedMeasurement newCacheEntry;
		  if (performLayout)
		  {
			// Use the single layout cache entry.
			newCacheEntry = layout.cachedLayout;
		  }
		  else
		  {
			// Allocate a new measurement cache entry.
			newCacheEntry = layout.cachedMeasurements.get(layout.nextCachedMeasurementsIndex);
			layout.nextCachedMeasurementsIndex++;
		  }

		  newCacheEntry.availableWidth = availableWidth;
		  newCacheEntry.availableHeight = availableHeight;
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: newCacheEntry->widthMeasureMode = widthMeasureMode;
		  newCacheEntry.widthMeasureMode.copyFrom(widthMeasureMode);
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: newCacheEntry->heightMeasureMode = heightMeasureMode;
		  newCacheEntry.heightMeasureMode.copyFrom(heightMeasureMode);
		  newCacheEntry.computedWidth = layout.measuredDimensions.get(YGDimensionWidth);
		  newCacheEntry.computedHeight = layout.measuredDimensions.get(YGDimensionHeight);
		}
	  }

	  if (performLayout)
	  {
		node.setLayoutDimension(node.getLayout().measuredDimensions.get(YGDimensionWidth), YGDimensionWidth);
		node.setLayoutDimension(node.getLayout().measuredDimensions.get(YGDimensionHeight), YGDimensionHeight);

		node.setHasNewLayout(true);
		node.setDirty(false);
	  }

//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: layout->generationCount = generationCount;
	  layout.generationCount.copyFrom(generationCount);

	  LayoutType layoutType;
	  if (performLayout)
	  {
		layoutType = !needToVisitNode && cachedResults == layout.cachedLayout ? LayoutType.kCachedLayout : LayoutType.kLayout;
	  }
	  else
	  {
		layoutType = cachedResults != null ? LayoutType.kCachedMeasure : LayoutType.kMeasure;
	  }
	  Event.<Event.NodeLayout>publish(node, {layoutType, layoutContext});

	  return (needToVisitNode || cachedResults == null);
	}

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if DEBUG
	public static void YGNodePrintInternal(YGNode node, YGPrintOptions options)
	{
	  String str;
	  facebook.yoga.YGNodeToString(str, node, options, 0);
	  Log.log(node, YGLogLevelDebug, null, str);
	}
	//#endif

	public static ArrayList<YGEdge> leading = new ArrayList<YGEdge>(Arrays.asList(YGEdgeTop, YGEdgeBottom, YGEdgeLeft, YGEdgeRight));

	public static ArrayList<YGEdge> trailing = new ArrayList<YGEdge>(Arrays.asList(YGEdgeBottom, YGEdgeTop, YGEdgeRight, YGEdgeLeft));
	public static ArrayList<YGEdge> pos = new ArrayList<YGEdge>(Arrays.asList((YGEdgeTop, YGEdgeBottom, YGEdgeLeft, YGEdgeRight)));

	public static ArrayList<YGDimension> dim = new ArrayList<YGDimension>(Arrays.asList((YGDimensionHeight, YGDimensionHeight, YGDimensionWidth, YGDimensionWidth)));

	public static float YGNodePaddingAndBorderForAxis(YGNode node, YGFlexDirection axis, float widthSize)
	{
	  return (node.getLeadingPaddingAndBorder(new YGFlexDirection(axis), widthSize) + node.getTrailingPaddingAndBorder(new YGFlexDirection(axis), widthSize)).unwrap();
	}

	public static YGAlign YGNodeAlignItem(YGNode node, YGNode child)
	{
	  YGAlign align = child.getStyle().alignSelf() == YGAlignAuto ? node.getStyle().alignItems() : child.getStyle().alignSelf();
	  if (align == YGAlignBaseline && YGFlexDirectionIsColumn(node.getStyle().flexDirection()))
	  {
		return YGAlignFlexStart;
	  }
	  return new YGAlign(align);
	}

	public static float YGBaseline(YGNode node, Object layoutContext)
	{
	  if (node.hasBaselineFunc())
	  {

		Event.<Event.NodeBaselineStart>publish(node);

		float baseline = node.baseline(node.getLayout().measuredDimensions.get(YGDimensionWidth), node.getLayout().measuredDimensions.get(YGDimensionHeight), layoutContext);

		Event.<Event.NodeBaselineEnd>publish(node);

		YGAssertWithNode(node, !YGFloatIsUndefined(baseline), "Expect custom baseline function to not return NaN");
		return baseline;
	  }

	  YGNode baselineChild = null;
	  int childCount = YGNodeGetChildCount(node);
	  for (int i = 0; i < childCount; i++)
	  {
		YGNode child = YGNodeGetChild(node, new int(i));
		if (child.getLineIndex() > 0)
		{
		  break;
		}
		if (child.getStyle().positionType() == YGPositionTypeAbsolute)
		{
		  continue;
		}
		if (YGNodeAlignItem(node, child) == YGAlignBaseline || child.isReferenceBaseline())
		{
		  baselineChild = child;
		  break;
		}

		if (baselineChild == null)
		{
		  baselineChild = child;
		}
	  }

	  if (baselineChild == null)
	  {
		return node.getLayout().measuredDimensions.get(YGDimensionHeight);
	  }

	  float baseline = YGBaseline(baselineChild, layoutContext);
	  return baseline + baselineChild.getLayout().position.get(YGEdgeTop);
	}

	public static boolean YGIsBaselineLayout(YGNode node)
	{
	  if (YGFlexDirectionIsColumn(node.getStyle().flexDirection()))
	  {
		return false;
	  }
	  if (node.getStyle().alignItems() == YGAlignBaseline)
	  {
		return true;
	  }
	  int childCount = YGNodeGetChildCount(node);
	  for (int i = 0; i < childCount; i++)
	  {
		YGNode child = YGNodeGetChild(node, new int(i));
		if (child.getStyle().positionType() != YGPositionTypeAbsolute && child.getStyle().alignSelf() == YGAlignBaseline)
		{
		  return true;
		}
	  }

	  return false;
	}

	public static float YGNodeDimWithMargin(YGNode node, YGFlexDirection axis, float widthSize)
	{
	  return node.getLayout().measuredDimensions.get(dim.get(axis)) + (node.getLeadingMargin(new YGFlexDirection(axis), widthSize) + node.getTrailingMargin(new YGFlexDirection(axis), widthSize)).unwrap();
	}

	public static boolean YGNodeIsStyleDimDefined(YGNode node, YGFlexDirection axis, float ownerSize)
	{
	  boolean isUndefined = YGFloatIsUndefined(node.getResolvedDimension(dim.get(axis)).value);
	  return !(node.getResolvedDimension(dim.get(axis)).unit == YGUnitAuto || node.getResolvedDimension(dim.get(axis)).unit == YGUnitUndefined || (node.getResolvedDimension(dim.get(axis)).unit == YGUnitPoint && !yoga.GlobalMembers.isUndefined && node.getResolvedDimension(dim.get(axis)).value < 0.0f) || (node.getResolvedDimension(dim.get(axis)).unit == YGUnitPercent && !yoga.GlobalMembers.isUndefined && (node.getResolvedDimension(dim.get(axis)).value < 0.0f || YGFloatIsUndefined(ownerSize))));
	}

	public static boolean YGNodeIsLayoutDimDefined(YGNode node, YGFlexDirection axis)
	{
	  float value = node.getLayout().measuredDimensions.get(dim.get(axis));
	  return !YGFloatIsUndefined(value) && value >= 0.0f;
	}

	public static YGFloatOptional YGNodeBoundAxisWithinMinAndMax(YGNode node, YGFlexDirection axis, YGFloatOptional value, float axisSize)
	{
	  YGFloatOptional min = new YGFloatOptional();
	  YGFloatOptional max = new YGFloatOptional();

	  if (YGFlexDirectionIsColumn(new YGFlexDirection(axis)))
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: min = YGResolveValue(node->getStyle().minDimensions()[YGDimensionHeight], axisSize);
		min.copyFrom(YGResolveValue(node.getStyle().minDimensions().get(YGDimensionHeight), axisSize));
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: max = YGResolveValue(node->getStyle().maxDimensions()[YGDimensionHeight], axisSize);
		max.copyFrom(YGResolveValue(node.getStyle().maxDimensions().get(YGDimensionHeight), axisSize));
	  }
	  else if (YGFlexDirectionIsRow(new YGFlexDirection(axis)))
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: min = YGResolveValue(node->getStyle().minDimensions()[YGDimensionWidth], axisSize);
		min.copyFrom(YGResolveValue(node.getStyle().minDimensions().get(YGDimensionWidth), axisSize));
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: max = YGResolveValue(node->getStyle().maxDimensions()[YGDimensionWidth], axisSize);
		max.copyFrom(YGResolveValue(node.getStyle().maxDimensions().get(YGDimensionWidth), axisSize));
	  }

	  if (max >= new YGFloatOptional(0) && value > max)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return max;
		return new YGFloatOptional(max);
	  }

	  if (min >= new YGFloatOptional(0) && value < min)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return min;
		return new YGFloatOptional(min);
	  }

//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return value;
	  return new YGFloatOptional(value);
	}

	// Like YGNodeBoundAxisWithinMinAndMax but also ensures that the value doesn't
	// go below the padding and border amount.
	public static float YGNodeBoundAxis(YGNode node, YGFlexDirection axis, float value, float axisSize, float widthSize)
	{
	  return YGFloatMax(YGNodeBoundAxisWithinMinAndMax(node, new YGFlexDirection(axis), new YGFloatOptional(value), axisSize).unwrap(), YGNodePaddingAndBorderForAxis(node, new YGFlexDirection(axis), widthSize));
	}

	public static void YGNodeSetChildTrailingPosition(YGNode node, YGNode child, YGFlexDirection axis)
	{
	  float size = child.getLayout().measuredDimensions.get(dim.get(axis));
	  child.setLayoutPosition(node.getLayout().measuredDimensions.get(dim.get(axis)) - size - child.getLayout().position.get(pos.get(axis)), trailing.get(axis));
	}

	public static void YGConstrainMaxSizeForMode(YGNode node, YGFlexDirection axis, float ownerAxisSize, float ownerWidth, YGMeasureMode mode, tangible.RefObject<Float> size)
	{
	  YGFloatOptional maxSize = YGResolveValue(node.getStyle().maxDimensions().get(dim.get(axis)), ownerAxisSize) + new YGFloatOptional(node.getMarginForAxis(new YGFlexDirection(axis), ownerWidth));
	  switch (mode)
	  {
		case YGMeasureModeExactly:
		case YGMeasureModeAtMost:
		  size.argValue = (maxSize.isUndefined() || size.argValue < maxSize.unwrap()) ? size.argValue : maxSize.unwrap();
		  break;
		case YGMeasureModeUndefined:
		  if (!maxSize.isUndefined())
		  {
			mode = YGMeasureModeAtMost;
			size.argValue = maxSize.unwrap();
		  }
		  break;
	  }
	}

	public static void YGNodeComputeFlexBasisForChild(YGNode node, YGNode child, float width, YGMeasureMode widthMode, float height, float ownerWidth, float ownerHeight, YGMeasureMode heightMode, YGDirection direction, YGConfig config, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount)
	{
	  YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), new YGDirection(direction));
	  boolean isMainAxisRow = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis));
	  float mainAxisSize = isMainAxisRow ? width : height;
	  float mainAxisownerSize = isMainAxisRow ? ownerWidth : ownerHeight;

	  float childWidth;
	  float childHeight;
	  YGMeasureMode childWidthMeasureMode = new YGMeasureMode();
	  YGMeasureMode childHeightMeasureMode = new YGMeasureMode();

	  YGFloatOptional resolvedFlexBasis = YGResolveValue(child.resolveFlexBasisPtr(), mainAxisownerSize);
	  boolean isRowStyleDimDefined = YGNodeIsStyleDimDefined(child, YGFlexDirectionRow, ownerWidth);
	  boolean isColumnStyleDimDefined = YGNodeIsStyleDimDefined(child, YGFlexDirectionColumn, ownerHeight);

	  if (!resolvedFlexBasis.isUndefined() && !YGFloatIsUndefined(mainAxisSize))
	  {
		if (child.getLayout().computedFlexBasis.isUndefined() || (YGConfigIsExperimentalFeatureEnabled(child.getConfig(), YGExperimentalFeatureWebFlexBasis) && child.getLayout().computedFlexBasisGeneration != generationCount))
		{
		  YGFloatOptional paddingAndBorder = new YGFloatOptional(YGNodePaddingAndBorderForAxis(child, new YGFlexDirection(mainAxis), ownerWidth));
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: child->setLayoutComputedFlexBasis(YGFloatOptionalMax(resolvedFlexBasis, paddingAndBorder));
		  child.setLayoutComputedFlexBasis(YGFloatOptionalMax(new YGFloatOptional(resolvedFlexBasis), new YGFloatOptional(paddingAndBorder)));
		}
	  }
	  else if (isMainAxisRow && isRowStyleDimDefined)
	  {
		// The width is definite, so use that as the flex basis.
		YGFloatOptional paddingAndBorder = new YGFloatOptional(YGNodePaddingAndBorderForAxis(child, YGFlexDirectionRow, ownerWidth));

//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: child->setLayoutComputedFlexBasis(YGFloatOptionalMax(YGResolveValue(child->getResolvedDimensions [YGDimensionWidth], ownerWidth), paddingAndBorder));
		child.setLayoutComputedFlexBasis(YGFloatOptionalMax(YGResolveValue(child.getResolvedDimensions [YGDimensionWidth], ownerWidth), new YGFloatOptional(paddingAndBorder)));
	  }
	  else if (!isMainAxisRow && isColumnStyleDimDefined)
	  {
		// The height is definite, so use that as the flex basis.
		YGFloatOptional paddingAndBorder = new YGFloatOptional(YGNodePaddingAndBorderForAxis(child, YGFlexDirectionColumn, ownerWidth));
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: child->setLayoutComputedFlexBasis(YGFloatOptionalMax(YGResolveValue(child->getResolvedDimensions [YGDimensionHeight], ownerHeight), paddingAndBorder));
		child.setLayoutComputedFlexBasis(YGFloatOptionalMax(YGResolveValue(child.getResolvedDimensions [YGDimensionHeight], ownerHeight), new YGFloatOptional(paddingAndBorder)));
	  }
	  else
	  {
		// Compute the flex basis and hypothetical main size (i.e. the clamped flex
		// basis).
		childWidth = ((float) __nan);
		childHeight = ((float) __nan);
		childWidthMeasureMode = YGMeasureModeUndefined;
		childHeightMeasureMode = YGMeasureModeUndefined;

		var marginRow = child.getMarginForAxis(YGFlexDirectionRow, ownerWidth).unwrap();
		var marginColumn = child.getMarginForAxis(YGFlexDirectionColumn, ownerWidth).unwrap();

		if (isRowStyleDimDefined)
		{
		  childWidth = YGResolveValue(child.getResolvedDimensions [YGDimensionWidth], ownerWidth).unwrap() + marginRow;
		  childWidthMeasureMode = YGMeasureModeExactly;
		}
		if (isColumnStyleDimDefined)
		{
		  childHeight = YGResolveValue(child.getResolvedDimensions [YGDimensionHeight], ownerHeight).unwrap() + marginColumn;
		  childHeightMeasureMode = YGMeasureModeExactly;
		}

		// The W3C spec doesn't say anything about the 'overflow' property, but all
		// major browsers appear to implement the following logic.
		if ((!isMainAxisRow && node.getStyle().overflow() == YGOverflowScroll) || node.getStyle().overflow() != YGOverflowScroll)
		{
		  if (YGFloatIsUndefined(childWidth) && !YGFloatIsUndefined(width))
		  {
			childWidth = width;
			childWidthMeasureMode = YGMeasureModeAtMost;
		  }
		}

		if ((isMainAxisRow && node.getStyle().overflow() == YGOverflowScroll) || node.getStyle().overflow() != YGOverflowScroll)
		{
		  if (YGFloatIsUndefined(childHeight) && !YGFloatIsUndefined(height))
		  {
			childHeight = height;
			childHeightMeasureMode = YGMeasureModeAtMost;
		  }
		}

		var childStyle = child.getStyle();
		if (!childStyle.aspectRatio().isUndefined())
		{
		  if (!isMainAxisRow && childWidthMeasureMode == YGMeasureModeExactly)
		  {
			childHeight = marginColumn + (childWidth - marginRow) / childStyle.aspectRatio().unwrap();
			childHeightMeasureMode = YGMeasureModeExactly;
		  }
		  else if (isMainAxisRow && childHeightMeasureMode == YGMeasureModeExactly)
		  {
			childWidth = marginRow + (childHeight - marginColumn) * childStyle.aspectRatio().unwrap();
			childWidthMeasureMode = YGMeasureModeExactly;
		  }
		}

		// If child has no defined size in the cross axis and is set to stretch, set
		// the cross axis to be measured exactly with the available inner width

		boolean hasExactWidth = !YGFloatIsUndefined(width) && widthMode == YGMeasureModeExactly;
		boolean childWidthStretch = YGNodeAlignItem(node, child) == YGAlignStretch && childWidthMeasureMode != YGMeasureModeExactly;
		if (!isMainAxisRow && !isRowStyleDimDefined && hasExactWidth && childWidthStretch)
		{
		  childWidth = width;
		  childWidthMeasureMode = YGMeasureModeExactly;
		  if (!childStyle.aspectRatio().isUndefined())
		  {
			childHeight = (childWidth - marginRow) / childStyle.aspectRatio().unwrap();
			childHeightMeasureMode = YGMeasureModeExactly;
		  }
		}

		boolean hasExactHeight = !YGFloatIsUndefined(height) && heightMode == YGMeasureModeExactly;
		boolean childHeightStretch = YGNodeAlignItem(node, child) == YGAlignStretch && childHeightMeasureMode != YGMeasureModeExactly;
		if (isMainAxisRow && !isColumnStyleDimDefined && hasExactHeight && childHeightStretch)
		{
		  childHeight = height;
		  childHeightMeasureMode = YGMeasureModeExactly;

		  if (!childStyle.aspectRatio().isUndefined())
		  {
			childWidth = (childHeight - marginColumn) * childStyle.aspectRatio().unwrap();
			childWidthMeasureMode = YGMeasureModeExactly;
		  }
		}

	tangible.RefObject<Float> tempRef_childWidth = new tangible.RefObject<Float>(childWidth);
		YGConstrainMaxSizeForMode(child, YGFlexDirectionRow, ownerWidth, ownerWidth, childWidthMeasureMode, tempRef_childWidth);
		childWidth = tempRef_childWidth.argValue;
	tangible.RefObject<Float> tempRef_childHeight = new tangible.RefObject<Float>(childHeight);
		YGConstrainMaxSizeForMode(child, YGFlexDirectionColumn, ownerHeight, ownerWidth, childHeightMeasureMode, tempRef_childHeight);
		childHeight = tempRef_childHeight.argValue;

		// Measure the child
		YGLayoutNodeInternal(child, childWidth, childHeight, new YGDirection(direction), new YGMeasureMode(childWidthMeasureMode), new YGMeasureMode(childHeightMeasureMode), ownerWidth, ownerHeight, false, LayoutPassReason.kMeasureChild, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));

		child.setLayoutComputedFlexBasis(new YGFloatOptional(YGFloatMax(child.getLayout().measuredDimensions.get(dim.get(mainAxis)), YGNodePaddingAndBorderForAxis(child, new YGFlexDirection(mainAxis), ownerWidth))));
	  }
	  child.setLayoutComputedFlexBasisGeneration(new int(generationCount));
	}

	public static void YGNodeAbsoluteLayoutChild(YGNode node, YGNode child, float width, YGMeasureMode widthMode, float height, YGDirection direction, YGConfig config, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount)
	{
	  YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), new YGDirection(direction));
	  YGFlexDirection crossAxis = YGFlexDirectionCross(new YGFlexDirection(mainAxis), new YGDirection(direction));
	  boolean isMainAxisRow = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis));

	  float childWidth = ((float) __nan);
	  float childHeight = ((float) __nan);
	  YGMeasureMode childWidthMeasureMode = YGMeasureModeUndefined;
	  YGMeasureMode childHeightMeasureMode = YGMeasureModeUndefined;

	  var marginRow = child.getMarginForAxis(YGFlexDirectionRow, width).unwrap();
	  var marginColumn = child.getMarginForAxis(YGFlexDirectionColumn, width).unwrap();

	  if (YGNodeIsStyleDimDefined(child, YGFlexDirectionRow, width))
	  {
		childWidth = YGResolveValue(child.getResolvedDimensions [YGDimensionWidth], width).unwrap() + marginRow;
	  }
	  else
	  {
		// If the child doesn't have a specified width, compute the width based on
		// the left/right offsets if they're defined.
		if (child.isLeadingPositionDefined(YGFlexDirectionRow) && child.isTrailingPosDefined(YGFlexDirectionRow))
		{
		  childWidth = node.getLayout().measuredDimensions.get(YGDimensionWidth) - (node.getLeadingBorder(YGFlexDirectionRow) + node.getTrailingBorder(YGFlexDirectionRow)) - (child.getLeadingPosition(YGFlexDirectionRow, width) + child.getTrailingPosition(YGFlexDirectionRow, width)).unwrap();
		  childWidth = YGNodeBoundAxis(child, YGFlexDirectionRow, childWidth, width, width);
		}
	  }

	  if (YGNodeIsStyleDimDefined(child, YGFlexDirectionColumn, height))
	  {
		childHeight = YGResolveValue(child.getResolvedDimensions [YGDimensionHeight], height).unwrap() + marginColumn;
	  }
	  else
	  {
		// If the child doesn't have a specified height, compute the height based on
		// the top/bottom offsets if they're defined.
		if (child.isLeadingPositionDefined(YGFlexDirectionColumn) && child.isTrailingPosDefined(YGFlexDirectionColumn))
		{
		  childHeight = node.getLayout().measuredDimensions.get(YGDimensionHeight) - (node.getLeadingBorder(YGFlexDirectionColumn) + node.getTrailingBorder(YGFlexDirectionColumn)) - (child.getLeadingPosition(YGFlexDirectionColumn, height) + child.getTrailingPosition(YGFlexDirectionColumn, height)).unwrap();
		  childHeight = YGNodeBoundAxis(child, YGFlexDirectionColumn, childHeight, height, width);
		}
	  }

	  // Exactly one dimension needs to be defined for us to be able to do aspect
	  // ratio calculation. One dimension being the anchor and the other being
	  // flexible.
	  var childStyle = child.getStyle();
	  if (YGFloatIsUndefined(childWidth) ^ YGFloatIsUndefined(childHeight))
	  {
		if (!childStyle.aspectRatio().isUndefined())
		{
		  if (YGFloatIsUndefined(childWidth))
		  {
			childWidth = marginRow + (childHeight - marginColumn) * childStyle.aspectRatio().unwrap();
		  }
		  else if (YGFloatIsUndefined(childHeight))
		  {
			childHeight = marginColumn + (childWidth - marginRow) / childStyle.aspectRatio().unwrap();
		  }
		}
	  }

	  // If we're still missing one or the other dimension, measure the content.
	  if (YGFloatIsUndefined(childWidth) || YGFloatIsUndefined(childHeight))
	  {
		childWidthMeasureMode = YGFloatIsUndefined(childWidth) ? YGMeasureModeUndefined : YGMeasureModeExactly;
		childHeightMeasureMode = YGFloatIsUndefined(childHeight) ? YGMeasureModeUndefined : YGMeasureModeExactly;

		// If the size of the owner is defined then try to constrain the absolute
		// child to that size as well. This allows text within the absolute child to
		// wrap to the size of its owner. This is the same behavior as many browsers
		// implement.
		if (!isMainAxisRow && YGFloatIsUndefined(childWidth) && widthMode != YGMeasureModeUndefined && !YGFloatIsUndefined(width) && width > 0F)
		{
		  childWidth = width;
		  childWidthMeasureMode = YGMeasureModeAtMost;
		}

		YGLayoutNodeInternal(child, childWidth, childHeight, new YGDirection(direction), new YGMeasureMode(childWidthMeasureMode), new YGMeasureMode(childHeightMeasureMode), childWidth, childHeight, false, LayoutPassReason.kAbsMeasureChild, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
		childWidth = child.getLayout().measuredDimensions.get(YGDimensionWidth) + child.getMarginForAxis(YGFlexDirectionRow, width).unwrap();
		childHeight = child.getLayout().measuredDimensions.get(YGDimensionHeight) + child.getMarginForAxis(YGFlexDirectionColumn, width).unwrap();
	  }

	  YGLayoutNodeInternal(child, childWidth, childHeight, new YGDirection(direction), YGMeasureModeExactly, YGMeasureModeExactly, childWidth, childHeight, true, LayoutPassReason.kAbsLayout, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));

	  if (child.isTrailingPosDefined(new YGFlexDirection(mainAxis)) && !child.isLeadingPositionDefined(new YGFlexDirection(mainAxis)))
	  {
		child.setLayoutPosition(node.getLayout().measuredDimensions.get(dim.get(mainAxis)) - child.getLayout().measuredDimensions.get(dim.get(mainAxis)) - node.getTrailingBorder(new YGFlexDirection(mainAxis)) - child.getTrailingMargin(new YGFlexDirection(mainAxis), width).unwrap() - child.getTrailingPosition(new YGFlexDirection(mainAxis), isMainAxisRow ? width : height).unwrap(), leading.get(mainAxis));
	  }
	  else if (!child.isLeadingPositionDefined(new YGFlexDirection(mainAxis)) && node.getStyle().justifyContent() == YGJustifyCenter)
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions.get(dim.get(mainAxis)) - child.getLayout().measuredDimensions.get(dim.get(mainAxis))) / 2.0f, leading.get(mainAxis));
	  }
	  else if (!child.isLeadingPositionDefined(new YGFlexDirection(mainAxis)) && node.getStyle().justifyContent() == YGJustifyFlexEnd)
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions.get(dim.get(mainAxis)) - child.getLayout().measuredDimensions.get(dim.get(mainAxis))), leading.get(mainAxis));
	  }

	  if (child.isTrailingPosDefined(new YGFlexDirection(crossAxis)) && !child.isLeadingPositionDefined(new YGFlexDirection(crossAxis)))
	  {
		child.setLayoutPosition(node.getLayout().measuredDimensions.get(dim.get(crossAxis)) - child.getLayout().measuredDimensions.get(dim.get(crossAxis)) - node.getTrailingBorder(new YGFlexDirection(crossAxis)) - child.getTrailingMargin(new YGFlexDirection(crossAxis), width).unwrap() - child.getTrailingPosition(new YGFlexDirection(crossAxis), isMainAxisRow ? height : width).unwrap(), leading.get(crossAxis));

	  }
	  else if (!child.isLeadingPositionDefined(new YGFlexDirection(crossAxis)) && YGNodeAlignItem(node, child) == YGAlignCenter)
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions.get(dim.get(crossAxis)) - child.getLayout().measuredDimensions.get(dim.get(crossAxis))) / 2.0f, leading.get(crossAxis));
	  }
	  else if (!child.isLeadingPositionDefined(new YGFlexDirection(crossAxis)) && ((YGNodeAlignItem(node, child) == YGAlignFlexEnd) ^ (node.getStyle().flexWrap() == YGWrapWrapReverse)))
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions.get(dim.get(crossAxis)) - child.getLayout().measuredDimensions.get(dim.get(crossAxis))), leading.get(crossAxis));
	  }
	}

	public static void YGNodeWithMeasureFuncSetMeasuredDimensions(YGNode node, float availableWidth, float availableHeight, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, float ownerWidth, float ownerHeight, LayoutData layoutMarkerData, Object layoutContext, LayoutPassReason reason)
	{
	  YGAssertWithNode(node, node.hasMeasureFunc(), "Expected node to have custom measure function");

	  if (widthMeasureMode == YGMeasureModeUndefined)
	  {
		availableWidth = ((float) __nan);
	  }
	  if (heightMeasureMode == YGMeasureModeUndefined)
	  {
		availableHeight = ((float) __nan);
	  }

	  var padding = node.getLayout().padding;
	  var border = node.getLayout().border;
	  float paddingAndBorderAxisRow = padding.get(YGEdgeLeft) + padding.get(YGEdgeRight) + border.get(YGEdgeLeft) + border.get(YGEdgeRight);
	  float paddingAndBorderAxisColumn = padding.get(YGEdgeTop) + padding.get(YGEdgeBottom) + border.get(YGEdgeTop) + border.get(YGEdgeBottom);

	  // We want to make sure we don't call measure with negative size
	  float innerWidth = YGFloatIsUndefined(availableWidth) ? availableWidth : YGFloatMax(0F, availableWidth - paddingAndBorderAxisRow);
	  float innerHeight = YGFloatIsUndefined(availableHeight) ? availableHeight : YGFloatMax(0F, availableHeight - paddingAndBorderAxisColumn);

	  if (widthMeasureMode == YGMeasureModeExactly && heightMeasureMode == YGMeasureModeExactly)
	  {
		// Don't bother sizing the text if both dimensions are already defined.
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionRow, availableWidth, ownerWidth, ownerWidth), YGDimensionWidth);
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionColumn, availableHeight, ownerHeight, ownerWidth), YGDimensionHeight);
	  }
	  else
	  {
		Event.<Event.MeasureCallbackStart>publish(node);

		// Measure the text under the current constraints.
		YGSize measuredSize = node.measure(innerWidth, new YGMeasureMode(widthMeasureMode), innerHeight, new YGMeasureMode(heightMeasureMode), layoutContext);

		layoutMarkerData.measureCallbacks += 1;
		layoutMarkerData.measureCallbackReasonsCount.set((long)reason, layoutMarkerData.measureCallbackReasonsCount.get((long)reason) + 1);

		Event.<Event.MeasureCallbackEnd>publish(node, {layoutContext, innerWidth, widthMeasureMode, innerHeight, heightMeasureMode, measuredSize.width, measuredSize.height, reason});

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionRow, (widthMeasureMode == YGMeasureModeUndefined || widthMeasureMode == YGMeasureModeAtMost) ? measuredSize.width + paddingAndBorderAxisRow : availableWidth, ownerWidth, ownerWidth), YGDimensionWidth);

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionColumn, (heightMeasureMode == YGMeasureModeUndefined || heightMeasureMode == YGMeasureModeAtMost) ? measuredSize.height + paddingAndBorderAxisColumn : availableHeight, ownerHeight, ownerWidth), YGDimensionHeight);
	  }
	}

	// For nodes with no children, use the available values if they were provided,
	// or the minimum size as indicated by the padding and border sizes.
	public static void YGNodeEmptyContainerSetMeasuredDimensions(YGNode node, float availableWidth, float availableHeight, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, float ownerWidth, float ownerHeight)
	{
	  var padding = node.getLayout().padding;
	  var border = node.getLayout().border;

	  float width = availableWidth;
	  if (widthMeasureMode == YGMeasureModeUndefined || widthMeasureMode == YGMeasureModeAtMost)
	  {
		width = padding.get(YGEdgeLeft) + padding.get(YGEdgeRight) + border.get(YGEdgeLeft) + border.get(YGEdgeRight);
	  }
	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionRow, width, ownerWidth, ownerWidth), YGDimensionWidth);

	  float height = availableHeight;
	  if (heightMeasureMode == YGMeasureModeUndefined || heightMeasureMode == YGMeasureModeAtMost)
	  {
		height = padding.get(YGEdgeTop) + padding.get(YGEdgeBottom) + border.get(YGEdgeTop) + border.get(YGEdgeBottom);
	  }
	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionColumn, height, ownerHeight, ownerWidth), YGDimensionHeight);
	}

	public static boolean YGNodeFixedSizeSetMeasuredDimensions(YGNode node, float availableWidth, float availableHeight, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, float ownerWidth, float ownerHeight)
	{
	  if ((!YGFloatIsUndefined(availableWidth) && widthMeasureMode == YGMeasureModeAtMost && availableWidth <= 0.0f) || (!YGFloatIsUndefined(availableHeight) && heightMeasureMode == YGMeasureModeAtMost && availableHeight <= 0.0f) || (widthMeasureMode == YGMeasureModeExactly && heightMeasureMode == YGMeasureModeExactly))
	  {
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionRow, YGFloatIsUndefined(availableWidth) || (widthMeasureMode == YGMeasureModeAtMost && availableWidth < 0.0f) ? 0.0f : availableWidth, ownerWidth, ownerWidth), YGDimensionWidth);

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionColumn, YGFloatIsUndefined(availableHeight) || (heightMeasureMode == YGMeasureModeAtMost && availableHeight < 0.0f) ? 0.0f : availableHeight, ownerHeight, ownerWidth), YGDimensionHeight);
		return true;
	  }

	  return false;
	}

	public static void YGZeroOutLayoutRecursivly(YGNode node, Object layoutContext)
	{
	  node.getLayout() = new YGLayout();
	  node.setLayoutDimension(0F, 0);
	  node.setLayoutDimension(0F, 1);
	  node.setHasNewLayout(true);

	  node.iterChildrenAfterCloningIfNeeded(YGZeroOutLayoutRecursivly, layoutContext);
	}

	public static float YGNodeCalculateAvailableInnerDim(YGNode node, YGDimension dimension, float availableDim, float paddingAndBorder, float ownerDim)
	{
	  float availableInnerDim = availableDim - paddingAndBorder;
	  // Max dimension overrides predefined dimension value; Min dimension in turn
	  // overrides both of the above
	  if (!YGFloatIsUndefined(availableInnerDim))
	  {
		// We want to make sure our available height does not violate min and max
		// constraints
		YGFloatOptional minDimensionOptional = YGResolveValue(node.getStyle().minDimensions().get(dimension), ownerDim);
		float minInnerDim = minDimensionOptional.isUndefined() ? 0.0f : minDimensionOptional.unwrap() - paddingAndBorder;

		YGFloatOptional maxDimensionOptional = YGResolveValue(node.getStyle().maxDimensions().get(dimension), ownerDim);

		float maxInnerDim = maxDimensionOptional.isUndefined() ? Float.MAX_VALUE : maxDimensionOptional.unwrap() - paddingAndBorder;
		availableInnerDim = YGFloatMax(YGFloatMin(availableInnerDim, maxInnerDim), minInnerDim);
	  }

	  return availableInnerDim;
	}

	public static float YGNodeComputeFlexBasisForChildren(YGNode node, float availableInnerWidth, float availableInnerHeight, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, YGDirection direction, YGFlexDirection mainAxis, YGConfig config, boolean performLayout, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount)
	{
	  float totalOuterFlexBasis = 0.0f;
	  YGNode singleFlexChild = null;
	  ArrayList<YGNode> children = node.getChildren();
	  YGMeasureMode measureModeMainDim = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis)) ? widthMeasureMode : heightMeasureMode;
	  // If there is only one child with flexGrow + flexShrink it means we can set
	  // the computedFlexBasis to 0 instead of measuring and shrinking / flexing the
	  // child to exactly match the remaining space
	  if (measureModeMainDim == YGMeasureModeExactly)
	  {
		for (var child : children)
		{
		  if (child.isNodeFlexible())
		  {
			if (singleFlexChild != null || YGFloatsEqual(child.resolveFlexGrow(), 0.0f) || YGFloatsEqual(child.resolveFlexShrink(), 0.0f))
			{
			  // There is already a flexible child, or this flexible child doesn't
			  // have flexGrow and flexShrink, abort
			  singleFlexChild = null;
			  break;
			}
			else
			{
			  singleFlexChild = child;
			}
		  }
		}
	  }

	  for (var child : children)
	  {
		child.resolveDimension();
		if (child.getStyle().display() == YGDisplayNone)
		{
		  YGZeroOutLayoutRecursivly(new YGNode(child), layoutContext);
		  child.setHasNewLayout(true);
		  child.setDirty(false);
		  continue;
		}
		if (performLayout)
		{
		  // Set the initial position (relative to the owner).
		  YGDirection childDirection = child.resolveDirection(new YGDirection(direction));
		  float mainDim = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis)) ? availableInnerWidth : availableInnerHeight;
		  float crossDim = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis)) ? availableInnerHeight : availableInnerWidth;
		  child.setPosition(new YGDirection(childDirection), mainDim, crossDim, availableInnerWidth);
		}

		if (child.getStyle().positionType() == YGPositionTypeAbsolute)
		{
		  continue;
		}
		if (child == singleFlexChild)
		{
		  child.setLayoutComputedFlexBasisGeneration(new int(generationCount));
		  child.setLayoutComputedFlexBasis(new YGFloatOptional(0F));
		}
		else
		{
		  YGNodeComputeFlexBasisForChild(node, new YGNode(child), availableInnerWidth, new YGMeasureMode(widthMeasureMode), availableInnerHeight, availableInnerWidth, availableInnerHeight, new YGMeasureMode(heightMeasureMode), new YGDirection(direction), config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
		}

		totalOuterFlexBasis += (child.getLayout().computedFlexBasis + child.getMarginForAxis(new YGFlexDirection(mainAxis), availableInnerWidth)).unwrap();
	  }

	  return totalOuterFlexBasis;
	}

	// This function assumes that all the children of node have their
	// computedFlexBasis properly computed(To do this use
	// YGNodeComputeFlexBasisForChildren function). This function calculates
	// YGCollectFlexItemsRowMeasurement
	public static YGCollectFlexItemsRowValues YGCalculateCollectFlexItemsRowValues(tangible.RefObject<YGNode> node, YGDirection ownerDirection, float mainAxisownerSize, float availableInnerWidth, float availableInnerMainDim, int startOfLineIndex, int lineCount)
	{
	  YGCollectFlexItemsRowValues flexAlgoRowMeasurement = new YGCollectFlexItemsRowValues();
	  flexAlgoRowMeasurement.relativeChildren.ensureCapacity(node.argValue.getChildren().size());

	  float sizeConsumedOnCurrentLineIncludingMinConstraint = 0F;
	  YGFlexDirection mainAxis = YGResolveFlexDirection(node.argValue.getStyle().flexDirection(), node.argValue.resolveDirection(new YGDirection(ownerDirection)));
	  boolean isNodeFlexWrap = node.argValue.getStyle().flexWrap() != YGWrapNoWrap;

	  // Add items to the current line until it's full or we run out of items.
	  int endOfLineIndex = new int(startOfLineIndex);
	  for (; endOfLineIndex < node.argValue.getChildren().size(); endOfLineIndex++)
	  {
		YGNode child = node.argValue.getChild(new int(endOfLineIndex));
		if (child.getStyle().display() == YGDisplayNone || child.getStyle().positionType() == YGPositionTypeAbsolute)
		{
		  continue;
		}
		child.setLineIndex(new int(lineCount));
		float childMarginMainAxis = child.getMarginForAxis(new YGFlexDirection(mainAxis), availableInnerWidth).unwrap();
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: float flexBasisWithMinAndMaxConstraints = YGNodeBoundAxisWithinMinAndMax(child, mainAxis, child->getLayout().computedFlexBasis, mainAxisownerSize).unwrap();
		float flexBasisWithMinAndMaxConstraints = YGNodeBoundAxisWithinMinAndMax(child, new YGFlexDirection(mainAxis), new YGFloatOptional(child.getLayout().computedFlexBasis), mainAxisownerSize).unwrap();

		// If this is a multi-line flow and this item pushes us over the available
		// size, we've hit the end of the current line. Break out of the loop and
		// lay out the current line.
		if (sizeConsumedOnCurrentLineIncludingMinConstraint + flexBasisWithMinAndMaxConstraints + childMarginMainAxis > availableInnerMainDim && isNodeFlexWrap && flexAlgoRowMeasurement.itemsOnLine > 0)
		{
		  break;
		}

		sizeConsumedOnCurrentLineIncludingMinConstraint += flexBasisWithMinAndMaxConstraints + childMarginMainAxis;
		flexAlgoRowMeasurement.sizeConsumedOnCurrentLine += flexBasisWithMinAndMaxConstraints + childMarginMainAxis;
		flexAlgoRowMeasurement.itemsOnLine++;

		if (child.isNodeFlexible())
		{
		  flexAlgoRowMeasurement.totalFlexGrowFactors += child.resolveFlexGrow();

		  // Unlike the grow factor, the shrink factor is scaled relative to the
		  // child dimension.
		  flexAlgoRowMeasurement.totalFlexShrinkScaledFactors += -child.resolveFlexShrink() * child.getLayout().computedFlexBasis.unwrap();
		}

		flexAlgoRowMeasurement.relativeChildren.add(child);
	  }

	  // The total flex factor needs to be floored to 1.
	  if (flexAlgoRowMeasurement.totalFlexGrowFactors > 0F && flexAlgoRowMeasurement.totalFlexGrowFactors < 1F)
	  {
		flexAlgoRowMeasurement.totalFlexGrowFactors = 1F;
	  }

	  // The total flex shrink factor needs to be floored to 1.
	  if (flexAlgoRowMeasurement.totalFlexShrinkScaledFactors > 0F && flexAlgoRowMeasurement.totalFlexShrinkScaledFactors < 1F)
	  {
		flexAlgoRowMeasurement.totalFlexShrinkScaledFactors = 1F;
	  }
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: flexAlgoRowMeasurement.endOfLineIndex = endOfLineIndex;
	  flexAlgoRowMeasurement.endOfLineIndex.copyFrom(endOfLineIndex);
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexAlgoRowMeasurement;
	  return new YGCollectFlexItemsRowValues(flexAlgoRowMeasurement);
	}

	// It distributes the free space to the flexible items and ensures that the size
	// of the flex items abide the min and max constraints. At the end of this
	// function the child nodes would have proper size. Prior using this function
	// please ensure that YGDistributeFreeSpaceFirstPass is called.
	public static float YGDistributeFreeSpaceSecondPass(YGCollectFlexItemsRowValues collectedFlexItemsValues, YGNode node, YGFlexDirection mainAxis, YGFlexDirection crossAxis, float mainAxisownerSize, float availableInnerMainDim, float availableInnerCrossDim, float availableInnerWidth, float availableInnerHeight, boolean flexBasisOverflows, YGMeasureMode measureModeCrossDim, boolean performLayout, YGConfig config, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount)
	{
	  float childFlexBasis = 0F;
	  float flexShrinkScaledFactor = 0F;
	  float flexGrowFactor = 0F;
	  float deltaFreeSpace = 0F;
	  boolean isMainAxisRow = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis));
	  boolean isNodeFlexWrap = node.getStyle().flexWrap() != YGWrapNoWrap;

	  for (var currentRelativeChild : collectedFlexItemsValues.relativeChildren)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: childFlexBasis = YGNodeBoundAxisWithinMinAndMax(currentRelativeChild, mainAxis, currentRelativeChild->getLayout().computedFlexBasis, mainAxisownerSize).unwrap();
		childFlexBasis = YGNodeBoundAxisWithinMinAndMax(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), new YGFloatOptional(currentRelativeChild.getLayout().computedFlexBasis), mainAxisownerSize).unwrap();
		float updatedMainSize = childFlexBasis;

		if (!YGFloatIsUndefined(collectedFlexItemsValues.remainingFreeSpace) && collectedFlexItemsValues.remainingFreeSpace < 0F)
		{
		  flexShrinkScaledFactor = -currentRelativeChild.resolveFlexShrink() * childFlexBasis;
		  // Is this child able to shrink?
		  if (flexShrinkScaledFactor != 0F)
		  {
			float childSize;

			if (!YGFloatIsUndefined(collectedFlexItemsValues.totalFlexShrinkScaledFactors) && collectedFlexItemsValues.totalFlexShrinkScaledFactors == 0F)
			{
			  childSize = childFlexBasis + flexShrinkScaledFactor;
			}
			else
			{
			  childSize = childFlexBasis + (collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexShrinkScaledFactors) * flexShrinkScaledFactor;
			}

			updatedMainSize = YGNodeBoundAxis(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), childSize, availableInnerMainDim, availableInnerWidth);
		  }
		}
		else if (!YGFloatIsUndefined(collectedFlexItemsValues.remainingFreeSpace) && collectedFlexItemsValues.remainingFreeSpace > 0F)
		{
		  flexGrowFactor = currentRelativeChild.resolveFlexGrow();

		  // Is this child able to grow?
		  if (!YGFloatIsUndefined(flexGrowFactor) && flexGrowFactor != 0F)
		  {
			updatedMainSize = YGNodeBoundAxis(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), childFlexBasis + collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexGrowFactors * flexGrowFactor, availableInnerMainDim, availableInnerWidth);
		  }
		}

		deltaFreeSpace += updatedMainSize - childFlexBasis;

		float marginMain = currentRelativeChild.getMarginForAxis(new YGFlexDirection(mainAxis), availableInnerWidth).unwrap();
		float marginCross = currentRelativeChild.getMarginForAxis(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap();

		float childCrossSize;
		float childMainSize = updatedMainSize + marginMain;
		YGMeasureMode childCrossMeasureMode = new YGMeasureMode();
		YGMeasureMode childMainMeasureMode = YGMeasureModeExactly;

		var childStyle = currentRelativeChild.getStyle();
		if (!childStyle.aspectRatio().isUndefined())
		{
		  childCrossSize = isMainAxisRow ? (childMainSize - marginMain) / childStyle.aspectRatio().unwrap() : (childMainSize - marginMain) * childStyle.aspectRatio().unwrap();
		  childCrossMeasureMode = YGMeasureModeExactly;

		  childCrossSize += marginCross;
		}
		else if (!YGFloatIsUndefined(availableInnerCrossDim) && !YGNodeIsStyleDimDefined(new YGNode(currentRelativeChild), new YGFlexDirection(crossAxis), availableInnerCrossDim) && measureModeCrossDim == YGMeasureModeExactly && !(isNodeFlexWrap && flexBasisOverflows) && YGNodeAlignItem(node, new YGNode(currentRelativeChild)) == YGAlignStretch && currentRelativeChild.marginLeadingValue(new YGFlexDirection(crossAxis)).unit != YGUnitAuto && currentRelativeChild.marginTrailingValue(new YGFlexDirection(crossAxis)).unit != YGUnitAuto)
		{
		  childCrossSize = availableInnerCrossDim;
		  childCrossMeasureMode = YGMeasureModeExactly;
		}
		else if (!YGNodeIsStyleDimDefined(new YGNode(currentRelativeChild), new YGFlexDirection(crossAxis), availableInnerCrossDim))
		{
		  childCrossSize = availableInnerCrossDim;
		  childCrossMeasureMode = YGFloatIsUndefined(childCrossSize) ? YGMeasureModeUndefined : YGMeasureModeAtMost;
		}
		else
		{
		  childCrossSize = YGResolveValue(currentRelativeChild.getResolvedDimension(dim.get(crossAxis)), availableInnerCrossDim).unwrap() + marginCross;
		  boolean isLoosePercentageMeasurement = currentRelativeChild.getResolvedDimension(dim.get(crossAxis)).unit == YGUnitPercent && measureModeCrossDim != YGMeasureModeExactly;
		  childCrossMeasureMode = YGFloatIsUndefined(childCrossSize) || isLoosePercentageMeasurement ? YGMeasureModeUndefined : YGMeasureModeExactly;
		}

	tangible.RefObject<Float> tempRef_childMainSize = new tangible.RefObject<Float>(childMainSize);
		YGConstrainMaxSizeForMode(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), availableInnerMainDim, availableInnerWidth, childMainMeasureMode, tempRef_childMainSize);
		childMainSize = tempRef_childMainSize.argValue;
	tangible.RefObject<Float> tempRef_childCrossSize = new tangible.RefObject<Float>(childCrossSize);
		YGConstrainMaxSizeForMode(new YGNode(currentRelativeChild), new YGFlexDirection(crossAxis), availableInnerCrossDim, availableInnerWidth, childCrossMeasureMode, tempRef_childCrossSize);
		childCrossSize = tempRef_childCrossSize.argValue;

		boolean requiresStretchLayout = !YGNodeIsStyleDimDefined(new YGNode(currentRelativeChild), new YGFlexDirection(crossAxis), availableInnerCrossDim) && YGNodeAlignItem(node, new YGNode(currentRelativeChild)) == YGAlignStretch && currentRelativeChild.marginLeadingValue(new YGFlexDirection(crossAxis)).unit != YGUnitAuto && currentRelativeChild.marginTrailingValue(new YGFlexDirection(crossAxis)).unit != YGUnitAuto;

		float childWidth = isMainAxisRow ? childMainSize : childCrossSize;
		float childHeight = !isMainAxisRow ? childMainSize : childCrossSize;

		YGMeasureMode childWidthMeasureMode = isMainAxisRow ? childMainMeasureMode : childCrossMeasureMode;
		YGMeasureMode childHeightMeasureMode = !isMainAxisRow ? childMainMeasureMode : childCrossMeasureMode;

		boolean isLayoutPass = performLayout && !requiresStretchLayout;
		// Recursively call the layout algorithm for this child with the updated
		// main size.
		YGLayoutNodeInternal(new YGNode(currentRelativeChild), childWidth, childHeight, node.getLayout().direction(), new YGMeasureMode(childWidthMeasureMode), new YGMeasureMode(childHeightMeasureMode), availableInnerWidth, availableInnerHeight, isLayoutPass, isLayoutPass ? LayoutPassReason.kFlexLayout : LayoutPassReason.kFlexMeasure, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
		node.setLayoutHadOverflow(node.getLayout().hadOverflow() | currentRelativeChild.getLayout().hadOverflow());
	  }
	  return deltaFreeSpace;
	}

	// It distributes the free space to the flexible items.For those flexible items
	// whose min and max constraints are triggered, those flex item's clamped size
	// is removed from the remaingfreespace.
	public static void YGDistributeFreeSpaceFirstPass(YGCollectFlexItemsRowValues collectedFlexItemsValues, YGFlexDirection mainAxis, float mainAxisownerSize, float availableInnerMainDim, float availableInnerWidth)
	{
	  float flexShrinkScaledFactor = 0F;
	  float flexGrowFactor = 0F;
	  float baseMainSize = 0F;
	  float boundMainSize = 0F;
	  float deltaFreeSpace = 0F;

	  for (var currentRelativeChild : collectedFlexItemsValues.relativeChildren)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: float childFlexBasis = YGNodeBoundAxisWithinMinAndMax(currentRelativeChild, mainAxis, currentRelativeChild->getLayout().computedFlexBasis, mainAxisownerSize).unwrap();
		float childFlexBasis = YGNodeBoundAxisWithinMinAndMax(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), new YGFloatOptional(currentRelativeChild.getLayout().computedFlexBasis), mainAxisownerSize).unwrap();

		if (collectedFlexItemsValues.remainingFreeSpace < 0F)
		{
		  flexShrinkScaledFactor = -currentRelativeChild.resolveFlexShrink() * childFlexBasis;

		  // Is this child able to shrink?
		  if (!YGFloatIsUndefined(flexShrinkScaledFactor) && flexShrinkScaledFactor != 0F)
		  {
			baseMainSize = childFlexBasis + collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexShrinkScaledFactors * flexShrinkScaledFactor;
			boundMainSize = YGNodeBoundAxis(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), baseMainSize, availableInnerMainDim, availableInnerWidth);
			if (!YGFloatIsUndefined(baseMainSize) && !YGFloatIsUndefined(boundMainSize) && baseMainSize != boundMainSize)
			{
			  // By excluding this item's size and flex factor from remaining, this
			  // item's min/max constraints should also trigger in the second pass
			  // resulting in the item's size calculation being identical in the
			  // first and second passes.
			  deltaFreeSpace += boundMainSize - childFlexBasis;
			  collectedFlexItemsValues.totalFlexShrinkScaledFactors -= (-currentRelativeChild.resolveFlexShrink() * currentRelativeChild.getLayout().computedFlexBasis.unwrap());
			}
		  }
		}
		else if (!YGFloatIsUndefined(collectedFlexItemsValues.remainingFreeSpace) && collectedFlexItemsValues.remainingFreeSpace > 0F)
		{
		  flexGrowFactor = currentRelativeChild.resolveFlexGrow();

		  // Is this child able to grow?
		  if (!YGFloatIsUndefined(flexGrowFactor) && flexGrowFactor != 0F)
		  {
			baseMainSize = childFlexBasis + collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexGrowFactors * flexGrowFactor;
			boundMainSize = YGNodeBoundAxis(new YGNode(currentRelativeChild), new YGFlexDirection(mainAxis), baseMainSize, availableInnerMainDim, availableInnerWidth);

			if (!YGFloatIsUndefined(baseMainSize) && !YGFloatIsUndefined(boundMainSize) && baseMainSize != boundMainSize)
			{
			  // By excluding this item's size and flex factor from remaining, this
			  // item's min/max constraints should also trigger in the second pass
			  // resulting in the item's size calculation being identical in the
			  // first and second passes.
			  deltaFreeSpace += boundMainSize - childFlexBasis;
			  collectedFlexItemsValues.totalFlexGrowFactors -= flexGrowFactor;
			}
		  }
		}
	  }
	  collectedFlexItemsValues.remainingFreeSpace -= deltaFreeSpace;
	}

	// Do two passes over the flex items to figure out how to distribute the
	// remaining space.
	//
	// The first pass finds the items whose min/max constraints trigger, freezes
	// them at those sizes, and excludes those sizes from the remaining space.
	//
	// The second pass sets the size of each flexible item. It distributes the
	// remaining space amongst the items whose min/max constraints didn't trigger in
	// the first pass. For the other items, it sets their sizes by forcing their
	// min/max constraints to trigger again.
	//
	// This two pass approach for resolving min/max constraints deviates from the
	// spec. The spec
	// (https://www.w3.org/TR/CSS-flexbox-1/#resolve-flexible-lengths) describes a
	// process that needs to be repeated a variable number of times. The algorithm
	// implemented here won't handle all cases but it was simpler to implement and
	// it mitigates performance concerns because we know exactly how many passes
	// it'll do.
	//
	// At the end of this function the child nodes would have the proper size
	// assigned to them.
	//
	public static void YGResolveFlexibleLength(YGNode node, YGCollectFlexItemsRowValues collectedFlexItemsValues, YGFlexDirection mainAxis, YGFlexDirection crossAxis, float mainAxisownerSize, float availableInnerMainDim, float availableInnerCrossDim, float availableInnerWidth, float availableInnerHeight, boolean flexBasisOverflows, YGMeasureMode measureModeCrossDim, boolean performLayout, YGConfig config, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount)
	{
	  float originalFreeSpace = collectedFlexItemsValues.remainingFreeSpace;
	  // First pass: detect the flex items whose min/max constraints trigger
	  YGDistributeFreeSpaceFirstPass(collectedFlexItemsValues, new YGFlexDirection(mainAxis), mainAxisownerSize, availableInnerMainDim, availableInnerWidth);

	  // Second pass: resolve the sizes of the flexible items
	  float distributedFreeSpace = YGDistributeFreeSpaceSecondPass(collectedFlexItemsValues, node, new YGFlexDirection(mainAxis), new YGFlexDirection(crossAxis), mainAxisownerSize, availableInnerMainDim, availableInnerCrossDim, availableInnerWidth, availableInnerHeight, flexBasisOverflows, new YGMeasureMode(measureModeCrossDim), performLayout, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));

	  collectedFlexItemsValues.remainingFreeSpace = originalFreeSpace - distributedFreeSpace;
	}

	public static void YGJustifyMainAxis(YGNode node, YGCollectFlexItemsRowValues collectedFlexItemsValues, int startOfLineIndex, YGFlexDirection mainAxis, YGFlexDirection crossAxis, YGMeasureMode measureModeMainDim, YGMeasureMode measureModeCrossDim, float mainAxisownerSize, float ownerWidth, float availableInnerMainDim, float availableInnerCrossDim, float availableInnerWidth, boolean performLayout, Object layoutContext)
	{
	  var style = node.getStyle();
	  float leadingPaddingAndBorderMain = node.getLeadingPaddingAndBorder(new YGFlexDirection(mainAxis), ownerWidth).unwrap();
	  float trailingPaddingAndBorderMain = node.getTrailingPaddingAndBorder(new YGFlexDirection(mainAxis), ownerWidth).unwrap();
	  // If we are using "at most" rules in the main axis, make sure that
	  // remainingFreeSpace is 0 when min main dimension is not given
	  if (measureModeMainDim == YGMeasureModeAtMost && collectedFlexItemsValues.remainingFreeSpace > 0F)
	  {
		if (!style.minDimensions().get(dim.get(mainAxis)).isUndefined() && !YGResolveValue(style.minDimensions [dim.get(mainAxis)], mainAxisownerSize).isUndefined())
		{
		  // This condition makes sure that if the size of main dimension(after
		  // considering child nodes main dim, leading and trailing padding etc)
		  // falls below min dimension, then the remainingFreeSpace is reassigned
		  // considering the min dimension

		  // `minAvailableMainDim` denotes minimum available space in which child
		  // can be laid out, it will exclude space consumed by padding and border.
		  float minAvailableMainDim = YGResolveValue(style.minDimensions [dim.get(mainAxis)], mainAxisownerSize).unwrap() - leadingPaddingAndBorderMain - trailingPaddingAndBorderMain;
		  float occupiedSpaceByChildNodes = availableInnerMainDim - collectedFlexItemsValues.remainingFreeSpace;
		  collectedFlexItemsValues.remainingFreeSpace = YGFloatMax(0F, minAvailableMainDim - occupiedSpaceByChildNodes);
		}
		else
		{
		  collectedFlexItemsValues.remainingFreeSpace = 0F;
		}
	  }

	  int numberOfAutoMarginsOnCurrentLine = 0;
	  for (int i = startOfLineIndex; i < collectedFlexItemsValues.endOfLineIndex; i++)
	  {
		YGNode child = node.getChild(new int(i));
		if (child.getStyle().positionType() != YGPositionTypeAbsolute)
		{
		  if (child.marginLeadingValue(new YGFlexDirection(mainAxis)).unit == YGUnitAuto)
		  {
			numberOfAutoMarginsOnCurrentLine++;
		  }
		  if (child.marginTrailingValue(new YGFlexDirection(mainAxis)).unit == YGUnitAuto)
		  {
			numberOfAutoMarginsOnCurrentLine++;
		  }
		}
	  }

	  // In order to position the elements in the main axis, we have two controls.
	  // The space between the beginning and the first element and the space between
	  // each two elements.
	  float leadingMainDim = 0F;
	  float betweenMainDim = 0F;
	  YGJustify justifyContent = node.getStyle().justifyContent();

	  if (numberOfAutoMarginsOnCurrentLine == 0)
	  {
		switch (justifyContent)
		{
		  case YGJustifyCenter:
			leadingMainDim = collectedFlexItemsValues.remainingFreeSpace / 2;
			break;
		  case YGJustifyFlexEnd:
			leadingMainDim = collectedFlexItemsValues.remainingFreeSpace;
			break;
		  case YGJustifySpaceBetween:
			if (collectedFlexItemsValues.itemsOnLine > 1)
			{
			  betweenMainDim = YGFloatMax(collectedFlexItemsValues.remainingFreeSpace, 0F) / (collectedFlexItemsValues.itemsOnLine - 1);
			}
			else
			{
			  betweenMainDim = 0F;
			}
			break;
		  case YGJustifySpaceEvenly:
			// Space is distributed evenly across all elements
			betweenMainDim = collectedFlexItemsValues.remainingFreeSpace / (collectedFlexItemsValues.itemsOnLine + 1);
			leadingMainDim = betweenMainDim;
			break;
		  case YGJustifySpaceAround:
			// Space on the edges is half of the space between elements
			betweenMainDim = collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.itemsOnLine;
			leadingMainDim = betweenMainDim / 2;
			break;
		  case YGJustifyFlexStart:
			break;
		}
	  }

	  collectedFlexItemsValues.mainDim = leadingPaddingAndBorderMain + leadingMainDim;
	  collectedFlexItemsValues.crossDim = 0F;

	  float maxAscentForCurrentLine = 0F;
	  float maxDescentForCurrentLine = 0F;
	  boolean isNodeBaselineLayout = YGIsBaselineLayout(node);
	  for (int i = startOfLineIndex; i < collectedFlexItemsValues.endOfLineIndex; i++)
	  {
		YGNode child = node.getChild(new int(i));
		YGStyle childStyle = child.getStyle();
		YGLayout childLayout = child.getLayout();
		if (childStyle.display() == YGDisplayNone)
		{
		  continue;
		}
		if (childStyle.positionType() == YGPositionTypeAbsolute && child.isLeadingPositionDefined(new YGFlexDirection(mainAxis)))
		{
		  if (performLayout)
		  {
			// In case the child is position absolute and has left/top being
			// defined, we override the position to whatever the user said (and
			// margin/border).
			child.setLayoutPosition(child.getLeadingPosition(new YGFlexDirection(mainAxis), availableInnerMainDim).unwrap() + node.getLeadingBorder(new YGFlexDirection(mainAxis)) + child.getLeadingMargin(new YGFlexDirection(mainAxis), availableInnerWidth).unwrap(), pos.get(mainAxis));
		  }
		}
		else
		{
		  // Now that we placed the element, we need to update the variables.
		  // We need to do that only for relative elements. Absolute elements do not
		  // take part in that phase.
		  if (childStyle.positionType() != YGPositionTypeAbsolute)
		  {
			if (child.marginLeadingValue(new YGFlexDirection(mainAxis)).unit == YGUnitAuto)
			{
			  collectedFlexItemsValues.mainDim += collectedFlexItemsValues.remainingFreeSpace / numberOfAutoMarginsOnCurrentLine;
			}

			if (performLayout)
			{
			  child.setLayoutPosition(childLayout.position.get(pos.get(mainAxis)) + collectedFlexItemsValues.mainDim, pos.get(mainAxis));
			}

			if (child.marginTrailingValue(new YGFlexDirection(mainAxis)).unit == YGUnitAuto)
			{
			  collectedFlexItemsValues.mainDim += collectedFlexItemsValues.remainingFreeSpace / numberOfAutoMarginsOnCurrentLine;
			}
			boolean canSkipFlex = !performLayout && measureModeCrossDim == YGMeasureModeExactly;
			if (canSkipFlex)
			{
			  // If we skipped the flex step, then we can't rely on the measuredDims
			  // because they weren't computed. This means we can't call
			  // YGNodeDimWithMargin.
			  collectedFlexItemsValues.mainDim += betweenMainDim + child.getMarginForAxis(new YGFlexDirection(mainAxis), availableInnerWidth).unwrap() + childLayout.computedFlexBasis.unwrap();
			  collectedFlexItemsValues.crossDim = availableInnerCrossDim;
			}
			else
			{
			  // The main dimension is the sum of all the elements dimension plus
			  // the spacing.
			  collectedFlexItemsValues.mainDim += betweenMainDim + YGNodeDimWithMargin(child, new YGFlexDirection(mainAxis), availableInnerWidth);

			  if (isNodeBaselineLayout)
			  {
				// If the child is baseline aligned then the cross dimension is
				// calculated by adding maxAscent and maxDescent from the baseline.
				float ascent = YGBaseline(child, layoutContext) + child.getLeadingMargin(YGFlexDirectionColumn, availableInnerWidth).unwrap();
				float descent = child.getLayout().measuredDimensions.get(YGDimensionHeight) + child.getMarginForAxis(YGFlexDirectionColumn, availableInnerWidth).unwrap() - ascent;

				maxAscentForCurrentLine = YGFloatMax(maxAscentForCurrentLine, ascent);
				maxDescentForCurrentLine = YGFloatMax(maxDescentForCurrentLine, descent);
			  }
			  else
			  {
				// The cross dimension is the max of the elements dimension since
				// there can only be one element in that cross dimension in the case
				// when the items are not baseline aligned
				collectedFlexItemsValues.crossDim = YGFloatMax(collectedFlexItemsValues.crossDim, YGNodeDimWithMargin(child, new YGFlexDirection(crossAxis), availableInnerWidth));
			  }
			}
		  }
		  else if (performLayout)
		  {
			child.setLayoutPosition(childLayout.position.get(pos.get(mainAxis)) + node.getLeadingBorder(new YGFlexDirection(mainAxis)) + leadingMainDim, pos.get(mainAxis));
		  }
		}
	  }
	  collectedFlexItemsValues.mainDim += trailingPaddingAndBorderMain;

	  if (isNodeBaselineLayout)
	  {
		collectedFlexItemsValues.crossDim = maxAscentForCurrentLine + maxDescentForCurrentLine;
	  }
	}

	//
	// This is the main routine that implements a subset of the flexbox layout
	// algorithm described in the W3C CSS documentation:
	// https://www.w3.org/TR/CSS3-flexbox/.
	//
	// Limitations of this algorithm, compared to the full standard:
	//  * Display property is always assumed to be 'flex' except for Text nodes,
	//    which are assumed to be 'inline-flex'.
	//  * The 'zIndex' property (or any form of z ordering) is not supported. Nodes
	//    are stacked in document order.
	//  * The 'order' property is not supported. The order of flex items is always
	//    defined by document order.
	//  * The 'visibility' property is always assumed to be 'visible'. Values of
	//    'collapse' and 'hidden' are not supported.
	//  * There is no support for forced breaks.
	//  * It does not support vertical inline directions (top-to-bottom or
	//    bottom-to-top text).
	//
	// Deviations from standard:
	//  * Section 4.5 of the spec indicates that all flex items have a default
	//    minimum main size. For text blocks, for example, this is the width of the
	//    widest word. Calculating the minimum width is expensive, so we forego it
	//    and assume a default minimum main size of 0.
	//  * Min/Max sizes in the main axis are not honored when resolving flexible
	//    lengths.
	//  * The spec indicates that the default value for 'flexDirection' is 'row',
	//    but the algorithm below assumes a default of 'column'.
	//
	// Input parameters:
	//    - node: current node to be sized and layed out
	//    - availableWidth & availableHeight: available size to be used for sizing
	//      the node or YGUndefined if the size is not available; interpretation
	//      depends on layout flags
	//    - ownerDirection: the inline (text) direction within the owner
	//      (left-to-right or right-to-left)
	//    - widthMeasureMode: indicates the sizing rules for the width (see below
	//      for explanation)
	//    - heightMeasureMode: indicates the sizing rules for the height (see below
	//      for explanation)
	//    - performLayout: specifies whether the caller is interested in just the
	//      dimensions of the node or it requires the entire node and its subtree to
	//      be layed out (with final positions)
	//
	// Details:
	//    This routine is called recursively to lay out subtrees of flexbox
	//    elements. It uses the information in node.style, which is treated as a
	//    read-only input. It is responsible for setting the layout.direction and
	//    layout.measuredDimensions fields for the input node as well as the
	//    layout.position and layout.lineIndex fields for its child nodes. The
	//    layout.measuredDimensions field includes any border or padding for the
	//    node but does not include margins.
	//
	//    The spec describes four different layout modes: "fill available", "max
	//    content", "min content", and "fit content". Of these, we don't use "min
	//    content" because we don't support default minimum main sizes (see above
	//    for details). Each of our measure modes maps to a layout mode from the
	//    spec (https://www.w3.org/TR/CSS3-sizing/#terms):
	//      - YGMeasureModeUndefined: max content
	//      - YGMeasureModeExactly: fill available
	//      - YGMeasureModeAtMost: fit content
	//
	//    When calling YGNodelayoutImpl and YGLayoutNodeInternal, if the caller
	//    passes an available size of undefined then it must also pass a measure
	//    mode of YGMeasureModeUndefined in that dimension.
	//
	public static void YGNodelayoutImpl(YGNode node, float availableWidth, float availableHeight, YGDirection ownerDirection, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, float ownerWidth, float ownerHeight, boolean performLayout, YGConfig config, LayoutData layoutMarkerData, Object layoutContext, int depth, int generationCount, LayoutPassReason reason)
	{
	  YGAssertWithNode(node, YGFloatIsUndefined(availableWidth) ? widthMeasureMode == YGMeasureModeUndefined : true, "availableWidth is indefinite so widthMeasureMode must be " + "YGMeasureModeUndefined");
	  YGAssertWithNode(node, YGFloatIsUndefined(availableHeight) ? heightMeasureMode == YGMeasureModeUndefined : true, "availableHeight is indefinite so heightMeasureMode must be " + "YGMeasureModeUndefined");

	  (performLayout ? layoutMarkerData.layouts : layoutMarkerData.measures) += 1;

	  // Set the resolved resolution in the node's layout.
	  YGDirection direction = node.resolveDirection(new YGDirection(ownerDirection));
	  node.setLayoutDirection(new YGDirection(direction));

	  YGFlexDirection flexRowDirection = YGResolveFlexDirection(YGFlexDirectionRow, new YGDirection(direction));
	  YGFlexDirection flexColumnDirection = YGResolveFlexDirection(YGFlexDirectionColumn, new YGDirection(direction));

	  YGEdge startEdge = direction == YGDirectionLTR ? YGEdgeLeft : YGEdgeRight;
	  YGEdge endEdge = direction == YGDirectionLTR ? YGEdgeRight : YGEdgeLeft;

	  float marginRowLeading = node.getLeadingMargin(new YGFlexDirection(flexRowDirection), ownerWidth).unwrap();
	  node.setLayoutMargin(marginRowLeading, new YGEdge(startEdge));
	  float marginRowTrailing = node.getTrailingMargin(new YGFlexDirection(flexRowDirection), ownerWidth).unwrap();
	  node.setLayoutMargin(marginRowTrailing, new YGEdge(endEdge));
	  float marginColumnLeading = node.getLeadingMargin(new YGFlexDirection(flexColumnDirection), ownerWidth).unwrap();
	  node.setLayoutMargin(marginColumnLeading, YGEdgeTop);
	  float marginColumnTrailing = node.getTrailingMargin(new YGFlexDirection(flexColumnDirection), ownerWidth).unwrap();
	  node.setLayoutMargin(marginColumnTrailing, YGEdgeBottom);

	  float marginAxisRow = marginRowLeading + marginRowTrailing;
	  float marginAxisColumn = marginColumnLeading + marginColumnTrailing;

	  node.setLayoutBorder(node.getLeadingBorder(new YGFlexDirection(flexRowDirection)), new YGEdge(startEdge));
	  node.setLayoutBorder(node.getTrailingBorder(new YGFlexDirection(flexRowDirection)), new YGEdge(endEdge));
	  node.setLayoutBorder(node.getLeadingBorder(new YGFlexDirection(flexColumnDirection)), YGEdgeTop);
	  node.setLayoutBorder(node.getTrailingBorder(new YGFlexDirection(flexColumnDirection)), YGEdgeBottom);

	  node.setLayoutPadding(node.getLeadingPadding(new YGFlexDirection(flexRowDirection), ownerWidth).unwrap(), new YGEdge(startEdge));
	  node.setLayoutPadding(node.getTrailingPadding(new YGFlexDirection(flexRowDirection), ownerWidth).unwrap(), new YGEdge(endEdge));
	  node.setLayoutPadding(node.getLeadingPadding(new YGFlexDirection(flexColumnDirection), ownerWidth).unwrap(), YGEdgeTop);
	  node.setLayoutPadding(node.getTrailingPadding(new YGFlexDirection(flexColumnDirection), ownerWidth).unwrap(), YGEdgeBottom);

	  if (node.hasMeasureFunc())
	  {
		YGNodeWithMeasureFuncSetMeasuredDimensions(node, availableWidth - marginAxisRow, availableHeight - marginAxisColumn, new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), ownerWidth, ownerHeight, layoutMarkerData, layoutContext, reason);
		return;
	  }

	  int childCount = YGNodeGetChildCount(node);
	  if (childCount == 0)
	  {
		YGNodeEmptyContainerSetMeasuredDimensions(node, availableWidth - marginAxisRow, availableHeight - marginAxisColumn, new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), ownerWidth, ownerHeight);
		return;
	  }

	  // If we're not being asked to perform a full layout we can skip the algorithm
	  // if we already know the size
	  if (!performLayout && YGNodeFixedSizeSetMeasuredDimensions(node, availableWidth - marginAxisRow, availableHeight - marginAxisColumn, new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), ownerWidth, ownerHeight))
	  {
		return;
	  }

	  // At this point we know we're going to perform work. Ensure that each child
	  // has a mutable copy.
	  node.cloneChildrenIfNeeded(layoutContext);
	  // Reset layout flags, as they could have changed.
	  node.setLayoutHadOverflow(false);

	  // STEP 1: CALCULATE VALUES FOR REMAINDER OF ALGORITHM
	  YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), new YGDirection(direction));
	  YGFlexDirection crossAxis = YGFlexDirectionCross(new YGFlexDirection(mainAxis), new YGDirection(direction));
	  boolean isMainAxisRow = YGFlexDirectionIsRow(new YGFlexDirection(mainAxis));
	  boolean isNodeFlexWrap = node.getStyle().flexWrap() != YGWrapNoWrap;

	  float mainAxisownerSize = isMainAxisRow ? ownerWidth : ownerHeight;
	  float crossAxisownerSize = isMainAxisRow ? ownerHeight : ownerWidth;

	  float paddingAndBorderAxisMain = YGNodePaddingAndBorderForAxis(node, new YGFlexDirection(mainAxis), ownerWidth);
	  float leadingPaddingAndBorderCross = node.getLeadingPaddingAndBorder(new YGFlexDirection(crossAxis), ownerWidth).unwrap();
	  float trailingPaddingAndBorderCross = node.getTrailingPaddingAndBorder(new YGFlexDirection(crossAxis), ownerWidth).unwrap();
	  float paddingAndBorderAxisCross = leadingPaddingAndBorderCross + trailingPaddingAndBorderCross;

	  YGMeasureMode measureModeMainDim = isMainAxisRow ? widthMeasureMode : heightMeasureMode;
	  YGMeasureMode measureModeCrossDim = isMainAxisRow ? heightMeasureMode : widthMeasureMode;

	  float paddingAndBorderAxisRow = isMainAxisRow ? paddingAndBorderAxisMain : paddingAndBorderAxisCross;
	  float paddingAndBorderAxisColumn = isMainAxisRow ? paddingAndBorderAxisCross : paddingAndBorderAxisMain;

	  // STEP 2: DETERMINE AVAILABLE SIZE IN MAIN AND CROSS DIRECTIONS

	  float availableInnerWidth = YGNodeCalculateAvailableInnerDim(node, YGDimensionWidth, availableWidth - marginAxisRow, paddingAndBorderAxisRow, ownerWidth);
	  float availableInnerHeight = YGNodeCalculateAvailableInnerDim(node, YGDimensionHeight, availableHeight - marginAxisColumn, paddingAndBorderAxisColumn, ownerHeight);

	  float availableInnerMainDim = isMainAxisRow ? availableInnerWidth : availableInnerHeight;
	  float availableInnerCrossDim = isMainAxisRow ? availableInnerHeight : availableInnerWidth;

	  // STEP 3: DETERMINE FLEX BASIS FOR EACH ITEM

	  float totalOuterFlexBasis = YGNodeComputeFlexBasisForChildren(node, availableInnerWidth, availableInnerHeight, new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), new YGDirection(direction), new YGFlexDirection(mainAxis), config, performLayout, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));

	  boolean flexBasisOverflows = measureModeMainDim == YGMeasureModeUndefined ? false : totalOuterFlexBasis > availableInnerMainDim;
	  if (isNodeFlexWrap && flexBasisOverflows && measureModeMainDim == YGMeasureModeAtMost)
	  {
		measureModeMainDim = YGMeasureModeExactly;
	  }
	  // STEP 4: COLLECT FLEX ITEMS INTO FLEX LINES

	  // Indexes of children that represent the first and last items in the line.
	  int startOfLineIndex = 0;
	  int endOfLineIndex = 0;

	  // Number of lines.
	  int lineCount = 0;

	  // Accumulated cross dimensions of all lines so far.
	  float totalLineCrossDim = 0F;

	  // Max main dimension of all the lines.
	  float maxLineMainDim = 0F;
	  YGCollectFlexItemsRowValues collectedFlexItemsValues = new YGCollectFlexItemsRowValues();
	  for (; endOfLineIndex < childCount; lineCount++, startOfLineIndex = endOfLineIndex)
	  {
	tangible.RefObject<YGNode> tempRef_node = new tangible.RefObject<YGNode>(node);
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: collectedFlexItemsValues = YGCalculateCollectFlexItemsRowValues(node, ownerDirection, mainAxisownerSize, availableInnerWidth, availableInnerMainDim, startOfLineIndex, lineCount);
		collectedFlexItemsValues.copyFrom(YGCalculateCollectFlexItemsRowValues(tempRef_node, new YGDirection(ownerDirection), mainAxisownerSize, availableInnerWidth, availableInnerMainDim, new int(startOfLineIndex), new int(lineCount)));
		node = tempRef_node.argValue;
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: endOfLineIndex = collectedFlexItemsValues.endOfLineIndex;
		endOfLineIndex.copyFrom(collectedFlexItemsValues.endOfLineIndex);

		// If we don't need to measure the cross axis, we can skip the entire flex
		// step.
		boolean canSkipFlex = !performLayout && measureModeCrossDim == YGMeasureModeExactly;

		// STEP 5: RESOLVING FLEXIBLE LENGTHS ON MAIN AXIS
		// Calculate the remaining available space that needs to be allocated. If
		// the main dimension size isn't known, it is computed based on the line
		// length, so there's no more space left to distribute.

		boolean sizeBasedOnContent = false;
		// If we don't measure with exact main dimension we want to ensure we don't
		// violate min and max
		if (measureModeMainDim != YGMeasureModeExactly)
		{
		  var minDimensions = node.getStyle().minDimensions();
		  var maxDimensions = node.getStyle().maxDimensions();
		  float minInnerWidth = YGResolveValue(minDimensions.get(YGDimensionWidth), ownerWidth).unwrap() - paddingAndBorderAxisRow;
		  float maxInnerWidth = YGResolveValue(maxDimensions.get(YGDimensionWidth), ownerWidth).unwrap() - paddingAndBorderAxisRow;
		  float minInnerHeight = YGResolveValue(minDimensions.get(YGDimensionHeight), ownerHeight).unwrap() - paddingAndBorderAxisColumn;
		  float maxInnerHeight = YGResolveValue(maxDimensions.get(YGDimensionHeight), ownerHeight).unwrap() - paddingAndBorderAxisColumn;

		  float minInnerMainDim = isMainAxisRow ? minInnerWidth : minInnerHeight;
		  float maxInnerMainDim = isMainAxisRow ? maxInnerWidth : maxInnerHeight;

		  if (!YGFloatIsUndefined(minInnerMainDim) && collectedFlexItemsValues.sizeConsumedOnCurrentLine < minInnerMainDim)
		  {
			availableInnerMainDim = minInnerMainDim;
		  }
		  else if (!YGFloatIsUndefined(maxInnerMainDim) && collectedFlexItemsValues.sizeConsumedOnCurrentLine > maxInnerMainDim)
		  {
			availableInnerMainDim = maxInnerMainDim;
		  }
		  else
		  {
			if (!node.getConfig().useLegacyStretchBehaviour && ((YGFloatIsUndefined(collectedFlexItemsValues.totalFlexGrowFactors) && collectedFlexItemsValues.totalFlexGrowFactors == 0F) || (YGFloatIsUndefined(node.resolveFlexGrow()) && node.resolveFlexGrow() == 0F)))
			{
			  // If we don't have any children to flex or we can't flex the node
			  // itself, space we've used is all space we need. Root node also
			  // should be shrunk to minimum
			  availableInnerMainDim = collectedFlexItemsValues.sizeConsumedOnCurrentLine;
			}

			if (node.getConfig().useLegacyStretchBehaviour)
			{
			  node.setLayoutDidUseLegacyFlag(true);
			}
			sizeBasedOnContent = !node.getConfig().useLegacyStretchBehaviour;
		  }
		}

		if (!sizeBasedOnContent && !YGFloatIsUndefined(availableInnerMainDim))
		{
		  collectedFlexItemsValues.remainingFreeSpace = availableInnerMainDim - collectedFlexItemsValues.sizeConsumedOnCurrentLine;
		}
		else if (collectedFlexItemsValues.sizeConsumedOnCurrentLine < 0F)
		{
		  // availableInnerMainDim is indefinite which means the node is being sized
		  // based on its content. sizeConsumedOnCurrentLine is negative which means
		  // the node will allocate 0 points for its content. Consequently,
		  // remainingFreeSpace is 0 - sizeConsumedOnCurrentLine.
		  collectedFlexItemsValues.remainingFreeSpace = -collectedFlexItemsValues.sizeConsumedOnCurrentLine;
		}

		if (!canSkipFlex)
		{
		  YGResolveFlexibleLength(node, collectedFlexItemsValues, new YGFlexDirection(mainAxis), new YGFlexDirection(crossAxis), mainAxisownerSize, availableInnerMainDim, availableInnerCrossDim, availableInnerWidth, availableInnerHeight, flexBasisOverflows, new YGMeasureMode(measureModeCrossDim), performLayout, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
		}

		node.setLayoutHadOverflow(node.getLayout().hadOverflow() | (collectedFlexItemsValues.remainingFreeSpace < 0F));

		// STEP 6: MAIN-AXIS JUSTIFICATION & CROSS-AXIS SIZE DETERMINATION

		// At this point, all the children have their dimensions set in the main
		// axis. Their dimensions are also set in the cross axis with the exception
		// of items that are aligned "stretch". We need to compute these stretch
		// values and set the final positions.

		YGJustifyMainAxis(node, collectedFlexItemsValues, new int(startOfLineIndex), new YGFlexDirection(mainAxis), new YGFlexDirection(crossAxis), new YGMeasureMode(measureModeMainDim), new YGMeasureMode(measureModeCrossDim), mainAxisownerSize, ownerWidth, availableInnerMainDim, availableInnerCrossDim, availableInnerWidth, performLayout, layoutContext);

		float containerCrossAxis = availableInnerCrossDim;
		if (measureModeCrossDim == YGMeasureModeUndefined || measureModeCrossDim == YGMeasureModeAtMost)
		{
		  // Compute the cross axis from the max cross dimension of the children.
		  containerCrossAxis = YGNodeBoundAxis(node, new YGFlexDirection(crossAxis), collectedFlexItemsValues.crossDim + paddingAndBorderAxisCross, crossAxisownerSize, ownerWidth) - paddingAndBorderAxisCross;
		}

		// If there's no flex wrap, the cross dimension is defined by the container.
		if (!isNodeFlexWrap && measureModeCrossDim == YGMeasureModeExactly)
		{
		  collectedFlexItemsValues.crossDim = availableInnerCrossDim;
		}

		// Clamp to the min/max size specified on the container.
		collectedFlexItemsValues.crossDim = YGNodeBoundAxis(node, new YGFlexDirection(crossAxis), collectedFlexItemsValues.crossDim + paddingAndBorderAxisCross, crossAxisownerSize, ownerWidth) - paddingAndBorderAxisCross;

		// STEP 7: CROSS-AXIS ALIGNMENT
		// We can skip child alignment if we're just measuring the container.
		if (performLayout)
		{
		  for (int i = startOfLineIndex; i < endOfLineIndex; i++)
		  {
			YGNode child = node.getChild(new int(i));
			if (child.getStyle().display() == YGDisplayNone)
			{
			  continue;
			}
			if (child.getStyle().positionType() == YGPositionTypeAbsolute)
			{
			  // If the child is absolutely positioned and has a
			  // top/left/bottom/right set, override all the previously computed
			  // positions to set it correctly.
			  boolean isChildLeadingPosDefined = child.isLeadingPositionDefined(new YGFlexDirection(crossAxis));
			  if (isChildLeadingPosDefined)
			  {
				child.setLayoutPosition(child.getLeadingPosition(new YGFlexDirection(crossAxis), availableInnerCrossDim).unwrap() + node.getLeadingBorder(new YGFlexDirection(crossAxis)) + child.getLeadingMargin(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap(), pos.get(crossAxis));
			  }
			  // If leading position is not defined or calculations result in Nan,
			  // default to border + margin
			  if (!isChildLeadingPosDefined || YGFloatIsUndefined(child.getLayout().position.get(pos.get(crossAxis))))
			  {
				child.setLayoutPosition(node.getLeadingBorder(new YGFlexDirection(crossAxis)) + child.getLeadingMargin(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap(), pos.get(crossAxis));
			  }
			}
			else
			{
			  float leadingCrossDim = leadingPaddingAndBorderCross;

			  // For a relative children, we're either using alignItems (owner) or
			  // alignSelf (child) in order to determine the position in the cross
			  // axis
			  YGAlign alignItem = YGNodeAlignItem(node, child);

			  // If the child uses align stretch, we need to lay it out one more
			  // time, this time forcing the cross-axis size to be the computed
			  // cross size for the current line.
			  if (alignItem == YGAlignStretch && child.marginLeadingValue(new YGFlexDirection(crossAxis)).unit != YGUnitAuto && child.marginTrailingValue(new YGFlexDirection(crossAxis)).unit != YGUnitAuto)
			  {
				// If the child defines a definite size for its cross axis, there's
				// no need to stretch.
				if (!YGNodeIsStyleDimDefined(child, new YGFlexDirection(crossAxis), availableInnerCrossDim))
				{
				  float childMainSize = child.getLayout().measuredDimensions.get(dim.get(mainAxis));
				  var childStyle = child.getStyle();
				  float childCrossSize = !childStyle.aspectRatio().isUndefined() ? child.getMarginForAxis(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap() + (isMainAxisRow ? childMainSize / childStyle.aspectRatio().unwrap() : childMainSize * childStyle.aspectRatio().unwrap()) : collectedFlexItemsValues.crossDim;

				  childMainSize += child.getMarginForAxis(new YGFlexDirection(mainAxis), availableInnerWidth).unwrap();

				  YGMeasureMode childMainMeasureMode = YGMeasureModeExactly;
				  YGMeasureMode childCrossMeasureMode = YGMeasureModeExactly;
			  tangible.RefObject<Float> tempRef_childMainSize = new tangible.RefObject<Float>(childMainSize);
				  YGConstrainMaxSizeForMode(child, new YGFlexDirection(mainAxis), availableInnerMainDim, availableInnerWidth, childMainMeasureMode, tempRef_childMainSize);
				  childMainSize = tempRef_childMainSize.argValue;
			  tangible.RefObject<Float> tempRef_childCrossSize = new tangible.RefObject<Float>(childCrossSize);
				  YGConstrainMaxSizeForMode(child, new YGFlexDirection(crossAxis), availableInnerCrossDim, availableInnerWidth, childCrossMeasureMode, tempRef_childCrossSize);
				  childCrossSize = tempRef_childCrossSize.argValue;

				  float childWidth = isMainAxisRow ? childMainSize : childCrossSize;
				  float childHeight = !isMainAxisRow ? childMainSize : childCrossSize;

				  var alignContent = node.getStyle().alignContent();
				  var crossAxisDoesNotGrow = alignContent != YGAlignStretch && isNodeFlexWrap;
				  YGMeasureMode childWidthMeasureMode = YGFloatIsUndefined(childWidth) || (!isMainAxisRow && crossAxisDoesNotGrow) ? YGMeasureModeUndefined : YGMeasureModeExactly;
				  YGMeasureMode childHeightMeasureMode = YGFloatIsUndefined(childHeight) || (isMainAxisRow && crossAxisDoesNotGrow) ? YGMeasureModeUndefined : YGMeasureModeExactly;

				  YGLayoutNodeInternal(child, childWidth, childHeight, new YGDirection(direction), new YGMeasureMode(childWidthMeasureMode), new YGMeasureMode(childHeightMeasureMode), availableInnerWidth, availableInnerHeight, true, LayoutPassReason.kStretch, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
				}
			  }
			  else
			  {
				float remainingCrossDim = containerCrossAxis - YGNodeDimWithMargin(child, new YGFlexDirection(crossAxis), availableInnerWidth);

				if (child.marginLeadingValue(new YGFlexDirection(crossAxis)).unit == YGUnitAuto && child.marginTrailingValue(new YGFlexDirection(crossAxis)).unit == YGUnitAuto)
				{
				  leadingCrossDim += YGFloatMax(0.0f, remainingCrossDim / 2);
				}
				else if (child.marginTrailingValue(new YGFlexDirection(crossAxis)).unit == YGUnitAuto)
				{
				  // No-Op
				}
				else if (child.marginLeadingValue(new YGFlexDirection(crossAxis)).unit == YGUnitAuto)
				{
				  leadingCrossDim += YGFloatMax(0.0f, remainingCrossDim);
				}
				else if (alignItem == YGAlignFlexStart)
				{
				  // No-Op
				}
				else if (alignItem == YGAlignCenter)
				{
				  leadingCrossDim += remainingCrossDim / 2;
				}
				else
				{
				  leadingCrossDim += remainingCrossDim;
				}
			  }
			  // And we apply the position
			  child.setLayoutPosition(child.getLayout().position.get(pos.get(crossAxis)) + totalLineCrossDim + leadingCrossDim, pos.get(crossAxis));
			}
		  }
		}

		totalLineCrossDim += collectedFlexItemsValues.crossDim;
		maxLineMainDim = YGFloatMax(maxLineMainDim, collectedFlexItemsValues.mainDim);
	  }

	  // STEP 8: MULTI-LINE CONTENT ALIGNMENT
	  // currentLead stores the size of the cross dim
	  if (performLayout && (isNodeFlexWrap || YGIsBaselineLayout(node)))
	  {
		float crossDimLead = 0F;
		float currentLead = leadingPaddingAndBorderCross;
		if (!YGFloatIsUndefined(availableInnerCrossDim))
		{
		  float remainingAlignContentDim = availableInnerCrossDim - totalLineCrossDim;
		  switch (node.getStyle().alignContent())
		  {
			case YGAlignFlexEnd:
			  currentLead += remainingAlignContentDim;
			  break;
			case YGAlignCenter:
			  currentLead += remainingAlignContentDim / 2;
			  break;
			case YGAlignStretch:
			  if (availableInnerCrossDim > totalLineCrossDim)
			  {
				crossDimLead = remainingAlignContentDim / lineCount;
			  }
			  break;
			case YGAlignSpaceAround:
			  if (availableInnerCrossDim > totalLineCrossDim)
			  {
				currentLead += remainingAlignContentDim / (2 * lineCount);
				if (lineCount > 1)
				{
				  crossDimLead = remainingAlignContentDim / lineCount;
				}
			  }
			  else
			  {
				currentLead += remainingAlignContentDim / 2;
			  }
			  break;
			case YGAlignSpaceBetween:
			  if (availableInnerCrossDim > totalLineCrossDim && lineCount > 1)
			  {
				crossDimLead = remainingAlignContentDim / (lineCount - 1);
			  }
			  break;
			case YGAlignAuto:
			case YGAlignFlexStart:
			case YGAlignBaseline:
			  break;
		  }
		}
		int endIndex = 0;
		for (int i = 0; i < lineCount; i++)
		{
		  int startIndex = new int(endIndex);
		  int ii = new int();

		  // compute the line's height and find the endIndex
		  float lineHeight = 0F;
		  float maxAscentForCurrentLine = 0F;
		  float maxDescentForCurrentLine = 0F;
		  for (ii = startIndex; ii < childCount; ii++)
		  {
			YGNode child = node.getChild(new int(ii));
			if (child.getStyle().display() == YGDisplayNone)
			{
			  continue;
			}
			if (child.getStyle().positionType() != YGPositionTypeAbsolute)
			{
			  if (child.getLineIndex() != i)
			  {
				break;
			  }
			  if (YGNodeIsLayoutDimDefined(child, new YGFlexDirection(crossAxis)))
			  {
				lineHeight = YGFloatMax(lineHeight, child.getLayout().measuredDimensions.get(dim.get(crossAxis)) + child.getMarginForAxis(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap());
			  }
			  if (YGNodeAlignItem(node, child) == YGAlignBaseline)
			  {
				float ascent = YGBaseline(child, layoutContext) + child.getLeadingMargin(YGFlexDirectionColumn, availableInnerWidth).unwrap();
				float descent = child.getLayout().measuredDimensions.get(YGDimensionHeight) + child.getMarginForAxis(YGFlexDirectionColumn, availableInnerWidth).unwrap() - ascent;
				maxAscentForCurrentLine = YGFloatMax(maxAscentForCurrentLine, ascent);
				maxDescentForCurrentLine = YGFloatMax(maxDescentForCurrentLine, descent);
				lineHeight = YGFloatMax(lineHeight, maxAscentForCurrentLine + maxDescentForCurrentLine);
			  }
			}
		  }
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: endIndex = ii;
		  endIndex.copyFrom(ii);
		  lineHeight += crossDimLead;

		  if (performLayout)
		  {
			for (ii = startIndex; ii < endIndex; ii++)
			{
			  YGNode child = node.getChild(new int(ii));
			  if (child.getStyle().display() == YGDisplayNone)
			  {
				continue;
			  }
			  if (child.getStyle().positionType() != YGPositionTypeAbsolute)
			  {
				switch (YGNodeAlignItem(node, child))
				{
				  case YGAlignFlexStart:
				  {
					child.setLayoutPosition(currentLead + child.getLeadingMargin(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap(), pos.get(crossAxis));
					break;
				  }
				  case YGAlignFlexEnd:
				  {
					child.setLayoutPosition(currentLead + lineHeight - child.getTrailingMargin(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap() - child.getLayout().measuredDimensions.get(dim.get(crossAxis)), pos.get(crossAxis));
					break;
				  }
				  case YGAlignCenter:
				  {
					float childHeight = child.getLayout().measuredDimensions.get(dim.get(crossAxis));

					child.setLayoutPosition(currentLead + (lineHeight - childHeight) / 2, pos.get(crossAxis));
					break;
				  }
				  case YGAlignStretch:
				  {
					child.setLayoutPosition(currentLead + child.getLeadingMargin(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap(), pos.get(crossAxis));

					// Remeasure child with the line height as it as been only
					// measured with the owners height yet.
					if (!YGNodeIsStyleDimDefined(child, new YGFlexDirection(crossAxis), availableInnerCrossDim))
					{
					  float childWidth = isMainAxisRow ? (child.getLayout().measuredDimensions.get(YGDimensionWidth) + child.getMarginForAxis(new YGFlexDirection(mainAxis), availableInnerWidth).unwrap()) : lineHeight;

					  float childHeight = !isMainAxisRow ? (child.getLayout().measuredDimensions.get(YGDimensionHeight) + child.getMarginForAxis(new YGFlexDirection(crossAxis), availableInnerWidth).unwrap()) : lineHeight;

					  if (!(YGFloatsEqual(childWidth, child.getLayout().measuredDimensions.get(YGDimensionWidth)) && YGFloatsEqual(childHeight, child.getLayout().measuredDimensions.get(YGDimensionHeight))))
					  {
						YGLayoutNodeInternal(child, childWidth, childHeight, new YGDirection(direction), YGMeasureModeExactly, YGMeasureModeExactly, availableInnerWidth, availableInnerHeight, true, LayoutPassReason.kMultilineStretch, config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
					  }
					}
					break;
				  }
				  case YGAlignBaseline:
				  {
					child.setLayoutPosition(currentLead + maxAscentForCurrentLine - YGBaseline(child, layoutContext) + child.getLeadingPosition(YGFlexDirectionColumn, availableInnerCrossDim).unwrap(), YGEdgeTop);

					break;
				  }
				  case YGAlignAuto:
				  case YGAlignSpaceBetween:
				  case YGAlignSpaceAround:
					break;
				}
			  }
			}
		  }
		  currentLead += lineHeight;
		}
	  }

	  // STEP 9: COMPUTING FINAL DIMENSIONS

	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionRow, availableWidth - marginAxisRow, ownerWidth, ownerWidth), YGDimensionWidth);

	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirectionColumn, availableHeight - marginAxisColumn, ownerHeight, ownerWidth), YGDimensionHeight);

	  // If the user didn't specify a width or height for the node, set the
	  // dimensions based on the children.
	  if (measureModeMainDim == YGMeasureModeUndefined || (node.getStyle().overflow() != YGOverflowScroll && measureModeMainDim == YGMeasureModeAtMost))
	  {
		// Clamp the size to the min/max size, if specified, and make sure it
		// doesn't go below the padding and border amount.
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, new YGFlexDirection(mainAxis), maxLineMainDim, mainAxisownerSize, ownerWidth), dim.get(mainAxis));

	  }
	  else if (measureModeMainDim == YGMeasureModeAtMost && node.getStyle().overflow() == YGOverflowScroll)
	  {
		node.setLayoutMeasuredDimension(YGFloatMax(YGFloatMin(availableInnerMainDim + paddingAndBorderAxisMain, YGNodeBoundAxisWithinMinAndMax(node, new YGFlexDirection(mainAxis), new YGFloatOptional(maxLineMainDim), mainAxisownerSize).unwrap()), paddingAndBorderAxisMain), dim.get(mainAxis));
	  }

	  if (measureModeCrossDim == YGMeasureModeUndefined || (node.getStyle().overflow() != YGOverflowScroll && measureModeCrossDim == YGMeasureModeAtMost))
	  {
		// Clamp the size to the min/max size, if specified, and make sure it
		// doesn't go below the padding and border amount.
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, new YGFlexDirection(crossAxis), totalLineCrossDim + paddingAndBorderAxisCross, crossAxisownerSize, ownerWidth), dim.get(crossAxis));

	  }
	  else if (measureModeCrossDim == YGMeasureModeAtMost && node.getStyle().overflow() == YGOverflowScroll)
	  {
		node.setLayoutMeasuredDimension(YGFloatMax(YGFloatMin(availableInnerCrossDim + paddingAndBorderAxisCross, YGNodeBoundAxisWithinMinAndMax(node, new YGFlexDirection(crossAxis), new YGFloatOptional(totalLineCrossDim + paddingAndBorderAxisCross), crossAxisownerSize).unwrap()), paddingAndBorderAxisCross), dim.get(crossAxis));
	  }

	  // As we only wrapped in normal direction yet, we need to reverse the
	  // positions on wrap-reverse.
	  if (performLayout && node.getStyle().flexWrap() == YGWrapWrapReverse)
	  {
		for (int i = 0; i < childCount; i++)
		{
		  YGNode child = YGNodeGetChild(node, new int(i));
		  if (child.getStyle().positionType() != YGPositionTypeAbsolute)
		  {
			child.setLayoutPosition(node.getLayout().measuredDimensions.get(dim.get(crossAxis)) - child.getLayout().position.get(pos.get(crossAxis)) - child.getLayout().measuredDimensions.get(dim.get(crossAxis)), pos.get(crossAxis));
		  }
		}
	  }

	  if (performLayout)
	  {
		// STEP 10: SIZING AND POSITIONING ABSOLUTE CHILDREN
		for (var child : node.getChildren())
		{
		  if (child.getStyle().display() == YGDisplayNone || child.getStyle().positionType() != YGPositionTypeAbsolute)
		  {
			continue;
		  }
		  YGNodeAbsoluteLayoutChild(node, new YGNode(child), availableInnerWidth, isMainAxisRow ? measureModeMainDim : measureModeCrossDim, availableInnerHeight, new YGDirection(direction), config, layoutMarkerData, layoutContext, new int(depth), new int(generationCount));
		}

		// STEP 11: SETTING TRAILING POSITIONS FOR CHILDREN
		boolean needsMainTrailingPos = mainAxis == YGFlexDirectionRowReverse || mainAxis == YGFlexDirectionColumnReverse;
		boolean needsCrossTrailingPos = crossAxis == YGFlexDirectionRowReverse || crossAxis == YGFlexDirectionColumnReverse;

		// Set trailing position if necessary.
		if (needsMainTrailingPos || needsCrossTrailingPos)
		{
		  for (int i = 0; i < childCount; i++)
		  {
			YGNode child = node.getChild(new int(i));
			if (child.getStyle().display() == YGDisplayNone)
			{
			  continue;
			}
			if (needsMainTrailingPos)
			{
			  YGNodeSetChildTrailingPosition(node, child, new YGFlexDirection(mainAxis));
			}

			if (needsCrossTrailingPos)
			{
			  YGNodeSetChildTrailingPosition(node, child, new YGFlexDirection(crossAxis));
			}
		  }
		}
	  }
	}

	public static boolean gPrintChanges = false;
	public static boolean gPrintSkips = false;

	public static static final String spacer = "                                                            ";

	//C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
	//ORIGINAL LINE: static char* YGSpacer(unsigned long level)
	public static String YGSpacer(int level)
	{
	  long spacerLen = strlen(spacer);
	  if (level > spacerLen)
	  {
		return spacer.charAt(0);
	  }
	  else
	  {
		return spacer.charAt(spacerLen - level);
	  }
	}

	public static String YGMeasureModeName(YGMeasureMode mode, boolean performLayout)
	{
	  var N = enums.<YGMeasureMode>count();
	  String[] kMeasureModeNames = {"UNDEFINED", "EXACTLY", "AT_MOST"};
	  String[] kLayoutModeNames = {"LAY_UNDEFINED", "LAY_EXACTLY", "LAY_AT_MOST"};

	  if (mode >= N)
	  {
		return "";
	  }

	  return performLayout ? kLayoutModeNames[mode] : kMeasureModeNames[mode];
	}

	public static boolean YGMeasureModeSizeIsExactAndMatchesOldMeasuredSize(YGMeasureMode sizeMode, float size, float lastComputedSize)
	{
	  return sizeMode == YGMeasureModeExactly && YGFloatsEqual(size, lastComputedSize);
	}

	public static boolean YGMeasureModeOldSizeIsUnspecifiedAndStillFits(YGMeasureMode sizeMode, float size, YGMeasureMode lastSizeMode, float lastComputedSize)
	{
	  return sizeMode == YGMeasureModeAtMost && lastSizeMode == YGMeasureModeUndefined && (size >= lastComputedSize || YGFloatsEqual(size, lastComputedSize));
	}

	public static boolean YGMeasureModeNewMeasureSizeIsStricterAndStillValid(YGMeasureMode sizeMode, float size, YGMeasureMode lastSizeMode, float lastSize, float lastComputedSize)
	{
	  return lastSizeMode == YGMeasureModeAtMost && sizeMode == YGMeasureModeAtMost && !YGFloatIsUndefined(lastSize) && !YGFloatIsUndefined(size) && !YGFloatIsUndefined(lastComputedSize) && lastSize > size && (lastComputedSize <= size || YGFloatsEqual(size, lastComputedSize));
	}

	public static void YGRoundToPixelGrid(YGNode node, double pointScaleFactor, double absoluteLeft, double absoluteTop)
	{
	  if (pointScaleFactor == 0.0f)
	  {
		return;
	  }

	  double nodeLeft = node.getLayout().position.get(YGEdgeLeft);
	  double nodeTop = node.getLayout().position.get(YGEdgeTop);

	  double nodeWidth = node.getLayout().dimensions.get(YGDimensionWidth);
	  double nodeHeight = node.getLayout().dimensions.get(YGDimensionHeight);

	  double absoluteNodeLeft = absoluteLeft + nodeLeft;
	  double absoluteNodeTop = absoluteTop + nodeTop;

	  double absoluteNodeRight = absoluteNodeLeft + nodeWidth;
	  double absoluteNodeBottom = absoluteNodeTop + nodeHeight;

	  // If a node has a custom measure function we never want to round down its
	  // size as this could lead to unwanted text truncation.
	  boolean textRounding = node.getNodeType() == YGNodeTypeText;

	  node.setLayoutPosition(YGRoundValueToPixelGrid(nodeLeft, pointScaleFactor, false, textRounding), YGEdgeLeft);

	  node.setLayoutPosition(YGRoundValueToPixelGrid(nodeTop, pointScaleFactor, false, textRounding), YGEdgeTop);

	  // We multiply dimension by scale factor and if the result is close to the
	  // whole number, we don't have any fraction To verify if the result is close
	  // to whole number we want to check both floor and ceil numbers
	  boolean hasFractionalWidth = !YGDoubleEqual(fmod(nodeWidth * pointScaleFactor, 1.0), 0) && !YGDoubleEqual(fmod(nodeWidth * pointScaleFactor, 1.0), 1.0);
	  boolean hasFractionalHeight = !YGDoubleEqual(fmod(nodeHeight * pointScaleFactor, 1.0), 0) && !YGDoubleEqual(fmod(nodeHeight * pointScaleFactor, 1.0), 1.0);

	  node.setLayoutDimension(YGRoundValueToPixelGrid(absoluteNodeRight, pointScaleFactor, (textRounding && hasFractionalWidth), (textRounding && !hasFractionalWidth)) - YGRoundValueToPixelGrid(absoluteNodeLeft, pointScaleFactor, false, textRounding), YGDimensionWidth);

	  node.setLayoutDimension(YGRoundValueToPixelGrid(absoluteNodeBottom, pointScaleFactor, (textRounding && hasFractionalHeight), (textRounding && !hasFractionalHeight)) - YGRoundValueToPixelGrid(absoluteNodeTop, pointScaleFactor, false, textRounding), YGDimensionHeight);

	  int childCount = YGNodeGetChildCount(node);
	  for (int i = 0; i < childCount; i++)
	  {
		YGRoundToPixelGrid(YGNodeGetChild(node, new int(i)), pointScaleFactor, absoluteNodeLeft, absoluteNodeTop);
	  }
	}

	public static void unsetUseLegacyFlagRecursively(YGNode node)
	{
	  node.getConfig().useLegacyStretchBehaviour = false;
	  for (var child : node.getChildren())
	  {
		unsetUseLegacyFlagRecursively(new YGNode(child));
	  }
	}

	 public static void YGNodeCalculateLayoutWithContext(YGNode node, float ownerWidth, float ownerHeight, YGDirection ownerDirection, Object layoutContext)
	 {

	  Event.<Event.LayoutPassStart>publish(node, {layoutContext});
	  LayoutData markerData = new LayoutData();

	  // Increment the generation count. This will force the recursive routine to
	  // visit all dirty nodes at least once. Subsequent visits will be skipped if
	  // the input parameters don't change.
	  gCurrentGenerationCount.fetch_add(1, std::memory_order_relaxed);
	  node.resolveDimension();
	  float width = ((float) __nan);
	  YGMeasureMode widthMeasureMode = YGMeasureModeUndefined;
	  var maxDimensions = node.getStyle().maxDimensions();
	  if (YGNodeIsStyleDimDefined(node, YGFlexDirectionRow, ownerWidth))
	  {
		width = (YGResolveValue(node.getResolvedDimension(dim.get(YGFlexDirectionRow)), ownerWidth) + node.getMarginForAxis(YGFlexDirectionRow, ownerWidth)).unwrap();
		widthMeasureMode = YGMeasureModeExactly;
	  }
	  else if (!YGResolveValue(maxDimensions.get(YGDimensionWidth), ownerWidth).isUndefined())
	  {
		width = YGResolveValue(maxDimensions.get(YGDimensionWidth), ownerWidth).unwrap();
		widthMeasureMode = YGMeasureModeAtMost;
	  }
	  else
	  {
		width = ownerWidth;
		widthMeasureMode = YGFloatIsUndefined(width) ? YGMeasureModeUndefined : YGMeasureModeExactly;
	  }

	  float height = ((float) __nan);
	  YGMeasureMode heightMeasureMode = YGMeasureModeUndefined;
	  if (YGNodeIsStyleDimDefined(node, YGFlexDirectionColumn, ownerHeight))
	  {
		height = (YGResolveValue(node.getResolvedDimension(dim.get(YGFlexDirectionColumn)), ownerHeight) + node.getMarginForAxis(YGFlexDirectionColumn, ownerWidth)).unwrap();
		heightMeasureMode = YGMeasureModeExactly;
	  }
	  else if (!YGResolveValue(maxDimensions.get(YGDimensionHeight), ownerHeight).isUndefined())
	  {
		height = YGResolveValue(maxDimensions.get(YGDimensionHeight), ownerHeight).unwrap();
		heightMeasureMode = YGMeasureModeAtMost;
	  }
	  else
	  {
		height = ownerHeight;
		heightMeasureMode = YGFloatIsUndefined(height) ? YGMeasureModeUndefined : YGMeasureModeExactly;
	  }
	  if (YGLayoutNodeInternal(node, width, height, new YGDirection(ownerDirection), new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), ownerWidth, ownerHeight, true, LayoutPassReason.kInitial, node.getConfig(), markerData, layoutContext, 0, gCurrentGenerationCount.load(std::memory_order_relaxed)))
	  {
		node.setPosition(node.getLayout().direction(), ownerWidth, ownerHeight, ownerWidth);
		YGRoundToPixelGrid(node, node.getConfig().pointScaleFactor, 0.0f, 0.0f);

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if DEBUG
		if (node.getConfig().printTree)
		{
		  YGNodePrint(node, (YGPrintOptions)(YGPrintOptionsLayout | YGPrintOptionsChildren | YGPrintOptionsStyle));
		}
	//#endif
	  }

	  Event.<Event.LayoutPassEnd>publish(node, {layoutContext, markerData});

	  // We want to get rid off `useLegacyStretchBehaviour` from YGConfig. But we
	  // aren't sure whether client's of yoga have gotten rid off this flag or not.
	  // So logging this in YGLayout would help to find out the call sites depending
	  // on this flag. This check would be removed once we are sure no one is
	  // dependent on this flag anymore. The flag
	  // `shouldDiffLayoutWithoutLegacyStretchBehaviour` in YGConfig will help to
	  // run experiments.
	  if (node.getConfig().shouldDiffLayoutWithoutLegacyStretchBehaviour && node.didUseLegacyFlag())
	  {
		YGNode nodeWithoutLegacyFlag = YGNodeDeepClone(node);
		nodeWithoutLegacyFlag.resolveDimension();
		// Recursively mark nodes as dirty
		nodeWithoutLegacyFlag.markDirtyAndPropogateDownwards();
		gCurrentGenerationCount.fetch_add(1, std::memory_order_relaxed);
		// Rerun the layout, and calculate the diff
		unsetUseLegacyFlagRecursively(nodeWithoutLegacyFlag);
		LayoutData layoutMarkerData = new LayoutData();
		if (YGLayoutNodeInternal(nodeWithoutLegacyFlag, width, height, new YGDirection(ownerDirection), new YGMeasureMode(widthMeasureMode), new YGMeasureMode(heightMeasureMode), ownerWidth, ownerHeight, true, LayoutPassReason.kInitial, nodeWithoutLegacyFlag.getConfig(), layoutMarkerData, layoutContext, 0, gCurrentGenerationCount.load(std::memory_order_relaxed)))
		{
		  nodeWithoutLegacyFlag.setPosition(nodeWithoutLegacyFlag.getLayout().direction(), ownerWidth, ownerHeight, ownerWidth);
		  YGRoundToPixelGrid(nodeWithoutLegacyFlag, nodeWithoutLegacyFlag.getConfig().pointScaleFactor, 0.0f, 0.0f);

		  // Set whether the two layouts are different or not.
		  var neededLegacyStretchBehaviour = !nodeWithoutLegacyFlag.isLayoutTreeEqualToNode(node);
		  node.setLayoutDoesLegacyFlagAffectsLayout(neededLegacyStretchBehaviour);

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if DEBUG
		  if (nodeWithoutLegacyFlag.getConfig().printTree)
		  {
			YGNodePrint(nodeWithoutLegacyFlag, (YGPrintOptions)(YGPrintOptionsLayout | YGPrintOptionsChildren | YGPrintOptionsStyle));
		  }
	//#endif
		}
		YGConfigFreeRecursive(nodeWithoutLegacyFlag);
		YGNodeFreeRecursive(nodeWithoutLegacyFlag);
	  }
	 }
@FunctionalInterface
interface voidDelegate
{
	std::function <invoke(YGNode node)>& f;
}


	public static void YGTraverseChildrenPreOrder(ArrayList<YGNode> children, voidDelegate void)
	{
	  for (YGNode node : children)
	  {
		f(node);
		YGTraverseChildrenPreOrder(node.getChildren(), f);
	  }
	}


	// operators take YGFloatOptional by value, as it is a 32bit value

	private boolean equalsTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs) || (ConversionHelpers.getValueFromOperator(lhs).isUndefined() && ConversionHelpers.getValueFromOperator(rhs).isUndefined());
	}
	private boolean notEqualsTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return !(ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs));
	}

	private boolean equalsTo(YGFloatOptional lhs, float rhs)
	{
	  return ConversionHelpers.getValueFromOperator(lhs) == YGFloatOptional(ConversionHelpers.getValueFromOperator(rhs));
	}
	private boolean notEqualsTo(YGFloatOptional lhs, float rhs)
	{
	  return !(ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs));
	}

	private boolean equalsTo(float lhs, YGFloatOptional rhs)
	{
	  return ConversionHelpers.getValueFromOperator(rhs) == ConversionHelpers.getValueFromOperator(lhs);
	}
	private boolean notEqualsTo(float lhs, YGFloatOptional rhs)
	{
	  return !(ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs));
	}

//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	YGFloatOptional plus(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return YGFloatOptional(ConversionHelpers.getValueFromOperator(lhs) + ConversionHelpers.getValueFromOperator(rhs));
	}

	private boolean greaterThan(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return ConversionHelpers.getValueFromOperator(lhs) > ConversionHelpers.getValueFromOperator(rhs);
	}

	private boolean lessThan(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return ConversionHelpers.getValueFromOperator(lhs) < ConversionHelpers.getValueFromOperator(rhs);
	}

	private boolean greaterThanOrEqualTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return ConversionHelpers.getValueFromOperator(lhs) > ConversionHelpers.getValueFromOperator(rhs) || ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs);
	}

	private boolean lessThanOrEqualTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return ConversionHelpers.getValueFromOperator(lhs) < ConversionHelpers.getValueFromOperator(rhs) || ConversionHelpers.getValueFromOperator(lhs) == ConversionHelpers.getValueFromOperator(rhs);
	}

	/*
	 * Copyright (c) Facebook, Inc. and its affiliates.
	 *
	 * This source code is licensed under the MIT license found in the
	 * LICENSE file in the root directory of this source tree.
	 */



//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//YG_EXTERN_C_BEGIN void YGNodeCalculateLayoutWithContext(YGNode node, float availableWidth, float availableHeight, YGDirection ownerDirection, Object layoutContext);

//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern java.util.ArrayList<YGEdge> trailing;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern java.util.ArrayList<YGEdge> leading;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern YGValue YGValueUndefined;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern YGValue YGValueAuto;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern YGValue YGValueZero;


	public static float kDefaultFlexGrow = 0.0f;
	public static float kDefaultFlexShrink = 0.0f;
	public static float kWebDefaultFlexShrink = 1.0f;

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//boolean YGFloatsEqual(float a, float b);

}