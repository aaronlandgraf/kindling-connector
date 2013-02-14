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
import java.util.Date;
import java.util.regex.Matcher;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class KindlingDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		String date = KindlingDateUtils.DATE_FORMAT_WITH_RFC822_TIME_ZONE.format(value);
		Matcher m = KindlingDateUtils.PATTERN_ISO8601_TO_RFC822.matcher(date);

		if (m.find()) {
			date = m.replaceFirst("$1$2$3");
		}

		jgen.writeString(date);
	}

}
