package br.ufc.deti.poo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.model.Administrador;
import br.ufc.deti.poo.model.Cliente;
import br.ufc.deti.poo.model.Emprestimo;
import br.ufc.deti.poo.model.Filme;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public class TelaListar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Cliente> clientes;
	private ArrayList<Filme> filmes;
	private ArrayList<Emprestimo> emprestimos;
	private Administrador admin;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListar frame = new TelaListar();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaListar(Administrador adm) {
		this.admin = adm;
		setTitle("Listar Clientes, Filmes e Empr\u00E9stimos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 414, 163);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnListarClientes = new JButton("Clientes");
		btnListarClientes.setBounds(10, 11, 111, 23);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String conteudo = "---------------------------------- LISTA DE CLIENTES -----------------------------------\n\n";
				try {
					clientes = admin.listarClientes();
					for(Cliente c : clientes){
						conteudo += c + "\n";
					}				
					textArea.setText(conteudo);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ListaIsEmptyException e) {
					textArea.setText("Lista de clientes vazia!");
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnListarClientes);
		
		JButton btnListarFilmes = new JButton("Filmes");
		btnListarFilmes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String conteudo = "------------------------------------ LISTA DE FILMES -------------------------------------\n\n";
					filmes = admin.listarFilmes();
					for(Filme f : filmes){
						conteudo += f + "\n";
					}				
					textArea.setText(conteudo);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ListaIsEmptyException e) {
					textArea.setText("Lista de filmes vazia!");
				}
			}
		});
		btnListarFilmes.setBounds(161, 11, 111, 23);
		contentPane.add(btnListarFilmes);
		
		JButton btnListarEmprstimos = new JButton("Empr\u00E9stimos");
		btnListarEmprstimos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String conteudo = "--------------------------------- LISTA DE EMPRÉSTIMOS ---------------------------------\n\n";
					emprestimos = admin.listarEmprestimos();
					for(Emprestimo emp : emprestimos){
						conteudo += emp + "\n";
					}				
					textArea.setText(conteudo);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ListaIsEmptyException e) {
					textArea.setText("Lista de empréstimos vazia!");
				}
			}
		});
		btnListarEmprstimos.setBounds(313, 11, 111, 23);
		contentPane.add(btnListarEmprstimos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPrincipal tela;
				try {
					tela = new TelaPrincipal(admin);
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
					dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSair.setBounds(342, 233, 82, 23);
		contentPane.add(btnSair);
		
	}
}
