package br.com.dao;

import javax.persistence.EntityManager;

public class GenericDAO {

	protected EntityManager em;
	
	public void cadastrar(Object object) {
		this.em.persist(object);
	}
	
	public void atualizar(Object object) {
		this.em.merge(object);
	}
}