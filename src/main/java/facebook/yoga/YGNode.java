package facebook.yoga;

import yoga.*;
import facebook.*;
import facebook.yoga.detail.CompactValue;
import java.util.*;
import java.io.*;

//#endif


//C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:

public class YGNode implements Closeable //Type originates from: YGNode.h
{
  @FunctionalInterface
  public interface MeasureWithContextFn
  {
	  YGSize invoke(YGNode UnnamedParameter, float UnnamedParameter2, YGMeasureMode UnnamedParameter3, float UnnamedParameter4, YGMeasureMode UnnamedParameter5, Object UnnamedParameter6);
  }

  @FunctionalInterface
  public interface BaselineWithContextFn
  {
	  float invoke(YGNode UnnamedParameter, float UnnamedParameter2, float UnnamedParameter3, Object UnnamedParameter4);
  }

  @FunctionalInterface
  public interface PrintWithContextFn
  {
	  void invoke(YGNode UnnamedParameter, Object UnnamedParameter2);
  }


  private static final long hasNewLayout_ = 0;
  private static final long isReferenceBaseline_ = 1;
  private static final long isDirty_ = 2;
  private static final long nodeType_ = 3;
  private static final long measureUsesContext_ = 4;
  private static final long baselineUsesContext_ = 5;
  private static final long printUsesContext_ = 6;
  private static final long useWebDefaults_ = 7;

  private Object context_ = null;
  private int flags = 1;
  private int reserved_ = 0;
  private static class measure_Struct //Type originates from: YGNode.h
  {

	public YGMeasureFunc noContext;
	public MeasureWithContextFn withContext;

  }

private measure_Struct measure_ = null;
  private static class baseline_Struct //Type originates from: YGNode.h
  {

	public YGBaselineFunc noContext;
	public BaselineWithContextFn withContext;

  }

private baseline_Struct baseline_ = null;
  private static class print_Struct //Type originates from: YGNode.h
  {

	public YGPrintFunc noContext;
	public PrintWithContextFn withContext;

  }

private print_Struct print_ = null;
  private YGDirtiedFunc dirtied_ = (node) -> null.invoke(node);
  private YGStyle style_ = new YGStyle();
  private YGLayout layout_ = new YGLayout();
  private int lineIndex_ = 0;
  private YGNode owner_ = null;
  private ArrayList<YGNode> children_ = new ArrayList<YGNode>();
  private YGConfig config_;
  private ArrayList<YGValue> resolvedDimensions_ = new ArrayList<YGValue>(Arrays.asList(YGValueUndefined, YGValueUndefined));


  // If both left and right are defined, then use left. Otherwise return +left or
  // -right depending on which is defined.
  private YGFloatOptional relativePosition(YGFlexDirection axis, float axisSize) //Method definition originates from: YGNode.cpp
  {
	if (isLeadingPositionDefined(new YGFlexDirection(axis)))
	{
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return getLeadingPosition(axis, axisSize);
	  return new YGFloatOptional(getLeadingPosition(new YGFlexDirection(axis), axisSize));
	}

	YGFloatOptional trailingPosition = getTrailingPosition(new YGFlexDirection(axis), axisSize);
	if (!trailingPosition.isUndefined())
	{
	  trailingPosition = new YGFloatOptional(-1 * trailingPosition.unwrap());
	}
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return trailingPosition;
	return new YGFloatOptional(trailingPosition);
  }


  // Setters

  private void setMeasureFunc(decltype(YGNode.measure_) measureFunc) //Method definition originates from: YGNode.cpp
  {
	if (measureFunc.noContext == null)
	{
	  // TODO: t18095186 Move nodeType to opt-in function and mark appropriate
	  // places in Litho
	  setNodeType(YGNodeTypeDefault);
	}
	else
	{
	  YGAssertWithNode(this, children_.size() == 0, "Cannot set measure function: Nodes with measure functions cannot have " + "children.");
	  // TODO: t18095186 Move nodeType to opt-in function and mark appropriate
	  // places in Litho
	  setNodeType(YGNodeTypeText);
	}

	measure_ = measureFunc;
  }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//  void setBaselineFunc(decltype(baseline_) UnnamedParameter);

