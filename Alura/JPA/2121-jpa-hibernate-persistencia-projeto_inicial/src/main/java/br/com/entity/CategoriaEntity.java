package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_categoria")
@Data
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	public CategoriaEntity(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "CategoriaEntity [id=" + id + ", nome=" + nome + "]";
	}
}
