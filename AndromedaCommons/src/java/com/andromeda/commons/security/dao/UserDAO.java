package com.andromeda.commons.security.dao;

import org.springframework.stereotype.Repository;

import com.andromeda.commons.dao.BaseDAO;

/**
 * 
 * @author prakash
 * @date 29-Aug-2015
 *
 */
@Repository
public class UserDAO extends BaseDAO
{
	// private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	//
	// private String tableName = "config.users";
	//
	// @Autowired
	// private SqlSessionFactory sqlSessionFactory;
	//
	// public User get(String userName)
	// {
	// SqlSession sqlSession = sqlSessionFactory.openSession();
	// List<User> users = sqlSession.selectList("User.GetUsers");
	// System.out.println("=====>Users: " + users);
	//
	// User user = null;
	// if (!CollectionUtils.isEmpty(users))
	// {
	// user = users.get(0);
	// }
	//
	// return user;
	// }
	//
	// public void add(User user)
	// {
	// super.add(user, tableName, "User.Add");
	// }
	//
	// public void delete(String userName)
	// {
	// super.deleteByColumnValue(userName, "username", userName);
	// }
	//
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