  private void useWebDefaults()
  {
	facebook.yoga.detail.setBooleanData(flags, useWebDefaults_, true);
	style_.flexDirection() = YGFlexDirectionRow;
	style_.alignContent() = YGAlignStretch;
  }

  // DANGER DANGER DANGER!
  // If the node assigned to has children, we'd either have to deallocate
  // them (potentially incorrect) or ignore them (danger of leaks). Only ever
  // use this after checking that there are no children.
  // DO NOT CHANGE THE VISIBILITY OF THIS METHOD!
//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
  private YGNode operator = (YGNode&&)
  {
  }


  public YGNode(YGConfig config)
  {
	  this.config_ = config;
	if (config.useWebDefaults)
	{
	  useWebDefaults();
	}
  }
  public final void close()
  {
  } // cleanup of owner/children relationships in YGNodeFree

//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
  public YGNode(YGNode && node) //Method definition originates from: YGNode.cpp
  {
	context_ = node.context_;
	flags = node.flags;
	measure_ = node.measure_;
	baseline_ = node.baseline_;
	print_ = node.print_;
	dirtied_ = (node) -> node.dirtied_.invoke(node);
	style_ = node.style_;
	layout_ = node.layout_;
	lineIndex_ = node.lineIndex_;
	owner_ = node.owner_;
	children_ = std::move(node.children_);
	config_ = node.config_;
	resolvedDimensions_ = node.resolvedDimensions_;
	for (var c : children_)
	{
	  c.setOwner(this);
	}
  }

  // Does not expose true value semantics, as children are not cloned eagerly.
  // Should we remove this?
  public YGNode(YGNode node)
  {
  }

  // for RB fabric
  public YGNode(YGNode node, YGConfig config) //Method definition originates from: YGNode.cpp
  {
	  this((node));
	config_ = config;
	if (config.useWebDefaults)
	{
	  useWebDefaults();
	}
  }

  // assignment means potential leaks of existing children, or alternatively
  // freeing unowned memory, double free, or freeing stack memory.
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//  YGNode& operator =(YGNode&) = delete;

  // Getters
  public final Object getContext()
  {
	  return context_;
  }

  public final int reserved()
  {
	  return new int(reserved_);
  }
  public final int reserved()
  {
	  return new int(reserved_);
  }

  public final void print(Object printContext) //Method definition originates from: YGNode.cpp
  {
	if (print_.noContext != null)
	{
	  if (facebook.yoga.detail.getBooleanData(flags, printUsesContext_))
	  {
		print_.withContext.invoke(this, printContext);
	  }
	  else
	  {
		print_.noContext.invoke(this);
	  }
	}
  }

  public final boolean getHasNewLayout()
  {
	return facebook.yoga.detail.getBooleanData(flags, hasNewLayout_);
  }

  public final YGNodeType getNodeType()
  {
	return facebook.yoga.detail.<YGNodeType>getEnumData(flags, nodeType_);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: boolean hasMeasureFunc() noexcept
  public final boolean hasMeasureFunc()
  {
	  return measure_.noContext != null;
  }

  public final YGSize measure(float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode, Object layoutContext) //Method definition originates from: YGNode.cpp
  {
	return facebook.yoga.detail.getBooleanData(flags, measureUsesContext_) ? measure_.withContext.invoke(this, width, widthMode, height, heightMode, layoutContext) : measure_.noContext.invoke(this, width, widthMode, height, heightMode);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: boolean hasBaselineFunc() noexcept
  public final boolean hasBaselineFunc()
  {
	return baseline_.noContext != null;
  }

  public final float baseline(float width, float height, Object layoutContext) //Method definition originates from: YGNode.cpp
  {
	return facebook.yoga.detail.getBooleanData(flags, baselineUsesContext_) ? baseline_.withContext.invoke(this, width, height, layoutContext) : baseline_.noContext.invoke(this, width, height);
  }

  public final YGDirtiedFunc getDirtied()
  {
	  return dirtied_;
  }

  // For Performance reasons passing as reference.
  public final YGStyle getStyle()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return style_;
	  return new YGStyle(style_);
  }

  public final YGStyle getStyle()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return style_;
	  return new YGStyle(style_);
  }

