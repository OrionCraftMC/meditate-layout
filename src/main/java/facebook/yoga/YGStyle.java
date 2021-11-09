package facebook.yoga;

import java.io.*;

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


public class YGStyle implements Closeable //Type originates from: YGStyle.h
{
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to templates on variables:
  private typedef facebook.yoga.detail.Values<facebook.yoga.enums.<Enum>count(Values)> = new typedef();


//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename T>
  public static class BitfieldRef<T> //Type originates from: YGStyle.h
  {
	public YGStyle style;
	public long offset = new long();
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	operator T()
	{
	  return facebook.yoga.detail.<T>getEnumData(style.flags, offset);
	}
//C++ TO JAVA CONVERTER NOTE: This 'copyFrom' method was converted from the original copy assignment operator:
//ORIGINAL LINE: BitfieldRef<T>& operator =(T x)
	public final BitfieldRef<T> copyFrom(T x)
	{
	  facebook.yoga.detail.<T>setEnumData(style.flags, offset, x);
	  return this;
	}
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <typename T, T YGStyle::*Prop>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename T, typename YGStyle> requires T<YGStyle>
  public static class Ref<T, YGStyle> //Type originates from: YGStyle.h
  {
	public YGStyle style;
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	operator T()
	{
		return style.*Prop;
	}
//C++ TO JAVA CONVERTER NOTE: This 'copyFrom' method was converted from the original copy assignment operator:
//ORIGINAL LINE: Ref<T, Prop>& operator =(T value)
	public final Ref<T, Prop> copyFrom(T value)
	{
	  style. Prop = value;
	  return this;
	}
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <typename Idx, Values<Idx> YGStyle::*Prop>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Idx, typename > requires Values<>
  public YGStyle.*Prop > static class IdxRef<Idx, > //Type originates from: YGStyle.h
  {
	public static class Ref //Type originates from: YGStyle.h
	{
	  public YGStyle style;
	  public Idx idx = new Idx();
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	  operator CompactValue()
	  {
		  return style.*Prop[idx];
	  }
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	  operator YGValue()
	  {
		  return style.*Prop[idx];
	  }
//C++ TO JAVA CONVERTER NOTE: This 'copyFrom' method was converted from the original copy assignment operator:
//ORIGINAL LINE: Ref& operator =(CompactValue value)
	  public final Ref copyFrom(CompactValue value)
	  {
		(style.*Prop)[idx] = value;
		return this;
	  }
	}

	public YGStyle style;
//C++ TO JAVA CONVERTER NOTE: This 'copyFrom' method was converted from the original copy assignment operator:
//ORIGINAL LINE: IdxRef<Idx, Prop>& operator =(Values<Idx>& values)
	public final IdxRef<Idx, Prop> copyFrom(Values<Idx> values)
	{
	  style. Prop = values;
	  return this;
	}
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	operator Values<Idx>&()
	{
		return style.*Prop;
	}
	public final Ref get(Idx idx)
	{
		return new Ref(style, idx);
	}
	public final CompactValue get(Idx idx)
	{
		return style.*Prop[idx];
	}
  }

  public YGStyle()
  {
	alignContent() = YGAlignFlexStart;
	alignItems() = YGAlignStretch;
  }
  public final void close()
  {
  }

  private static final long directionOffset = 0;
  private static long flexdirectionOffset = directionOffset + facebook.yoga.detail.<YGDirection>bitWidthFn();
  private static long justifyContentOffset = flexdirectionOffset + facebook.yoga.detail.<YGFlexDirection>bitWidthFn();
  private static long alignContentOffset = justifyContentOffset + facebook.yoga.detail.<YGJustify>bitWidthFn();
  private static long alignItemsOffset = alignContentOffset + facebook.yoga.detail.<YGAlign>bitWidthFn();
  private static long alignSelfOffset = alignItemsOffset + facebook.yoga.detail.<YGAlign>bitWidthFn();
  private static long positionTypeOffset = alignSelfOffset + facebook.yoga.detail.<YGAlign>bitWidthFn();
  private static long flexWrapOffset = positionTypeOffset + facebook.yoga.detail.<YGPositionType>bitWidthFn();
  private static long overflowOffset = flexWrapOffset + facebook.yoga.detail.<YGWrap>bitWidthFn();
  private static long displayOffset = overflowOffset + facebook.yoga.detail.<YGOverflow>bitWidthFn();

