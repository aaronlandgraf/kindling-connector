/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model.idea;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.mule.module.kindling.model.KindlingEntity;
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.model.comment.KindlingComment;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.module.kindling.serialization.KindlingDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingIdea implements KindlingEntity {
	
	private String className;
	private Integer id;
	private KindlingCategory category;
	private String title;
	private String description;
	private Integer votes;
	private Integer anonymous;
	private Date dateCreated;
	private String dateCreatedLocalized;
	private Date dateUpdated;
	private String dateUpdatedLocalized;
	private Date dateManaged;
	private String dateManagedLocalized;
	private Date dateRectified;
	private String dateRectifiedLocalized;
	private Integer stateId;
	private KindlingIdeaStateName stateName;
	private String cachetags;
	private Boolean lockedForComments;
	private String bonfireUrl;
	private String submissionSource;
	private String resourceUri;
	private String applicationUri;
	private Integer assignedTo;
	private KindlingUser author;
	private List<String> tags;
	private List<KindlingComment> comments;
	private KindlingIdeaCurrentUserInfo currentUserInfo;
	private Object events;
	private List<Object> volunteers;
	private List<Object> contributors;
	
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
	public Integer getVotes() {
		return votes;
	}
	
	@JsonProperty
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	
	@JsonProperty
	public Integer getAnonymous() {
		return anonymous;
	}
	
	@JsonProperty
	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
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
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateUpdatedLocalized(String dateUpdatedLocalized) {
		this.dateUpdatedLocalized = dateUpdatedLocalized;
	}
	
	@JsonIgnore
	public Date getDateManaged() {
		return dateManaged;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateManaged(Date dateManaged) {
		this.dateManaged = dateManaged;
	}
	
	@JsonIgnore
	public String getDateManagedLocalized() {
		return dateManagedLocalized;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateManagedLocalized(String dateManagedLocalized) {
		this.dateManagedLocalized = dateManagedLocalized;
	}
	
	@JsonIgnore
	public Date getDateRectified() {
		return dateRectified;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateRectified(Date dateRectified) {
		this.dateRectified = dateRectified;
	}
	
	@JsonIgnore
	public String getDateRectifiedLocalized() {
		return dateRectifiedLocalized;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDateRectifiedLocalized(String dateRectifiedLocalized) {
		this.dateRectifiedLocalized = dateRectifiedLocalized;
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
	public KindlingIdeaStateName getStateName() {
		return stateName;
	}
	
	@JsonProperty
	public void setStateName(KindlingIdeaStateName stateName) {
		this.stateName = stateName;
	}
	
	@JsonProperty
	public String getCachetags() {
		return cachetags;
	}
	
	@JsonProperty
	public void setCachetags(String cachetags) {
		this.cachetags = cachetags;
	}
	
	@JsonProperty
	public Boolean getLockedForComments() {
		return lockedForComments;
	}
	
	@JsonProperty
	public void setLockedForComments(Boolean lockedForComments) {
		this.lockedForComments = lockedForComments;
	}
	
	@JsonProperty
	public String getBonfireUrl() {
		return bonfireUrl;
	}
	
	@JsonProperty
	public void setBonfireUrl(String bonfireUrl) {
		this.bonfireUrl = bonfireUrl;
	}
	
	@JsonProperty
	public String getSubmissionSource() {
		return submissionSource;
	}
	
	@JsonProperty
	public void setSubmissionSource(String submissionSource) {
		this.submissionSource = submissionSource;
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
	public Integer getAssignedTo() {
		return assignedTo;
	}
	
	@JsonProperty
	public void setAssignedTo(Integer assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	@JsonProperty
	public List<String> getTags() {
		return tags;
	}
	
	@JsonProperty
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
		
	@JsonProperty
	public KindlingIdeaCurrentUserInfo getCurrentUserInfo() {
		return currentUserInfo;
	}
	
	@JsonProperty
	public void setCurrentUserInfo(KindlingIdeaCurrentUserInfo currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}
	
	@JsonProperty
	public Object getEvents() {
		return events;
	}

	@JsonIgnore
	public void setEvents(Object events) {
		this.events = events;
	}

	@JsonProperty
	public KindlingCategory getCategory() {
		return category;
	}

	@JsonProperty
	public void setCategory(KindlingCategory category) {
		this.category = category;
	}

	@JsonProperty
	public KindlingUser getAuthor() {
		return author;
	}

	@JsonProperty
	public void setAuthor(KindlingUser author) {
		this.author = author;
	}

	@JsonProperty
	public List<KindlingComment> getComments() {
		return comments;
	}

	@JsonProperty
	public void setComments(List<KindlingComment> comments) {
		this.comments = comments;
	}

	@JsonProperty
	public List<Object> getVolunteers() {
		return volunteers;
	}

	@JsonProperty
	public void setVolunteers(List<Object> volunteers) {
		this.volunteers = volunteers;
	}

	@JsonProperty
	public List<Object> getContributors() {
		return contributors;
	}

	@JsonProperty
	public void setContributors(List<Object> contributors) {
		this.contributors = contributors;
	}
}