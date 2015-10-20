package com.andromeda.commons.reports.model;

import com.andromeda.commons.model.BaseModel;

public class DataItem extends BaseModel
{
	private String url;
	private String value;

	public DataItem(String url, String value)
	{
		this.url = url;
		this.value = value;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
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
