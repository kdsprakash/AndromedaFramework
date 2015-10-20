package com.andromeda.commons.security.model;

import java.sql.Timestamp;

import com.andromeda.commons.model.BaseModel;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class Login extends BaseModel
{
    private String username;

    private String password;

    private String context;

    private Timestamp logTime;

    private String ipAddress;

    private Boolean active;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public Timestamp getLogTime()
    {
        return logTime;
    }

    public void setLogTime(Timestamp logTime)
    {
        this.logTime = logTime;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
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
