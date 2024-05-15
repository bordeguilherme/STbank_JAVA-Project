package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.pessoas.Cliente;

public class JSaque extends JFrame {
//Mensagem de saldo na tela 
	// tela de aviso: saque efetuado com sucesso ou não e por que?
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JSaque(ContaCorrente c1, Cliente c) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				JContaCorrente JConCor = new JContaCorrente(c, c1, 500.0);
				JConCor.setLocationRelativeTo(JConCor);
				JConCor.setVisible(true);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(319, 309, 113, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Double valor = Double.parseDouble(textField.getText());
				c1.sacar(valor);
				try {
					LeituraEscrita.comprovanteSaque(c1, valor);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(btnNewButton, "Saque realizado com sucesso.");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(136, 309, 113, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Saque Conta Corrente");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		lblNewLabel_1.setBounds(148, 11, 371, 40);
		contentPane.add(lblNewLabel_1);

		JButton buttonSim = new JButton("Sim");
		buttonSim.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonSim.setBounds(301, 218, 69, 23);
		contentPane.add(buttonSim);

		JLabel lmpComp = new JLabel("Deseja imprimir o comprovante de");
		lmpComp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lmpComp.setBounds(85, 213, 212, 14);
		contentPane.add(lmpComp);

		JLabel ImpComprov = new JLabel("saque ao finalizar a transação?");
		ImpComprov.setFont(new Font("Tahoma", Font.BOLD, 11));
		ImpComprov.setBounds(85, 227, 212, 14);
		contentPane.add(ImpComprov);

		JLabel TarifaSaque = new JLabel("Tarifa para Saque em Conta Corrente: R$0,10 por saque.");
		TarifaSaque.setFont(new Font("Tahoma", Font.BOLD, 11));
		TarifaSaque.setForeground(new Color(255, 0, 0));
		TarifaSaque.setBounds(85, 160, 420, 14);
		contentPane.add(TarifaSaque);

		JLabel lblNewLabel_3 = new JLabel("Valor do saque:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(85, 119, 97, 14);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(184, 113, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Seu saldo: R$ " + c1.getSaldo());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(85, 88, 150, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, -28, 625, 452);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/logo.png"));
		lblNewLabel_4.setBounds(538, 365, 69, 59);
		contentPane.add(lblNewLabel_4);
	}
}
