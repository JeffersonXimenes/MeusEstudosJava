package br.com.alura;

import java.util.ArrayList;

public class TestandoLista {
	
	public static void main(String[] args) {
		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe aula";
		String aula3 = "Trabalhando com Cursos e Sets";
		
		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}
		
		aulas.forEach(aula -> {
			System.out.println("Aula: " + aula);});
	}
}
