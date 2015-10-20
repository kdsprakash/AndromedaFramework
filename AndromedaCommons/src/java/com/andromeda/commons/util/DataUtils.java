package com.andromeda.commons.util;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class DataUtils
{
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static int getInt(String str)
	{
		return getInt(str, 0);
	}

	/**
	 * 
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(String str, int defaultValue)
	{
		int result = defaultValue;

		try
		{
			result = Integer.parseInt(str);
		}
		catch (NumberFormatException e)
		{
			// Do nothing
		}

		return result;
	}
}
