package facebook.yoga;

/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */



public class YGFloatOptional //Type originates from: YGFloatOptional.h
{
  private float value_ = Float.NaN;

  public YGFloatOptional(float value)
  {
	  this.value_ = value;
  }
  public YGFloatOptional()
  {
  }

  // returns the wrapped value, or a value x with YGIsUndefined(x) == true
  public final float unwrap()
  {
	  return value_;
  }

  public final boolean isUndefined()
  {
	  return Float.isNaN(value_);
  }
}