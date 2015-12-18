/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.exception;

import org.apache.commons.lang.StringUtils;

public class KindlingConnectorUnauthorizedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String token;

	public KindlingConnectorUnauthorizedException(String username, String token) {
		super( StringUtils.isEmpty(token) ? 
				"The credentials supplied for user " + username + " are not valid" :
				"The supplied token (" + token + ") has expired");
		this.setUsername(username);
		this.setToken(token);
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
