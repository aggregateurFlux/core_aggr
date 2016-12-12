package org.restws.aggreg.resources;

import java.io.IOException;
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
	
	/* Récupérer les derniers posts de l'utilisateur ayant pour id {id}
	 * GET : http://localhost:8080/core_aggreg/webapi/post/{id}
	 * Retour :
	 * [{  "authorName":"authorName",
	 *     "content":"content",
	 *     "idAuthor":"idAuthor",
	 *     "imageLink":"imageLink",
	 *     "postCreatedAt":"postCreatedAt"
	 *  },
	 *  {
	 *      ...
	 *  }]
	 */
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getLastPosts(@PathParam("id") String id) throws IOException {
		List<Post> list = InstagramApiService.getPosts(UserApiService.getAccountInfos(id));
		list.addAll(TwitterApiService.getPosts(UserApiService.getAccountInfos(id)));
		return list;
    }
	
	/*Créer un nouveau Post
	 * POST : http://localhost:8080/core_aggreg/webapi/createPost
	 * Envoi :
	 {  "id":"id", "content":"content"  }
	 Retour :
	     true : post créé
	     false : échec création du post
	 */
	@POST
	@Path("/createPost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createPost(@PathParam("id") String id, @PathParam("content") String content) {
		return "true";
		/* envoyer access_token_id, access_token_secret, content*/
	}
	
	/*Commenter un Post
	 * POST : http://localhost:8080/core_aggreg/webapi/commentPost
	 * Envoi :
	 {  "id":"id", "content":"content"  }
	 Retour :
	     true : post créé
	     false : échec création du post	 
	 */
	@POST
	@Path("/commentPost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String commentPost(@PathParam("id") String id,@PathParam("content") String content) {
		return "true";
		/* envoyer token, content*/
	}
}