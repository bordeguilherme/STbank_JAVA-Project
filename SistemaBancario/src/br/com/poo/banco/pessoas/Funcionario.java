package br.com.poo.banco.pessoas;

import java.util.HashMap;
import java.util.Map;

public abstract class Funcionario  {

	protected String nome;
	private String cpf;
	private String email;
	private String cargo;
	private Double salario;
	private String senha;
	
	//criando o mapafuncionario
		public static Map<String, Funcionario> mapaFuncionario = new HashMap<>();
	
	//construtor
	public Funcionario() {
		
	}
	public Funcionario(String cargo, String nome, String cpf, String email, String senha, Double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
		this.senha = senha;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	public Double getSalario() {
		return salario;
	}
	public String getSenha() {
		return senha;
	}
	
	
	public void setCargo(String cargo) {
		if (this.cargo == "presidente") {
			this.cargo = cargo;			
		}
		
	}
}