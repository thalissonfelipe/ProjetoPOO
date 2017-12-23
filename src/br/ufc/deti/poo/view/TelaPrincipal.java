package br.ufc.deti.poo.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.deti.poo.model.Administrador;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Administrador admin;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	 * @param adm 
	 * @throws ParseException 
	 */
	public TelaPrincipal(Administrador adm) throws ParseException {
		this.admin = adm;
		
		setTitle("Gerenciador de Video Locadora");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarCliente tela;
				try {
					tela = new TelaCadastrarCliente(admin);
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
					dispose();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});

		mnCadastrar.add(mntmCliente);
		mntmCliente.setIcon(new ImageIcon("icones//iconeCliente.ico"));
		
		JMenuItem mntmFilme = new JMenuItem("Filme");
		mntmFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarFilme tela;
				try {
					tela = new TelaCadastrarFilme(admin);
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
					dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnCadastrar.add(mntmFilme);
		mntmFilme.setIcon(new ImageIcon("icones//iconeFilme.ico"));
		
		JMenu mnEmprstimo = new JMenu("Empr\u00E9stimo");
		menuBar.add(mnEmprstimo);
		
		JMenuItem mntmLocar = new JMenuItem("Locar");
		mntmLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLocacao tela = new TelaLocacao(admin);
				tela.setVisible(true);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
				dispose();
			}
		});
		mntmLocar.setIcon(new ImageIcon("icones//iconeLocar.ico"));
		mnEmprstimo.add(mntmLocar);
		
		JMenuItem mntmDevolver = new JMenuItem("Devolver");
		mntmDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDevolverLocacao tela;
				try {
					tela = new TelaDevolverLocacao(admin);
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
					dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmDevolver.setIcon(new ImageIcon("icones//iconeDevolver.ico"));
		mnEmprstimo.add(mntmDevolver);
		
		JMenu mnAlterar = new JMenu("Alterar");
		menuBar.add(mnAlterar);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlterarCliente tela;
				try {
					tela = new TelaAlterarCliente(admin);
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
					dispose();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
		});
		mntmCliente_1.setIcon(new ImageIcon("icones//iconeCliente.ico"));
		mnAlterar.add(mntmCliente_1);
		
		JMenuItem mntmFilme_1 = new JMenuItem("Filme");
		mntmFilme_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterarFilme tela = new TelaAlterarFilme(admin);
				tela.setVisible(true);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
				dispose();
			}
		});
		mntmFilme_1.setIcon(new ImageIcon("icones//iconeFilme.ico"));
		mnAlterar.add(mntmFilme_1);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmClientes = new JMenuItem("Listar");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListar tela = new TelaListar(admin);
				tela.setVisible(true);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
				dispose();
			}
		});
		mntmClientes.setIcon(new ImageIcon("icones//iconeListar.ico"));
		mnListar.add(mntmClientes);
	}
}
