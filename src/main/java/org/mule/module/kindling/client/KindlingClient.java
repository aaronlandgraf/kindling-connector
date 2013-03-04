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
import org.mule.module.kindling.model.KindlingCollection;
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.model.comment.KindlingComment;
import org.mule.module.kindling.model.comment.KindlingCommentParentType;
import org.mule.module.kindling.model.comment.KindlingCommentType;
import org.mule.module.kindling.model.group.KindlingGroup;
import org.mule.module.kindling.model.idea.KindlingIdea;
import org.mule.module.kindling.model.post.KindlingPost;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.module.kindling.types.KindlingCategoryState;
import org.mule.module.kindling.types.KindlingIdeaFilter;
import org.mule.module.kindling.types.KindlingPostState;
import org.mule.module.kindling.types.KindlingState;
import org.mule.module.kindling.types.KindlingUserDigest;
import org.mule.module.kindling.types.KindlingUserReputationTimeframe;
import org.mule.module.kindling.types.KindlingUserState;

public interface KindlingClient {

	public KindlingCollection<KindlingGroup> retrieveGroups(Integer depth, String sort, Integer page,
			Integer limit, KindlingState state, String startsWith, String query)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingGroup retrieveGroup(String groupId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingGroup updateGroup(String groupId, KindlingGroup group)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingGroup createGroup(KindlingGroup group)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCollection<KindlingComment> retrieveComments(KindlingCommentParentType parentType,
			Integer depth, String sort, Integer page, Integer limit,
			KindlingState state, Integer parentId, KindlingCommentType type)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingComment createComment(KindlingComment comment)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingComment retrieveComment(String commentId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public void deleteComment(String commentId)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCollection<KindlingIdea> retrieveIdeas(Integer depth, String sort, Integer page,
			Integer limit, String state, Boolean allowsVoting, String query,
			String authorId, String categoryId, KindlingIdeaFilter filter)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingIdea createIdea(KindlingIdea idea)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingIdea retrieveIdea(String ideaId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingIdea updateIdea(String ideaId, KindlingIdea idea)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCollection<KindlingUser> retrieveUsers(Integer depth, String sort, Integer page,
			Integer limit, KindlingUserState state,
			Integer associatedWithCategoryId, KindlingUserDigest digest,
			String query, KindlingUserReputationTimeframe reputationTimeframe)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingUser createUser(KindlingUser user)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingUser retrieveUser(String userId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingUser updateUser(String userId, KindlingUser user)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public void deleteUser(String userId) throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCollection<KindlingCategory> retrieveCategories(Integer depth, String sort, Integer page,
			Integer limit, KindlingCategoryState state, String query,
			Integer associatedWithUserId) throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCategory createCategory(KindlingCategory category)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCategory retrieveCategory(String categoryId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingCategory updateCategory(String categoryId, KindlingCategory category)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;
	
	public KindlingCollection<KindlingPost> retrievePosts(Integer depth, String sort, Integer page,
			Integer limit, KindlingPostState state, String startsWith, String query)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingPost retrievePost(String postId, Integer depth)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingPost updatePost(String postId, KindlingPost group)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;

	public KindlingPost createPost(KindlingPost group)
			throws KindlingConnectorException,
			KindlingConnectorUnauthorizedException;
}
