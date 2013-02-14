/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.category;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KindlingCategoryIdea {
	
	private Integer count;
	private String collectionUri;
	
	@JsonIgnore
	public Integer getCount() {
		return count;
	}
	
	@JsonIgnore
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonIgnore
	public String getCollectionUri() {
		return collectionUri;
	}
	
	@JsonIgnore
	public void setCollectionUri(String collectionUri) {
		this.collectionUri = collectionUri;
	}
}
