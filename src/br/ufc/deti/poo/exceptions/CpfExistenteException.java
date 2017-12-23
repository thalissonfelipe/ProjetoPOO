package br.ufc.deti.poo.exceptions;

public class CpfExistenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfExistenteException(){
		super("Cliente já cadastrado!");
	}
	
}
