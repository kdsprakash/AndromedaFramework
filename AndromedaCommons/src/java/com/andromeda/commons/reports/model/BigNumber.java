package com.andromeda.commons.reports.model;

import com.andromeda.commons.defs.ReportBigNumberType;
import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 04-Sep-2015
 *
 */
public class BigNumber extends BaseModel
{
	private String id;
	private String name;
	private String value;
	private String description;
	private Boolean active;
	private ReportBigNumberType type;

	public BigNumber(String id, String name, String value)
	{
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}

	public ReportBigNumberType getType()
	{
		return type;
	}

	public void setType(ReportBigNumberType type)
	{
		this.type = type;
	}
}
