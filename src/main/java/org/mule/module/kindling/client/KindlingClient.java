/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client;

import org.mule.module.kindling.exception.KindlingConnectorException;
import org.mule.module.kindling.exception.KindlingConnectorUnauthorizedException;
import org.mule.module.kindling.types.KindlingCategoryState;
import org.mule.module.kindling.types.KindlingCommentParentType;
import org.mule.module.kindling.types.KindlingCommentType;
import org.mule.module.kindling.types.KindlingIdeaFilter;
import org.mule.module.kindling.types.KindlingState;
import org.mule.module.kindling.types.KindlingUserDigest;
import org.mule.module.kindling.types.KindlingUserReputationTimeframe;
import org.mule.module.kindling.types.KindlingUserState;

public interface KindlingClient {

	public String retrieveGroups(Integer depth, String sort, Integer page,
			Integer limit, KindlingState state, String startsWith, String query)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveGroup(String groupId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String updateGroup(String groupId, String groupJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String createGroup(String groupJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveComments(KindlingCommentParentType parentType,
			Integer depth, String sort, Integer page, Integer limit,
			KindlingState state, Integer parentId, KindlingCommentType type)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String createComment(String commentJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveComment(String commentId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public void deleteComment(String commentId)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveIdeas(Integer depth, String sort, Integer page,
			Integer limit, String state, Boolean allowsVoting, String query,
			String authorId, String categoryId, KindlingIdeaFilter filter)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String createIdea(String ideaJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveIdea(String ideaId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String updateIdea(String ideaId, String ideaJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveUsers(Integer depth, String sort, Integer page,
			Integer limit, KindlingUserState state,
			Integer associatedWithCategoryId, KindlingUserDigest digest,
			String query, KindlingUserReputationTimeframe reputationTimeframe)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String createUser(String userJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveUser(String userId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String updateUser(String userId, String userJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public void deleteUser(String userId) throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveCategories(Integer depth, String sort, Integer page,
			Integer limit, KindlingCategoryState state, String query,
			Integer associatedWithUserId) throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String createCategory(String categoryJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String retrieveCategory(String categoryId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public String updateCategory(String categoryId, String categoryJson)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;
}
