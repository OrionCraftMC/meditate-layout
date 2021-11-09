package facebook.yoga.detail;

public class GlobalMembers
{
public static void vlog(YGConfig config, YGNode node, YGLogLevel level, Object context, tangible.RefObject<String> format, va_list args)
{
  YGConfig logConfig = config != null ? config : YGConfigGetDefault();
  logConfig.log(logConfig, node, new YGLogLevel(level), context, format, new va_list(args));
}
	/*
	 * Copyright (c) Facebook, Inc. and its affiliates.
	 *
	 * This source code is licensed under the MIT license found in the
	 * LICENSE file in the root directory of this source tree.
	 */





	public static long log2ceilFn(long n)
	{
	  return detail.GlobalMembers.n < 1 ? 0 : (1 + detail.GlobalMembers.log2ceilFn(detail.GlobalMembers.n / 2));
	}

	public static int mask(long bitWidth, long index)
	{
	  return ((1 << bitWidth) - 1) << index;
	}

	// The number of bits necessary to represent enums defined with YG_ENUM_SEQ_DECL
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> long bitWidthFn()
	{
	//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to 'static_assert':
	//  static_assert(enums::count<Enum>() > 0, "Enums must have at least one entries");
	  return new long(detail.GlobalMembers.log2ceilFn(enums.<Enum>count() - 1));
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> Enum getEnumData(int flags, long index)
	{
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
	  return (Enum)((flags & detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), new long(index))) >> index);
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> void setEnumData(tangible.RefObject<int> flags, long index, int newValue)
	{
	  flags.argValue = (flags.argValue & ~detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), new long(index))) | ((newValue << index) & (detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), new long(index))));
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> void setEnumData(tangible.RefObject<int> flags, long index, int newValue)
	{
	  flags.argValue = (flags.argValue & ~(int)detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), new long(index))) | ((newValue << index) & ((int)detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), new long(index))));
	}

	public static boolean getBooleanData(int flags, long index)
	{
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
	  return ((flags >> index) & 1) != 0;
	}

	public static void setBooleanData(int flags, long index, boolean value)
	{
	  if (value)
	  {
		flags |= 1 << index;
	  }
	  else
	  {
		flags &= ~(1 << index);
	  }
	}

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: constexpr boolean operator !=(CompactValue a, CompactValue b) noexcept
	private boolean notEqualsTo(CompactValue a, CompactValue b)
	{
	  return !a.equalsTo(b);
	}
}