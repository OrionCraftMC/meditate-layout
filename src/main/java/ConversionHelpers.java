import facebook.yoga.YGFloatOptional;

public class ConversionHelpers {
    public static float getValueFromOperator(float value) {
        return value;
    }

    public static float getValueFromOperator(YGFloatOptional value) {
        return value.unwrap();
    }
}
