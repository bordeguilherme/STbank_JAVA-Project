package br.com.poo.banco.views;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.poo.Enums.ContaEnum;
import br.com.poo.Enums.PessoaEnum;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.contas.*;
import br.com.poo.banco.io.LeituraEscrita;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldEmail;
	private JTextField textFieldAg;
	private JPasswordField passwordFieldGer;
	private JPasswordField passwordFieldCSenha;
	private JTextField textFieldNconta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeituraEscrita.leitor("banco");
					JGerente frame = new JGerente();
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
	public JGerente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/logo.png"));
		setTitle("STBank");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNconta = new JTextField();
		textFieldNconta.setColumns(10);
		textFieldNconta.setBounds(297, 208, 126, 20);
		contentPane.add(textFieldNconta);

		JLabel textNconta = new JLabel("Número da Conta:");
		textNconta.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNconta.setBounds(192, 211, 141, 14);
		contentPane.add(textNconta);

		JLabel lblNewLabelSenha = new JLabel("Senha:");
		lblNewLabelSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelSenha.setBounds(10, 242, 46, 14);
		contentPane.add(lblNewLabelSenha);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("imagens/logo.png"));
		Logo.setBounds(418, 373, 56, 47);
		contentPane.add(Logo);

		JComboBox<String> comboBoxTipoConta = new JComboBox<>();
		List<ContaEnum> tipoConta = Arrays.asList(ContaEnum.values());
		comboBoxTipoConta.addItem("Selecione um tipo:");

		for (ContaEnum ce : tipoConta) {
			comboBoxTipoConta.addItem(ce.getTipoConta());
		}
		comboBoxTipoConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxTipoConta.setBounds(100, 175, 228, 22);
		contentPane.add(comboBoxTipoConta);

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
		ButtonVoltar.setBounds(250, 328, 116, 23);
		contentPane.add(ButtonVoltar);

		JButton FinalizarCadastro = new JButton("Finalizar Cadastro");
		FinalizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String cpf = textFieldCpf.getText();
				String email = textFieldEmail.getText();
				String tipoConta = comboBoxTipoConta.getSelectedItem().toString();
				String agencia = textFieldAg.getText();
				String senha = new String(passwordFieldGer.getPassword());
				String confSenha = new String(passwordFieldCSenha.getPassword());
				Double saldo = 0.00;
				Double rendimento = 0.00;
				String contaId = textFieldNconta.getText();
				Double chequeEspecial = 0.00;

				if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || agencia.isEmpty() || senha.isEmpty()
						|| confSenha.isEmpty()) {
					JOptionPane.showMessageDialog(FinalizarCadastro, "Preencha todos os campos. ");
				} else if (!senha.equals(confSenha)) {
					JOptionPane.showMessageDialog(FinalizarCadastro, " As senha não coincidem");
				} else {
					Cliente c = new Cliente(PessoaEnum.CLIENTE.getTipoPessoa(), nome, cpf, email);
					Cliente.mapaClientes.put(cpf, c);
					Conta c1 = new ContaCorrente(ContaEnum.CORRENTE.getTipoConta(), contaId, agencia, cpf, senha, saldo,
							chequeEspecial);
					Conta.mapaContas.put(cpf, c1);
					Conta c2 = new ContaPoupanca(ContaEnum.POUPANÇA.getTipoConta(), contaId, agencia, cpf, senha,
							saldo);
					Conta.mapaContas.put(cpf, c2);
					String cliente = "\n" + PessoaEnum.CLIENTE.getTipoPessoa() + ";" + nome + ";" + cpf + ";" + email;
					String conta = null;

					if (c1.getTipo().equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
						ContaCorrente cc = new ContaCorrente(tipoConta, contaId, agencia, cpf, senha, saldo,
								chequeEspecial);
						conta = "\n" + ContaEnum.CORRENTE.getTipoConta() + ";" + contaId + ";" + agencia + ";" + cpf
								+ ";" + senha + ";" + saldo + ";" + chequeEspecial;
					} else if (c2.getTipo().equalsIgnoreCase(ContaEnum.POUPANÇA.getTipoConta())) {
						ContaPoupanca cp = new ContaPoupanca(tipoConta, contaId, agencia, cpf, senha, saldo);
						conta = "\n" + ContaEnum.POUPANÇA.getTipoConta() + ";" + contaId + ";" + agencia + ";" + cpf
								+ ";" + senha + ";" + saldo;
					}
					JOptionPane.showMessageDialog(FinalizarCadastro, "Cadastro realizado com sucesso!");
					dispose();
					JGerente jGer = new JGerente();
					jGer.setLocationRelativeTo(jGer);
					jGer.setVisible(true);
					
					try {
						LeituraEscrita.escritor("banco", cliente, conta);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		FinalizarCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		FinalizarCadastro.setBounds(53, 328, 162, 23);
		contentPane.add(FinalizarCadastro);

		passwordFieldCSenha = new JPasswordField();
		passwordFieldCSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordFieldCSenha.setBounds(343, 239, 116, 20);
		contentPane.add(passwordFieldCSenha);

		JLabel lblNewLabelCSenha = new JLabel("Confirme sua senha:");
		lblNewLabelCSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelCSenha.setBounds(217, 242, 116, 14);
		contentPane.add(lblNewLabelCSenha);

		passwordFieldGer = new JPasswordField();
		passwordFieldGer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordFieldGer.setBounds(53, 239, 116, 20);
		contentPane.add(passwordFieldGer);

		textFieldAg = new JTextField();
		textFieldAg.setBounds(64, 208, 105, 20);
		contentPane.add(textFieldAg);
		textFieldAg.setColumns(10);

		JLabel lblNewLabelAg = new JLabel("Agência:");
		lblNewLabelAg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelAg.setBounds(10, 211, 57, 14);
		contentPane.add(lblNewLabelAg);

		JLabel lblNewLabelEmail = new JLabel("Email:");
		lblNewLabelEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelEmail.setBounds(10, 140, 46, 14);
		contentPane.add(lblNewLabelEmail);

		JLabel textCpf = new JLabel("CPF:");
		textCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCpf.setBounds(10, 104, 34, 14);
		contentPane.add(textCpf);

		JLabel lblNewLabel_1 = new JLabel("Gerente");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		lblNewLabel_1.setBounds(178, 11, 126, 31);
		contentPane.add(lblNewLabel_1);

		JLabel textNome = new JLabel("Nome:");
		textNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNome.setBounds(10, 76, 46, 14);
		contentPane.add(textNome);

		JLabel lblNewLabelTipodeConta = new JLabel("Tipo de Conta:");
		lblNewLabelTipodeConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelTipodeConta.setBounds(10, 179, 80, 14);
		contentPane.add(lblNewLabelTipodeConta);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(53, 137, 251, 20);
		contentPane.add(textFieldEmail);

		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");

			textFieldCpf = new JFormattedTextField(mascaraCpf);
			textFieldCpf.setColumns(10);
			textFieldCpf.setBounds(53, 101, 251, 20);
			contentPane.add(textFieldCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textFieldNome = new JTextField();
		textFieldNome.setBounds(53, 73, 251, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/imagemFundo.jpeg"));
		lblNewLabel.setBounds(0, 0, 501, 432);
		contentPane.add(lblNewLabel);
	}
}
