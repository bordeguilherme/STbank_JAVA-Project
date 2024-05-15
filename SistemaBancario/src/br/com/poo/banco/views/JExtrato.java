package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.pessoas.Cliente;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class JExtrato extends JFrame {

	private JPanel contentPane;
	private int contador = 0;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public JExtrato(Cliente c, Conta c1, Double chequeEspecial) throws IOException {
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
				
				ContaCorrente cc = (ContaCorrente)c1;
				dispose();
				JContaCorrente JConCor = new JContaCorrente(c, cc, chequeEspecial);
				JConCor.setLocationRelativeTo(JConCor);
				JConCor.setVisible(true);
			}
		});
		

		
		// permissão da leitura do arquivo
		String path = "";
		if(c1.getTipo().equalsIgnoreCase("CORRENTE")) {
			path = path.concat("Corrente_" + c1.getCpf());
		}else {
			path = path.concat("Poupanca_" + c1.getCpf());
		}

		BufferedReader buffRead = new BufferedReader(new FileReader("./temp/" + path + ".txt"));
		// definir uma variavel string
		String linha = "";
		String text = "";

		// faço um enquanto para ler
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				contador++;
				text = text.concat(linha + "\n");
			}else {
				break;
			}
		}
		// fechar o buff
		buffRead.close();
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(392, 74, 17, 287);
		contentPane.add(scrollBar);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 74, 337, 287);
		contentPane.add(textArea);
		textArea.append(text);
		btnNewButton_1.setBounds(193, 385, 89, 23);
		contentPane.add(btnNewButton_1);

		
		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/logo.png"));
		lblNewLabel_4.setBounds(418, 373, 56, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel Transf = new JLabel("Extrato");
		Transf.setForeground(new Color(0, 0, 128));
		Transf.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		Transf.setBounds(182, 11, 117, 39);
		contentPane.add(Transf);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(-10, 0, 484, 428);
		contentPane.add(lblNewLabel);
		

	}
}
