package org.restws.aggreg.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;

import com.google.gson.Gson;

public class UserApiService {

	public static User getAccountInfos(String id) throws IOException {
		//A DECOMMENTER SI LES AUTRES APIs SONT FONCTIONNELLES
		//HashMap<String,String> userParams = new HashMap<String,String>();
		//userParams.put("id", id);
		//String json = HttpService.callMethod("GET", "http://localhost:8081/get/user", userParams);
		//Gson gson = new Gson();
		//return  gson.fromJson( json , User.class);
        
		//A COMMENTER SI LES AUTRES APIs SONT FONCTIONNELLES
		return new User(id,"login","password",new TwitterAccount("id","secret"), new InstagramAccount("token"));
	}
	
	public static User connection(String login, String password) {
		//appel api user (API en développement)
		return new User("1","login","password",new TwitterAccount("id","secret"), new InstagramAccount("token"));
	}
	
	
	public static User accountCreation(String login, String password) {
		//appel api user (API en développement)
		return new User("1","login","password",new TwitterAccount("id","secret"), new InstagramAccount("token"));
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
