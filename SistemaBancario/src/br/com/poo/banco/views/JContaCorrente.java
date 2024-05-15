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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.pessoas.Cliente;

public class JContaCorrente extends JFrame {
//Linkar as telas de: saque, deposito e transferencia
	private JPanel telaContaCorrente;

	/**
	 * Launch the application.
	 */
	
	public JContaCorrente(Cliente c, ContaCorrente c1, Double chequeEspecial) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		telaContaCorrente = new JPanel();
		telaContaCorrente.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(telaContaCorrente);
		telaContaCorrente.setLayout(null);
		
		JButton ButtonImpExt = new JButton("Imprimir Extrato");
		ButtonImpExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				try {
					JExtrato jExt = new JExtrato(c, c1, chequeEspecial);
				jExt.setLocationRelativeTo(jExt);
				jExt.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		ButtonImpExt.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonImpExt.setBounds(77, 301, 127, 23);
		telaContaCorrente.add(ButtonImpExt);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JSaque jS = new JSaque (c1, c);
				jS.setLocationRelativeTo(jS);
				jS.setVisible(true);
			}
		});
		btnSaque.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaque.setBounds(77, 335, 127, 23);
		telaContaCorrente.add(btnSaque);
		
		JLabel textChequeEspecial = new JLabel("Limite Cheque Especial: R$ " + chequeEspecial);
		textChequeEspecial.setFont(new Font("Tahoma", Font.BOLD, 11));
		textChequeEspecial.setBounds(32, 230, 224, 14);
		telaContaCorrente.add(textChequeEspecial);
		
		JLabel textContaCorrente = new JLabel("Conta Corrente");
		textContaCorrente.setForeground(new Color(0, 0, 128));
		textContaCorrente.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		textContaCorrente.setBounds(114, 21, 276, 37);
		telaContaCorrente.add(textContaCorrente);
		
		JLabel TextCC = new JLabel("Seja Bem-Vindo(a) : " + c.getNome());
		TextCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		TextCC.setBounds(32, 82, 311, 14);
		telaContaCorrente.add(TextCC);
		
		JButton btnNewButton_1 = new JButton("Depósito");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JDepCor jD = new JDepCor(c, c1);
				jD.setLocationRelativeTo(jD);
				jD.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(277, 301, 111, 23);
		telaContaCorrente.add(btnNewButton_1);
		
		JLabel textAgencia = new JLabel("Agencia: " + c1.getAgencia());
		textAgencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAgencia.setBounds(32, 154, 141, 14);
		telaContaCorrente.add(textAgencia);
		
		JButton btnNewButton_2 = new JButton("Transferencia");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JTransferencia jT = new JTransferencia(c, c1);
				jT.setLocationRelativeTo(jT);
				jT.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(277, 335, 111, 23);
		telaContaCorrente.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo: R$ " + c1.getSaldo());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(32, 192, 119, 14);
		telaContaCorrente.add(lblNewLabel_2);
		
		JLabel textNumeroCc = new JLabel("Número Conta Corrente: "+c1.getContaId());
		textNumeroCc.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNumeroCc.setBounds(32, 118, 260, 25);
		telaContaCorrente.add(textNumeroCc);
		
		JLabel TextLogo = new JLabel("Logo");
		TextLogo.setIcon(new ImageIcon("./imagens/logo.png"));
		TextLogo.setBounds(418, 370, 56, 47);
		telaContaCorrente.add(TextLogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, 0, 484, 432);
		telaContaCorrente.add(lblNewLabel);
	}
}