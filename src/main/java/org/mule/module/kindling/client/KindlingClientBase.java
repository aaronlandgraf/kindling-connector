/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.client;

import javax.ws.rs.core.UriBuilder;

import org.mule.module.kindling.client.authentication.KindlingAuthentication;

import com.sun.jersey.api.client.Client;


abstract public class KindlingClientBase implements KindlingClient {
	
	static final private String API_URL = "https://%s.kindlingapp.com/api/";
	
	private Client jerseyClient;
	
	private String loggedUser;
	
	private String companyName;
	
	private KindlingAuthentication authentication;
	
	public KindlingClientBase(String companyName, KindlingAuthentication authentication) {
		this.companyName = companyName;
		this.authentication = authentication;
		loggedUser = authentication.getUsername();
		jerseyClient = null;
	}
	
	/**
	 * This method returns the jersey client used to call the service. It is created when the first call to a processor is made
	 * @return The jersey client instance
	 */
	synchronized protected Client getJerseyClient() {
		if (jerseyClient == null)
			jerseyClient = authentication.generateClientAndAuthenticate();
		
		return jerseyClient;
	}
	
	protected UriBuilder getBaseUriBuilder() {
    	return UriBuilder.fromPath(String.format(API_URL, companyName));
    }

	public String getLoggedUser() {
		return loggedUser;
	}
	
	public KindlingAuthentication getAuthentication(){
		return authentication;
	}
	
}
