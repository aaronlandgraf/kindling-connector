
package org.mule.module.kindling.model.category.transformers;

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
import org.mule.module.kindling.model.category.KindlingCategoryIdea;
import org.mule.module.kindling.model.category.KindlingCategoryIdeaRestriction;
import org.mule.module.kindling.model.category.KindlingCategoryStateName;
import org.mule.module.kindling.model.category.holders.KindlingCategoryExpressionHolder;
import org.mule.module.kindling.model.group.KindlingGroup;
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingCategoryExpressionHolderTransformer
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
        return (aClass == KindlingCategoryExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingCategoryExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingCategoryExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingCategoryExpressionHolder.class)});
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
        return KindlingCategory.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingCategory.class);
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
        KindlingCategoryExpressionHolder holder = ((KindlingCategoryExpressionHolder) src);
        KindlingCategory result = new KindlingCategory();
        try {
            final String _transformedClassName = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_classNameType").getGenericType(), null, holder.getClassName()));
            result.setClassName(_transformedClassName);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final Object _transformedParent = ((Object) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_parentType").getGenericType(), null, holder.getParent()));
            result.setParent(_transformedParent);
            final KindlingUser _transformedOwner = ((KindlingUser) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_ownerType").getGenericType(), null, holder.getOwner()));
            result.setOwner(_transformedOwner);
            final String _transformedSlug = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_slugType").getGenericType(), null, holder.getSlug()));
            result.setSlug(_transformedSlug);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Integer _transformedStateId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_stateIdType").getGenericType(), null, holder.getStateId()));
            result.setStateId(_transformedStateId);
            final KindlingCategoryStateName _transformedStateName = ((KindlingCategoryStateName) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_stateNameType").getGenericType(), null, holder.getStateName()));
            result.setStateName(_transformedStateName);
            final Date _transformedDateCreated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateCreatedType").getGenericType(), null, holder.getDateCreated()));
            result.setDateCreated(_transformedDateCreated);
            final String _transformedDateCreatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateCreatedLocalizedType").getGenericType(), null, holder.getDateCreatedLocalized()));
            result.setDateCreatedLocalized(_transformedDateCreatedLocalized);
            final Date _transformedDateUpdated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateUpdatedType").getGenericType(), null, holder.getDateUpdated()));
            result.setDateUpdated(_transformedDateUpdated);
            final String _transformedDateUpdatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateUpdatedLocalizedType").getGenericType(), null, holder.getDateUpdatedLocalized()));
            result.setDateUpdatedLocalized(_transformedDateUpdatedLocalized);
            final Boolean _transformedIsDefault = ((Boolean) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_isDefaultType").getGenericType(), null, holder.getIsDefault()));
            result.setIsDefault(_transformedIsDefault);
            final KindlingCategoryIdeaRestriction _transformedSubmitIdeaRestriction = ((KindlingCategoryIdeaRestriction) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_submitIdeaRestrictionType").getGenericType(), null, holder.getSubmitIdeaRestriction()));
            result.setSubmitIdeaRestriction(_transformedSubmitIdeaRestriction);
            final Date _transformedDateStart = ((Date) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateStartType").getGenericType(), null, holder.getDateStart()));
            result.setDateStart(_transformedDateStart);
            final String _transformedDateStartLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateStartLocalizedType").getGenericType(), null, holder.getDateStartLocalized()));
            result.setDateStartLocalized(_transformedDateStartLocalized);
            final Date _transformedDateEnd = ((Date) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateEndType").getGenericType(), null, holder.getDateEnd()));
            result.setDateEnd(_transformedDateEnd);
            final String _transformedDateEndLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateEndLocalizedType").getGenericType(), null, holder.getDateEndLocalized()));
            result.setDateEndLocalized(_transformedDateEndLocalized);
            final Date _transformedDateClose = ((Date) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateCloseType").getGenericType(), null, holder.getDateClose()));
            result.setDateClose(_transformedDateClose);
            final String _transformedDateCloseLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_dateCloseLocalizedType").getGenericType(), null, holder.getDateCloseLocalized()));
            result.setDateCloseLocalized(_transformedDateCloseLocalized);
            final Integer _transformedNotifyPhase = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_notifyPhaseType").getGenericType(), null, holder.getNotifyPhase()));
            result.setNotifyPhase(_transformedNotifyPhase);
            final Integer _transformedNotifyStart = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_notifyStartType").getGenericType(), null, holder.getNotifyStart()));
            result.setNotifyStart(_transformedNotifyStart);
            final Integer _transformedNotifyDaysLeft = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_notifyDaysLeftType").getGenericType(), null, holder.getNotifyDaysLeft()));
            result.setNotifyDaysLeft(_transformedNotifyDaysLeft);
            final Integer _transformedNotifyEnd = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_notifyEndType").getGenericType(), null, holder.getNotifyEnd()));
            result.setNotifyEnd(_transformedNotifyEnd);
            final String _transformedReward = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_rewardType").getGenericType(), null, holder.getReward()));
            result.setReward(_transformedReward);
            final String _transformedFullyQualifiedTitle = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_fullyQualifiedTitleType").getGenericType(), null, holder.getFullyQualifiedTitle()));
            result.setFullyQualifiedTitle(_transformedFullyQualifiedTitle);
            final List<String> _transformedHierarchy = ((List<String> ) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_hierarchyType").getGenericType(), null, holder.getHierarchy()));
            result.setHierarchy(_transformedHierarchy);
            final KindlingCategoryIdea _transformedIdeas = ((KindlingCategoryIdea) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_ideasType").getGenericType(), null, holder.getIdeas()));
            result.setIdeas(_transformedIdeas);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final String _transformedApplicationUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_applicationUriType").getGenericType(), null, holder.getApplicationUri()));
            result.setApplicationUri(_transformedApplicationUri);
            final Integer _transformedVoteMax = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_voteMaxType").getGenericType(), null, holder.getVoteMax()));
            result.setVoteMax(_transformedVoteMax);
            final List<KindlingGroup> _transformedGroups = ((List<KindlingGroup> ) evaluateAndTransform(this.muleContext, event, KindlingCategoryExpressionHolder.class.getDeclaredField("_groupsType").getGenericType(), null, holder.getGroups()));
            result.setGroups(_transformedGroups);
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
