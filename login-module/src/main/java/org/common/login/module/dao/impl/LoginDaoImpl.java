package org.common.login.module.dao.impl;

import java.util.List;
import java.util.Queue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.common.login.module.dao.LoginDao;
import org.common.login.module.entity.Login;
import org.common.login.utility.DBUtilityFactory;
import org.hibernate.Session;

public class LoginDaoImpl implements LoginDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

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
		finally{
			session.close();
		}
		
	}

	@Override
	public List<Login> getAllLogin() {
		//Session session = DBUtilityFactory.getSessionFacotry().openSession();
		
		/*session.beginTransaction();
		Query query = session.createQuery("from Login");
		List<Login> listOfLogin = query.getResultList();
		session.close();*/
		
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Login> q = em.createQuery("from Login", Login.class);
        List<Login> listOfLogin =  q.getResultList();
        
        
        em.getTransaction().commit();
        em.close();
        
        
        
		return listOfLogin;
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
