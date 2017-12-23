package br.ufc.deti.poo.model;

public class Relatorio {

	private String nomeCliente;
	private String nomeFilme;
	private String dataRecebida;
	private String codigoEmp;
	private double valorFilme;
	private double multa;
	private double total;
	
	public String toString(){
		String s = "";
		s += "Cliente: " + this.getNomeCliente();
		s += "\nFilme: " + this.getNomeFilme();
		s += "\nCódigo do Empréstimo: " + this.getCodigoEmp();
		s += "\nPreço do filme: R$ " + this.getValorFilme();
		s += "\nData recebida: " + this.getDataRecebida();
		s += "\nMulta: R$ " + this.getMulta();
		s += "\nTotal: R$ " + this.getTotal();
		return s;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getNomeFilme() {
		return nomeFilme;
	}
	
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	public String getDataRecebida() {
		return dataRecebida;
	}
	
	public void setDataRecebida(String dataRecebida) {
		this.dataRecebida = dataRecebida;
	}
	
	public double getValorFilme() {
		return valorFilme;
	}
	
	public void setValorFilme(double valorFilme) {
		this.valorFilme = valorFilme;
	}
	
	public double getMulta() {
		return multa;
	}
	
	public void setMulta(double multa) {
		this.multa = multa;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public String getCodigoEmp() {
		return codigoEmp;
	}

	public void setCodigoEmp(String codigoEmp) {
		this.codigoEmp = codigoEmp;
	}
	
}
