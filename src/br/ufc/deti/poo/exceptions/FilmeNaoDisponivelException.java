package br.ufc.deti.poo.exceptions;

public class FilmeNaoDisponivelException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoDisponivelException(){
		super("Filme não disponível para empréstimo!");
	}
	
}
