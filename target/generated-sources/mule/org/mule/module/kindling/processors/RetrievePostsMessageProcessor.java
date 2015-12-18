
package org.mule.module.kindling.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.module.kindling.KindlingConnector;
import org.mule.module.kindling.model.KindlingCollection;
import org.mule.module.kindling.types.KindlingPostState;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * RetrievePostsMessageProcessor invokes the {@link org.mule.module.kindling.KindlingConnector#retrievePosts(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.mule.module.kindling.types.KindlingPostState, java.lang.String, java.lang.String)} method in {@link KindlingConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RetrievePostsMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object depth;
    protected Integer _depthType;
    protected Object sort;
    protected String _sortType;
    protected Object page;
    protected Integer _pageType;
    protected Object limit;
    protected Integer _limitType;
    protected Object state;
    protected KindlingPostState _stateType;
    protected Object startsWith;
    protected String _startsWithType;
    protected Object query;
    protected String _queryType;

    public RetrievePostsMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets limit
     * 
     * @param value Value to set
     */
    public void setLimit(Object value) {
        this.limit = value;
    }

    /**
     * Sets startsWith
     * 
     * @param value Value to set
     */
    public void setStartsWith(Object value) {
        this.startsWith = value;
    }

    /**
     * Sets sort
     * 
     * @param value Value to set
     */
    public void setSort(Object value) {
        this.sort = value;
    }

    /**
     * Sets page
     * 
     * @param value Value to set
     */
    public void setPage(Object value) {
        this.page = value;
    }

    /**
     * Sets query
     * 
     * @param value Value to set
     */
    public void setQuery(Object value) {
        this.query = value;
    }

    /**
     * Sets state
     * 
     * @param value Value to set
     */
    public void setState(Object value) {
        this.state = value;
    }

    /**
     * Sets depth
     * 
     * @param value Value to set
     */
    public void setDepth(Object value) {
        this.depth = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final Integer _transformedDepth = ((Integer) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_depthType").getGenericType(), null, depth));
            final String _transformedSort = ((String) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_sortType").getGenericType(), null, sort));
            final Integer _transformedPage = ((Integer) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_pageType").getGenericType(), null, page));
            final Integer _transformedLimit = ((Integer) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_limitType").getGenericType(), null, limit));
            final KindlingPostState _transformedState = ((KindlingPostState) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_stateType").getGenericType(), null, state));
            final String _transformedStartsWith = ((String) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_startsWithType").getGenericType(), null, startsWith));
            final String _transformedQuery = ((String) evaluateAndTransform(getMuleContext(), event, RetrievePostsMessageProcessor.class.getDeclaredField("_queryType").getGenericType(), null, query));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((KindlingConnector) object).retrievePosts(_transformedDepth, _transformedSort, _transformedPage, _transformedLimit, _transformedState, _transformedStartsWith, _transformedQuery);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(KindlingCollection.class)));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at KindlingConnector at retrievePosts retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
