package facebook.yoga;

import java.util.*;

public class LayoutData //Type originates from: event.h
{
  public int layouts;
  public int measures;
  public int maxMeasureCache;
  public int cachedLayouts;
  public int cachedMeasures;
  public int measureCallbacks;
  public ArrayList<Integer> measureCallbackReasonsCount = new ArrayList<>(static_cast<int>(LayoutPassReason.COUNT));
}