/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.group;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum KindlingGroupType {
	SMART("smart"),
	MANAGED("managed");
	
	static final private Log logger = LogFactory.getLog(KindlingGroupType.class);
	
	@JsonCreator
	static public KindlingGroupType getValueOf(String arg) {
		
		for (KindlingGroupType k : KindlingGroupType.values()) {
			if (k.value.equalsIgnoreCase(arg)) return k;
		}
		
		logger.warn(String.format("Value %s not found in enum", arg));
		return null;
	}
	
	private String value;
		
	private KindlingGroupType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() { return value; }
}
