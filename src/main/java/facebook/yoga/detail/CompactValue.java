package facebook.yoga.detail;

/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */



//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to 'static_assert':
//static_assert(std::numeric_limits<float>::is_iec559, "facebook::yoga::detail::CompactValue only works with IEEE754 floats");

//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
//#if YOGA_COMPACT_VALUE_TEST
//C++ TO JAVA CONVERTER TODO TASK: #define macros defined in multiple preprocessor conditionals can only be replaced within the scope of the preprocessor conditional:
///#define VISIBLE_FOR_TESTING public:
//#else
//C++ TO JAVA CONVERTER TODO TASK: #define macros defined in multiple preprocessor conditionals can only be replaced within the scope of the preprocessor conditional:
///#define VISIBLE_FOR_TESTING private:
//#endif


// This class stores YGValue in 32 bits.
// - The value does not matter for Undefined and Auto. NaNs are used for their
//   representation.
// - To differentiate between Point and Percent, one exponent bit is used.
//   Supported the range [0x40, 0xbf] (0xbf is inclusive for point, but
//   exclusive for percent).
// - Value ranges:
//   points:  1.08420217e-19f to 36893485948395847680
//            0x00000000         0x3fffffff
//   percent: 1.08420217e-19f to 18446742974197923840
//            0x40000000         0x7f7fffff
// - Zero is supported, negative zero is not
// - values outside of the representable range are clamped
public class CompactValue //Type originates from: CompactValue.h
{
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: constexpr boolean operator ==(CompactValue a, CompactValue b) noexcept
  private boolean equalsTo(CompactValue a, CompactValue b) //Method definition originates from: CompactValue.h
  {
	return a.payload_.repr == b.payload_.repr;
  }

  public static final var LOWER_BOUND = 1.08420217e-19f;
  public static final var UPPER_BOUND_POINT = 36893485948395847680.0f;
  public static final var UPPER_BOUND_PERCENT = 18446742974197923840.0f;

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <YGUnit Unit>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Unit> requires YGUnit<Unit>
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static CompactValue of(float value) noexcept
  public static <Unit> CompactValue of(float value)
  {
	if (value == 0.0f || (value < LOWER_BOUND && value > -LOWER_BOUND))
	{
	  final var zero = Unit == YGUnitPercent ? ZERO_BITS_PERCENT : ZERO_BITS_POINT;
	  return new CompactValue(Payload(zero));
	}

	final var upperBound = Unit == YGUnitPercent ? UPPER_BOUND_PERCENT : UPPER_BOUND_POINT;
	if (value > upperBound || value < -upperBound)
	{
	  value = copysignf(upperBound, value);
	}

	int unitBit = Unit == YGUnitPercent ? PERCENT_BIT : 0;
	var data = new Payload((value));
	data.repr -= BIAS;
	data.repr |= unitBit;
	return new CompactValue(data);
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <YGUnit Unit>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Unit> requires YGUnit<Unit>
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static CompactValue ofMaybe(float value) noexcept
  public static <Unit> CompactValue ofMaybe(float value)
  {
	return Float.isNaN(value) || Math.isInfinite(value) ? ofUndefined() : facebook.yoga.detail.CompactValue.<Unit>of(value);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static constexpr CompactValue ofZero() noexcept
  public static CompactValue ofZero()
  {
	return CompactValue
	{
		Payload(ZERO_BITS_POINT)
	};
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static constexpr CompactValue ofUndefined() noexcept
  public static CompactValue ofUndefined()
  {
	return CompactValue();
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: static constexpr CompactValue ofAuto() noexcept
  public static CompactValue ofAuto()
  {
	return CompactValue
	{
		Payload(AUTO_BITS)
	};
  }

  public CompactValue() noexcept
  {
	  this.payload_ = new facebook.yoga.detail.CompactValue.Payload(Float.NaN);
  }

  public CompactValue(YGValue x) noexcept
  {
	  this.payload_ = new facebook.yoga.detail.CompactValue.Payload(int((0)));
	switch (x.unit)
	{
	  case YGUnitUndefined:
		this = ofUndefined();
		break;
	  case YGUnitAuto:
		this = ofAuto();
		break;
	  case YGUnitPoint:
		this = facebook.yoga.detail.CompactValue.<YGUnitPoint>of(x.value);
		break;
	  case YGUnitPercent:
		this = facebook.yoga.detail.CompactValue.<YGUnitPercent>of(x.value);
		break;
	}
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: operator YGValue() noexcept
//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
  operator YGValue() 
  {
	switch (payload_.repr)
	{
	  case AUTO_BITS:
		return YGValueAuto;
	  case ZERO_BITS_POINT:
		return YGValue(0.0f, YGUnitPoint);
	  case ZERO_BITS_PERCENT:
		return YGValue(0.0f, YGUnitPercent);
	}

	if (Float.isNaN(payload_.value))
	{
	  return YGValueUndefined;
	}

	var data = payload_;
	data.repr &= ~PERCENT_BIT;
	data.repr += BIAS;

	return YGValue(data.value, payload_.repr & 0x40000000 != null ? YGUnitPercent : YGUnitPoint);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: boolean isUndefined() noexcept
  public final boolean isUndefined()
  {
	return (payload_.repr != AUTO_BITS && payload_.repr != ZERO_BITS_POINT && payload_.repr != ZERO_BITS_PERCENT && Float.isNaN(payload_.value));
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: boolean isAuto() noexcept
  public final boolean isAuto()
  {
	  return payload_.repr == AUTO_BITS;
  }

//C++ TO JAVA CONVERTER TODO TASK: Unions are not supported in Java:
//  union Payload //Type originates from: CompactValue.h
//  {
//	float value;
//	uint32_t repr;
//	Payload() = delete;
//	constexpr Payload(uint32_t r) : repr(r)
//	{
//	}
//	constexpr Payload(float v) : value(v)
//	{
//	}
//  };

  private static final int BIAS = 0x20000000;
  private static final int PERCENT_BIT = 0x40000000;

  // these are signaling NaNs with specific bit pattern as payload they will be
  // silenced whenever going through an FPU operation on ARM + x86
  private static final int AUTO_BITS = 0x7faaaaaa;
  private static final int ZERO_BITS_POINT = 0x7f8f0f0f;
  private static final int ZERO_BITS_PERCENT = 0x7f80f0f0;

  private CompactValue(Payload data) noexcept
  {
	  this.payload_ = new facebook.yoga.detail.CompactValue.Payload(data);
  }

  private Payload payload_ = new Payload();

//C++ TO JAVA CONVERTER TODO TASK: The #define macro 'VISIBLE_FOR_TESTING' was defined in multiple preprocessor conditionals and cannot be replaced in-line:
  private VISIBLE_FOR_TESTING int repr()
  {
	  return new int(payload_.repr);
  }
}
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::of<YGUnitUndefined>(float) noexcept = delete;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::of<YGUnitAuto>(float) noexcept = delete;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::ofMaybe<YGUnitUndefined>(float) noexcept = delete;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::ofMaybe<YGUnitAuto>(float) noexcept = delete;

