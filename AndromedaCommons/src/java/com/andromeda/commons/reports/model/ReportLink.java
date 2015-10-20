package com.andromeda.commons.reports.model;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 13-Sep-2015
 *
 */
public class ReportLink extends BaseModel
{
	private String text;
	private String url;

	public ReportLink(String text, String url)
	{
		this.text = text;
		this.url = url;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
