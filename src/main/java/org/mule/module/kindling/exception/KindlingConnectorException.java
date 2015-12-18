/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.exception;

public class KindlingConnectorException extends Exception {

	private static final long serialVersionUID = 1L;

	public KindlingConnectorException() {
		super();
	}

	public KindlingConnectorException(String message, Throwable cause) {
		super(message, cause);
	}

	public KindlingConnectorException(String message) {
		super(message);
	}

	public KindlingConnectorException(Throwable cause) {
		super(cause);
	}

}
