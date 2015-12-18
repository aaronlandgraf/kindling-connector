/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.module.kindling.serialization;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class KindlingDateUtils {
	
	static final public Pattern PATTERN_ISO8601_TO_RFC822 = Pattern.compile("([^\\+-]+)([\\+-]\\d{1,2}):(\\d{1,2})$");
	static final public SimpleDateFormat DATE_FORMAT_WITH_RFC822_TIME_ZONE = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	static final public SimpleDateFormat DATE_FORMAT_WITHOUT_TIME_ZONE = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
}
