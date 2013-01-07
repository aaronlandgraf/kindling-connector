/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.types;

public enum KindlingIdeaFilter {
	MY_IDEAS		("myIdeas"),
	MY_VOTES		("myVotes"),
	FOLLOWED_IDEAS	("followedIdeas"),
	POPULAR_IDEAS	("popularIdeas"),
	LATEST_IDEAS	("latestIdeas");
	
	private String value;
	
	private KindlingIdeaFilter(String value) {
		this.value = value;
	}
	
	public String getValue() { return value; }
}
