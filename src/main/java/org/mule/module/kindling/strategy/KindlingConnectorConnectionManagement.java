/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.strategy;


import org.mule.api.ConnectionException;
import org.mule.api.annotations.*;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.module.kindling.client.KindlingClient;
import org.mule.module.kindling.client.authentication.KindlingAuthentication;
import org.mule.module.kindling.client.authentication.impl.KindlingAuthenticationBasic;
import org.mule.module.kindling.client.impl.KindlingClientImpl;

@ConnectionManagement(configElementName = "config",
        friendlyName = "Connection Management")
public class KindlingConnectorConnectionManagement {

    private KindlingClient client;

    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @param companyName The name of the company registered in kindling and used for access your site like https://{companyName}.kindlingapp.com
     * @param impersonationToken the token used for impersonation
     * @throws ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String username, String password, String companyName, String impersonationToken)
            throws ConnectionException {

        KindlingAuthentication auth = new KindlingAuthenticationBasic(username, password,impersonationToken);
        client = new KindlingClientImpl(companyName, auth);
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        client = null;
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
//        return client != null;
        return false;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

    public KindlingClient getClient() {
        return client;
    }

    public void setClient(KindlingClient client) {
        this.client = client;
    }
}
