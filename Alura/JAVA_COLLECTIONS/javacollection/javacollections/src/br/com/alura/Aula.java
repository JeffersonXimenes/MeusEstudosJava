package br.com.alura;

public class Aula implements Comparable<Aula>{

	private String titulo;
	private int tempo;
	
	public Aula() {}

	public Aula(String titulo, int tempo) {
		super();
		this.titulo = titulo;
		this.tempo = tempo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getTempo() {
		return tempo;
	}

	@Override
	public String toString() {
		return "Aula [titulo= " + titulo + ", tempo= " + tempo + "]";
	}

	@Override
	public int compareTo(Aula outraAula) {
		return outraAula != null ? this.titulo.compareToIgnoreCase(outraAula.titulo) : 0;
	}
}
