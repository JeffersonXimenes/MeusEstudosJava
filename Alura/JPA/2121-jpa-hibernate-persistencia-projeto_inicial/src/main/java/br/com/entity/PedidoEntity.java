package br.com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pedidos")
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "total")
	private BigDecimal total = BigDecimal.ZERO;
	
	@Column(name = "data ")
	private LocalDate data = LocalDate.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ClienteEntity clienteEntity;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoEntity", cascade = CascadeType.ALL)
	private List<ItemPedidoEntity> itens = new ArrayList<>();
 
	public PedidoEntity(ClienteEntity clienteEntity) {
		super();
		this.clienteEntity = clienteEntity;
	}
	
	public void adicionarItem(ItemPedidoEntity item) {
		item.setPedidoEntity(this);
		this.itens.add(item);
		this.total = this.total.add(item.getValor());
	}
}
