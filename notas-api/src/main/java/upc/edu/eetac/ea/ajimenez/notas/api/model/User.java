package upc.edu.eetac.ea.ajimenez.notas.api.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User implements Comparable<User>{
	private String name;
	private String surname;
	private String nickname;
	private String pass;
	List<Note> listNotes = new ArrayList<Note>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Note> getListNotes() {
		return listNotes;
	}

	public void setListNotes(List<Note> listNotes) {
		this.listNotes = listNotes;
	}

	public int compareTo(User o) {
		int resultado = 0;
		if (this.name.compareTo(o.name) == 0) {
			resultado = this.surname.compareTo(o.surname);
		} else {
			resultado = this.name.compareTo(o.name);
		}
		return resultado;
	}

}

