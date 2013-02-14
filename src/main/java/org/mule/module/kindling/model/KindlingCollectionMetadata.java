/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingCollectionMetadata {

	private Integer count;
	private Integer totalCount;
	private Integer totalPages;
	private Object parameters;
	
	@JsonProperty
	public Integer getCount() {
		return count;
	}
	
	@JsonProperty
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty
	public Integer getTotalCount() {
		return totalCount;
	}
	
	@JsonProperty
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	@JsonProperty
	public Integer getTotalPages() {
		return totalPages;
	}
	
	@JsonProperty
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@JsonProperty
	public Object getParameters() {
		return parameters;
	}

	@JsonProperty
	public void setParameters(Object parameters) {
		this.parameters = parameters;
	}
}
