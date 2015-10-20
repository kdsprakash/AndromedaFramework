package com.andromeda.portal.model;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 08-Sep-2015
 *
 */
public class Module extends BaseModel
{
	private Integer id;
	private String name;
	private String description;
	private String url;
	private String testUrl;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getTestUrl()
	{
		return testUrl;
	}

	public void setTestUrl(String testUrl)
	{
		this.testUrl = testUrl;
	}
}
