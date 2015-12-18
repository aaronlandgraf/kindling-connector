/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.model.idea;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class KindlingIdeaCurrentUserInfo {

//	"votes":                "integer",
//  "votesAvailable":       "integer",
//  "votesMax":             "integer",
//  "votesTotal":           "integer",
//  "voterCount":           "integer",
//  "ideaId":               "integer($id)",
//  "categoryId":           "integer($categoryId)",
//  "isVotable":            "boolean"
	
	private Integer votes;
	private Integer votesAvailable;
	private Integer votesMax;
	private Integer votesTotal;
	private Integer voterCount;
	private Integer ideaId;
	private Integer categoryId;
	private Boolean isVotable;
	
	@JsonProperty
	public Integer getVotes() {
		return votes;
	}
	
	@JsonProperty
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	
	@JsonProperty
	public Integer getVotesAvailable() {
		return votesAvailable;
	}
	
	@JsonProperty
	public void setVotesAvailable(Integer votesAvailable) {
		this.votesAvailable = votesAvailable;
	}
	
	@JsonProperty
	public Integer getVotesMax() {
		return votesMax;
	}
	
	@JsonProperty
	public void setVotesMax(Integer votesMax) {
		this.votesMax = votesMax;
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
	public Integer getVoterCount() {
		return voterCount;
	}
	
	@JsonProperty
	public void setVoterCount(Integer voterCount) {
		this.voterCount = voterCount;
	}
	
	@JsonProperty
	public Integer getIdeaId() {
		return ideaId;
	}
	
	@JsonProperty
	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}
	
	@JsonProperty
	public Integer getCategoryId() {
		return categoryId;
	}
	
	@JsonProperty
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public Boolean getIsVotable() {
		return isVotable;
	}
	
	@JsonProperty
	public void setIsVotable(Boolean isVotable) {
		this.isVotable = isVotable;
	}
}