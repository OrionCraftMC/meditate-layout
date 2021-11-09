package facebook.yoga;

import facebook.yoga.*;
import facebook.*;
import java.util.*;

public class YGLayout //Type originates from: YGLayout.h
{
  public ArrayList<Float> position = new ArrayList<Float>();
  public ArrayList<Float> dimensions = new ArrayList<Float>(Arrays.asList(YGUndefined, YGUndefined));
  public ArrayList<Float> margin = new ArrayList<Float>();
  public ArrayList<Float> border = new ArrayList<Float>();
  public ArrayList<Float> padding = new ArrayList<Float>();

  private static final Integer directionOffset = 0;
  private static Integer didUseLegacyFlagOffset = directionOffset + facebook.yoga.detail.<YGDirection>bitWidthFn();
  private static final Integer doesLegacyStretchFlagAffectsLayoutOffset = didUseLegacyFlagOffset + 1;
  private static final Integer hadOverflowOffset = doesLegacyStretchFlagAffectsLayoutOffset + 1;
  private Byte flags = 0;

  public Integer computedFlexBasisGeneration = 0;
  public YGFloatOptional computedFlexBasis = new YGFloatOptional();



  public Integer generationCount = 0;
  public YGDirection lastOwnerDirection = YGDirection.YGDirectionInherit;

  public Integer nextCachedMeasurementsIndex = 0;
  public ArrayList<YGCachedMeasurement> cachedMeasurements = new ArrayList<YGCachedMeasurement>();
  public ArrayList<Float> measuredDimensions = new ArrayList<Float>(Arrays.asList(YGUndefined, YGUndefined));

  public YGCachedMeasurement cachedLayout = new YGCachedMeasurement();

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: YGDirection direction() const
  public final YGDirection direction()
  {
	return facebook.yoga.detail.<YGDirection>getEnumData(flags, directionOffset);
  }

  public final void setDirection(YGDirection direction)
  {
	facebook.yoga.detail.<YGDirection>setEnumData(flags, directionOffset, direction);
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean didUseLegacyFlag() const
  public final boolean didUseLegacyFlag()
  {
	return facebook.yoga.detail.getBooleanData(flags, didUseLegacyFlagOffset);
  }

  public final void setDidUseLegacyFlag(boolean val)
  {
	facebook.yoga.detail.setBooleanData(flags, didUseLegacyFlagOffset, val);
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean doesLegacyStretchFlagAffectsLayout() const
  public final boolean doesLegacyStretchFlagAffectsLayout()
  {
	return facebook.yoga.detail.getBooleanData(flags, doesLegacyStretchFlagAffectsLayoutOffset);
  }

  public final void setDoesLegacyStretchFlagAffectsLayout(boolean val)
  {
	facebook.yoga.detail.setBooleanData(flags, doesLegacyStretchFlagAffectsLayoutOffset, val);
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean hadOverflow() const
  public final boolean hadOverflow()
  {
	return facebook.yoga.detail.getBooleanData(flags, hadOverflowOffset);
  }
  public final void setHadOverflow(boolean hadOverflow)
  {
	facebook.yoga.detail.setBooleanData(flags, hadOverflowOffset, hadOverflow);
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean operator ==(YGLayout layout) const
  public boolean equalsTo(YGLayout layout) //Method definition originates from: YGLayout.cpp
  {
	boolean isEqual = GlobalMembers.YGFloatArrayEqual(position, layout.position) && GlobalMembers.YGFloatArrayEqual(dimensions, layout.dimensions) && GlobalMembers.YGFloatArrayEqual(margin, layout.margin) && GlobalMembers.YGFloatArrayEqual(border, layout.border) && GlobalMembers.YGFloatArrayEqual(padding, layout.padding) && direction() == layout.direction() && hadOverflow() == layout.hadOverflow() && lastOwnerDirection == layout.lastOwnerDirection && nextCachedMeasurementsIndex == layout.nextCachedMeasurementsIndex && cachedLayout.equalsTo(layout.cachedLayout) && computedFlexBasis == layout.computedFlexBasis;

	for (Integer i = 0; i < YG_MAX_CACHED_RESULT_COUNT && isEqual; ++i)
	{
	  isEqual = isEqual && cachedMeasurements.get(i).equalsTo(layout.cachedMeasurements.get(i));
	}

	if (!yoga.GlobalMembers.isUndefined(measuredDimensions.get(0)) || !yoga.GlobalMembers.isUndefined(layout.measuredDimensions.get(0)))
	{
	  isEqual = isEqual && (measuredDimensions.get(0) == layout.measuredDimensions.get(0));
	}
	if (!yoga.GlobalMembers.isUndefined(measuredDimensions.get(1)) || !yoga.GlobalMembers.isUndefined(layout.measuredDimensions.get(1)))
	{
	  isEqual = isEqual && (measuredDimensions.get(1) == layout.measuredDimensions.get(1));
	}

	return isEqual;
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean operator !=(YGLayout layout) const
  public boolean notEqualsTo(YGLayout layout)
  {
	  return !(this.equalsTo(layout));
  }
}