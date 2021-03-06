package io.github.orioncraftmc.meditate.internal.interfaces;

import io.github.orioncraftmc.meditate.internal.YGNode;

@FunctionalInterface
public
interface YGBaselineFunc {
    float invoke(YGNode node, float width, float height);
}