/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.exception;

public class KindlingConnectorUnauthorizedException extends Exception {

	private static final long serialVersionUID = 1L;

	public KindlingConnectorUnauthorizedException(String username) {
		super("The credentials supplied for user " + username + " are not valid");
	}
}
