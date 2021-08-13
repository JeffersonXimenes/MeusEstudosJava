package br.com.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.entity.Produto;

public class CadastroProduto {
	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Samsun S10 Plus");
		celular.setDescricao("Mió celular, naõ tem pra ninguém >>");
		celular.setPreco(new BigDecimal("800"));

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
		
	}
}
