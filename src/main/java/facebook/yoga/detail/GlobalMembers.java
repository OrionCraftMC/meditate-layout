package facebook.yoga.detail;

import facebook.yoga.YGConfig;
import facebook.yoga.YGLogLevel;
import facebook.yoga.YGNode;

import static facebook.GlobalMembers.YGConfigGetDefault;
import org.jetbrains.annotations.Contract;

public class GlobalMembers {
    public static void vlog(YGConfig config, YGNode node, YGLogLevel level, Object context, String format, Object... args) {
        YGConfig logConfig = config != null ? config : YGConfigGetDefault();
        logConfig.log(logConfig, node, level, context, format, args);
    }

    public static Integer log2ceilFn(Integer n) {
        return n < 1 ? 0 : (1 + log2ceilFn(n / 2));
    }

    public static int mask(Integer bitWidth, Integer index) {
        return ((1 << bitWidth) - 1) << index;
    }

    public static <E extends Enum<E>> int bitWidthFn(Class<E> e) {
        return (log2ceilFn(e.getEnumConstants().length - 1));
    }

    public static <E extends Enum<E>> E getEnumData(Class<E> e, int flags, Integer index) { //TODO: Change to ByRef
        E[] constants = e.getEnumConstants();
        return constants[((flags & mask(bitWidthFn(e), index)) >> index)];
    }


    @Contract(pure = true)
    public static <E extends Enum<E>> byte setEnumData(Class<E> e, byte flags, int index, E newValue) {
        return (byte) ((flags & ~mask(bitWidthFn(e), index)) | ((newValue.ordinal() << index) & (mask(bitWidthFn(e), index))));
    }

    public static boolean getBooleanData(byte flags, Integer index) {
        return ((flags >> index) & 1) != 0;
    }

    @Contract(pure = true)
    public static byte setBooleanData(byte flags, int index, boolean value) {
        if (value) {
            return (byte) (flags | 1 << index);
        } else {
            return (byte) (flags & ~(1 << index));
        }
    }

    private boolean notEqualsTo(CompactValue a, CompactValue b) {
        return !CompactValue.equalsTo(a, b);
    }
}
