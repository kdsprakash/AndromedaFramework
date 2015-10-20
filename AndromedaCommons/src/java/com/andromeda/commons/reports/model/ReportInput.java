package com.andromeda.commons.reports.model;

import com.andromeda.commons.criteria.model.Criteria;
import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author prakash
 * @date 29-Aug-2015
 *
 */
public class ReportInput extends BaseModel
{
	private String url;
	private Criteria criteria;

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Criteria getCriteria()
	{
		return criteria;
	}

	public void setCriteria(Criteria criteria)
	{
		this.criteria = criteria;
	}
}
