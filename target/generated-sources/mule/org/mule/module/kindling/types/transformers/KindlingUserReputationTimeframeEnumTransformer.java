
package org.mule.module.kindling.types.transformers;

import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.module.kindling.types.KindlingUserReputationTimeframe;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingUserReputationTimeframeEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public KindlingUserReputationTimeframeEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(KindlingUserReputationTimeframe.class);
        setName("KindlingUserReputationTimeframeEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        KindlingUserReputationTimeframe result = null;
        result = Enum.valueOf(KindlingUserReputationTimeframe.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
