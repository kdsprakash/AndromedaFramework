package com.andromeda.security.service;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.security.dao.LoginDAO;
import com.andromeda.commons.security.dao.UserDAO;
import com.andromeda.commons.security.model.Login;
import com.andromeda.commons.util.CryptoUtils;
import com.andromeda.commons.util.IDGenerator;
import com.andromeda.commons.util.ObjectUtils;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
@Service
public class LoginService
{
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	private static final long SESSION_TIMEOUT = TimeUnit.MINUTES.toMillis(30);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private LoginDAO loginDAO;

	public boolean isUserLoggedIn(Login login)
	{
		boolean status = false;

		if ((!StringUtils.isEmpty(login.getUsername()))
				&& (!StringUtils.isEmpty(login.getContext())))
		{
			Login result = loginDAO.getLoginByContext(login);
			if (result != null)
			{
				status = true;
			}
		}

		logger.info("isUserLoggedIn userName={}, context={}, status={}", login.getUsername(),
				login.getContext(), status);
		return status;
	}

	public Response login(Login login)
	{
		Timestamp logTime = new Timestamp(System.currentTimeMillis());

		Login loginClone = (Login) ObjectUtils.clone(login);
		loginClone.setPassword(null);

		Response response = new Response();
		response.setSuccessful(false);
		response.setResponseObject(login);

		if ((login != null) && (!StringUtils.isEmpty(login.getUsername()))
				&& (!StringUtils.isEmpty(login.getPassword())))
		{
			String passwordHash = CryptoUtils.getMD5Hash(login.getPassword());
			login.setPassword(passwordHash);
			boolean result = loginDAO.isValidUser(login);
			if (result)
			{
				login.setContext(IDGenerator.getUniqueID());
				login.setLogTime(logTime);

				loginDAO.addLoginLog(login);

				login.setPassword(null);
				response.setSuccessful(true);
				response.setResponseObject(login);
			}
			else
			{
				response.setErrorMessage("Invalid credentials");
			}

			System.out.println("=====>Login: " + login);
		}
		else
		{
			response.setErrorMessage("Invalid parameters passed");
		}

		return response;
	}

	public void logout(String username)
	{
		loginDAO.deleteLoginLog(username);
	}
}
