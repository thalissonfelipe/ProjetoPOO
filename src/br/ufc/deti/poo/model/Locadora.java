package br.ufc.deti.poo.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.ufc.deti.poo.exceptions.*;
import br.ufc.deti.poo.interfaces.InterfaceLocadora;

public class Locadora implements InterfaceLocadora{

	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ArrayList<Filme> listaFilmes = new ArrayList<Filme>();
	private ArrayList<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>(); 
	
	ControladorArquivo arq = new ControladorArquivo();
	
	public Locadora(ArrayList<Cliente> cliente, ArrayList<Filme> filme, ArrayList<Emprestimo> emprestimo){
		this.listaClientes = cliente;
		this.listaFilmes = filme;
		this.listaEmprestimos = emprestimo;
	}
	
	public void adicionarCliente(Cliente cliente) throws CpfExistenteException, IOException{
		this.listaClientes = arq.recuperaClientes();
		for(Cliente c : this.listaClientes){
			if(cliente.getCpf().equals(c.getCpf())) throw new CpfExistenteException();
		}
		arq.persisteCliente(cliente, true);
	}
	
	public void excluirCliente(String nome) throws IOException, ClienteNaoEncontradoException, ListaIsEmptyException{
		this.listaClientes = arq.recuperaClientes();
		Cliente c = buscarCliente(nome);
		this.listaClientes.remove(c);
		arq.clearFile("arquivos//clientes.txt");
		for(Cliente cliente : this.listaClientes){
			arq.persisteCliente(cliente, true);
		}
	}
	 
	public Cliente buscarCliente(String nome) throws FileNotFoundException, ClienteNaoEncontradoException, ListaIsEmptyException{
		this.listaClientes = arq.recuperaClientes();
		if(!listaClientes.isEmpty()){
			for(Cliente c : this.listaClientes){
				if(c.getNome().equals(nome)){
					return c;
				}
			}
			throw new ClienteNaoEncontradoException();
		}
		else throw new ListaIsEmptyException("clientes");
	}
	
	public ArrayList<Cliente> listarClientes() throws FileNotFoundException, ListaIsEmptyException{
		this.listaClientes = arq.recuperaClientes();
		if(this.listaClientes.isEmpty()) throw new ListaIsEmptyException("clientes");
		return listaClientes;
	}
	
	public void cadastrarFilme(Filme filme) throws CodigoExistenteException, ValorNegativoException, FileNotFoundException{
		this.listaFilmes = arq.recuperaFilmes();
		for(Filme f : this.listaFilmes){
			if(f.getCodigo().equals(filme.getCodigo())) throw new CodigoExistenteException();
		}
		arq.persisteFilme(filme, true);
	}
	
	public void excluirFilme(String codigo) throws IOException, FilmeNaoEncontradoException, ListaIsEmptyException{
		this.listaFilmes = arq.recuperaFilmes();
		Filme f = buscarFilme(codigo);
		this.listaFilmes.remove(f);
		arq.clearFile("arquivos//filmes.txt");
		for(Filme filme : this.listaFilmes){
			arq.persisteFilme(filme, true);
		}
	}
	
	public Filme buscarFilme(String codigo) throws FileNotFoundException, FilmeNaoEncontradoException, ListaIsEmptyException{
		this.listaFilmes = arq.recuperaFilmes();
		if(!listaFilmes.isEmpty()){
			for(Filme f : this.listaFilmes){
				if(f.getCodigo().equals(codigo)){
					return f;
				}
			}
			throw new FilmeNaoEncontradoException();
		}
		else throw new ListaIsEmptyException("filmes");
	}
	
	public ArrayList<Filme> listarFilmes() throws FileNotFoundException, ListaIsEmptyException{
		this.listaFilmes = arq.recuperaFilmes();
		if(this.listaFilmes.isEmpty()) throw new ListaIsEmptyException("filmes");
		return this.listaFilmes;
	}
	
	public Emprestimo buscarEmprestimo(String codigoEmp) throws FileNotFoundException, EmprestimoNaoEncontradoException, ListaIsEmptyException{
		this.listaEmprestimos = arq.recuperaEmprestimos();
		if(!this.listaEmprestimos.isEmpty()){
			for(Emprestimo e : this.listaEmprestimos){
				if(e.getCodigo().equals(codigoEmp)){
					return e;
				}
			}
			throw new EmprestimoNaoEncontradoException();
		}
		else throw new ListaIsEmptyException("emprestimos");
	}
	
