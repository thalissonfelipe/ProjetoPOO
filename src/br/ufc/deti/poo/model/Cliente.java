package br.ufc.deti.poo.model;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private String dataNasc;
	
	public Cliente(String nome, String sobrenome, String cpf, String dataNasc, String endereco, String telefone, String email){
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
		this.setDataNasc(dataNasc);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setEmail(email);
	}
	
	public String toString(){
		String s = "";
		s += "Nome: " + this.getNome() + " " + this.getSobrenome();
		s += "\nCPF: " + this.getCpf();
		s += "\nData de nascimento: " + this.getDataNasc();
		s += "\nEndereço: " + this.getEndereco();
		s += "\nTelefone: " + this.getTelefone();
		s += "\nEmail: " + this.getEmail() + "\n";
		return s;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
