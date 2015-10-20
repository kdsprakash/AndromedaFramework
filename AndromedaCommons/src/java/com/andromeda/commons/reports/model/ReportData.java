package com.andromeda.commons.reports.model;

import java.util.List;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class ReportData extends BaseModel
{
	private Config config;
	private List<ReportHeader> reportHeaders;
	private List<BigNumber> bigNumbers;
	private List<ReportLink> reportLinks;
	private List<ColumnHeader> columnHeaders;
	private List<List<DataItem>> data;

	public Config getConfig()
	{
		return config;
	}

	public void setConfig(Config config)
	{
		this.config = config;
	}

	public List<ReportHeader> getReportHeaders()
	{
		return reportHeaders;
	}

	public void setReportHeaders(List<ReportHeader> reportHeaders)
	{
		this.reportHeaders = reportHeaders;
	}

	public List<BigNumber> getBigNumbers()
	{
		return bigNumbers;
	}

	public void setBigNumbers(List<BigNumber> bigNumbers)
	{
		this.bigNumbers = bigNumbers;
	}

	public List<ReportLink> getReportLinks()
	{
		return reportLinks;
	}

	public void setReportLinks(List<ReportLink> reportLinks)
	{
		this.reportLinks = reportLinks;
	}

	public List<ColumnHeader> getColumnHeaders()
	{
		return columnHeaders;
	}

	public void setColumnHeaders(List<ColumnHeader> columnHeaders)
	{
		this.columnHeaders = columnHeaders;
	}

	public List<List<DataItem>> getData()
	{
		return data;
	}

	public void setData(List<List<DataItem>> data)
	{
		this.data = data;
	}
}
