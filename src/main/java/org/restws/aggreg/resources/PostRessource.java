package org.restws.aggreg.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restws.aggreg.model.Post;
import org.restws.aggreg.service.InstagramApiService;
import org.restws.aggreg.service.PostService;
import org.restws.aggreg.service.TwitterApiService;
import org.restws.aggreg.service.UserApiService;

@Path("/post")
public class PostRessource {
	PostService postService = new PostService();
	
	//getLastPosts
	//return : Lis<String>
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getLastPosts(@PathParam("id") String id) {
		List<Post> list = InstagramApiService.getPosts(UserApiService.getAccountInfos(id));
		list.add(TwitterApiService.getPosts(UserApiService.getAccountInfos(id)));
		return list;
    }
	
	//createPost
	//return : String
	@POST
	@Path("/createPost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createPost(@PathParam("access_token") String accesstoken,@PathParam("access_token_secret") String access_token_secret,	@PathParam("content") String content) {
		return "Posted";
	}
	
	//commentPost
	//return : String
	@POST
	@Path("/commentPost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String commentPost(@PathParam("token") String token,@PathParam("content") String content) {
		return "Posted";
	}
}