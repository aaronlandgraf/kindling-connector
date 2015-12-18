/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
			logger.info("Authentication configuration created for user " + username);
		}
		else {
			authFilter = new HTTPCustomFilter(impersonationToken);
			logger.info("Authentication configuration created for supplied token");
		}

		jerseyClient.addFilter(authFilter);
		
        
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
