/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
