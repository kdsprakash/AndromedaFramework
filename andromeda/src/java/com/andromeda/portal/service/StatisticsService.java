package com.andromeda.portal.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.andromeda.portal.model.MemoryStatistics;
import com.andromeda.portal.model.Statistics;

/**
 * 
 * @author Prakash K
 * @date 17-Oct-2015
 *
 */
@Service
public class StatisticsService
{
	private static final Logger logger = LoggerFactory.getLogger(StatisticsService.class);

	public Statistics getStatistics()
	{
		Timestamp logTime = new Timestamp(System.currentTimeMillis());
		Statistics statistics = new Statistics();
		statistics.setLogTime(logTime);
		statistics.setMemoryStatistics(getMemoryStatistics(logTime));

		return statistics;
	}

	private MemoryStatistics getMemoryStatistics(Timestamp logTime)
	{
		Runtime runtime = Runtime.getRuntime();
		long totalMemory = runtime.totalMemory();
		long maxMemory = runtime.maxMemory();
		long freeMemory = runtime.freeMemory();
		long usedMemory = totalMemory - freeMemory;

		MemoryStatistics memoryStatistics = new MemoryStatistics();
		memoryStatistics.setLogTime(logTime);
		memoryStatistics.setTotalMemory(totalMemory);
		memoryStatistics.setMaxMemory(maxMemory);
		memoryStatistics.setUsedMemory(usedMemory);
		memoryStatistics.setFreeMemory(freeMemory);
		memoryStatistics.setMemoryUsageString(String.format(
				"Java Heap: (total=%,d), (max=%,d), (used=%,d), (free=%,d)", totalMemory,
				maxMemory, usedMemory, freeMemory));

		return memoryStatistics;
	}
}
