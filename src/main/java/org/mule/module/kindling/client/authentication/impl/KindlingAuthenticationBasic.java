/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client.authentication.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.module.kindling.client.authentication.KindlingAuthentication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class KindlingAuthenticationBasic implements KindlingAuthentication {

	static final private Log logger = LogFactory.getLog(KindlingAuthenticationBasic.class);
	
	private String username;
	private String password;
	
	public KindlingAuthenticationBasic(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public Client generateClientAndAuthenticate(){		
		Client jerseyClient = new Client();
        HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(username, password);
        // Add basic auth filter for all the
        jerseyClient.addFilter(authFilter);
        
        logger.info("Authentication configuration created for user " + username);
        
        return jerseyClient;
	}

	@Override
	public String getUsername() {
		return username;
	}
}
