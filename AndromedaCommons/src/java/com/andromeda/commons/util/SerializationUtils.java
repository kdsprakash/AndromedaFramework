package com.andromeda.commons.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class SerializationUtils
{
	/**
	 * 
	 * @param object
	 * @return
	 */
	public static byte[] objectToBytes(Object object)
	{
		byte[] result = null;

		try
		{
			// Serialize to a byte array
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutput out = new ObjectOutputStream(bos);
			out.writeObject(object);
			out.close();

			// Get the bytes of the serialized object
			result = bos.toByteArray();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object bytesToObject(byte bytes[])
	{
		Object result = null;

		try
		{
			// Deserialize from a byte array
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
			result = in.readObject();
			in.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}

		return result;
	}
}
