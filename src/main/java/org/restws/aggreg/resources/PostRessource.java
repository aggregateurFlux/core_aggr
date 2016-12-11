package org.restws.aggreg.resources;

import java.util.List;

import javax.ws.rs.GET;
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
	@Path("/{userIdentifiant}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPost(@PathParam("userIdentifiant") String userIdentifiant) {
        return postService.getAllPosts(userIdentifiant);
    }
}
