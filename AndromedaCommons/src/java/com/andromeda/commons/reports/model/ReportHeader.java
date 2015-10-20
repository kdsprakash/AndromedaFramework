package com.andromeda.commons.reports.model;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 04-Sep-2015
 *
 */
public class ReportHeader extends BaseModel
{
	private String value;

	public ReportHeader(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}
