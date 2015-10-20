package com.andromeda.commons.util;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class Base64Utils
{
	/**
	 * 
	 * @param source
	 * @return
	 */
	public static String encode(byte[] source)
	{
		return Base64.encodeBase64String(source);
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static byte[] decode(String source)
	{
		return Base64.decodeBase64(source);
	}
}
