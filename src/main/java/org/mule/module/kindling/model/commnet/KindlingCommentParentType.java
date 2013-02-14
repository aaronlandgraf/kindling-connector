/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.commnet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum KindlingCommentParentType {
	IDEAS("ideas"),
	POSTS("posts");
	
	static final private Log logger = LogFactory.getLog(KindlingCommentParentType.class);
	
	@JsonCreator
	static public KindlingCommentParentType getValueOf(String arg) {
		
		for (KindlingCommentParentType k : KindlingCommentParentType.values()) {
			if (k.value.equalsIgnoreCase(arg)) return k;
		}
		
		logger.warn(String.format("Value %s not found in enum", arg));
		return null;
	}
	
	private String value;
		
	private KindlingCommentParentType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() { return value; }
}
