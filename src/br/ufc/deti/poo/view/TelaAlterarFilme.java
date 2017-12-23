package br.ufc.deti.poo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import br.ufc.deti.poo.exceptions.CodigoExistenteException;
import br.ufc.deti.poo.exceptions.FilmeNaoEncontradoException;
import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.exceptions.ValorNegativoException;
import br.ufc.deti.poo.model.Administrador;
import br.ufc.deti.poo.model.BlueRay;
import br.ufc.deti.poo.model.DVD;
import br.ufc.deti.poo.model.Filme;

import java.awt.Color;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class TelaAlterarFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textProcurar;
	private JLabel label;
	private JTextField textCodigo;
	private JTextField textQuantidade;
	private JFormattedTextField textDuracao;
	private JTextField textTitulo;
	private JTextField textGenero;
	private JTextField textPreco;
	private JLabel label_1;
	private JLabel label_2;
	private JRadioButton rdbtnDvd;
	private JRadioButton rdbtnBlueRay;
	private JTextArea textArea;
	private JButton button_1;
	private JButton button_2;
	private JButton btnExcluir;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private Administrador admin;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarFilme frame = new TelaAlterarFilme();
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
	public TelaAlterarFilme(Administrador adm) {
		this.admin = adm;
		setTitle("Alterar Filme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarFilme = new JLabel("Buscar Filme (c\u00F3digo): ");
		lblBuscarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBuscarFilme.setBounds(10, 14, 148, 20);
		contentPane.add(lblBuscarFilme);
		
		textProcurar = new JTextField();
		textProcurar.setBounds(168, 12, 157, 20);
		contentPane.add(textProcurar);
		textProcurar.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textProcurar.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, digite o nome do cliente");
				}
				else {
					String procurar = textProcurar.getText();
					try {
						Filme f = admin.buscarFilme(procurar);
						JOptionPane.showMessageDialog(null, "Filme encontrado!");
						textCodigo.setText(f.getCodigo());
						textQuantidade.setText(Integer.toString(f.getQuantidade()));
						textDuracao.setText(Integer.toString(f.getDuracao()));
						textTitulo.setText(f.getTitulo());
						textGenero.setText(f.getGenero());
						textArea.setText(f.getDescricao());
						textPreco.setText(Double.toString(f.getValor()));
						if(f instanceof DVD){
							rdbtnDvd.setSelected(true);
						}
						else if(f instanceof BlueRay){
							rdbtnBlueRay.setSelected(true);
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (FilmeNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ListaIsEmptyException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());	
					}
				}
			}
		});
		btnProcurar.setBounds(335, 11, 89, 23);
		contentPane.add(btnProcurar);
		
		label = new JLabel("C\u00F3digo: ");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 41, 60, 14);
		contentPane.add(label);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(68, 39, 90, 20);
		contentPane.add(textCodigo);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(207, 39, 44, 20);
		contentPane.add(textQuantidade);
		
		textDuracao = new JFormattedTextField();
		textDuracao.setBounds(364, 39, 60, 20);
		contentPane.add(textDuracao);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(68, 66, 356, 20);
		contentPane.add(textTitulo);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(68, 97, 238, 20);
		contentPane.add(textGenero);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(364, 97, 60, 20);
		contentPane.add(textPreco);
		
		label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(10, 132, 71, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Tipo:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(118, 132, 46, 14);
		contentPane.add(label_2);
		
		rdbtnDvd = new JRadioButton("DVD");
		rdbtnDvd.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnDvd.setBounds(157, 128, 58, 23);
		contentPane.add(rdbtnDvd);
		
		rdbtnBlueRay = new JRadioButton("BlueRay");
		rdbtnBlueRay.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnBlueRay.setBounds(223, 128, 78, 23);
		contentPane.add(rdbtnBlueRay);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnDvd);
		group.add(rdbtnBlueRay);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setBounds(10, 157, 414, 66);
		contentPane.add(textArea);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textCodigo.getText().equals("") || textQuantidade.getText().equals("") || textDuracao.getText().equals("") || textPreco.getText().equals("") || textGenero.getText().equals("") || textTitulo.getText().equals("") || textArea.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
				else {
					String codigo = textProcurar.getText();
					String code = textCodigo.getText();
					int quantidade = Integer.parseInt(textQuantidade.getText());
					int duracao = Integer.parseInt(textDuracao.getText());
					double valor = Double.parseDouble(textPreco.getText());
					String genero = textGenero.getText();
					String titulo = textTitulo.getText();
					String descricao = textArea.getText();
					try {
						admin.removerFilme(codigo);
						if(rdbtnDvd.isSelected()){
							admin.cadastrarDVD(code, quantidade, titulo, duracao, genero, descricao, valor);
						}
						else if(rdbtnBlueRay.isSelected()){
							admin.cadastrarBlueRay(code, quantidade, titulo, duracao, genero, descricao, valor);
						}
						JOptionPane.showMessageDialog(null, "Filme alterado com sucesso!");
					} catch (IOException e) {
						e.printStackTrace();
					} catch (FilmeNaoEncontradoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());			
					} catch (ListaIsEmptyException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (CodigoExistenteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ValorNegativoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());	
					}
				}
			}
		});
		btnAlterar.setBounds(10, 233, 98, 23);
		contentPane.add(btnAlterar);
		
		button_1 = new JButton("Limpar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCodigo.setText("");
				textQuantidade.setText("");
				textPreco.setText("");
				textGenero.setText("");
				textArea.setText("");
				textDuracao.setText("");
				textTitulo.setText("");
				label.setIcon(null);
				textProcurar.setText("");
				group.clearSelection();
			}
		});
		button_1.setBounds(118, 233, 89, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("Sair");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBounds(335, 233, 89, 23);
		contentPane.add(button_2);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigo = textProcurar.getText();
				try {
					admin.removerFilme(codigo);
					JOptionPane.showMessageDialog(null, "Filme removido com sucesso!");
					textCodigo.setText("");
					textQuantidade.setText("");
					textPreco.setText("");
					textGenero.setText("");
					textArea.setText("");
					textDuracao.setText("");
					textTitulo.setText("");
					label.setIcon(null);
					textProcurar.setText("");
					group.clearSelection();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (FilmeNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());		
				} catch (ListaIsEmptyException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnExcluir.setBounds(217, 233, 108, 23);
		contentPane.add(btnExcluir);
		
		label_4 = new JLabel("Qtd: ");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(168, 41, 39, 14);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Pre\u00E7o: ");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(313, 99, 46, 14);
		contentPane.add(label_5);
		
		label_6 = new JLabel("G\u00EAnero: ");
		label_6.setFont(new Font("Arial", Font.PLAIN, 14));
		label_6.setBounds(10, 101, 60, 14);
		contentPane.add(label_6);
		
		label_7 = new JLabel("T\u00EDtulo:");
		label_7.setFont(new Font("Arial", Font.PLAIN, 14));
		label_7.setBounds(10, 66, 46, 14);
		contentPane.add(label_7);
		
		label_8 = new JLabel("Dura\u00E7\u00E3o (min): ");
		label_8.setFont(new Font("Arial", Font.PLAIN, 14));
		label_8.setBounds(261, 41, 98, 14);
		contentPane.add(label_8);
	}

}
