/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client.impl;

import java.net.URI;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.type.JavaType;
import org.mule.module.kindling.client.KindlingClientBase;
import org.mule.module.kindling.client.KindlingClientUtils;
import org.mule.module.kindling.client.authentication.KindlingAuthentication;
import org.mule.module.kindling.exception.KindlingConnectorException;
import org.mule.module.kindling.exception.KindlingConnectorUnauthorizedException;
import org.mule.module.kindling.model.KindlingCollection;
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.model.commnet.KindlingComment;
import org.mule.module.kindling.model.commnet.KindlingCommentParentType;
import org.mule.module.kindling.model.commnet.KindlingCommentType;
import org.mule.module.kindling.model.group.KindlingGroup;
import org.mule.module.kindling.model.idea.KindlingIdea;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.module.kindling.types.KindlingCategoryState;
import org.mule.module.kindling.types.KindlingIdeaFilter;
import org.mule.module.kindling.types.KindlingState;
import org.mule.module.kindling.types.KindlingUserDigest;
import org.mule.module.kindling.types.KindlingUserReputationTimeframe;
import org.mule.module.kindling.types.KindlingUserState;
import org.mule.module.kindling.types.KindlingWebResourceMethods;

import com.sun.jersey.api.client.WebResource;

public class KindlingClientImpl extends KindlingClientBase {

	static final private Log logger = LogFactory.getLog(KindlingClientImpl.class);
	
