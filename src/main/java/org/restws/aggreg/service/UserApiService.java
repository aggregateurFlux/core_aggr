package org.restws.aggreg.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;

import com.google.gson.Gson;

public class UserApiService {

	public static User getAccountInfos(String id) throws IOException, JSONException {
		HashMap<String,String> userParams = new HashMap<String,String>();
		userParams.put("id", id);
		String json = HttpService.callMethod("GET", "http://localhost:8081/get/user", userParams);
        
		JSONObject jsonObject = new JSONObject( json );
	       
	    User user = new User();
	    user.setId( String.valueOf(jsonObject.get( "id" )) );
	       
	    TwitterAccount twitterAccount = new TwitterAccount();
	    twitterAccount.setAccessTokenId( String.valueOf(jsonObject.get("accessTokenId")) );
	    twitterAccount.setAccessTokenSecret( String.valueOf(jsonObject.get("accessTokenSecret")) );
	       
	    user.setTwitteraccount( twitterAccount );
	       
	    InstagramAccount instagramAccount = new InstagramAccount();
	    instagramAccount.setToken( String.valueOf(jsonObject.get("tokenInsta")) );
	    user.setInstagramAccount(instagramAccount);
		
	    return user;
	}
	
	public static User connection(String login, String password) throws IOException, JSONException {
		HashMap<String,String> userParams = new HashMap<String,String>();
		userParams.put("login", login);
		userParams.put("password", password);
		String json = HttpService.callMethod("GET", "http://localhost:8081/get/identification", userParams);
		JSONObject jsonObject = new JSONObject( json );
		User user = new User();
	    user.setId( String.valueOf(jsonObject.get( "id" )) );
		return user;
	}
	
	
	public static User accountCreation(String login, String password) throws IOException, JSONException {
		HashMap<String,String> userParams = new HashMap<String,String>();
		userParams.put("login", login);
		userParams.put("password", password);
		String json = HttpService.callMethod("POST", "http://localhost:8081/post/user", userParams);
		JSONObject jsonObject = new JSONObject( json );
		User user = new User();
	    user.setId( String.valueOf(jsonObject.get( "id" )) );
		return user;
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
