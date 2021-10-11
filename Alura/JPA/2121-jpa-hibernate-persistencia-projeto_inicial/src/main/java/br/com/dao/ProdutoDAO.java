package br.com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.entity.ProdutoEntity;

public class ProdutoDAO extends GenericDAO {
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public ProdutoEntity buscarPorId(Long id) {
		return em.find(ProdutoEntity.class, id);
	}
	
	public void remover(ProdutoEntity produtoEntity) {
		ProdutoEntity produto = em.merge(produtoEntity);
		em.remove(produto);
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
	
	public List<ProdutoEntity> buscaPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
		String JPQL = "SELECT produto FROM ProdutoEntity produto WHERE 1=1";
		
		if(nome != null && !nome.trim().isEmpty()) {
			JPQL += "AND produto.nome = :nome";
		}
		
		if(preco != null) {
			JPQL += "AND produto.preco = :preco";
		}

		if(dataCadastro != null) {
			JPQL += "AND produto.dataCadastro = :dataCadastro";
		}
		
		TypedQuery<ProdutoEntity> query = em.createQuery(JPQL, ProdutoEntity.class);
		
		if(nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		
		if(preco != null) {
			query.setParameter("preco", preco);
		}

		if(dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}
		
		return query.getResultList();
	}
	
	public List<ProdutoEntity> buscaPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
		String JPQL = "SELECT produto FROM ProdutoEntity produto WHERE 1=1";
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ProdutoEntity> query = builder.createQuery(ProdutoEntity.class);
		Root<ProdutoEntity> from = query.from(ProdutoEntity.class);
		Predicate filtros = builder.and();
		
		if(nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if(preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if(dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
		
	}
}
