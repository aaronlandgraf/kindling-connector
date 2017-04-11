/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model.comment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum KindlingCommentStateName {
	ACTIVATED("Activated"),
	ARCHIEVED("Archived");
	
	static final private Log logger = LogFactory.getLog(KindlingCommentStateName.class);
	
	@JsonCreator
	static public KindlingCommentStateName getValueOf(String arg) {
		
		for (KindlingCommentStateName k : KindlingCommentStateName.values()) {
			if (k.value.equalsIgnoreCase(arg)) return k;
		}
		
		logger.warn(String.format("Value %s not found in enum", arg));
		return null;
	}
	
	private String value;
		
	private KindlingCommentStateName(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() { return value; }
}