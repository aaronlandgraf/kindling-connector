
package org.mule.module.kindling.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.kindling.model.category.holders.KindlingCategoryExpressionHolder;
import org.mule.module.kindling.model.category.holders.KindlingCategoryIdeaExpressionHolder;
import org.mule.module.kindling.model.comment.holders.KindlingCommentExpressionHolder;
import org.mule.module.kindling.model.group.holders.KindlingGroupExpressionHolder;
import org.mule.module.kindling.model.post.holders.KindlingPostExpressionHolder;
import org.mule.module.kindling.model.user.holders.KindlingUserEmailPreferencesExpressionHolder;
import org.mule.module.kindling.model.user.holders.KindlingUserExpressionHolder;
import org.mule.module.kindling.processors.UpdatePostMessageProcessor;
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
public class UpdatePostDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdatePostDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdatePostMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-post] within the connector [kindling] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-post] within the connector [kindling] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updatePost");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-post] within the connector [kindling] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "postId", "postId");
        if (!parseObjectRef(element, builder, "post", "post")) {
            BeanDefinitionBuilder postBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingPostExpressionHolder.class.getName());
            Element postChildElement = DomUtils.getChildElementByTagName(element, "post");
            if (postChildElement!= null) {
                parseProperty(postBuilder, postChildElement, "className", "className");
                parseProperty(postBuilder, postChildElement, "id", "id");
                if (!parseObjectRef(postChildElement, postBuilder, "category", "category")) {
                    BeanDefinitionBuilder _categoryBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryExpressionHolder.class.getName());
                    Element _categoryChildElement = DomUtils.getChildElementByTagName(postChildElement, "category");
                    if (_categoryChildElement!= null) {
                        parseProperty(_categoryBuilder, _categoryChildElement, "className", "className");
                        parseProperty(_categoryBuilder, _categoryChildElement, "id", "id");
                        if (hasAttribute(_categoryChildElement, "parent-ref")) {
                            if (_categoryChildElement.getAttribute("parent-ref").startsWith("#")) {
                                _categoryBuilder.addPropertyValue("parent", _categoryChildElement.getAttribute("parent-ref"));
                            } else {
                                _categoryBuilder.addPropertyValue("parent", (("#[registry:"+ _categoryChildElement.getAttribute("parent-ref"))+"]"));
                            }
                        }
                        if (!parseObjectRef(_categoryChildElement, _categoryBuilder, "owner", "owner")) {
                            BeanDefinitionBuilder __ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                            Element __ownerChildElement = DomUtils.getChildElementByTagName(_categoryChildElement, "owner");
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
                                _categoryBuilder.addPropertyValue("owner", __ownerBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(_categoryBuilder, _categoryChildElement, "slug", "slug");
                        parseProperty(_categoryBuilder, _categoryChildElement, "title", "title");
                        parseProperty(_categoryBuilder, _categoryChildElement, "description", "description");
                        parseProperty(_categoryBuilder, _categoryChildElement, "stateId", "stateId");
                        parseProperty(_categoryBuilder, _categoryChildElement, "stateName", "stateName");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateCreated", "dateCreated");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateUpdated", "dateUpdated");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateUpdatedLocalized", "dateUpdatedLocalized");
                        parseProperty(_categoryBuilder, _categoryChildElement, "isDefault", "isDefault");
                        parseProperty(_categoryBuilder, _categoryChildElement, "submitIdeaRestriction", "submitIdeaRestriction");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateStart", "dateStart");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateStartLocalized", "dateStartLocalized");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateEnd", "dateEnd");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateEndLocalized", "dateEndLocalized");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateClose", "dateClose");
                        parseProperty(_categoryBuilder, _categoryChildElement, "dateCloseLocalized", "dateCloseLocalized");
                        parseProperty(_categoryBuilder, _categoryChildElement, "notifyPhase", "notifyPhase");
                        parseProperty(_categoryBuilder, _categoryChildElement, "notifyStart", "notifyStart");
                        parseProperty(_categoryBuilder, _categoryChildElement, "notifyDaysLeft", "notifyDaysLeft");
                        parseProperty(_categoryBuilder, _categoryChildElement, "notifyEnd", "notifyEnd");
                        parseProperty(_categoryBuilder, _categoryChildElement, "reward", "reward");
                        parseProperty(_categoryBuilder, _categoryChildElement, "fullyQualifiedTitle", "fullyQualifiedTitle");
                        parseListAndSetProperty(_categoryChildElement, _categoryBuilder, "hierarchy", "hierarchy", "hierarchy", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        if (!parseObjectRef(_categoryChildElement, _categoryBuilder, "ideas", "ideas")) {
                            BeanDefinitionBuilder __ideasBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCategoryIdeaExpressionHolder.class.getName());
                            Element __ideasChildElement = DomUtils.getChildElementByTagName(_categoryChildElement, "ideas");
                            if (__ideasChildElement!= null) {
                                parseProperty(__ideasBuilder, __ideasChildElement, "count", "count");
                                parseProperty(__ideasBuilder, __ideasChildElement, "collectionUri", "collectionUri");
                                _categoryBuilder.addPropertyValue("ideas", __ideasBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(_categoryBuilder, _categoryChildElement, "resourceUri", "resourceUri");
                        parseProperty(_categoryBuilder, _categoryChildElement, "applicationUri", "applicationUri");
                        parseProperty(_categoryBuilder, _categoryChildElement, "voteMax", "voteMax");
                        parseListAndSetProperty(_categoryChildElement, _categoryBuilder, "groups", "groups", "group", new ParseDelegate<BeanDefinition>() {


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
                        postBuilder.addPropertyValue("category", _categoryBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(postChildElement, postBuilder, "owner", "owner")) {
                    BeanDefinitionBuilder _ownerBuilder = BeanDefinitionBuilder.rootBeanDefinition(KindlingUserExpressionHolder.class.getName());
                    Element _ownerChildElement = DomUtils.getChildElementByTagName(postChildElement, "owner");
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
                        postBuilder.addPropertyValue("owner", _ownerBuilder.getBeanDefinition());
                    }
                }
                parseProperty(postBuilder, postChildElement, "title", "title");
                parseProperty(postBuilder, postChildElement, "description", "description");
                if (hasAttribute(postChildElement, "postImage-ref")) {
                    if (postChildElement.getAttribute("postImage-ref").startsWith("#")) {
                        postBuilder.addPropertyValue("postImage", postChildElement.getAttribute("postImage-ref"));
                    } else {
                        postBuilder.addPropertyValue("postImage", (("#[registry:"+ postChildElement.getAttribute("postImage-ref"))+"]"));
                    }
                }
                parseProperty(postBuilder, postChildElement, "dateCreated", "dateCreated");
                parseProperty(postBuilder, postChildElement, "dateCreatedLocalized", "dateCreatedLocalized");
                parseProperty(postBuilder, postChildElement, "dateUpdated", "dateUpdated");
                parseProperty(postBuilder, postChildElement, "dateUpdatedLocalized", "dateUpdatedLocalized");
                parseProperty(postBuilder, postChildElement, "datePublished", "datePublished");
                parseProperty(postBuilder, postChildElement, "datePublishedLocalized", "datePublishedLocalized");
                parseProperty(postBuilder, postChildElement, "stateId", "stateId");
                parseProperty(postBuilder, postChildElement, "stateName", "stateName");
                if (hasAttribute(postChildElement, "cachedTags-ref")) {
                    if (postChildElement.getAttribute("cachedTags-ref").startsWith("#")) {
                        postBuilder.addPropertyValue("cachedTags", postChildElement.getAttribute("cachedTags-ref"));
                    } else {
                        postBuilder.addPropertyValue("cachedTags", (("#[registry:"+ postChildElement.getAttribute("cachedTags-ref"))+"]"));
                    }
                }
                parseProperty(postBuilder, postChildElement, "lockedForComments", "lockedForComments");
                parseProperty(postBuilder, postChildElement, "resourceUri", "resourceUri");
                parseProperty(postBuilder, postChildElement, "applicationUri", "applicationUri");
                parseListAndSetProperty(postChildElement, postBuilder, "tags", "tags", "tag", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(postChildElement, postBuilder, "comments", "comments", "comment", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(KindlingCommentExpressionHolder.class);
                        parseProperty(builder, element, "className", "className");
                        parseProperty(builder, element, "id", "id");
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
                        parseProperty(builder, element, "parentType", "parentType");
                        if (hasAttribute(element, "parent-ref")) {
                            if (element.getAttribute("parent-ref").startsWith("#")) {
                                builder.addPropertyValue("parent", element.getAttribute("parent-ref"));
                            } else {
                                builder.addPropertyValue("parent", (("#[registry:"+ element.getAttribute("parent-ref"))+"]"));
                            }
                        }
                        if (hasAttribute(element, "matchOptionIndex-ref")) {
                            if (element.getAttribute("matchOptionIndex-ref").startsWith("#")) {
                                builder.addPropertyValue("matchOptionIndex", element.getAttribute("matchOptionIndex-ref"));
                            } else {
                                builder.addPropertyValue("matchOptionIndex", (("#[registry:"+ element.getAttribute("matchOptionIndex-ref"))+"]"));
                            }
                        }
                        parseProperty(builder, element, "type", "type");
                        parseProperty(builder, element, "description", "description");
                        parseProperty(builder, element, "dateCreated", "dateCreated");
                        parseProperty(builder, element, "dateCreatedLocalized", "dateCreatedLocalized");
                        parseProperty(builder, element, "stateId", "stateId");
                        parseProperty(builder, element, "stateName", "stateName");
                        parseProperty(builder, element, "resourceUri", "resourceUri");
                        parseListAndSetProperty(element, builder, "attachments", "attachments", "attachment", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        return builder.getBeanDefinition();
                    }

                }
                );
                builder.addPropertyValue("post", postBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
