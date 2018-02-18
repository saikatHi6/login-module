package org.common.login.module.login_module;

import org.common.login.module.dao.LoginDao;
import org.common.login.module.dao.impl.LoginDaoImpl;
import org.common.login.module.entity.Login;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

	@Test
	public void insertLogin(){
		Login login = new Login();
		login.setUserName("saikat1");
		login.setPassword("saikat1");
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.insert(login);
	}
	
	

}
