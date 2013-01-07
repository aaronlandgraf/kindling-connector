/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.types;

public enum KindlingUserDigest {
	ALL				("all"),
	DIGEST_NIGHTLY	("digest-nightly"),
	DIGEST_WEEKLY	("digest-weekly"),
	NONE			("none");
	
	private String value;
	
	private KindlingUserDigest(String value) {
		this.value = value;
	}
	
	public String getValue() { return value; }
}
