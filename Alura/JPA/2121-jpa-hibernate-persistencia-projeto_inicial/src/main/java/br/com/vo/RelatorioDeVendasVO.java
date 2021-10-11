package br.com.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVO {
	
	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataVenda;
	
	public RelatorioDeVendasVO(String nomeProduto, Long quantidadeVendida, LocalDate dataVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataVenda = dataVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVO [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataVenda=" + dataVenda + "]";
	}
}
