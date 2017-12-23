package br.ufc.deti.poo.exceptions;

public class ClienteNaoEncontradoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(){
		super("Cliente não encontrado!");
	}
	
}
