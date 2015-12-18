
package org.mule.module.kindling.connectivity;

import javax.annotation.Generated;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionKey;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class ConnectionManagementConfigKindlingConnectorConnectionKey implements ConnectionManagementConnectionKey
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    /**
     * 
     */
    private String companyName;
    /**
     * 
     */
    private String impersonationToken;

    public ConnectionManagementConfigKindlingConnectorConnectionKey(String username, String password, String companyName, String impersonationToken) {
        this.username = username;
        this.password = password;
        this.companyName = companyName;
        this.impersonationToken = impersonationToken;
    }

    /**
     * Sets impersonationToken
     * 
     * @param value Value to set
     */
    public void setImpersonationToken(String value) {
        this.impersonationToken = value;
    }

    /**
     * Retrieves impersonationToken
     * 
     */
    public String getImpersonationToken() {
        return this.impersonationToken;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets companyName
     * 
     * @param value Value to set
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Retrieves companyName
     * 
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    @Override
    public int hashCode() {
        int result = ((this.username!= null)?this.username.hashCode(): 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectionManagementConfigKindlingConnectorConnectionKey)) {
            return false;
        }
        ConnectionManagementConfigKindlingConnectorConnectionKey that = ((ConnectionManagementConfigKindlingConnectorConnectionKey) o);
        if (((this.username!= null)?(!this.username.equals(that.username)):(that.username!= null))) {
            return false;
        }
        return true;
    }

}
