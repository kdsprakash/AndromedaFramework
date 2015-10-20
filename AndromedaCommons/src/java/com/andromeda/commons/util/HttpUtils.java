package com.andromeda.commons.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class HttpUtils
{
	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	public static String getClientProxyAddress(HttpServletRequest httpServletRequest)
	{
		return httpServletRequest.getRemoteAddr();
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	public static String getClientAddress(HttpServletRequest httpServletRequest)
	{
		String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null)
		{
			ipAddress = httpServletRequest.getRemoteAddr();
		}

		return ipAddress;
	}
}
