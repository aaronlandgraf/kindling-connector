/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.kindling.serialization;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class KindlingDateUtils {
	
	static final public Pattern PATTERN_ISO8601_TO_RFC822 = Pattern.compile("([^\\+-]+)([\\+-]\\d{1,2}):(\\d{1,2})$");
	static final public SimpleDateFormat DATE_FORMAT_WITH_RFC822_TIME_ZONE = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	static final public SimpleDateFormat DATE_FORMAT_WITHOUT_TIME_ZONE = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
}
