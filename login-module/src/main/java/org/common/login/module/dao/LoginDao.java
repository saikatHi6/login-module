package org.common.login.module.dao;


import java.util.List;

import org.common.login.module.entity.Login;

public interface LoginDao {
	public void insert(Login login);
	public List<Login> getAllLogin();
	public void update(Login login);
	public void delete(Login login);
}
