package br.ufc.deti.poo.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import br.ufc.deti.poo.exceptions.ClienteNaoEncontradoException;
import br.ufc.deti.poo.exceptions.CodigoExistenteException;
import br.ufc.deti.poo.exceptions.CpfExistenteException;
import br.ufc.deti.poo.exceptions.EmprestimoNaoEncontradoException;
import br.ufc.deti.poo.exceptions.FilmeNaoDisponivelException;
import br.ufc.deti.poo.exceptions.FilmeNaoEncontradoException;
import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.exceptions.ValorNegativoException;
import br.ufc.deti.poo.model.Cliente;
import br.ufc.deti.poo.model.Emprestimo;
import br.ufc.deti.poo.model.Filme;
import br.ufc.deti.poo.model.Relatorio;

public interface InterfaceAdministrador {

	public void cadastrarCliente(String nome, String sobrenome, String cpf, String dataNasc, String endereco, String telefone, String email) throws CpfExistenteException, IOException;
	public void removerCliente(String nome) throws ListaIsEmptyException, IOException, ClienteNaoEncontradoException;
	public Cliente buscarCliente(String nome) throws ListaIsEmptyException, FileNotFoundException, ClienteNaoEncontradoException;
	public ArrayList<Cliente> listarClientes() throws FileNotFoundException, ListaIsEmptyException;
	public void cadastrarDVD(String codigo, int quantidade, String titulo, int duracao, String genero, String descricao, double valor) throws CodigoExistenteException, ValorNegativoException, FileNotFoundException;
	public void cadastrarBlueRay(String codigo, int quantidade, String titulo, int duracao, String genero, String descricao, double valor) throws CodigoExistenteException, ValorNegativoException, FileNotFoundException;
	public void removerFilme(String titulo) throws IOException, FilmeNaoEncontradoException, ListaIsEmptyException;
	public Filme buscarFilme(String titulo) throws FileNotFoundException, FilmeNaoEncontradoException, ListaIsEmptyException;
	public ArrayList<Filme> listarFilmes() throws FileNotFoundException, ListaIsEmptyException;
	public Emprestimo buscarEmprestimo(String codigo) throws FileNotFoundException, EmprestimoNaoEncontradoException, ListaIsEmptyException;
	public void realizarEmprestimo(String nome, String titulo, String codigo) throws FileNotFoundException, ClienteNaoEncontradoException, ListaIsEmptyException, FilmeNaoEncontradoException, FilmeNaoDisponivelException, IOException, CodigoExistenteException, ValorNegativoException;
	public Relatorio devolverEmprestimo(String codigo, String dataRecebida) throws ParseException, ValorNegativoException, FileNotFoundException, EmprestimoNaoEncontradoException, ListaIsEmptyException, IOException, FilmeNaoEncontradoException, CodigoExistenteException;
	public ArrayList<Emprestimo> listarEmprestimos() throws FileNotFoundException, ListaIsEmptyException;
	
}
