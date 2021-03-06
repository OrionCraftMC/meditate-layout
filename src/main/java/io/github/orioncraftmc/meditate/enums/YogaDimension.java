/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.github.orioncraftmc.meditate.enums;

public enum YogaDimension {
  WIDTH(0),
  HEIGHT(1);

  private final int mIntValue;

  YogaDimension(int intValue) {
    mIntValue = intValue;
  }

  public int intValue() {
    return mIntValue;
  }

  public static YogaDimension fromInt(int value) {
    switch (value) {
      case 0: return WIDTH;
      case 1: return HEIGHT;
      default: throw new IllegalArgumentException("Unknown enum value: " + value);
    }
  }
}
