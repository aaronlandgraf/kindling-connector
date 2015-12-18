
package org.mule.module.kindling.model.group.transformers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.module.kindling.model.group.KindlingGroup;
import org.mule.module.kindling.model.group.KindlingGroupStateName;
import org.mule.module.kindling.model.group.KindlingGroupType;
import org.mule.module.kindling.model.group.holders.KindlingGroupExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingGroupExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == KindlingGroupExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingGroupExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingGroupExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingGroupExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return KindlingGroup.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingGroup.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        KindlingGroupExpressionHolder holder = ((KindlingGroupExpressionHolder) src);
        KindlingGroup result = new KindlingGroup();
        try {
            final String _transformedClassName = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_classNameType").getGenericType(), null, holder.getClassName()));
            result.setClassName(_transformedClassName);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final KindlingGroupType _transformedType = ((KindlingGroupType) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final Integer _transformedStateId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_stateIdType").getGenericType(), null, holder.getStateId()));
            result.setStateId(_transformedStateId);
            final KindlingGroupStateName _transformedStateName = ((KindlingGroupStateName) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_stateNameType").getGenericType(), null, holder.getStateName()));
            result.setStateName(_transformedStateName);
            final Boolean _transformedRequiresLdap = ((Boolean) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_requiresLdapType").getGenericType(), null, holder.getRequiresLdap()));
            result.setRequiresLdap(_transformedRequiresLdap);
            final Object _transformedParameters = ((Object) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_parametersType").getGenericType(), null, holder.getParameters()));
            result.setParameters(_transformedParameters);
            final Date _transformedDateCreated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_dateCreatedType").getGenericType(), null, holder.getDateCreated()));
            result.setDateCreated(_transformedDateCreated);
            final String _transformedDateCreatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_dateCreatedLocalizedType").getGenericType(), null, holder.getDateCreatedLocalized()));
            result.setDateCreatedLocalized(_transformedDateCreatedLocalized);
            final Date _transformedDateUpdated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_dateUpdatedType").getGenericType(), null, holder.getDateUpdated()));
            result.setDateUpdated(_transformedDateUpdated);
            final String _transformedDateUpdatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_dateUpdatedLocalizedType").getGenericType(), null, holder.getDateUpdatedLocalized()));
            result.setDateUpdatedLocalized(_transformedDateUpdatedLocalized);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final String _transformedApplicationUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_applicationUriType").getGenericType(), null, holder.getApplicationUri()));
            result.setApplicationUri(_transformedApplicationUri);
            final List<Object> _transformedMembers = ((List<Object> ) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_membersType").getGenericType(), null, holder.getMembers()));
            result.setMembers(_transformedMembers);
            final List<Object> _transformedModerators = ((List<Object> ) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_moderatorsType").getGenericType(), null, holder.getModerators()));
            result.setModerators(_transformedModerators);
            final List<Object> _transformedCategories = ((List<Object> ) evaluateAndTransform(this.muleContext, event, KindlingGroupExpressionHolder.class.getDeclaredField("_categoriesType").getGenericType(), null, holder.getCategories()));
            result.setCategories(_transformedCategories);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
