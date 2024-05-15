package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.pessoas.Cliente;
import javax.swing.JTextField;

public class JRend extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JRend(Cliente c, Conta c1) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Simular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor = Double.parseDouble(textField.getText());
				Integer dias = Integer.parseInt(textField_1.getText());
				
				Double rendimento = (0.00002 * dias);
				Double valorRendido = valor * rendimento;
				Double rendTotal = valor + valorRendido;
				
				JOptionPane.showConfirmDialog(btnNewButton_1, "Seus R$ "+valor+" renderiam R$ "+valorRendido+". Ao final de "+dias+
						" dias, você terá um total de R$ "+rendTotal+". Deseja realizar aplicação?");
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(202, 301, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Simulador de rendimentos");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		lblNewLabel_1.setBounds(58, 22, 379, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaPoupanca cp = (ContaPoupanca)c1;
				dispose();
				JContaPoupanca jConPou = new JContaPoupanca(c, cp, 0.00002);
				jConPou.setLocationRelativeTo(jConPou);
				jConPou.setVisible(true);
			}
		});
		btnNewButton.setBounds(202, 349, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/logo.png"));
		lblNewLabel_4.setBounds(418, 373, 56, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Insira o valor que pretende aplicar: R$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(37, 102, 234, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Por quantos dias pretende");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(37, 150, 168, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(" manter a aplicação?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(47, 168, 128, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(263, 96, 86, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 150, 86, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("A Poupança tem o rendimento mensal de 0,6%");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(37, 214, 276, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, 0, 484, 447);
		contentPane.add(lblNewLabel);
	}
}
