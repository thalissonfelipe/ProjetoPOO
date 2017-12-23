package br.ufc.deti.poo.exceptions;

public class CodigoExistenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodigoExistenteException(){
		super("Filme já cadastrado!");
	}
	
}
