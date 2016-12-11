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
import org.restws.aggreg.service.PostService;

@Path("/post")
public class PostRessource {
	PostService postService = new PostService();
	
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getLastPosts(@PathParam("id") String id) {
		Post p1 = new Post();
		Post p2 = new Post();
		List<Post> list = new ArrayList<Post>();
		list.add(p1);
		list.add(p2);
		return list;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTwitterAccount(@PathParam("id") String socialNetwork,@PathParam("accessTokenId") String accessTokenId,@PathParam("accessTokenSecret") String accessTokenSecret) {
		return userService.addSocialNetwork(socialNetwork, accessTokenId,accessTokenSecret);
	}
}
