package facebook.yoga;

import facebook.yoga.*;
import detail.Log;
import detail.CompactValue;

@FunctionalInterface
interface YGNodeCleanupFunc
{
	void invoke(YGNode node);
}