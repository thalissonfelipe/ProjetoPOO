package br.ufc.deti.poo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.deti.poo.exceptions.ClienteNaoEncontradoException;
import br.ufc.deti.poo.exceptions.CodigoExistenteException;
import br.ufc.deti.poo.exceptions.FilmeNaoDisponivelException;
import br.ufc.deti.poo.exceptions.FilmeNaoEncontradoException;
import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.exceptions.ValorNegativoException;
import br.ufc.deti.poo.model.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class TelaLocacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCliente;
	private JTextField textFilme;
	private JTextField textCodigo;
	private Administrador admin;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLocacao frame = new TelaLocacao();
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
	public TelaLocacao(Administrador adm) {
		this.admin = adm;
		setResizable(false);
		setTitle("Loca\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do cliente:");
		lblNomeDoCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeDoCliente.setBounds(95, 50, 116, 14);
		contentPane.add(lblNomeDoCliente);
		
		textCliente = new JTextField();
		textCliente.setBounds(209, 48, 129, 20);
		contentPane.add(textCliente);
		textCliente.setColumns(10);
		
		JLabel lblTtuloDoFilme = new JLabel("C\u00F3digo do filme:");
		lblTtuloDoFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTtuloDoFilme.setBounds(95, 87, 103, 14);
		contentPane.add(lblTtuloDoFilme);
		
		textFilme = new JTextField();
		textFilme.setBounds(209, 85, 129, 20);
		contentPane.add(textFilme);
		textFilme.setColumns(10);
		
		JLabel lblCdigoDoEmprstimo = new JLabel("C\u00F3digo do Empr\u00E9stimo: ");
		lblCdigoDoEmprstimo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCdigoDoEmprstimo.setBounds(95, 119, 160, 17);
		contentPane.add(lblCdigoDoEmprstimo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(251, 116, 87, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnRealizarLocao = new JButton("Realizar Loca\u00E7\u00E3o");
		btnRealizarLocao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textCliente.getText().equals("") || textFilme.getText().equals("") || textCodigo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
				}
				else {
					String nome = textCliente.getText();
					String titulo = textFilme.getText();
					String codigo = textCodigo.getText();
					try {
						admin.realizarEmprestimo(nome, titulo, codigo);
						JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
						textCliente.setText("");
						textFilme.setText("");
						textCodigo.setText("");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (ClienteNaoEncontradoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ListaIsEmptyException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (FilmeNaoEncontradoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (FilmeNaoDisponivelException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CodigoExistenteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ValorNegativoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}	
				}
			}
		});
		btnRealizarLocao.setBounds(95, 163, 146, 23);
		contentPane.add(btnRealizarLocao);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCliente.setText("");
				textFilme.setText("");
				textCodigo.setText("");
			}
		});
		btnLimpar.setBounds(251, 163, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", null, JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
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
			}
		});
		btnSair.setBounds(363, 227, 61, 23);
		contentPane.add(btnSair);
	}

}
