package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.io.LeituraEscrita;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class JSaqPou extends JFrame {
//Mensagem de saldo na tela 
	//tela de aviso: saque efetuado com sucesso ou não e por que?
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public JSaqPou(Cliente c, ContaPoupanca cp, Double rendimento) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JContaPoupanca jConPou = new JContaPoupanca(c ,cp ,0.00002);
				jConPou.setLocationRelativeTo(jConPou);
				jConPou.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/logo.png"));
		lblNewLabel_4.setBounds(418, 373, 56, 47);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sim");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBounds(291, 195, 47, 23);
		contentPane.add(chckbxNewCheckBox);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(251, 282, 113, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor = Double.parseDouble(textField.getText());
				cp.sacar(valor);
				try {
					LeituraEscrita.comprovanteSaqPou(cp, valor);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showConfirmDialog(btnNewButton, "Saque realizado com sucesso.");
				
				//adicionar telinha extra de visualizar comprov saque
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(68, 282, 113, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Saque Conta Poupança");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		lblNewLabel_1.setBounds(85, 11, 371, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lmpComp = new JLabel("Deseja imprimir o comprovante de");
		lmpComp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lmpComp.setBounds(57, 195, 212, 14);
		contentPane.add(lmpComp);
		
		JLabel ImpComprov = new JLabel("saque ao finalizar a transação?");
		ImpComprov.setFont(new Font("Tahoma", Font.BOLD, 12));
		ImpComprov.setBounds(57, 209, 212, 14);
		contentPane.add(ImpComprov);
		
		JLabel lblNewLabel_3 = new JLabel("Valor do saque:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(57, 134, 97, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(156, 132, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Seu saldo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(57, 91, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, -20, 625, 452);
		contentPane.add(lblNewLabel);
	}
}
