package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class JTransferencia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldDest;
	private JTextField textFieldAg;
	private JTextField textFieldNConta;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JTransferencia(Cliente c, ContaCorrente c1) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sim");
		chckbxNewCheckBox.setBounds(266, 294, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("Tarifa para Transferência em Conta Corrente: R$0,20 por transferência.");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(18, 232, 410, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel textComprov = new JLabel("transferência ao finalizar a transação?");
		textComprov.setFont(new Font("Tahoma", Font.BOLD, 11));
		textComprov.setBounds(26, 303, 230, 14);
		contentPane.add(textComprov);
		
		JLabel textComp = new JLabel("Deseja imprimir o comprovante de");
		textComp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textComp.setBounds(26, 284, 204, 14);
		contentPane.add(textComp);
		
		JLabel textNConta = new JLabel("Número Conta: ");
		textNConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNConta.setBounds(27, 147, 113, 14);
		contentPane.add(textNConta);
		
		textFieldNConta = new JTextField();
		textFieldNConta.setColumns(10);
		textFieldNConta.setBounds(143, 147, 134, 20);
		contentPane.add(textFieldNConta);
		
		textFieldAg = new JTextField();
		textFieldAg.setColumns(10);
		textFieldAg.setBounds(143, 119, 134, 20);
		contentPane.add(textFieldAg);
		
		JLabel textAgDest = new JLabel("Agência:");
		textAgDest.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAgDest.setBounds(28, 122, 113, 14);
		contentPane.add(textAgDest);
		
		textFieldDest = new JTextField();
		textFieldDest.setBounds(141, 77, 271, 20);
		contentPane.add(textFieldDest);
		textFieldDest.setColumns(10);
		
		JLabel textDest = new JLabel("Nome destinatário:");
		textDest.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDest.setBounds(26, 80, 113, 14);
		contentPane.add(textDest);
		
		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/logo.png"));
		lblNewLabel_4.setBounds(418, 373, 56, 47);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double valor = Double.parseDouble(textField.getText());
				String remetente = c1.getContaId();
				String destino = textFieldNConta.getText();
				
				c1.transferir(c1, c1, valor);
				try {
					LeituraEscrita.comprovanteTransf(c1, c1, valor);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showConfirmDialog(btnNewButton_1, "Transferência realizada com sucesso.");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(77, 357, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JContaCorrente JConCor = new JContaCorrente(c, c1, 500.0);
				JConCor.setLocationRelativeTo(JConCor);
				JConCor.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(267, 357, 113, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(164, 188, 115, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor da Transferência:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(27, 189, 146, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel Transf = new JLabel("Transferência");
		Transf.setForeground(new Color(0, 0, 128));
		Transf.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		Transf.setBounds(142, 11, 204, 39);
		contentPane.add(Transf);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, 0, 484, 428);
		contentPane.add(lblNewLabel);
	}
}
