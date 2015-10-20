package com.andromeda.commons.util;

/**
 * 
 * @author Prakash K
 * @date 08-Sep-2015
 *
 */
public class ObjectUtils
{
	/**
	 * 
	 * @param object
	 * @return
	 */
	public static Object clone(Object object)
	{
		return SerializationUtils.bytesToObject(SerializationUtils.objectToBytes(object));
	}
}
