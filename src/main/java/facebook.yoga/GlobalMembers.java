import java.util.*;

package facebook.yoga;

public class GlobalMembers
{
	public static String LayoutPassReasonToString(LayoutPassReason value) //Method definition originates from: event.cpp
	{
	  switch (value)
	  {
		case kInitial:
		  return "initial";
		case kAbsLayout:
		  return "abs_layout";
		case kStretch:
		  return "stretch";
		case kMultilineStretch:
		  return "multiline_stretch";
		case kFlexLayout:
		  return "flex_layout";
		case kMeasureChild:
		  return "measure";
		case kAbsMeasureChild:
		  return "abs_measure";
		case kFlexMeasure:
		  return "flex_measure";
		default:
		  return "unknown";
	  }
	}

public static std::atomic<Node> subscribers = new std::atomic<Node>(null);

public static Node push(Node newHead)
{
  Node oldHead;
  do
  {
	oldHead = GlobalMembers.subscribers.load(std::memory_order_relaxed);
	if (newHead != null)
	{
	  newHead.next = oldHead;
	}
  } while (!GlobalMembers.subscribers.compare_exchange_weak(oldHead, newHead, std::memory_order_release, std::memory_order_relaxed));
  return oldHead;
}
	/*
	 * Copyright (c) Facebook, Inc. and its affiliates.
	 *
	 * This source code is licensed under the MIT license found in the
	 * LICENSE file in the root directory of this source tree.
	 */

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if DEBUG
	/*
	 * Copyright (c) Facebook, Inc. and its affiliates.
	 *
	 * This source code is licensed under the MIT license found in the
	 * LICENSE file in the root directory of this source tree.
	 */

	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	//#if DEBUG



