package br.com.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_itens_pedido")
public class ItemPedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PedidoEntity pedidoEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	private ProdutoEntity produtoEntity;

	public ItemPedidoEntity(Integer quantidade, PedidoEntity pedidoEntity, ProdutoEntity produtoEntity) {
		super();
		this.quantidade = quantidade;
		this.pedidoEntity = pedidoEntity;
		this.precoUnitario = produtoEntity.getPreco();
		this.produtoEntity = produtoEntity;
	}
	public BigDecimal getValor() {
		return precoUnitario.multiply(new BigDecimal(quantidade));
	}
}
