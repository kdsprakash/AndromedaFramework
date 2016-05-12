package com.andromeda.commons.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.Base64;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.andromeda.commons.model.Login;
import com.andromeda.commons.model.System;

/**
 * 
 * @author Prakash K
 * @date 09-Dec-2015
 *
 */
public class RestClient
{
	public static final int CONNECTION_TIMEOUT = 20000; // 20 seconds
	public static final int READ_TIMEOUT = 30000; // 30 seconds

	private RestTemplate restTemplate = null;

	public void init(final System system, final Login login, final String bearer)
	{
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory()
		{
			@Override
			protected void prepareConnection(HttpURLConnection connection, String httpMethod)
					throws IOException
			{
				super.prepareConnection(connection, httpMethod);
				String acceptHeaderValue = "application/json";
				connection.setRequestProperty("Accept", acceptHeaderValue);

				if (login != null)
				{
					String authorization = login.getUsername() + ":" + login.getPassword();
					String authorizationBase64 = Base64.encodeBytes(authorization.getBytes());
					connection.setRequestProperty("Authorization", "Basic " + authorizationBase64);
				}
				
				if(bearer != null)
				{
					connection.setRequestProperty("Authorization", "Bearer " + bearer);
				}

				connection.setConnectTimeout(CONNECTION_TIMEOUT);
				connection.setReadTimeout(READ_TIMEOUT);
			}
		};

		MediaType plainTextType = new MediaType("text", "plain");
		MediaType jsonType = new MediaType("application", "json");

		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(plainTextType);
		supportedMediaTypes.add(jsonType);

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
				new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(mappingJackson2HttpMessageConverter);

		restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
		restTemplate.setRequestFactory(requestFactory);
	}

	public <T> T get(String url, Class<T> responseType)
	{
		return restTemplate.getForObject(url, responseType);
	}

	public void post()
	{

	}

	public void delete(String url)
	{
		restTemplate.delete(url);
	}
}