	public void realizarLocacao(String nome, String codigoF, String codigoEmp) throws ClienteNaoEncontradoException, ListaIsEmptyException, FilmeNaoEncontradoException, FilmeNaoDisponivelException, IOException, CodigoExistenteException, ValorNegativoException{
		Calendar data = Calendar.getInstance();
		Calendar dataDev = Calendar.getInstance();
		Cliente c = buscarCliente(nome);
		Filme f = buscarFilme(codigoF);
		if(f.getQuantidade() != 0){
			Emprestimo emp = new Emprestimo(codigoEmp);
			emp.setDataEmprestimo(data);
			dataDev.add(Calendar.DATE, +7);
			emp.setDataDevolucao(dataDev);
			emp.setCliente(c);
			emp.setFilme(f); 
			arq.persisteEmprestimo(emp, true);
			f.setQuantidade(f.getQuantidade() - 1);
			f.setNumeroLoc(f.getNumeroLoc() + 1);
			if(f.getQuantidade() == 0) f.setDisponivel(false);
			excluirFilme(codigoF);
			cadastrarFilme(f);
		}
		else throw new FilmeNaoDisponivelException();
	}
	
	public void excluirEmprestimo(String codigo) throws EmprestimoNaoEncontradoException, ListaIsEmptyException, IOException{
		this.listaEmprestimos = arq.recuperaEmprestimos();
		Emprestimo e = buscarEmprestimo(codigo);
		this.listaEmprestimos.remove(e);
		arq.clearFile("arquivos//emprestimos.txt");
		for(Emprestimo emp : this.listaEmprestimos){
			arq.persisteEmprestimo(emp, true);
		}
	}
	
	public Relatorio devolverLocacao(String codigoEmp, String dataRecebida) throws ParseException, ValorNegativoException, EmprestimoNaoEncontradoException, ListaIsEmptyException, IOException, FilmeNaoEncontradoException, CodigoExistenteException{
		double total = 0;
		//Formatando a data
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		Date date = formato.parse(dataRecebida);
		calendar.setTime(date);
		Emprestimo emp = buscarEmprestimo(codigoEmp);
		emp.setDataDevolucaoEfetiva(calendar);
		//Incrementando a quantidade do filme
		String codigo = emp.getFilme().getCodigo();
		Filme f = buscarFilme(codigo);
		f.setQuantidade(f.getQuantidade() + 1);
		//Compara os dias para saber se tem multa
		//O prazo para devolução são de 7 dias, caso o cliente entregue depois desse dia
		//será cobrado 5 reais por dia de atraso
		int x = emp.getDataDevolucao().compareTo(emp.getDataDevolucaoEfetiva());
		if(x == 0 || x == 1){
			emp.setMulta(0);
		}
		else if(x == -1){
			int diferenca =  emp.getDataDevolucaoEfetiva().get(Calendar.DAY_OF_MONTH) - emp.getDataDevolucao().get(Calendar.DAY_OF_MONTH);
			emp.setMulta(diferenca * 5);				
		}
		total = emp.getFilme().taxaAdicional() + emp.getMulta();
		excluirFilme(codigo);
		cadastrarFilme(f);
		//Cria relatório
		Relatorio relatorio = new Relatorio();
		relatorio.setNomeCliente(emp.getCliente().getNome() + "" + emp.getCliente().getSobrenome());
		relatorio.setNomeFilme(f.getTitulo());
		relatorio.setDataRecebida(dataRecebida);
		relatorio.setValorFilme(f.getValor());
		relatorio.setMulta(emp.getMulta());
		relatorio.setTotal(total);
		relatorio.setCodigoEmp(codigoEmp);
		//Empréstimo devolvido, exclui da lista
		excluirEmprestimo(codigoEmp);
		return relatorio;
	}
	
	public ArrayList<Emprestimo> listarEmprestimos() throws FileNotFoundException, ListaIsEmptyException{
		this.listaEmprestimos = arq.recuperaEmprestimos();
		if(this.listaEmprestimos.isEmpty()) throw new ListaIsEmptyException("emprestimos");
		return this.listaEmprestimos;
	}
	
}
