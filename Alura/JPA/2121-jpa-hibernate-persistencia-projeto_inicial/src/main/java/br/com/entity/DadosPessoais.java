package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoais {

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String cpf;
}
