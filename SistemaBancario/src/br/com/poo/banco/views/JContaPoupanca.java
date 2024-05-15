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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.pessoas.Cliente;

public class JContaPoupanca extends JFrame {

	private JPanel JContaPoupanca;

	/**
	 * Launch the application.
	 */
//	

	/**
	 * Create the frame.
	 */
	public JContaPoupanca(Cliente c ,ContaPoupanca cp,Double rendimento) {
		setTitle("STBank");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 467);
		JContaPoupanca = new JPanel();
		JContaPoupanca.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(JContaPoupanca);
		JContaPoupanca.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("./imagens/logo.png"));
		Logo.setBounds(418, 373, 56, 47);
		JContaPoupanca.add(Logo);
		
		JLabel textNumContaPoupanca = new JLabel("Número da Conta : " + cp.getContaId());
		textNumContaPoupanca.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNumContaPoupanca.setBounds(20, 146, 177, 14);
		JContaPoupanca.add(textNumContaPoupanca);
		
		JLabel textContaPoupanca = new JLabel("Conta Poupanca");
		textContaPoupanca.setForeground(new Color(0, 0, 128));
		textContaPoupanca.setFont(new Font("Bauhaus 93", Font.BOLD, 31));
		textContaPoupanca.setBounds(101, 11, 255, 46);
		JContaPoupanca.add(textContaPoupanca);
		
		JButton buttonExtrato = new JButton("Imprimir Extrato");
		buttonExtrato.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonExtrato.setBounds(31, 263, 132, 23);
		JContaPoupanca.add(buttonExtrato);
		
		JButton ButtonRendimentos = new JButton("Rendimentos " + cp.getRendimento());
		ButtonRendimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JRend jR = new JRend (c, cp);
				jR.setLocationRelativeTo(jR);
				jR.setVisible(true);
				
			}
		});
		ButtonRendimentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonRendimentos.setBounds(224, 299, 121, 23);
		JContaPoupanca.add(ButtonRendimentos);
		
		JButton ButtonDeposito = new JButton("Depósito ");
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JDepPoup jDP = new JDepPoup(c, cp);
				jDP.setLocationRelativeTo(jDP);
				jDP.setVisible(true);
			}
		});
		ButtonDeposito.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonDeposito.setBounds(224, 263, 121, 23);
		JContaPoupanca.add(ButtonDeposito);
		
		JButton ButtonSaque = new JButton("Saque ");
		ButtonSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JSaqPou jS = new JSaqPou(c, cp, rendimento);
				jS.setLocationRelativeTo(jS);
				jS.setVisible(true);
				
			}
		});
		ButtonSaque.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonSaque.setBounds(31, 299, 132, 23);
		JContaPoupanca.add(ButtonSaque);
		
		JLabel textSaldoCp = new JLabel("Saldo : R$ " + cp.getSaldo());
		textSaldoCp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textSaldoCp.setBounds(20, 197, 177, 14);
		JContaPoupanca.add(textSaldoCp);
		
		JLabel textNumeroAgenciaCp = new JLabel("Agência : " + cp.getAgencia());
		textNumeroAgenciaCp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNumeroAgenciaCp.setBounds(20, 167, 154, 14);
		JContaPoupanca.add(textNumeroAgenciaCp);
		
		JLabel textContaPoupanca1 = new JLabel("Seja Bem-vindo(a): " + c.getNome());
		textContaPoupanca1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textContaPoupanca1.setBounds(10, 95, 316, 14);
		JContaPoupanca.add(textContaPoupanca1);
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		Fundo.setBounds(0, 0, 615, 432);
		JContaPoupanca.add(Fundo);
	}
}