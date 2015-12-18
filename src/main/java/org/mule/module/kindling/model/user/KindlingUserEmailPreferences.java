/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model.user;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingUserEmailPreferences {
	private String defaultValue;
	private Object categories;
	
	@JsonProperty("default")
	public String getDefaultValue() {
		return defaultValue;
	}
	
	@JsonProperty("default")
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	@JsonProperty
	public Object getCategories() {
		return categories;
	}
	
	@JsonProperty
	public void setCategories(Object categories) {
		this.categories = categories;
	}
}
