/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client.authentication.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.module.kindling.client.authentication.KindlingAuthentication;
import org.mule.module.kindling.client.authentication.filter.HTTPCustomFilter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class KindlingAuthenticationBasic implements KindlingAuthentication {

	static final private Log logger = LogFactory.getLog(KindlingAuthenticationBasic.class);
	
	private String username;
	private String password;
	private String impersonationToken;
	
	public KindlingAuthenticationBasic(String username, String password, String impersonationToken) {
		this.username = username;
		this.password = password;
		this.impersonationToken = impersonationToken;
	}
	
	@Override
	public Client generateClientAndAuthenticate(){		
		Client jerseyClient = new Client();
        
		ClientFilter authFilter;
		
		if (StringUtils.isEmpty(impersonationToken)) {
			authFilter = new HTTPBasicAuthFilter(username,password);
		}
		else {
			authFilter = new HTTPCustomFilter(impersonationToken);
		}

		jerseyClient.addFilter(authFilter);
		
		logger.info("Authentication configuration created for user " + username);
        
        return jerseyClient;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getToken() {
		return impersonationToken;
	}
}
