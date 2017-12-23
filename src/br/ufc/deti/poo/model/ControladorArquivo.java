package br.ufc.deti.poo.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControladorArquivo {

	private FileInputStream fileInputStream; 
	private FileOutputStream fileOutputStream;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	public ArrayList<Cliente> recuperaClientes(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		File file = new File("arquivos//clientes.txt");
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		while(true){
			try {
				objectInputStream =  new ObjectInputStream(fileInputStream);
				Cliente c = (Cliente)objectInputStream.readObject();
				clientes.add(c);
			}
			catch(Exception e){
				e.getMessage();
				break;
			}
		}
		return clientes;
	}

	public ArrayList<Filme> recuperaFilmes() throws FileNotFoundException{
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		File file = new File("arquivos//filmes.txt");
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		while(true){
			try {
				objectInputStream =  new ObjectInputStream(fileInputStream);
				Filme f = (Filme)objectInputStream.readObject();
				filmes.add(f);
			}
			catch(Exception e){
				e.getMessage();
				break;
			}
		}
		return filmes;
	}
	
	public ArrayList<Emprestimo> recuperaEmprestimos() throws FileNotFoundException{
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		File file = new File("arquivos//emprestimos.txt"); 
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		while(true){
			try {
				objectInputStream =  new ObjectInputStream(fileInputStream);
				Emprestimo emp = (Emprestimo)objectInputStream.readObject();
				emprestimos.add(emp);
			}
			catch(Exception e){
				e.getMessage();
				break;
			}
		}
		return emprestimos;
	}
	
	public void persisteCliente(Cliente c, boolean append){
		File file = new File("arquivos//clientes.txt");
		try {
			fileOutputStream = new FileOutputStream(file, append);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(c);
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public void persisteFilme(Filme f, boolean append){
		File file = new File("arquivos//filmes.txt");
		try {
			fileOutputStream = new FileOutputStream(file, append);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(f);
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public void persisteEmprestimo(Emprestimo emp, boolean append){
		File file = new File("arquivos//emprestimos.txt");
		try {
			fileOutputStream = new FileOutputStream(file, append);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(emp);
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public void clearFile(String caminho) throws IOException{
		fileOutputStream = new FileOutputStream(caminho, false);
		fileOutputStream.close();
	}
	
}
