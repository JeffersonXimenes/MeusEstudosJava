package br.com.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.entity.ProdutoEntity;

public class ProdutoDAO extends GenericDAO {
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public ProdutoEntity buscarProduto(Long id) {
		return em.find(ProdutoEntity.class, id);
	}
	
	public List<ProdutoEntity> buscarTodos() {
		String JPQL = "SELECT produto FROM ProdutoEntity produto";
		return em.createQuery(JPQL, ProdutoEntity.class).getResultList();
	}
	
	public List<ProdutoEntity> buscarPorNome(String nome) {
		String JPQL = "SELECT produto FROM ProdutoEntity produto WHERE produto.nome = :nome";
		return em.createQuery(JPQL, ProdutoEntity.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String JPQL = "SELECT produto.preco FROM ProdutoEntity produto WHERE produto.nome = :nome";
		return em.createQuery(JPQL, BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
	
}
