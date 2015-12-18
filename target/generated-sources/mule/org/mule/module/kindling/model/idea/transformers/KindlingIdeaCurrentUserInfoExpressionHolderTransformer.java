
package org.mule.module.kindling.model.idea.transformers;

import java.util.Arrays;
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
import org.mule.module.kindling.model.idea.KindlingIdeaCurrentUserInfo;
import org.mule.module.kindling.model.idea.holders.KindlingIdeaCurrentUserInfoExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingIdeaCurrentUserInfoExpressionHolderTransformer
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
        return (aClass == KindlingIdeaCurrentUserInfoExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == KindlingIdeaCurrentUserInfoExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {KindlingIdeaCurrentUserInfoExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(KindlingIdeaCurrentUserInfoExpressionHolder.class)});
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
        return KindlingIdeaCurrentUserInfo.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(KindlingIdeaCurrentUserInfo.class);
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
        KindlingIdeaCurrentUserInfoExpressionHolder holder = ((KindlingIdeaCurrentUserInfoExpressionHolder) src);
        KindlingIdeaCurrentUserInfo result = new KindlingIdeaCurrentUserInfo();
        try {
            final Integer _transformedVotes = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_votesType").getGenericType(), null, holder.getVotes()));
            result.setVotes(_transformedVotes);
            final Integer _transformedVotesAvailable = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_votesAvailableType").getGenericType(), null, holder.getVotesAvailable()));
            result.setVotesAvailable(_transformedVotesAvailable);
            final Integer _transformedVotesMax = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_votesMaxType").getGenericType(), null, holder.getVotesMax()));
            result.setVotesMax(_transformedVotesMax);
            final Integer _transformedVotesTotal = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_votesTotalType").getGenericType(), null, holder.getVotesTotal()));
            result.setVotesTotal(_transformedVotesTotal);
            final Integer _transformedVoterCount = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_voterCountType").getGenericType(), null, holder.getVoterCount()));
            result.setVoterCount(_transformedVoterCount);
            final Integer _transformedIdeaId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_ideaIdType").getGenericType(), null, holder.getIdeaId()));
            result.setIdeaId(_transformedIdeaId);
            final Integer _transformedCategoryId = ((Integer) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_categoryIdType").getGenericType(), null, holder.getCategoryId()));
            result.setCategoryId(_transformedCategoryId);
            final Boolean _transformedIsVotable = ((Boolean) evaluateAndTransform(this.muleContext, event, KindlingIdeaCurrentUserInfoExpressionHolder.class.getDeclaredField("_isVotableType").getGenericType(), null, holder.getIsVotable()));
            result.setIsVotable(_transformedIsVotable);
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
