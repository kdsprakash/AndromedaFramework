package com.andromeda.commons.reports.util;

/**
 * 
 * @author Prakash K
 * @date 01-Sep-2015
 *
 */
public class ReportUtils
{
	public static String getStringValue(Integer value)
	{
		String result = "-";
		if (value != null)
		{
			result = value.toString();
		}

		return result;
	}
}
