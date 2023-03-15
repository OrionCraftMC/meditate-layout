package io.github.orioncraftmc.meditate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YGSelfMeasureTest {
    @Test
    public void test_measure() {
        YogaConfig config = YogaConfigFactory.create();

        final YogaNode root = createNode(config);
        root.setWidth(100f);
        root.setHeightAuto();

        root.setMeasureFunction(io.github.orioncraftmc.meditate.internal.YGSelfMeasureTest::measure);

        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(100f, root.getLayoutWidth());
        assertEquals(75f, root.getLayoutHeight());
    }

    private YogaNode createNode(YogaConfig config) {
        return YogaNodeFactory.create(config);
    }
}
