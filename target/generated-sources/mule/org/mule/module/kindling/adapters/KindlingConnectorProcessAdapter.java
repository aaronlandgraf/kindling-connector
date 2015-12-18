
package org.mule.module.kindling.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.kindling.KindlingConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>KindlingConnectorProcessAdapter</code> is a wrapper around {@link KindlingConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingConnectorProcessAdapter
    extends KindlingConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<KindlingConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, KindlingConnectorCapabilitiesAdapter> getProcessTemplate() {
        final KindlingConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,KindlingConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, KindlingConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, KindlingConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
