/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client.authentication.filter;

import javax.ws.rs.core.HttpHeaders;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class HTTPCustomFilter extends ClientFilter {
	
	private final String authentication;
	
	public HTTPCustomFilter(final String impersonationToken){
            authentication = "Token " + impersonationToken;
	}

	@Override
	public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
        
		cr.getHeaders().add(HttpHeaders.AUTHORIZATION, authentication);
        
		return getNext().handle(cr);
	}

}
