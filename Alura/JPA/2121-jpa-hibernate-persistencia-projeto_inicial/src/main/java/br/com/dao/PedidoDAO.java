package br.com.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.entity.PedidoEntity;
import br.com.entity.ProdutoEntity;
import br.com.vo.RelatorioDeVendasVO;

public class PedidoDAO extends GenericDAO {
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public PedidoEntity buscarProduto(Long id) {
		return em.find(PedidoEntity.class, id);
	}
	
	public void remover(PedidoEntity pedidoEntity) {
		PedidoEntity produto = em.merge(pedidoEntity);
		em.remove(produto);
	} 
	
	public List<PedidoEntity> buscarTodos() {
		String JPQL = "SELECT pedido FROM PedidoEntity pedido";
		return em.createQuery(JPQL, PedidoEntity.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido() {
		String JPQL = "SELECT SUM(produto.total) FROM ProdutoEntity produto";
		return em.createQuery(JPQL, BigDecimal.class)
				.getSingleResult();
	}
	
	public List<RelatorioDeVendasVO> relatorioDeVendas() {
		String JPQL = "SELECT new br.com.vo.RelatorioDeVendasVO( "
				+ "produto.nome, "
				+ "SUM(item.quantidade), "
				+ "MAX(pedido.data)) "
				+ "FROM PedidoEntity pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produtoEntity produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		
		return em.createQuery(JPQL, RelatorioDeVendasVO.class)
				.getResultList();
	}
	
	public PedidoEntity buscarPedidoComCliente(Long id) {
		String JPQL = "SELECT p FROM PedidoEntity p "
				+ "JOIN FETCH p.cliente WHERE p.id = :id ";
		
		return em.createQuery(JPQL, PedidoEntity.class)
				.setParameter("id", id)
				.getSingleResult();
		
	}
	
	public List<Object[]> relatorioDeVendasObjet() {
		String JPQL = "SELECT produto.nome, "
				+ "SUM(item.quantidade), "
				+ "MAX(pedido.data) "
				+ "FROM PedidoEntity pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produtoEntity produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		
		return em.createQuery(JPQL, Object[].class)
				.getResultList();
	}
}
