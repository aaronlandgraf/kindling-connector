
package org.mule.module.kindling.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.kindling.model.group.holders.KindlingGroupExpressionHolder;
import org.mule.module.kindling.processors.CreateGroupMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class CreateGroupDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateGroupDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateGroupMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-group] within the connector [kindling] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-group] within the connector [kindling] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createGroup");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-group] within the connector [kindling] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "group", "group")) {
            BeanDefinitionBuilder groupBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class.getName());
            Element groupChildElement = DomUtils.getChildElementByTagName(element, "group");
            if (groupChildElement!= null) {
                parseProperty(groupBuilder, groupChildElement, "className", "className");
                parseProperty(groupBuilder, groupChildElement, "id", "id");
                parseProperty(groupBuilder, groupChildElement, "title", "title");
                parseProperty(groupBuilder, groupChildElement, "description", "description");
                parseProperty(groupBuilder, groupChildElement, "type", "type");
                parseProperty(groupBuilder, groupChildElement, "stateId", "stateId");
                parseProperty(groupBuilder, groupChildElement, "stateName", "stateName");
                parseProperty(groupBuilder, groupChildElement, "requiresLdap", "requiresLdap");
                if (hasAttribute(groupChildElement, "parameters-ref")) {
                    if (groupChildElement.getAttribute("parameters-ref").startsWith("#")) {
                        groupBuilder.addPropertyValue("parameters", groupChildElement.getAttribute("parameters-ref"));
                    } else {
                        groupBuilder.addPropertyValue("parameters", (("#[registry:"+ groupChildElement.getAttribute("parameters-ref"))+"]"));
                    }
                }
                parseProperty(groupBuilder, groupChildElement, "dateCreated", "dateCreated");
                parseProperty(groupBuilder, groupChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                parseProperty(groupBuilder, groupChildElement, "dateUpdated", "dateUpdated");
                parseProperty(groupBuilder, groupChildElement, "dateUpdatedLocalized", "dateUpdatedLocalized");
                parseProperty(groupBuilder, groupChildElement, "resourceUri", "resourceUri");
                parseProperty(groupBuilder, groupChildElement, "applicationUri", "applicationUri");
                parseListAndSetProperty(groupChildElement, groupBuilder, "members", "members", "member", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(groupChildElement, groupBuilder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(groupChildElement, groupBuilder, "categories", "categories", "category", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                builder.addPropertyValue("group", groupBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}