package br.ufc.deti.poo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import br.ufc.deti.poo.exceptions.CodigoExistenteException;
import br.ufc.deti.poo.exceptions.ValorNegativoException;
import br.ufc.deti.poo.model.Administrador;

public class TelaCadastrarFilme extends JFrame implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textQuantidade;
	private JTextField textTitulo;
	private JTextField textGenero;
	private JTextField textPreco;
	private Administrador admin;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarFilme frame = new TelaCadastrarFilme();
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
	public TelaCadastrarFilme(Administrador adm) throws ParseException {
		this.admin = adm;
		setTitle("Cadastrar Filme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo: ");
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 13, 60, 14);
		contentPane.add(lblCdigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(68, 11, 90, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Qtd: ");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuantidade.setBounds(168, 13, 39, 14);
		contentPane.add(lblQuantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(207, 11, 44, 20);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTtulo.setBounds(10, 52, 46, 14);
		contentPane.add(lblTtulo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(68, 50, 356, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero: ");
		lblGnero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGnero.setBounds(10, 92, 60, 14);
		contentPane.add(lblGnero);
		
		textGenero = new JTextField();
		textGenero.setBounds(68, 90, 230, 20);
		contentPane.add(textGenero);
		textGenero.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o: ");
		lblPreo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPreo.setBounds(308, 92, 46, 14);
		contentPane.add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setBounds(364, 90, 60, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 127, 71, 14);
		contentPane.add(lblDescrio);
		
		JTextArea textDescricao = new JTextArea();
		textDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textDescricao.setLineWrap(true);
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		textDescricao.setBounds(10, 151, 414, 66);
		contentPane.add(textDescricao);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o (min): ");
		lblDurao.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDurao.setBounds(261, 13, 98, 14);
		contentPane.add(lblDurao);
		
		JFormattedTextField textDuracao = new JFormattedTextField();
		textDuracao.setBounds(364, 11, 60, 20);
		contentPane.add(textDuracao);
		
		JRadioButton rdbtnDvd = new JRadioButton("DVD");
		rdbtnDvd.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnDvd.setBounds(157, 123, 58, 23);
		contentPane.add(rdbtnDvd);
		
		JRadioButton rdbtnBlueray = new JRadioButton("BlueRay");
		rdbtnBlueray.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnBlueray.setBounds(223, 123, 78, 23);
		contentPane.add(rdbtnBlueray);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnDvd);
		btnGroup.add(rdbtnBlueray);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textCodigo.getText().equals("") || textQuantidade.getText().equals("") || textDuracao.getText().equals("") || textPreco.getText().equals("") || textGenero.getText().equals("") || textTitulo.getText().equals("") || textDescricao.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
				else {
					String codigo = textCodigo.getText();
					int quantidade = Integer.parseInt(textQuantidade.getText());
					int duracao = Integer.parseInt(textDuracao.getText());
					double valor = Double.parseDouble(textPreco.getText());
					String genero = textGenero.getText();
					String titulo = textTitulo.getText();
					String descricao = textDescricao.getText();
					try {
						if(rdbtnDvd.isSelected()){
							admin.cadastrarDVD(codigo, quantidade, titulo, duracao, genero, descricao, valor);
							JOptionPane.showMessageDialog(null, "Filme 'DVD' cadastrado com sucesso!");
						}
						else if(rdbtnBlueray.isSelected()){
							admin.cadastrarBlueRay(codigo, quantidade, titulo, duracao, genero, descricao, valor);
							JOptionPane.showMessageDialog(null, "Filme 'BlueRay' cadastrado com sucesso!");
						}
						textCodigo.setText("");
						textQuantidade.setText("");
						textPreco.setText("");
						textGenero.setText("");
						textDescricao.setText("");
						textDuracao.setText("");
						textTitulo.setText("");
						btnGroup.clearSelection();
					} catch (CodigoExistenteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());			
					} catch(ValorNegativoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(10, 228, 98, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCodigo.setText("");
				textQuantidade.setText("");
				textPreco.setText("");
				textGenero.setText("");
				textDescricao.setText("");
				textDuracao.setText("");
				textTitulo.setText("");
				btnGroup.clearSelection();
			}
		});
		btnLimpar.setBounds(118, 228, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnSair.setBounds(335, 228, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(118, 127, 46, 14);
		contentPane.add(lblNewLabel);
	
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}