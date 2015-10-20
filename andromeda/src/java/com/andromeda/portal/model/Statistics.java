package com.andromeda.portal.model;

import java.sql.Timestamp;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 17-Oct-2015
 *
 */
public class Statistics extends BaseModel
{
	private Timestamp logTime;
	private MemoryStatistics memoryStatistics;

	public Timestamp getLogTime()
	{
		return logTime;
	}

	public void setLogTime(Timestamp logTime)
	{
		this.logTime = logTime;
	}

	public MemoryStatistics getMemoryStatistics()
	{
		return memoryStatistics;
	}

	public void setMemoryStatistics(MemoryStatistics memoryStatistics)
	{
		this.memoryStatistics = memoryStatistics;
	}
}
