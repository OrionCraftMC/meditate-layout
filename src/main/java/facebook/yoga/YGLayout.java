package facebook.yoga;

import facebook.yoga.*;
import facebook.*;
import java.util.*;

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





public class YGLayout //Type originates from: YGLayout.h
{
  public ArrayList<Float> position = new ArrayList<Float>();
  public ArrayList<Float> dimensions = new ArrayList<Float>(Arrays.asList((*(float*) __nan), (*(float*) __nan)));
  public ArrayList<Float> margin = new ArrayList<Float>();
  public ArrayList<Float> border = new ArrayList<Float>();
  public ArrayList<Float> padding = new ArrayList<Float>();

  private static final long directionOffset = 0;
  private static long didUseLegacyFlagOffset = directionOffset + facebook.yoga.detail.<YGDirection>bitWidthFn();
  private static final long doesLegacyStretchFlagAffectsLayoutOffset = didUseLegacyFlagOffset + 1;
  private static final long hadOverflowOffset = doesLegacyStretchFlagAffectsLayoutOffset + 1;
  private int flags = 0;

  public int computedFlexBasisGeneration = 0;
  public YGFloatOptional computedFlexBasis = new YGFloatOptional();

  // Instead of recomputing the entire layout every single time, we cache some
  // information to break early when nothing changed
  public int generationCount = 0;
  public YGDirection lastOwnerDirection = YGDirectionInherit;

  public int nextCachedMeasurementsIndex = 0;
  public ArrayList<YGCachedMeasurement> cachedMeasurements = new ArrayList<YGCachedMeasurement>();
  public ArrayList<Float> measuredDimensions = new ArrayList<Float>(Arrays.asList((*(float*) __nan), (*(float*) __nan)));

  public YGCachedMeasurement cachedLayout = new YGCachedMeasurement();

  public final YGDirection direction()
  {
	return facebook.yoga.detail.<YGDirection>getEnumData(flags, directionOffset);
  }

  public final void setDirection(YGDirection direction)
  {
	facebook.yoga.detail.<YGDirection>setEnumData(flags, directionOffset, direction);
  }

  public final boolean didUseLegacyFlag()
  {
	return facebook.yoga.detail.getBooleanData(flags, didUseLegacyFlagOffset);
  }

  public final void setDidUseLegacyFlag(boolean val)
  {
	facebook.yoga.detail.setBooleanData(flags, didUseLegacyFlagOffset, val);
  }

  public final boolean doesLegacyStretchFlagAffectsLayout()
  {
	return facebook.yoga.detail.getBooleanData(flags, doesLegacyStretchFlagAffectsLayoutOffset);
  }

  public final void setDoesLegacyStretchFlagAffectsLayout(boolean val)
  {
	facebook.yoga.detail.setBooleanData(flags, doesLegacyStretchFlagAffectsLayoutOffset, val);
  }

  public final boolean hadOverflow()
  {
	return facebook.yoga.detail.getBooleanData(flags, hadOverflowOffset);
  }
  public final void setHadOverflow(boolean hadOverflow)
  {
	facebook.yoga.detail.setBooleanData(flags, hadOverflowOffset, hadOverflow);
  }

  public boolean equalsTo(YGLayout layout) //Method definition originates from: YGLayout.cpp
  {
	boolean isEqual = GlobalMembers.YGFloatArrayEqual(position, layout.position) && GlobalMembers.YGFloatArrayEqual(dimensions, layout.dimensions) && GlobalMembers.YGFloatArrayEqual(margin, layout.margin) && GlobalMembers.YGFloatArrayEqual(border, layout.border) && GlobalMembers.YGFloatArrayEqual(padding, layout.padding) && direction() == layout.direction() && hadOverflow() == layout.hadOverflow() && lastOwnerDirection == layout.lastOwnerDirection && nextCachedMeasurementsIndex == layout.nextCachedMeasurementsIndex && cachedLayout.equalsTo(layout.cachedLayout) && computedFlexBasis == layout.computedFlexBasis;

	for (int i = 0; i < DefineConstants.YG_MAX_CACHED_RESULT_COUNT && isEqual; ++i)
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

  public boolean notEqualsTo(YGLayout layout)
  {
	  return !(this.equalsTo(layout));
  }
}