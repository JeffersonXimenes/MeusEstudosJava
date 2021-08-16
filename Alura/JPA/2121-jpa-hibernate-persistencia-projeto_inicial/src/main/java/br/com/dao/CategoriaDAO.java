package br.com.dao;

import javax.persistence.EntityManager;

public class CategoriaDAO extends GenericDAO{
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
}
