package br.com.loja.desconto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class DescontoMaisDeCincoItens extends Desconto {

	public DescontoMaisDeCincoItens(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Orcamento orcamento) {
		if(orcamento.getQuantidadeItens() > 5) {
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		}
		
		return proximo.calcular(orcamento);
	}
	
}