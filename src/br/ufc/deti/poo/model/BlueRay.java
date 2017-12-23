package br.ufc.deti.poo.model;

import br.ufc.deti.poo.exceptions.ValorNegativoException;

public class BlueRay extends Filme {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlueRay(String codigo, int quantidade, String titulo, int duracao, String genero, String descricao, double valor) throws ValorNegativoException{
		super(codigo, quantidade, titulo, duracao, genero, descricao, valor);
	}

	@Override
	public double taxaAdicional() throws ValorNegativoException {
		this.setValor(this.getValor() + TAXA_BLUERAY);
		return this.getValor();
	}
	
}
