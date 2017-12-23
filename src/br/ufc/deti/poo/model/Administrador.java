package br.ufc.deti.poo.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import br.ufc.deti.poo.exceptions.*;
import br.ufc.deti.poo.interfaces.InterfaceAdministrador;

public class Administrador implements InterfaceAdministrador{

	private String nome = "Administrador";
	private Locadora locadora = new Locadora(new ArrayList<Cliente>(), new ArrayList<Filme>(), new ArrayList<Emprestimo>());
	
	public Administrador(){
		this.setNome(nome);
	}
	
	public void cadastrarCliente(String nome, String sobrenome, String cpf, String dataNasc, String endereco, String telefone, String email) throws CpfExistenteException, IOException{
		Cliente c = new Cliente(nome, sobrenome, cpf, dataNasc, endereco, telefone, email);
		locadora.adicionarCliente(c);
	}
	
	public void removerCliente(String nome) throws ListaIsEmptyException, IOException, ClienteNaoEncontradoException{
		locadora.excluirCliente(nome);
	}
	
	public Cliente buscarCliente(String nome) throws ListaIsEmptyException, FileNotFoundException, ClienteNaoEncontradoException{
		return locadora.buscarCliente(nome);
	}
	
	public ArrayList<Cliente> listarClientes() throws FileNotFoundException, ListaIsEmptyException{
		return locadora.listarClientes();
	}
	
	public void cadastrarDVD(String codigo, int quantidade, String titulo, int duracao, String genero, String descricao, double valor) throws CodigoExistenteException, ValorNegativoException, FileNotFoundException{
		Filme filme = new DVD(codigo, quantidade, titulo, duracao, genero, descricao, valor);
		locadora.cadastrarFilme(filme);
	}
	
	public void cadastrarBlueRay(String codigo, int quantidade, String titulo, int duracao, String genero, String descricao, double valor) throws CodigoExistenteException, ValorNegativoException, FileNotFoundException{
		Filme filme = new BlueRay(codigo, quantidade, titulo, duracao, genero, descricao, valor);
		locadora.cadastrarFilme(filme);
	}
	
	public void removerFilme(String codigo) throws IOException, FilmeNaoEncontradoException, ListaIsEmptyException{
		locadora.excluirFilme(codigo);
	}
	
	public Filme buscarFilme(String codigo) throws FileNotFoundException, FilmeNaoEncontradoException, ListaIsEmptyException{
		return locadora.buscarFilme(codigo);
	}
	
	public ArrayList<Filme> listarFilmes() throws FileNotFoundException, ListaIsEmptyException{
		return locadora.listarFilmes();
	}
	
	public Emprestimo buscarEmprestimo(String codigo) throws FileNotFoundException, EmprestimoNaoEncontradoException, ListaIsEmptyException{
		return locadora.buscarEmprestimo(codigo);
	}
	
	public void realizarEmprestimo(String nome, String codigoF, String codigoEmp) throws ClienteNaoEncontradoException, ListaIsEmptyException, FilmeNaoEncontradoException, FilmeNaoDisponivelException, IOException, CodigoExistenteException, ValorNegativoException{
		locadora.realizarLocacao(nome, codigoF, codigoEmp);
	}

	public Relatorio devolverEmprestimo(String codigoEmp, String dataRecebida) throws ParseException, ValorNegativoException, EmprestimoNaoEncontradoException, ListaIsEmptyException, IOException, FilmeNaoEncontradoException, CodigoExistenteException{
		return locadora.devolverLocacao(codigoEmp, dataRecebida);
	}
	
	public ArrayList<Emprestimo> listarEmprestimos() throws FileNotFoundException, ListaIsEmptyException{
		return locadora.listarEmprestimos();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
