/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
