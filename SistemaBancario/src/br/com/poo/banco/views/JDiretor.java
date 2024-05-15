package br.com.poo.banco.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDiretor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldCpd;
	private JTextField textField_1;
	private JTextField textFieldSalario;
	private JPasswordField passwordFieldDiretor;
	private JPasswordField passwordFieldCSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDiretor frame = new JDiretor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JDiretor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonVoltar = new JButton("Voltar");
		ButtonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JLogin jLog = new JLogin();
				jLog.setLocationRelativeTo(jLog);
				jLog.setVisible(true);
			}
		});
		ButtonVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonVoltar.setBackground(UIManager.getColor("Button.background"));
		ButtonVoltar.setBounds(211, 373, 89, 23);
		contentPane.add(ButtonVoltar);
		
		JButton ButtonCadastrar = new JButton("Cadastrar");
		ButtonCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonCadastrar.setBackground(new Color(240, 240, 240));
		ButtonCadastrar.setBounds(79, 373, 89, 23);
		contentPane.add(ButtonCadastrar);
		
		JLabel JDiretor = new JLabel("Diretor");
		JDiretor.setForeground(new Color(0, 0, 128));
		JDiretor.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		JDiretor.setBounds(180, 11, 113, 37);
		contentPane.add(JDiretor);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("./imagens/logo.png"));
		Logo.setBounds(418, 373, 56, 47);
		contentPane.add(Logo);
		
		passwordFieldCSenha = new JPasswordField();
		passwordFieldCSenha.setBounds(128, 311, 159, 20);
		contentPane.add(passwordFieldCSenha);
		
		JLabel textConfirmaSenha = new JLabel("Confirme sua senha: ");
		textConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		textConfirmaSenha.setBounds(10, 314, 128, 14);
		contentPane.add(textConfirmaSenha);
		
		passwordFieldDiretor = new JPasswordField();
		passwordFieldDiretor.setBounds(53, 271, 159, 20);
		contentPane.add(passwordFieldDiretor);
		
		JLabel textSenha = new JLabel("Senha:");
		textSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		textSenha.setBounds(10, 274, 46, 14);
		contentPane.add(textSenha);
		
		JLabel textSalario = new JLabel("Salário:");
		textSalario.setFont(new Font("Tahoma", Font.BOLD, 11));
		textSalario.setBounds(10, 237, 46, 14);
		contentPane.add(textSalario);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(63, 234, 237, 20);
		contentPane.add(textFieldSalario);
		
		JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"Selecione um tipo:", "Gerente"}));
		comboBoxCargo.setBounds(53, 194, 237, 22);
		contentPane.add(comboBoxCargo);
		
		JLabel LabelCargo = new JLabel("Cargo:");
		LabelCargo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelCargo.setBounds(10, 198, 46, 14);
		contentPane.add(LabelCargo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 151, 237, 20);
		contentPane.add(textField_1);
		
		JLabel textemail = new JLabel("E-mail:");
		textemail.setFont(new Font("Tahoma", Font.BOLD, 11));
		textemail.setBounds(10, 154, 46, 14);
		contentPane.add(textemail);
		
		textFieldCpd = new JTextField();
		textFieldCpd.setColumns(10);
		textFieldCpd.setBounds(53, 115, 237, 20);
		contentPane.add(textFieldCpd);
		
		textField = new JTextField();
		textField.setBounds(53, 74, 237, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel textDiretor = new JLabel("Nome:");
		textDiretor.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDiretor.setBounds(10, 77, 46, 14);
		contentPane.add(textDiretor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, 0, 484, 432);
		contentPane.add(lblNewLabel);
		
		JLabel textCpf = new JLabel("CPF:");
		textCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCpf.setBounds(10, 118, 46, 14);
		contentPane.add(textCpf);
	}
}
