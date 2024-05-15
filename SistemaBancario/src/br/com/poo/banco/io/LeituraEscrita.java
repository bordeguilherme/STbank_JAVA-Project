package br.com.poo.banco.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.poo.Enums.ContaEnum;
import br.com.poo.Enums.PessoaEnum;
import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Funcionario;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Presidente;

public class LeituraEscrita {
	
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	static int contador = 0;
	
	
	//criando método leitor do banco.txt
	public static void leitor(String path) throws IOException
	{
		
			BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path+EXTENSAO));
			
			String linha = "";
			while(true)
			{
				linha = buffRead.readLine();
				if(linha != null)
					
				{
					contador ++;
					String[] dados = linha.split(";");
					
										
					if(dados[0].equalsIgnoreCase(ContaEnum.POUPANÇA.name())) 
					{
						ContaPoupanca cp = new ContaPoupanca(dados[0], dados[1], dados[2], dados[3], dados[4], Double.parseDouble(dados[5]));
						//na primeira coluna, fica o identificador unico. Nesse caso, cpf.
						Conta.mapaContas.put(dados[3], cp);
						System.out.println(cp);
					}
					
					else if(dados[0].equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) 
					{ 
						ContaCorrente cc = new ContaCorrente(dados[0], dados[1], dados[2], dados[3], dados[4], Double.parseDouble(dados[5]),Double.parseDouble(dados[6]));
						Conta.mapaContas.put(dados[3], cc);
					}
					
					else if(dados[0].equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())) 
					{ 
						Cliente c = new Cliente(dados[0], dados[1], dados[2], dados[3]);
						Cliente.mapaClientes.put(dados[2], c);
					}
					
					else if(dados[0].equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) 
					{
						//String cargo, String nome, String cpf, String email, String senha, Double salario,String agencia
						Gerente g = new Gerente(dados[0], dados[1], dados[2], dados[3], dados[4], Double.parseDouble(dados[5]), dados[6]);
						Funcionario.mapaFuncionario.put(dados[2], g);
					}
					
					else if(dados[0].equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) 
					{
						Diretor d = new Diretor (dados[0], dados[1], dados[2], dados[3], Double.parseDouble(dados[4]), dados[5]);
						Funcionario.mapaFuncionario.put(dados[2], d);
					}
					
					else if(dados[0].equalsIgnoreCase(PessoaEnum.PRESIDENTE.getTipoPessoa())) 
					{
						Presidente p = new Presidente(dados[0], dados[1], dados[2], dados[3], Double.parseDouble(dados[4]), dados[5]);
						Funcionario.mapaFuncionario.put(dados[2], p);
					}
				}
				else
				{
					break;
				}

			}
			buffRead.close();
			//System.out.println(Conta.mapaContas);
	}
	
	//criando método escritor no banco.txt
