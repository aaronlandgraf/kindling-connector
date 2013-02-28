/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.model.user;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.mule.module.kindling.model.KindlingEntity;
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.serialization.KindlingDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingUser implements KindlingEntity {

	
	private String className;
	private Integer id;
	private Object avatar;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private KindlingUserEmailPreferences emailPreferences;
	private Integer votesTotal;
	private Integer reputation;
	private Integer stateId;
	private KindlingUserStateName stateName;
	private Date resetRequested;
	private Boolean storNotification;
	private String backend;
	private String fullName;
	private String avatarUri;
	private String resourceUri;
	private String applicationUri;
	private String locale;
	private Date lastLogin;
	private String lastLoginLocalized;
	private Date dateCreated;
	private String dateCreatedLocalized;
	private List<String> skills;
	private List<String> interests;
	private List<KindlingCategory> categories;
	private Boolean isAnonymous;
	private String token;
	
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
	public Object getAvatar() {
		return avatar;
	}
	
	@JsonProperty
	public void setAvatar(Object avatar) {
		this.avatar = avatar;
	}
	
	@JsonProperty
	public String getUsername() {
		return username;
	}
	
	@JsonProperty
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getFirstName() {
		return firstName;
	}
	
	@JsonProperty
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty
	public String getLastName() {
		return lastName;
	}
	
	@JsonProperty
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonProperty
	public String getEmail() {
		return email;
	}
	
	@JsonProperty
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty
	public Integer getVotesTotal() {
		return votesTotal;
	}
	
	@JsonProperty
	public void setVotesTotal(Integer votesTotal) {
		this.votesTotal = votesTotal;
	}
	
	@JsonProperty
	public Integer getReputation() {
		return reputation;
	}
	
	@JsonProperty
	public void setReputation(Integer reputation) {
		this.reputation = reputation;
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
	public KindlingUserStateName getStateName() {
		return stateName;
	}
	
	@JsonProperty
	public void setStateName(KindlingUserStateName stateName) {
		this.stateName = stateName;
	}
	
	@JsonIgnore	
	public Date getResetRequested() {
		return resetRequested;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setResetRequested(Date resetRequested) {
		this.resetRequested = resetRequested;
	}
	
	@JsonProperty
	public Boolean getStorNotification() {
		return storNotification;
	}
	
	@JsonProperty
	public void setStorNotification(Boolean storNotification) {
		this.storNotification = storNotification;
	}
	
	@JsonProperty
	public String getBackend() {
		return backend;
	}
	
	@JsonProperty
	public void setBackend(String backend) {
		this.backend = backend;
	}
	
	@JsonProperty
	public String getFullName() {
		return fullName;
	}
	
	@JsonProperty
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonProperty
	public String getAvatarUri() {
		return avatarUri;
	}
	
	@JsonProperty
	public void setAvatarUri(String avatarUri) {
		this.avatarUri = avatarUri;
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
	public String getLocale() {
		return locale;
	}
	
	@JsonProperty
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@JsonIgnore
	public Date getLastLogin() {
		return lastLogin;
	}
	
	@JsonProperty
	@JsonSerialize(using = KindlingDateSerializer.class)
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@JsonProperty
	public String getLastLoginLocalized() {
		return lastLoginLocalized;
	}
	
	@JsonProperty
	public void setLastLoginLocalized(String lastLoginLocalized) {
		this.lastLoginLocalized = lastLoginLocalized;
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
	
	@JsonProperty
	public String getDateCreatedLocalized() {
		return dateCreatedLocalized;
	}
	
	@JsonProperty
	public void setDateCreatedLocalized(String dateCreatedLocalized) {
		this.dateCreatedLocalized = dateCreatedLocalized;
	}
	
	@JsonProperty
	public List<String> getSkills() {
		return skills;
	}
	
	@JsonProperty
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	@JsonProperty
	public List<String> getInterests() {
		return interests;
	}
	
	@JsonProperty
	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
	
	@JsonProperty
	public List<KindlingCategory> getCategories() {
		return categories;
	}

	@JsonProperty
	public void setCategories(List<KindlingCategory> categories) {
		this.categories = categories;
	}

	@JsonProperty
	public KindlingUserEmailPreferences getEmailPreferences() {
		return emailPreferences;
	}

	@JsonProperty
	public void setEmailPreferences(KindlingUserEmailPreferences emailPreferences) {
		this.emailPreferences = emailPreferences;
	}

	@JsonProperty
	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	@JsonProperty
	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	@JsonProperty
	public String getToken() {
		return token;
	}

	@JsonIgnore
	public void setToken(String token) {
		this.token = token;
	}	
}