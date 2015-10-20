package com.andromeda.security.controller;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
// @RestController
// @RequestMapping("/auth")
public class UserController
{
	// @Autowired
	// private LoginService loginService;
	//
	// @ResponseBody
	// @RequestMapping(value = "loggedin", method = { RequestMethod.POST })
	// public Boolean isUserLoggedIn(@RequestBody Login login)
	// {
	// System.out.println("=====>login: " + login);
	// Boolean status = loginService.isUserLoggedIn(login);
	// return status;
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "login", method = { RequestMethod.POST })
	// public Response login(@RequestBody User user, HttpServletRequest httpServletRequest)
	// {
	// System.out.println("==========================================");
	// System.out.println("ClientIP: 1: " + HttpUtils.getClientProxyAddress(httpServletRequest));
	// System.out.println("ClientIP: 2: " + HttpUtils.getClientAddress(httpServletRequest));
	// System.out.println("==========================================");
	// return loginService.login(user);
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "logout", method = { RequestMethod.POST })
	// public void logout(@RequestBody String userName)
	// {
	// loginService.logout(userName);
	// }

	//
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
