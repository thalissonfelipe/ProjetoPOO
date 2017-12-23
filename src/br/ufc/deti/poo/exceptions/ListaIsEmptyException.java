package br.ufc.deti.poo.exceptions;

public class ListaIsEmptyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaIsEmptyException(String tipo){
		super("A lista de " + tipo + " está vazia.");
	}
	
}
