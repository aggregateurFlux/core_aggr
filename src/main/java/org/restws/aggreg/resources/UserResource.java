package org.restws.aggreg.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restws.aggreg.model.User;
import org.restws.aggreg.service.UserService;

@Path("/user")
public class UserResource {
	UserService userService = new UserService();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUser() {
        return userService.getAllUsers();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createAccount(User user) {
		return userService.addAccount(user);
	}
}
