package org.restws.aggreg.service;

import java.util.ArrayList;
import java.util.List;

import org.restws.aggreg.model.User;

public class UserService {

	List<User> list = new ArrayList<>();
	
	public List<User> getAllUsers() {
		return list;
	}
	
	public void createAccount(String identifiant, String password) {
		this.list.add(new User(identifiant, password));
	}
	
	public User addAccount(User user) {
		this.list.add(user);
		return user;
	}
	
}
