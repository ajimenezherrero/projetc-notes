package upc.edu.eetac.ea.ajimenez.notas.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import upc.edu.eetac.ea.ajimenez.notas.api.model.Manager;
import upc.edu.eetac.ea.ajimenez.notas.api.model.ManagerImpl;
import upc.edu.eetac.ea.ajimenez.notas.api.model.Note;

@Path("/user/{nickname}/notes")
public class NoteResource {
	Manager manager = ManagerImpl.getInstance();
	
	@POST
	@Consumes(MediaType.NOTE_API_NOTE)
	public void setUser(@PathParam("nickname") String nickname, Note nota) {
		manager.addNote(nickname, nota);
	}

	@GET
	@Produces(MediaType.NOTE_API_NOTE_COLLECTION)
	public List<Note> getNotes(@PathParam("nickname") String nickname) {
		List<Note> notas = manager.notes(nickname);
		return notas;
	}
}
