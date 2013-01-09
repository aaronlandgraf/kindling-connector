/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.mule.module.kindling.client.authentication.KindlingAuthentication;
import org.mule.module.kindling.exception.KindlingConnectorException;
import org.mule.module.kindling.exception.KindlingConnectorUnauthorizedException;
import org.mule.module.kindling.types.KindlingWebResourceMethods;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;


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
    
	protected String webResourceGet(WebResource wr, KindlingWebResourceMethods method, String requestBody) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		try {
			return webResourceCallByEnumType(wr, method, requestBody);
		} catch (UniformInterfaceException e) {
			int statusCode = e.getResponse().getStatus();
			
			// The code 204 is returned as a successful operation with no response, but as the expected parameter is a String.class it throws a UniformInterfaceException.
			if (statusCode == 204) {
				return "";
			} else if (statusCode == 401) {
				throw new KindlingConnectorUnauthorizedException(loggedUser);
			} else {
				throw new KindlingConnectorException("ERROR - statusCode: " + statusCode, e);
			}
		}
	}
    
	protected String webResourceCallByEnumType(WebResource wr, KindlingWebResourceMethods method, String requestBody) {
		if (KindlingWebResourceMethods.GET.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		} else if (KindlingWebResourceMethods.POST.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).post(String.class, requestBody);
		} else if (KindlingWebResourceMethods.PUT.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).put(String.class, requestBody);
		} else if (KindlingWebResourceMethods.DELETE.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
		} else {
			return null;
		}
	}

}
