package facebook.yoga;

public class YGFloatOptional //Type originates from: YGFloatOptional.h
{
  private float value_ = numeric_limits<Float>.quiet_NaN();

  public YGFloatOptional(float value)
  {
	  this.value_ = value;
  }
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = default':
//  constexpr YGFloatOptional() = default;


//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: constexpr float unwrap() const
  public final float unwrap()
  {
	  return value_;
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean isUndefined() const
  public final boolean isUndefined()
  {
	  return Math.isNaN(value_);
  }
}