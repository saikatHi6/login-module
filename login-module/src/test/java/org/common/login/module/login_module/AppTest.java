package org.common.login.module.login_module;

import java.util.List;

import org.common.login.module.dao.LoginDao;
import org.common.login.module.dao.impl.LoginDaoImpl;
import org.common.login.module.entity.Login;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

	LoginDao loginDao = new LoginDaoImpl();
	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());
	
	
	//@Test
	public void insertLogin(){
		Login login = new Login();
		login.setUserName("saikat12");
		login.setPassword("saikat5");
		
		loginDao.insert(login);
	}
	
	@Test
	public void fetchListOfLogin() {
		List<Login> listOfLogin = loginDao.getAllLogin();
		for (Login login : listOfLogin) {
			log.info("Id:"+ login.getId()+" User Name: "+login.getUserName());
			//System.out.println("Id:"+ login.getId()+" User Name: "+login.getUserName());
		}
	}

}