  private int flags = 0;

  private YGFloatOptional flex_ = new YGFloatOptional();
  private YGFloatOptional flexGrow_ = new YGFloatOptional();
  private YGFloatOptional flexShrink_ = new YGFloatOptional();
  private facebook.yoga.detail.CompactValue flexBasis_ = facebook.yoga.detail.CompactValue.ofAuto();
  private Values<YGEdge> margin_ = new Values<YGEdge>();
  private Values<YGEdge> position_ = new Values<YGEdge>();
  private Values<YGEdge> padding_ = new Values<YGEdge>();
  private Values<YGEdge> border_ = new Values<YGEdge>();
  private Values<YGDimension> dimensions_ = new Values<YGDimension>(facebook.yoga.detail.CompactValue.ofAuto());
  private Values<YGDimension> minDimensions_ = new Values<YGDimension>();
  private Values<YGDimension> maxDimensions_ = new Values<YGDimension>();
  // Yoga specific properties, not compatible with flexbox specification
  private YGFloatOptional aspectRatio_ = new YGFloatOptional();

  // for library users needing a type
  public typedef std::remove_reference<decltype(margin_[0]ValueRepr)>.type = new typedef();

  public final YGDirection direction()
  {
	return facebook.yoga.detail.<YGDirection>getEnumData(flags, directionOffset);
  }
  public final BitfieldRef<YGDirection> direction()
  {
	  return new BitfieldRef(this, directionOffset);
  }

  public final YGFlexDirection flexDirection()
  {
	return facebook.yoga.detail.<YGFlexDirection>getEnumData(flags, flexdirectionOffset);
  }
  public final BitfieldRef<YGFlexDirection> flexDirection()
  {
	return new BitfieldRef(this, flexdirectionOffset);
  }

  public final YGJustify justifyContent()
  {
	return facebook.yoga.detail.<YGJustify>getEnumData(flags, justifyContentOffset);
  }
  public final BitfieldRef<YGJustify> justifyContent()
  {
	return new BitfieldRef(this, justifyContentOffset);
  }

  public final YGAlign alignContent()
  {
	return facebook.yoga.detail.<YGAlign>getEnumData(flags, alignContentOffset);
  }
  public final BitfieldRef<YGAlign> alignContent()
  {
	  return new BitfieldRef(this, alignContentOffset);
  }

  public final YGAlign alignItems()
  {
	return facebook.yoga.detail.<YGAlign>getEnumData(flags, alignItemsOffset);
  }
  public final BitfieldRef<YGAlign> alignItems()
  {
	  return new BitfieldRef(this, alignItemsOffset);
  }

  public final YGAlign alignSelf()
  {
	return facebook.yoga.detail.<YGAlign>getEnumData(flags, alignSelfOffset);
  }
  public final BitfieldRef<YGAlign> alignSelf()
  {
	  return new BitfieldRef(this, alignSelfOffset);
  }

  public final YGPositionType positionType()
  {
	return facebook.yoga.detail.<YGPositionType>getEnumData(flags, positionTypeOffset);
  }
  public final BitfieldRef<YGPositionType> positionType()
  {
	return new BitfieldRef(this, positionTypeOffset);
  }

  public final YGWrap flexWrap()
  {
	return facebook.yoga.detail.<YGWrap>getEnumData(flags, flexWrapOffset);
  }
  public final BitfieldRef<YGWrap> flexWrap()
  {
	  return new BitfieldRef(this, flexWrapOffset);
  }

