package br.ufc.deti.poo.model;

import java.io.Serializable;

import br.ufc.deti.poo.exceptions.ValorNegativoException;

public abstract class Filme implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String titulo;
	private int duracao;
	private String genero;
	private String descricao;
	private double valor;
	private boolean Disponivel;
	private int quantidade;
	private int numeroLoc;
	protected static final double TAXA_BLUERAY = 5;
	protected static final double TAXA_DVD = 0;
	
	public Filme(String codigo, int quantidade, String titulo, int duracao, String genero, String descricao, double valor) throws ValorNegativoException{
		this.setCodigo(codigo);
		this.setQuantidade(quantidade);
		this.setDisponivel(true);
		this.setTitulo(titulo);
		this.setDuracao(duracao);
		this.setGenero(genero);
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setNumeroLoc(0);
	}

	public String toString(){
		String s = "";
		s += "Código: " + this.getCodigo();
		s += "\nQuantidade: " + this.getQuantidade();
		if(this.getNumeroLoc() == 0){
			s += "\nLocado: nenhuma vez";
		}
		else if(this.getNumeroLoc() == 1){
			s += "\nLocado: 1 vez";
		}
		else s += "\nLocado: " + this.getNumeroLoc() + " vezes";
		s += "\nTítulo: " + this.getTitulo();
		s += "\nDuração: " + this.getDuracao() + " minutos";
		s += "\nGênero: " + this.getGenero();
		s += "\nDescrição: " + this.getDescricao();
		s += "\nValor: R$ " + this.getValor() + "\n";
		return s;
	}
	
	public abstract double taxaAdicional() throws ValorNegativoException;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) throws ValorNegativoException {
		if(valor <= 0) throw new ValorNegativoException();
		this.valor = valor;
	}

	public boolean isDisponivel() {
		return Disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		Disponivel = disponivel;
	}

	public int getNumeroLoc() {
		return numeroLoc;
	}

	public void setNumeroLoc(int numeroLoc) {
		this.numeroLoc = numeroLoc;
	}
	
}
