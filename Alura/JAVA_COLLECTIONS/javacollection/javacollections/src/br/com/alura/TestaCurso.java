package br.com.alura;

import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Jefferson Ximenes");
		
		List<Aula> aulas = javaColecoes.getAulas();
//		System.out.println(aulas);
	
//		aulas.add(new Aula("Trabalhando com ArrayList", 21));
//		javaColecoes.getAulas().add(new Aula("Testando", 23));
		
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com colecoes", 22));

		System.out.println(javaColecoes.getAulas());
		
		
	}
}
