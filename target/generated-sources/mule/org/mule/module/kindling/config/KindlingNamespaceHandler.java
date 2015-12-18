
package org.mule.module.kindling.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/kindling</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T02:51:31-03:00", comments = "Build UNNAMED.2405.44720b7")
public class KindlingNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(KindlingNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [kindling] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [kindling] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new KindlingConnectorKindlingConnectorConnectionManagementConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-groups", new RetrieveGroupsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-groups", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-group", new RetrieveGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-group", new UpdateGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-group", new CreateGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-comments", new RetrieveCommentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-comments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-comment", new CreateCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-comment", new RetrieveCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-comment", new DeleteCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-ideas", new RetrieveIdeasDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-ideas", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-idea", new CreateIdeaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-idea", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-idea", new RetrieveIdeaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-idea", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-idea", new UpdateIdeaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-idea", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-users", new RetrieveUsersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-users", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-user", new CreateUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-user", new RetrieveUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-user", new UpdateUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-user", new DeleteUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-posts", new RetrievePostsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-posts", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-post", new CreatePostDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-post", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-post", new RetrievePostDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-post", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-post", new UpdatePostDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-post", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-categories", new RetrieveCategoriesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-categories", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-category", new CreateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("retrieve-category", new RetrieveCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("retrieve-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-category", new UpdateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-category", "@Processor", ex);
        }
    }

}
