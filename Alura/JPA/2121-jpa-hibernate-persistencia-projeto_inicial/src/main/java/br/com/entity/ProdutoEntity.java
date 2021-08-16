package br.com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produtos")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	@Column(name = "dataCadastro")
	private LocalDate dataCadastro = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity categoriaEntity;
	
	public ProdutoEntity(String nome, String descricao, BigDecimal preco, CategoriaEntity categoriaEntity) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoriaEntity = categoriaEntity;
	}
}
