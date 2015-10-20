package com.andromeda.portal.model;

import java.sql.Timestamp;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 17-Oct-2015
 *
 */
public class MemoryStatistics extends BaseModel
{
	private Timestamp logTime;
	private long totalMemory;
	private long maxMemory;
	private long usedMemory;
	private long freeMemory;
	private String memoryUsageString;

	public Timestamp getLogTime()
	{
		return logTime;
	}

	public void setLogTime(Timestamp logTime)
	{
		this.logTime = logTime;
	}

	public long getTotalMemory()
	{
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory)
	{
		this.totalMemory = totalMemory;
	}

	public long getMaxMemory()
	{
		return maxMemory;
	}

	public void setMaxMemory(long maxMemory)
	{
		this.maxMemory = maxMemory;
	}

	public long getUsedMemory()
	{
		return usedMemory;
	}

	public void setUsedMemory(long usedMemory)
	{
		this.usedMemory = usedMemory;
	}

	public long getFreeMemory()
	{
		return freeMemory;
	}

	public void setFreeMemory(long freeMemory)
	{
		this.freeMemory = freeMemory;
	}

	public String getMemoryUsageString()
	{
		return memoryUsageString;
	}

	public void setMemoryUsageString(String memoryUsageString)
	{
		this.memoryUsageString = memoryUsageString;
	}
}
