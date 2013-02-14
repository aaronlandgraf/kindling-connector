/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.category;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.mule.module.kindling.model.KindlingEntity;
import org.mule.module.kindling.serialization.KindlingDateDeserializer;
import org.mule.module.kindling.serialization.KindlingDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingCategory implements KindlingEntity {

	private String className;
	private Integer id;
	private Object parent;
	private Object owner;
	private String slug;
	private String title;
	private String description;
	private Integer stateId;
	private KindlingCategoryStateName stateName;
	private Date dateCreated;
	private String dateCreatedLocalized;
	private Date dateUpdated;
	private String dateUpdatedLocalized;
	private Boolean isDefault;
	private KindlingCategoryIdeaRestriction submitIdeaRestriction;
	private Date dateStart;
	private String dateStartLocalized;
	private Date dateEnd;
	private String dateEndLocalized;
	private Date dateClose;
	private String dateCloseLocalized;
	private Integer notifyPhase;
	private Integer notifyStart;
	private Integer notifyDaysLeft;
	private Integer notifyEnd;
	private String reward;
	private String fullyQualifiedTitle;
	private List<String> hierarchy;
	private KindlingCategoryIdea ideas;
	private String resourceUri;
	private String applicationUri;
	private Integer voteMax;
	private List<Object> groups;

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
	public String getSlug() {
		return slug;
	}

	@JsonProperty
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@JsonProperty
	public String getTitle() {
		return title;
	}

	@JsonProperty
	public void setTitle(String title) {
		this.title = title;
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
	public KindlingCategoryStateName getStateName() {
		return stateName;
	}

	@JsonProperty
	public void setStateName(KindlingCategoryStateName stateName) {
		this.stateName = stateName;
	}

	@JsonProperty
	public Integer getStateId() {
		return stateId;
	}

	@JsonProperty
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@JsonIgnore
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	@JsonDeserialize(using = KindlingDateDeserializer.class)
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

	@JsonDeserialize(using = KindlingDateDeserializer.class)
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
	public Boolean getIsDefault() {
		return isDefault;
	}

	@JsonProperty
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	@JsonProperty
	public KindlingCategoryIdeaRestriction getSubmitIdeaRestriction() {
		return submitIdeaRestriction;
	}

	@JsonProperty
	public void setSubmitIdeaRestriction(
			KindlingCategoryIdeaRestriction submitIdeaRestriction) {
		this.submitIdeaRestriction = submitIdeaRestriction;
	}

	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public Date getDateStart() {
		return dateStart;
	}

	@JsonProperty
	@JsonDeserialize(using = KindlingDateDeserializer.class)
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	@JsonProperty
	public String getDateStartLocalized() {
		return dateStartLocalized;
	}

	@JsonProperty
	public void setDateStartLocalized(String dateStartLocalized) {
		this.dateStartLocalized = dateStartLocalized;
	}

	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public Date getDateEnd() {
		return dateEnd;
	}

	@JsonProperty
	@JsonDeserialize(using = KindlingDateDeserializer.class)
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@JsonProperty
	public String getDateEndLocalized() {
		return dateEndLocalized;
	}

	@JsonProperty
	public void setDateEndLocalized(String dateEndLocalized) {
		this.dateEndLocalized = dateEndLocalized;
	}

	@JsonProperty
	public Integer getNotifyPhase() {
		return notifyPhase;
	}

	@JsonProperty
	public void setNotifyPhase(Integer notifyPhase) {
		this.notifyPhase = notifyPhase;
	}

	@JsonProperty
	public Integer getNotifyStart() {
		return notifyStart;
	}

	@JsonProperty
	public void setNotifyStart(Integer notifyStart) {
		this.notifyStart = notifyStart;
	}

	@JsonProperty
	public Integer getNotifyDaysLeft() {
		return notifyDaysLeft;
	}

	@JsonProperty
	public void setNotifyDaysLeft(Integer notifyDaysLeft) {
		this.notifyDaysLeft = notifyDaysLeft;
	}

	@JsonProperty
	public Integer getNotifyEnd() {
		return notifyEnd;
	}

	@JsonProperty
	public void setNotifyEnd(Integer notifyEnd) {
		this.notifyEnd = notifyEnd;
	}

	@JsonProperty
	public String getReward() {
		return reward;
	}

	@JsonProperty
	public void setReward(String reward) {
		this.reward = reward;
	}

	@JsonProperty
	public String getFullyQualifiedTitle() {
		return fullyQualifiedTitle;
	}

	@JsonProperty
	public void setFullyQualifiedTitle(String fullyQualifiedTitle) {
		this.fullyQualifiedTitle = fullyQualifiedTitle;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public Date getDateClose() {
		return dateClose;
	}

	@JsonIgnore
	public void setDateClose(Date dateClose) {
		this.dateClose = dateClose;
	}

	@JsonProperty
	public String getDateCloseLocalized() {
		return dateCloseLocalized;
	}

	@JsonIgnore
	public void setDateCloseLocalized(String dateCloseLocalized) {
		this.dateCloseLocalized = dateCloseLocalized;
	}

	@JsonProperty
	public List<String> getHierarchy() {
		return hierarchy;
	}

	@JsonProperty
	public void setHierarchy(List<String> hierarchy) {
		this.hierarchy = hierarchy;
	}

	@JsonProperty
	public KindlingCategoryIdea getIdeas() {
		return ideas;
	}

	@JsonProperty
	public void setIdeas(KindlingCategoryIdea ideas) {
		this.ideas = ideas;
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
	public Integer getVoteMax() {
		return voteMax;
	}

	@JsonProperty
	public void setVoteMax(Integer voteMax) {
		this.voteMax = voteMax;
	}

	@JsonProperty
	public Object getParent() {
		return parent;
	}

	@JsonProperty
	public void setParent(Object parent) {
		this.parent = parent;
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
	public List<Object> getGroups() {
		return groups;
	}

	@JsonProperty
	public void setGroups(List<Object> groups) {
		this.groups = groups;
	}
}
