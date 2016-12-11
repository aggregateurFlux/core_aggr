package org.restws.aggreg.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restws.aggreg.model.InstagramAccount;
import org.restws.aggreg.model.TwitterAccount;
import org.restws.aggreg.model.User;
import org.restws.aggreg.service.UserApiService;

@Path("/user")
public class UserResource {
	UserApiService userService = new UserApiService();
	
	//getUser
	//return : User
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id) {
        return userService.getAccountInfos(id);
    }
	
	//Connection
	//return : User
	@GET
	@Path("/connection/{login}&{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public User connection(@PathParam("login") String login,@PathParam("password") String password) {
        return UserApiService.connection(login, password);
    }

	//createAccount
	//return : User
	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createAccount(@PathParam("login") String login,@PathParam("password") String password) {
		return UserApiService.accountCreation(login, password);
	}
	
	//addInstagramAccount
	//return string
	@POST
	@Path("/addInstagramAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addInstagramAccount(@PathParam("token") String token) {
		return UserApiService.addInstagramAccount(new InstagramAccount(token));
	}
	
	//addTwitterAccount
	//return String
	@POST
	@Path("/addTwitterAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTwitterAccount(@PathParam("accessTokenId") String accessTokenId,@PathParam("accessTokenSecret") String accessTokenSecret) {
		return UserApiService.addTwitterAccount(new TwitterAccount(accessTokenId,accessTokenSecret));
	}
}
