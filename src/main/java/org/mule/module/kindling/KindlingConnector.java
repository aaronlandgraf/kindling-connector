/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 **/

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module.kindling;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Optional;
import org.mule.module.kindling.client.KindlingClient;
import org.mule.module.kindling.client.authentication.KindlingAuthentication;
import org.mule.module.kindling.client.authentication.impl.KindlingAuthenticationBasic;
import org.mule.module.kindling.client.impl.KindlingClientImpl;
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

/**
 * Kindling Cloud Connector
 * <p>
 * Kindling ignites innovation by connecting people and ideas
 * <p>
 * Allows to connect to the kindling site across the Kindling Service API.
 * Connector created with the documentation of the service for the version v3.12.0.2
 * @author MuleSoft, Inc.
 */
@Connector(name="kindling", schemaVersion="2.0", friendlyName="Kindling")
public class KindlingConnector
{
	
	/**
	 * The name of the company registered in kindling and used for access your site like https://{companyName}.kindlingapp.com
	 */
	@Configurable
	private String companyName;
	
	private KindlingClient client;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey String username, String password)
        throws ConnectionException {
    	
    	KindlingAuthentication auth = new KindlingAuthenticationBasic(username, password);
    	client = new KindlingClientImpl(companyName, auth);
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
    	client = null;
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return client != null;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

    
    /**
     * Gets the groups collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-groups}
     * 
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @param sort <i>Default: title.</i> How the collection output will be sorted, like 'date ASC', 'date', or 'name DESC' etc.
     * @param page <i>Default: 1.</i> The page requested
     * @param limit <i>Default: 20</i> The limit on number of collection items to show per page
     * @param state <i>Default: ACTIVATED.</i> Get only items in the collection that are in the given state, either by a state ID or it's natural language name
     * @param startsWith find group titles beginning with this string
     * @param query a general group search
     * @return A {@link KindlingCollection} of {@link KindlingGroup}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCollection<KindlingGroup> retrieveGroups(@Optional Integer depth,
	    						@Optional String sort,
	    						@Optional Integer page,
	    						@Optional Integer limit,
	    						@Optional KindlingState state,
	    						@Optional String startsWith,
	    						@Optional String query) 
    		throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveGroups(depth, sort, page, limit, state, startsWith, query);
    }
    
    /**
     * Gets a single group
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-group}
     * 
     * @param groupId The id of the group to retrieve
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * group.json
     * @return A {@link KindlingGroup}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingGroup retrieveGroup(String groupId, @Optional Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveGroup(groupId, depth);
    }
    
    /**
     * Updates a single group
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:update-group}
     * 
     * @param groupId  The id of the group to retrieve
     * @param group The {@link KindlingGroup} with the data to be updated
     * @return A {@link KindlingGroup}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingGroup updateGroup(String groupId, KindlingGroup group)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.updateGroup(groupId, group);    	
    }
    
    /**
     * Create a new group in the groups collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:create-group}
     * 
     * @param group The {@link KindlingGroup} to be created
     * @return A {@link KindlingGroup}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingGroup createGroup(KindlingGroup group)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.createGroup(group);
    }

    /**
     * Gets the comments collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-comments}
     * 
     * @param parentType Retrieve only comments whose parent is of this type
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @param sort <i>Default: title.</i> How the collection output will be sorted, like 'date ASC', 'date', or 'name DESC' etc.
     * @param page <i>Default: 1.</i> The page requested
     * @param limit <i>Default: 20</i> The limit on number of collection items to show per page
     * @param state <i>Default: ACTIVATED.</i> Get only items in the collection that are in the given state, either by a state ID or it's natural language name
     * @param parentId Retrieve only comments of a specific parent ID
     * @param type The type of comments to retrieve
     * @return A {@link KindlingCollection} of {@link KindlingComment}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCollection<KindlingComment> retrieveComments(
    						KindlingCommentParentType parentType,
    						@Optional Integer depth,
							@Optional String sort,
							@Optional Integer page,
							@Optional Integer limit,
							@Optional KindlingState state,
							@Optional Integer parentId,
							@Optional KindlingCommentType type)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveComments(parentType, depth, sort, page, limit, state, parentId, type);
    }
    
    /**
     * Creates a new comment in the comments collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:create-comment}
     *     
     * @param comment The {@link KindlingComment} to be created
     * @return A {@link KindlingComment}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingComment createComment(KindlingComment comment)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.createComment(comment);
    }
    
    /**
     * Gets a single comment
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-comment}
     * 
     * @param commentId The id of the comment to retrieve
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @return @return A {@link KindlingComment}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingComment retrieveComment(String commentId, @Optional Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveComment(commentId, depth);
    }
    
    /**
     * Deletes a single comment
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:delete-comment}
     * 
     * @param commentId The id of the comment to delete
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public void deleteComment(String commentId)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	client.deleteComment(commentId);
    }
    
    /**
     * Gets the ideas collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-ideas}
     * 
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @param sort <i>Default: title.</i> How the collection output will be sorted, like 'date ASC', 'date', or 'name DESC' etc.
     * @param page <i>Default: 1.</i> The page requested
     * @param limit <i>Default: 20</i> The limit on number of collection items to show per page
     * @param state Get only items in the collection that are in the given state, either by a state ID or it's natural language name
     * <p>
     * <ul>
     * 	<li>drafted</li>
     * 	<li>open</li>
     * 	<li>approved</li>
     * 	<li>completed</li>
     * 	<li>declined</li>
     * 	<li>paused</li>
     * 	<li>others depending on workflow settings</ul>
     * </ul>
     * @param allowsVoting only show ideas that can or cannot be voted upon
     * @param query a general idea search string
     * @param authorId show only ideas from a particular author
     * @param categoryId show only ideas in a particular category
     * @param filter conceptual filters
     * @return A {@link KindlingCollection} of {@link KindlingIdea}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCollection<KindlingIdea> retrieveIdeas(@Optional Integer depth,
								@Optional String sort,
								@Optional Integer page,
								@Optional Integer limit,
								@Optional String state,
								@Optional Boolean allowsVoting,
								@Optional String query,
								@Optional String authorId,
								@Optional String categoryId,
								@Optional KindlingIdeaFilter filter)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveIdeas(depth, sort, page, limit, state, allowsVoting, query, authorId, categoryId, filter);
    }
    
    /**
     * Create a new idea in the ideas collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:create-idea}
     * 
     * @param idea The {@link KindlingIdea} to be created
     * @return idea.json
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingIdea createIdea(KindlingIdea idea)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.createIdea(idea);
    }
    
    /**
     * Gets a single idea
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-idea}
     * 
     * @param ideaId The id of the Idea to retrieve
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @return A {@link KindlingIdea}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingIdea retrieveIdea(String ideaId, @Optional Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveIdea(ideaId, depth);
    }
    
    /**
     * Updates a single idea
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:update-idea}
     * 
     * @param ideaId The id of the Idea to update
     * @param idea The {@link KindlingIdea} with the data to be updated
	 * @return A {@link KindlingIdea}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingIdea updateIdea(String ideaId, KindlingIdea idea)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.updateIdea(ideaId, idea);
    }
    
    /**
     * Gets the users collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-users}
     * 
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @param sort <i>Default: title.</i> How the collection output will be sorted, like 'date ASC', 'date', or 'name DESC' etc.
     * @param page <i>Default: 1.</i> The page requested
     * @param limit <i>Default: 20.</i> The limit on number of collection items to show per page
     * @param state <i>Default: ACTIVATED.</i> Get only items in the collection that are in the given state, either by a state ID or it's natural language name
     * @param associatedWithCategoryId only show users associated with a particular category
     * @param digest show only users with a particular type of digest set
     * @param query general user search string
     * @param reputationTimeframe if present, will turn this request into one specifically for reputation leaders for a given timeframe, which may be combined with the associatedWithCategoryId parameter as well to return a leaderbooard for a category
     * @return A {@link KindlingCollection} of {@link KindlingUser}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCollection<KindlingUser> retrieveUsers(@Optional Integer depth,
								@Optional String sort,
								@Optional Integer page,
								@Optional Integer limit,
								@Optional KindlingUserState state,
								@Optional Integer associatedWithCategoryId,
								@Optional KindlingUserDigest digest,
								@Optional String query,
								@Optional KindlingUserReputationTimeframe reputationTimeframe)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveUsers(depth, sort, page, limit, state, associatedWithCategoryId, digest, query, reputationTimeframe);
    }
    
    /**
     * Creates a new user in the users collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:create-user}
     * 
     * @param user The {@link KindlingUser} to be created
     * @return A {@link KindlingUser}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingUser createUser(KindlingUser user)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.createUser(user);
    }
    
    /**
     * Gets a single user
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:create-user}
     * 
     * @param userId The id of the user to retrieve
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @return A {@link KindlingUser}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingUser retrieveUser(String userId, @Optional Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveUser(userId, depth);
    }
    
    /**
     * Updates a single user
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:update-user}
     * 
     * @param userId The id of the user to update
     * @param user The {@link KindlingUser} with the data to be updated
     * @return A {@link KindlingUser}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingUser updateUser(String userId, KindlingUser user)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.updateUser(userId, user);
    }
    
    /**
     * Deletes a single user
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:delete-user}
     * 
     * @param userId The id of the user to delete
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public void deleteUser(String userId)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	client.deleteUser(userId);
    }
    
    /**
     * Gets the categories collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-categories}
     * 
     * 
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @param sort <i>Default: title.</i> How the collection output will be sorted, like 'date ASC', 'date', or 'name DESC' etc.
     * @param page <i>Default: 1.</i> The page requested
     * @param limit <i>Default: 20.</i> The limit on number of collection items to show per page
     * @param state <i>Default: ACTIVATED.</i> Get only items in the collection that are in the given state, either by a state ID or it's natural language name
     * @param query a general category search
     * @param associatedWithUserId If provided, will only return categories that the given user ID has access to
     * @return A {@link KindlingCollection} of {@link KindlingCategory}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCollection<KindlingCategory> retrieveCategories(@Optional Integer depth,
									@Optional String sort,
									@Optional Integer page,
									@Optional Integer limit,
									@Optional KindlingCategoryState state,
									@Optional String query,
									@Optional Integer associatedWithUserId)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveCategories(depth, sort, page, limit, state, query, associatedWithUserId);
    }
    
    /**
     * Creates a new category in the categories collection
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:create-category}
     * 
     * @param category The {@link KindlingCategory} to be created
     * @return A {@link KindlingCategory}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCategory createCategory(KindlingCategory category)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.createCategory(category);
    }
    
    /**
     * Gets a single category
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:retrieve-category}
     * 
     * @param categoryId The id of the category to retrieve
     * @param depth <i>Default: 0.</i> Any object in the result can be displayed at depth, 0 = no depth, 1 = expand first relational object level, etc.
     * @return A {@link KindlingCategory}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCategory retrieveCategory(String categoryId, @Optional Integer depth)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.retrieveCategory(categoryId, depth);
    }
    
    /**
     * Updates a single category
     * <p>
     * {@sample.xml ../../../doc/kindling-connector.xml.sample kindling:update-category}
     * 
     * @param categoryId The id of the category to update
     * @param category The {@link KindlingCategory} with the data to be updated
     * @return A {@link KindlingCategory}
     * @throws KindlingConnectorException If something goes wrong with the service API this exception is throw
     * @throws KindlingConnectorUnauthorizedException If the credentials provided for the user are wrong or are expired this exception is throw
     */
    @Processor
    public KindlingCategory updateCategory(String categoryId, KindlingCategory category)
    	throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
    	
    	return client.updateCategory(categoryId, category);
    }
    
    
}
