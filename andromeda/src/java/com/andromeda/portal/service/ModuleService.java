package com.andromeda.portal.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.portal.dao.ModuleDAO;
import com.andromeda.portal.model.Module;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
@Service
public class ModuleService
{
	private static final Logger logger = LoggerFactory.getLogger(ModuleService.class);

	private static final long SESSION_TIMEOUT = TimeUnit.MINUTES.toMillis(30);

	@Autowired
	private ModuleDAO moduleDAO;

	public List<Module> getModules()
	{
		return moduleDAO.getAll();
	}
}
