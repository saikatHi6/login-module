package org.common.login.module.dao.impl;

import java.util.List;

import org.common.login.module.dao.LoginDao;
import org.common.login.module.entity.Login;
import org.common.login.utility.DBUtilityFactory;
import org.hibernate.Session;

public class LoginDaoImpl implements LoginDao {

	@Override
	public void insert(Login login) {
		Session session = DBUtilityFactory.getSessionFacotry().openSession();
		session.beginTransaction();
		try{
			session.save(login);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		DBUtilityFactory.shutDown();
	}

	@Override
	public List<Login> getAllLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Login login) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Login login) {
		// TODO Auto-generated method stub

	}

}
