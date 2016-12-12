package org.restws.aggreg.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.User;
import org.restws.aggreg.service.InstagramApiService;
import org.restws.aggreg.service.PostService;
import org.restws.aggreg.service.TwitterApiService;
import org.restws.aggreg.service.UserApiService;

@Path("/post")
public class PostRessource {
	
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
	public String createPost(@PathParam("id") String id, @PathParam("content") String content, @PathParam("imageLink") String imageLink) throws IOException, JSONException {
		return TwitterApiService.createPost(content, UserApiService.getAccountInfos(id).getTwitteraccount().getAccessTokenId(),UserApiService.getAccountInfos(id).getTwitteraccount().getAccessTokenSecret());
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
	   public String commentPost(@HeaderParam("idUser") String idUser, @HeaderParam("content") String content, @HeaderParam("mediaId") String mediaId) throws IOException, JSONException {
	       UserApiService userApiService = new UserApiService();
	       User user = UserApiService.getAccountInfos( idUser );
	       InstagramApiService.postComment(mediaId, content, user);
	       return "true";
	       
	   }
}