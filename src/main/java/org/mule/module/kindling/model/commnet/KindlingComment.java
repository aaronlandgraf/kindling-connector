/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.commnet;

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
public class KindlingComment implements KindlingEntity {
	
	private String className;
	private Integer id;
	private Object owner;
	private KindlingCommentParentType parentType;
	private Object parent;
	private Object matchOptionIndex;
	private KindlingCommentType type;
	private String description;
	private Date dateCreated;
	private String dateCreatedLocalized;
	private Integer stateId;
	private KindlingCommentStateName stateName;
	private String resourceUri;
	private List<Object> attachments;
	
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
	public KindlingCommentParentType getParentType() {
		return parentType;
	}
	
	@JsonProperty
	public void setParentType(KindlingCommentParentType parentType) {
		this.parentType = parentType;
	}
	
	@JsonProperty
	public KindlingCommentType getType() {
		return type;
	}
	
	@JsonProperty
	public void setType(KindlingCommentType type) {
		this.type = type;
	}
	
	@JsonProperty
	public String getDescription() {
		return description;
	}
	
	@JsonProperty
	public void setDescription(String description) {
		this.description = description;
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
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateCreatedLocalized(String dateCreatedLocalized) {
		this.dateCreatedLocalized = dateCreatedLocalized;
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
	public KindlingCommentStateName getStateName() {
		return stateName;
	}
	
	@JsonProperty
	public void setStateName(KindlingCommentStateName stateName) {
		this.stateName = stateName;
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
	public Object getOwner() {
		return owner;
	}

	@JsonProperty
	public void setOwner(Object owner) {
		this.owner = owner;
	}

	@JsonProperty
	public Object getMatchOptionIndex() {
		return matchOptionIndex;
	}

	@JsonProperty
	public void setMatchOptionIndex(Object matchOptionIndex) {
		this.matchOptionIndex = matchOptionIndex;
	}

	@JsonProperty
	public List<Object> getAttachments() {
		return attachments;
	}

	@JsonProperty
	public void setAttachments(List<Object> attachments) {
		this.attachments = attachments;
	}

	@JsonProperty
	public Object getParent() {
		return parent;
	}

	@JsonProperty
	public void setParent(Object parent) {
		this.parent = parent;
	}
}