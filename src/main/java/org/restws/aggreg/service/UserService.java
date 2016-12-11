package org.restws.aggreg.service;

import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;

public class UserService {

	public User getAccountInfos(String id) {
		return new User(id,"login","password");
	}
	
	public User connection(String login, String password) {
		return new User("1", login, password);
	}
	
	public User accountCreation(String login, String password) {
		return new User("1", login, password);
	}
	
	public String addSocialNetwork(String token) {
		InstagramAccount newSocialNetwork = new InstagramAccount(token);
		return "Social Network added";
	}
	
	public String addSocialNetwork(String accessTokenId, String accessTokenSecret) {
		TwitterAccount newSocialNetwork = new TwitterAccount(accessTokenId, accessTokenSecret);
		return "Social Network added";
	}
	
}
