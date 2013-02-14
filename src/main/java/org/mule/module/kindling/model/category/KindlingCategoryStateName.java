/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.category;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum KindlingCategoryStateName {
	ACTIVATED("Activated"),
	DISABLED("Disabled"),
	ARCHIVED("Archived"),
	LOCKED("Locked"),
	QUEUED("Queued"),
	ENDED("Ended");
	
	static final private Log logger = LogFactory.getLog(KindlingCategoryStateName.class);
	
	@JsonCreator
	static public KindlingCategoryStateName getValueOf(String arg) {
		
		for (KindlingCategoryStateName kcs : KindlingCategoryStateName.values()) {
			if (kcs.value.equalsIgnoreCase(arg)) return kcs;
		}
		
		logger.warn(String.format("Value %s not found in enum", arg));
		return null;
	}
	
	private String value;
	
	private KindlingCategoryStateName(String name) {
		this.value = name;
	} 
	
	@JsonValue 
	public String getValue() { return value; }
}
