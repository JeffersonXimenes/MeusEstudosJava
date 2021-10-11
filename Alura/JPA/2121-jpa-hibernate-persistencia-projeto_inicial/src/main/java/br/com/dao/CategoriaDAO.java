package br.com.dao;

import javax.persistence.EntityManager;

import br.com.entity.CategoriaEntity;
import br.com.entity.ProdutoEntity;

public class CategoriaDAO extends GenericDAO{
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void excluir(CategoriaEntity categoriaEntity) {
		CategoriaEntity cateogria = em.merge(categoriaEntity);
		this.em.remove(cateogria);
	}
	
	public CategoriaEntity buscarPorId(Long id) {
		return em.find(CategoriaEntity.class, id);
	}
}
