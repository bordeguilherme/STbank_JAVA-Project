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

import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.pessoas.Cliente;
import javax.swing.JCheckBox;

public class JDepCor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1VDep;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JDeposito frame = new JDeposito();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JDepCor(Cliente c, ContaCorrente c1) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JContaCorrente JConCor = new JContaCorrente(c, c1, 500.0);
				JConCor.setLocationRelativeTo(JConCor);
				JConCor.setVisible(true);
			}
		});
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sim");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Depósito");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		lblNewLabel_1.setBounds(169, 23, 134, 30);
		contentPane.add(lblNewLabel_1);
		chckbxNewCheckBox.setBounds(250, 219, 97, 38);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel tarifa = new JLabel("Tarifa para Depósito em Conta Corrente: R$0,10 por depósito.");
		tarifa.setForeground(new Color(255, 0, 0));
		tarifa.setFont(new Font("Tahoma", Font.BOLD, 11));
		tarifa.setBounds(34, 156, 355, 14);
		contentPane.add(tarifa);
		
		JLabel textImpComprov = new JLabel("depósito ao finalizar a transação?");
		textImpComprov.setFont(new Font("Tahoma", Font.BOLD, 11));
		textImpComprov.setBounds(34, 238, 232, 14);
		contentPane.add(textImpComprov);
		
		JLabel textImpComp = new JLabel("Deseja imprimir o comprovante de");
		textImpComp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textImpComp.setBounds(34, 219, 218, 14);
		contentPane.add(textImpComp);
		
		textField_1VDep = new JTextField();
		textField_1VDep.setColumns(10);
		textField_1VDep.setBounds(153, 100, 144, 19);
		contentPane.add(textField_1VDep);
		
		JLabel ValorDep = new JLabel("Valor para depósito:");
		ValorDep.setFont(new Font("Tahoma", Font.BOLD, 11));
		ValorDep.setBounds(34, 103, 127, 14);
		contentPane.add(ValorDep);
		btnNewButton_1.setBounds(276, 285, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor = Double.parseDouble(textField_1VDep.getText());
				c1.depositar(valor);
				try {
					LeituraEscrita.comprovanteDepCor(c1, valor);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showConfirmDialog(btnNewButton, "Depósito realizado com sucesso");
			}
		});
		btnNewButton.setBounds(94, 285, 113, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/logo.png"));
		lblNewLabel_4.setBounds(418, 373, 56, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, 0, 631, 447);
		contentPane.add(lblNewLabel);
	}
}
