
package org.mule.module.kindling.model.idea.transformers;

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
import org.mule.module.kindling.model.idea.KindlingIdea;
import org.mule.module.kindling.model.idea.KindlingIdeaCurrentUserInfo;
import org.mule.module.kindling.model.idea.KindlingIdeaStateName;
import org.mule.module.kindling.model.idea.holders.KindlingIdeaExpressionHolder;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingIdeaExpressionHolderTransformer
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
        return (aClass == KindlingIdeaExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingIdeaExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingIdeaExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingIdeaExpressionHolder.class)});
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
        return KindlingIdea.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingIdea.class);
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
        KindlingIdeaExpressionHolder holder = ((KindlingIdeaExpressionHolder) src);
        KindlingIdea result = new KindlingIdea();
        try {
            final String _transformedClassName = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_classNameType").getGenericType(), null, holder.getClassName()));
            result.setClassName(_transformedClassName);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final KindlingCategory _transformedCategory = ((KindlingCategory) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_categoryType").getGenericType(), null, holder.getCategory()));
            result.setCategory(_transformedCategory);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Integer _transformedVotes = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_votesType").getGenericType(), null, holder.getVotes()));
            result.setVotes(_transformedVotes);
            final Integer _transformedAnonymous = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_anonymousType").getGenericType(), null, holder.getAnonymous()));
            result.setAnonymous(_transformedAnonymous);
            final Date _transformedDateCreated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateCreatedType").getGenericType(), null, holder.getDateCreated()));
            result.setDateCreated(_transformedDateCreated);
            final String _transformedDateCreatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateCreatedLocalizedType").getGenericType(), null, holder.getDateCreatedLocalized()));
            result.setDateCreatedLocalized(_transformedDateCreatedLocalized);
            final Date _transformedDateUpdated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateUpdatedType").getGenericType(), null, holder.getDateUpdated()));
            result.setDateUpdated(_transformedDateUpdated);
            final String _transformedDateUpdatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateUpdatedLocalizedType").getGenericType(), null, holder.getDateUpdatedLocalized()));
            result.setDateUpdatedLocalized(_transformedDateUpdatedLocalized);
            final Date _transformedDateManaged = ((Date) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateManagedType").getGenericType(), null, holder.getDateManaged()));
            result.setDateManaged(_transformedDateManaged);
            final String _transformedDateManagedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateManagedLocalizedType").getGenericType(), null, holder.getDateManagedLocalized()));
            result.setDateManagedLocalized(_transformedDateManagedLocalized);
            final Date _transformedDateRectified = ((Date) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateRectifiedType").getGenericType(), null, holder.getDateRectified()));
            result.setDateRectified(_transformedDateRectified);
            final String _transformedDateRectifiedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_dateRectifiedLocalizedType").getGenericType(), null, holder.getDateRectifiedLocalized()));
            result.setDateRectifiedLocalized(_transformedDateRectifiedLocalized);
            final Integer _transformedStateId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_stateIdType").getGenericType(), null, holder.getStateId()));
            result.setStateId(_transformedStateId);
            final KindlingIdeaStateName _transformedStateName = ((KindlingIdeaStateName) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_stateNameType").getGenericType(), null, holder.getStateName()));
            result.setStateName(_transformedStateName);
            final String _transformedCachetags = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_cachetagsType").getGenericType(), null, holder.getCachetags()));
            result.setCachetags(_transformedCachetags);
            final Boolean _transformedLockedForComments = ((Boolean) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_lockedForCommentsType").getGenericType(), null, holder.getLockedForComments()));
            result.setLockedForComments(_transformedLockedForComments);
            final String _transformedBonfireUrl = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_bonfireUrlType").getGenericType(), null, holder.getBonfireUrl()));
            result.setBonfireUrl(_transformedBonfireUrl);
            final String _transformedSubmissionSource = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_submissionSourceType").getGenericType(), null, holder.getSubmissionSource()));
            result.setSubmissionSource(_transformedSubmissionSource);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final String _transformedApplicationUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_applicationUriType").getGenericType(), null, holder.getApplicationUri()));
            result.setApplicationUri(_transformedApplicationUri);
            final Integer _transformedAssignedTo = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_assignedToType").getGenericType(), null, holder.getAssignedTo()));
            result.setAssignedTo(_transformedAssignedTo);
            final KindlingUser _transformedAuthor = ((KindlingUser) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_authorType").getGenericType(), null, holder.getAuthor()));
            result.setAuthor(_transformedAuthor);
            final List<String> _transformedTags = ((List<String> ) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_tagsType").getGenericType(), null, holder.getTags()));
            result.setTags(_transformedTags);
            final List<KindlingComment> _transformedComments = ((List<KindlingComment> ) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_commentsType").getGenericType(), null, holder.getComments()));
            result.setComments(_transformedComments);
            final KindlingIdeaCurrentUserInfo _transformedCurrentUserInfo = ((KindlingIdeaCurrentUserInfo) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_currentUserInfoType").getGenericType(), null, holder.getCurrentUserInfo()));
            result.setCurrentUserInfo(_transformedCurrentUserInfo);
            final Object _transformedEvents = ((Object) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_eventsType").getGenericType(), null, holder.getEvents()));
            result.setEvents(_transformedEvents);
            final List<Object> _transformedVolunteers = ((List<Object> ) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_volunteersType").getGenericType(), null, holder.getVolunteers()));
            result.setVolunteers(_transformedVolunteers);
            final List<Object> _transformedContributors = ((List<Object> ) evaluateAndTransform(this.muleContext, event, KindlingIdeaExpressionHolder.class.getDeclaredField("_contributorsType").getGenericType(), null, holder.getContributors()));
            result.setContributors(_transformedContributors);
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
