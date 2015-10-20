package com.andromeda.commons.criteria.model;

import com.andromeda.commons.defs.ReportColumnType;
import com.andromeda.commons.defs.SqlOperator;
import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author prakash
 * @date 29-Aug-2015
 *
 */
public class Criterion extends BaseModel
{
	private String columnName;
	private ReportColumnType type;
	private SqlOperator operator;
	private String value;

	public String getColumnName()
	{
		return columnName;
	}

	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	public ReportColumnType getType()
	{
		return type;
	}

	public void setType(ReportColumnType type)
	{
		this.type = type;
	}

	public SqlOperator getOperator()
	{
		return operator;
	}

	public void setOperator(SqlOperator operator)
	{
		this.operator = operator;
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
