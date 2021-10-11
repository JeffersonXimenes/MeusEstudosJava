package br.com.dao;

import javax.persistence.EntityManager;

import br.com.entity.ClienteEntity;

public class ClienteDAO extends GenericDAO {
	
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(ClienteEntity cliente) {
		this.em.persist(cliente);
	}
	
	public ClienteEntity buscarPorId(Long id) {
		return em.find(ClienteEntity.class, id);
	}
}
