package upc.edu.eetac.ea.ajimenez.notas.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerImpl implements Manager {
	private static ManagerImpl instance = null;
	private List<User> usuarios;

	private ManagerImpl() {
		this.usuarios = new ArrayList<User>();
	}

	public static Manager getInstance() {
		if (instance == null){
			instance = new ManagerImpl();
		}
		return instance;
	}

	public User updateUser(User user, String nick) {
		for (User usuario : usuarios) {
			if (usuario.getNickname().equals(nick)) {
				if (usuario.getPass().equals(user.getPass())) {
					// Copiamos en usuario los nuevos valores de user
					usuario.setName(user.getName());
					usuario.setNickname(user.getNickname());
					usuario.setSurname(user.getSurname());
					usuario.setPass(user.getPass());
					// Utilizamos user para devolver los valores que hemos
					// introducido
					user.setName(usuario.getName());
					user.setNickname(usuario.getNickname());
					user.setSurname(usuario.getSurname());
					break;
				}
			}
		}
		return user;
	}

	public User getUser(String nickname) {
		User user = new User();
		for (User usuario : usuarios) {
			if (usuario.getNickname().equals(nickname)) {
				user.setName(usuario.getName());
				user.setSurname(usuario.getSurname());
				user.setNickname(usuario.getNickname());
				break;
			}

		}
		return user;
	}

	public void deleteUser(String nickname) {
		//SEGURIDAD
		for (User usuario : usuarios) {
			if (usuario.getNickname().equals(nickname)) {
				usuarios.remove(usuario);
				break;
			}
		}
	}

	public User setUser(User user) {
		int compr = 1;
		for (User usuario : usuarios) {
			if (usuario.getNickname().equals(user.getNickname())
					&& usuario.getName().equals(
							user.getName())
									&& usuario.getSurname().equals(
											user.getSurname())) {
				compr = 0;
				break;
			}
		}
		if (compr == 1) {
			usuarios.add(user);
		}
		return user;
	}

	public void addNote(String nickname, Note nota) {
		Note not = new Note();
		for (User usuario : usuarios){
			if (usuario.getNickname().equals(nickname)) {
					not.setText(nota.getText());
					usuario.getListNotes().add(not);
					break;
			}
		}
	}

	public List<User> users() {
		Collections.sort(usuarios);
		return usuarios;
	}

	public List<User> userByMessages() {
		Collections.sort(usuarios, new userByMessage());
		return usuarios;
	}

	public List<Note> notes(String nickname) {
		List<Note> notas = null;
		for (User usuario : usuarios){
			if (usuario.getNickname() == nickname) {
				notas = usuario.getListNotes();
				Collections.sort(notas);
				break;
			}
		}
		return notas;
	}
}
