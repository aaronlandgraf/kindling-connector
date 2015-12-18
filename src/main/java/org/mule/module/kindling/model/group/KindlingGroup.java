/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model.group;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.mule.module.kindling.model.KindlingEntity;
import org.mule.module.kindling.serialization.KindlingDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingGroup implements KindlingEntity {
	
	private String className;
	private Integer id;
	private String title;
	private String description;
	private KindlingGroupType type;
	private Integer stateId;
	private KindlingGroupStateName stateName;
	private Boolean requiresLdap;
	private Object parameters;
	private Date dateCreated;
	private String dateCreatedLocalized;
	private Date dateUpdated;
	private String dateUpdatedLocalized;
	private String resourceUri;
	private String applicationUri;
	private List<Object> members;
	private List<Object> moderators;
	private List<Object> categories;
	
	@JsonProperty
	public String getClassName() {
		return className;
	}
	
	@JsonProperty
	public void setClassName(String className) {
		this.className = className;
	}
	
	@JsonProperty
	public Integer getId() {
		return id;
	}
	
	@JsonProperty
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getDescription() {
		return description;
	}
	
	@JsonProperty
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty
	public KindlingGroupType getType() {
		return type;
	}
	
	@JsonProperty
	public void setType(KindlingGroupType type) {
		this.type = type;
	}
	
	@JsonProperty
	public Integer getStateId() {
		return stateId;
	}
	
	@JsonProperty
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
	@JsonProperty
	public KindlingGroupStateName getStateName() {
		return stateName;
	}
	
	@JsonProperty
	public void setStateName(KindlingGroupStateName stateName) {
		this.stateName = stateName;
	}
	
	@JsonProperty
	public Boolean getRequiresLdap() {
		return requiresLdap;
	}
	
	@JsonProperty
	public void setRequiresLdap(Boolean requiresLdap) {
		this.requiresLdap = requiresLdap;
	}
	
	@JsonProperty
	public Object getParameters() {
		return parameters;
	}
	
	@JsonProperty
	public void setParameters(Object parameters) {
		this.parameters = parameters;
	}
	
	@JsonIgnore
	public Date getDateCreated() {
		return dateCreated;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@JsonIgnore
	public String getDateCreatedLocalized() {
		return dateCreatedLocalized;
	}
	
	@JsonProperty
	public void setDateCreatedLocalized(String dateCreatedLocalized) {
		this.dateCreatedLocalized = dateCreatedLocalized;
	}
	
	@JsonIgnore
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	@JsonIgnore
	public String getDateUpdatedLocalized() {
		return dateUpdatedLocalized;
	}
	
	@JsonProperty
	public void setDateUpdatedLocalized(String dateUpdatedLocalized) {
		this.dateUpdatedLocalized = dateUpdatedLocalized;
	}
	
	@JsonProperty
	public String getResourceUri() {
		return resourceUri;
	}
	
	@JsonProperty
	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}
	
	@JsonProperty
	public String getApplicationUri() {
		return applicationUri;
	}
	
	@JsonProperty
	public void setApplicationUri(String applicationUri) {
		this.applicationUri = applicationUri;
	}

	@JsonProperty
	public List<Object> getMembers() {
		return members;
	}

	@JsonProperty
	public void setMembers(List<Object> members) {
		this.members = members;
	}

	@JsonProperty
	public List<Object> getModerators() {
		return moderators;
	}

	@JsonProperty
	public void setModerators(List<Object> moderators) {
		this.moderators = moderators;
	}

	@JsonProperty
	public List<Object> getCategories() {
		return categories;
	}

	@JsonProperty
	public void setCategories(List<Object> categories) {
		this.categories = categories;
	}

	@JsonProperty
	public String getTitle() {
		return title;
	}

	@JsonProperty
	public void setTitle(String title) {
		this.title = title;
	}
}
