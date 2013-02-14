/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.serialization;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class KindlingDateDeserializer extends JsonDeserializer<Date> {

	static final private Log logger = LogFactory.getLog(KindlingDateDeserializer.class);
		
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		String date = jp.getText();
            
    	try {
    		Matcher m = KindlingDateUtils.PATTERN_ISO8601_TO_RFC822.matcher(date);
    		// Remove the : (from +dd:dd to +dddd)
    		if (m.find()) {
    			date = m.replaceFirst("$1$2$3");
    		}    		
    		return KindlingDateUtils.DATE_FORMAT_WITH_RFC822_TIME_ZONE.parse(date);
    		
    	} catch (ParseException e2) {
    		try {        			
    			return KindlingDateUtils.DATE_FORMAT_WITHOUT_TIME_ZONE.parse(date);
    		} catch (ParseException e3) {
    			logger.error(String.format("Cannot parse date (%s) to any format", date));
                return null;
    		}        		
    	}
	}
}