	public KindlingClientImpl(String companyName,
			KindlingAuthentication authentication) {
		super(companyName, authentication);
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public KindlingCollection<KindlingGroup> retrieveGroups(Integer depth,
	    						String sort,
	    						Integer page,
	    						Integer limit,
	    						KindlingState state,
	    						String startsWith,
	    						String query) 
    		throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	URI uri = getBaseUriBuilder().path("groups").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	// Check for optional parameters (do not send them if they have their default value)
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	if (!StringUtils.isEmpty(sort))
    		wr = wr.queryParam("sort", sort);
    	
    	if (page != null && page > 1)
    		wr = wr.queryParam("page", String.valueOf(page));
    	
    	if (limit != null && limit > 0)
    		wr = wr.queryParam("limit", String.valueOf(limit));
    	
    	if (state != null)
    		wr = wr.queryParam("state", state.getValue());
    	
    	if (!StringUtils.isEmpty(startsWith))
    		wr = wr.queryParam("startsWith", startsWith);
    	
    	if (!StringUtils.isEmpty(query))
    		wr = wr.queryParam("q", query);
    	
    	logger.info("Requesting retrieveGroups to: " + wr.toString());
//    	return webResourceGet(wr, KindlingWebResourceMethods.GET, null);
    	
    	JavaType type = KindlingClientUtils.constructKindlingCollectionType(KindlingGroup.class);
    	return KindlingClientUtils.webResourceCallWithJavaType(type, KindlingCollection.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }
        
    @Override
    public KindlingGroup retrieveGroup(String groupId, Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(groupId))
    		throw new KindlingConnectorException("The groupId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("groups/{groupId}").build(groupId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	// Check for optional parameters (do not send them if they have their default value)
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	    	    	
    	logger.info("Requesting retrieveGroup to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingGroup.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }
    
    @Override
    public KindlingGroup updateGroup(String groupId, KindlingGroup group)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(groupId))
    		throw new KindlingConnectorException("The groupId parameter it's required");
    	
    	if (group == null)
    		throw new KindlingConnectorException("The group parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("groups/{groupId}").build(groupId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	    	    	
    	String groupJson = KindlingClientUtils.transformObjectToJson(group);
    	
    	logger.info("Requesting updateGroup to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingGroup.class, wr, getLoggedUser(), KindlingWebResourceMethods.PUT, groupJson);
    }
    
    @Override
    public KindlingGroup createGroup(KindlingGroup group)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (group == null)
    		throw new KindlingConnectorException("The group parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("groups").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String groupJson = KindlingClientUtils.transformObjectToJson(group);
    	
    	logger.info("Requesting createGroup to: " + wr.toString());    	
    	return KindlingClientUtils.webResourceCallWithClassType(null, wr, getLoggedUser(), KindlingWebResourceMethods.POST, groupJson);
    }

    @SuppressWarnings("unchecked")
	@Override
    public KindlingCollection<KindlingComment> retrieveComments(
    						KindlingCommentParentType parentType,
    						Integer depth,
							String sort,
							Integer page,
							Integer limit,
							KindlingState state,
							Integer parentId,
							KindlingCommentType type)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (parentType == null)
    		throw new KindlingConnectorException("The parentType parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("comments").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	// Check for optional parameters (do not send them if they have their default value)
    	wr = wr.queryParam("parentType", parentType.getValue());
    	
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	if (!StringUtils.isEmpty(sort))
    		wr = wr.queryParam("sort", sort);
    	
    	if (page != null && page > 1)
    		wr = wr.queryParam("page", String.valueOf(page));
    	
    	if (limit != null && limit > 0)
    		wr = wr.queryParam("limit", String.valueOf(limit));
    	
    	if (state != null)
    		wr = wr.queryParam("state", state.getValue());
    	
    	if (parentId != null && parentId > 0)
    		wr = wr.queryParam("parentId", String.valueOf(parentId));
    	
    	if (type != null)
    		wr = wr.queryParam("type", type.getValue());
    	    	
    	logger.info("Requesting getComments to: " + wr.toString());
    	JavaType jtype = KindlingClientUtils.constructKindlingCollectionType(KindlingComment.class);
    	return KindlingClientUtils.webResourceCallWithJavaType(jtype, KindlingCollection.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }
    
    @Override
    public KindlingComment createComment(KindlingComment comment)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (comment == null)
    		throw new KindlingConnectorException("The comment parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("comments").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String commentJson = KindlingClientUtils.transformObjectToJson(comment);
    	
    	logger.info("Requesting createComment to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingComment.class, wr, getLoggedUser(), KindlingWebResourceMethods.POST, commentJson);
    }
    
    @Override
    public KindlingComment retrieveComment(String commentId, Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(commentId))
    		throw new KindlingConnectorException("The commentId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("comments/{commentId}").build(commentId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	logger.info("Requesting retrieveComment to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingComment.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }
    
    @Override
    public void deleteComment(String commentId)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(commentId))
    		throw new KindlingConnectorException("The commentId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("comments/{commentId}").build(commentId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	logger.info("Requesting deleteComment to: " + wr.toString());
    	KindlingClientUtils.webResourceCall(wr, getLoggedUser(), KindlingWebResourceMethods.DELETE);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public KindlingCollection<KindlingIdea> retrieveIdeas(Integer depth,
								String sort,
								Integer page,
								Integer limit,
								String state,
								Boolean allowsVoting,
								String query,
								String authorId,
								String categoryId,
								KindlingIdeaFilter filter)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	URI uri = getBaseUriBuilder().path("ideas").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	// Check for optional parameters (do not send them if they have their default value)
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	if (!StringUtils.isEmpty(sort))
    		wr = wr.queryParam("sort", sort);
    	
    	if (page != null && page > 1)
    		wr = wr.queryParam("page", String.valueOf(page));
    	
    	if (limit != null && limit > 0)
    		wr = wr.queryParam("limit", String.valueOf(limit));
    	
    	if (!StringUtils.isEmpty(state))
    		wr = wr.queryParam("state", state);
    	
    	if (allowsVoting != null)
    		wr = wr.queryParam("allowsVoting", String.valueOf(allowsVoting));
    	
    	if (!StringUtils.isEmpty(query))
    		wr = wr.queryParam("q", query);
    	
    	if (!StringUtils.isEmpty(authorId))
    		wr = wr.queryParam("authorId", authorId);
    	
    	if (!StringUtils.isEmpty(categoryId))
    		wr = wr.queryParam("categoryId", categoryId);
    	
    	if (filter != null)
    		wr = wr.queryParam("filter", filter.getValue());
    	
    	logger.info("Requesting retrieveIdeas to: " + wr.toString());
    	JavaType jtype = KindlingClientUtils.constructKindlingCollectionType(KindlingIdea.class);
    	return KindlingClientUtils.webResourceCallWithJavaType(jtype, KindlingCollection.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }

    @Override
    public KindlingIdea createIdea(KindlingIdea idea)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (idea == null)
    		throw new KindlingConnectorException("The idea parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("ideas").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String ideaJson = KindlingClientUtils.transformObjectToJson(idea);
    	
    	logger.info("Requesting createIdea to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingIdea.class, wr, getLoggedUser(), KindlingWebResourceMethods.POST, ideaJson);
    }

    @Override
    public KindlingIdea retrieveIdea(String ideaId, Integer depth)
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(ideaId))
    		throw new KindlingConnectorException("The ideaId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("ideas/{ideaId}").build(ideaId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	logger.info("Requesting retrieveIdea to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingIdea.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }

    @Override
    public KindlingIdea updateIdea(String ideaId, KindlingIdea idea)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(ideaId))
    		throw new KindlingConnectorException("The ideaId parameter it's required");
    	
    	if (idea == null)
    		throw new KindlingConnectorException("The idea parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("ideas/{ideaId}").build(ideaId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	logger.info("Requesting updateIdea to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingIdea.class, wr, getLoggedUser(), KindlingWebResourceMethods.PUT);
    }

    @SuppressWarnings("unchecked")
	@Override
    public KindlingCollection<KindlingUser> retrieveUsers(Integer depth,
								String sort,
								Integer page,
								Integer limit,
								KindlingUserState state,
								Integer associatedWithCategoryId,
								KindlingUserDigest digest,
								String query,
								KindlingUserReputationTimeframe reputationTimeframe)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	URI uri = getBaseUriBuilder().path("users").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	// Check for optional parameters (do not send them if they have their default value)
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	if (!StringUtils.isEmpty(sort))
    		wr = wr.queryParam("sort", sort);
    	
    	if (page != null && page > 1)
    		wr = wr.queryParam("page", String.valueOf(page));
    	
    	if (limit != null && limit > 0)
    		wr = wr.queryParam("limit", String.valueOf(limit));
    	
    	if (state != null)
    		wr = wr.queryParam("state", state.getValue());
    	
    	if (associatedWithCategoryId != null && associatedWithCategoryId > 0)
    		wr = wr.queryParam("associatedWithCategoryId", String.valueOf(associatedWithCategoryId));
    	
    	if (digest != null)
    		wr = wr.queryParam("hasDigests", digest.getValue());
    	
    	if (!StringUtils.isEmpty(query))
    		wr = wr.queryParam("q", query);
   	
    	if (reputationTimeframe != null)
    		wr = wr.queryParam("reputationTimeframe", reputationTimeframe.getValue());
    	
    	logger.info("Requesting retrieveUsers to: " + wr.toString());
    	JavaType jtype = KindlingClientUtils.constructKindlingCollectionType(KindlingUser.class);
    	return KindlingClientUtils.webResourceCallWithJavaType(jtype, KindlingCollection.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }

    @Override
    public KindlingUser createUser(KindlingUser user)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (user == null)
    		throw new KindlingConnectorException("The user parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("users").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String userJson = KindlingClientUtils.transformObjectToJson(user);
    	
    	logger.info("Requesting createUser to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingUser.class, wr, getLoggedUser(), KindlingWebResourceMethods.POST, userJson);
    }

    @Override
    public KindlingUser retrieveUser(String userId, Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (userId == null)
    		throw new KindlingConnectorException("The userId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("users/{userId}").build(userId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	if (depth != null)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	logger.info("Requesting retrieveUser to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingUser.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }

    @Override
    public KindlingUser updateUser(String userId, KindlingUser user)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(userId))
    		throw new KindlingConnectorException("The userId parameter it's required");
    	
    	if (user == null)
    		throw new KindlingConnectorException("The user parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("users/{userId}").build(userId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String userJson = KindlingClientUtils.transformObjectToJson(user);
    	
    	logger.info("Requesting updateUser to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingUser.class, wr, getLoggedUser(), KindlingWebResourceMethods.PUT, userJson);
    }

    @Override
    public void deleteUser(String userId)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(userId))
    		throw new KindlingConnectorException("The userId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("users/{userId}").build(userId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	    	
    	logger.info("Requesting deleteUser to: " + wr.toString());
    	KindlingClientUtils.webResourceCall(wr, getLoggedUser(), KindlingWebResourceMethods.DELETE);
    }

    @SuppressWarnings("unchecked")
	@Override
    public KindlingCollection<KindlingCategory> retrieveCategories(Integer depth,
									String sort,
									Integer page,
									Integer limit,
									KindlingCategoryState state,
									String query,
									Integer associatedWithUserId)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	URI uri = getBaseUriBuilder().path("categories").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	// Check for optional parameters (do not send them if they have their default value)
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	if (!StringUtils.isEmpty(sort))
    		wr = wr.queryParam("sort", sort);
    	
    	if (page != null && page > 1)
    		wr = wr.queryParam("page", String.valueOf(page));
    	
    	if (limit != null && limit > 0)
    		wr = wr.queryParam("limit", String.valueOf(limit));
    	
    	if (state != null)
    		wr = wr.queryParam("state", state.getValue());
    	
    	if (!StringUtils.isEmpty(query))
    		wr = wr.queryParam("q", query);
    	
     	if (associatedWithUserId != null && associatedWithUserId > 0)
    		wr = wr.queryParam("associatedWithUserId", String.valueOf(associatedWithUserId));
    	
    	logger.info("Requesting retrieveCategories to: " + wr.toString());
    	JavaType jtype = KindlingClientUtils.constructKindlingCollectionType(KindlingCategory.class);
    	return KindlingClientUtils.webResourceCallWithJavaType(jtype, KindlingCollection.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }

    @Override
    public KindlingCategory createCategory(KindlingCategory category)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (category == null)
    		throw new KindlingConnectorException("The category parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("categories").build();
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String categoryJson = KindlingClientUtils.transformObjectToJson(category);
    	
    	logger.info("Requesting createCategory to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingCategory.class, wr, getLoggedUser(), KindlingWebResourceMethods.POST, categoryJson);
    }

    @Override
    public KindlingCategory retrieveCategory(String categoryId, Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(categoryId))
    		throw new KindlingConnectorException("The categoryId parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("categories/{categoryId}").build(categoryId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	if (depth != null && depth > 0)
    		wr = wr.queryParam("depth", String.valueOf(depth));
    	
    	logger.info("Requesting retrieveCategory to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingCategory.class, wr, getLoggedUser(), KindlingWebResourceMethods.GET);
    }

    @Override
    public KindlingCategory updateCategory(String categoryId, KindlingCategory category)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	if (StringUtils.isEmpty(categoryId))
    		throw new KindlingConnectorException("The categoryId parameter it's required");
    	
    	if (category == null)
    		throw new KindlingConnectorException("The category parameter it's required");
    	
    	URI uri = getBaseUriBuilder().path("categories/{categoryId}").build(categoryId);
    	
    	WebResource wr = getJerseyClient().resource(uri);
    	
    	String categoryJson = KindlingClientUtils.transformObjectToJson(category);
    	
    	logger.info("Requesting updateCategory to: " + wr.toString());
    	return KindlingClientUtils.webResourceCallWithClassType(KindlingCategory.class, wr, getLoggedUser(), KindlingWebResourceMethods.PUT, categoryJson);
    }

}
