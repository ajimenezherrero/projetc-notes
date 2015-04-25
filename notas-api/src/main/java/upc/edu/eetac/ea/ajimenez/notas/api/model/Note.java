package upc.edu.eetac.ea.ajimenez.notas.api.model;

public class Note implements Comparable<Note> {
	private String text;

	public String getText() {
		return this.text;
	}

	public void setText(String texto) {
		this.text = texto;
	}

	public int compareTo(Note o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
