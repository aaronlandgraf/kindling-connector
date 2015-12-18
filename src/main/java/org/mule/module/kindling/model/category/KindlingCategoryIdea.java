/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
