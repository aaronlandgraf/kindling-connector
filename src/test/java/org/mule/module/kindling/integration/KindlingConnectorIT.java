/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.integration;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.module.kindling.KindlingConnector;
import org.mule.module.kindling.exception.KindlingConnectorException;
import org.mule.module.kindling.exception.KindlingConnectorUnauthorizedException;
import org.mule.module.kindling.model.KindlingCollection;
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.model.comment.KindlingComment;
import org.mule.module.kindling.model.comment.KindlingCommentParentType;
import org.mule.module.kindling.model.group.KindlingGroup;
import org.mule.module.kindling.model.idea.KindlingIdea;
import org.mule.module.kindling.model.post.KindlingPost;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.module.kindling.strategy.KindlingConnectorConnectionManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KindlingConnectorIT {
	
	private KindlingConnector kindlingConnector;
	private KindlingConnectorConnectionManagement connectionManagement;
	
	@Before
	public void configuration() throws IOException, ConnectionException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("kindlingconnectorit.properties");
		prop.load(stream);

		kindlingConnector = new KindlingConnector();
		connectionManagement = new KindlingConnectorConnectionManagement();
		kindlingConnector.setConnectionManagement(connectionManagement);
		connectionManagement.connect(prop.getProperty("kindling.it.username"), prop.getProperty("kindling.it.password"), prop.getProperty("kindling.it.company"), prop.getProperty("kindling.it.impersonationToken"));
	}
	
	@Test
	public void retrieves() throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		// Users
		KindlingCollection<KindlingUser> kcku = kindlingConnector.retrieveUsers(3, null, null, null, null, null, null, null, null,null);
		
		Assert.assertNotNull(kcku);
		Assert.assertNotNull(kcku.getResults());
		Assert.assertTrue(kcku.getResults().size() > 0);
		
		KindlingUser ku = kcku.getResults().get(0);
		
		Assert.assertNotNull(ku);
		Assert.assertTrue(ku.getId() > 0);
		
		ku = kindlingConnector.retrieveUser(ku.getId().toString(), 3);
		
		Assert.assertNotNull(ku);
		Assert.assertTrue(ku.getId() > 0);
		
		// Idea
		KindlingCollection<KindlingIdea> kcki = kindlingConnector.retrieveIdeas(3, null, null, null, null, null, null, null, null, null);
		
		Assert.assertNotNull(kcki);
		Assert.assertNotNull(kcki.getResults());
		Assert.assertTrue(kcki.getResults().size() > 0);
		
		KindlingIdea ki = kcki.getResults().get(0);
		
		Assert.assertNotNull(ki);
		Assert.assertTrue(ki.getId() > 0);
		
		ki = kindlingConnector.retrieveIdea(ki.getId().toString(), 3);
		
		Assert.assertNotNull(ki);
		Assert.assertTrue(ki.getId() > 0);
		
		// Group
		KindlingCollection<KindlingGroup> kckg = kindlingConnector.retrieveGroups(3, null, null, null, null, null, null);
		
		Assert.assertNotNull(kckg);
		Assert.assertNotNull(kckg.getResults());
		Assert.assertTrue(kckg.getResults().size() > 0);
		
		KindlingGroup kg = kckg.getResults().get(0);
		
		Assert.assertNotNull(kg);
		Assert.assertTrue(kg.getId() > 0);
		
		kg = kindlingConnector.retrieveGroup(kg.getId().toString(), 3);
		
		Assert.assertNotNull(kg);
		Assert.assertTrue(kg.getId() > 0);
		
		// Comment
		KindlingCollection<KindlingComment> kckc = kindlingConnector.retrieveComments(KindlingCommentParentType.IDEAS, 3, null, null, null, null, null, null);
		
		Assert.assertNotNull(kckc);
		Assert.assertNotNull(kckc.getResults());
		Assert.assertTrue(kckc.getResults().size() > 0);
		
		KindlingComment kc = kckc.getResults().get(0);
		
		Assert.assertNotNull(kc);
		Assert.assertTrue(kc.getId() > 0);
		
		kc = kindlingConnector.retrieveComment(kc.getId().toString(), 3);
		
		Assert.assertNotNull(kc);
		Assert.assertTrue(kc.getId() > 0);
		
		// Category
		KindlingCollection<KindlingCategory> kckca = kindlingConnector.retrieveCategories(3, null, null, null, null, null, null);
		
		Assert.assertNotNull(kckca);
		Assert.assertNotNull(kckca.getResults());
		Assert.assertTrue(kckca.getResults().size() > 0);
		
		KindlingCategory kca = kckca.getResults().get(0);
		
		Assert.assertNotNull(kca);
		Assert.assertTrue(kca.getId() > 0);
		
		kca = kindlingConnector.retrieveCategory(kca.getId().toString(), 3);
		
		Assert.assertNotNull(kca);
		Assert.assertTrue(kca.getId() > 0);

		// Posts
		KindlingCollection<KindlingPost> kckp = kindlingConnector.retrievePosts(3, null, null, null, null, null, null);
		
		Assert.assertNotNull(kckp);
		Assert.assertNotNull(kckp.getResults());
		Assert.assertTrue(kckp.getResults().size() > 0);
		
		KindlingPost kcp = kckp.getResults().get(0);
		
		Assert.assertNotNull(kcp);
		Assert.assertTrue(kcp.getId() > 0);
		
		kcp = kindlingConnector.retrievePost(kcp.getId().toString(), 3);
		
		Assert.assertNotNull(kcp);
		Assert.assertTrue(kcp.getId() > 0);
		
	}
}
