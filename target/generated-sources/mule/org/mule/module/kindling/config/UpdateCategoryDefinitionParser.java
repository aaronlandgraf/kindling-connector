
package org.mule.module.kindling.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.kindling.model.category.holders.KindlingCategoryExpressionHolder;
import org.mule.module.kindling.model.category.holders.KindlingCategoryIdeaExpressionHolder;
import org.mule.module.kindling.model.group.holders.KindlingGroupExpressionHolder;
import org.mule.module.kindling.model.user.holders.KindlingUserEmailPreferencesExpressionHolder;
import org.mule.module.kindling.model.user.holders.KindlingUserExpressionHolder;
import org.mule.module.kindling.processors.UpdateCategoryMessageProcessor;
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
public class UpdateCategoryDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateCategoryDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateCategoryMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-category] within the connector [kindling] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-category] within the connector [kindling] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateCategory");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-category] within the connector [kindling] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "categoryId", "categoryId");
        if (!parseObjectRef(element, builder, "category", "category")) {
            BeanDefinitionBuilder categoryBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class.getName());
            Element categoryChildElement = DomUtils.getChildElementByTagName(element, "category");
            if (categoryChildElement!= null) {
                parseProperty(categoryBuilder, categoryChildElement, "className", "className");
                parseProperty(categoryBuilder, categoryChildElement, "id", "id");
                if (hasAttribute(categoryChildElement, "parent-ref")) {
                    if (categoryChildElement.getAttribute("parent-ref").startsWith("#")) {
                        categoryBuilder.addPropertyValue("parent", categoryChildElement.getAttribute("parent-ref"));
                    } else {
                        categoryBuilder.addPropertyValue("parent", (("#[registry:"+ categoryChildElement.getAttribute("parent-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(categoryChildElement, categoryBuilder, "owner", "owner")) {
                    BeanDefinitionBuilder _ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                    Element _ownerChildElement = DomUtils.getChildElementByTagName(categoryChildElement, "owner");
                    if (_ownerChildElement!= null) {
                        parseProperty(_ownerBuilder, _ownerChildElement, "className", "className");
                        parseProperty(_ownerBuilder, _ownerChildElement, "id", "id");
                        if (hasAttribute(_ownerChildElement, "avatar-ref")) {
                            if (_ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                _ownerBuilder.addPropertyValue("avatar", _ownerChildElement.getAttribute("avatar-ref"));
                            } else {
                                _ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _ownerChildElement.getAttribute("avatar-ref"))+"]"));
                            }
                        }
                        parseProperty(_ownerBuilder, _ownerChildElement, "username", "username");
                        parseProperty(_ownerBuilder, _ownerChildElement, "firstName", "firstName");
                        parseProperty(_ownerBuilder, _ownerChildElement, "lastName", "lastName");
                        parseProperty(_ownerBuilder, _ownerChildElement, "email", "email");
                        if (!parseObjectRef(_ownerChildElement, _ownerBuilder, "email-preferences", "emailPreferences")) {
                            BeanDefinitionBuilder __emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                            Element __emailPreferencesChildElement = DomUtils.getChildElementByTagName(_ownerChildElement, "email-preferences");
                            if (__emailPreferencesChildElement!= null) {
                                parseProperty(__emailPreferencesBuilder, __emailPreferencesChildElement, "defaultValue", "defaultValue");
                                if (hasAttribute(__emailPreferencesChildElement, "categories-ref")) {
                                    if (__emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                        __emailPreferencesBuilder.addPropertyValue("categories", __emailPreferencesChildElement.getAttribute("categories-ref"));
                                    } else {
                                        __emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ __emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                    }
                                }
                                _ownerBuilder.addPropertyValue("emailPreferences", __emailPreferencesBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(_ownerBuilder, _ownerChildElement, "votesTotal", "votesTotal");
                        parseProperty(_ownerBuilder, _ownerChildElement, "reputation", "reputation");
                        parseProperty(_ownerBuilder, _ownerChildElement, "stateId", "stateId");
                        parseProperty(_ownerBuilder, _ownerChildElement, "stateName", "stateName");
                        parseProperty(_ownerBuilder, _ownerChildElement, "resetRequested", "resetRequested");
                        parseProperty(_ownerBuilder, _ownerChildElement, "storNotification", "storNotification");
                        parseProperty(_ownerBuilder, _ownerChildElement, "backend", "backend");
                        parseProperty(_ownerBuilder, _ownerChildElement, "fullName", "fullName");
                        parseProperty(_ownerBuilder, _ownerChildElement, "avatarUri", "avatarUri");
                        parseProperty(_ownerBuilder, _ownerChildElement, "resourceUri", "resourceUri");
                        parseProperty(_ownerBuilder, _ownerChildElement, "applicationUri", "applicationUri");
                        parseProperty(_ownerBuilder, _ownerChildElement, "locale", "locale");
                        parseProperty(_ownerBuilder, _ownerChildElement, "lastLogin", "lastLogin");
                        parseProperty(_ownerBuilder, _ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                        parseProperty(_ownerBuilder, _ownerChildElement, "dateCreated", "dateCreated");
                        parseProperty(_ownerBuilder, _ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                        parseListAndSetProperty(_ownerChildElement, _ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        parseListAndSetProperty(_ownerChildElement, _ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        parseListAndSetProperty(_ownerChildElement, _ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                parseProperty(builder, element, "className", "className");
                                parseProperty(builder, element, "id", "id");
                                if (hasAttribute(element, "parent-ref")) {
                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                    } else {
                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                    }
                                }
                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                    BeanDefinitionBuilder ___ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                    Element ___ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                    if (___ownerChildElement!= null) {
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "className", "className");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "id", "id");
                                        if (hasAttribute(___ownerChildElement, "avatar-ref")) {
                                            if (___ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                ___ownerBuilder.addPropertyValue("avatar", ___ownerChildElement.getAttribute("avatar-ref"));
                                            } else {
                                                ___ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ___ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                            }
                                        }
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "username", "username");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "firstName", "firstName");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "lastName", "lastName");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "email", "email");
                                        if (!parseObjectRef(___ownerChildElement, ___ownerBuilder, "email-preferences", "emailPreferences")) {
                                            BeanDefinitionBuilder ____emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                            Element ____emailPreferencesChildElement = DomUtils.getChildElementByTagName(___ownerChildElement, "email-preferences");
                                            if (____emailPreferencesChildElement!= null) {
                                                parseProperty(____emailPreferencesBuilder, ____emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                if (hasAttribute(____emailPreferencesChildElement, "categories-ref")) {
                                                    if (____emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                        ____emailPreferencesBuilder.addPropertyValue("categories", ____emailPreferencesChildElement.getAttribute("categories-ref"));
                                                    } else {
                                                        ____emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ____emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                    }
                                                }
                                                ___ownerBuilder.addPropertyValue("emailPreferences", ____emailPreferencesBuilder.getBeanDefinition());
                                            }
                                        }
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "votesTotal", "votesTotal");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "reputation", "reputation");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "stateId", "stateId");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "stateName", "stateName");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "resetRequested", "resetRequested");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "storNotification", "storNotification");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "backend", "backend");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "fullName", "fullName");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "avatarUri", "avatarUri");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "resourceUri", "resourceUri");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "applicationUri", "applicationUri");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "locale", "locale");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "lastLogin", "lastLogin");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "dateCreated", "dateCreated");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                        parseListAndSetProperty(___ownerChildElement, ___ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                            public String parse(Element element) {
                                                return element.getTextContent();
                                            }

                                        }
                                        );
                                        parseListAndSetProperty(___ownerChildElement, ___ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                            public String parse(Element element) {
                                                return element.getTextContent();
                                            }

                                        }
                                        );
                                        parseListAndSetProperty(___ownerChildElement, ___ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                            public BeanDefinition parse(Element element) {
                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                parseProperty(builder, element, "className", "className");
                                                parseProperty(builder, element, "id", "id");
                                                if (hasAttribute(element, "parent-ref")) {
                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                    } else {
                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                    }
                                                }
                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                    BeanDefinitionBuilder _____ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                    Element _____ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                    if (_____ownerChildElement!= null) {
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "className", "className");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "id", "id");
                                                        if (hasAttribute(_____ownerChildElement, "avatar-ref")) {
                                                            if (_____ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                _____ownerBuilder.addPropertyValue("avatar", _____ownerChildElement.getAttribute("avatar-ref"));
                                                            } else {
                                                                _____ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _____ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                            }
                                                        }
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "username", "username");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "firstName", "firstName");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "lastName", "lastName");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "email", "email");
                                                        if (!parseObjectRef(_____ownerChildElement, _____ownerBuilder, "email-preferences", "emailPreferences")) {
                                                            BeanDefinitionBuilder ______emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                            Element ______emailPreferencesChildElement = DomUtils.getChildElementByTagName(_____ownerChildElement, "email-preferences");
                                                            if (______emailPreferencesChildElement!= null) {
                                                                parseProperty(______emailPreferencesBuilder, ______emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                if (hasAttribute(______emailPreferencesChildElement, "categories-ref")) {
                                                                    if (______emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                        ______emailPreferencesBuilder.addPropertyValue("categories", ______emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                    } else {
                                                                        ______emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ______emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                    }
                                                                }
                                                                _____ownerBuilder.addPropertyValue("emailPreferences", ______emailPreferencesBuilder.getBeanDefinition());
                                                            }
                                                        }
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "votesTotal", "votesTotal");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "reputation", "reputation");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "stateId", "stateId");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "stateName", "stateName");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "resetRequested", "resetRequested");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "storNotification", "storNotification");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "backend", "backend");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "fullName", "fullName");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "avatarUri", "avatarUri");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "resourceUri", "resourceUri");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "applicationUri", "applicationUri");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "locale", "locale");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "lastLogin", "lastLogin");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "dateCreated", "dateCreated");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                        parseListAndSetProperty(_____ownerChildElement, _____ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                            public String parse(Element element) {
                                                                return element.getTextContent();
                                                            }

                                                        }
                                                        );
                                                        parseListAndSetProperty(_____ownerChildElement, _____ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                            public String parse(Element element) {
                                                                return element.getTextContent();
                                                            }

                                                        }
                                                        );
                                                        parseListAndSetProperty(_____ownerChildElement, _____ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                            public BeanDefinition parse(Element element) {
                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                parseProperty(builder, element, "className", "className");
                                                                parseProperty(builder, element, "id", "id");
                                                                if (hasAttribute(element, "parent-ref")) {
                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                    } else {
                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                    }
                                                                }
                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                    BeanDefinitionBuilder _______ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                    Element _______ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                    if (_______ownerChildElement!= null) {
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "className", "className");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "id", "id");
                                                                        if (hasAttribute(_______ownerChildElement, "avatar-ref")) {
                                                                            if (_______ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                _______ownerBuilder.addPropertyValue("avatar", _______ownerChildElement.getAttribute("avatar-ref"));
                                                                            } else {
                                                                                _______ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _______ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                            }
                                                                        }
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "username", "username");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "firstName", "firstName");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "lastName", "lastName");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "email", "email");
                                                                        if (!parseObjectRef(_______ownerChildElement, _______ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                            BeanDefinitionBuilder ________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                            Element ________emailPreferencesChildElement = DomUtils.getChildElementByTagName(_______ownerChildElement, "email-preferences");
                                                                            if (________emailPreferencesChildElement!= null) {
                                                                                parseProperty(________emailPreferencesBuilder, ________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                if (hasAttribute(________emailPreferencesChildElement, "categories-ref")) {
                                                                                    if (________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                        ________emailPreferencesBuilder.addPropertyValue("categories", ________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                    } else {
                                                                                        ________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                    }
                                                                                }
                                                                                _______ownerBuilder.addPropertyValue("emailPreferences", ________emailPreferencesBuilder.getBeanDefinition());
                                                                            }
                                                                        }
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "votesTotal", "votesTotal");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "reputation", "reputation");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "stateId", "stateId");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "stateName", "stateName");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "resetRequested", "resetRequested");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "storNotification", "storNotification");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "backend", "backend");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "fullName", "fullName");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "avatarUri", "avatarUri");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "resourceUri", "resourceUri");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "applicationUri", "applicationUri");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "locale", "locale");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "lastLogin", "lastLogin");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "dateCreated", "dateCreated");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                        parseListAndSetProperty(_______ownerChildElement, _______ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                            public String parse(Element element) {
                                                                                return element.getTextContent();
                                                                            }

                                                                        }
                                                                        );
                                                                        parseListAndSetProperty(_______ownerChildElement, _______ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                            public String parse(Element element) {
                                                                                return element.getTextContent();
                                                                            }

                                                                        }
                                                                        );
                                                                        parseListAndSetProperty(_______ownerChildElement, _______ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                            public BeanDefinition parse(Element element) {
                                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                                parseProperty(builder, element, "className", "className");
                                                                                parseProperty(builder, element, "id", "id");
                                                                                if (hasAttribute(element, "parent-ref")) {
                                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                                    } else {
                                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                                    }
                                                                                }
                                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                                    BeanDefinitionBuilder _________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                    Element _________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                    if (_________ownerChildElement!= null) {
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "className", "className");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "id", "id");
                                                                                        if (hasAttribute(_________ownerChildElement, "avatar-ref")) {
                                                                                            if (_________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                _________ownerBuilder.addPropertyValue("avatar", _________ownerChildElement.getAttribute("avatar-ref"));
                                                                                            } else {
                                                                                                _________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                            }
                                                                                        }
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "username", "username");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "firstName", "firstName");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "lastName", "lastName");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "email", "email");
                                                                                        if (!parseObjectRef(_________ownerChildElement, _________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                            BeanDefinitionBuilder __________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                            Element __________emailPreferencesChildElement = DomUtils.getChildElementByTagName(_________ownerChildElement, "email-preferences");
                                                                                            if (__________emailPreferencesChildElement!= null) {
                                                                                                parseProperty(__________emailPreferencesBuilder, __________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                if (hasAttribute(__________emailPreferencesChildElement, "categories-ref")) {
                                                                                                    if (__________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                        __________emailPreferencesBuilder.addPropertyValue("categories", __________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                    } else {
                                                                                                        __________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ __________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                    }
                                                                                                }
                                                                                                _________ownerBuilder.addPropertyValue("emailPreferences", __________emailPreferencesBuilder.getBeanDefinition());
                                                                                            }
                                                                                        }
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "votesTotal", "votesTotal");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "reputation", "reputation");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "stateId", "stateId");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "stateName", "stateName");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "resetRequested", "resetRequested");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "storNotification", "storNotification");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "backend", "backend");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "fullName", "fullName");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "avatarUri", "avatarUri");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "resourceUri", "resourceUri");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "applicationUri", "applicationUri");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "locale", "locale");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "lastLogin", "lastLogin");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "dateCreated", "dateCreated");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                        parseListAndSetProperty(_________ownerChildElement, _________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                            public String parse(Element element) {
                                                                                                return element.getTextContent();
                                                                                            }

                                                                                        }
                                                                                        );
                                                                                        parseListAndSetProperty(_________ownerChildElement, _________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                            public String parse(Element element) {
                                                                                                return element.getTextContent();
                                                                                            }

                                                                                        }
                                                                                        );
                                                                                        parseListAndSetProperty(_________ownerChildElement, _________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                            public BeanDefinition parse(Element element) {
                                                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                                                parseProperty(builder, element, "className", "className");
                                                                                                parseProperty(builder, element, "id", "id");
                                                                                                if (hasAttribute(element, "parent-ref")) {
                                                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                                                    } else {
                                                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                                                    }
                                                                                                }
                                                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                                                    BeanDefinitionBuilder ___________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                    Element ___________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                    if (___________ownerChildElement!= null) {
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "className", "className");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "id", "id");
                                                                                                        if (hasAttribute(___________ownerChildElement, "avatar-ref")) {
                                                                                                            if (___________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                ___________ownerBuilder.addPropertyValue("avatar", ___________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                            } else {
                                                                                                                ___________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ___________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                            }
                                                                                                        }
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "username", "username");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "firstName", "firstName");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "lastName", "lastName");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "email", "email");
                                                                                                        if (!parseObjectRef(___________ownerChildElement, ___________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                            BeanDefinitionBuilder ____________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                            Element ____________emailPreferencesChildElement = DomUtils.getChildElementByTagName(___________ownerChildElement, "email-preferences");
                                                                                                            if (____________emailPreferencesChildElement!= null) {
                                                                                                                parseProperty(____________emailPreferencesBuilder, ____________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                if (hasAttribute(____________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                    if (____________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                        ____________emailPreferencesBuilder.addPropertyValue("categories", ____________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                    } else {
                                                                                                                        ____________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ____________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                    }
                                                                                                                }
                                                                                                                ___________ownerBuilder.addPropertyValue("emailPreferences", ____________emailPreferencesBuilder.getBeanDefinition());
                                                                                                            }
                                                                                                        }
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "reputation", "reputation");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "stateId", "stateId");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "stateName", "stateName");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "storNotification", "storNotification");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "backend", "backend");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "fullName", "fullName");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "locale", "locale");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                        parseListAndSetProperty(___________ownerChildElement, ___________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                            public String parse(Element element) {
                                                                                                                return element.getTextContent();
                                                                                                            }

                                                                                                        }
                                                                                                        );
                                                                                                        parseListAndSetProperty(___________ownerChildElement, ___________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                            public String parse(Element element) {
                                                                                                                return element.getTextContent();
                                                                                                            }

                                                                                                        }
                                                                                                        );
                                                                                                        parseListAndSetProperty(___________ownerChildElement, ___________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                                            public BeanDefinition parse(Element element) {
                                                                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                                                                parseProperty(builder, element, "className", "className");
                                                                                                                parseProperty(builder, element, "id", "id");
                                                                                                                if (hasAttribute(element, "parent-ref")) {
                                                                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                                                                    } else {
                                                                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                                                                    }
                                                                                                                }
                                                                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                                                                    BeanDefinitionBuilder _____________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                    Element _____________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                    if (_____________ownerChildElement!= null) {
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "className", "className");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "id", "id");
                                                                                                                        if (hasAttribute(_____________ownerChildElement, "avatar-ref")) {
                                                                                                                            if (_____________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                _____________ownerBuilder.addPropertyValue("avatar", _____________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                            } else {
                                                                                                                                _____________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _____________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                            }
                                                                                                                        }
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "username", "username");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "firstName", "firstName");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "lastName", "lastName");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "email", "email");
                                                                                                                        if (!parseObjectRef(_____________ownerChildElement, _____________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                            BeanDefinitionBuilder ______________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                            Element ______________emailPreferencesChildElement = DomUtils.getChildElementByTagName(_____________ownerChildElement, "email-preferences");
                                                                                                                            if (______________emailPreferencesChildElement!= null) {
                                                                                                                                parseProperty(______________emailPreferencesBuilder, ______________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                if (hasAttribute(______________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                    if (______________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                        ______________emailPreferencesBuilder.addPropertyValue("categories", ______________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                    } else {
                                                                                                                                        ______________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ______________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                _____________ownerBuilder.addPropertyValue("emailPreferences", ______________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                            }
                                                                                                                        }
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "reputation", "reputation");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "stateId", "stateId");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "stateName", "stateName");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "storNotification", "storNotification");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "backend", "backend");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "fullName", "fullName");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "locale", "locale");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                        parseListAndSetProperty(_____________ownerChildElement, _____________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                            public String parse(Element element) {
                                                                                                                                return element.getTextContent();
                                                                                                                            }

                                                                                                                        }
                                                                                                                        );
                                                                                                                        parseListAndSetProperty(_____________ownerChildElement, _____________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                            public String parse(Element element) {
                                                                                                                                return element.getTextContent();
                                                                                                                            }

                                                                                                                        }
                                                                                                                        );
                                                                                                                        parseListAndSetProperty(_____________ownerChildElement, _____________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                                                            public BeanDefinition parse(Element element) {
                                                                                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                                                                                parseProperty(builder, element, "className", "className");
                                                                                                                                parseProperty(builder, element, "id", "id");
                                                                                                                                if (hasAttribute(element, "parent-ref")) {
                                                                                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                                                                                    } else {
                                                                                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                                                                                    BeanDefinitionBuilder _______________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                                    Element _______________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                                    if (_______________ownerChildElement!= null) {
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "className", "className");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "id", "id");
                                                                                                                                        if (hasAttribute(_______________ownerChildElement, "avatar-ref")) {
                                                                                                                                            if (_______________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                                _______________ownerBuilder.addPropertyValue("avatar", _______________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                                            } else {
                                                                                                                                                _______________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _______________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "username", "username");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "firstName", "firstName");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "lastName", "lastName");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "email", "email");
                                                                                                                                        if (!parseObjectRef(_______________ownerChildElement, _______________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                                            BeanDefinitionBuilder ________________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                                            Element ________________emailPreferencesChildElement = DomUtils.getChildElementByTagName(_______________ownerChildElement, "email-preferences");
                                                                                                                                            if (________________emailPreferencesChildElement!= null) {
                                                                                                                                                parseProperty(________________emailPreferencesBuilder, ________________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                                if (hasAttribute(________________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                                    if (________________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                                        ________________emailPreferencesBuilder.addPropertyValue("categories", ________________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                                    } else {
                                                                                                                                                        ________________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ________________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                _______________ownerBuilder.addPropertyValue("emailPreferences", ________________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "reputation", "reputation");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "stateId", "stateId");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "stateName", "stateName");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "storNotification", "storNotification");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "backend", "backend");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "fullName", "fullName");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "locale", "locale");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                        parseListAndSetProperty(_______________ownerChildElement, _______________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                                            public String parse(Element element) {
                                                                                                                                                return element.getTextContent();
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                        );
                                                                                                                                        parseListAndSetProperty(_______________ownerChildElement, _______________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                                            public String parse(Element element) {
                                                                                                                                                return element.getTextContent();
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                        );
                                                                                                                                        parseListAndSetProperty(_______________ownerChildElement, _______________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                                                                            public BeanDefinition parse(Element element) {
                                                                                                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                                                                                                parseProperty(builder, element, "className", "className");
                                                                                                                                                parseProperty(builder, element, "id", "id");
                                                                                                                                                if (hasAttribute(element, "parent-ref")) {
                                                                                                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                                                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                                                                                                    } else {
                                                                                                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                                                                                                    BeanDefinitionBuilder _________________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                                                    Element _________________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                                                    if (_________________ownerChildElement!= null) {
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "className", "className");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "id", "id");
                                                                                                                                                        if (hasAttribute(_________________ownerChildElement, "avatar-ref")) {
                                                                                                                                                            if (_________________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                                                _________________ownerBuilder.addPropertyValue("avatar", _________________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                                                            } else {
                                                                                                                                                                _________________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ _________________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "username", "username");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "firstName", "firstName");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "lastName", "lastName");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "email", "email");
                                                                                                                                                        if (!parseObjectRef(_________________ownerChildElement, _________________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                                                            BeanDefinitionBuilder __________________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                                                            Element __________________emailPreferencesChildElement = DomUtils.getChildElementByTagName(_________________ownerChildElement, "email-preferences");
                                                                                                                                                            if (__________________emailPreferencesChildElement!= null) {
                                                                                                                                                                parseProperty(__________________emailPreferencesBuilder, __________________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                                                if (hasAttribute(__________________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                                                    if (__________________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                                                        __________________emailPreferencesBuilder.addPropertyValue("categories", __________________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                                                    } else {
                                                                                                                                                                        __________________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ __________________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                _________________ownerBuilder.addPropertyValue("emailPreferences", __________________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "reputation", "reputation");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "stateId", "stateId");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "stateName", "stateName");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "storNotification", "storNotification");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "backend", "backend");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "fullName", "fullName");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "locale", "locale");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                        parseListAndSetProperty(_________________ownerChildElement, _________________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                return element.getTextContent();
                                                                                                                                                            }

                                                                                                                                                        }
                                                                                                                                                        );
                                                                                                                                                        parseListAndSetProperty(_________________ownerChildElement, _________________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                return element.getTextContent();
                                                                                                                                                            }

                                                                                                                                                        }
                                                                                                                                                        );
                                                                                                                                                        parseListAndSetProperty(_________________ownerChildElement, _________________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                                                                                            public BeanDefinition parse(Element element) {
                                                                                                                                                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class);
                                                                                                                                                                parseProperty(builder, element, "className", "className");
                                                                                                                                                                parseProperty(builder, element, "id", "id");
                                                                                                                                                                if (hasAttribute(element, "parent-ref")) {
                                                                                                                                                                    if (element.getAttribute("parent-ref").startsWith("#")) {
                                                                                                                                                                        builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                                                                                                                                                                    } else {
                                                                                                                                                                        builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                if (!parseObjectRef(element, builder, "owner", "owner")) {
                                                                                                                                                                    BeanDefinitionBuilder ___________________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                                                                    Element ___________________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                                                                    if (___________________ownerChildElement!= null) {
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "className", "className");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "id", "id");
                                                                                                                                                                        if (hasAttribute(___________________ownerChildElement, "avatar-ref")) {
                                                                                                                                                                            if (___________________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                                                                ___________________ownerBuilder.addPropertyValue("avatar", ___________________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                                                                            } else {
                                                                                                                                                                                ___________________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ___________________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "username", "username");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "firstName", "firstName");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "lastName", "lastName");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "email", "email");
                                                                                                                                                                        if (!parseObjectRef(___________________ownerChildElement, ___________________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                                                                            BeanDefinitionBuilder ____________________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                                                                            Element ____________________emailPreferencesChildElement = DomUtils.getChildElementByTagName(___________________ownerChildElement, "email-preferences");
                                                                                                                                                                            if (____________________emailPreferencesChildElement!= null) {
                                                                                                                                                                                parseProperty(____________________emailPreferencesBuilder, ____________________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                                                                if (hasAttribute(____________________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                                                                    if (____________________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                                                                        ____________________emailPreferencesBuilder.addPropertyValue("categories", ____________________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                                                                    } else {
                                                                                                                                                                                        ____________________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ____________________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                                ___________________ownerBuilder.addPropertyValue("emailPreferences", ____________________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "reputation", "reputation");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "stateId", "stateId");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "stateName", "stateName");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "storNotification", "storNotification");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "backend", "backend");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "fullName", "fullName");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "locale", "locale");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                                        parseListAndSetProperty(___________________ownerChildElement, ___________________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                                return element.getTextContent();
                                                                                                                                                                            }

                                                                                                                                                                        }
                                                                                                                                                                        );
                                                                                                                                                                        parseListAndSetProperty(___________________ownerChildElement, ___________________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                                return element.getTextContent();
                                                                                                                                                                            }

                                                                                                                                                                        }
                                                                                                                                                                        );
                                                                                                                                                                        parseListAndSetProperty(___________________ownerChildElement, ___________________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                                                                                                            public BeanDefinition parse(Element element) {
                                                                                                                                                                                throw new RuntimeException("Cannot parse this many nested elements");
                                                                                                                                                                            }

                                                                                                                                                                        }
                                                                                                                                                                        );
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                                                                        parseProperty(___________________ownerBuilder, ___________________ownerChildElement, "token", "token");
                                                                                                                                                                        builder.addPropertyValue("owner", ___________________ownerBuilder.getBeanDefinition());
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                parseProperty(builder, element, "slug", "slug");
                                                                                                                                                                parseProperty(builder, element, "title", "title");
                                                                                                                                                                parseProperty(builder, element, "description", "description");
                                                                                                                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                                                                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                                                                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                                                                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                                                                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                                                                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                                                                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                                                                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                                                                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                                                                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                                                                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                                                                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                                                                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                                                                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                                                                                                                parseProperty(builder, element, "reward", "reward");
                                                                                                                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                                                                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                                                                                                                    public String parse(Element element) {
                                                                                                                                                                        return element.getTextContent();
                                                                                                                                                                    }

                                                                                                                                                                }
                                                                                                                                                                );
                                                                                                                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                                                                                                                    BeanDefinitionBuilder ___________________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                                                                    Element ___________________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                                                                    if (___________________ideasChildElement!= null) {
                                                                                                                                                                        parseProperty(___________________ideasBuilder, ___________________ideasChildElement, "count", "count");
                                                                                                                                                                        parseProperty(___________________ideasBuilder, ___________________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                                                                        builder.addPropertyValue("ideas", ___________________ideasBuilder.getBeanDefinition());
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                                                                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                                                                                                                    public BeanDefinition parse(Element element) {
                                                                                                                                                                        throw new RuntimeException("Cannot parse this many nested elements");
                                                                                                                                                                    }

                                                                                                                                                                }
                                                                                                                                                                );
                                                                                                                                                                return builder.getBeanDefinition();
                                                                                                                                                            }

                                                                                                                                                        }
                                                                                                                                                        );
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                                                        parseProperty(_________________ownerBuilder, _________________ownerChildElement, "token", "token");
                                                                                                                                                        builder.addPropertyValue("owner", _________________ownerBuilder.getBeanDefinition());
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                parseProperty(builder, element, "slug", "slug");
                                                                                                                                                parseProperty(builder, element, "title", "title");
                                                                                                                                                parseProperty(builder, element, "description", "description");
                                                                                                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                                                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                                                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                                                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                                                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                                                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                                                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                                                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                                                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                                                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                                                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                                                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                                                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                                                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                                                                                                parseProperty(builder, element, "reward", "reward");
                                                                                                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                                                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                                                                                                    public String parse(Element element) {
                                                                                                                                                        return element.getTextContent();
                                                                                                                                                    }

                                                                                                                                                }
                                                                                                                                                );
                                                                                                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                                                                                                    BeanDefinitionBuilder _________________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                                                    Element _________________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                                                    if (_________________ideasChildElement!= null) {
                                                                                                                                                        parseProperty(_________________ideasBuilder, _________________ideasChildElement, "count", "count");
                                                                                                                                                        parseProperty(_________________ideasBuilder, _________________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                                                        builder.addPropertyValue("ideas", _________________ideasBuilder.getBeanDefinition());
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                                                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                                                                                                    public BeanDefinition parse(Element element) {
                                                                                                                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                                                                                                                        parseProperty(builder, element, "className", "className");
                                                                                                                                                        parseProperty(builder, element, "id", "id");
                                                                                                                                                        parseProperty(builder, element, "title", "title");
                                                                                                                                                        parseProperty(builder, element, "description", "description");
                                                                                                                                                        parseProperty(builder, element, "type", "type");
                                                                                                                                                        parseProperty(builder, element, "stateId", "stateId");
                                                                                                                                                        parseProperty(builder, element, "stateName", "stateName");
                                                                                                                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                                                                                                                        if (hasAttribute(element, "parameters-ref")) {
                                                                                                                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                                                                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                                                                                                                            } else {
                                                                                                                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                return element.getTextContent();
                                                                                                                                                            }

                                                                                                                                                        }
                                                                                                                                                        );
                                                                                                                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                return element.getTextContent();
                                                                                                                                                            }

                                                                                                                                                        }
                                                                                                                                                        );
                                                                                                                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                                                                                                                            public String parse(Element element) {
                                                                                                                                                                return element.getTextContent();
                                                                                                                                                            }

                                                                                                                                                        }
                                                                                                                                                        );
                                                                                                                                                        return builder.getBeanDefinition();
                                                                                                                                                    }

                                                                                                                                                }
                                                                                                                                                );
                                                                                                                                                return builder.getBeanDefinition();
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                        );
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                                        parseProperty(_______________ownerBuilder, _______________ownerChildElement, "token", "token");
                                                                                                                                        builder.addPropertyValue("owner", _______________ownerBuilder.getBeanDefinition());
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                parseProperty(builder, element, "slug", "slug");
                                                                                                                                parseProperty(builder, element, "title", "title");
                                                                                                                                parseProperty(builder, element, "description", "description");
                                                                                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                                                                                parseProperty(builder, element, "reward", "reward");
                                                                                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                                                                                    public String parse(Element element) {
                                                                                                                                        return element.getTextContent();
                                                                                                                                    }

                                                                                                                                }
                                                                                                                                );
                                                                                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                                                                                    BeanDefinitionBuilder _______________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                                    Element _______________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                                    if (_______________ideasChildElement!= null) {
                                                                                                                                        parseProperty(_______________ideasBuilder, _______________ideasChildElement, "count", "count");
                                                                                                                                        parseProperty(_______________ideasBuilder, _______________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                                        builder.addPropertyValue("ideas", _______________ideasBuilder.getBeanDefinition());
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                                                                                    public BeanDefinition parse(Element element) {
                                                                                                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                                                                                                        parseProperty(builder, element, "className", "className");
                                                                                                                                        parseProperty(builder, element, "id", "id");
                                                                                                                                        parseProperty(builder, element, "title", "title");
                                                                                                                                        parseProperty(builder, element, "description", "description");
                                                                                                                                        parseProperty(builder, element, "type", "type");
                                                                                                                                        parseProperty(builder, element, "stateId", "stateId");
                                                                                                                                        parseProperty(builder, element, "stateName", "stateName");
                                                                                                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                                                                                                        if (hasAttribute(element, "parameters-ref")) {
                                                                                                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                                                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                                                                                                            } else {
                                                                                                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                                                                                                            public String parse(Element element) {
                                                                                                                                                return element.getTextContent();
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                        );
                                                                                                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                                                                                                            public String parse(Element element) {
                                                                                                                                                return element.getTextContent();
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                        );
                                                                                                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                                                                                                            public String parse(Element element) {
                                                                                                                                                return element.getTextContent();
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                        );
                                                                                                                                        return builder.getBeanDefinition();
                                                                                                                                    }

                                                                                                                                }
                                                                                                                                );
                                                                                                                                return builder.getBeanDefinition();
                                                                                                                            }

                                                                                                                        }
                                                                                                                        );
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                        parseProperty(_____________ownerBuilder, _____________ownerChildElement, "token", "token");
                                                                                                                        builder.addPropertyValue("owner", _____________ownerBuilder.getBeanDefinition());
                                                                                                                    }
                                                                                                                }
                                                                                                                parseProperty(builder, element, "slug", "slug");
                                                                                                                parseProperty(builder, element, "title", "title");
                                                                                                                parseProperty(builder, element, "description", "description");
                                                                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                                                                parseProperty(builder, element, "reward", "reward");
                                                                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                                                                    public String parse(Element element) {
                                                                                                                        return element.getTextContent();
                                                                                                                    }

                                                                                                                }
                                                                                                                );
                                                                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                                                                    BeanDefinitionBuilder _____________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                    Element _____________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                    if (_____________ideasChildElement!= null) {
                                                                                                                        parseProperty(_____________ideasBuilder, _____________ideasChildElement, "count", "count");
                                                                                                                        parseProperty(_____________ideasBuilder, _____________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                        builder.addPropertyValue("ideas", _____________ideasBuilder.getBeanDefinition());
                                                                                                                    }
                                                                                                                }
                                                                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                                                                    public BeanDefinition parse(Element element) {
                                                                                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                                                                                        parseProperty(builder, element, "className", "className");
                                                                                                                        parseProperty(builder, element, "id", "id");
                                                                                                                        parseProperty(builder, element, "title", "title");
                                                                                                                        parseProperty(builder, element, "description", "description");
                                                                                                                        parseProperty(builder, element, "type", "type");
                                                                                                                        parseProperty(builder, element, "stateId", "stateId");
                                                                                                                        parseProperty(builder, element, "stateName", "stateName");
                                                                                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                                                                                        if (hasAttribute(element, "parameters-ref")) {
                                                                                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                                                                                            } else {
                                                                                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                                                                                            }
                                                                                                                        }
                                                                                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                                                                                            public String parse(Element element) {
                                                                                                                                return element.getTextContent();
                                                                                                                            }

                                                                                                                        }
                                                                                                                        );
                                                                                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                                                                                            public String parse(Element element) {
                                                                                                                                return element.getTextContent();
                                                                                                                            }

                                                                                                                        }
                                                                                                                        );
                                                                                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                                                                                            public String parse(Element element) {
                                                                                                                                return element.getTextContent();
                                                                                                                            }

                                                                                                                        }
                                                                                                                        );
                                                                                                                        return builder.getBeanDefinition();
                                                                                                                    }

                                                                                                                }
                                                                                                                );
                                                                                                                return builder.getBeanDefinition();
                                                                                                            }

                                                                                                        }
                                                                                                        );
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                        parseProperty(___________ownerBuilder, ___________ownerChildElement, "token", "token");
                                                                                                        builder.addPropertyValue("owner", ___________ownerBuilder.getBeanDefinition());
                                                                                                    }
                                                                                                }
                                                                                                parseProperty(builder, element, "slug", "slug");
                                                                                                parseProperty(builder, element, "title", "title");
                                                                                                parseProperty(builder, element, "description", "description");
                                                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                                                parseProperty(builder, element, "reward", "reward");
                                                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                                                    public String parse(Element element) {
                                                                                                        return element.getTextContent();
                                                                                                    }

                                                                                                }
                                                                                                );
                                                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                                                    BeanDefinitionBuilder ___________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                    Element ___________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                    if (___________ideasChildElement!= null) {
                                                                                                        parseProperty(___________ideasBuilder, ___________ideasChildElement, "count", "count");
                                                                                                        parseProperty(___________ideasBuilder, ___________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                        builder.addPropertyValue("ideas", ___________ideasBuilder.getBeanDefinition());
                                                                                                    }
                                                                                                }
                                                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                                                    public BeanDefinition parse(Element element) {
                                                                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                                                                        parseProperty(builder, element, "className", "className");
                                                                                                        parseProperty(builder, element, "id", "id");
                                                                                                        parseProperty(builder, element, "title", "title");
                                                                                                        parseProperty(builder, element, "description", "description");
                                                                                                        parseProperty(builder, element, "type", "type");
                                                                                                        parseProperty(builder, element, "stateId", "stateId");
                                                                                                        parseProperty(builder, element, "stateName", "stateName");
                                                                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                                                                        if (hasAttribute(element, "parameters-ref")) {
                                                                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                                                                            } else {
                                                                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                                                                            }
                                                                                                        }
                                                                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                                                                            public String parse(Element element) {
                                                                                                                return element.getTextContent();
                                                                                                            }

                                                                                                        }
                                                                                                        );
                                                                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                                                                            public String parse(Element element) {
                                                                                                                return element.getTextContent();
                                                                                                            }

                                                                                                        }
                                                                                                        );
                                                                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                                                                            public String parse(Element element) {
                                                                                                                return element.getTextContent();
                                                                                                            }

                                                                                                        }
                                                                                                        );
                                                                                                        return builder.getBeanDefinition();
                                                                                                    }

                                                                                                }
                                                                                                );
                                                                                                return builder.getBeanDefinition();
                                                                                            }

                                                                                        }
                                                                                        );
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                        parseProperty(_________ownerBuilder, _________ownerChildElement, "token", "token");
                                                                                        builder.addPropertyValue("owner", _________ownerBuilder.getBeanDefinition());
                                                                                    }
                                                                                }
                                                                                parseProperty(builder, element, "slug", "slug");
                                                                                parseProperty(builder, element, "title", "title");
                                                                                parseProperty(builder, element, "description", "description");
                                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                                parseProperty(builder, element, "reward", "reward");
                                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                                    public String parse(Element element) {
                                                                                        return element.getTextContent();
                                                                                    }

                                                                                }
                                                                                );
                                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                                    BeanDefinitionBuilder _________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                    Element _________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                    if (_________ideasChildElement!= null) {
                                                                                        parseProperty(_________ideasBuilder, _________ideasChildElement, "count", "count");
                                                                                        parseProperty(_________ideasBuilder, _________ideasChildElement, "collectionUri", "collectionUri");
                                                                                        builder.addPropertyValue("ideas", _________ideasBuilder.getBeanDefinition());
                                                                                    }
                                                                                }
                                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                                    public BeanDefinition parse(Element element) {
                                                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                                                        parseProperty(builder, element, "className", "className");
                                                                                        parseProperty(builder, element, "id", "id");
                                                                                        parseProperty(builder, element, "title", "title");
                                                                                        parseProperty(builder, element, "description", "description");
                                                                                        parseProperty(builder, element, "type", "type");
                                                                                        parseProperty(builder, element, "stateId", "stateId");
                                                                                        parseProperty(builder, element, "stateName", "stateName");
                                                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                                                        if (hasAttribute(element, "parameters-ref")) {
                                                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                                                            } else {
                                                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                                                            }
                                                                                        }
                                                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                                                            public String parse(Element element) {
                                                                                                return element.getTextContent();
                                                                                            }

                                                                                        }
                                                                                        );
                                                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                                                            public String parse(Element element) {
                                                                                                return element.getTextContent();
                                                                                            }

                                                                                        }
                                                                                        );
                                                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                                                            public String parse(Element element) {
                                                                                                return element.getTextContent();
                                                                                            }

                                                                                        }
                                                                                        );
                                                                                        return builder.getBeanDefinition();
                                                                                    }

                                                                                }
                                                                                );
                                                                                return builder.getBeanDefinition();
                                                                            }

                                                                        }
                                                                        );
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "isAnonymous", "isAnonymous");
                                                                        parseProperty(_______ownerBuilder, _______ownerChildElement, "token", "token");
                                                                        builder.addPropertyValue("owner", _______ownerBuilder.getBeanDefinition());
                                                                    }
                                                                }
                                                                parseProperty(builder, element, "slug", "slug");
                                                                parseProperty(builder, element, "title", "title");
                                                                parseProperty(builder, element, "description", "description");
                                                                parseProperty(builder, element, "stateId", "stateId");
                                                                parseProperty(builder, element, "stateName", "stateName");
                                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                                parseProperty(builder, element, "reward", "reward");
                                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                                    public String parse(Element element) {
                                                                        return element.getTextContent();
                                                                    }

                                                                }
                                                                );
                                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                                    BeanDefinitionBuilder _______ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                    Element _______ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                    if (_______ideasChildElement!= null) {
                                                                        parseProperty(_______ideasBuilder, _______ideasChildElement, "count", "count");
                                                                        parseProperty(_______ideasBuilder, _______ideasChildElement, "collectionUri", "collectionUri");
                                                                        builder.addPropertyValue("ideas", _______ideasBuilder.getBeanDefinition());
                                                                    }
                                                                }
                                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                                    public BeanDefinition parse(Element element) {
                                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                                        parseProperty(builder, element, "className", "className");
                                                                        parseProperty(builder, element, "id", "id");
                                                                        parseProperty(builder, element, "title", "title");
                                                                        parseProperty(builder, element, "description", "description");
                                                                        parseProperty(builder, element, "type", "type");
                                                                        parseProperty(builder, element, "stateId", "stateId");
                                                                        parseProperty(builder, element, "stateName", "stateName");
                                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                                        if (hasAttribute(element, "parameters-ref")) {
                                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                                            } else {
                                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                                            }
                                                                        }
                                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                                            public String parse(Element element) {
                                                                                return element.getTextContent();
                                                                            }

                                                                        }
                                                                        );
                                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                                            public String parse(Element element) {
                                                                                return element.getTextContent();
                                                                            }

                                                                        }
                                                                        );
                                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                                            public String parse(Element element) {
                                                                                return element.getTextContent();
                                                                            }

                                                                        }
                                                                        );
                                                                        return builder.getBeanDefinition();
                                                                    }

                                                                }
                                                                );
                                                                return builder.getBeanDefinition();
                                                            }

                                                        }
                                                        );
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "isAnonymous", "isAnonymous");
                                                        parseProperty(_____ownerBuilder, _____ownerChildElement, "token", "token");
                                                        builder.addPropertyValue("owner", _____ownerBuilder.getBeanDefinition());
                                                    }
                                                }
                                                parseProperty(builder, element, "slug", "slug");
                                                parseProperty(builder, element, "title", "title");
                                                parseProperty(builder, element, "description", "description");
                                                parseProperty(builder, element, "stateId", "stateId");
                                                parseProperty(builder, element, "stateName", "stateName");
                                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                parseProperty(builder, element, "isDefault", "isDefault");
                                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                                parseProperty(builder, element, "dateStart", "dateStart");
                                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                                parseProperty(builder, element, "dateClose", "dateClose");
                                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                                parseProperty(builder, element, "reward", "reward");
                                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                                    public String parse(Element element) {
                                                        return element.getTextContent();
                                                    }

                                                }
                                                );
                                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                                    BeanDefinitionBuilder _____ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                    Element _____ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                    if (_____ideasChildElement!= null) {
                                                        parseProperty(_____ideasBuilder, _____ideasChildElement, "count", "count");
                                                        parseProperty(_____ideasBuilder, _____ideasChildElement, "collectionUri", "collectionUri");
                                                        builder.addPropertyValue("ideas", _____ideasBuilder.getBeanDefinition());
                                                    }
                                                }
                                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                                parseProperty(builder, element, "voteMax", "voteMax");
                                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                                    public BeanDefinition parse(Element element) {
                                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                                        parseProperty(builder, element, "className", "className");
                                                        parseProperty(builder, element, "id", "id");
                                                        parseProperty(builder, element, "title", "title");
                                                        parseProperty(builder, element, "description", "description");
                                                        parseProperty(builder, element, "type", "type");
                                                        parseProperty(builder, element, "stateId", "stateId");
                                                        parseProperty(builder, element, "stateName", "stateName");
                                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                                        if (hasAttribute(element, "parameters-ref")) {
                                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                                            } else {
                                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                                            }
                                                        }
                                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                                            public String parse(Element element) {
                                                                return element.getTextContent();
                                                            }

                                                        }
                                                        );
                                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                                            public String parse(Element element) {
                                                                return element.getTextContent();
                                                            }

                                                        }
                                                        );
                                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                                            public String parse(Element element) {
                                                                return element.getTextContent();
                                                            }

                                                        }
                                                        );
                                                        return builder.getBeanDefinition();
                                                    }

                                                }
                                                );
                                                return builder.getBeanDefinition();
                                            }

                                        }
                                        );
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "isAnonymous", "isAnonymous");
                                        parseProperty(___ownerBuilder, ___ownerChildElement, "token", "token");
                                        builder.addPropertyValue("owner", ___ownerBuilder.getBeanDefinition());
                                    }
                                }
                                parseProperty(builder, element, "slug", "slug");
                                parseProperty(builder, element, "title", "title");
                                parseProperty(builder, element, "description", "description");
                                parseProperty(builder, element, "stateId", "stateId");
                                parseProperty(builder, element, "stateName", "stateName");
                                parseProperty(builder, element, "dateCreated", "dateCreated");
                                parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                parseProperty(builder, element, "isDefault", "isDefault");
                                parseProperty(builder, element, "submitIdeaRestriction", "submitIdeaRestriction");
                                parseProperty(builder, element, "dateStart", "dateStart");
                                parseProperty(builder, element, "dateStartLocalized", "dateStartLocalized");
                                parseProperty(builder, element, "dateEnd", "dateEnd");
                                parseProperty(builder, element, "dateEndLocalized", "dateEndLocalized");
                                parseProperty(builder, element, "dateClose", "dateClose");
                                parseProperty(builder, element, "dateCloseLocalized", "dateCloseLocalized");
                                parseProperty(builder, element, "notifyPhase", "notifyPhase");
                                parseProperty(builder, element, "notifyStart", "notifyStart");
                                parseProperty(builder, element, "notifyDaysLeft", "notifyDaysLeft");
                                parseProperty(builder, element, "notifyEnd", "notifyEnd");
                                parseProperty(builder, element, "reward", "reward");
                                parseProperty(builder, element, "fullyQualifiedTitle", "fullyQualifiedTitle");
                                parseListAndSetProperty(element, builder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                                    public String parse(Element element) {
                                        return element.getTextContent();
                                    }

                                }
                                );
                                if (!parseObjectRef(element, builder, "ideas", "ideas")) {
                                    BeanDefinitionBuilder ___ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                    Element ___ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                    if (___ideasChildElement!= null) {
                                        parseProperty(___ideasBuilder, ___ideasChildElement, "count", "count");
                                        parseProperty(___ideasBuilder, ___ideasChildElement, "collectionUri", "collectionUri");
                                        builder.addPropertyValue("ideas", ___ideasBuilder.getBeanDefinition());
                                    }
                                }
                                parseProperty(builder, element, "resourceUri", "resourceUri");
                                parseProperty(builder, element, "applicationUri", "applicationUri");
                                parseProperty(builder, element, "voteMax", "voteMax");
                                parseListAndSetProperty(element, builder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                                    public BeanDefinition parse(Element element) {
                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                                        parseProperty(builder, element, "className", "className");
                                        parseProperty(builder, element, "id", "id");
                                        parseProperty(builder, element, "title", "title");
                                        parseProperty(builder, element, "description", "description");
                                        parseProperty(builder, element, "type", "type");
                                        parseProperty(builder, element, "stateId", "stateId");
                                        parseProperty(builder, element, "stateName", "stateName");
                                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                                        if (hasAttribute(element, "parameters-ref")) {
                                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                                            } else {
                                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                                            }
                                        }
                                        parseProperty(builder, element, "dateCreated", "dateCreated");
                                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                                        parseProperty(builder, element, "resourceUri", "resourceUri");
                                        parseProperty(builder, element, "applicationUri", "applicationUri");
                                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                                            public String parse(Element element) {
                                                return element.getTextContent();
                                            }

                                        }
                                        );
                                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                                            public String parse(Element element) {
                                                return element.getTextContent();
                                            }

                                        }
                                        );
                                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                                            public String parse(Element element) {
                                                return element.getTextContent();
                                            }

                                        }
                                        );
                                        return builder.getBeanDefinition();
                                    }

                                }
                                );
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        parseProperty(_ownerBuilder, _ownerChildElement, "isAnonymous", "isAnonymous");
                        parseProperty(_ownerBuilder, _ownerChildElement, "token", "token");
                        categoryBuilder.addPropertyValue("owner", _ownerBuilder.getBeanDefinition());
                    }
                }
                parseProperty(categoryBuilder, categoryChildElement, "slug", "slug");
                parseProperty(categoryBuilder, categoryChildElement, "title", "title");
                parseProperty(categoryBuilder, categoryChildElement, "description", "description");
                parseProperty(categoryBuilder, categoryChildElement, "stateId", "stateId");
                parseProperty(categoryBuilder, categoryChildElement, "stateName", "stateName");
                parseProperty(categoryBuilder, categoryChildElement, "dateCreated", "dateCreated");
                parseProperty(categoryBuilder, categoryChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                parseProperty(categoryBuilder, categoryChildElement, "dateUpdated", "dateUpdated");
                parseProperty(categoryBuilder, categoryChildElement, "dateUpdatedLocalized", "dateUpdatedLocalized");
                parseProperty(categoryBuilder, categoryChildElement, "isDefault", "isDefault");
                parseProperty(categoryBuilder, categoryChildElement, "submitIdeaRestriction", "submitIdeaRestriction");
                parseProperty(categoryBuilder, categoryChildElement, "dateStart", "dateStart");
                parseProperty(categoryBuilder, categoryChildElement, "dateStartLocalized", "dateStartLocalized");
                parseProperty(categoryBuilder, categoryChildElement, "dateEnd", "dateEnd");
                parseProperty(categoryBuilder, categoryChildElement, "dateEndLocalized", "dateEndLocalized");
                parseProperty(categoryBuilder, categoryChildElement, "dateClose", "dateClose");
                parseProperty(categoryBuilder, categoryChildElement, "dateCloseLocalized", "dateCloseLocalized");
                parseProperty(categoryBuilder, categoryChildElement, "notifyPhase", "notifyPhase");
                parseProperty(categoryBuilder, categoryChildElement, "notifyStart", "notifyStart");
                parseProperty(categoryBuilder, categoryChildElement, "notifyDaysLeft", "notifyDaysLeft");
                parseProperty(categoryBuilder, categoryChildElement, "notifyEnd", "notifyEnd");
                parseProperty(categoryBuilder, categoryChildElement, "reward", "reward");
                parseProperty(categoryBuilder, categoryChildElement, "fullyQualifiedTitle", "fullyQualifiedTitle");
                parseListAndSetProperty(categoryChildElement, categoryBuilder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (!parseObjectRef(categoryChildElement, categoryBuilder, "ideas", "ideas")) {
                    BeanDefinitionBuilder _ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                    Element _ideasChildElement = DomUtils.getChildElementByTagName(categoryChildElement, "ideas");
                    if (_ideasChildElement!= null) {
                        parseProperty(_ideasBuilder, _ideasChildElement, "count", "count");
                        parseProperty(_ideasBuilder, _ideasChildElement, "collectionUri", "collectionUri");
                        categoryBuilder.addPropertyValue("ideas", _ideasBuilder.getBeanDefinition());
                    }
                }
                parseProperty(categoryBuilder, categoryChildElement, "resourceUri", "resourceUri");
                parseProperty(categoryBuilder, categoryChildElement, "applicationUri", "applicationUri");
                parseProperty(categoryBuilder, categoryChildElement, "voteMax", "voteMax");
                parseListAndSetProperty(categoryChildElement, categoryBuilder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingGroupExpressionHolder.class);
                        parseProperty(builder, element, "className", "className");
                        parseProperty(builder, element, "id", "id");
                        parseProperty(builder, element, "title", "title");
                        parseProperty(builder, element, "description", "description");
                        parseProperty(builder, element, "type", "type");
                        parseProperty(builder, element, "stateId", "stateId");
                        parseProperty(builder, element, "stateName", "stateName");
                        parseProperty(builder, element, "requiresLdap", "requiresLdap");
                        if (hasAttribute(element, "parameters-ref")) {
                            if (element.getAttribute("parameters-ref").startsWith("#")) {
                                builder.addPropertyValue("parameters", element.getAttribute("parameters-ref"));
                            } else {
                                builder.addPropertyValue("parameters", (("#[registry:"+ element.getAttribute("parameters-ref"))+"]"));
                            }
                        }
                        parseProperty(builder, element, "dateCreated", "dateCreated");
                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                        parseProperty(builder, element, "dateUpdated", "dateUpdated");
                        parseProperty(builder, element, "dateUpdatedLocalized", "dateUpdatedLocalized");
                        parseProperty(builder, element, "resourceUri", "resourceUri");
                        parseProperty(builder, element, "applicationUri", "applicationUri");
                        parseListAndSetProperty(element, builder, "members", "members", "member", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        parseListAndSetProperty(element, builder, "moderators", "moderators", "moderator", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        parseListAndSetProperty(element, builder, "categories", "categories", "category", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        return builder.getBeanDefinition();
                    }

                }
                );
                builder.addPropertyValue("category", categoryBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
