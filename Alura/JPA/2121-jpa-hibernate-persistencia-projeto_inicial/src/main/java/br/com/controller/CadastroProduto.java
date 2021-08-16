package br.com.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.dao.CategoriaDAO;
import br.com.dao.ProdutoDAO;
import br.com.entity.CategoriaEntity;
import br.com.entity.ProdutoEntity;
import br.com.util.JPAUtil;

public class CadastroProduto {
	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		CategoriaEntity categoria = new CategoriaEntity("Celular");
		ProdutoEntity celular = new ProdutoEntity("Samsung S10 Plus", "Mió celular, naõ tem pra ninguém >>", new BigDecimal("800"), categoria);
		
		categoriaDAO.cadastrar(categoria);
		produtoDAO.cadastrar(celular);
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}	
}
