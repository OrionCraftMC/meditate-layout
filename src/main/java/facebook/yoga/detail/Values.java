package facebook.yoga.detail;

import facebook.*;
import java.util.*;

// This value was chosen based on empirical data:
// 98% of analyzed layouts require less than 8 entries.


//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t Size>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Size> requires size_t<Size>
public class Values<Size> //Type originates from: Yoga-internal.h
{
  private ArrayList<CompactValue> values_ = new ArrayList<>(Size);

  public Values()
  {
  }
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: explicit Values(YGValue& defaultValue) noexcept
  public Values(YGValue defaultValue)
  {
	values_.fill(defaultValue);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: CompactValue& operator [](size_t i) noexcept
  public final CompactValue get(long i)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return values_[i];
	  return new facebook.yoga.detail.CompactValue(values_.get(i));
  }
  public final void set(long i, CompactValue value)
  {
	  values_.set(i, value);
  }
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: CompactValue& operator [](size_t i) noexcept
  public final CompactValue get(long i)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return values_[i];
	  return new facebook.yoga.detail.CompactValue(values_.get(i));
  }
  public final void set(long i, CompactValue value)
  {
	  values_.set(i, value);
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t I>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename I> requires size_t<I>
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: YGValue get() noexcept
  public final <I> YGValue get()
  {
	return std::get<I>(values_);
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t I>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename I> requires size_t<I>
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: void set(YGValue& value) noexcept
  public final <I> void set(YGValue value)
  {
	std::get<I>(values_) = value;
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t I>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename I> requires size_t<I>
//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: void set(YGValue&& value) noexcept
//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
  public final <I> void set(YGValue && value)
  {
	this.<I>set(value);
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: boolean operator ==(Values& other) noexcept
  public boolean equalsTo(Values other)
  {
	for (long i = 0; i < Size; ++i)
	{
	  if (values_.get(i) != other.values_.get(i))
	  {
		return false;
	  }
	}
	return true;
  }

//C++ TO JAVA CONVERTER NOTE: This 'copyFrom' method was converted from the original copy assignment operator:
//ORIGINAL LINE: Values& operator =(Values& other)
  public final Values copyFrom(Values other)
  {
  }
}