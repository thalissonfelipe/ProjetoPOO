package br.ufc.deti.poo.exceptions;

public class FilmeNaoDisponivelException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoDisponivelException(){
		super("Filme n�o dispon�vel para empr�stimo!");
	}
	
}
