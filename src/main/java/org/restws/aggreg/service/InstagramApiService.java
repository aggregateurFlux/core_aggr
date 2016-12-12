package org.restws.aggreg.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.User;

import com.google.gson.Gson;

public class InstagramApiService {

	public static List<Post> getPosts(User user) throws IOException {
		HashMap<String,String> InstagramParams = new HashMap<String,String>();
		InstagramParams.put("access_token", user.getInstagramAccount().getToken());
		
        String json = HttpService.callMethod("GET", "http://localhost:8000/user/feed", InstagramParams);
        
        Gson gson = new Gson();
        
		return gson.fromJson( json , List.class);
	}
}
