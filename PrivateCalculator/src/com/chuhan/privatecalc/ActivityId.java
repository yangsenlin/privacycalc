package com.chuhan.privatecalc;

import java.util.HashMap;

public final class ActivityId {

	public static final HashMap<String, Integer> activityIds = new HashMap<String, Integer>();
	
	static {
		activityIds.put("com.chuhan.privatecalc.PrivateCalculatorActivity", 1);
	}
}
