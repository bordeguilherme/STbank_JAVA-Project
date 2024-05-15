package br.com.poo.banco.contas;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.poo.banco.contas.Conta;

public abstract class Conta {

	private String tipo;
	private String contaId;
	private String agencia;
	private String cpf;
	private String senha;
	private Double saldo;

	private static Logger logger = Logger.getLogger(Conta.class.getName());
	
	//definição do mapa
		public static Map<String, Conta> mapaContas = new HashMap<>();

	// construtores

	public Conta() {

	}

	public Conta(String tipo, String contaId, String agencia, String cpf, String senha, Double saldo) {
		this.tipo = tipo;
		this.contaId = contaId;
		this.agencia = agencia;
		this.saldo = saldo;
		this.cpf = cpf;
		this.senha = senha;
	}

	// método Login
	public Boolean logIn(String cpf, String senha) {

		if (this.cpf.equals(cpf) && this.senha.equals(senha)) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
			return false;
		}
	}

	// método de saque
	public boolean sacar(double valor) {
		if (this.saldo < valor) {
			System.out.println("Saldo Insuficiente!");
			return false;
		} else if (valor <= 0.0) {
			System.out.println("Valor inválido!");
			return false;
		} else {
			this.saldo -= valor;
			System.out.println("Saque de R$ " + valor + "realizado com sucesso.\n Saldo atual de R$ " + saldo);
			return true;
		}
	}
	
	// método verificador de saldo
	
	public double verificaSaldo()
	{
		return this.saldo;
	}

	// gets e sets

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getContaId() {
		return contaId;
	}

	public String getAgencia() {
		return agencia;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	// informações da conta

	public static Logger getLogger() {
		return logger;
	}

	public String getTipo() {
		return tipo;
	}

	public String toString() {
		return "Número da conta: " + contaId + ".\nAgência: " + agencia + ".";
	}

	// logger para exibir infos no sistema interno

	public String informa() {
		logger.log(Level.INFO, "Número da conta: {0}.\nAgência: {1}.\nCPF: {2}.",
				new Object[] {contaId, agencia, cpf});
		return contaId;
	}

}