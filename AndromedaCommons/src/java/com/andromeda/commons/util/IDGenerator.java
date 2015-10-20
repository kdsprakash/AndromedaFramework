/*
 * Created on May 29, 2006
 */
package com.andromeda.commons.util;

import java.rmi.server.UID;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class IDGenerator
{
	/**
	 * 
	 * @return
	 */
	public static String getUniqueID()
	{
		UID uid = new UID();
		StringBuffer buf = new StringBuffer();
		buf.append(uid.toString());
		return (buf.toString());
	}
}
