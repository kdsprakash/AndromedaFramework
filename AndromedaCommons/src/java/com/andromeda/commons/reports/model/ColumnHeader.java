package com.andromeda.commons.reports.model;

import com.andromeda.commons.defs.ReportColumnType;
import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class ColumnHeader extends BaseModel
{
	private String id;
	private String value;
	private String description;
	private ReportColumnType type;

	public ColumnHeader(String id, String value, String description, ReportColumnType type)
	{
		this.id = id;
		this.value = value;
		this.description = description;
		this.type = type;
	}

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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ReportColumnType getType()
	{
		return type;
	}

	public void setType(ReportColumnType type)
	{
		this.type = type;
	}
}
