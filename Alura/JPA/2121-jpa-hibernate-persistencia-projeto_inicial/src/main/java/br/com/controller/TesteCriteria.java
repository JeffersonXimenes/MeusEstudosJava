package br.com.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.dao.ClienteDAO;
import br.com.dao.PedidoDAO;
import br.com.dao.ProdutoDAO;
import br.com.entity.ClienteEntity;
import br.com.entity.ItemPedidoEntity;
import br.com.entity.PedidoEntity;
import br.com.entity.ProdutoEntity;
import br.com.util.BancoDeDadosUtil;
import br.com.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		BancoDeDadosUtil.popularBancoDeDados();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);

		em.getTransaction().begin();

		ProdutoEntity produto = produtoDAO.buscarPorId(1l);
		ClienteEntity cliente = clienteDAO.buscarPorId(1l);

		PedidoEntity pedido = new PedidoEntity(cliente);
		
		pedido.adicionarItem(new ItemPedidoEntity(10, pedido, produto));
		pedidoDAO.cadastrar(pedido);
		
		
		em.getTransaction().commit();

		
		List<ProdutoEntity> filtroComCriteria = produtoDAO.buscaPorParametrosComCriteria("Iphone X", null, null);
		filtroComCriteria.forEach(System.out::println); 
	}

}
