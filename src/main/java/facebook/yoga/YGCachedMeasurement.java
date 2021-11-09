package facebook.yoga;
import java.util.*;

public class YGCachedMeasurement //Type originates from: Yoga-internal.h
{
  public float availableWidth;
  public float availableHeight;
  public YGMeasureMode widthMeasureMode;
  public YGMeasureMode heightMeasureMode;

  public float computedWidth;
  public float computedHeight;

  public YGCachedMeasurement()
  {
	  this.availableWidth = -1F;
	  this.availableHeight = -1F;
	  this.widthMeasureMode = new YGMeasureMode.YGMeasureModeUndefined;
	  this.heightMeasureMode = new YGMeasureMode.YGMeasureModeUndefined;
	  this.computedWidth = -1F;
	  this.computedHeight = -1F;
  }

//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean operator ==(YGCachedMeasurement measurement) const
  public boolean equalsTo(YGCachedMeasurement measurement)
  {
	boolean isEqual = widthMeasureMode == measurement.widthMeasureMode && heightMeasureMode == measurement.heightMeasureMode;

	if (!yoga.GlobalMembers.isUndefined(availableWidth) || !yoga.GlobalMembers.isUndefined(measurement.availableWidth))
	{
	  isEqual = isEqual && availableWidth == measurement.availableWidth;
	}
	if (!yoga.GlobalMembers.isUndefined(availableHeight) || !yoga.GlobalMembers.isUndefined(measurement.availableHeight))
	{
	  isEqual = isEqual && availableHeight == measurement.availableHeight;
	}
	if (!yoga.GlobalMembers.isUndefined(computedWidth) || !yoga.GlobalMembers.isUndefined(measurement.computedWidth))
	{
	  isEqual = isEqual && computedWidth == measurement.computedWidth;
	}
	if (!yoga.GlobalMembers.isUndefined(computedHeight) || !yoga.GlobalMembers.isUndefined(measurement.computedHeight))
	{
	  isEqual = isEqual && computedHeight == measurement.computedHeight;
	}

	return isEqual;
  }
}