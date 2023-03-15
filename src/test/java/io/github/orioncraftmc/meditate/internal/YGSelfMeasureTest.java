package io.github.orioncraftmc.meditate.internal;

import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.enums.YogaMeasureMode;

public class YGSelfMeasureTest {
    public static YGSize measure(YogaNode node, float width, YogaMeasureMode widthMode, float height, YogaMeasureMode heightMode) {
        var measuredWidth = node.measure(width, widthMode.intValue(), height, heightMode.intValue()).width;
        var newHeight = measuredWidth * .75f;
        return new YGSize(measuredWidth, newHeight);
    }
}
