package br.com.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.dao.ProdutoDAO;
import br.com.entity.ProdutoEntity;
import br.com.util.BancoDeDadosUtil;
import br.com.util.JPAUtil;

public class CadastroProduto {
	
	public static void main(String[] args) {
		BancoDeDadosUtil.popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		ProdutoEntity produto = produtoDAO.buscarPorId(1l);
		List<ProdutoEntity> listarTodos = produtoDAO.buscarTodos();

		System.out.println(produto.toString());
		
		listarTodos.forEach(listar -> System.out.println(listar.toString()));
		
	}
}
