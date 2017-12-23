package br.ufc.deti.poo.exceptions;

public class EmprestimoNaoEncontradoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmprestimoNaoEncontradoException(){
		super("Empréstimo não encontrado!");
	}
	
}
