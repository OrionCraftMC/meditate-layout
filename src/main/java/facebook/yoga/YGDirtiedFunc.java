package facebook.yoga;

import facebook.yoga.*;
import detail.Log;
import detail.CompactValue;

@FunctionalInterface
interface YGDirtiedFunc
{
	void invoke(YGNode node);
}