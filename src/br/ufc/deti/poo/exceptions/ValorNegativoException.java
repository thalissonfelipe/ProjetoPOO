package br.ufc.deti.poo.exceptions;

public class ValorNegativoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValorNegativoException(){
		super("O valor do filme n�o pode ser menor ou igual a zero.");
	}
	
}
