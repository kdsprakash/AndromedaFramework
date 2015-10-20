package com.andromeda.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.security.model.Login;
import com.andromeda.commons.util.HttpUtils;
import com.andromeda.portal.model.Module;
import com.andromeda.portal.service.ModuleService;
import com.andromeda.security.service.LoginService;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
@RestController
public class LoginController
{
	@Autowired
	private LoginService loginService;

	@Autowired
	private ModuleService moduleService;

	@ResponseBody
	@RequestMapping(value = "/security/loggedin", method = { RequestMethod.POST })
	public Boolean isUserLoggedIn(@RequestBody Login login)
	{
		System.out.println("=====>login: " + login);
		Boolean status = loginService.isUserLoggedIn(login);
		return status;
	}

	@ResponseBody
	@RequestMapping(value = "/modules", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> getModules()
	{
		Map<String, Object> response = new HashMap<String, Object>();
		List<Module> modules = moduleService.getModules();
		System.out.println("=====>modules: " + modules);
		response.put("modules", modules);

		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/security/login", method = { RequestMethod.POST })
	public Response login(@RequestBody Login login, HttpServletRequest httpServletRequest)
	{
		System.out.println("=====>LoginController.login(): login: " + login);
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		login.setIpAddress(ipAddress);

		System.out.println("==========================================");
		System.out.println("ipAddress: " + ipAddress);
		System.out.println("==========================================");

		return loginService.login(login);
	}

	@ResponseBody
	@RequestMapping(value = "/security/logout", method = { RequestMethod.POST })
	public void logout(@RequestBody Login login)
	{
		String username = login.getUsername();
		if (username != null)
		{
			loginService.logout(username);
		}
	}

	// @RequestMapping(value = "changePwd", method = { RequestMethod.GET, RequestMethod.POST })
	// public Response changePwd(@RequestBody Map<String, String> params)
	// {
	// Response response = new Response();
	//
	// String viewName = "message";
	// String message = null;
	// String errorMessage = null;
	//
	// boolean status = loginService.isUserLoggedIn(userName, context);
	// if (status)
	// {
	// User credentials = new User();
	// credentials.setUserName(userName);
	// credentials.setPassword(password);
	// status = userService.changePassword(credentials, newPassword);
	// if (status)
	// {
	// message = "Password changed successfully";
	// }
	// else
	// {
	// errorMessage = "Could not change password";
	// }
	// }
	// else
	// {
	// errorMessage = "User not logged-in";
	// }
	//
	// model.addAttribute("message", message);
	// model.addAttribute("errorMessage", errorMessage);
	//
	// return viewName;
	// }
}
