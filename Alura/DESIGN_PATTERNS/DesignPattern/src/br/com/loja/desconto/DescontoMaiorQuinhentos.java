package br.com.loja.desconto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class DescontoMaiorQuinhentos extends Desconto {

	public DescontoMaiorQuinhentos(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Orcamento orcamento) {
		if(orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
			return orcamento.getValor().multiply(new BigDecimal("0.05"));
		}
		
		return proximo.calcular(orcamento);
	}
	
}