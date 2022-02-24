package br.com.loja;

import java.math.BigDecimal;

import br.com.loja.desconto.CalculadoraDeDescontos;
import br.com.loja.orcamento.Orcamento;

public class TesteDescontos {

	public static void main(String[] args) {
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		Orcamento primeiroOrcamento = new Orcamento(new BigDecimal("200"), 6);
		Orcamento segundoOrcamento = new Orcamento(new BigDecimal("1000"), 6);


		System.out.println(calculadora.calcular(primeiroOrcamento));
		System.out.println(calculadora.calcular(segundoOrcamento));

		
	}

}
