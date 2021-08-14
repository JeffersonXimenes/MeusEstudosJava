package br.com.entity;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_produtos")
public class Produto {
	
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
	
	@Column(name = "categoria")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		
	}
}
