package facebook.yoga;

import facebook.yoga.*;
import detail.Log;
import detail.CompactValue;

@FunctionalInterface
interface YGLogger
{
	int invoke(YGConfig config, YGNode node, YGLogLevel level, tangible.RefObject<String> format, va_list args);
}