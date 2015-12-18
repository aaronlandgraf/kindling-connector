/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
