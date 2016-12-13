package org.restws.aggreg.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.User;

import com.google.gson.Gson;

public class InstagramApiService {

	public static List<Post> getPosts(User user) throws IOException, JSONException {
		HashMap<String, String> InstagramParams = new HashMap<String, String>();
		
		InstagramParams.put("access_token", user.getInstagramAccount().getToken());
		
	       String json = HttpService.callMethod("GET", "http://localhost:8000/user/feed", InstagramParams); //twitter call

	       List<Post> posts = new ArrayList<Post>();
	       JSONArray jsonArray = new JSONArray(json);

	       for (int i = 0; i < jsonArray.length(); i++) {
	           JSONObject jsonObject = jsonArray.getJSONObject(i);
	           
	           Post post = new Post();
	           post.setIdAuthor( String.valueOf( jsonObject.get( "idAuthor" ) ) );
	           post.setAuthorName( String.valueOf( jsonObject.get( "authorName" ) ) );
	           post.setContent( String.valueOf( jsonObject.get( "content" ) ) );
	           post.setImageLink( String.valueOf( jsonObject.get("imageLink") ) );
	           post.setOrigin("Instagram");
	           
	           posts.add( post );
	       }

	       return posts;
	}
	
	public static void postComment(String mediaId, String content , User user) throws IOException {
	       HashMap<String, String> InstagramParams = new HashMap<String, String>();
	       InstagramParams.put("content", content );
	       InstagramParams.put("access_token", user.getInstagramAccount().getToken());
	       String json = HttpService.callMethod("GET", "http://localhost:8000/media/"+mediaId+"/addComment", InstagramParams);
	       System.out.println("json : " + json);
	   }
}
