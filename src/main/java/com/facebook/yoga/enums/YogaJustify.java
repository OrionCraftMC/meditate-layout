/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.yoga.enums;

public enum YogaJustify {
  FLEX_START(0),
  CENTER(1),
  FLEX_END(2),
  SPACE_BETWEEN(3),
  SPACE_AROUND(4),
  SPACE_EVENLY(5);

  private final int mIntValue;

  YogaJustify(int intValue) {
    mIntValue = intValue;
  }

  public int intValue() {
    return mIntValue;
  }

  public static YogaJustify fromInt(int value) {
    switch (value) {
      case 0: return FLEX_START;
      case 1: return CENTER;
      case 2: return FLEX_END;
      case 3: return SPACE_BETWEEN;
      case 4: return SPACE_AROUND;
      case 5:
        return SPACE_EVENLY;
      default: throw new IllegalArgumentException("Unknown enum value: " + value);
    }
  }
}