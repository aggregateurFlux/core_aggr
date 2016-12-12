package org.restws.aggreg.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;
import org.restws.aggreg.service.InstagramApiService;
import org.restws.aggreg.service.TwitterApiService;
import org.restws.aggreg.service.UserApiService;

@Path("/user")
public class UserResource {
	
	/*Récupérer un user depuis son id
	*GET : http://localhost:8080/core_aggreg/webapi/user/{id}
	*Retour : 
	{
	    "id":"xxx",
	    "instagramAccount": {
	        "name":"Instagram",
	        "token":"token"
	        },
	    "login":"login",
	    "password":"password",
	    "twitteraccount": {
	    "name":"Twitter",
	    "accessTokenId":"id",
	    "accessTokenSecret":"secret"}
	}
	*/
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id) throws IOException, JSONException {
        return UserApiService.getAccountInfos(id);
    }
	
	/*Connexion : Récupérer l'id d'un user à partir du login/password
	 *GET : http://localhost:8080/core_aggreg/webapi/user/connection/{login}&{password}
	 *Retour : 
	{
	    "id":"xxx"
	}
	 */
	@GET
	@Path("/connection/{login}&{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String connection(@PathParam("login") String login,@PathParam("password") String password) {
        return UserApiService.connection(login, password).getId();
    }

	/*Création de compte : Créer un user côté serveur et récupérer ses infos
	 * POST : http://localhost:8080/core_aggreg/webapi/user/createAccount
	 * Envoi : { "login":"login", "password":"password" }
	 * Retour : 
	{
	    "id":"xxx",
	    "instagramAccount": {
	        "name":"Instagram",
	        "token":"token"
	        },
	    "login":"login",
	    "password":"password",
	    "twitteraccount": {
	    "name":"Twitter",
	    "accessTokenId":"id",
	    "accessTokenSecret":"secret"}
	}
	 */
	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createAccount(@PathParam("login") String login,@PathParam("password") String password) {
		return UserApiService.accountCreation(login, password);
	}
	
	/*Lier un compte instagram à un compte user
	 * POST : http://localhost:8080/core_aggreg/webapi/user/addInstagramAccount
	 * Envoi : {  "token":"token"  }
	 * Retour :
	    true : liaison créer
	    false : echec de la liaison
	 */
	@POST
	@Path("/addInstagramAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addInstagramAccount(@PathParam("token") String token) {
		return UserApiService.addInstagramAccount(new InstagramAccount(token));
	}
	
	/*Lier un compte twitter à un compte user
	 * POST : http://localhost:8080/core_aggreg/webapi/user/addTwitterAccount
	 * Envoi : {  "access_token_id":"access_token_id", "access_token_secret":"access_token_secret"  }
	 * Retour :
	    true : liaison créée
	    false : echec de la liaison
	 */
	@POST
	@Path("/addTwitterAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTwitterAccount(@PathParam("accessTokenId") String accessTokenId,@PathParam("accessTokenSecret") String accessTokenSecret) {
		return UserApiService.addTwitterAccount(new TwitterAccount(accessTokenId,accessTokenSecret));
	}
	
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
	@Path("/{id}/feed")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getLastPosts(@PathParam("id") String id) throws IOException, JSONException {
		List<Post> list = InstagramApiService.getPosts(UserApiService.getAccountInfos(id));
		list.addAll(TwitterApiService.getPosts(UserApiService.getAccountInfos(id)));
		return list;
    }
}
