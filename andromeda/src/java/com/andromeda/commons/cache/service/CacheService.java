package com.andromeda.commons.cache.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.andromeda.commons.cache.model.ServerCache;

/**
 * 
 * @author Prakash K
 * @date 27-Jan-2016
 *
 */
@Service
public class CacheService
{
	private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

	private Map<String, List<ServerCache>> cache;

	@PostConstruct
	public void init()
	{
		logger.info("creating server cache");
		cache = new HashMap<String, List<ServerCache>>();
	}

	@PreDestroy
	public void cleanUp() throws Exception
	{
		logger.info("cleaning server cache");
		cache = null;
	}

	public void add(String username, ServerCache serverCache)
	{
		if ((!StringUtils.isEmpty(username)) && (serverCache != null))
		{
			List<ServerCache> serverCaches = cache.get(username);
			if (serverCaches == null)
			{
				serverCaches = new ArrayList<ServerCache>();
				cache.put(username, serverCaches);
			}

			int location = -1;
			if ((!StringUtils.isEmpty(serverCache.getUsername()))
					&& (!StringUtils.isEmpty(serverCache.getModule()))
					&& (!StringUtils.isEmpty(serverCache.getKey())))
			{
				for (int i = 0; i < serverCaches.size(); i++)
				{
					if ((serverCache.getUsername().equals(serverCaches.get(i).getUsername()))
							&& (serverCache.getModule().equals(serverCaches.get(i).getModule()))
							&& (serverCache.getKey().equals(serverCaches.get(i).getKey())))
					{
						location = i;
						break;
					}
				}

				if (location >= 0)
				{
					serverCaches.remove(location);
				}

				serverCaches.add(serverCache);
			}
		}
	}

	public String get(String username, String module, String key)
	{
		String value = null;

		if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(module))
				&& (!StringUtils.isEmpty(key)))
		{
			List<ServerCache> serverCaches = cache.get(username);
			if (!CollectionUtils.isEmpty(serverCaches))
			{
				for (ServerCache serverCache : serverCaches)
				{
					if ((module.equals(serverCache.getModule()))
							&& (key.equals(serverCache.getKey())))
					{
						value = serverCache.getValue();
					}
				}
			}
		}

		return value;
	}

	public void remove(String username)
	{
		logger.info(String.format("removing server cache for user: %s", username));
		cache.remove(username);
	}
}