	public static void YGNodeToString(String str, YGNode node, YGPrintOptions options, int level) //Method definition originates from: YGNodePrint.cpp
	{
	  yoga.GlobalMembers.indent(str, new int(level));
	  appendFormatedString(str, "<div ");

	  if (options & YGPrintOptionsLayout != null)
	  {
		appendFormatedString(str, "layout=\"");
		yoga.GlobalMembers.appendFormatedString(str, "width: %g; ", node.getLayout().dimensions.get(YGDimensionWidth));
		yoga.GlobalMembers.appendFormatedString(str, "height: %g; ", node.getLayout().dimensions.get(YGDimensionHeight));
		yoga.GlobalMembers.appendFormatedString(str, "top: %g; ", node.getLayout().position.get(YGEdgeTop));
		yoga.GlobalMembers.appendFormatedString(str, "left: %g;", node.getLayout().position.get(YGEdgeLeft));
		appendFormatedString(str, "\" ");
	  }

	  if (options & YGPrintOptionsStyle != null)
	  {
		appendFormatedString(str, "style=\"");
		var style = node.getStyle();
		if (style.flexDirection() != (new GlobalMembers.YGNode()).getStyle().flexDirection())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "flex-direction: %s; ", YGFlexDirectionToString(style.flexDirection()));
		}
		if (style.justifyContent() != (new GlobalMembers.YGNode()).getStyle().justifyContent())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "justify-content: %s; ", YGJustifyToString(style.justifyContent()));
		}
		if (style.alignItems() != (new GlobalMembers.YGNode()).getStyle().alignItems())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "align-items: %s; ", YGAlignToString(style.alignItems()));
		}
		if (style.alignContent() != (new GlobalMembers.YGNode()).getStyle().alignContent())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "align-content: %s; ", YGAlignToString(style.alignContent()));
		}
		if (style.alignSelf() != (new GlobalMembers.YGNode()).getStyle().alignSelf())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "align-self: %s; ", YGAlignToString(style.alignSelf()));
		}
		yoga.GlobalMembers.appendFloatOptionalIfDefined(str, "flex-grow", style.flexGrow());
		yoga.GlobalMembers.appendFloatOptionalIfDefined(str, "flex-shrink", style.flexShrink());
		yoga.GlobalMembers.appendNumberIfNotAuto(str, "flex-basis", style.flexBasis());
		yoga.GlobalMembers.appendFloatOptionalIfDefined(str, "flex", style.flex());

		if (style.flexWrap() != (new GlobalMembers.YGNode()).getStyle().flexWrap())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "flex-wrap: %s; ", YGWrapToString(style.flexWrap()));
		}

		if (style.overflow() != (new GlobalMembers.YGNode()).getStyle().overflow())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "overflow: %s; ", YGOverflowToString(style.overflow()));
		}

		if (style.display() != (new GlobalMembers.YGNode()).getStyle().display())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "display: %s; ", YGDisplayToString(style.display()));
		}
		yoga.GlobalMembers.appendEdges(str, "margin", style.margin());
		yoga.GlobalMembers.appendEdges(str, "padding", style.padding());
		yoga.GlobalMembers.appendEdges(str, "border", style.border());

		yoga.GlobalMembers.appendNumberIfNotAuto(str, "width", style.dimensions [YGDimensionWidth]);
		yoga.GlobalMembers.appendNumberIfNotAuto(str, "height", style.dimensions [YGDimensionHeight]);
		yoga.GlobalMembers.appendNumberIfNotAuto(str, "max-width", style.maxDimensions [YGDimensionWidth]);
		yoga.GlobalMembers.appendNumberIfNotAuto(str, "max-height", style.maxDimensions [YGDimensionHeight]);
		yoga.GlobalMembers.appendNumberIfNotAuto(str, "min-width", style.minDimensions [YGDimensionWidth]);
		yoga.GlobalMembers.appendNumberIfNotAuto(str, "min-height", style.minDimensions [YGDimensionHeight]);

		if (style.positionType() != (new GlobalMembers.YGNode()).getStyle().positionType())
		{
		  yoga.GlobalMembers.appendFormatedString(str, "position: %s; ", YGPositionTypeToString(style.positionType()));
		}

		yoga.GlobalMembers.appendEdgeIfNotUndefined(str, "left", style.position(), YGEdgeLeft);
		yoga.GlobalMembers.appendEdgeIfNotUndefined(str, "right", style.position(), YGEdgeRight);
		yoga.GlobalMembers.appendEdgeIfNotUndefined(str, "top", style.position(), YGEdgeTop);
		yoga.GlobalMembers.appendEdgeIfNotUndefined(str, "bottom", style.position(), YGEdgeBottom);
		appendFormatedString(str, "\" ");

		if (node.hasMeasureFunc())
		{
		  appendFormatedString(str, "has-custom-measure=\"true\"");
		}
	  }
	  appendFormatedString(str, ">");

	  int childCount = (int)(node.getChildren().size());
	  if (options & YGPrintOptionsChildren != null && childCount > 0)
	  {
		for (int i = 0; i < childCount; i++)
		{
		  appendFormatedString(str, "\n");
		  yoga.GlobalMembers.YGNodeToString(str, YGNodeGetChild(node, i), new YGPrintOptions(options), level + 1);
		}
		appendFormatedString(str, "\n");
		yoga.GlobalMembers.indent(str, new int(level));
	  }
	  appendFormatedString(str, "</div>");
	}

	//#endif



	public static void indent(String base, int level)
	{
	  for (int i = 0; i < level; ++i)
	  {
		base.append("  ");
	  }
	}

	public static boolean areFourValuesEqual(Values<YGEdge> four)
	{
	  return GlobalMembers.YGValueEqual(four.get(0), four.get(1)) && GlobalMembers.YGValueEqual(four.get(0), four.get(2)) && GlobalMembers.YGValueEqual(four.get(0), four.get(3));
	}

	public static void appendFormatedString(String str, tangible.RefObject<String> fmt, Object... LegacyParamArray)
	{
//	  va_list args;
	  int ParamCount = -1;
//	  va_start(args, fmt);
//	  va_list argsCopy;
	  va_copy(argsCopy, args);
	  ArrayList<Character> buf = new ArrayList<>(1 + vsnprintf(null, 0, fmt.argValue, args));
//	  va_end(args);
	  vsnprintf(buf.data(), buf.size(), fmt.argValue, argsCopy);
//	  va_end(argsCopy);
	  String result = string(buf.iterator(), buf.end() - 1);
	  str.append(result);
	}

	public static void appendFloatOptionalIfDefined(String base, String key, YGFloatOptional num)
	{
	  if (!num.isUndefined())
	  {
		appendFormatedString(base, "%s: %g; ", key, num.unwrap());
	  }
	}

	public static void appendNumberIfNotUndefined(String base, String key, YGValue number)
	{
	  if (number.unit != YGUnitUndefined)
	  {
		if (number.unit == YGUnitAuto)
		{
		  base.append(key + ": auto; ");
		}
		else
		{
		  String unit = number.unit == YGUnitPoint ? "px" : "%%";
		  appendFormatedString(base, "%s: %g%s; ", key, number.value, unit);
		}
	  }
	}

	public static void appendNumberIfNotAuto(String base, String key, YGValue number)
	{
	  if (number.unit != YGUnitAuto)
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: appendNumberIfNotUndefined(base, key, number);
		yoga.GlobalMembers.appendNumberIfNotUndefined(base, key, new YGValue(number));
	  }
	}

	public static void appendNumberIfNotZero(String base, String str, YGValue number)
	{
	  if (number.unit == YGUnitAuto)
	  {
		base.append(str + ": auto; ");
	  }
	  else if (!YGFloatsEqual(number.value, 0))
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: appendNumberIfNotUndefined(base, str, number);
		yoga.GlobalMembers.appendNumberIfNotUndefined(base, str, new YGValue(number));
	  }
	}

	public static void appendEdges(String base, String key, Values<YGEdge> edges)
	{
	  if (yoga.GlobalMembers.areFourValuesEqual(edges))
	  {
		yoga.GlobalMembers.appendNumberIfNotZero(base, key, edges.get(YGEdgeLeft));
	  }
	  else
	  {
		for (int edge = YGEdgeLeft; edge != YGEdgeAll; ++edge)
		{
		  String str = key + "-" + YGEdgeToString((YGEdge)edge);
		  yoga.GlobalMembers.appendNumberIfNotZero(base, str, edges.get(edge));
		}
	  }
	}

	public static void appendEdgeIfNotUndefined(String base, String str, Values<YGEdge> edges, YGEdge edge)
	{
	  // TODO: this doesn't take RTL / YGEdgeStart / YGEdgeEnd into account
	  var value = (edge == YGEdgeLeft || edge == YGEdgeRight) ? GlobalMembers.YGNode.computeEdgeValueForRow(edges, edge, edge, detail.CompactValue.ofUndefined()) : GlobalMembers.YGNode.computeEdgeValueForColumn(edges, edge, detail.CompactValue.ofUndefined());
	  yoga.GlobalMembers.appendNumberIfNotUndefined(base, str, new CompactValue(value));
	}




	public static boolean isUndefined(float value)
	{
	  return Float.isNaN(value);
	}

	public static boolean isUndefined(double value)
	{
	  return Float.isNaN(value);
	}
}