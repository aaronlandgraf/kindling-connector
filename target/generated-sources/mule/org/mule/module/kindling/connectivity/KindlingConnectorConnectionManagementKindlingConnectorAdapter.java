
package org.mule.module.kindling.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.module.kindling.strategy.KindlingConnectorConnectionManagement;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingConnectorConnectionManagementKindlingConnectorAdapter
    extends KindlingConnectorConnectionManagement
    implements ConnectionManagementConnectionAdapter<KindlingConnectorConnectionManagement, ConnectionManagementConfigKindlingConnectorConnectionKey>
{


    @Override
    public void connect(ConnectionManagementConfigKindlingConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getUsername(), connectionKey.getPassword(), connectionKey.getCompanyName(), connectionKey.getImpersonationToken());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.connectionId();
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public KindlingConnectorConnectionManagement getStrategy() {
        return this;
    }

}
