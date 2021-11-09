package facebook.yoga.detail;

//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to 'static_assert':
//static_assert(std::numeric_limits<float>::is_iec559, "facebook::yoga::detail::CompactValue only works with IEEE754 floats");







public class CompactValue //Type originates from: CompactValue.h
{
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
  public static <Unit> CompactValue of(float value)
  {
	if (value == 0.0f || (value < LOWER_BOUND && value > -LOWER_BOUND))
	{
	  final var zero = Unit == YGUnit.YGUnitPercent ? ZERO_BITS_PERCENT : ZERO_BITS_POINT;
	  return new CompactValue(Payload(zero));
	}

	final var upperBound = Unit == YGUnit.YGUnitPercent ? UPPER_BOUND_PERCENT : UPPER_BOUND_POINT;
	if (value > upperBound || value < -upperBound)
	{
	  value = copysignf(upperBound, value);
	}

	Integer unitBit = Unit == YGUnit.YGUnitPercent ? PERCENT_BIT : 0;
	var data = new Payload((value));
	data.repr -= BIAS;
	data.repr |= unitBit;
	return new CompactValue(data);
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <YGUnit Unit>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Unit> requires YGUnit<Unit>
  public static <Unit> CompactValue ofMaybe(float value)
  {
	return Math.isNaN(value) || Math.isInfinite(value) ? ofUndefined() : facebook.yoga.detail.CompactValue.<Unit>of(value);
  }

  public static CompactValue ofZero()
  {
	return CompactValue
	{
		Payload(ZERO_BITS_POINT)
	};
  }

  public static CompactValue ofUndefined()
  {
	return CompactValue();
  }

  public static CompactValue ofAuto()
  {
	return CompactValue
	{
		Payload(AUTO_BITS)
	};
  }

  public CompactValue()
  {
	  this.payload_ = new facebook.yoga.detail.CompactValue.Payload(numeric_limits<Float>.quiet_NaN());
  }

  public CompactValue(final YGValue x)
  {
	  this.payload_ = new facebook.yoga.detail.CompactValue.Payload(Integer((0)));
	switch (x.unit)
	{
	  case YGUnitUndefined:
		this = ofUndefined();
		break;
	  case YGUnitAuto:
		this = ofAuto();
		break;
	  case YGUnitPoint:
		this = facebook.yoga.detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>of(x.value);
		break;
	  case YGUnitPercent:
		this = facebook.yoga.detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>of(x.value);
		break;
	}
  }

//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
  operator YGValue()
  {
	switch (payload_.repr)
	{
	  case AUTO_BITS:
		return YGValueAuto;
	  case ZERO_BITS_POINT:
		return YGValue(0.0f, YGUnit.YGUnitPoint);
	  case ZERO_BITS_PERCENT:
		return YGValue(0.0f, YGUnit.YGUnitPercent);
	}

	if (Math.isNaN(payload_.value))
	{
	  return YGValueUndefined;
	}

	var data = payload_;
	data.repr &= ~PERCENT_BIT;
	data.repr += BIAS;

	return YGValue(data.value, payload_.repr & 0x40000000 != null ? YGUnit.YGUnitPercent : YGUnit.YGUnitPoint);
  }

  public final boolean isUndefined()
  {
	return (payload_.repr != AUTO_BITS && payload_.repr != ZERO_BITS_POINT && payload_.repr != ZERO_BITS_PERCENT && Math.isNaN(payload_.value));
  }

  public final boolean isAuto()
  {
	  return payload_.repr == AUTO_BITS;
  }

  private static class Payload //Type originates from: CompactValue.h
  {
	public float value;
	public Integer repr;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//	Payload() = delete;
	public Payload(Integer r)
	{
		this.repr = r;
	}
	public Payload(float v)
	{
		this.value = v;
	}
  }

  private static final Integer BIAS = 0x20000000;
  private static final Integer PERCENT_BIT = 0x40000000;



  private static final Integer AUTO_BITS = 0x7faaaaaa;
  private static final Integer ZERO_BITS_POINT = 0x7f8f0f0f;
  private static final Integer ZERO_BITS_PERCENT = 0x7f80f0f0;

  private CompactValue(Payload data)
  {
	  this.payload_ = new facebook.yoga.detail.CompactValue.Payload(data);
  }

  private Payload payload_ = new Payload();

  private Integer repr()
  {
	  return (payload_.repr);
  }
}
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::of<YGUnitUndefined>(float) = delete;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::of<YGUnitAuto>(float) = delete;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::ofMaybe<YGUnitUndefined>(float) = delete;
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = delete':
//CompactValue CompactValue::ofMaybe<YGUnitAuto>(float) = delete;

