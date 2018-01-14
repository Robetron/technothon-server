package com.psl.service;

import org.springframework.stereotype.Service;

import com.psl.dao.UserDao;
import com.psl.entity.User;

@Service
public class UserService {

	private UserDao dao;

	public UserService() {
		super();
		this.dao = new UserDao();
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	public String authenticateUser(String username, String password) {
		return this.dao.authenticateUser(username, password);
	}

	public boolean addUser(User user) {
		return this.dao.addUser(user);
	}
}
