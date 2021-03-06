package com.andromeda.portal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.andromeda.commons.dao.BaseDAO;
import com.andromeda.portal.model.Module;

/**
 * 
 * @author Prakash K
 * @date 08-Sep-2015
 *
 */
@Repository
public class ModuleDAO extends BaseDAO
{
	public List<Module> getAll()
	{
		Map<String, Object> params = new HashMap<>();
		List<Module> modules = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			modules = sqlSession.selectList("Security.Module.GetAll", params);
		}
		catch (Exception e)
		{
		}
		finally
		{
			sqlSession.close();
		}
		return modules;
	}

	public List<Module> getSelectModules()
	{
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		List<Module> modules = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			modules = sqlSession.selectList("Security.Module.GetSelectModules", params);
		}
		catch (Exception e)
		{
		}
		finally
		{
			sqlSession.close();
		}
		return modules;
	}
}
