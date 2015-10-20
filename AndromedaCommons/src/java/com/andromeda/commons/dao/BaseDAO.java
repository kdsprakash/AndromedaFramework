package com.andromeda.commons.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
abstract public class BaseDAO
{
	protected static final String TABLE_NAME = "tableName";

	@Autowired
	protected DataSource dataSource;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected SqlSessionFactory sqlSessionFactory;

	protected void add(Object object, String tableName, String sqlMap)
	{
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put(TABLE_NAME, tableName);
		params.put("p", object);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert(sqlMap, params);
		sqlSession.close();
	}

	protected void deleteById(String tableName, Integer id)
	{
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put(TABLE_NAME, tableName);
		params.put("id", id);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.delete("Common.DeleteById", params);
		sqlSession.close();
	}

	protected void deleteByColumnValue(String tableName, String columnName, String columnValue)
	{
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put(TABLE_NAME, tableName);
		params.put("columnName", columnName);
		params.put("columnValue", columnValue);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.delete("Common.DeleteColumnValue", params);
		sqlSession.close();
	}
}
