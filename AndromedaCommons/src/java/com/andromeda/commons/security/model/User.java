package com.andromeda.commons.security.model;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author prakash
 * @date 29-Aug-2015
 *
 */
public class User extends BaseModel
{
	private Integer id;

	private String userName;

	private String name;

	private Boolean active;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Boolean getActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}
}
