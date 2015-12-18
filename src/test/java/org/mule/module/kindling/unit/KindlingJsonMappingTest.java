/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.unit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Before;
import org.junit.Test;
import org.mule.module.kindling.model.KindlingCollection;
import org.mule.module.kindling.model.category.KindlingCategory;
import org.mule.module.kindling.model.category.KindlingCategoryStateName;
import org.mule.module.kindling.model.comment.KindlingComment;
import org.mule.module.kindling.model.group.KindlingGroup;
import org.mule.module.kindling.model.idea.KindlingIdea;
import org.mule.module.kindling.model.user.KindlingUser;

public class KindlingJsonMappingTest {
	
	private ObjectMapper jacksonMapper;
	
	@Before
	public void initialize() {
		jacksonMapper = new ObjectMapper();
	}
	
	
	@Test
	public void categoryDeserialization() throws JsonParseException, JsonMappingException, IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getJsonPathFor("category-collection.json"));
		
		JavaType type = jacksonMapper.getTypeFactory().constructParametricType(KindlingCollection.class, KindlingCategory.class);
		Class<?> c = type.getClass();
		
		KindlingCollection<KindlingCategory> kc = null;
		if (c.isInstance(JavaType.class)) {
			kc = jacksonMapper.readValue(is, (JavaType) type);
		} else {
			kc = jacksonMapper.readValue(is, type);
		}
		KindlingCategory kca = kc.getResults().get(0);
		
		Assert.assertNotNull(kc);
		Assert.assertNotNull(kca);
				
		Assert.assertTrue(kc.getResults().size() > 0);
		Assert.assertEquals(new Integer(2), kca.getId());
		Assert.assertEquals("Category", kca.getClassName());
		Assert.assertEquals(new Integer(1), kca.getStateId());		
		Assert.assertEquals(KindlingCategoryStateName.ACTIVATED, kca.getStateName());
		Assert.assertNotNull(kca.getDateCreated());
		Assert.assertEquals("January  4, 2013", kca.getDateCreatedLocalized());
	}
	
	@Test
	public void categorySerialization() throws JsonGenerationException, JsonMappingException, IOException {
		KindlingCategory kc = new KindlingCategory();
		
		Calendar c = Calendar.getInstance();
		c.set(2013, 0, 1, 1, 2, 3);
		
		kc.setClassName("Category");
		kc.setDateCreated(new Date());
		kc.setDateUpdated(new Date());
		kc.setDateCreatedLocalized("localizedDate");
		kc.setDateUpdatedLocalized("localizedDate");
		kc.setStateId(8);
		kc.setStateName(KindlingCategoryStateName.LOCKED);
		kc.setDateStart(c.getTime());
		kc.setDateEnd(c.getTime());
		
		String json = jacksonMapper.writeValueAsString(kc);
		
		Assert.assertNotNull(json);
		// The dates are only read values, must not be serialized
		Assert.assertFalse(checkExistenceOfName("dateCreated", json));
		Assert.assertFalse(checkExistenceOfName("dateCreatedLocalized", json));
		Assert.assertFalse(checkExistenceOfName("dateUpdated", json));
		Assert.assertFalse(checkExistenceOfName("dateUpdatedLocalized", json));
		Assert.assertTrue(checkExistenceOfValue("stateId", 8, json));
		Assert.assertTrue(checkExistenceOfValue("stateName", "Locked", json));
		Assert.assertTrue(checkExistenceOfName("dateStart", json));
		Assert.assertTrue(checkExistenceOfName("dateEnd", json));
	}
	
	@Test
	public void commentDeserialization() throws JsonParseException, JsonMappingException, IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getJsonPathFor("comment.json"));
		KindlingComment kc = jacksonMapper.readValue(is, KindlingComment.class);
		
		Assert.assertNotNull(kc);
	}
	
	@Test	
	public void commentSerialization() throws JsonGenerationException, JsonMappingException, IOException {
		KindlingComment kc = new KindlingComment();
		kc.setId(1);
		
		String json = jacksonMapper.writeValueAsString(kc);
		Assert.assertNotNull(checkExistenceOfValue("id", 1, json));
	}
	
	@Test
	public void groupSerialization() throws JsonParseException, JsonMappingException, IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getJsonPathFor("group.json"));
		KindlingGroup kg = jacksonMapper.readValue(is, KindlingGroup.class);
		
		Assert.assertNotNull(kg);
	}
	
	@Test
	public void groupDeserialization() throws JsonGenerationException, JsonMappingException, IOException {
		KindlingGroup kg = new KindlingGroup();
		kg.setId(1);
		
		String json = jacksonMapper.writeValueAsString(kg);
		Assert.assertNotNull(checkExistenceOfValue("id", 1, json));
	}
	
	@Test
	public void ideaSerialization() throws JsonParseException, JsonMappingException, IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getJsonPathFor("idea.json"));
		KindlingIdea kg = jacksonMapper.readValue(is, KindlingIdea.class);
		
		Assert.assertNotNull(kg);
	}
	
	@Test
	public void ideaDeserialization() throws JsonGenerationException, JsonMappingException, IOException {
		KindlingIdea kg = new KindlingIdea();
		kg.setId(1);
		
		String json = jacksonMapper.writeValueAsString(kg);
		Assert.assertNotNull(checkExistenceOfValue("id", 1, json));
	}
	
	@Test
	public void userSerialization() throws JsonGenerationException, JsonMappingException, IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getJsonPathFor("user.json"));
		KindlingUser kg = jacksonMapper.readValue(is, KindlingUser.class);
		
		Assert.assertNotNull(kg);
	}
	
	@Test
	public void userDeserialization() throws JsonGenerationException, JsonMappingException, IOException {
		KindlingUser kg = new KindlingUser();
		kg.setId(1);
		
		String json = jacksonMapper.writeValueAsString(kg);
		Assert.assertNotNull(checkExistenceOfValue("id", 1, json));
	}

	@Test
	public void postSerialization() throws JsonGenerationException, JsonMappingException, IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getJsonPathFor("post.json"));
		KindlingUser kg = jacksonMapper.readValue(is, KindlingUser.class);
		
		Assert.assertNotNull(kg);
	}
	
	@Test
	public void postsDeserialization() throws JsonGenerationException, JsonMappingException, IOException {
		KindlingCategory post = new KindlingCategory();
		post.setId(1);
		
		String json = jacksonMapper.writeValueAsString(post);
		Assert.assertNotNull(checkExistenceOfValue("id", 1, json));
	}
	
	private String getJsonPathFor(String jsonFile) {
		return String.format("json%s%s", File.separator, jsonFile);
	}
	
	private boolean checkExistenceOfName(String name, String json) {
		return json.contains(String.format("\"%s\"", name));
	}
	
	private boolean checkExistenceOfValue(String name, String value, String json) {
		return json.contains(String.format("\"%s\":\"%s\"", name, value));
	}
	
	private boolean checkExistenceOfValue(String name, int value, String json) {
		return json.contains(String.format("\"%s\":%d", name, value));
	}
}
