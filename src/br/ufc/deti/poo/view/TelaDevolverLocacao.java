package br.ufc.deti.poo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.ufc.deti.poo.exceptions.CodigoExistenteException;
import br.ufc.deti.poo.exceptions.EmprestimoNaoEncontradoException;
import br.ufc.deti.poo.exceptions.FilmeNaoEncontradoException;
import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.exceptions.ValorNegativoException;
import br.ufc.deti.poo.model.Administrador;
import br.ufc.deti.poo.model.Relatorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TelaDevolverLocacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Administrador admin;
	Relatorio relatorio = new Relatorio();
	private JTextField textCodigo;
	private JLabel lblDataDeDevoluo;
	private JButton btnDevolver;
	private JButton btnSair;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDevolverLocacao frame = new TelaDevolverLocacao();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaDevolverLocacao(Administrador adm) throws ParseException {
		this.admin = adm;
		setTitle("Devolver Loca\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo do empr\u00E9stimo: ");
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCdigo.setBounds(81, 76, 150, 17);
		contentPane.add(lblCdigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(241, 75, 86, 23);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		lblDataDeDevoluo = new JLabel("Data de devolu\u00E7\u00E3o: ");
		lblDataDeDevoluo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDataDeDevoluo.setBounds(81, 111, 150, 14);
		contentPane.add(lblDataDeDevoluo);
		
		MaskFormatter mask = new MaskFormatter("##/##/####");
		mask.setPlaceholderCharacter('_');
		mask.setValueContainsLiteralCharacters(false);
		JFormattedTextField textData = new JFormattedTextField(mask);
		textData.setBounds(241, 109, 86, 23);
		contentPane.add(textData);
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textCodigo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
				}
				else {
					try {
						String codigoEmp = textCodigo.getText();
						String dataRecebida = textData.getText();
						Relatorio relatorio = null;
						relatorio = admin.devolverEmprestimo(codigoEmp, dataRecebida);
						int resposta = JOptionPane.showConfirmDialog(null, "Filme devolvido com sucesso!\nDeseja ver o relatório de devolução?", null, JOptionPane.YES_NO_OPTION);
						if(resposta == JOptionPane.YES_OPTION) JOptionPane.showMessageDialog(null, relatorio);
						textCodigo.setText("");
						textData.setText("");
					} catch (ParseException e1) {
						e1.printStackTrace();
					} catch (ValorNegativoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (EmprestimoNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ListaIsEmptyException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (FilmeNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CodigoExistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnDevolver.setBounds(81, 146, 100, 23);
		contentPane.add(btnDevolver);
		
		btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textCodigo.getText().equals("")){
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
				else {
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
			}
		});
		btnSair.setBounds(335, 227, 89, 23);
		contentPane.add(btnSair);
		
	}
}
