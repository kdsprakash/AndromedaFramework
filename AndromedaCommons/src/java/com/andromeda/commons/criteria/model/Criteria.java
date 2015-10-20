package com.andromeda.commons.criteria.model;

import java.util.List;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author prakash
 * @date 29-Aug-2015
 *
 */
public class Criteria extends BaseModel
{
	private List<Criterion> criteria;

	public List<Criterion> getCriteria()
	{
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria)
	{
		this.criteria = criteria;
	}
}
