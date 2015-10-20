package com.andromeda.commons.security.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.andromeda.commons.dao.BaseDAO;
import com.andromeda.commons.security.model.Login;

/**
 * 
 * @author prakash
 * @date 29-Aug-2015
 *
 */
@Repository
public class LoginDAO extends BaseDAO
{
	private static final Logger logger = LoggerFactory.getLogger(LoginDAO.class);

	private static final String TABLE_NAME = "security.logins";

	private static final String LOG_TABLE_NAME = "security.login_log";

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void add(Login login)
	{
		super.add(login, TABLE_NAME, "Login.Add");
	}

	public void addLoginLog(Login login)
	{
		super.add(login, LOG_TABLE_NAME, "Login.AddLoginLog");
	}

	public boolean isValidUser(Login login)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", login);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Login> logins = sqlSession.selectList("Login.GetLoginByCredentials", params);
		sqlSession.close();

		boolean valid = false;
		if (!CollectionUtils.isEmpty(logins))
		{
			Login result = logins.get(0);
			if (result.getUsername().equals(login.getUsername()))
			{
				valid = true;
			}
		}

		return valid;
	}

	public Login getLoginByContext(Login login)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", login);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Login> logins = sqlSession.selectList("Login.GetLoginByContext", params);
		sqlSession.close();

		Login result = null;
		if (!CollectionUtils.isEmpty(logins))
		{
			result = logins.get(0);
		}

		return result;
	}

	public void deleteLoginLog(String username)
	{
		System.out.println("=====>LoginDAO.deleteLoginLog: CALLED");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("Login.DeleteLoginLog", username);
		sqlSession.close();
	}

	// public void addUserToRole(String userName, String roleName)
	// {
	// String sql = "INSERT INTO role_mappings (roleName, userName) VALUES (?, ?);";
	//
	// final Object[] args = new Object[2];
	// args[0] = roleName;
	// args[1] = userName;
	//
	// jdbcTemplate.update(sql, args);
	// logger.info("Role mapping added: {} - {}", roleName, userName);
	// }
	//
	// public List<Role> getUserRoles(String userName)
	// {
	// String sql = "SELECT * FROM user_roles WHERE userName='" + userName + "';";
	// return jdbcTemplate.query(sql, new RolesResultSetExtractor());
	// }
	//
	// public List<Service> getUserServices(String userName)
	// {
	// String sql = "SELECT * FROM services WHERE serviceName IN ( "
	// + "SELECT rs.serviceName FROM ( " + "SELECT * FROM user_roles WHERE userName = '"
	// + userName + "' ) ur "
	// + "INNER JOIN role_services rs ON ur.roleName = rs.roleName);";
	//
	// return jdbcTemplate.query(sql, new ServicesResultSetExtractor());
	// }
	//
	// private static final class LoginResultSetExtractor implements ResultSetExtractor<User>
	// {
	// public User extractData(final ResultSet rs) throws SQLException, DataAccessException
	// {
	// User login = null;
	//
	// if (rs.next())
	// {
	// login = new User();
	// login.setUserName(rs.getString(1));
	// login.setPassword(rs.getString(2));
	// login.setDepartmentId(rs.getString(3));
	// }
	//
	// return login;
	// }
	// }
	//
	// private static final class RolesResultSetExtractor implements ResultSetExtractor<List<Role>>
	// {
	// public List<Role> extractData(final ResultSet rs) throws SQLException, DataAccessException
	// {
	// List<Role> roles = new ArrayList<>();
	//
	// while (rs.next())
	// {
	// Role role = new Role();
	// role.setRoleName(rs.getString(1));
	// role.setDescription(rs.getString(2));
	//
	// roles.add(role);
	// }
	//
	// return roles;
	// }
	// }
	//
	// private static final class ServicesResultSetExtractor implements
	// ResultSetExtractor<List<Service>>
	// {
	// public List<Service> extractData(final ResultSet rs) throws SQLException,
	// DataAccessException
	// {
	// List<Service> services = new ArrayList<>();
	//
	// while (rs.next())
	// {
	// Service service = new Service();
	// service.setServiceName(rs.getString(1));
	// service.setServiceUrl(rs.getString(2));
	// service.setDescription(rs.getString(3));
	//
	// services.add(service);
	// }
	//
	// return services;
	// }
	// }
}
