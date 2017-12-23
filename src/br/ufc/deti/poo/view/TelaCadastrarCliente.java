package br.ufc.deti.poo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.ufc.deti.poo.exceptions.CpfExistenteException;
import br.ufc.deti.poo.model.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TelaCadastrarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textSobrenome;
	private JTextField textEndereco;
	private JTextField textEmail;
	private Administrador admin;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCliente frame = new TelaCadastrarCliente();
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
	 * @throws ParseException 
	 */
	public TelaCadastrarCliente(Administrador adm) throws ParseException {
		this.admin = adm;
		setTitle("Cadastrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(10, 30, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(62, 28, 125, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSobrenome.setBounds(197, 30, 82, 14);
		contentPane.add(lblSobrenome);
		
		textSobrenome = new JTextField();
		textSobrenome.setColumns(10);
		textSobrenome.setBounds(289, 28, 135, 20);
		contentPane.add(textSobrenome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCpf.setBounds(10, 72, 46, 14);
		contentPane.add(lblCpf);
		MaskFormatter mask1 = new MaskFormatter("###.###.###-##");
		JFormattedTextField textCpf = new JFormattedTextField(mask1);
		textCpf.setBounds(62, 69, 125, 20);
		contentPane.add(textCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(197, 72, 140, 14);
		contentPane.add(lblDataDeNascimento);
		
		MaskFormatter mask2 = new MaskFormatter("##/##/####");
		mask2.setPlaceholderCharacter('_');
		mask2.setValueContainsLiteralCharacters(false);
		JFormattedTextField textData = new JFormattedTextField(mask2);
		textData.setFocusLostBehavior(JFormattedTextField.COMMIT);
		textData.setBounds(340, 70, 84, 20);
		contentPane.add(textData);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEndereo.setBounds(10, 114, 74, 14);
		contentPane.add(lblEndereo);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(84, 112, 340, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 189, 64, 14);
		contentPane.add(lblTelefone);
		
		MaskFormatter mask3 = new MaskFormatter("(##) #####-####");
		JFormattedTextField textTelefone = new JFormattedTextField(mask3);
		textTelefone.setBounds(84, 187, 103, 20);
		contentPane.add(textTelefone);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(10, 154, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(62, 152, 362, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textNome.getText().equals("") || textSobrenome.getText().equals("") || textCpf.getText().equals("") || textData.getText().equals("") || textEndereco.getText().equals("") || textTelefone.getText().equals("") || textEmail.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
				else {
					String nome = textNome.getText();
					String sobrenome = textSobrenome.getText();
					String cpf = textCpf.getText();
					String data = textData.getText();
					String endereco = textEndereco.getText();
					String telefone = textTelefone.getText();
					String email = textEmail.getText();
					try {
						admin.cadastrarCliente(nome, sobrenome, cpf, data, endereco, telefone, email);
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
						textNome.setText("");
						textSobrenome.setText("");
						textCpf.setText("");
						textData.setText("");
						textEndereco.setText("");
						textEmail.setText("");
						textTelefone.setText("");
					} catch (CpfExistenteException ex){
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} catch (IOException ex){
						ex.printStackTrace();
					}
				}
			}
		});
		btnCadastrar.setBounds(10, 228, 116, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textNome.setText("");
				textSobrenome.setText("");
				textCpf.setText("");
				textData.setText("");
				textEndereco.setText("");
				textEmail.setText("");
				textTelefone.setText("");
				
			}
		});
		btnLimpar.setBounds(136, 228, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnSair.setBounds(350, 228, 74, 23);
		contentPane.add(btnSair);
		
	}
}