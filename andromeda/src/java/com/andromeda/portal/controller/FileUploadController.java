package com.andromeda.portal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
@RestController
@RequestMapping("/file")
public class FileUploadController
{
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file)
	{
		String name = "test11";
		if (!file.isEmpty())
		{
			try
			{
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream =
						new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
				stream.write(bytes);
				stream.close();
				return "You successfully uploaded " + name + " into " + name + "-uploaded !";
			}
			catch (Exception e)
			{
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		else
		{
			return "You failed to upload " + name + " because the file was empty.";
		}
	}
}
