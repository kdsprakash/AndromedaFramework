package com.andromeda.commons.model;

import com.andromeda.commons.defs.Colors;

/**
 * 
 * @author Prakash K
 * @date 21-Nov-2015
 *
 */
public class BigNumber extends BaseModel
{
	private String id;
	private String value;
	private String title;
	private String description;
	private String percentage;
	private Colors color;
	private String url;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getPercentage()
	{
		return percentage;
	}

	public void setPercentage(String percentage)
	{
		this.percentage = percentage;
	}

	public Colors getColor()
	{
		return color;
	}

	public void setColor(Colors color)
	{
		this.color = color;
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