  // For Performance reasons passing as reference.
  public final YGLayout getLayout()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return layout_;
	  return new YGLayout(layout_);
  }

  public final YGLayout getLayout()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return layout_;
	  return new YGLayout(layout_);
  }

  public final int getLineIndex()
  {
	  return new int(lineIndex_);
  }

  public final boolean isReferenceBaseline()
  {
	return facebook.yoga.detail.getBooleanData(flags, isReferenceBaseline_);
  }

  // returns the YGNodeRef that owns this YGNode. An owner is used to identify
  // the YogaTree that a YGNode belongs to. This method will return the parent
  // of the YGNode when a YGNode only belongs to one YogaTree or nullptr when
  // the YGNode is shared between two or more YogaTrees.
  public final YGNode getOwner()
  {
	  return owner_;
  }

  // Deprecated, use getOwner() instead.
  public final YGNode getParent()
  {
	  return getOwner();
  }

  public final ArrayList<YGNode> getChildren()
  {
	  return new ArrayList<YGNode>(children_);
  }

  // Applies a callback to all children, after cloning them if they are not
  // owned.
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename T>
  public final <T> void iterChildrenAfterCloningIfNeeded(T callback, Object cloneContext)
  {
	int i = 0;
	for (GlobalMembers.YGNode child : children_)
	{
	  if (child.getOwner() != this)
	  {
		child = config_.cloneNode(child, this, i, cloneContext);
		child.setOwner(this);
	  }
	  i += 1;

	  callback(child, cloneContext);
	}
  }

  public final YGNode getChild(int index)
  {
	  return new YGNode(children_.get(index));
  }

  public final YGConfig getConfig()
  {
	  return config_;
  }

  public final boolean isDirty()
  {
	return facebook.yoga.detail.getBooleanData(flags, isDirty_);
  }

  public final ArrayList<YGValue> getResolvedDimensions()
  {
	return new ArrayList<YGValue>(resolvedDimensions_);
  }

  public final YGValue getResolvedDimension(int index)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return resolvedDimensions_[index];
	return new YGValue(resolvedDimensions_.get(index));
  }

  public static CompactValue computeEdgeValueForColumn(Values<YGEdge> edges, YGEdge edge, CompactValue defaultValue) //Method definition originates from: YGNode.cpp
  {
	if (!edges.get(edge).isUndefined())
	{
	  return edges.get(edge);
	}
	else if (!edges.get(YGEdgeVertical).isUndefined())
	{
	  return edges.get(YGEdgeVertical);
	}
	else if (!edges.get(YGEdgeAll).isUndefined())
	{
	  return edges.get(YGEdgeAll);
	}
	else
	{
	  return new CompactValue(defaultValue);
	}
  }

  public static CompactValue computeEdgeValueForRow(Values<YGEdge> edges, YGEdge rowEdge, YGEdge edge, CompactValue defaultValue) //Method definition originates from: YGNode.cpp
  {
	if (!edges.get(rowEdge).isUndefined())
	{
	  return edges.get(rowEdge);
	}
	else if (!edges.get(edge).isUndefined())
	{
	  return edges.get(edge);
	}
	else if (!edges.get(YGEdgeHorizontal).isUndefined())
	{
	  return edges.get(YGEdgeHorizontal);
	}
	else if (!edges.get(YGEdgeAll).isUndefined())
	{
	  return edges.get(YGEdgeAll);
	}
	else
	{
	  return new CompactValue(defaultValue);
	}
  }

  // Methods related to positions, margin, padding and border
  public final YGFloatOptional getLeadingPosition(YGFlexDirection axis, float axisSize) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var leadingPosition = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.position(), YGEdgeStart, leading[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.position(), leading[axis], CompactValue.ofZero());
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return YGResolveValue(leadingPosition, axisSize);
	return new YGFloatOptional(GlobalMembers.YGResolveValue(new CompactValue(leadingPosition), axisSize));
  }

  public final boolean isLeadingPositionDefined(YGFlexDirection axis) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var leadingPosition = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.position(), YGEdgeStart, leading[axis], CompactValue.ofUndefined()) : computeEdgeValueForColumn(style_.position(), leading[axis], CompactValue.ofUndefined());
	return !leadingPosition.isUndefined();
  }

  public final boolean isTrailingPosDefined(YGFlexDirection axis) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var trailingPosition = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.position(), YGEdgeEnd, trailing[axis], CompactValue.ofUndefined()) : computeEdgeValueForColumn(style_.position(), trailing[axis], CompactValue.ofUndefined());
	return !trailingPosition.isUndefined();
  }

  public final YGFloatOptional getTrailingPosition(YGFlexDirection axis, float axisSize) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var trailingPosition = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.position(), YGEdgeEnd, trailing[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.position(), trailing[axis], CompactValue.ofZero());
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return YGResolveValue(trailingPosition, axisSize);
	return new YGFloatOptional(GlobalMembers.YGResolveValue(new CompactValue(trailingPosition), axisSize));
  }

  public final YGFloatOptional getLeadingMargin(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var leadingMargin = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.margin(), YGEdgeStart, leading[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.margin(), leading[axis], CompactValue.ofZero());
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return YGResolveValueMargin(leadingMargin, widthSize);
	return new YGFloatOptional(GlobalMembers.YGResolveValueMargin(new CompactValue(leadingMargin), widthSize));
  }

  public final YGFloatOptional getTrailingMargin(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var trailingMargin = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.margin(), YGEdgeEnd, trailing[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.margin(), trailing[axis], CompactValue.ofZero());
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return YGResolveValueMargin(trailingMargin, widthSize);
	return new YGFloatOptional(GlobalMembers.YGResolveValueMargin(new CompactValue(trailingMargin), widthSize));
  }

  public final float getLeadingBorder(YGFlexDirection axis) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	YGValue leadingBorder = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.border(), YGEdgeStart, leading[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.border(), leading[axis], CompactValue.ofZero());
	return fmaxf(leadingBorder.value, 0.0f);
  }

  public final float getTrailingBorder(YGFlexDirection axis) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	YGValue trailingBorder = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.border(), YGEdgeEnd, trailing[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.border(), trailing[axis], CompactValue.ofZero());
	return fmaxf(trailingBorder.value, 0.0f);
  }

  public final YGFloatOptional getLeadingPadding(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var leadingPadding = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.padding(), YGEdgeStart, leading[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.padding(), leading[axis], CompactValue.ofZero());
	return YGFloatOptionalMax(GlobalMembers.YGResolveValue(new CompactValue(leadingPadding), widthSize), new YGFloatOptional(0.0f));
  }

  public final YGFloatOptional getTrailingPadding(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
  //C++ TO JAVA CONVERTER TODO TASK: The typedef 'CompactValue' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
	var trailingPadding = GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) ? computeEdgeValueForRow(style_.padding(), YGEdgeEnd, trailing[axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.padding(), trailing[axis], CompactValue.ofZero());
	return YGFloatOptionalMax(GlobalMembers.YGResolveValue(new CompactValue(trailingPadding), widthSize), new YGFloatOptional(0.0f));
  }

  public final YGFloatOptional getLeadingPaddingAndBorder(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
	return getLeadingPadding(new YGFlexDirection(axis), widthSize) + new YGFloatOptional(getLeadingBorder(new YGFlexDirection(axis)));
  }

  public final YGFloatOptional getTrailingPaddingAndBorder(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
	return getTrailingPadding(new YGFlexDirection(axis), widthSize) + new YGFloatOptional(getTrailingBorder(new YGFlexDirection(axis)));
  }

  public final YGFloatOptional getMarginForAxis(YGFlexDirection axis, float widthSize) //Method definition originates from: YGNode.cpp
  {
	return getLeadingMargin(new YGFlexDirection(axis), widthSize) + getTrailingMargin(new YGFlexDirection(axis), widthSize);
  }

  // Setters

  public final void setContext(Object context)
  {
	  context_ = context;
  }

  public final void setPrintFunc(YGPrintFunc printFunc)
  {
	print_.noContext = (node) -> printFunc.invoke(node);
	facebook.yoga.detail.setBooleanData(flags, printUsesContext_, false);
  }
  public final void setPrintFunc(PrintWithContextFn printFunc)
  {
	print_.withContext = (p1, p2) -> printFunc.invoke(p1, p2);
	facebook.yoga.detail.setBooleanData(flags, printUsesContext_, true);
  }
  public final void setPrintFunc(std::nullptr_t UnnamedParameter)
  {
	  setPrintFunc(YGPrintFunc((null)));
  }

  public final void setHasNewLayout(boolean hasNewLayout)
  {
	facebook.yoga.detail.setBooleanData(flags, hasNewLayout_, hasNewLayout);
  }

  public final void setNodeType(YGNodeType nodeType)
  {
	return facebook.yoga.detail.<YGNodeType>setEnumData(flags, nodeType_, nodeType);
  }

  public final void setMeasureFunc(YGMeasureFunc measureFunc) //Method definition originates from: YGNode.cpp
  {
	facebook.yoga.detail.setBooleanData(flags, measureUsesContext_, false);
//C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'decltype':
	decltype(GlobalMembers.YGNode.measure_) m;
	m.noContext = measureFunc;
	setMeasureFunc(m);
  }

  public final void setMeasureFunc(MeasureWithContextFn measureFunc) //Method definition originates from: YGNode.cpp
  {
   facebook.yoga.detail.setBooleanData(flags, measureUsesContext_, true);
//C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'decltype':
   decltype(GlobalMembers.YGNode.measure_) m;
   m.withContext = measureFunc;
   setMeasureFunc(m);
  }

  public final void setMeasureFunc(std::nullptr_t UnnamedParameter)
  {
	return setMeasureFunc(YGMeasureFunc((null)));
  }

  public final void setBaselineFunc(YGBaselineFunc baseLineFunc)
  {
	facebook.yoga.detail.setBooleanData(flags, baselineUsesContext_, false);
	baseline_.noContext = (node, width, height) -> baseLineFunc.invoke(node, width, height);
  }
  public final void setBaselineFunc(BaselineWithContextFn baseLineFunc)
  {
	facebook.yoga.detail.setBooleanData(flags, baselineUsesContext_, true);
	baseline_.withContext = (p1, p2, p3, p4) -> baseLineFunc.invoke(p1, p2, p3, p4);
  }
  public final void setBaselineFunc(std::nullptr_t UnnamedParameter)
  {
	return setBaselineFunc(YGBaselineFunc((null)));
  }

  public final void setDirtiedFunc(YGDirtiedFunc dirtiedFunc)
  {
	  dirtied_ = (node) -> dirtiedFunc.invoke(node);
  }

  public final void setStyle(YGStyle style)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: style_ = style;
	  style_.copyFrom(style);
  }

  public final void setLayout(YGLayout layout)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: layout_ = layout;
	  layout_.copyFrom(layout);
  }

  public final void setLineIndex(int lineIndex)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: lineIndex_ = lineIndex;
	  lineIndex_.copyFrom(lineIndex);
  }

  public final void setIsReferenceBaseline(boolean isReferenceBaseline)
  {
	facebook.yoga.detail.setBooleanData(flags, isReferenceBaseline_, isReferenceBaseline);
  }

  public final void setOwner(YGNode owner)
  {
	  owner_ = owner;
  }

  public final void setChildren(ArrayList<YGNode> children)
  {
	  children_ = new ArrayList<YGNode>(children);
  }

  // TODO: rvalue override for setChildren

