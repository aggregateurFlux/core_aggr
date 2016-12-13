package org.restws.aggreg.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;

import com.google.gson.Gson;

public class TwitterApiService {

	public static List<Post> getPosts(User user) throws IOException, JSONException {
		 HashMap<String, String> TwitterParams = new HashMap<String, String>();
	       TwitterParams.put("access_token", user.getTwitteraccount().getAccessTokenId());
	       TwitterParams.put("access_token_secret", user.getTwitteraccount().getAccessTokenSecret());
	       String json = HttpService.callMethod("GET", "http://localhost:8012/timeline", TwitterParams); //twitter call

	       List<Post> posts = new ArrayList<Post>();

	       JSONArray jsonArray = new JSONArray(json);

	       for (int i = 0; i < jsonArray.length(); i++) {
	           JSONObject jsonObject = jsonArray.getJSONObject(i);
	           
	           Post post = new Post();
	           post.setIdAuthor( String.valueOf( jsonObject.get( "idAuthor" ) ) );
	           post.setAuthorName( String.valueOf( jsonObject.get( "authorName" ) ) );
	           post.setContent( String.valueOf( jsonObject.get( "content" ) ) );
	           post.setImageLink( String.valueOf( jsonObject.get("imageLink") ) );
	           post.setOrigin("Twitter");
	           
	           posts.add( post );
	       }

	       return posts;
	}
	
	public static String createPost(String content, String access_token_id, String access_token_secret) throws IOException {
		HashMap<String,String> TwitterParams = new HashMap<String,String>();
		TwitterParams.put("access_token", access_token_id);
		TwitterParams.put("access_token_secret", access_token_secret);
		TwitterParams.put("content", content);
		
		return HttpService.callMethod("POST", "http://localhost:8012/user/feed", TwitterParams);
	}
}

