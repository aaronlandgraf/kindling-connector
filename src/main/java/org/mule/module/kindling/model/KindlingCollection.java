/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingCollection<T extends KindlingEntity> {

	private KindlingCollectionMetadata meta;
	private List<T> results;

	@JsonProperty
	public List<T> getResults() {
		return results;
	}

	@JsonProperty
	public void setResults(List<T> results) {
		this.results = results;
	}

	@JsonProperty
	public KindlingCollectionMetadata getMeta() {
		return meta;
	}

	@JsonProperty
	public void setMeta(KindlingCollectionMetadata meta) {
		this.meta = meta;
	}
	
	
}
