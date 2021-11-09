package facebook.yoga;

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



//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGConfig;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGNode;


public enum LayoutType //Type originates from: event.h
{
  kLayout(0),
  kMeasure(1),
  kCachedLayout(2),
  kCachedMeasure(3);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, LayoutType> mappings;
	private static java.util.HashMap<Integer, LayoutType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (LayoutType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, LayoutType>();
				}
			}
		}
		return mappings;
	}

	private LayoutType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static LayoutType forValue(int value)
	{
		return getMappings().get(value);
	}
}