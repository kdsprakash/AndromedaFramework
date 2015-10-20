package com.andromeda.commons.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class CryptoUtils
{

	/**
	 * 
	 * @param password
	 * @return
	 */
	public static String getMD5Hash(String password)
	{
		String passwordHash = null;

		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			passwordHash = Base64.encodeBase64URLSafeString(md.digest(password.getBytes()));
		}
		catch (NoSuchAlgorithmException e)
		{
			passwordHash = password;
		}

		return passwordHash;
	}
}
