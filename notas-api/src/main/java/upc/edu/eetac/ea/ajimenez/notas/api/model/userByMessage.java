package upc.edu.eetac.ea.ajimenez.notas.api.model;

import java.util.Comparator;

public class userByMessage implements Comparator<User> {
	@Override
	public int compare(User arg0, User arg1) {
		int resultado = 0;
		if (arg1.listNotes.size() < arg0.listNotes.size()) {
			resultado = -1;
		} else if (arg1.listNotes.size() > arg0.listNotes.size()) {
			resultado = 1;
		}
		return resultado;
	}
}
