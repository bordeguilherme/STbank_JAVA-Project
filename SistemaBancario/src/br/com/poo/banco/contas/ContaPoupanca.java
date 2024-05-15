package br.com.poo.banco.contas;
import java.util.HashMap;
import java.util.Map;

import br.com.poo.banco.pessoas.Cliente;

//definindo atributos da classe.

public class ContaPoupanca extends Conta {
	
	private Double rendimento;

	//definição do mapa
		public static Map<String, ContaPoupanca> mapaContaPoupanca = new HashMap<>();
// construtores
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String tipo, String contaId, String agencia, String cpf, String senha, Double saldo) {
		super(tipo, contaId, agencia, cpf, senha, saldo);
	}
	
	public Double getSaldoPoupanca() {
		return getSaldo();
	}
	//get do rendimento
	public Double getRendimento() {
		return rendimento;
	}
	
	// método saque sem tarifa

    public boolean sacar(double valor) {
        if (this.getSaldo() < valor) {
            System.out.println("Saldo Insuficiente!");
            return false;
        } else if (valor <= 0.0) {
            System.out.println("Valor inválido!");
            return false;
        } else {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
            System.out.println("Saque de R$ " + valor + "realizado com sucesso.\n Saldo atual de R$ " + getSaldo());
            return true;
        }
    }
 // método depósito sem tarifa

    public void depositar(double valor)
    {
        double novoSaldo = this.getSaldo() + valor;
        this.setSaldo(novoSaldo);
        System.out.println("Foi realizado um depósito de R$ "+valor+".");
    }
	
	// método rendimento por dias
	// rende 0,02% ao dia
	
		public void gerarRend(double valor, int dias) {
			double rendimento = (0.00002 * dias);
			
			//de onde vem o valor e os dias
			//criar um scanner para ler valor e dias
			
			double valorRendido = valor * rendimento;
			double saldoAtualizado = valor + valorRendido;
			
		}
	
	// informações da conta
	
}