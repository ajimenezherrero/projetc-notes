package upc.edu.eetac.ea.ajimenez.notas.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import upc.edu.eetac.ea.ajimenez.notas.api.model.Manager;
import upc.edu.eetac.ea.ajimenez.notas.api.model.ManagerImpl;
import upc.edu.eetac.ea.ajimenez.notas.api.model.User;

@Path("/user")
public class UserResource {
	Manager manager = ManagerImpl.getInstance();

	@PUT
	@Path("/{nickname}")
	@Consumes(MediaType.NOTE_API_USER)
	@Produces(MediaType.NOTE_API_USER)
	public User updateUser(@PathParam("nickname") String nickname, User user) {
		return manager.updateUser(user, nickname);
	}

	@POST
	@Consumes(MediaType.NOTE_API_USER)
	@Produces(MediaType.NOTE_API_USER)
	public User setUser(User user) {
		return manager.setUser(user);
	}

	@GET
	@Produces(MediaType.NOTE_API_USER_COLLECTION)
	public List<User> getUsers(@QueryParam("type") String tipo) {
		List<User> usuarios = new ArrayList<User>();
		if (tipo == null) {
			usuarios = manager.users();
		} else if (tipo.equals("mensajes")) {
			usuarios = manager.userByMessages();
		}
		return usuarios;
	}

	@GET
	@Path("/{nickname}")
	@Produces(MediaType.NOTE_API_USER)
	public User getUser(@PathParam("nickname") String nickname) {
		User user = manager.getUser(nickname);
		return user;
	}

	@DELETE
	@Path("/{nickname}")
	public void deleteUser(@PathParam("nickname") String nickname) {
		manager.deleteUser(nickname);
	}

}
