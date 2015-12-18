
package org.mule.module.kindling.model.post.transformers;

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
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.model.comment.KindlingComment;
import org.mule.module.kindling.model.post.KindlingPost;
import org.mule.module.kindling.model.post.KindlingPostStateName;
import org.mule.module.kindling.model.post.holders.KindlingPostExpressionHolder;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingPostExpressionHolderTransformer
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
        return (aClass == KindlingPostExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingPostExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingPostExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingPostExpressionHolder.class)});
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
        return KindlingPost.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingPost.class);
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
        KindlingPostExpressionHolder holder = ((KindlingPostExpressionHolder) src);
        KindlingPost result = new KindlingPost();
        try {
            final String _transformedClassName = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_classNameType").getGenericType(), null, holder.getClassName()));
            result.setClassName(_transformedClassName);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final KindlingCategory _transformedCategory = ((KindlingCategory) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_categoryType").getGenericType(), null, holder.getCategory()));
            result.setCategory(_transformedCategory);
            final KindlingUser _transformedOwner = ((KindlingUser) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_ownerType").getGenericType(), null, holder.getOwner()));
            result.setOwner(_transformedOwner);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Object _transformedPostImage = ((Object) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_postImageType").getGenericType(), null, holder.getPostImage()));
            result.setPostImage(_transformedPostImage);
            final Date _transformedDateCreated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_dateCreatedType").getGenericType(), null, holder.getDateCreated()));
            result.setDateCreated(_transformedDateCreated);
            final String _transformedDateCreatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_dateCreatedLocalizedType").getGenericType(), null, holder.getDateCreatedLocalized()));
            result.setDateCreatedLocalized(_transformedDateCreatedLocalized);
            final Date _transformedDateUpdated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_dateUpdatedType").getGenericType(), null, holder.getDateUpdated()));
            result.setDateUpdated(_transformedDateUpdated);
            final String _transformedDateUpdatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_dateUpdatedLocalizedType").getGenericType(), null, holder.getDateUpdatedLocalized()));
            result.setDateUpdatedLocalized(_transformedDateUpdatedLocalized);
            final String _transformedDatePublished = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_datePublishedType").getGenericType(), null, holder.getDatePublished()));
            result.setDatePublished(_transformedDatePublished);
            final String _transformedDatePublishedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_datePublishedLocalizedType").getGenericType(), null, holder.getDatePublishedLocalized()));
            result.setDatePublishedLocalized(_transformedDatePublishedLocalized);
            final Integer _transformedStateId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_stateIdType").getGenericType(), null, holder.getStateId()));
            result.setStateId(_transformedStateId);
            final KindlingPostStateName _transformedStateName = ((KindlingPostStateName) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_stateNameType").getGenericType(), null, holder.getStateName()));
            result.setStateName(_transformedStateName);
            final Object _transformedCachedTags = ((Object) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_cachedTagsType").getGenericType(), null, holder.getCachedTags()));
            result.setCachedTags(_transformedCachedTags);
            final Integer _transformedLockedForComments = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_lockedForCommentsType").getGenericType(), null, holder.getLockedForComments()));
            result.setLockedForComments(_transformedLockedForComments);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final String _transformedApplicationUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_applicationUriType").getGenericType(), null, holder.getApplicationUri()));
            result.setApplicationUri(_transformedApplicationUri);
            final List<String> _transformedTags = ((List<String> ) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_tagsType").getGenericType(), null, holder.getTags()));
            result.setTags(_transformedTags);
            final List<KindlingComment> _transformedComments = ((List<KindlingComment> ) evaluateAndTransform(this.muleContext, event, KindlingPostExpressionHolder.class.getDeclaredField("_commentsType").getGenericType(), null, holder.getComments()));
            result.setComments(_transformedComments);
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
