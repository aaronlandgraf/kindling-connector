
package org.mule.module.kindling.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.module.kindling.KindlingConnector;


/**
 * A <code>KindlingConnectorMetadataAdapater</code> is a wrapper around {@link KindlingConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingConnectorMetadataAdapater
    extends KindlingConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Kindling";
    private final static String MODULE_VERSION = "3.0";
    private final static String DEVKIT_VERSION = "3.6.1";
    private final static String DEVKIT_BUILD = "UNNAMED.2405.44720b7";
    private final static String MIN_MULE_VERSION = "3.5.0";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

}