//	public static void escritor(String path) throws IOException
//	{
//		String escreve;
//		Scanner sc = new Scanner(System.in);
//		
//		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(PATH_BASICO+path+EXTENSAO, true));
//		
//		//o ",true" verifica se tem algo escrito e escreve depois
//		
//		System.out.println("Escreva algo: ");
//		escreve = sc.nextLine();
//		buffWriter.append(escreve+"\n");
//		
//		sc.close();
//		buffWriter.close();
//
//	}
	
	public static void escritor(String path, String cliente, String conta) throws IOException {

        try (BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path+EXTENSAO))) {
            String dado = "";
            for(int i = 0; i < contador+1; i++) {
                dado = buffRead.readLine();
                if(dado == null) {
                    try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(PATH_BASICO+path+EXTENSAO,true))) {
                        buffWriter.append(cliente);
                        buffWriter.append(conta);
                    }
                }
            }
        } 
    }
	// Método Comprovante de Saque com tarifa
	 
	public static void comprovanteSaque(Conta conta, Double valor) throws IOException {
		String path = conta.getTipo() + "_" + conta.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		
		//biblioteca para data e hora
				LocalDateTime dataHora = LocalDateTime.now();
				//formatação do padrão da data
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


		buffWrite.append("-------------- SAQUE --------------\n");
		buffWrite.append("CPF: "+conta.getCpf()+"\n");
		buffWrite.append("Conta: "+conta.getContaId()+"\n");
		buffWrite.append("Valor do saque: R$ "+valor+"\n");
		buffWrite.append("Valor da tarifa: R$ 0,10.\n");
		buffWrite.append("Operação realizada em "+dtf.format(dataHora)+"\n");
		buffWrite.append("------------ FIM SAQUE ------------\n\n");
		
		buffWrite.close();
	}
	
	// Método Comprovante de Saque sem tarifa
	 
	public static void comprovanteSaqPou(Conta conta, Double valor) throws IOException {
		String path = conta.getTipo() + "_" + conta.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		
		//biblioteca para data e hora
				LocalDateTime dataHora = LocalDateTime.now();
				//formatação do padrão da data
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


		buffWrite.append("-------------- SAQUE --------------\n");
		buffWrite.append("CPF: "+conta.getCpf()+"\n");
		buffWrite.append("Conta: "+conta.getContaId()+"\n");
		buffWrite.append("Valor do saque: R$ "+valor+"\n");
		buffWrite.append("Operação realizada em "+dtf.format(dataHora)+"\n");
		buffWrite.append("------------ FIM SAQUE ------------\n\n");
		
		buffWrite.close();
	}
	
	// Método Comprovante de Depósito sem tarifa
	 
	public static void comprovanteDepPou(Conta conta, Double valor) throws IOException {
		String path = conta.getTipo() + "_" + conta.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		
		//biblioteca para data e hora
				LocalDateTime dataHora = LocalDateTime.now();
				//formatação do padrão da data
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


		buffWrite.append("-------------- DEPÓSITO --------------\n");
		buffWrite.append("CPF: "+conta.getCpf()+"\n");
		buffWrite.append("Conta: "+conta.getContaId()+"\n");
		buffWrite.append("Valor do depósito: R$ "+valor+"\n");
		buffWrite.append("Operação realizada em "+dtf.format(dataHora)+"\n");
		buffWrite.append("------------ FIM DEPÓSITO ------------\n\n");
		
		buffWrite.close();
	}
	
	// Método Comprovante de Depósito com tarifa
	 
	public static void comprovanteDepCor(Conta conta, Double valor) throws IOException {
		String path = conta.getTipo() + "_" + conta.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		
		//biblioteca para data e hora
				LocalDateTime dataHora = LocalDateTime.now();
				//formatação do padrão da data
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


		buffWrite.append("-------------- DEPÓSITO --------------\n");
		buffWrite.append("CPF: "+conta.getCpf()+"\n");
		buffWrite.append("Conta: "+conta.getContaId()+"\n");
		buffWrite.append("Valor do depósito: R$ "+valor+"\n");
		buffWrite.append("Valor da tarifa: R$ 0,10.\n");
		buffWrite.append("Operação realizada em "+dtf.format(dataHora)+"\n");
		buffWrite.append("------------ FIM DEPÓSITO ------------\n\n");
		
		buffWrite.close();
	}
	
	// Método Comprovante de Depósito com tarifa
	 
	public static void comprovanteTransf(Conta remetente, Conta destino, Double valor) throws IOException {
		String path = remetente.getTipo() + "_" + remetente.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		
		//biblioteca para data e hora
				LocalDateTime dataHora = LocalDateTime.now();
				//formatação do padrão da data
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


		buffWrite.append("-------------- TRANSFERÊNCIA --------------\n");
		buffWrite.append("CPF: "+remetente.getCpf()+"\n");
		buffWrite.append("Conta: "+remetente.getContaId()+"\n");
		buffWrite.append("Valor da transferência: R$ "+valor+"\n");
		buffWrite.append("Valor da tarifa: R$ 0,20.\n");
		buffWrite.append("CPF do destinatário: "+destino.getCpf()+"\n");
		buffWrite.append("Conta do destinatário: "+destino.getContaId()+"\n");
		buffWrite.append("Operação realizada em "+dtf.format(dataHora)+"\n");
		buffWrite.append("------------ FIM TRANSFERÊNCIA ------------\n\n");
		
		buffWrite.close();
	}

}

