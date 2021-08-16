package br.com.dao;

import javax.persistence.EntityManager;

public class ProdutoDAO extends GenericDAO {
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
}
