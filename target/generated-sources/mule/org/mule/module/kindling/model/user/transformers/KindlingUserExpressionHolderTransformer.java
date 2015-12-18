
package org.mule.module.kindling.model.user.transformers;

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
import org.mule.module.kindling.model.user.KindlingUser;
import org.mule.module.kindling.model.user.KindlingUserEmailPreferences;
import org.mule.module.kindling.model.user.KindlingUserStateName;
import org.mule.module.kindling.model.user.holders.KindlingUserExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingUserExpressionHolderTransformer
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
        return (aClass == KindlingUserExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingUserExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingUserExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingUserExpressionHolder.class)});
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
        return KindlingUser.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingUser.class);
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
        KindlingUserExpressionHolder holder = ((KindlingUserExpressionHolder) src);
        KindlingUser result = new KindlingUser();
        try {
            final String _transformedClassName = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_classNameType").getGenericType(), null, holder.getClassName()));
            result.setClassName(_transformedClassName);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final Object _transformedAvatar = ((Object) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_avatarType").getGenericType(), null, holder.getAvatar()));
            result.setAvatar(_transformedAvatar);
            final String _transformedUsername = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_usernameType").getGenericType(), null, holder.getUsername()));
            result.setUsername(_transformedUsername);
            final String _transformedFirstName = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_firstNameType").getGenericType(), null, holder.getFirstName()));
            result.setFirstName(_transformedFirstName);
            final String _transformedLastName = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_lastNameType").getGenericType(), null, holder.getLastName()));
            result.setLastName(_transformedLastName);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final KindlingUserEmailPreferences _transformedEmailPreferences = ((KindlingUserEmailPreferences) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_emailPreferencesType").getGenericType(), null, holder.getEmailPreferences()));
            result.setEmailPreferences(_transformedEmailPreferences);
            final Integer _transformedVotesTotal = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_votesTotalType").getGenericType(), null, holder.getVotesTotal()));
            result.setVotesTotal(_transformedVotesTotal);
            final Integer _transformedReputation = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_reputationType").getGenericType(), null, holder.getReputation()));
            result.setReputation(_transformedReputation);
            final Integer _transformedStateId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_stateIdType").getGenericType(), null, holder.getStateId()));
            result.setStateId(_transformedStateId);
            final KindlingUserStateName _transformedStateName = ((KindlingUserStateName) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_stateNameType").getGenericType(), null, holder.getStateName()));
            result.setStateName(_transformedStateName);
            final Date _transformedResetRequested = ((Date) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_resetRequestedType").getGenericType(), null, holder.getResetRequested()));
            result.setResetRequested(_transformedResetRequested);
            final Boolean _transformedStorNotification = ((Boolean) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_storNotificationType").getGenericType(), null, holder.getStorNotification()));
            result.setStorNotification(_transformedStorNotification);
            final String _transformedBackend = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_backendType").getGenericType(), null, holder.getBackend()));
            result.setBackend(_transformedBackend);
            final String _transformedFullName = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_fullNameType").getGenericType(), null, holder.getFullName()));
            result.setFullName(_transformedFullName);
            final String _transformedAvatarUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_avatarUriType").getGenericType(), null, holder.getAvatarUri()));
            result.setAvatarUri(_transformedAvatarUri);
            final String _transformedResourceUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_resourceUriType").getGenericType(), null, holder.getResourceUri()));
            result.setResourceUri(_transformedResourceUri);
            final String _transformedApplicationUri = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_applicationUriType").getGenericType(), null, holder.getApplicationUri()));
            result.setApplicationUri(_transformedApplicationUri);
            final String _transformedLocale = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_localeType").getGenericType(), null, holder.getLocale()));
            result.setLocale(_transformedLocale);
            final Date _transformedLastLogin = ((Date) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_lastLoginType").getGenericType(), null, holder.getLastLogin()));
            result.setLastLogin(_transformedLastLogin);
            final String _transformedLastLoginLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_lastLoginLocalizedType").getGenericType(), null, holder.getLastLoginLocalized()));
            result.setLastLoginLocalized(_transformedLastLoginLocalized);
            final Date _transformedDateCreated = ((Date) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_dateCreatedType").getGenericType(), null, holder.getDateCreated()));
            result.setDateCreated(_transformedDateCreated);
            final String _transformedDateCreatedLocalized = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_dateCreatedLocalizedType").getGenericType(), null, holder.getDateCreatedLocalized()));
            result.setDateCreatedLocalized(_transformedDateCreatedLocalized);
            final List<String> _transformedSkills = ((List<String> ) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_skillsType").getGenericType(), null, holder.getSkills()));
            result.setSkills(_transformedSkills);
            final List<String> _transformedInterests = ((List<String> ) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_interestsType").getGenericType(), null, holder.getInterests()));
            result.setInterests(_transformedInterests);
            final List<KindlingCategory> _transformedCategories = ((List<KindlingCategory> ) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_categoriesType").getGenericType(), null, holder.getCategories()));
            result.setCategories(_transformedCategories);
            final Boolean _transformedIsAnonymous = ((Boolean) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_isAnonymousType").getGenericType(), null, holder.getIsAnonymous()));
            result.setIsAnonymous(_transformedIsAnonymous);
            final String _transformedToken = ((String) evaluateAndTransform(this.muleContext, event, KindlingUserExpressionHolder.class.getDeclaredField("_tokenType").getGenericType(), null, holder.getToken()));
            result.setToken(_transformedToken);
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
