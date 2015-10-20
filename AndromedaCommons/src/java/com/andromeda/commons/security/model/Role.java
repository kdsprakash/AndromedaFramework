package com.andromeda.commons.security.model;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class Role extends BaseModel
{
    private Integer id;

    private String name;

    private String description;

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
}
