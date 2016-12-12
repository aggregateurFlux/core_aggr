package org.restws.aggreg.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.User;

import com.google.gson.Gson;

public class TwitterApiService {

	public static List<Post> getPosts(User user) throws IOException {
		HashMap<String,String> TwitterParams = new HashMap<String,String>();
		TwitterParams.put("access_token", user.getTwitteraccount().getAccessTokenId());
		TwitterParams.put("access_token_secret", user.getTwitteraccount().getAccessTokenSecret());
		
        String json = HttpService.callMethod("GET", "http://localhost:8012/user/feed", TwitterParams); //twitter call
        
        Gson gson = new Gson();
        
		return gson.fromJson( json , List.class);
	}
}
