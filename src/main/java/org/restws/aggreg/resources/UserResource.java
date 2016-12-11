package org.restws.aggreg.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restws.aggreg.model.User;
import org.restws.aggreg.service.UserService;

@Path("/user")
public class UserResource {
	UserService userService = new UserService();
	
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id) {
        return userService.getAccountInfos(id);
    }
	
	@GET
	@Path("/connection/{login}&{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public User connection(@PathParam("login") String login,@PathParam("password") String password) {
        return userService.connection(login, password);
    }

	@POST
	@Path("/accountCreation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createAccount(@PathParam("login") String login,@PathParam("password") String password) {
		return userService.accountCreation(login, password);
	}
	
	@POST
	@Path("/addInstagramAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addInstagramAccount(@PathParam("token") String token) {
		return userService.addSocialNetwork(token);
	}
	
	@POST
	@Path("/addTwitterAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTwitterAccount(@PathParam("accessTokenId") String accessTokenId,@PathParam("accessTokenSecret") String accessTokenSecret) {
		return userService.addSocialNetwork(accessTokenId,accessTokenSecret);
	}
}
