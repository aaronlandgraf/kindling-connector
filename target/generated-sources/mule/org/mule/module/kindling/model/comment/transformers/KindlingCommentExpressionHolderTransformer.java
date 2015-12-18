
package org.mule.module.kindling.model.comment.transformers;

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
import org.mule.module.kindling.model.comment.KindlingComment;
import org.mule.module.kindling.model.comment.KindlingCommentParentType;
import org.mule.module.kindling.model.comment.KindlingCommentStateName;
import org.mule.module.kindling.model.comment.KindlingCommentType;
import org.mule.module.kindling.model.comment.holders.KindlingCommentExpressionHolder;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingCommentExpressionHolderTransformer
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
        return (aClass == KindlingCommentExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingCommentExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingCommentExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingCommentExpressionHolder.class)});
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
        return KindlingComment.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingComment.class);
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
        KindlingCommentExpressionHolder holder = ((KindlingCommentExpressionHolder) src);
        KindlingComment result = new KindlingComment();
        try {
            final String _transformedClassName = ((String) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_classNameType").getGenericType(), null, holder.getClassName()));
            result.setClassName(_transformedClassName);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final KindlingUser _transformedOwner = ((KindlingUser) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_ownerType").getGenericType(), null, holder.getOwner()));
            result.setOwner(_transformedOwner);
            final KindlingCommentParentType _transformedParentType = ((KindlingCommentParentType) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_parentTypeType").getGenericType(), null, holder.getParentType()));
            result.setParentType(_transformedParentType);
            final Object _transformedParent = ((Object) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_parentType").getGenericType(), null, holder.getParent()));
            result.setParent(_transformedParent);
            final Object _transformedMatchOptionIndex = ((Object) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_matchOptionIndexType").getGenericType(), null, holder.getMatchOptionIndex()));
            result.setMatchOptionIndex(_transformedMatchOptionIndex);
            final KindlingCommentType _transformedType = ((KindlingCommentType) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Date _transformedDateCreated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_dateCreatedType").getGenericType(), null, holder.getDateCreated()));
            result.setDateCreated(_transformedDateCreated);
            final String _transformedDateCreatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_dateCreatedLocalizedType").getGenericType(), null, holder.getDateCreatedLocalized()));
            result.setDateCreatedLocalized(_transformedDateCreatedLocalized);
            final Integer _transformedStateId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_stateIdType").getGenericType(), null, holder.getStateId()));
            result.setStateId(_transformedStateId);
            final KindlingCommentStateName _transformedStateName = ((KindlingCommentStateName) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_stateNameType").getGenericType(), null, holder.getStateName()));
            result.setStateName(_transformedStateName);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final List<Object> _transformedAttachments = ((List<Object> ) evaluateAndTransform(this.muleContext, event, KindlingCommentExpressionHolder.class.getDeclaredField("_attachmentsType").getGenericType(), null, holder.getAttachments()));
            result.setAttachments(_transformedAttachments);
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