  public final YGOverflow overflow()
  {
	return facebook.yoga.detail.<YGOverflow>getEnumData(flags, overflowOffset);
  }
  public final BitfieldRef<YGOverflow> overflow()
  {
	  return new BitfieldRef(this, overflowOffset);
  }

  public final YGDisplay display()
  {
	return facebook.yoga.detail.<YGDisplay>getEnumData(flags, displayOffset);
  }
  public final BitfieldRef<YGDisplay> display()
  {
	  return new BitfieldRef(this, displayOffset);
  }

  public final YGFloatOptional flex()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flex_;
	  return new YGFloatOptional(flex_);
  }
  public final Ref<YGFloatOptional, &YGStyle.flex_> flex()
  {
	  return new Ref(this);
  }

  public final YGFloatOptional flexGrow()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexGrow_;
	  return new YGFloatOptional(flexGrow_);
  }
  public final Ref<YGFloatOptional, &YGStyle.flexGrow_> flexGrow()
  {
	  return new Ref(this);
  }

  public final YGFloatOptional flexShrink()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexShrink_;
	  return new YGFloatOptional(flexShrink_);
  }
  public final Ref<YGFloatOptional, &YGStyle.flexShrink_> flexShrink()
  {
	  return new Ref(this);
  }

  public final facebook.yoga.detail.CompactValue flexBasis()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexBasis_;
	  return new facebook.yoga.detail.CompactValue(flexBasis_);
  }
  public final Ref<facebook.yoga.detail.CompactValue, &YGStyle.flexBasis_> flexBasis()
  {
	  return new Ref(this);
  }

  public final Values<YGEdge> margin()
  {
	  return new Values<YGEdge>(margin_);
  }
  public final IdxRef<YGEdge, &YGStyle.margin_> margin()
  {
	  return new IdxRef<YGEdge, this.margin_>(this);
  }

  public final Values<YGEdge> position()
  {
	  return new Values<YGEdge>(position_);
  }
  public final IdxRef<YGEdge, &YGStyle.position_> position()
  {
	  return new IdxRef<YGEdge, this.position_>(this);
  }

  public final Values<YGEdge> padding()
  {
	  return new Values<YGEdge>(padding_);
  }
  public final IdxRef<YGEdge, &YGStyle.padding_> padding()
  {
	  return new IdxRef<YGEdge, this.padding_>(this);
  }

  public final Values<YGEdge> border()
  {
	  return new Values<YGEdge>(border_);
  }
  public final IdxRef<YGEdge, &YGStyle.border_> border()
  {
	  return new IdxRef<YGEdge, this.border_>(this);
  }

  public final Values<YGDimension> dimensions()
  {
	  return new Values<YGDimension>(dimensions_);
  }
  public final IdxRef<YGDimension, &YGStyle.dimensions_> dimensions()
  {
	  return new IdxRef<YGDimension, this.dimensions_>(this);
  }

  public final Values<YGDimension> minDimensions()
  {
	  return new Values<YGDimension>(minDimensions_);
  }
  public final IdxRef<YGDimension, &YGStyle.minDimensions_> minDimensions()
  {
	return new IdxRef<YGDimension, this.minDimensions_>(this);
  }

  public final Values<YGDimension> maxDimensions()
  {
	  return new Values<YGDimension>(maxDimensions_);
  }
  public final IdxRef<YGDimension, &YGStyle.maxDimensions_> maxDimensions()
  {
	return new IdxRef<YGDimension, this.maxDimensions_>(this);
  }

  // Yoga specific properties, not compatible with flexbox specification
  public final YGFloatOptional aspectRatio()
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return aspectRatio_;
	  return new YGFloatOptional(aspectRatio_);
  }
  public final Ref<YGFloatOptional, &YGStyle.aspectRatio_> aspectRatio()
  {
	  return new Ref(this);
  }
}