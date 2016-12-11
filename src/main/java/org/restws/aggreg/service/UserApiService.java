package org.restws.aggreg.service;

import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;

public class UserApiService {

	public static User getAccountInfos(String id) {
		//appel api user (API en développement)
		return new User(id,"login","password");
	}
	
	public static User connection(String login, String password) {
		//appel api user (API en développement)
		return new User("1", login, password);
	}
	
	
	public static User accountCreation(String login, String password) {
		//appel api user (API en développement)
		return new User("1", login, password);
	}
	
	public static String addInstagramAccount(InstagramAccount instagramAccount) {
		//appel api user (API en développement)
		return "true";
	}
	
	public static String addTwitterAccount(TwitterAccount twitteraccount) {
		//appel api user (API en développement)
		return "true";
	}
}
