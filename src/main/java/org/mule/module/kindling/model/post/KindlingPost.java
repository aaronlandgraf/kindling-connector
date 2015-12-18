/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model.post;

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
public class KindlingPost implements KindlingEntity {

	private String className;
	private Integer id;
	private KindlingCategory category;
	private KindlingUser owner;
	private String title;
	private String description;
	private Object postImage; //Attachment
	private Date dateCreated;
	private String dateCreatedLocalized;
	private Date dateUpdated;
	private String dateUpdatedLocalized;
	private String datePublished;
	private String datePublishedLocalized;
	private Integer stateId;
	private KindlingPostStateName stateName;
	private Object cachedTags;
	private Integer lockedForComments;
	private String resourceUri;
	private String applicationUri;
	private List<String> tags;
	private List<KindlingComment> comments;
	
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
	public KindlingCategory getCategory() {
		return category;
	}
	
	@JsonProperty
	public void setCategory(KindlingCategory category) {
		this.category = category;
	}
	
	@JsonProperty
	public KindlingUser getOwner() {
		return owner;
	}
	
	@JsonProperty
	public void setOwner(KindlingUser owner) {
		this.owner = owner;
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
	public Object getPostImage() {
		return postImage;
	}
	
	@JsonProperty
	public void setPostImage(Object postImage) {
		this.postImage = postImage;
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
	public String getDatePublished() {
		return datePublished;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}
	
	@JsonIgnore
	public String getDatePublishedLocalized() {
		return datePublishedLocalized;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setDatePublishedLocalized(String datePublishedLocalized) {
		this.datePublishedLocalized = datePublishedLocalized;
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
	public KindlingPostStateName getStateName() {
		return stateName;
	}
	
	@JsonProperty
	public void setStateName(KindlingPostStateName stateName) {
		this.stateName = stateName;
	}
	
	@JsonProperty
	public Object getCachedTags() {
		return cachedTags;
	}
	
	@JsonProperty
	public void setCachedTags(Object cachedTags) {
		this.cachedTags = cachedTags;
	}
	
	@JsonProperty
	public Integer getLockedForComments() {
		return lockedForComments;
	}
	
	@JsonProperty
	public void setLockedForComments(Integer lockedForComments) {
		this.lockedForComments = lockedForComments;
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
	public List<String> getTags() {
		return tags;
	}
	
	@JsonProperty
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@JsonProperty
	public List<KindlingComment> getComments() {
		return comments;
	}
	
	@JsonProperty
	public void setComments(List<KindlingComment> comments) {
		this.comments = comments;
	}
}