//C++ TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to C++ attributes:
//ORIGINAL LINE: [System.Obsolete] void setConfig(struct YGConfig* config)
  public final void setConfig(YGConfig config)
  {
	  config_ = config;
  }

  public final void setDirty(boolean isDirty) //Method definition originates from: YGNode.cpp
  {
	if (isDirty == facebook.yoga.detail.getBooleanData(flags, isDirty_))
	{
	  return;
	}
	facebook.yoga.detail.setBooleanData(flags, isDirty_, isDirty);
	if (isDirty && dirtied_ != null)
	{
	  dirtied_.invoke(this);
	}
  }

  public final void setLayoutLastOwnerDirection(YGDirection direction) //Method definition originates from: YGNode.cpp
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: layout_.lastOwnerDirection = direction;
	layout_.lastOwnerDirection.copyFrom(direction);
  }

  public final void setLayoutComputedFlexBasis(YGFloatOptional computedFlexBasis) //Method definition originates from: YGNode.cpp
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: layout_.computedFlexBasis = computedFlexBasis;
	layout_.computedFlexBasis.copyFrom(computedFlexBasis);
  }

  public final void setLayoutComputedFlexBasisGeneration(int computedFlexBasisGeneration) //Method definition originates from: YGNode.cpp
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: layout_.computedFlexBasisGeneration = computedFlexBasisGeneration;
	layout_.computedFlexBasisGeneration.copyFrom(computedFlexBasisGeneration);
  }

  public final void setLayoutMeasuredDimension(float measuredDimension, int index) //Method definition originates from: YGNode.cpp
  {
	layout_.measuredDimensions.set(index, measuredDimension);
  }

  public final void setLayoutHadOverflow(boolean hadOverflow) //Method definition originates from: YGNode.cpp
  {
	layout_.setHadOverflow(hadOverflow);
  }

  public final void setLayoutDimension(float dimension, int index) //Method definition originates from: YGNode.cpp
  {
	layout_.dimensions.set(index, dimension);
  }

  public final void setLayoutDirection(YGDirection direction) //Method definition originates from: YGNode.cpp
  {
	layout_.setDirection(new YGDirection(direction));
  }

  public final void setLayoutMargin(float margin, int index) //Method definition originates from: YGNode.cpp
  {
	layout_.margin.set(index, margin);
  }

  public final void setLayoutBorder(float border, int index) //Method definition originates from: YGNode.cpp
  {
	layout_.border.set(index, border);
  }

  public final void setLayoutPadding(float padding, int index) //Method definition originates from: YGNode.cpp
  {
	layout_.padding.set(index, padding);
  }

  public final void setLayoutPosition(float position, int index) //Method definition originates from: YGNode.cpp
  {
	layout_.position.set(index, position);
  }

  public final void setPosition(YGDirection direction, float mainSize, float crossSize, float ownerWidth) //Method definition originates from: YGNode.cpp
  {
	/* Root nodes should be always layouted as LTR, so we don't return negative
	 * values. */
	YGDirection directionRespectingRoot = owner_ != null ? direction : YGDirectionLTR;
	YGFlexDirection mainAxis = GlobalMembers.YGResolveFlexDirection(style_.flexDirection(), new YGDirection(directionRespectingRoot));
	YGFlexDirection crossAxis = YGFlexDirectionCross(mainAxis, directionRespectingRoot);

	// Here we should check for `YGPositionTypeStatic` and in this case zero inset
	// properties (left, right, top, bottom, begin, end).
	// https://www.w3.org/TR/css-position-3/#valdef-position-static
	YGFloatOptional relativePositionMain = relativePosition(new YGFlexDirection(mainAxis), mainSize);
	YGFloatOptional relativePositionCross = relativePosition(new YGFlexDirection(crossAxis), crossSize);

	setLayoutPosition((getLeadingMargin(new YGFlexDirection(mainAxis), ownerWidth) + relativePositionMain).unwrap(), leading[mainAxis]);
	setLayoutPosition((getTrailingMargin(new YGFlexDirection(mainAxis), ownerWidth) + relativePositionMain).unwrap(), trailing[mainAxis]);
	setLayoutPosition((getLeadingMargin(new YGFlexDirection(crossAxis), ownerWidth) + relativePositionCross).unwrap(), leading[crossAxis]);
	setLayoutPosition((getTrailingMargin(new YGFlexDirection(crossAxis), ownerWidth) + relativePositionCross).unwrap(), trailing[crossAxis]);
  }

  public final void setLayoutDoesLegacyFlagAffectsLayout(boolean doesLegacyFlagAffectsLayout) //Method definition originates from: YGNode.cpp
  {
	layout_.setDoesLegacyStretchFlagAffectsLayout(doesLegacyFlagAffectsLayout);
  }

  public final void setLayoutDidUseLegacyFlag(boolean didUseLegacyFlag) //Method definition originates from: YGNode.cpp
  {
	layout_.setDidUseLegacyFlag(didUseLegacyFlag);
  }

  public final void markDirtyAndPropogateDownwards() //Method definition originates from: YGNode.cpp
  {
	facebook.yoga.detail.setBooleanData(flags, isDirty_, true);
	for_each(children_.iterator(), children_.end(), (GlobalMembers.YGNode childNode) ->
	{
		childNode.markDirtyAndPropogateDownwards();
	});
  }

  // Other methods
  public final YGValue marginLeadingValue(YGFlexDirection axis) //Method definition originates from: YGNode.cpp
  {
	if (GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) && !style_.margin().get(YGEdgeStart).isUndefined())
	{
	  return style_.margin().get(YGEdgeStart);
	}
	else
	{
	  return style_.margin().get(leading[axis]);
	}
  }

  public final YGValue marginTrailingValue(YGFlexDirection axis) //Method definition originates from: YGNode.cpp
  {
	if (GlobalMembers.YGFlexDirectionIsRow(new YGFlexDirection(axis)) && !style_.margin().get(YGEdgeEnd).isUndefined())
	{
	  return style_.margin().get(YGEdgeEnd);
	}
	else
	{
	  return style_.margin().get(trailing[axis]);
	}
  }

  public final YGValue resolveFlexBasisPtr() //Method definition originates from: YGNode.cpp
  {
	YGValue flexBasis = style_.flexBasis();
	if (flexBasis.unit != YGUnitAuto && flexBasis.unit != YGUnitUndefined)
	{
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexBasis;
	  return new YGValue(flexBasis);
	}
	if (!style_.flex().isUndefined() && style_.flex().unwrap() > 0.0f)
	{
	  return facebook.yoga.detail.getBooleanData(flags, useWebDefaults_) ? YGValueAuto : YGValueZero;
	}
	return YGValueAuto;
  }

  public final void resolveDimension() //Method definition originates from: YGNode.cpp
  {
	YGStyle style = getStyle();
	for (var dim : {YGDimensionWidth, YGDimensionHeight})
	{
	  if (!style.maxDimensions().get(dim).isUndefined() && GlobalMembers.YGValueEqual(style.maxDimensions [dim], style.minDimensions [dim]))
	  {
		resolvedDimensions_.set(dim, style.maxDimensions().get(dim));
	  }
	  else
	  {
		resolvedDimensions_.set(dim, style.dimensions().get(dim));
	  }
	}
  }

  public final YGDirection resolveDirection(YGDirection ownerDirection) //Method definition originates from: YGNode.cpp
  {
	if (style_.direction() == YGDirectionInherit)
	{
	  return ownerDirection > YGDirectionInherit ? ownerDirection : YGDirectionLTR;
	}
	else
	{
	  return new YGDirection(style_.direction());
	}
  }

  public final void clearChildren() //Method definition originates from: YGNode.cpp
  {
   children_.clear();
   children_.shrink_to_fit();
  }

  /// Replaces the occurrences of oldChild with newChild
  public final void replaceChild(YGNode oldChild, YGNode newChild) //Method definition originates from: YGNode.cpp
  {
	std::replace(children_.iterator(), children_.end(), oldChild, newChild);
  }

  public final void replaceChild(YGNode child, int index) //Method definition originates from: YGNode.cpp
  {
	children_.set(index, child);
  }

  public final void insertChild(YGNode child, int index) //Method definition originates from: YGNode.cpp
  {
//C++ TO JAVA CONVERTER TODO TASK: There is no direct equivalent to the STL vector 'insert' method in Java:
	children_.insert(children_.iterator() + index, child);
  }

  /// Removes the first occurrence of child
  public final boolean removeChild(YGNode child) //Method definition originates from: YGNode.cpp
  {
	Iterator<GlobalMembers.YGNode> p = std::find(children_.iterator(), children_.end(), child);
//C++ TO JAVA CONVERTER TODO TASK: Iterators are only converted within the context of 'while' and 'for' loops:
	if (p != children_.end())
	{
//C++ TO JAVA CONVERTER TODO TASK: There is no direct equivalent to the STL vector 'erase' method in Java:
	  children_.erase(p);
	  return true;
	}
	return false;
  }

  public final void removeChild(int index) //Method definition originates from: YGNode.cpp
  {
	children_.remove(index);
  }


  // Other Methods

  public final void cloneChildrenIfNeeded(Object cloneContext) //Method definition originates from: YGNode.cpp
  {
	iterChildrenAfterCloningIfNeeded((GlobalMembers.YGNode UnnamedParameter, Object UnnamedParameter2) ->
	{
	}, cloneContext);
  }

  public final void markDirtyAndPropogate() //Method definition originates from: YGNode.cpp
  {
	if (!facebook.yoga.detail.getBooleanData(flags, isDirty_))
	{
	  setDirty(true);
	  setLayoutComputedFlexBasis(new YGFloatOptional());
	  if (owner_ != null)
	  {
		owner_.markDirtyAndPropogate();
	  }
	}
  }

  public final float resolveFlexGrow() //Method definition originates from: YGNode.cpp
  {
	// Root nodes flexGrow should always be 0
	if (owner_ == null)
	{
	  return 0.0F;
	}
	if (!style_.flexGrow().isUndefined())
	{
	  return style_.flexGrow().unwrap();
	}
	if (!style_.flex().isUndefined() && style_.flex().unwrap() > 0.0f)
	{
	  return style_.flex().unwrap();
	}
	return GlobalMembers.kDefaultFlexGrow;
  }

  public final float resolveFlexShrink() //Method definition originates from: YGNode.cpp
  {
	if (owner_ == null)
	{
	  return 0.0F;
	}
	if (!style_.flexShrink().isUndefined())
	{
	  return style_.flexShrink().unwrap();
	}
	if (!facebook.yoga.detail.getBooleanData(flags, useWebDefaults_) && !style_.flex().isUndefined() && style_.flex().unwrap() < 0.0f)
	{
	  return -style_.flex().unwrap();
	}
	return facebook.yoga.detail.getBooleanData(flags, useWebDefaults_) ? GlobalMembers.kWebDefaultFlexShrink : GlobalMembers.kDefaultFlexShrink;
  }

  public final boolean isNodeFlexible() //Method definition originates from: YGNode.cpp
  {
	return ((style_.positionType() != YGPositionTypeAbsolute) && (resolveFlexGrow() != 0F || resolveFlexShrink() != 0F));
  }

  public final boolean didUseLegacyFlag() //Method definition originates from: YGNode.cpp
  {
	boolean didUseLegacyFlag = layout_.didUseLegacyFlag();
	if (didUseLegacyFlag)
	{
	  return true;
	}
	for (var child : children_)
	{
	  if (child.layout_.didUseLegacyFlag())
	  {
		didUseLegacyFlag = true;
		break;
	  }
	}
	return didUseLegacyFlag;
  }

  public final boolean isLayoutTreeEqualToNode(YGNode node) //Method definition originates from: YGNode.cpp
  {
	if (children_.size() != node.children_.size())
	{
	  return false;
	}
	if (layout_.notEqualsTo(node.layout_))
	{
	  return false;
	}
	if (children_.size() == 0)
	{
	  return true;
	}

	boolean isLayoutTreeEqual = true;
	GlobalMembers.YGNode otherNodeChildren = null;
	for (ArrayList<struct GlobalMembers.YGNode>.longype i = 0; i < children_.size(); ++i)
	{
	  otherNodeChildren = node.children_.get(i);
	  isLayoutTreeEqual = children_.get(i).isLayoutTreeEqualToNode(otherNodeChildren);
	  if (!isLayoutTreeEqual)
	  {
		return false;
	  }
	}
	return isLayoutTreeEqual;
  }

  public final void reset() //Method definition originates from: YGNode.cpp
  {
	YGAssertWithNode(this, children_.size() == 0, "Cannot reset a node which still has children attached");
	YGAssertWithNode(this, owner_ == null, "Cannot reset a node still attached to a owner");

	clearChildren();

	var webDefaults = facebook.yoga.detail.getBooleanData(flags, useWebDefaults_);
	this = new YGNode((getConfig()));
	if (webDefaults != null)
	{
	  useWebDefaults();
	}
  }
}