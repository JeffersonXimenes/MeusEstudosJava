package br.com.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.dao.ProdutoDAO;
import br.com.entity.Categoria;
import br.com.entity.Produto;
import br.com.util.JPAUtil;

public class CadastroProduto {
	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);

		Produto celular = new Produto("Samsung S10 Plus", "Mió celular, naõ tem pra ninguém >>", new BigDecimal("800"), Categoria.CELULARES);

		dao.cadastrar(celular);
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}
}
