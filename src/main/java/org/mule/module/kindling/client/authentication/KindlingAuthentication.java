package org.mule.module.kindling.client.authentication;

import com.sun.jersey.api.client.Client;

public interface KindlingAuthentication {
	
	Client generateClientAndAuthenticate();
	String getUsername();
}
