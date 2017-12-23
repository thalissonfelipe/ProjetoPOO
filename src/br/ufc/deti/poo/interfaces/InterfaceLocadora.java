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

public interface InterfaceLocadora {
		
	public void adicionarCliente(Cliente cliente) throws CpfExistenteException, IOException;
	public void excluirCliente(String nome) throws IOException, ClienteNaoEncontradoException, ListaIsEmptyException;
	public Cliente buscarCliente(String nome) throws FileNotFoundException, IOException, ClienteNaoEncontradoException, ListaIsEmptyException;		
	public ArrayList<Cliente> listarClientes() throws FileNotFoundException, IOException, ListaIsEmptyException;
	public void cadastrarFilme(Filme filme) throws CodigoExistenteException, ValorNegativoException, FileNotFoundException;
	public void excluirFilme(String titulo) throws IOException, FilmeNaoEncontradoException, ListaIsEmptyException;
	public Filme buscarFilme(String titulo) throws FileNotFoundException, FilmeNaoEncontradoException, ListaIsEmptyException;
	public ArrayList<Filme> listarFilmes() throws FileNotFoundException, ListaIsEmptyException;
	public Emprestimo buscarEmprestimo(String codigo) throws FileNotFoundException, EmprestimoNaoEncontradoException, ListaIsEmptyException;
	public void realizarLocacao(String nome, String titulo, String codigo) throws IOException, ClienteNaoEncontradoException, ListaIsEmptyException, FilmeNaoEncontradoException, FilmeNaoDisponivelException, CodigoExistenteException, ValorNegativoException;
	public Relatorio devolverLocacao(String codigo, String dataRecebida) throws ParseException, ValorNegativoException, FileNotFoundException, EmprestimoNaoEncontradoException, ListaIsEmptyException, IOException, FilmeNaoEncontradoException, CodigoExistenteException;
	public ArrayList<Emprestimo> listarEmprestimos() throws FileNotFoundException, ListaIsEmptyException;
	public void excluirEmprestimo(String codigo) throws EmprestimoNaoEncontradoException, ListaIsEmptyException, IOException;
}
