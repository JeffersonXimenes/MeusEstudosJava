package br.com.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.dao.CategoriaDAO;
import br.com.dao.ProdutoDAO;
import br.com.entity.CategoriaEntity;
import br.com.entity.ProdutoEntity;
import br.com.util.JPAUtil;

public class CadastroProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		ProdutoEntity produto = produtoDAO.buscarProduto(1l);
		List<ProdutoEntity> listarTodos = produtoDAO.buscarTodos();

		System.out.println(produto.toString());
		
		listarTodos.forEach(listar -> System.out.println(listar.toString()));
		
	}

	private static void cadastrarProduto() {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		CategoriaEntity categoriaCadastrar = new CategoriaEntity("Celular");
		ProdutoEntity celular = new ProdutoEntity("Samsung S10 Plus", "Mió celular, naõ tem pra ninguém >>", new BigDecimal("800"), categoriaCadastrar);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(categoriaCadastrar);
		produtoDAO.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}	
}
