package br.com.loja.desconto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {

	public BigDecimal calcular(Orcamento orcamento) {
		Desconto desconto = new DescontoMaisDeCincoItens(
				new DescontoMaiorQuinhentos(new SemDesconto()));
		
		return desconto.calcular(orcamento);
		
	}
}
