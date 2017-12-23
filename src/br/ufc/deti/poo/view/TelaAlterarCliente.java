package br.ufc.deti.poo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.ufc.deti.poo.exceptions.ClienteNaoEncontradoException;
import br.ufc.deti.poo.exceptions.CpfExistenteException;
import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.model.Administrador;
import br.ufc.deti.poo.model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class TelaAlterarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textProcurar;
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
					TelaAlterarCliente frame = new TelaAlterarCliente();
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
	public TelaAlterarCliente(Administrador adm) throws ParseException {
		this.admin = adm;
		setTitle("Alterar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarcliente = new JLabel("Buscar Cliente (nome):");
		lblBuscarcliente.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBuscarcliente.setBounds(10, 13, 152, 14);
		contentPane.add(lblBuscarcliente);
		
		textProcurar = new JTextField();
		textProcurar.setBounds(166, 11, 144, 20);
		contentPane.add(textProcurar);
		textProcurar.setColumns(10);
		
		JLabel label = new JLabel("Nome: ");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 49, 46, 14);
		contentPane.add(label);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(62, 47, 125, 20);
		contentPane.add(textNome);
		
		JLabel label_1 = new JLabel("Sobrenome:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(197, 49, 82, 14);
		contentPane.add(label_1);
		
		textSobrenome = new JTextField();
		textSobrenome.setColumns(10);
		textSobrenome.setBounds(289, 47, 135, 20);
		contentPane.add(textSobrenome);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(10, 91, 46, 14);
		contentPane.add(label_2);
		
		MaskFormatter mask1 = new MaskFormatter("###.###.###-##");
		JFormattedTextField textCpf = new JFormattedTextField(mask1);
		textCpf.setBounds(62, 88, 125, 20);
		contentPane.add(textCpf);
		
		MaskFormatter mask2 = new MaskFormatter("##/##/####");
		mask2.setPlaceholderCharacter('_');
		JLabel label_3 = new JLabel("Data de Nascimento:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(197, 91, 140, 14);
		contentPane.add(label_3);
		
		JFormattedTextField textData = new JFormattedTextField(mask2);
		textData.setFocusLostBehavior(JFormattedTextField.COMMIT);
		textData.setBounds(340, 89, 84, 20);
		contentPane.add(textData);
		
		JLabel label_4 = new JLabel("Endere\u00E7o:");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(10, 129, 74, 14);
		contentPane.add(label_4);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(84, 127, 246, 20);
		contentPane.add(textEndereco);
		
		JLabel label_5 = new JLabel("Telefone: ");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(10, 200, 64, 14);
		contentPane.add(label_5);
		
		MaskFormatter mask3 = new MaskFormatter("(##) #####-####");
		JFormattedTextField textTelefone = new JFormattedTextField(mask3);
		textTelefone.setBounds(84, 198, 103, 20);
		contentPane.add(textTelefone);
		
		JLabel label_6 = new JLabel("Email: ");
		label_6.setFont(new Font("Arial", Font.PLAIN, 14));
		label_6.setBounds(10, 164, 46, 14);
		contentPane.add(label_6);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(62, 162, 362, 20);
		contentPane.add(textEmail);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textNome.getText().equals("") || textSobrenome.getText().equals("") || textCpf.getText().equals("") || textData.getText().equals("") || textEndereco.getText().equals("") || textTelefone.getText().equals("") || textEmail.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
				else{
					String nome = textProcurar.getText();
					String name = textNome.getText();
					String sobrenome = textSobrenome.getText();
					String cpf = textCpf.getText();
					String dataNasc = textData.getText();
					String endereco = textEndereco.getText();
					String telefone = textTelefone.getText();
					String email = textEmail.getText();
					try {
						admin.removerCliente(nome);
						admin.cadastrarCliente(name, sobrenome, cpf, dataNasc, endereco, telefone, email);
						JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
					} catch (ListaIsEmptyException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClienteNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CpfExistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}						
				}
			}
		});
		btnAlterar.setBounds(10, 227, 116, 23);
		contentPane.add(btnAlterar);
		
		JButton button_1 = new JButton("Limpar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNome.setText("");
				textSobrenome.setText("");
				textCpf.setText("");
				textData.setText("");
				textEndereco.setText("");
				textEmail.setText("");
				textTelefone.setText("");
				textProcurar.setText("");
			}
		});
		button_1.setBounds(136, 227, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Sair");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", null, JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					TelaPrincipal tela;
					try {
						tela = new TelaPrincipal(adm);
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
		button_2.setBounds(340, 227, 84, 23);
		contentPane.add(button_2);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textProcurar.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, digite o nome do cliente!");
				}
				else {
					String procurar = textProcurar.getText();
					try {
						Cliente c = admin.buscarCliente(procurar);
						JOptionPane.showMessageDialog(null, "Cliente encontrado!");
						textNome.setText(c.getNome());
						textSobrenome.setText(c.getSobrenome());
						textCpf.setText(c.getCpf());
						textData.setText(c.getDataNasc());
						textEndereco.setText(c.getEndereco());
						textEmail.setText(c.getEmail());
						textTelefone.setText(c.getTelefone());		
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (ListaIsEmptyException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ClienteNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());			
					}		
				}
			}
		});
		btnProcurar.setBounds(320, 10, 104, 23);
		contentPane.add(btnProcurar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String nome = textNome.getText();
					admin.removerCliente(nome);
					JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
					textNome.setText("");
					textSobrenome.setText("");
					textCpf.setText("");
					textData.setText("");
					textEndereco.setText("");
					textEmail.setText("");
					textTelefone.setText("");
					textProcurar.setText("");
				} catch (ListaIsEmptyException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClienteNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnExcluir.setBounds(241, 227, 89, 23);
		contentPane.add(btnExcluir);
	}
}
