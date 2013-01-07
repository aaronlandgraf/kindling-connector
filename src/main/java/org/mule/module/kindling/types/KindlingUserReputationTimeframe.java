/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
