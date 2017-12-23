package br.ufc.deti.poo.model;

import java.io.Serializable;
import java.util.Calendar;

public class Emprestimo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private Calendar dataDevolucaoEfetiva;
	private double multa;
	private Filme filme;
	private Cliente cliente;
	private Relatorio relatorio;

	public Emprestimo(String codigo){
		this.setCodigo(codigo);
	}

	public String toString(){
		String s = "";
		s += "Código do empréstimo: " + this.getCodigo();
		s += "\nData do empréstimo: " + this.getDataEmprestimo().get(Calendar.DAY_OF_MONTH) + "/" + (this.getDataEmprestimo().get(Calendar.MONTH)+1) + "/" + this.getDataEmprestimo().get(Calendar.YEAR);
		s += "\nData prevista para devolução: " + this.getDataDevolucao().get(Calendar.DAY_OF_MONTH) + "/" + (this.getDataDevolucao().get(Calendar.MONTH)+1) + "/" + this.getDataDevolucao().get(Calendar.YEAR);
		s += "\nCliente: " + this.getCliente().getNome() + " " + this.getCliente().getSobrenome();
		s += "\nFilme: " + this.getFilme().getTitulo() + "\n";
		return s;
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public Calendar getDataDevolucaoEfetiva() {
		return dataDevolucaoEfetiva;
	}
	
	public void setDataDevolucaoEfetiva(Calendar dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}
	
	public double getMulta() {
		return multa;
	}
	
	public void setMulta(double multa) {
		this.multa = multa;
	}
	
	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}
	
}
