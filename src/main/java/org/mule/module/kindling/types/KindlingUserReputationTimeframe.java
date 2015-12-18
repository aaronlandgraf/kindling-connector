/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.types;

public enum KindlingUserReputationTimeframe {
	ALL_TIME		("all-time"),
	LAST_90_DAYS	("last-90-days"),
	CURRENT_MONTH	("current-month");
	
	private String value;
	
	private KindlingUserReputationTimeframe(String value) {
		this.value = value;
	}
	
	public String getValue() { return value; }
}
