package upc.edu.eetac.ea.ajimenez.notas.api.model;

import java.util.List;

public interface Manager {
	public User updateUser(User user, String nickname);
	public User getUser(String nickname);
	public void deleteUser(String nickname);

	// Si la funcion devuelve un 1 es que se ha introducido el usuario, si es un
	// 0 es que ya existe ese nickname
	public User setUser(User user);

	public void addNote(String nickname, Note nota);

	// Devuelve una lista de usuarios ordenada alfabeticamente por el campo
	// nickname
	public List<User> users();

	// Devuelve una lista de usuarios ordenada por el nº de mensajes de cada
	// usuario
	public List<User> userByMessages();

	public List<Note> notes(String nickname);
}

