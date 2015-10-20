package com.andromeda.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.portal.model.Statistics;
import com.andromeda.portal.service.StatisticsService;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
@RestController
public class StatisticsController
{
	@Autowired
	private StatisticsService statisticsService;

	@ResponseBody
	@RequestMapping(value = "/statistics", method = { RequestMethod.GET, RequestMethod.POST })
	public Statistics getStatistics()
	{
		return statisticsService.getStatistics();
	}
}
