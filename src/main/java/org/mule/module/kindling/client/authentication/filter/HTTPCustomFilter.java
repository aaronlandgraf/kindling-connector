/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
