/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.mule.module.kindling.exception.KindlingConnectorException;
import org.mule.module.kindling.exception.KindlingConnectorUnauthorizedException;
import org.mule.module.kindling.model.KindlingCollection;
import org.mule.module.kindling.model.KindlingEntity;
import org.mule.module.kindling.types.KindlingWebResourceMethods;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class KindlingClientUtils {

	static final private ObjectMapper jacksonMapper = new ObjectMapper();
	
	/**
	 * Constructs a JavaType for kindling collections (KindlingCollection\<classType\>)
	 * 
	 * @param classType The type of the class contained in the collection. It must extend from {@link KindlingEntity}
	 * @return A JavaType representation for {@link KindlingCollection}\<classType\>
	 */
	static public JavaType constructKindlingCollectionType(Class<? extends KindlingEntity> classType) {
		return jacksonMapper.getTypeFactory().constructParametricType(KindlingCollection.class, classType);
	}
	
	/**
	 * Using ObjectMapper (Jackson) transform an Object to their respective JSON equivalent (String)
	 * 
	 * @param The object to be transformed
	 * @return The JSON representation of the object (String)
	 * @throws KindlingConnectorException If for some reason the transformation cannot be acomplished
	 */
	static public String transformObjectToJson(Object o) throws KindlingConnectorException {
		try {
			return jacksonMapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			throw new KindlingConnectorException("Cannot generate the Json from object", e);
		} catch (JsonMappingException e) {
			throw new KindlingConnectorException("Cannot map the Json from object", e);
		} catch (IOException e) {
			throw new KindlingConnectorException(e);
		}
	}
	
	static public <T> T webResourceCallWithJavaType(JavaType jtype, Class<T> type, WebResource wr, String loggedUser, String token, KindlingWebResourceMethods method) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		return webResourceCallWithJavaType(jtype, type, wr, loggedUser, token, method, null);
	}
	
	static public <T> T webResourceCallWithJavaType(JavaType jtype, Class<T> type, WebResource wr, String loggedUser, String token, KindlingWebResourceMethods method, String requestBody) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		
		String json = webResourceCall(wr, loggedUser, token,  method, null);
		InputStream is = new ByteArrayInputStream(json.getBytes());
		
		try {
			return jacksonMapper.readValue(is, jtype);
		} catch (JsonParseException e) {
			throw new KindlingConnectorException("ERROR - Error Parsing the JSON", e);
		} catch (JsonMappingException e) {
			throw new KindlingConnectorException("ERROR - Error Mapping the JSON", e);
		} catch (IOException e) {
			throw new KindlingConnectorException(e);
		}
	}
	
	static public <T> T webResourceCallWithClassType(Class<T> type, WebResource wr, String loggedUser, String token, KindlingWebResourceMethods method) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		return webResourceCallWithClassType(type, wr, loggedUser, token, method, null);
	}
	
	static public <T> T webResourceCallWithClassType(Class<T> type, WebResource wr, String loggedUser, String token,  KindlingWebResourceMethods method, String requestBody) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		
		String json = webResourceCall(wr, loggedUser, token, method, requestBody);
		InputStream is = new ByteArrayInputStream(json.getBytes());
		
		try {
			return jacksonMapper.readValue(is, type);
		} catch (JsonParseException e) {
			throw new KindlingConnectorException("ERROR - Error Parsing the JSON", e);
		} catch (JsonMappingException e) {
			throw new KindlingConnectorException("ERROR - Error Mapping the JSON", e);
		} catch (IOException e) {
			throw new KindlingConnectorException(e);
		}
	}
	
	/**
	 * Method used to eliminate boilerplate handling exceptions when calling get(String) | post(String) | ... from a WebResource
	 * 
	 * @param wr The WebResource to call get
	 * @param loggedUser The currently logged user
	 * @param method The method to use when requesting the resource to the service
	 * @return The response of the service in an JSON String format
	 * @throws KindlingConnectorUnauthorizedException If the service responded with a 401 means that the session has expired
	 * @throws KindlingConnectorException If is not a 401 it will throw this exception
	 */
	static public String webResourceCall(WebResource wr, String loggedUser, String token, KindlingWebResourceMethods method) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		return webResourceCall(wr, loggedUser, token, method, null);
	}
	
	/**
	 * Method used to eliminate boilerplate handling exceptions when calling get(String) | post(String) | ... from a WebResource
	 * 
	 * @param wr The WebResource to call get
	 * @param loggedUser The currently logged user
	 * @param method The method to use when requesting the resource to the service
	 * @param requestBody If the type is PUT or POST, it can contain data in the body (if the service request it that way)
	 * @return The response of the service in an JSON String format
	 * @throws KindlingConnectorUnauthorizedException If the service responded with a 401 means that the session has expired
	 * @throws KindlingConnectorException If is not a 401 it will throw this exception
	 */
	static public String webResourceCall(WebResource wr, String loggedUser, String token, KindlingWebResourceMethods method, String requestBody) 
			throws KindlingConnectorException, KindlingConnectorUnauthorizedException {
		try {
			return webResourceCallByEnumType(wr, method, requestBody);
		} catch (UniformInterfaceException e) {
			int statusCode = e.getResponse().getStatus();
			
			// The code 204 is returned as a successful operation with no response, 
			// but as the expected parameter is a String.class it throws a UniformInterfaceException.
			if (statusCode == 204) {
				return null;
			} else if (statusCode == 401) {
					throw new KindlingConnectorUnauthorizedException(loggedUser,token);
			} else {
				throw new KindlingConnectorException("ERROR - statusCode: " + statusCode, e);
			}
		} 
	}
	
    
	static private String webResourceCallByEnumType(WebResource wr, KindlingWebResourceMethods method, String requestBody) {
		if (KindlingWebResourceMethods.GET.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		} else if (KindlingWebResourceMethods.POST.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).post(String.class, requestBody);
		} else if (KindlingWebResourceMethods.PUT.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).put(String.class, requestBody);
		} else if (KindlingWebResourceMethods.DELETE.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
		} else {
			return null;
		}
	}
}
