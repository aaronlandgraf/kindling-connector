
package org.mule.module.kindling.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.kindling.model.category.holders.KindlingCategoryExpressionHolder;
import org.mule.module.kindling.model.category.holders.KindlingCategoryIdeaExpressionHolder;
import org.mule.module.kindling.model.group.holders.KindlingGroupExpressionHolder;
import org.mule.module.kindling.model.user.holders.KindlingUserEmailPreferencesExpressionHolder;
import org.mule.module.kindling.model.user.holders.KindlingUserExpressionHolder;
import org.mule.module.kindling.processors.CreateUserMessageProcessor;
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
public class CreateUserDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateUserDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateUserMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-user] within the connector [kindling] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-user] within the connector [kindling] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createUser");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-user] within the connector [kindling] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "user", "user")) {
            BeanDefinitionBuilder userBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
            Element userChildElement = DomUtils.getChildElementByTagName(element, "user");
            if (userChildElement!= null) {
                parseProperty(userBuilder, userChildElement, "className", "className");
                parseProperty(userBuilder, userChildElement, "id", "id");
                if (hasAttribute(userChildElement, "avatar-ref")) {
                    if (userChildElement.getAttribute("avatar-ref").startsWith("#")) {
                        userBuilder.addPropertyValue("avatar", userChildElement.getAttribute("avatar-ref"));
                    } else {
                        userBuilder.addPropertyValue("avatar", (("#[registry:"+ userChildElement.getAttribute("avatar-ref"))+"]"));
                    }
                }
                parseProperty(userBuilder, userChildElement, "username", "username");
                parseProperty(userBuilder, userChildElement, "firstName", "firstName");
                parseProperty(userBuilder, userChildElement, "lastName", "lastName");
                parseProperty(userBuilder, userChildElement, "email", "email");
                if (!parseObjectRef(userChildElement, userBuilder, "email-preferences", "emailPreferences")) {
                    BeanDefinitionBuilder _emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                    Element _emailPreferencesChildElement = DomUtils.getChildElementByTagName(userChildElement, "email-preferences");
                    if (_emailPreferencesChildElement!= null) {
                        parseProperty(_emailPreferencesBuilder, _emailPreferencesChildElement, "defaultValue", "defaultValue");
                        if (hasAttribute(_emailPreferencesChildElement, "categories-ref")) {
                            if (_emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                _emailPreferencesBuilder.addPropertyValue("categories", _emailPreferencesChildElement.getAttribute("categories-ref"));
                            } else {
                                _emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                            }
                        }
                        userBuilder.addPropertyValue("emailPreferences", _emailPreferencesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(userBuilder, userChildElement, "votesTotal", "votesTotal");
                parseProperty(userBuilder, userChildElement, "reputation", "reputation");
                parseProperty(userBuilder, userChildElement, "stateId", "stateId");
                parseProperty(userBuilder, userChildElement, "stateName", "stateName");
                parseProperty(userBuilder, userChildElement, "resetRequested", "resetRequested");
                parseProperty(userBuilder, userChildElement, "storNotification", "storNotification");
                parseProperty(userBuilder, userChildElement, "backend", "backend");
                parseProperty(userBuilder, userChildElement, "fullName", "fullName");
                parseProperty(userBuilder, userChildElement, "avatarUri", "avatarUri");
                parseProperty(userBuilder, userChildElement, "resourceUri", "resourceUri");
                parseProperty(userBuilder, userChildElement, "applicationUri", "applicationUri");
                parseProperty(userBuilder, userChildElement, "locale", "locale");
                parseProperty(userBuilder, userChildElement, "lastLogin", "lastLogin");
                parseProperty(userBuilder, userChildElement, "lastLoginLocalized", "lastLoginLocalized");
                parseProperty(userBuilder, userChildElement, "dateCreated", "dateCreated");
                parseProperty(userBuilder, userChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                parseListAndSetProperty(userChildElement, userBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(userChildElement, userBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(userChildElement, userBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                            BeanDefinitionBuilder __ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                            Element __ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                            if (__ownerChildElement!= null) {
                                parseProperty(__ownerBuilder, __ownerChildElement, "className", "className");
                                parseProperty(__ownerBuilder, __ownerChildElement, "id", "id");
                                if (hasAttribute(__ownerChildElement, "avatar-ref")) {
                                    if (__ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                        __ownerBuilder.addPropertyValue("avatar", __ownerChildElement.getAttribute("avatar-ref"));
                                    } else {
                                        __ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ __ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                    }
                                }
                                parseProperty(__ownerBuilder, __ownerChildElement, "username", "username");
                                parseProperty(__ownerBuilder, __ownerChildElement, "firstName", "firstName");
                                parseProperty(__ownerBuilder, __ownerChildElement, "lastName", "lastName");
                                parseProperty(__ownerBuilder, __ownerChildElement, "email", "email");
                                if (!parseObjectRef(__ownerChildElement, __ownerBuilder, "email-preferences", "emailPreferences")) {
                                    BeanDefinitionBuilder ___emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                    Element ___emailPreferencesChildElement = DomUtils.getChildElementByTagName(__ownerChildElement, "email-preferences");
                                    if (___emailPreferencesChildElement!= null) {
                                        parseProperty(___emailPreferencesBuilder, ___emailPreferencesChildElement, "defaultValue", "defaultValue");
                                        if (hasAttribute(___emailPreferencesChildElement, "categories-ref")) {
                                            if (___emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                ___emailPreferencesBuilder.addPropertyValue("categories", ___emailPreferencesChildElement.getAttribute("categories-ref"));
                                            } else {
                                                ___emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ___emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                            }
                                        }
                                        __ownerBuilder.addPropertyValue("emailPreferences", ___emailPreferencesBuilder.getBeanDefinition());
                                    }
                                }
                                parseProperty(__ownerBuilder, __ownerChildElement, "votesTotal", "votesTotal");
                                parseProperty(__ownerBuilder, __ownerChildElement, "reputation", "reputation");
                                parseProperty(__ownerBuilder, __ownerChildElement, "stateId", "stateId");
                                parseProperty(__ownerBuilder, __ownerChildElement, "stateName", "stateName");
                                parseProperty(__ownerBuilder, __ownerChildElement, "resetRequested", "resetRequested");
                                parseProperty(__ownerBuilder, __ownerChildElement, "storNotification", "storNotification");
                                parseProperty(__ownerBuilder, __ownerChildElement, "backend", "backend");
                                parseProperty(__ownerBuilder, __ownerChildElement, "fullName", "fullName");
                                parseProperty(__ownerBuilder, __ownerChildElement, "avatarUri", "avatarUri");
                                parseProperty(__ownerBuilder, __ownerChildElement, "resourceUri", "resourceUri");
                                parseProperty(__ownerBuilder, __ownerChildElement, "applicationUri", "applicationUri");
                                parseProperty(__ownerBuilder, __ownerChildElement, "locale", "locale");
                                parseProperty(__ownerBuilder, __ownerChildElement, "lastLogin", "lastLogin");
                                parseProperty(__ownerBuilder, __ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                parseProperty(__ownerBuilder, __ownerChildElement, "dateCreated", "dateCreated");
                                parseProperty(__ownerBuilder, __ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                parseListAndSetProperty(__ownerChildElement, __ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                    public String parse(Element element) {
                                        return element.getTextContent();
                                    }

                                }
                                );
                                parseListAndSetProperty(__ownerChildElement, __ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                    public String parse(Element element) {
                                        return element.getTextContent();
                                    }

                                }
                                );
                                parseListAndSetProperty(__ownerChildElement, __ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                            BeanDefinitionBuilder ____ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                            Element ____ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                            if (____ownerChildElement!= null) {
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "className", "className");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "id", "id");
                                                if (hasAttribute(____ownerChildElement, "avatar-ref")) {
                                                    if (____ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                        ____ownerBuilder.addPropertyValue("avatar", ____ownerChildElement.getAttribute("avatar-ref"));
                                                    } else {
                                                        ____ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ____ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                    }
                                                }
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "username", "username");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "firstName", "firstName");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "lastName", "lastName");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "email", "email");
                                                if (!parseObjectRef(____ownerChildElement, ____ownerBuilder, "email-preferences", "emailPreferences")) {
                                                    BeanDefinitionBuilder _____emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                    Element _____emailPreferencesChildElement = DomUtils.getChildElementByTagName(____ownerChildElement, "email-preferences");
                                                    if (_____emailPreferencesChildElement!= null) {
                                                        parseProperty(_____emailPreferencesBuilder, _____emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                        if (hasAttribute(_____emailPreferencesChildElement, "categories-ref")) {
                                                            if (_____emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                _____emailPreferencesBuilder.addPropertyValue("categories", _____emailPreferencesChildElement.getAttribute("categories-ref"));
                                                            } else {
                                                                _____emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _____emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                            }
                                                        }
                                                        ____ownerBuilder.addPropertyValue("emailPreferences", _____emailPreferencesBuilder.getBeanDefinition());
                                                    }
                                                }
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "votesTotal", "votesTotal");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "reputation", "reputation");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "stateId", "stateId");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "stateName", "stateName");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "resetRequested", "resetRequested");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "storNotification", "storNotification");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "backend", "backend");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "fullName", "fullName");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "avatarUri", "avatarUri");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "resourceUri", "resourceUri");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "applicationUri", "applicationUri");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "locale", "locale");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "lastLogin", "lastLogin");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "dateCreated", "dateCreated");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                parseListAndSetProperty(____ownerChildElement, ____ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                    public String parse(Element element) {
                                                        return element.getTextContent();
                                                    }

                                                }
                                                );
                                                parseListAndSetProperty(____ownerChildElement, ____ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                    public String parse(Element element) {
                                                        return element.getTextContent();
                                                    }

                                                }
                                                );
                                                parseListAndSetProperty(____ownerChildElement, ____ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                            BeanDefinitionBuilder ______ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                            Element ______ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                            if (______ownerChildElement!= null) {
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "className", "className");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "id", "id");
                                                                if (hasAttribute(______ownerChildElement, "avatar-ref")) {
                                                                    if (______ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                        ______ownerBuilder.addPropertyValue("avatar", ______ownerChildElement.getAttribute("avatar-ref"));
                                                                    } else {
                                                                        ______ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ______ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                    }
                                                                }
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "username", "username");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "firstName", "firstName");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "lastName", "lastName");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "email", "email");
                                                                if (!parseObjectRef(______ownerChildElement, ______ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                    BeanDefinitionBuilder _______emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                    Element _______emailPreferencesChildElement = DomUtils.getChildElementByTagName(______ownerChildElement, "email-preferences");
                                                                    if (_______emailPreferencesChildElement!= null) {
                                                                        parseProperty(_______emailPreferencesBuilder, _______emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                        if (hasAttribute(_______emailPreferencesChildElement, "categories-ref")) {
                                                                            if (_______emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                _______emailPreferencesBuilder.addPropertyValue("categories", _______emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                            } else {
                                                                                _______emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _______emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                            }
                                                                        }
                                                                        ______ownerBuilder.addPropertyValue("emailPreferences", _______emailPreferencesBuilder.getBeanDefinition());
                                                                    }
                                                                }
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "votesTotal", "votesTotal");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "reputation", "reputation");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "stateId", "stateId");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "stateName", "stateName");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "resetRequested", "resetRequested");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "storNotification", "storNotification");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "backend", "backend");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "fullName", "fullName");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "avatarUri", "avatarUri");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "resourceUri", "resourceUri");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "applicationUri", "applicationUri");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "locale", "locale");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "lastLogin", "lastLogin");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "dateCreated", "dateCreated");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                parseListAndSetProperty(______ownerChildElement, ______ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                    public String parse(Element element) {
                                                                        return element.getTextContent();
                                                                    }

                                                                }
                                                                );
                                                                parseListAndSetProperty(______ownerChildElement, ______ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                    public String parse(Element element) {
                                                                        return element.getTextContent();
                                                                    }

                                                                }
                                                                );
                                                                parseListAndSetProperty(______ownerChildElement, ______ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                                            BeanDefinitionBuilder ________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                            Element ________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                            if (________ownerChildElement!= null) {
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "className", "className");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "id", "id");
                                                                                if (hasAttribute(________ownerChildElement, "avatar-ref")) {
                                                                                    if (________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                        ________ownerBuilder.addPropertyValue("avatar", ________ownerChildElement.getAttribute("avatar-ref"));
                                                                                    } else {
                                                                                        ________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                    }
                                                                                }
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "username", "username");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "firstName", "firstName");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "lastName", "lastName");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "email", "email");
                                                                                if (!parseObjectRef(________ownerChildElement, ________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                    BeanDefinitionBuilder _________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                    Element _________emailPreferencesChildElement = DomUtils.getChildElementByTagName(________ownerChildElement, "email-preferences");
                                                                                    if (_________emailPreferencesChildElement!= null) {
                                                                                        parseProperty(_________emailPreferencesBuilder, _________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                        if (hasAttribute(_________emailPreferencesChildElement, "categories-ref")) {
                                                                                            if (_________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                _________emailPreferencesBuilder.addPropertyValue("categories", _________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                            } else {
                                                                                                _________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                            }
                                                                                        }
                                                                                        ________ownerBuilder.addPropertyValue("emailPreferences", _________emailPreferencesBuilder.getBeanDefinition());
                                                                                    }
                                                                                }
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "votesTotal", "votesTotal");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "reputation", "reputation");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "stateId", "stateId");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "stateName", "stateName");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "resetRequested", "resetRequested");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "storNotification", "storNotification");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "backend", "backend");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "fullName", "fullName");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "avatarUri", "avatarUri");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "resourceUri", "resourceUri");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "applicationUri", "applicationUri");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "locale", "locale");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "lastLogin", "lastLogin");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "dateCreated", "dateCreated");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                parseListAndSetProperty(________ownerChildElement, ________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                    public String parse(Element element) {
                                                                                        return element.getTextContent();
                                                                                    }

                                                                                }
                                                                                );
                                                                                parseListAndSetProperty(________ownerChildElement, ________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                    public String parse(Element element) {
                                                                                        return element.getTextContent();
                                                                                    }

                                                                                }
                                                                                );
                                                                                parseListAndSetProperty(________ownerChildElement, ________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                                                            BeanDefinitionBuilder __________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                            Element __________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                            if (__________ownerChildElement!= null) {
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "className", "className");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "id", "id");
                                                                                                if (hasAttribute(__________ownerChildElement, "avatar-ref")) {
                                                                                                    if (__________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                        __________ownerBuilder.addPropertyValue("avatar", __________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                    } else {
                                                                                                        __________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ __________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                    }
                                                                                                }
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "username", "username");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "firstName", "firstName");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "lastName", "lastName");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "email", "email");
                                                                                                if (!parseObjectRef(__________ownerChildElement, __________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                    BeanDefinitionBuilder ___________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                    Element ___________emailPreferencesChildElement = DomUtils.getChildElementByTagName(__________ownerChildElement, "email-preferences");
                                                                                                    if (___________emailPreferencesChildElement!= null) {
                                                                                                        parseProperty(___________emailPreferencesBuilder, ___________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                        if (hasAttribute(___________emailPreferencesChildElement, "categories-ref")) {
                                                                                                            if (___________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                ___________emailPreferencesBuilder.addPropertyValue("categories", ___________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                            } else {
                                                                                                                ___________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ___________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                            }
                                                                                                        }
                                                                                                        __________ownerBuilder.addPropertyValue("emailPreferences", ___________emailPreferencesBuilder.getBeanDefinition());
                                                                                                    }
                                                                                                }
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "reputation", "reputation");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "stateId", "stateId");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "stateName", "stateName");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "storNotification", "storNotification");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "backend", "backend");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "fullName", "fullName");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "locale", "locale");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                parseListAndSetProperty(__________ownerChildElement, __________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                    public String parse(Element element) {
                                                                                                        return element.getTextContent();
                                                                                                    }

                                                                                                }
                                                                                                );
                                                                                                parseListAndSetProperty(__________ownerChildElement, __________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                    public String parse(Element element) {
                                                                                                        return element.getTextContent();
                                                                                                    }

                                                                                                }
                                                                                                );
                                                                                                parseListAndSetProperty(__________ownerChildElement, __________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                                                                            BeanDefinitionBuilder ____________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                            Element ____________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                            if (____________ownerChildElement!= null) {
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "className", "className");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "id", "id");
                                                                                                                if (hasAttribute(____________ownerChildElement, "avatar-ref")) {
                                                                                                                    if (____________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                        ____________ownerBuilder.addPropertyValue("avatar", ____________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                    } else {
                                                                                                                        ____________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ____________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                    }
                                                                                                                }
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "username", "username");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "firstName", "firstName");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "lastName", "lastName");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "email", "email");
                                                                                                                if (!parseObjectRef(____________ownerChildElement, ____________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                    BeanDefinitionBuilder _____________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                    Element _____________emailPreferencesChildElement = DomUtils.getChildElementByTagName(____________ownerChildElement, "email-preferences");
                                                                                                                    if (_____________emailPreferencesChildElement!= null) {
                                                                                                                        parseProperty(_____________emailPreferencesBuilder, _____________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                        if (hasAttribute(_____________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                            if (_____________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                _____________emailPreferencesBuilder.addPropertyValue("categories", _____________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                            } else {
                                                                                                                                _____________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _____________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                            }
                                                                                                                        }
                                                                                                                        ____________ownerBuilder.addPropertyValue("emailPreferences", _____________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                    }
                                                                                                                }
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "reputation", "reputation");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "stateId", "stateId");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "stateName", "stateName");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "storNotification", "storNotification");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "backend", "backend");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "fullName", "fullName");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "locale", "locale");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                parseListAndSetProperty(____________ownerChildElement, ____________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                    public String parse(Element element) {
                                                                                                                        return element.getTextContent();
                                                                                                                    }

                                                                                                                }
                                                                                                                );
                                                                                                                parseListAndSetProperty(____________ownerChildElement, ____________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                    public String parse(Element element) {
                                                                                                                        return element.getTextContent();
                                                                                                                    }

                                                                                                                }
                                                                                                                );
                                                                                                                parseListAndSetProperty(____________ownerChildElement, ____________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                                                                                            BeanDefinitionBuilder ______________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                            Element ______________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                            if (______________ownerChildElement!= null) {
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "className", "className");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "id", "id");
                                                                                                                                if (hasAttribute(______________ownerChildElement, "avatar-ref")) {
                                                                                                                                    if (______________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                        ______________ownerBuilder.addPropertyValue("avatar", ______________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                                    } else {
                                                                                                                                        ______________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ______________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "username", "username");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "firstName", "firstName");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "lastName", "lastName");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "email", "email");
                                                                                                                                if (!parseObjectRef(______________ownerChildElement, ______________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                                    BeanDefinitionBuilder _______________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                                    Element _______________emailPreferencesChildElement = DomUtils.getChildElementByTagName(______________ownerChildElement, "email-preferences");
                                                                                                                                    if (_______________emailPreferencesChildElement!= null) {
                                                                                                                                        parseProperty(_______________emailPreferencesBuilder, _______________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                        if (hasAttribute(_______________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                            if (_______________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                                _______________emailPreferencesBuilder.addPropertyValue("categories", _______________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                            } else {
                                                                                                                                                _______________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _______________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        ______________ownerBuilder.addPropertyValue("emailPreferences", _______________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "reputation", "reputation");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "stateId", "stateId");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "stateName", "stateName");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "storNotification", "storNotification");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "backend", "backend");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "fullName", "fullName");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "locale", "locale");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                parseListAndSetProperty(______________ownerChildElement, ______________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                                    public String parse(Element element) {
                                                                                                                                        return element.getTextContent();
                                                                                                                                    }

                                                                                                                                }
                                                                                                                                );
                                                                                                                                parseListAndSetProperty(______________ownerChildElement, ______________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                                    public String parse(Element element) {
                                                                                                                                        return element.getTextContent();
                                                                                                                                    }

                                                                                                                                }
                                                                                                                                );
                                                                                                                                parseListAndSetProperty(______________ownerChildElement, ______________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                                                                                                            BeanDefinitionBuilder ________________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                                            Element ________________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                                            if (________________ownerChildElement!= null) {
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "className", "className");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "id", "id");
                                                                                                                                                if (hasAttribute(________________ownerChildElement, "avatar-ref")) {
                                                                                                                                                    if (________________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                                        ________________ownerBuilder.addPropertyValue("avatar", ________________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                                                    } else {
                                                                                                                                                        ________________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ ________________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "username", "username");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "firstName", "firstName");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "lastName", "lastName");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "email", "email");
                                                                                                                                                if (!parseObjectRef(________________ownerChildElement, ________________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                                                    BeanDefinitionBuilder _________________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                                                    Element _________________emailPreferencesChildElement = DomUtils.getChildElementByTagName(________________ownerChildElement, "email-preferences");
                                                                                                                                                    if (_________________emailPreferencesChildElement!= null) {
                                                                                                                                                        parseProperty(_________________emailPreferencesBuilder, _________________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                                        if (hasAttribute(_________________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                                            if (_________________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                                                _________________emailPreferencesBuilder.addPropertyValue("categories", _________________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                                            } else {
                                                                                                                                                                _________________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ _________________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        ________________ownerBuilder.addPropertyValue("emailPreferences", _________________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "reputation", "reputation");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "stateId", "stateId");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "stateName", "stateName");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "storNotification", "storNotification");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "backend", "backend");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "fullName", "fullName");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "locale", "locale");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                parseListAndSetProperty(________________ownerChildElement, ________________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                                                    public String parse(Element element) {
                                                                                                                                                        return element.getTextContent();
                                                                                                                                                    }

                                                                                                                                                }
                                                                                                                                                );
                                                                                                                                                parseListAndSetProperty(________________ownerChildElement, ________________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                                                    public String parse(Element element) {
                                                                                                                                                        return element.getTextContent();
                                                                                                                                                    }

                                                                                                                                                }
                                                                                                                                                );
                                                                                                                                                parseListAndSetProperty(________________ownerChildElement, ________________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


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
                                                                                                                                                            BeanDefinitionBuilder __________________ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                                                                                                                                                            Element __________________ownerChildElement = DomUtils.getChildElementByTagName(element, "owner");
                                                                                                                                                            if (__________________ownerChildElement!= null) {
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "className", "className");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "id", "id");
                                                                                                                                                                if (hasAttribute(__________________ownerChildElement, "avatar-ref")) {
                                                                                                                                                                    if (__________________ownerChildElement.getAttribute("avatar-ref").startsWith("#")) {
                                                                                                                                                                        __________________ownerBuilder.addPropertyValue("avatar", __________________ownerChildElement.getAttribute("avatar-ref"));
                                                                                                                                                                    } else {
                                                                                                                                                                        __________________ownerBuilder.addPropertyValue("avatar", (("#[registry:"+ __________________ownerChildElement.getAttribute("avatar-ref"))+"]"));
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "username", "username");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "firstName", "firstName");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "lastName", "lastName");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "email", "email");
                                                                                                                                                                if (!parseObjectRef(__________________ownerChildElement, __________________ownerBuilder, "email-preferences", "emailPreferences")) {
                                                                                                                                                                    BeanDefinitionBuilder ___________________emailPreferencesBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserEmailPreferencesExpressionHolder.class.getName());
                                                                                                                                                                    Element ___________________emailPreferencesChildElement = DomUtils.getChildElementByTagName(__________________ownerChildElement, "email-preferences");
                                                                                                                                                                    if (___________________emailPreferencesChildElement!= null) {
                                                                                                                                                                        parseProperty(___________________emailPreferencesBuilder, ___________________emailPreferencesChildElement, "defaultValue", "defaultValue");
                                                                                                                                                                        if (hasAttribute(___________________emailPreferencesChildElement, "categories-ref")) {
                                                                                                                                                                            if (___________________emailPreferencesChildElement.getAttribute("categories-ref").startsWith("#")) {
                                                                                                                                                                                ___________________emailPreferencesBuilder.addPropertyValue("categories", ___________________emailPreferencesChildElement.getAttribute("categories-ref"));
                                                                                                                                                                            } else {
                                                                                                                                                                                ___________________emailPreferencesBuilder.addPropertyValue("categories", (("#[registry:"+ ___________________emailPreferencesChildElement.getAttribute("categories-ref"))+"]"));
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        __________________ownerBuilder.addPropertyValue("emailPreferences", ___________________emailPreferencesBuilder.getBeanDefinition());
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "votesTotal", "votesTotal");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "reputation", "reputation");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "stateId", "stateId");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "stateName", "stateName");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "resetRequested", "resetRequested");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "storNotification", "storNotification");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "backend", "backend");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "fullName", "fullName");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "avatarUri", "avatarUri");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "resourceUri", "resourceUri");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "applicationUri", "applicationUri");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "locale", "locale");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "lastLogin", "lastLogin");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "lastLoginLocalized", "lastLoginLocalized");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "dateCreated", "dateCreated");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                                                                                                                                                                parseListAndSetProperty(__________________ownerChildElement, __________________ownerBuilder, "skills", "skills", "skill", new ParseDelegate<String>() {


                                                                                                                                                                    public String parse(Element element) {
                                                                                                                                                                        return element.getTextContent();
                                                                                                                                                                    }

                                                                                                                                                                }
                                                                                                                                                                );
                                                                                                                                                                parseListAndSetProperty(__________________ownerChildElement, __________________ownerBuilder, "interests", "interests", "interest", new ParseDelegate<String>() {


                                                                                                                                                                    public String parse(Element element) {
                                                                                                                                                                        return element.getTextContent();
                                                                                                                                                                    }

                                                                                                                                                                }
                                                                                                                                                                );
                                                                                                                                                                parseListAndSetProperty(__________________ownerChildElement, __________________ownerBuilder, "categories", "categories", "category", new ParseDelegate<BeanDefinition>() {


                                                                                                                                                                    public BeanDefinition parse(Element element) {
                                                                                                                                                                        throw new RuntimeException("Cannot parse this many nested elements");
                                                                                                                                                                    }

                                                                                                                                                                }
                                                                                                                                                                );
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                                                                parseProperty(__________________ownerBuilder, __________________ownerChildElement, "token", "token");
                                                                                                                                                                builder.addPropertyValue("owner", __________________ownerBuilder.getBeanDefinition());
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
                                                                                                                                                            BeanDefinitionBuilder __________________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                                                            Element __________________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                                                            if (__________________ideasChildElement!= null) {
                                                                                                                                                                parseProperty(__________________ideasBuilder, __________________ideasChildElement, "count", "count");
                                                                                                                                                                parseProperty(__________________ideasBuilder, __________________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                                                                builder.addPropertyValue("ideas", __________________ideasBuilder.getBeanDefinition());
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
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                                                parseProperty(________________ownerBuilder, ________________ownerChildElement, "token", "token");
                                                                                                                                                builder.addPropertyValue("owner", ________________ownerBuilder.getBeanDefinition());
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
                                                                                                                                            BeanDefinitionBuilder ________________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                                            Element ________________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                                            if (________________ideasChildElement!= null) {
                                                                                                                                                parseProperty(________________ideasBuilder, ________________ideasChildElement, "count", "count");
                                                                                                                                                parseProperty(________________ideasBuilder, ________________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                                                builder.addPropertyValue("ideas", ________________ideasBuilder.getBeanDefinition());
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
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                                parseProperty(______________ownerBuilder, ______________ownerChildElement, "token", "token");
                                                                                                                                builder.addPropertyValue("owner", ______________ownerBuilder.getBeanDefinition());
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
                                                                                                                            BeanDefinitionBuilder ______________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                                            Element ______________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                                            if (______________ideasChildElement!= null) {
                                                                                                                                parseProperty(______________ideasBuilder, ______________ideasChildElement, "count", "count");
                                                                                                                                parseProperty(______________ideasBuilder, ______________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                                builder.addPropertyValue("ideas", ______________ideasBuilder.getBeanDefinition());
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
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                                parseProperty(____________ownerBuilder, ____________ownerChildElement, "token", "token");
                                                                                                                builder.addPropertyValue("owner", ____________ownerBuilder.getBeanDefinition());
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
                                                                                                            BeanDefinitionBuilder ____________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                                            Element ____________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                                            if (____________ideasChildElement!= null) {
                                                                                                                parseProperty(____________ideasBuilder, ____________ideasChildElement, "count", "count");
                                                                                                                parseProperty(____________ideasBuilder, ____________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                                builder.addPropertyValue("ideas", ____________ideasBuilder.getBeanDefinition());
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
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                                parseProperty(__________ownerBuilder, __________ownerChildElement, "token", "token");
                                                                                                builder.addPropertyValue("owner", __________ownerBuilder.getBeanDefinition());
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
                                                                                            BeanDefinitionBuilder __________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                                            Element __________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                                            if (__________ideasChildElement!= null) {
                                                                                                parseProperty(__________ideasBuilder, __________ideasChildElement, "count", "count");
                                                                                                parseProperty(__________ideasBuilder, __________ideasChildElement, "collectionUri", "collectionUri");
                                                                                                builder.addPropertyValue("ideas", __________ideasBuilder.getBeanDefinition());
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
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "isAnonymous", "isAnonymous");
                                                                                parseProperty(________ownerBuilder, ________ownerChildElement, "token", "token");
                                                                                builder.addPropertyValue("owner", ________ownerBuilder.getBeanDefinition());
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
                                                                            BeanDefinitionBuilder ________ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                                            Element ________ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                                            if (________ideasChildElement!= null) {
                                                                                parseProperty(________ideasBuilder, ________ideasChildElement, "count", "count");
                                                                                parseProperty(________ideasBuilder, ________ideasChildElement, "collectionUri", "collectionUri");
                                                                                builder.addPropertyValue("ideas", ________ideasBuilder.getBeanDefinition());
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
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "isAnonymous", "isAnonymous");
                                                                parseProperty(______ownerBuilder, ______ownerChildElement, "token", "token");
                                                                builder.addPropertyValue("owner", ______ownerBuilder.getBeanDefinition());
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
                                                            BeanDefinitionBuilder ______ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                                            Element ______ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                                            if (______ideasChildElement!= null) {
                                                                parseProperty(______ideasBuilder, ______ideasChildElement, "count", "count");
                                                                parseProperty(______ideasBuilder, ______ideasChildElement, "collectionUri", "collectionUri");
                                                                builder.addPropertyValue("ideas", ______ideasBuilder.getBeanDefinition());
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
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "isAnonymous", "isAnonymous");
                                                parseProperty(____ownerBuilder, ____ownerChildElement, "token", "token");
                                                builder.addPropertyValue("owner", ____ownerBuilder.getBeanDefinition());
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
                                            BeanDefinitionBuilder ____ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                                            Element ____ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                                            if (____ideasChildElement!= null) {
                                                parseProperty(____ideasBuilder, ____ideasChildElement, "count", "count");
                                                parseProperty(____ideasBuilder, ____ideasChildElement, "collectionUri", "collectionUri");
                                                builder.addPropertyValue("ideas", ____ideasBuilder.getBeanDefinition());
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
                                parseProperty(__ownerBuilder, __ownerChildElement, "isAnonymous", "isAnonymous");
                                parseProperty(__ownerBuilder, __ownerChildElement, "token", "token");
                                builder.addPropertyValue("owner", __ownerBuilder.getBeanDefinition());
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
                            BeanDefinitionBuilder __ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                            Element __ideasChildElement = DomUtils.getChildElementByTagName(element, "ideas");
                            if (__ideasChildElement!= null) {
                                parseProperty(__ideasBuilder, __ideasChildElement, "count", "count");
                                parseProperty(__ideasBuilder, __ideasChildElement, "collectionUri", "collectionUri");
                                builder.addPropertyValue("ideas", __ideasBuilder.getBeanDefinition());
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
                parseProperty(userBuilder, userChildElement, "isAnonymous", "isAnonymous");
                parseProperty(userBuilder, userChildElement, "token", "token");
                builder.addPropertyValue("user", userBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
