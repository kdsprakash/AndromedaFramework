package com.andromeda.commons.model;

import java.io.Serializable;

import com.andromeda.commons.util.JsonUtils;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class BaseModel implements Serializable
{
	@Override
	public String toString()
	{
		return JsonUtils.toString(this);
	}
}
