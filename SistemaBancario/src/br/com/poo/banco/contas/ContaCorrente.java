package br.com.poo.banco.contas;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.banco.pessoas.Cliente;

//definindo atributos da classe.

public class ContaCorrente extends Conta {

	private Double chequeEspecial;
	
	//definição do mapa
	public static Map<String, ContaCorrente> mapaContaCorrente = new HashMap<>();

	// construtores

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String tipo, String contaId, String agencia, String cpf, String senha, Double saldo, Double chequeEspecial) {
		super(tipo, contaId, agencia, cpf, senha, saldo);
		this.chequeEspecial = chequeEspecial;

	}

	// método de cobrança de tarifa

	public void gerarTarifa() {
		double novoSaldo = this.getSaldo() - 13.90;
		this.setSaldo(novoSaldo);

	}
	
	// método saque com tarifa
	
		public boolean sacar(double valor) {
			if (this.getSaldo() < (valor+0.10)) {
				System.out.println("Saldo Insuficiente!");
				return false;
			} else if (valor <= 0.0) {
				System.out.println("Valor inválido!");
				return false;
			} else {
				double novoSaldo = this.getSaldo() - (valor+0.10);
				this.setSaldo(novoSaldo);
				System.out.println("Saque de R$ " + valor + "realizado com sucesso.\n Saldo atual de R$ " + getSaldo());
				return true;
			}
		}
		
		// método depósito com tarifa
		
		public void depositar(double valor)
		{
			double novoSaldo = this.getSaldo() + (valor-0.10);
			this.setSaldo(novoSaldo);
			System.out.println("Foi realizado um depósito de R$ "+valor+". Porém foi cobrada uma taxa de R$ 0,10");
		}
		
		
		// método transferência com tarifa
		
		public void transferir(Conta remetente, Conta destino, double valor)
		{
			if(remetente.getSaldo() >= (valor+0.20))
					{
				remetente.setSaldo(remetente.getSaldo() - (valor+0.20));
				destino.setSaldo(destino.getSaldo() + valor);
					}
			else
			{
				System.out.println("Saldo insuficiente para a transferência.");
			}
		}



	// gets e sets
		
		

	public void setChequeEspecial(Double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public Double getChequeEspecial() {
		return chequeEspecial;
	}

	// informações da conta

}
